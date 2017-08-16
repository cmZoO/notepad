package util;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * ������ʾ������
 * @author zx583
 *
 */
public class AlertWindows {
	//ȷ�ϴ���  ���ȷ������true��������false
	public static boolean showConfirmDialog(Component parentComponent, Object message, String title) {
		Toolkit.getDefaultToolkit().beep();
		return JOptionPane.showConfirmDialog(parentComponent, message, title, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
	}
	
	//��Ϣ��ʾ����
	public static void showMessageDialog(Component parentComponent, Object message) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(parentComponent, message);
	}
}
