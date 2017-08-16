package view;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

import listener.ConfigListener;
import listener.EditorListener;
import listener.FileListener;
import listener.HelpListener;
import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * 菜单条界面
 * 	属性
 * 		fileMenu, editorMenu, config, help		菜单条中的菜单
 * @author zx583
 *
 */
public class NMenuBar extends JMenuBar {
	private NMenu fileMenu, editorMenu, config, help;

	/**
	 * 构造方法中对菜单条进行布局
	 * @param resourceMgmt			上文传递来的公有资源管理接口    可从中获取公有资源
	 */
	public NMenuBar(ResourceMgmt resourceMgmt) {
		super();
		
		//新建一个菜单
		fileMenu = new FileMenu("文件", resourceMgmt);
		//设置该菜单的字体
		MenuFontUtil.setMenuFont(fileMenu);
		
		
		editorMenu = new EditorMenu("编辑", resourceMgmt);
		MenuFontUtil.setMenuFont(editorMenu);
		
		config = new ConfigMenu("设置", resourceMgmt);
		MenuFontUtil.setMenuFont(config);
	
		help = new NMenu("帮助", resourceMgmt);
		MenuFontUtil.setMenuFont(help);
		
		//为该菜单添加对应的监听逻辑
		fileMenu.addActionListener(new FileListener(resourceMgmt));
		EditorListener editorListener = new EditorListener(resourceMgmt);
		editorMenu.addMenuListener(editorListener);
		editorMenu.addActionListener(editorListener);
		config.addActionListener(new ConfigListener(resourceMgmt));
		help.addMouseListener(new HelpListener(resourceMgmt));
		
		//将该菜单加到菜单条中
		add(fileMenu);
		add(editorMenu);
		add(config);
		add(help);
	}
}
