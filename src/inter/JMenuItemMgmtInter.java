package inter;

import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public interface JMenuItemMgmtInter {
	/**
	 * ��дpublic JMenuItem add(JMenuItem menuItem)
	 * ʹ����JMenuItemʱ�������menuJMenuItem������
	 */
	public JMenuItem add(JMenuItem menuItem);

	/**
	 * ��дpublic void remove(JMenuItem item)
	 * ʹ�Ƴ�JMenuItemʱ�����menuJMenuItem�������Ƴ�
	 */
	public void remove(JMenuItem item);
	
	/**
	 * Ϊ��Menu����������MenuItem����ActionListener
	 * @param listener
	 */
	public void addActionListener(ActionListener listener);

	/**
	 * ����Items�Ƿ����
	 * @param values		��Ŀ�ɷ�ʹ�õ�ֵ
	 */
	public void updateItemsEnable(boolean ...values);
}
