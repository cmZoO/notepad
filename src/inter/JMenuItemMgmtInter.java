package inter;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public interface JMenuItemMgmtInter {
	/**
	 * 重写public JMenuItem add(JMenuItem menuItem)
	 * 使加入JMenuItem时将其加入menuJMenuItem数组中
	 */
	public JMenuItem add(JMenuItem menuItem);

	/**
	 * 重写public void remove(JMenuItem item)
	 * 使移除JMenuItem时将其从menuJMenuItem数组中移除
	 */
	public void remove(JMenuItem item);
	
	/**
	 * 为该Menu下属的所有MenuItem设置ActionListener
	 * @param listener
	 */
	public void addActionListener(ActionListener listener);

	/**
	 * 设置Items是否可用
	 * @param values		项目可否使用的值
	 */
	public void updateItemsEnable(boolean ...values);
}
