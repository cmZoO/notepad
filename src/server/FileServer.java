package server;

import java.io.File;

import javax.swing.JFileChooser;

import bean.NFileChooser;
import bean.NTextArea;
import inter.FileInter;
import inter.ResourceMgmt;
import util.TextAreaUtil;

/**
 * �ļ���������
 * @author zx583
 *
 */
public class FileServer implements FileInter {
	public static final int success = 1;
	public static final int fileNotExists = 2;
	
	private TextAreaMgmtServer textAreaServer;
	
	public FileServer(ResourceMgmt resourceMgmt) {
		super();
		
		this.textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
	}

	//�½��ļ�����
	public int newFile(NTextArea textArea) {
		//û�д�textArea���ȡ��ǰʹ��textAreaΪ��������
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
		
		//�ı����ʼ�� 
		textArea.clearEdit();
	
		return success;
	}

	//���ļ�����
	public int open(File file, NTextArea textArea) {
		// û�д�textArea���ȡ��ǰʹ��textAreaΪ��������
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
		
		//�жϸ��ļ��Ƿ����
		if (!file.exists()) {
			//�ļ�������,���ز���
			return fileNotExists;
		}
			
		//����ı�����
		textArea.setText("");
		//��File�������ı����ݶ�ȡ�����������뵽�ı�����
		TextAreaUtil.appendInitText(new FileIOServer().readCharFile(file), textArea);
		//����ı�����״̬
		textArea.clearState();
		//����textArea��file�ļ�����
		textArea.setFile(file);

		return success;
	}

	//�����ļ�����
	public int save(File file, NTextArea textArea) {
		// û�д�textArea���ȡ��ǰʹ��textAreaΪ��������
		if (textArea == null) {
			textArea = textAreaServer.getUsingTextArea();
		}
				
		//�����ǰ�ı���û�й��������ļ�
		if (file == null) {
			return fileNotExists;
		}
		
		String[] data;		//���ڱ�����ı�������ȡ����������
		//ȡ���ı����е�����
		data = TextAreaUtil.toStringArry(textArea);
		
		if (file != null && file instanceof File) {
			//������д��������
			new FileIOServer().wirteCharFile(file, data, textArea.getEncoded());
			//�����ı���״̬Ϊ�ѱ���
			textArea.setSaved(true);
			//����textArea��file�ļ�����
			textArea.setFile(file);
		}
		
		return success;
	}

	/**
	 * ͨ��·�������ļ�����
	 */
	public int save(String path, NTextArea textArea) {
		return save(new File(path), textArea);
	}

	/**
	 * ͨ��·�����ļ�����
	 */
	public int open(String path, NTextArea textArea) {
		return open(new File(path), textArea);
	}

}
