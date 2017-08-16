package bean;

import java.awt.Component;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import bean.NTextArea;
import inter.JMenuItemMgmtInter;

/**
 * 鼠标右键点击菜单
 * 	属性	
 * 		menuJMenuItems		菜单下的菜单项JMenuItem
 * 	增加方法
 * 		各属性的getter和setter方法
 * 		各接口未实现方法
 * 	实现接口
 * 		JMenuItemMgmtInter
 * @author zx583
 *
 */
public class NPopupMenu extends JPopupMenu implements JMenuItemMgmtInter{
	private ArrayList<JMenuItem> menuJMenuItems;
	
	public NPopupMenu() {
		super();
		
		NPopupMenuInit();
	}

	public NPopupMenu(String label) {
		super(label);
		
		NPopupMenuInit();
	}
	
	private void NPopupMenuInit() {
		this.menuJMenuItems = new ArrayList<JMenuItem>();
	}
	
	/**
	 * 重写public JMenuItem add(JMenuItem menuItem)
	 * 使加入JMenuItem时将其加入menuJMenuItem数组中
	 */
	@Override
	public JMenuItem add(JMenuItem menuItem) {
		
		this.menuJMenuItems.add(menuItem);
		
		return super.add(menuItem);
	}
	
	/**
	 * MenuJMenuItem的getter方法
	 * 获得该菜单下所有的菜单项目的数组
	 * @return	该菜单下所有的菜单JMenuItem项目的数组
	 */
	public ArrayList<JMenuItem> getMenuJMenuItems() {
		return menuJMenuItems;
	}

	/**
	 * MenuJMenuItem的setter方法
	*/
	public void setMenuJMenuItems(ArrayList<JMenuItem> menuJMenuItems) {
		this.menuJMenuItems = menuJMenuItems;
	}

	/**
	 * 为该Menu下属的所有MenuItem设置ActionListener
	 * @param listener
	 */
	public void addActionListener(ActionListener listener) {
		for (JMenuItem item : getMenuJMenuItems()) {
			item.addActionListener(listener);
		}
	}
	
	/**
	 * 设置Items是否可用
	 * @param values		项目可否使用的值
	 */
	public void updateItemsEnable(boolean ...values) {
		for (int i=0; i < values.length; i++) {
			getMenuJMenuItems().get(i).setEnabled(values[i]);
		}
	}

	/**
	 * 使移除JMenuItem时将其从menuJMenuItem数组中移除
	 */
	public void remove(JMenuItem item) {
		super.remove(item);
		
		if (menuJMenuItems.contains(item)) {
			menuJMenuItems.remove(item);
		}
	}
}
