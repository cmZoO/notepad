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
 * ����Ҽ�����˵�
 * 	����	
 * 		menuJMenuItems		�˵��µĲ˵���JMenuItem
 * 	���ӷ���
 * 		�����Ե�getter��setter����
 * 		���ӿ�δʵ�ַ���
 * 	ʵ�ֽӿ�
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
	 * ��дpublic JMenuItem add(JMenuItem menuItem)
	 * ʹ����JMenuItemʱ�������menuJMenuItem������
	 */
	@Override
	public JMenuItem add(JMenuItem menuItem) {
		
		this.menuJMenuItems.add(menuItem);
		
		return super.add(menuItem);
	}
	
	/**
	 * MenuJMenuItem��getter����
	 * ��øò˵������еĲ˵���Ŀ������
	 * @return	�ò˵������еĲ˵�JMenuItem��Ŀ������
	 */
	public ArrayList<JMenuItem> getMenuJMenuItems() {
		return menuJMenuItems;
	}

	/**
	 * MenuJMenuItem��setter����
	*/
	public void setMenuJMenuItems(ArrayList<JMenuItem> menuJMenuItems) {
		this.menuJMenuItems = menuJMenuItems;
	}

	/**
	 * Ϊ��Menu����������MenuItem����ActionListener
	 * @param listener
	 */
	public void addActionListener(ActionListener listener) {
		for (JMenuItem item : getMenuJMenuItems()) {
			item.addActionListener(listener);
		}
	}
	
	/**
	 * ����Items�Ƿ����
	 * @param values		��Ŀ�ɷ�ʹ�õ�ֵ
	 */
	public void updateItemsEnable(boolean ...values) {
		for (int i=0; i < values.length; i++) {
			getMenuJMenuItems().get(i).setEnabled(values[i]);
		}
	}

	/**
	 * ʹ�Ƴ�JMenuItemʱ�����menuJMenuItem�������Ƴ�
	 */
	public void remove(JMenuItem item) {
		super.remove(item);
		
		if (menuJMenuItems.contains(item)) {
			menuJMenuItems.remove(item);
		}
	}
}
