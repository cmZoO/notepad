package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bean.NTextArea;
import inter.ResourceMgmt;
import server.ConfigServer;
import server.TextAreaMgmtServer;
import util.AlertWindows;
import view.ConfigMenu;

/**
 * ���ò˵������߼�
 * 	����
 * 		resourceMgmt		������Դ�ӿ�
 * 		textArea			�������ı������
 * 		configServer		���÷���ʵ��
 * 		textAreaMgmtServer	�ı������������
 * @author zx583
 *
 */
public class ConfigListener implements ActionListener {
	private ResourceMgmt resourceMgmt;
	private NTextArea textArea;
	private TextAreaMgmtServer textAreaMgmtServer;
	private ConfigServer configServer;
	/**
	 * ���캯��
	 * 		ֱ�Ӵ���ʵ����������Դ�ӿ�resourceMgmt��ʵ����textArea�ı������
	 * @param resourceMgmt
	 */
	public ConfigListener(ResourceMgmt resourceMgmt) {
		super();
		
		//ʵ����������Դ�ӿ�resourceMgmt
		this.resourceMgmt = resourceMgmt;
		
		//ʵ����textAreaMgmtServer����
		this.textAreaMgmtServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
		
		//ʵ����configServer����
		this.configServer = (ConfigServer) resourceMgmt.getAResource("configServer");
	}

	/**
	 * ActionCommand�����߼�����
	 */
	public void actionPerformed(ActionEvent e) {
		//���ACtionCommandֵ
		String actionCommand = e.getActionCommand();
		
		//��õ�ǰѡ��textArea����
		textArea = textAreaMgmtServer.getUsingTextArea();
		
		//�ж�ActionCommand��Ӧ�Ĳ���
		if (actionCommand.equals(ConfigMenu.ActionCommand_toUTF)) {
			//����ˡ�ʹ��UTF-8���롯��ť
			//�жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				//����δ��������,��������
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "�����������ܻᵼ���ĵ���ʧ", 
												   "����:��ǰ�ĵ�δ����")) {
					//ȡ���¼�����
					return;
				}
			} 
			
			configServer.useUTF(true);
			
		} else if (actionCommand.equals(ConfigMenu.ActionCommand_toGBK)) {
			//����ˡ�ʹ��GBK���롯��ť
			//�жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				//����δ��������,��������
				if (!AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "�����������ܻᵼ���ĵ���ʧ", 
												   "����:��ǰ�ĵ�δ����")) {
					//ȡ���¼�����
					return;
				}
			} 
			
			configServer.useGBK(true);
		} else if (actionCommand.equals(ConfigMenu.ActionCommand_font)) {
			//����ˡ����塯��ť
			configServer.setFont();
		}
	}

}
