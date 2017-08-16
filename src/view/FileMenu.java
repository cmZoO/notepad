package view;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * 文件菜单
 * 	属性		newfile, open, save				菜单中的菜单项
 * 			resourceMgmt					公有资源接口
 * 	方法		public void EditorMenuInit()
 * @author zx583
 *
 */
public class FileMenu extends NMenu {
	
	public static final String ActionCommand_newfile = "newfile";
	public static final String ActionCommand_open = "open";
	public static final String ActionCommand_save = "save";
	public static final String ActionCommand_saveas = "saveas";
	
	private JMenuItem newfile, open, save, saveas;
	ResourceMgmt resourceMgmt;
	
	public FileMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	/**
	 * 初始化菜单界面
	 * 		为文件菜单添加菜单项
	 * 实例化公有资源接口
	 */
	public void FileMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		
		//实例化一个菜单项
		newfile = new JMenuItem("新建");
		//为该菜单项设置ActionCommet值
		newfile.setActionCommand(ActionCommand_newfile);
		open = new JMenuItem("打开");
		open.setActionCommand(ActionCommand_open);
		save = new JMenuItem("保存");
		save.setActionCommand(ActionCommand_save);
		//设置保存快捷键
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveas = new JMenuItem("另存为");
		saveas.setActionCommand(ActionCommand_saveas);
		
		//将另存为加入公有资源
		resourceMgmt.setAResource("JMenuItem_saveas", saveas);
		resourceMgmt.setAResource("JMenuItem_save", save);
		
		//将菜单项加入到菜单中
		add(newfile);
		add(open);
		add(save);
		add(saveas);
		
		//设置Item项目字体大小
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
}
