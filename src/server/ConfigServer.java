package server;

import java.awt.Font;

import bean.NTextArea;
import inter.ConfigInter;
import util.MQFontChooser;
import util.TextAreaUtil;

/**
 * ���ò˵�����
 * @author zx583
 *
 */
public class ConfigServer implements ConfigInter {
	public static final int success = 1;
	public static final int fileNotSave = 2;
	private TextAreaMgmtServer textAreaServer;
	
	public ConfigServer(TextAreaMgmtServer textAreaServer) {
		super();
		
		this.textAreaServer = textAreaServer;
	}

	//ʹ��UTF-8��������
	public int useUTF(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//�жϵ�ǰ�ı������Ƿ���δ���������
		if (!force && !textArea.isSaved()) {
			//����δ��������,���ؽ��
			return fileNotSave;
		} 
		//�����ı�����뻷��ΪUTF-8
		textArea.setEncoded("UTF-8");
		
		//�����ǰ�ı�����ڹ����ļ� ���������ļ�
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}

		return success;
	}

	//ʹ��GBK��������
	public int useGBK(boolean force) {
		NTextArea textArea = textAreaServer.getUsingTextArea();
		
		//�жϵ�ǰ�ı������Ƿ���δ���������
		if (!force && !textArea.isSaved()) {
			//����δ��������,���ؽ��
			return fileNotSave;
		} 
		//�����ı�����뻷��ΪGBK
		textArea.setEncoded("GBK");
		
		//�����ǰ�ı�����ڹ����ļ� ���������ļ�
		if (textArea.getFile() != null) {
			TextAreaUtil.reload(textArea);
		}
		
		return success;
	}

	public void setFont() {
		NTextArea textArea = textAreaServer.getUsingTextArea();
			
		 // ��������ѡ��������������ΪԤ��ֵ  
        MQFontChooser fontChooser = new MQFontChooser(textArea.getFont());  
        // ��һ������ѡ�������ڣ�����Ϊ���������ߴ��塣����һ�����ͣ�������������ʱ������ȷ������ȡ�����ɲο�MQFontChooser.APPROVE_OPTION��MQFontChooser.CANCEL_OPTION  
        int returnValue = fontChooser.showFontDialog(textArea.getFrame());  
        // ������µ���ȷ����ť  
        if (returnValue == MQFontChooser.APPROVE_OPTION) {  
            // ��ȡѡ�������  
            Font font = fontChooser.getSelectFont();  
            // ���������õ�JTextArea��  
            textArea.setFont(font);  
        }
	}

}
