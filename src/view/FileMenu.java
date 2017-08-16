package view;

import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * �ļ��˵�
 * 	����		newfile, open, save				�˵��еĲ˵���
 * 			resourceMgmt					������Դ�ӿ�
 * 	����		public void EditorMenuInit()
 * @author zx583
 *
 */
public class FileMenu extends NMenu {
	
	public static final String ActionCommand_newfile = "newfile";
	public static final String ActionCommand_open = "open";
	public static final String ActionCommand_save = "save";
	public static final String ActionCommand_saveas = "saveas";
	
	private JMenuItem newfile, open, save, saveas;
	ResourceMgmt resourceMgmt;
	
	public FileMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	public FileMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
		
		FileMenuInit(resourceMgmt);
	}

	/**
	 * ��ʼ���˵�����
	 * 		Ϊ�ļ��˵���Ӳ˵���
	 * ʵ����������Դ�ӿ�
	 */
	public void FileMenuInit(ResourceMgmt resourceMgmt) {
		this.resourceMgmt = resourceMgmt;
		
		//ʵ����һ���˵���
		newfile = new JMenuItem("�½�");
		//Ϊ�ò˵�������ActionCommetֵ
		newfile.setActionCommand(ActionCommand_newfile);
		open = new JMenuItem("��");
		open.setActionCommand(ActionCommand_open);
		save = new JMenuItem("����");
		save.setActionCommand(ActionCommand_save);
		//���ñ����ݼ�
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		saveas = new JMenuItem("���Ϊ");
		saveas.setActionCommand(ActionCommand_saveas);
		
		//�����Ϊ���빫����Դ
		resourceMgmt.setAResource("JMenuItem_saveas", saveas);
		resourceMgmt.setAResource("JMenuItem_save", save);
		
		//���˵�����뵽�˵���
		add(newfile);
		add(open);
		add(save);
		add(saveas);
		
		//����Item��Ŀ�����С
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
}
