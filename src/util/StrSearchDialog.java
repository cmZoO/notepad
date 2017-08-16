package util;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 * 查找功能服务
 * @author zx583
 *
 */
public class StrSearchDialog extends JDialog {

	public StrSearchDialog(JTextArea textArea, Component relativeTo) {
		super();
		
		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Dialog owner, boolean modal, JTextArea textArea, Component relativeTo) {
		super(owner, modal);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Dialog owner, String title, boolean modal,
			GraphicsConfiguration gc, JTextArea textArea, Component relativeTo) {
		super(owner, title, modal, gc);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Dialog owner, String title, boolean modal, JTextArea textArea, Component relativeTo) {
		super(owner, title, modal);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Dialog owner, String title, JTextArea textArea, Component relativeTo) {
		super(owner, title);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Dialog owner, JTextArea textArea, Component relativeTo) {
		super(owner);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Frame owner, boolean modal, JTextArea textArea, Component relativeTo) {
		super(owner, modal);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Frame owner, String title, boolean modal,
			GraphicsConfiguration gc, JTextArea textArea, Component relativeTo) {
		super(owner, title, modal, gc);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Frame owner, String title, boolean modal, JTextArea textArea, Component relativeTo) {
		super(owner, title, modal);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Frame owner, String title, JTextArea textArea, Component relativeTo) {
		super(owner, title);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Frame owner, JTextArea textArea, Component relativeTo) {
		super(owner);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Window owner, ModalityType modalityType, JTextArea textArea, Component relativeTo) {
		super(owner, modalityType);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Window owner, String title,
			ModalityType modalityType, GraphicsConfiguration gc, JTextArea textArea, Component relativeTo) {
		super(owner, title, modalityType, gc);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Window owner, String title, ModalityType modalityType, JTextArea textArea, Component relativeTo) {
		super(owner, title, modalityType);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Window owner, String title, JTextArea textArea, Component relativeTo) {
		super(owner, title);

		StrSearchServerInit(textArea, relativeTo);
	}

	public StrSearchDialog(Window owner, JTextArea textArea, Component relativeTo) {
		super(owner);

		StrSearchServerInit(textArea, relativeTo);
	}

	/**
	 * 核心功能实现
	 * @param textArea  查找对象
	 * @param relative	窗口依赖
	 */
	public void StrSearchServerInit(final JTextArea textArea, Component relativeTo) {
		final StrSearchDialog thisDialog = this;
		//合法性判断
		if (textArea == null || !(textArea  instanceof JTextArea)) return;
	
		//设置窗口布局为绝对布局
		getContentPane().setLayout(null);
		//设置窗口标题
		setTitle("查找");
		//设置窗口大小
		setSize(400, 200);
		//设置窗口大小不可变
		setResizable(false);
		//设置文本窗口居中显示
		setLocationRelativeTo(relativeTo);
		
		//查找文本输入框
		final TextField inputField = new TextField();
		//设置输入框位置大小
		inputField.setBounds(20, 20, 200, 30);
		
		//查找第一个按钮
		JButton searchFirst = new JButton("查找第一个");
		//设置按钮位置大小
		searchFirst.setBounds(260, 20, 120, 30);
		//为按钮添加监听
		searchFirst.addMouseListener(new MouseAdapter() {
			//功能：查找文本输入框中文本第一次出现的位置
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//得到文本输入框中的文本
				String searchStr = inputField.getText();
				//查找查询文本在文本域中第一次出现的位置
				int index = textArea.getText().indexOf(searchStr);
				//没有查到结果，弹窗提醒
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "找不到下一个" + searchStr);
					return;
				}
		
				//选中所查到的文本，光标置于文本后
				textArea.select(index, index + searchStr.length());
			}
		});
		
		JButton searchLast = new JButton("向上查");
		searchLast.setBounds(260, 60, 120, 30);
		searchLast.addMouseListener(new MouseAdapter() {
			//功能：从光标位置开始查找上一个文本输入框中的文本
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				String searchStr = inputField.getText();
				
				int index;
				//如果当前选中文档为本查询的一个结果，则该文档的上一个位置开始查找
				if (textArea.getSelectedText() != null && textArea.getSelectedText().equals(searchStr) && textArea.getSelectionEnd() == textArea.getCaretPosition()) {
					index = textArea.getText().substring(0, textArea.getCaretPosition()-searchStr.length()).lastIndexOf(searchStr);
				} else {
					//否则从光标位置开始查找上一个文本输入框中的文本
					index = textArea.getText().substring(0, textArea.getCaretPosition()).lastIndexOf(searchStr);
				}
			
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "找不到上一个" + searchStr);
					return;
				}
	
				textArea.select(index, index + searchStr.length());
			}
		});
		
		
		JButton searchNext = new JButton("向下查");
		searchNext.addMouseListener(new MouseAdapter() {
			//功能：从光标位置开始查找下一个文本输入框中的文本
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				String searchStr = inputField.getText();
				//从光标位置开始查找下一个文本输入框中的文本
				int index = textArea.getText().indexOf(searchStr, textArea.getCaretPosition());
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "找不到下一个" + searchStr);
					return;
				}
	
				textArea.select(index, index + searchStr.length());
			}
		});
		searchNext.setBounds(260, 100, 120, 30);
		
		getContentPane().add(inputField);
		getContentPane().add(searchFirst);
		getContentPane().add(searchLast);
		getContentPane().add(searchNext);
		
		setVisible(true);
		
	}
	
}
