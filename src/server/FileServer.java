package server;

import java.io.File;

import javax.swing.JFileChooser;

import bean.NFileChooser;
import bean.NTextArea;
import inter.FileInter;
import inter.ResourceMgmt;
import util.TextAreaUtil;

/**
 * 文件操作服务
 * @author zx583
 *
 */
public class FileServer implements FileInter {
	public static final int success = 1;
	public static final int fileNotExists = 2;
	
	private TextAreaMgmtServer textAreaServer;
	
	public FileServer(ResourceMgmt resourceMgmt) {
		super();
		
		this.textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
	}

	//新建文件事务
	public int newFile(NTextArea textArea) {
		//没有传textArea则获取当前使用textArea为操作对象
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
		
		//文本域初始化 
		textArea.clearEdit();
	
		return success;
	}

	//打开文件事务
	public int open(File file, NTextArea textArea) {
		// 没有传textArea则获取当前使用textArea为操作对象
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
		
		//判断该文件是否存在
		if (!file.exists()) {
			//文件不存在,返回参数
			return fileNotExists;
		}
			
		//清空文本内容
		textArea.setText("");
		//将File的内容文本内容读取出来，并加入到文本域中
		TextAreaUtil.appendInitText(new FileIOServer().readCharFile(file), textArea);
		//清除文本域附属状态
		textArea.clearState();
		//设置textArea的file文件关联
		textArea.setFile(file);

		return success;
	}

	//保存文件事务
	public int save(File file, NTextArea textArea) {
		// 没有传textArea则获取当前使用textArea为操作对象
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
				
		//如果当前文本域没有关联磁盘文件
		if (file == null) {
			return fileNotExists;
		}
		
		String[] data;		//用于保存从文本域中提取出来的数据
		//取出文本域中的数据
		data = TextAreaUtil.toStringArry(textArea);
		
		if (file != null && file instanceof File) {
			//将数据写到磁盘中
			new FileIOServer().wirteCharFile(file, data, textArea.getEncoded());
			//设置文本域状态为已保存
			textArea.setSaved(true);
			//设置textArea的file文件关联
			textArea.setFile(file);
		}
		
		return success;
	}

	/**
	 * 通过路径保存文件事务
	 */
	public int save(String path, NTextArea textArea) {
		return save(new File(path), textArea);
	}

	/**
	 * 通过路径打开文件事务
	 */
	public int open(String path, NTextArea textArea) {
		return open(new File(path), textArea);
	}

}
