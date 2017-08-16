package view;

import java.awt.Font;

import javax.swing.Action;
import javax.swing.JMenuItem;

import util.MenuFontUtil;
import bean.NMenu;
import inter.ResourceMgmt;

/**
 * ���ò˵�
 * 	����
 * 		resourceMgmt		������Դ�ӿ�
 * 		�˵���Ŀ				useUTF, useGBK,font
 * @author zx583
 *
 */
public class ConfigMenu extends NMenu {
	//ActionCommandֵ
	public static final String ActionCommand_toUTF = "useUTF";
	public static final String ActionCommand_toGBK = "useGBK";
	public static final String ActionCommand_font = "font";
	
	private ResourceMgmt resourceMgmt;
	private JMenuItem useUTF, useGBK, font, search;
	
	public ConfigMenu(Action a, ResourceMgmt resourceMgmt) {
		super(a, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(ResourceMgmt resourceMgmt) {
		super(resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(String s, boolean b, ResourceMgmt resourceMgmt) {
		super(s, b, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	public ConfigMenu(String s, ResourceMgmt resourceMgmt) {
		super(s, resourceMgmt);
		
		ConfigMenuInit(resourceMgmt);
	}

	/**
	 * ��ʼ������
	 * 		ֱ�Ӵ���ʵ����������Դ�ӿ�resourceMgmt
	 * @param resourceMgmt
	 */
	public void ConfigMenuInit(ResourceMgmt resourceMgmt) {
		//ʵ����resourceMgmt
		this.resourceMgmt = resourceMgmt;
		
		//�½�һ���˵���Ŀ
		useUTF = new JMenuItem("ʹ��UTF��������");
		//���ò˵���ĿActionCommand
		useUTF.setActionCommand(ActionCommand_toUTF);
		
		useGBK = new JMenuItem("ʹ��GBK��������");
		useGBK.setActionCommand(ActionCommand_toGBK);
		
		font = new JMenuItem("����");
		font.setActionCommand(ActionCommand_font);
		
		//���˵���Ŀ����˵���
		add(useUTF);
		add(useGBK);
		addSeparator();
		add(font);
	
		//����Item��Ŀ�����С
		MenuFontUtil.setMenuItemFont(getMenuJMenuItems());
	}
	
}
