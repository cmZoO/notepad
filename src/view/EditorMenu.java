package view;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * 编辑菜单
 * 		属性		cut, copy, paste, selectAll, addTime, search		菜单中的菜单项
 * 				resourceMgmt										公有资源接口
 * 		方法		public void EditorMenuInit()
 * @author zx583
 *
 */
public class EditorMenu extends NMenu {
	//ActionComment常量
	public static final String ActionCommand_cut = "cut";
	public static final String ActionCommand_copy = "copy";
	public static final String ActionCommand_paste = "paste";
	public static final String ACtionCommand_redo = "redo";
	public static final String ACtionCommand_undo = "undo";
	public static final String ActionCommand_selectAll = "selectAll";
	public static final String ActionCommand_addTime = "addTime";
	public static final String ActionCommand_search = "search";
	
	private JMenuItem cut, copy, paste,undo, redo, selectAll, addTime, search;
	private ResourceMgmt resourceMgmt;
	
	public EditorMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt); 
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	/**
	 * 初始化菜单界面
	 * 		为编辑菜单添加菜单项
	 */
	/**
	 * @param resourceMgmt
	 */
	public void EditorMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		
		// 实例化一个菜单项
		cut = new JMenuItem("剪切");
		// 为该菜单项设置ActionCommet值
		cut.setActionCommand(ActionCommand_cut);
		//设置快捷键
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

		copy = new JMenuItem("复制");
		copy.setActionCommand(ActionCommand_copy);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));

		paste = new JMenuItem("粘贴");
		paste.setActionCommand(ActionCommand_paste);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));

		undo = new JMenuItem("撤销");
		undo.setActionCommand(ACtionCommand_undo);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));

		redo = new JMenuItem("重做");
		redo.setActionCommand(ACtionCommand_redo);
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));

		selectAll = new JMenuItem("全选");
		selectAll.setActionCommand(ActionCommand_selectAll);
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));

		addTime = new JMenuItem("时间/日期");
		addTime.setActionCommand(ActionCommand_addTime);

		search = new JMenuItem("查找");
		search.setActionCommand(ActionCommand_search);
		search.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		
		//将该菜单,撤销项目,重做项目,查找加入公有资源中
		resourceMgmt.setAResource("EditorMenu_editorMenu", this);
		resourceMgmt.setAResource("JMenuItem_undo", undo);
		resourceMgmt.setAResource("JMenuItem_redo", redo);
		resourceMgmt.setAResource("JMenuItem_search", search);
		
		//将菜单项加入到菜单中
		add(cut);
		add(copy);
		add(paste);
		add(undo);
		add(redo);
		addSeparator();
		add(selectAll);
		add(addTime);
		add(search);
		
		//设置Item项目字体大小
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
}
