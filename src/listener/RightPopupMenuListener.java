package listener;

import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import bean.NPopupMenu;
import inter.ResourceMgmt;
import server.EditorServer;
import view.RightPopupMenu;

/**
 * NPopupMenu�ļ���
 * 		ʵ��NPopupMenu�Ĳ����߼�
 * 		ʵ��
 * 			ActionListener
 * 			PopupMenuListener
 * 		����
 * 			editorServer	�ı��༭����
 * 			nPopupMenu	������Ӧ��NPopupMenuʵ��
 * @author zx583
 *
 */
public class RightPopupMenuListener implements ActionListener, PopupMenuListener {
	private EditorServer editorServer;
	private RightPopupMenu rightPopupMenu;
	/**
	 * ��ʼ��ʱͨ��������Դ����ӿڽ�textAreaʵ����
	 * @param resourceMgmt		������Դ����ӿ�
	 */
	public RightPopupMenuListener(ResourceMgmt resourceMgmt) {
		this.editorServer = (EditorServer) resourceMgmt.getAResource("editorServer");
		this.rightPopupMenu = (RightPopupMenu) resourceMgmt.getAResource("RightPopupMenu_rightPopupMenu");
	}
	
	//ActionCommand��Ӧ�߼�
	public void actionPerformed(ActionEvent e) {
		// �õ�ActionComment
		String ActionCommand = e.getActionCommand();

		// �ж�ActionComment����Ӧ�Ĳ���
		if (ActionCommand.equals(RightPopupMenu.ActionCommand_cut)) {
			// ����˼��а�ť�����м��в���
			editorServer.cut();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_copy)) {
			// ����˸��ư�ť�����и��Ʋ���
			editorServer.copy();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_paste)) {
			// �����ճ����ť������ճ������
			editorServer.paste();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_undo)) {
			// ����˳�����ť�����г�������
			editorServer.undo();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_selectAll)) {
			// �����ȫѡ��ť������ȫѡ����
			editorServer.selectAll();
		} else if (ActionCommand.equals(RightPopupMenu.ActionCommand_addTime)) {
			// ��������ڰ�ť���ڹ�����ڵط���hh:mm:ss yyyy-MM-dd��ʽ����ʱ��
			editorServer.addTime();
		} 
	}

	//�˵���ʾʱ�����䰴ť������
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		rightPopupMenu.updateItemsEnable(editorServer.canUndo(),
									 editorServer.canCopy(), 
								 	 editorServer.canPaste(), 
									 editorServer.canCut());
	}

	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		
	}

	public void popupMenuCanceled(PopupMenuEvent e) {
		
	}



}
