package view;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.JMenuItem;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * 设置菜单
 * 	属性
 * 		resourceMgmt		公有资源接口
 * 		菜单项目				useUTF, useGBK,font
 * @author zx583
 *
 */
public class ConfigMenu extends NMenu {
	//ActionCommand值
	public static final String ActionCommand_toUTF = "useUTF";
	public static final String ActionCommand_toGBK = "useGBK";
	public static final String ActionCommand_font = "font";
	
	private ResourceMgmt resourceMgmt;
	private JMenuItem useUTF, useGBK, font, search;
	
	public ConfigMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	/**
	 * 初始化函数
	 * 		直接传参实例化公有资源接口resourceMgmt
	 * @param resourceMgmt
	 */
	public void ConfigMenuInit(ResourceMgmt resourceMgmt) {
		//实例化resourceMgmt
		this.resourceMgmt = resourceMgmt;
		
		//新建一个菜单项目
		useUTF = new JMenuItem("使用UTF编码重载");
		//设置菜单项目ActionCommand
		useUTF.setActionCommand(ActionCommand_toUTF);
		
		useGBK = new JMenuItem("使用GBK编码重载");
		useGBK.setActionCommand(ActionCommand_toGBK);
		
		font = new JMenuItem("字体");
		font.setActionCommand(ActionCommand_font);
		
		//将菜单项目加入菜单中
		add(useUTF);
		add(useGBK);
		addSeparator();
		add(font);
	
		//设置Item项目字体大小
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
	
}
