package view;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * �༭�˵�
 * 		����		cut, copy, paste, selectAll, addTime, search		�˵��еĲ˵���
 * 				resourceMgmt										������Դ�ӿ�
 * 		����		public void EditorMenuInit()
 * @author zx583
 *
 */
public class EditorMenu extends NMenu {
	//ActionComment����
	public static final String ActionCommand_cut = "cut";
	public static final String ActionCommand_copy = "copy";
	public static final String ActionCommand_paste = "paste";
	public static final String ACtionCommand_redo = "redo";
	public static final String ACtionCommand_undo = "undo";
	public static final String ActionCommand_selectAll = "selectAll";
	public static final String ActionCommand_addTime = "addTime";
	public static final String ActionCommand_search = "search";
	
	private JMenuItem cut, copy, paste,undo, redo, selectAll, addTime, search;
	private ResourceMgmt resourceMgmt;
	
	public EditorMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt); 
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	public EditorMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
	
		EditorMenuInit(resourceMgmt);
	}

	/**
	 * ��ʼ���˵�����
	 * 		Ϊ�༭�˵���Ӳ˵���
	 */
	/**
	 * @param resourceMgmt
	 */
	public void EditorMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		
		// ʵ����һ���˵���
		cut = new JMenuItem("����");
		// Ϊ�ò˵�������ActionCommetֵ
		cut.setActionCommand(ActionCommand_cut);
		//���ÿ�ݼ�
		cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));

		copy = new JMenuItem("����");
		copy.setActionCommand(ActionCommand_copy);
		copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));

		paste = new JMenuItem("ճ��");
		paste.setActionCommand(ActionCommand_paste);
		paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));

		undo = new JMenuItem("����");
		undo.setActionCommand(ACtionCommand_undo);
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));

		redo = new JMenuItem("����");
		redo.setActionCommand(ACtionCommand_redo);
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));

		selectAll = new JMenuItem("ȫѡ");
		selectAll.setActionCommand(ActionCommand_selectAll);
		selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));

		addTime = new JMenuItem("ʱ��/����");
		addTime.setActionCommand(ActionCommand_addTime);

		search = new JMenuItem("����");
		search.setActionCommand(ActionCommand_search);
		search.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		
		//���ò˵�,������Ŀ,������Ŀ,���Ҽ��빫����Դ��
		resourceMgmt.setAResource("EditorMenu_editorMenu", this);
		resourceMgmt.setAResource("JMenuItem_undo", undo);
		resourceMgmt.setAResource("JMenuItem_redo", redo);
		resourceMgmt.setAResource("JMenuItem_search", search);
		
		//���˵�����뵽�˵���
		add(cut);
		add(copy);
		add(paste);
		add(undo);
		add(redo);
		addSeparator();
		add(selectAll);
		add(addTime);
		add(search);
		
		//����Item��Ŀ�����С
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
}
