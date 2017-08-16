package bean;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

import inter.TextAreaInter;

/**
 * �Զ���ļ̳�JTextArea���ı�����
 * 	ʵ��	
 * 		DocumentListener�ӿ�		���ڱ���״̬���
 * 	��������
 * 		UndoManager		���ڳ���������(δʵ��)
 * 		saved			����ı����ڵ�����״̬�Ƿ񱣴�
 *  	file			��ʾ��ǰ�ı���������ļ�
 *  	encoded			��ʾ��ǰ�����ʽ����		Ĭ��ֵnull
 *  	frame			���Ŀ��
 *  	clip			ϵͳ���а����
 *	��������
 *		�ӿ�δʵ�ֵķ���
 *		�����Ե�getter��setter����
 *		public void NTextAreaInit()
 *		public boolean newEdit()
 *		public boolean canRedo()
 *		public boolean canUndo()
 *		public boolean canCopy()
 *		public boolean canCut()
 *		public boolean canPaste()
 *		public void redo()
 *		public void undo()
 *		public void updateTitle();
 * @author zx583
 *
 */
public class NTextArea extends JTextArea implements DocumentListener, TextAreaInter {
	private UndoManager um = new UndoManager();
	private boolean saved;
	private File file;
	private String encoded;
	private JFrame frame;
	private Clipboard clip;
	
	public NTextArea(JFrame frame) {
		super();
		
		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, Document doc) {
		super(doc);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, int rows, int columns) {
		super(rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, String text, int rows, int columns) {
		super(text, rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, String text) {
		super(text);

		NTextAreaInit(frame);
	}

	/**
	 * ��ʼ��������ʵ���������ԣ������ʽ������null
	 */
	public void NTextAreaInit(JFrame frame) {
		//ʵ����ϵͳ���а����
		clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		//ʵ�������Ŀ��
		this.frame = frame;
		
		//Ĭ���ı�����ʱΪ�����ѱ���״̬
		this.saved = true;
		
		//��file����ֵnull
		this.file = null;
					
		//ע��UndoManager
		this.getDocument().addUndoableEditListener(new UndoableEditListener() {
				public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});
		
		//
		this.getDocument().addDocumentListener(this);
		
		//�����ʽĬ��null
		this.encoded = null;
		
		//����Tab�Ĵ�С
		setTabSize(4);
    }

	
	/**
	 * UndoManager��getter����
	 * @return		�ı���󶨵�UndoManagerʵ��
	 */
	public UndoManager getUm() {
		return um;
	}

	/**
	 * UndoManager��setter����
	 * @param um		����ȡ������UndoManagerʵ��
	 */
	public void setUm(UndoManager um) {
		this.um = um;
	}

	/**
	 * saved��setter����
	 * @param saved		�µ�savedֵ
	 */
	public void setSaved(boolean saved) {
		this.saved = saved;
		
		updateTitle();
	}
	
	/**
	 * ����frame���ڱ���,Ϊ������״̬��ʾ
	 */
	public void updateTitle() {
		//���ñ�����ʾ
		String s, n, e;

		s = (isSaved() ? "" : "*");
		n = (getFile() == null ? "" : getFile().getName());
		e = (getEncoded() == null ? "" : "(" + getEncoded() + ")");

		frame.setTitle(s + n + e);
	}

	/**
	 * saved��getter����
	 * @return		saved��ֵ
	 */
	public boolean isSaved() {
		return saved;
	}

	/**
	 * ��ʼ���ı���Ϊ��
	 */
	public void clearEdit() {
		//����ı���û���й����룬ֱ�ӷ���
		if (!um.canUndoOrRedo() && file == null) return;

		//�����ı���Ϊ���ı�
		setText("");
		
		//���UndoManager��¼
		um.discardAllEdits();
		
		//ȡ��textArea��file�ļ�����
		setFile(null);
		
		//���õ�ǰ���뻷��
		setEncoded(null);
		
		//�����ı���Ϊ�ѱ���״̬
		setSaved(true);
		
		updateTitle();
		
		return;
	}
	
	/**
	 * ����ı�����״̬
	 */
	public void clearState() {
		//ȡ��textArea��file�ļ�����
		setFile(null);
				
		//���õ�ǰ���뻷��
		setEncoded(null);	
		
		//���undo/redo����
		clearUndoRedo();
		
		//�����ı���Ϊ�ѱ���״̬
		setSaved(true);
		
		updateTitle();
	}
	
	/**
	 * ���undo/redo����
	 */
	public void clearUndoRedo() {
		//���UndoManager��¼
		um.discardAllEdits();
	}

	/**
	 * �жϵ�ǰ�ı���ɷ�Redo����
	 * @return	�жϵĽ��
	 */
	public boolean canRedo() {
		return um.canRedo();
	}
	
	/**
	 * �жϵ�ǰ�ı���ɷ�Undo����
	 * @return	�жϵĽ��
	 */
	public boolean canUndo() {
		return um.canUndo();
	}
	
	/**
	 * �жϵ�ǰ�ı���ɷ��Ʋ���
	 * @return	�жϵĽ��
	 */
	public boolean canCopy() {
		return getSelectedText() != null ;
	}
	
	/**
	 * �жϵ�ǰ�ı���ɷ���в���
	 * @return	�жϵĽ��
	 */
	public boolean canCut() {
		return canCopy();
	}
	
	/**
	 * �жϵ�ǰ�ı���ɷ�ճ������
	 * @return	�жϵĽ��
	 */
	public boolean canPaste() {
		Transferable clipT = clip.getContents(null);
		
		return clipT != null && clipT.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	
	/**
	 * �Ե�ǰ�ı������redo����
	 */
	public void redo() {
		if (um.canRedo())	um.redo();
	}
	
	/**
	 * �Ե�ǰ�ı������undo����
	 */
	public void undo() {
		if (um.canUndo())	um.undo();
	}
	
	/**
	 * file��getter����
	 * @return		fileʵ��
	 */
	public File getFile() {
		return file;
	}

	/**
	 * file��setter����
	 * @param file		�µ�fileʵ��
	 */
	public void setFile(File file) {
		this.file = file;
		
		updateTitle();
	}

	/**
	 * frame��getter����
	 * @param frameʵ��
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * frame��setter����
	 * @param frame		�µ�frameʵ��
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	/**
	 * �����ʽ����encoded��getter����
	 * @return	��ǰ�����ʽ����
	 */
	public String getEncoded() {
		return encoded;
	}

	/**
	 * �����ʽ����encoded��setter����
	 * @param encoded	�µı����ʽ����
	 */
	public void setEncoded(String encoded) {
		this.encoded = encoded;
		
		updateTitle();
	}


	/**
	 * DocumentListener����
	 * ��Ӧ�ı�������
	 */
	public void insertUpdate(DocumentEvent e) {
		setSaved(false);
//		System.out.println("����");
	}

	/**
	 * DocumentListener����
	 * ��Ӧ�ı��Ƴ����
	 */
	public void removeUpdate(DocumentEvent e) {
		setSaved(false);
//		System.out.println("�Ƴ�");
	}

	/**
	 * DocumentListener����
	 * ��Ӧ�ı����Եı仯
	 */
	public void changedUpdate(DocumentEvent e) {
		
	}
}
