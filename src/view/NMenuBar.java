package view;

import java.awt.Font;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MenuDragMouseListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;

import listener.ConfigListener;
import listener.EditorListener;
import listener.FileListener;
import listener.HelpListener;
import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * �˵�������
 * 	����
 * 		fileMenu, editorMenu, config, help		�˵����еĲ˵�
 * @author zx583
 *
 */
public class NMenuBar extends JMenuBar {
	private NMenu fileMenu, editorMenu, config, help;

	/**
	 * ���췽���жԲ˵������в���
	 * @param resourceMgmt			���Ĵ������Ĺ�����Դ����ӿ�    �ɴ��л�ȡ������Դ
	 */
	public NMenuBar(ResourceMgmt resourceMgmt) {
		super();
		
		//�½�һ���˵�
		fileMenu = new FileMenu("�ļ�", resourceMgmt);
		//���øò˵�������
		MenuFontUtil.setMenuFont(fileMenu);
		
		
		editorMenu = new EditorMenu("�༭", resourceMgmt);
		MenuFontUtil.setMenuFont(editorMenu);
		
		config = new ConfigMenu("����", resourceMgmt);
		MenuFontUtil.setMenuFont(config);
	
		help = new NMenu("����", resourceMgmt);
		MenuFontUtil.setMenuFont(help);
		
		//Ϊ�ò˵���Ӷ�Ӧ�ļ����߼�
		fileMenu.addActionListener(new FileListener(resourceMgmt));
		EditorListener editorListener = new EditorListener(resourceMgmt);
		editorMenu.addMenuListener(editorListener);
		editorMenu.addActionListener(editorListener);
		config.addActionListener(new ConfigListener(resourceMgmt));
		help.addMouseListener(new HelpListener(resourceMgmt));
		
		//���ò˵��ӵ��˵�����
		add(fileMenu);
		add(editorMenu);
		add(config);
		add(help);
	}
}
