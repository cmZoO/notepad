package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import bean.NFileChooser;
import bean.NTextArea;
import inter.ResourceMgmt;
import server.FileIOServer;
import server.FileServer;
import server.TextAreaMgmtServer;
import util.AlertWindows;
import util.FileServerAlert;
import util.TextAreaUtil;
import view.FileMenu;

/**
 * FileMenu的逻辑操作接口
 * 属性
 * 		jFileChooser 		NFileChoser类，用于可视化选中读/写路径
 * 		textAreaServer		文本域资源服务
 * 		fileServer 			文件服务
 * 		saveas, save		FileMenu菜单上的saveas, save项目
 * @author zx583
 *
 */
public class FileListener implements ActionListener {
	private JFileChooser jFileChooser;
	private TextAreaMgmtServer textAreaServer;
	private FileServer fileServer;
	private JMenuItem saveas, save;
	
	//下面为共用临时变量
	private NTextArea textArea;
	private int result;
	/**
	 * 初始化操作
	 * @param resourceMgmt
	 */
	public FileListener(ResourceMgmt resourceMgmt) {
		super();
		
		//实例化自定义的JFileChoser的子类FileChooser
		jFileChooser = new NFileChooser();
		
		//通过公有资源管理接口实例化fileServer,textAreaServer,save
		textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
		fileServer = (FileServer)resourceMgmt.getAResource("fileServer");
		saveas = (JMenuItem) resourceMgmt.getAResource("JMenuItem_saveas");
		save = (JMenuItem) resourceMgmt.getAResource("JMenuItem_save");
	}
	
	public void actionPerformed(ActionEvent e) {
		//得到ACtionComment
		String actionComment = e.getActionCommand();
	
		//判断ActionComment所对应的操作
		if (actionComment.equals(FileMenu.ActionCommand_newfile)) {
			//新建文本操作
			//获取当前操作文本域实例
			textArea = textAreaServer.getUsingTextArea();
			
			//判断当前文本域内是否有未保存的内容
			if (!textArea.isSaved()) {
				//存在未保存内容,弹窗警告
				if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "是否保存当前文档", 
												   "继续操作可能会导致文档丢失")) {
					//保存当前文档
					save.doClick();
					return;
				}
			} 
			
			//文本域初始化 
			fileServer.newFile(textArea);
		
		} else if (actionComment.equals(FileMenu.ActionCommand_open)) {
			//文本打开操作
			//获取当前操作文本域实例
			textArea = textAreaServer.getUsingTextArea();
			
			//判断当前文本域内是否有未保存的内容
			if (!textArea.isSaved()) {
				//存在未保存内容,弹窗警告
				if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "是否保存当前文档", 
												   "继续操作可能会导致文档丢失")) {
					//保存当前文档
					save.doClick();
					return;
				}
			} 
		
			//打开JFileChoser的文件选择器，并判断是否选择了文件
			if (jFileChooser.showOpenDialog(textArea.getFrame()) == jFileChooser.APPROVE_OPTION) {
				//选中了文件,获得对应的File实例
				File file = jFileChooser.getSelectedFile();
				
				result = fileServer.open(file, textArea);
				
				if (result != fileServer.success) {
					FileServerAlert.showErrorMessage(result, textArea.getFrame());
				}

			}
				
		} else if (actionComment.equals(FileMenu.ActionCommand_save)){
			//文本保存操作
	
			//获取当前操作文本域实例
			textArea = textAreaServer.getUsingTextArea();
			//得到关联的磁盘文件
			File file = textArea.getFile();
			//如果当前文本域没有关联磁盘文件
			if (file == null) {
				saveas.doClick();
				return;
			}
			
			result = fileServer.save(file, textArea);
			
			if (result != fileServer.success) {
				FileServerAlert.showErrorMessage(result, textArea.getFrame());
			}
			
		} else if (actionComment.equals(FileMenu.ActionCommand_saveas)) {
			//文本另存操作
			//获取当前操作文本域实例
			textArea = textAreaServer.getUsingTextArea();
			
			//另存为的文件实例
			File file = null;
			//使用goto语法进行多次读取文件路径
			rechose:for(;;) {
				//判断是否取消了操作，是则中断事件
				if (jFileChooser.showSaveDialog(textArea.getFrame()) == JFileChooser.CANCEL_OPTION) return;
				//获得所选取的文件实例
				file = jFileChooser.getSelectedFile();
				//得到当前选定的合法后缀
				String end = jFileChooser.getFileFilter().getDescription().replace("*", "");
				//判断所选是否为一个合法后缀且所选文件后缀是否与合法后缀相同
				if (end.contains(".") && !file.getName().endsWith(end)) {
					//判断所选文件是否有文件后缀
					if (file.getName().lastIndexOf('.') != -1) {
						//所选文件与合法文件后缀不同，弹窗提醒并取消事件
						AlertWindows.showMessageDialog(textArea.getFrame(), "文件后缀错误");
						return;
					}
			
					//所选文件没有后缀，自动添加文件后缀
					file = new File(file.getAbsolutePath() + end);
				}
				
				//判断该文件是否已经存在
				if (file.exists()) {
					//文件已存在，弹窗询问是否替代该文件
					if (AlertWindows.showConfirmDialog(textArea.getFrame(), "是否替换该文件", "该文件已存在")) {
						//选择了替换文件，跳出goto循环
						break rechose;
					}
				} else {
					//文件不存在，路径合法，跳出goto循环
					break rechose;
				}
			}
			
			fileServer.save(file, textArea);
		}
	}

}
