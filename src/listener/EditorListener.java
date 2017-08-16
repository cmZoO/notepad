package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import inter.ResourceMgmt;
import server.EditorServer;
import util.TextAreaUtil;
import view.EditorMenu;

/**
 * EditorMenu�ļ���
 * 		ʵ��EditorMenu�Ĳ����߼�
 * 		ʵ��
 * 			ActionListener, MenuListener
 * 		����
 * 			editorMenu 		������Ӧ�Ĳ˵�
 * 			editorServer	�ı��༭����
 * @author zx583
 *
 */
public class EditorListener implements ActionListener, MenuListener{
	private EditorMenu editorMenu;
	private EditorServer editorServer;
	/**
	 * ��ʼ��ʱͨ��������Դ����ӿڽ�editorMenu�� editorServerʵ����
	 * @param resourceMgmt		������Դ����ӿ�
	 */
	public EditorListener(ResourceMgmt resourceMgmt) {
		this.editorMenu = (EditorMenu) resourceMgmt.getAResource("EditorMenu_editorMenu");
		this.editorServer = (EditorServer) resourceMgmt.getAResource("editorServer");
	}
	
	//ActionCommand��Ӧ
	public void actionPerformed(ActionEvent e) {
		//�õ�ActionComment
		String ActionCommand = e.getActionCommand();
		
		//�ж�ActionComment����Ӧ�Ĳ���
		if (ActionCommand.equals(EditorMenu.ActionCommand_cut)) {
			//����˼��а�ť�����м��в���
			editorServer.cut();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_copy)) {
			//����˸��ư�ť�����и��Ʋ���
			editorServer.copy();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_paste)) {
			//�����ճ����ť������ճ������
			editorServer.paste();
		} else if (ActionCommand.equals(EditorMenu.ACtionCommand_undo)) {
			//����˳�����ť�����г�������
			editorServer.undo();
		} else if (ActionCommand.equals(EditorMenu.ACtionCommand_redo)) {
			//�������װ��ť��������������
			editorServer.redo();
		}else if (ActionCommand.equals(EditorMenu.ActionCommand_selectAll)) {
			//�����ȫѡ��ť������ȫѡ����
			editorServer.selectAll();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_addTime)) {
			//��������ڰ�ť���ڹ�����ڵط���hh:mm:ss yyyy-MM-dd��ʽ����ʱ��
			editorServer.addTime();
		} else if (ActionCommand.equals(EditorMenu.ActionCommand_search)) {
			editorServer.search();
		}
	}

	/**
	 * �˵���ѡ��ʱ���°�ť������
	 */
	public void menuSelected(MenuEvent e) {
		editorMenu.updateItemsEnable(editorServer.canCut(), 
									 editorServer.canCopy(), 
									 editorServer.canPaste(), 
								     editorServer.canUndo(), 
									 editorServer.canRedo());
	}

	/**
	 * �˵�ȡ��ѡ��ʱȷ����ݼ�������
	 */
	public void menuDeselected(MenuEvent e) {
		editorMenu.updateItemsEnable(true, 
									 true, 
									 true, 
									 true, 
									 true);
	}

	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub
		
	}

}
