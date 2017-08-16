package util;

import java.util.ArrayList;

import javax.swing.JTextArea;

import bean.NTextArea;
import server.FileIOServer;


/**
 * JTextArea文本域操作工具类
 * 方法
 * 		public static String[] toStringArry(JTextArea textArea)
 * 		public static void appendText(ArrayList<String> data, JTextArea textArea)
 * 		public static void insertToCaretPosition(JTextArea textArea, String str)
 * @author zx583
 *
 */
public class TextAreaUtil {
	/**
	 * 将文本域textArea里的文本内容读取出来并分隔成多行
	 * @param textArea		读取的文本域
	 * @return				读取的内容所分隔出的数据数组
	 */
	public static String[] toStringArry(JTextArea textArea) {
		return textArea.getText().split("\n");
	}
	
	/**
	 * 同指定的数据初始化文本域
	 * @param data			加入的数据集合
	 * @param textArea		数据加入的文本域
	 */
	public static void appendInitText(ArrayList<String> data, JTextArea textArea) {
		appendText(data, textArea);
	}
	
	/**
	 * 将集合中的所有数据以行为单位加入文本域textArea
	 * @param data			加入的数据集合
	 * @param textArea		数据加入的文本域
	 */
	public static void appendText(ArrayList<String> data, JTextArea textArea) {
		if (data == null || textArea == null) return;
		
		for (String tmp : data) {
			textArea.append(tmp + "\n");
		}
		
		textArea.setCaretPosition(0);
			
	}
	
	/**
	 * 在文本域textArea光标处插入字符串
	 * @param textArea		数据插入的文本域
	 * @param str			插入的字符串数据
	 */
	public static void insertToSelectPosition(JTextArea textArea, String str) {
		textArea.replaceRange(str, textArea.getSelectionStart(), textArea.getSelectionEnd());
	}
	
	/**
	 * 文本域TextArea文本重载操作
	 */
	public static void reload(NTextArea textArea) {
		//文本域初始化
		textArea.setText("");
		//将File的内容文本内容读取出来，并加入到文本域中
		TextAreaUtil.appendInitText(new FileIOServer().readCharFile(textArea.getFile(), textArea.getEncoded()), textArea);
		textArea.clearUndoRedo();
		textArea.setSaved(true);
	}
}
