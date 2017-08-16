package listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JMenuItem;

import bean.NTextArea;
import inter.ResourceMgmt;
import util.AlertWindows;

/**
 * MainFrame框架监听逻辑
 * 	属性
 * 		resourceMgmt 		公有资源接口
 * @author zx583
 *
 */
public class MainFrameListener extends WindowAdapter {
	private ResourceMgmt resourceMgmt;
	
	/**
	 * 实例化公有资源接口resourceMgmt
	 * @param resourceMgmt		公有资源接口实例
	 */
	public MainFrameListener(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		//取出公有资源中的textArea资源
		NTextArea textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
		////判断该文本域内是否有未保存的内容
		if (!textArea.isSaved()) {
			//存在未保存内容,弹窗警告
			if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
											   "是否保存当前文档", 
											   "继续操作可能会导致文档丢失")) {
				((JMenuItem) resourceMgmt.getAResource("JMenuItem_save")).doClick();
				return;
			}
		}
		
		super.windowClosing(e);
		
		System.exit(0);
		
	}
}
