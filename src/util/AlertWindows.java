package util;

import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

/**
 * 窗口提示工具类
 * @author zx583
 *
 */
public class AlertWindows {
	//确认窗口  点击确定返回true，其他均false
	public static boolean showConfirmDialog(Component parentComponent, Object message, String title) {
		Toolkit.getDefaultToolkit().beep();
		return JOptionPane.showConfirmDialog(parentComponent, message, title, JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION;
	}
	
	//消息提示窗口
	public static void showMessageDialog(Component parentComponent, Object message) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(parentComponent, message);
	}
}
