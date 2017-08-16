package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import inter.ResourceMgmt;
import server.EditorServer;
import util.TextAreaUtil;
import view.EditorMenu;

/**
 * EditorMenu的监听
 * 		实现EditorMenu的操作逻辑
 * 		实现
 * 			ActionListener, MenuListener
 * 		属性
 * 			editorMenu 		监听对应的菜单
 * 			editorServer	文本编辑服务
 * @author zx583
 *
 */
public class EditorListener implements ActionListener, MenuListener{
	private EditorMenu editorMenu;
	private EditorServer editorServer;
	/**
	 * 初始化时通过公有资源管理接口将editorMenu， editorServer实例化
	 * @param resourceMgmt		公有资源管理接口
	 */
	public EditorListener(ResourceMgmt resourceMgmt) {
		this.editorMenu = (EditorMenu) resourceMgmt.getAResource("EditorMenu_editorMenu");
		this.editorServer = (EditorServer) resourceMgmt.getAResource("editorServer");
	}
	
	//ActionCommand响应
	public void actionPerformed(ActionEvent e) {
		//得到ActionComment
		String ActionCommand = e.getActionCommand();
		
		//判断ActionComment所对应的操作
		if (ActionCommand.equals(EditorMenu.ActionCommand_cut)) {
			//点击了剪切按钮，进行剪切操作
			editorServer.cut();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_copy)) {
			//点击了复制按钮，进行复制操作
			editorServer.copy();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_paste)) {
			//点击了粘贴按钮，进行粘贴操作
			editorServer.paste();
		} else if (ActionCommand.equals(EditorMenu.ACtionCommand_undo)) {
			//点击了撤销按钮，进行撤销操作
			editorServer.undo();
		} else if (ActionCommand.equals(EditorMenu.ACtionCommand_redo)) {
			//点击了重装按钮，进行重做操作
			editorServer.redo();
		}else if (ActionCommand.equals(EditorMenu.ActionCommand_selectAll)) {
			//点击了全选按钮，进行全选操作
			editorServer.selectAll();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_addTime)) {
			//点击的日期按钮，在光标所在地方以hh:mm:ss yyyy-MM-dd格式插入时间
			editorServer.addTime();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_search)) {
			editorServer.search();
		}
	}

	/**
	 * 菜单被选中时更新按钮可用性
	 */
	public void menuSelected(MenuEvent e) {
		editorMenu.updateItemsEnable(editorServer.canCut(), 
									 editorServer.canCopy(), 
									 editorServer.canPaste(), 
								     editorServer.canUndo(), 
									 editorServer.canRedo());
	}

	/**
	 * 菜单取消选择时确保快捷键可用性
	 */
	public void menuDeselected(MenuEvent e) {
		editorMenu.updateItemsEnable(true, 
									 true, 
									 true, 
									 true, 
									 true);
	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}
