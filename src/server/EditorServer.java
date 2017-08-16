package server;

import java.text.SimpleDateFormat;
import java.util.Date;

import bean.NTextArea;
import inter.EditorInter;
import inter.ResourceMgmt;
import util.StrSearchDialog;
import util.TextAreaUtil;

/**
 * �ļ��༭����
 * @author zx583
 *
 */
public class EditorServer implements EditorInter {
	private TextAreaMgmtServer textAreaServer;
	
	public EditorServer(ResourceMgmt resourceMgmt) {
		this.textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
	}
	
	//������ʱ����
	private NTextArea textArea;
	
	/**
	 * ��������
	 */
	public void cut() {
		textAreaServer.getUsingTextArea().cut();
	}

	/**
	 * ��������
	 */
	public void copy() {
		textAreaServer.getUsingTextArea().copy();
	}

	/**
	 * ճ������
	 */
	public void paste() {
		textAreaServer.getUsingTextArea().paste();
	}

	/**
	 * ��������
	 */
	public void redo() {
		textAreaServer.getUsingTextArea().redo();
	}

	/**
	 * undo����
	 */
	public void undo() {
		textAreaServer.getUsingTextArea().undo();
	}

	/**
	 * ȫѡ����
	 */
	public void selectAll() {
		textAreaServer.getUsingTextArea().selectAll();
	}

	/**
	 * ���ʱ������
	 */
	public void addTime() {
		TextAreaUtil.insertToSelectPosition(textAreaServer.getUsingTextArea(),  new SimpleDateFormat("hh:mm:ss yyyy-MM-dd").format(new Date()).toString());
	}

	/**
	 * ��������
	 */
	public void search() {
		textArea = textAreaServer.getUsingTextArea();
		new StrSearchDialog(textArea, textArea.getFrame());
	}

	/**
	 * �ж��ܷ��������
	 */
	public boolean canCut() {
		
		return textAreaServer.getUsingTextArea().canCut();
	}

	/**
	 * �ж��ܷ�������
	 */
	public boolean canCopy() {
		
		return textAreaServer.getUsingTextArea().canCopy();
	}

	/**
	 * �ж��ܷ�ճ������
	 */
	public boolean canPaste() {
		
		return textAreaServer.getUsingTextArea().canPaste();
	}

	/**
	 * �ж��ܷ�������
	 */
	public boolean canUndo() {
		
		return textAreaServer.getUsingTextArea().canUndo();
	}

	/**
	 * �ж��ܷ���������
	 */
	public boolean canRedo() {
	
		return textAreaServer.getUsingTextArea().canRedo();
	}

}
