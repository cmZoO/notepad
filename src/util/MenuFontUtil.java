package util;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import bean.NMenu;

/**
 * 菜单字体管理工具类
 * 		独立管理菜单字体
 * @author zx583
 *
 */
public class MenuFontUtil {
	//菜单字体
	public static final Font MenuFont = new Font("微软",Font.PLAIN,22);
	//菜单的菜单项目字体
	public static final Font MenuItemFont = new Font("微软", Font.PLAIN, 18);
	
	/**
	 * 设置菜单的项目的字体
	 * @param items	菜单项目集合
	 */
	public static void setMenuItemFont(ArrayList<JMenuItem> items) {
		for (JMenuItem item : items) {
			item.setFont(MenuItemFont);
		}
	}
	
	/**
	 * 设置菜单的字体
	 * @param menu	菜单
	 */
	public static void setMenuFont(NMenu menu) {
		menu.setFont(MenuFont);
	}
	
}
