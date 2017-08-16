package view;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenuItem;

import bean.NPopupMenu;
import bean.NTextArea;
import inter.ResourceMgmt;

/**
 * ����Ҽ�����˵�
 * 	����	
 * 		textArea 										�������ı������
 * 		resourceMgmt									������Դ�ӿ�
 * 		undo, copy, paste, cut, selectAll, addTime		�˵���Ŀ
 * 	���ӷ���
 * 		�����Ե�getter��setter����
 * 		private void NPopupMenuInit(ResourceMgmt resourceMgmt)
 *		private void initResource()
 * @author zx583
 *
 */
public class RightPopupMenu extends NPopupMenu {
	public final static String ActionCommand_undo = "undo";
	public final static String ActionCommand_copy = "copy";
	public final static String ActionCommand_paste = "paste";
	public final static String ActionCommand_cut = "cut";
	public final static String ActionCommand_selectAll = "selectAll";
	public final static String ActionCommand_addTime = "addTime";
	
	private ResourceMgmt resourceMgmt;
	private JMenuItem undo, copy, paste, cut, selectAll, addTime;
	
	public RightPopupMenu(ResourceMgmt resourceMgmt) {
		super();
		
		RightPopupMenuInit(resourceMgmt);
	}

	public RightPopupMenu(String label, ResourceMgmt resourceMgmt) {
		super(label);
		
		RightPopupMenuInit(resourceMgmt);
	}

	/**
	 * ��ʼ������
	 * 	��ʼ������
	 * 	ʵ��������
	 * @param resourceMgmt	������Դ�ӿ�
	 */
	private void RightPopupMenuInit(ResourceMgmt resourceMgmt) {
		//ʵ������Դ
		initResource(resourceMgmt);
		
		//Ϊitem����ActionCommand
		undo.setActionCommand(ActionCommand_undo);
		copy.setActionCommand(ActionCommand_copy);
		paste.setActionCommand(ActionCommand_paste);
		cut.setActionCommand(ActionCommand_cut);
		selectAll.setActionCommand(ActionCommand_selectAll);
		addTime.setActionCommand(ActionCommand_addTime);
		
		//����˵���
		add(undo);
		addSeparator();
		add(copy);
		add(paste);
		add(cut);
		addSeparator();
		add(selectAll);
		add(addTime);
	}
	
	/**
	 * ��Դ��ʼʵ��������
	 */
	private void initResource(ResourceMgmt resourceMgmt) {
		
		//ʵ����������Դ�ӿ�
		this.resourceMgmt = resourceMgmt;
		
		undo = new JMenuItem("����");
		copy = new JMenuItem("����");
		paste = new JMenuItem("ճ��");
		cut = new JMenuItem("����");
		selectAll = new JMenuItem("ȫѡ");
		addTime = new JMenuItem("ʱ��/����");
	}
}
