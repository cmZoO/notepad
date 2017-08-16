package bean;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import inter.JMenuItemMgmtInter;
import inter.ResourceMgmt;


/**
 * 自定义的JMenu
 * 		增加属性 
 * 			resourceMgmt  	上级资源对象
 * 			menuJMenuItems		菜单下的菜单项JMenuItem
 * 增加方法
 * 		各属性的getter和setter方法
 * 		private void NMenuInit(ResourceMgmt resourceMgmt)
 *
 * 重写
 * 		public void remove(JMenuItem item)
 * 		public JMenuItem add(JMenuItem menuItem)
 * 		public void addActionListener(ActionListener listener)
 * @author zx583
 *
 */
public class NMenu extends JMenu implements JMenuItemMgmtInter {
	private ResourceMgmt resourceMgmt;
	private ArrayList<JMenuItem> menuJMenuItems;
	
	public NMenu(ResourceMgmt resourceMgmt) {
		super();
	
		NMenuInit(resourceMgmt);
	}

	public NMenu(String s, ResourceMgmt resourceMgmt) {
		super(s);

		NMenuInit(resourceMgmt);
	}

	public NMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a);

		NMenuInit(resourceMgmt);
	}

	public NMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b);

		NMenuInit(resourceMgmt);
	}

	private void NMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		this.menuJMenuItems = new ArrayList<JMenuItem>();
	}

	/**
	 * resourceMgmt属性的getter方法
	 * @return ResourceMgmt
	 */
	public ResourceMgmt getResourceMgmt() {
		return resourceMgmt;
	}

	/**
	 * resourceMgmt的setter方法
	 * @param resourceMgmt 设置的值
	 */
	public void setResourceMgmt(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
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
	public void setMenuJMenuItems(ArrayList<JMenuItem> menuJMenuItem) {
		this.menuJMenuItems = menuJMenuItem;
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
	 * 重写public void remove(JMenuItem item)
	 * 使移除JMenuItem时将其从menuJMenuItem数组中移除
	 */
	@Override
	public void remove(JMenuItem item) {
		this.menuJMenuItems.remove(item);
		
		super.remove(item);
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
}
