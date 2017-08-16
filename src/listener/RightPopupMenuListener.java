package listener;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import bean.NPopupMenu;
import inter.ResourceMgmt;
import server.EditorServer;
import view.RightPopupMenu;

/**
 * NPopupMenu的监听
 * 		实现NPopupMenu的操作逻辑
 * 		实现
 * 			ActionListener
 * 			PopupMenuListener
 * 		属性
 * 			editorServer	文本编辑服务
 * 			nPopupMenu	监听对应得NPopupMenu实例
 * @author zx583
 *
 */
public class RightPopupMenuListener implements ActionListener, PopupMenuListener {
	private EditorServer editorServer;
	private RightPopupMenu rightPopupMenu;
	/**
	 * 初始化时通过公有资源管理接口将textArea实例化
	 * @param resourceMgmt		公有资源管理接口
	 */
	public RightPopupMenuListener(ResourceMgmt resourceMgmt) {
		this.editorServer = (EditorServer) resourceMgmt.getAResource("editorServer");
		this.rightPopupMenu = (RightPopupMenu) resourceMgmt.getAResource("RightPopupMenu_rightPopupMenu");
	}
	
	//ActionCommand响应逻辑
	public void actionPerformed(ActionEvent e) {
		// 得到ActionComment
		String ActionCommand = e.getActionCommand();

		// 判断ActionComment所对应的操作
		if (ActionCommand.equals(RightPopupMenu.ActionCommand_cut)) {
			// 点击了剪切按钮，进行剪切操作
			editorServer.cut();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_copy)) {
			// 点击了复制按钮，进行复制操作
			editorServer.copy();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_paste)) {
			// 点击了粘贴按钮，进行粘贴操作
			editorServer.paste();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_undo)) {
			// 点击了撤销按钮，进行撤销操作
			editorServer.undo();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_selectAll)) {
			// 点击了全选按钮，进行全选操作
			editorServer.selectAll();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_addTime)) {
			// 点击的日期按钮，在光标所在地方以hh:mm:ss yyyy-MM-dd格式插入时间
			editorServer.addTime();
		} 
	}

	//菜单显示时更新其按钮可用性
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		rightPopupMenu.updateItemsEnable(editorServer.canUndo(),
									 editorServer.canCopy(), 
								 	 editorServer.canPaste(), 
									 editorServer.canCut());
	}

	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		
	}

	public void popupMenuCanceled(PopupMenuEvent e) {
		
	}



}
