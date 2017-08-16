package bean;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import inter.JMenuItemMgmtInter;
import inter.ResourceMgmt;


/**
 * �Զ����JMenu
 * 		�������� 
 * 			resourceMgmt  	�ϼ���Դ����
 * 			menuJMenuItems		�˵��µĲ˵���JMenuItem
 * ���ӷ���
 * 		�����Ե�getter��setter����
 * 		private void NMenuInit(ResourceMgmt resourceMgmt)
 *
 * ��д
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
	 * resourceMgmt���Ե�getter����
	 * @return ResourceMgmt
	 */
	public ResourceMgmt getResourceMgmt() {
		return resourceMgmt;
	}

	/**
	 * resourceMgmt��setter����
	 * @param resourceMgmt ���õ�ֵ
	 */
	public void setResourceMgmt(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
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
	public void setMenuJMenuItems(ArrayList<JMenuItem> menuJMenuItem) {
		this.menuJMenuItems = menuJMenuItem;
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
	 * ��дpublic void remove(JMenuItem item)
	 * ʹ�Ƴ�JMenuItemʱ�����menuJMenuItem�������Ƴ�
	 */
	@Override
	public void remove(JMenuItem item) {
		this.menuJMenuItems.remove(item);
		
		super.remove(item);
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
}
