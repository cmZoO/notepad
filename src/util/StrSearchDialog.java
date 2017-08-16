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
 * ���ҹ��ܷ���
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
	 * ���Ĺ���ʵ��
	 * @param textArea  ���Ҷ���
	 * @param relative	��������
	 */
	public void StrSearchServerInit(final JTextArea textArea, Component relativeTo) {
		final StrSearchDialog thisDialog = this;
		//�Ϸ����ж�
		if (textArea == null || !(textArea  instanceof JTextArea)) return;
	
		//���ô��ڲ���Ϊ���Բ���
		getContentPane().setLayout(null);
		//���ô��ڱ���
		setTitle("����");
		//���ô��ڴ�С
		setSize(400, 200);
		//���ô��ڴ�С���ɱ�
		setResizable(false);
		//�����ı����ھ�����ʾ
		setLocationRelativeTo(relativeTo);
		
		//�����ı������
		final TextField inputField = new TextField();
		//���������λ�ô�С
		inputField.setBounds(20, 20, 200, 30);
		
		//���ҵ�һ����ť
		JButton searchFirst = new JButton("���ҵ�һ��");
		//���ð�ťλ�ô�С
		searchFirst.setBounds(260, 20, 120, 30);
		//Ϊ��ť��Ӽ���
		searchFirst.addMouseListener(new MouseAdapter() {
			//���ܣ������ı���������ı���һ�γ��ֵ�λ��
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				//�õ��ı�������е��ı�
				String searchStr = inputField.getText();
				//���Ҳ�ѯ�ı����ı����е�һ�γ��ֵ�λ��
				int index = textArea.getText().indexOf(searchStr);
				//û�в鵽�������������
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "�Ҳ�����һ��" + searchStr);
					return;
				}
		
				//ѡ�����鵽���ı�����������ı���
				textArea.select(index, index + searchStr.length());
			}
		});
		
		JButton searchLast = new JButton("���ϲ�");
		searchLast.setBounds(260, 60, 120, 30);
		searchLast.addMouseListener(new MouseAdapter() {
			//���ܣ��ӹ��λ�ÿ�ʼ������һ���ı�������е��ı�
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				String searchStr = inputField.getText();
				
				int index;
				//�����ǰѡ���ĵ�Ϊ����ѯ��һ�����������ĵ�����һ��λ�ÿ�ʼ����
				if (textArea.getSelectedText() != null && textArea.getSelectedText().equals(searchStr) && textArea.getSelectionEnd() == textArea.getCaretPosition()) {
					index = textArea.getText().substring(0, textArea.getCaretPosition()-searchStr.length()).lastIndexOf(searchStr);
				} else {
					//����ӹ��λ�ÿ�ʼ������һ���ı�������е��ı�
					index = textArea.getText().substring(0, textArea.getCaretPosition()).lastIndexOf(searchStr);
				}
			
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "�Ҳ�����һ��" + searchStr);
					return;
				}
	
				textArea.select(index, index + searchStr.length());
			}
		});
		
		
		JButton searchNext = new JButton("���²�");
		searchNext.addMouseListener(new MouseAdapter() {
			//���ܣ��ӹ��λ�ÿ�ʼ������һ���ı�������е��ı�
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				String searchStr = inputField.getText();
				//�ӹ��λ�ÿ�ʼ������һ���ı�������е��ı�
				int index = textArea.getText().indexOf(searchStr, textArea.getCaretPosition());
				if (index == -1) {
					JOptionPane.showMessageDialog(thisDialog, "�Ҳ�����һ��" + searchStr);
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
