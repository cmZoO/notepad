package util;

import java.util.ArrayList;

import javax.swing.JTextArea;

import bean.NTextArea;
import server.FileIOServer;


/**
 * JTextArea�ı������������
 * ����
 * 		public static String[] toStringArry(JTextArea textArea)
 * 		public static void appendText(ArrayList<String> data, JTextArea textArea)
 * 		public static void insertToCaretPosition(JTextArea textArea, String str)
 * @author zx583
 *
 */
public class TextAreaUtil {
	/**
	 * ���ı���textArea����ı����ݶ�ȡ�������ָ��ɶ���
	 * @param textArea		��ȡ���ı���
	 * @return				��ȡ���������ָ�������������
	 */
	public static String[] toStringArry(JTextArea textArea) {
		return textArea.getText().split("\n");
	}
	
	/**
	 * ָͬ�������ݳ�ʼ���ı���
	 * @param data			��������ݼ���
	 * @param textArea		���ݼ�����ı���
	 */
	public static void appendInitText(ArrayList<String> data, JTextArea textArea) {
		appendText(data, textArea);
	}
	
	/**
	 * �������е�������������Ϊ��λ�����ı���textArea
	 * @param data			��������ݼ���
	 * @param textArea		���ݼ�����ı���
	 */
	public static void appendText(ArrayList<String> data, JTextArea textArea) {
		if (data == null || textArea == null) return;
		
		for (String tmp : data) {
			textArea.append(tmp + "\n");
		}
		
		textArea.setCaretPosition(0);
			
	}
	
	/**
	 * ���ı���textArea��괦�����ַ���
	 * @param textArea		���ݲ�����ı���
	 * @param str			������ַ�������
	 */
	public static void insertToSelectPosition(JTextArea textArea, String str) {
		textArea.replaceRange(str, textArea.getSelectionStart(), textArea.getSelectionEnd());
	}
	
	/**
	 * �ı���TextArea�ı����ز���
	 */
	public static void reload(NTextArea textArea) {
		//�ı����ʼ��
		textArea.setText("");
		//��File�������ı����ݶ�ȡ�����������뵽�ı�����
		TextAreaUtil.appendInitText(new FileIOServer().readCharFile(textArea.getFile(), textArea.getEncoded()), textArea);
		textArea.clearUndoRedo();
		textArea.setSaved(true);
	}
}
