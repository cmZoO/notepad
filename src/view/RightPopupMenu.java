package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import bean.NPopupMenu;
import bean.NTextArea;
import inter.ResourceMgmt;

/**
 * 鼠标右键点击菜单
 * 	属性	
 * 		textArea 										操作的文本域对象
 * 		resourceMgmt									公有资源接口
 * 		undo, copy, paste, cut, selectAll, addTime		菜单项目
 * 	增加方法
 * 		各属性的getter和setter方法
 * 		private void NPopupMenuInit(ResourceMgmt resourceMgmt)
 *		private void initResource()
 * @author zx583
 *
 */
public class RightPopupMenu extends NPopupMenu {
	public final static String ActionCommand_undo = "undo";
	public final static String ActionCommand_copy = "copy";
	public final static String ActionCommand_paste = "paste";
	public final static String ActionCommand_cut = "cut";
	public final static String ActionCommand_selectAll = "selectAll";
	public final static String ActionCommand_addTime = "addTime";
	
	private ResourceMgmt resourceMgmt;
	private JMenuItem undo, copy, paste, cut, selectAll, addTime;
	
	public RightPopupMenu(ResourceMgmt resourceMgmt) {
		super();
		
		RightPopupMenuInit(resourceMgmt);
	}

	public RightPopupMenu(String label, ResourceMgmt resourceMgmt) {
		super(label);
		
		RightPopupMenuInit(resourceMgmt);
	}

	/**
	 * 初始化函数
	 * 	初始化布局
	 * 	实例化属性
	 * @param resourceMgmt	公有资源接口
	 */
	private void RightPopupMenuInit(ResourceMgmt resourceMgmt) {
		//实例化资源
		initResource(resourceMgmt);
		
		//为item设置ActionCommand
		undo.setActionCommand(ActionCommand_undo);
		copy.setActionCommand(ActionCommand_copy);
		paste.setActionCommand(ActionCommand_paste);
		cut.setActionCommand(ActionCommand_cut);
		selectAll.setActionCommand(ActionCommand_selectAll);
		addTime.setActionCommand(ActionCommand_addTime);
		
		//加入菜单中
		add(undo);
		addSeparator();
		add(copy);
		add(paste);
		add(cut);
		addSeparator();
		add(selectAll);
		add(addTime);
	}
	
	/**
	 * 资源初始实例化函数
	 */
	private void initResource(ResourceMgmt resourceMgmt) {
		
		//实例化公有资源接口
		this.resourceMgmt = resourceMgmt;
		
		undo = new JMenuItem("撤销");
		copy = new JMenuItem("复制");
		paste = new JMenuItem("粘贴");
		cut = new JMenuItem("剪切");
		selectAll = new JMenuItem("全选");
		addTime = new JMenuItem("时间/日期");
	}
}
