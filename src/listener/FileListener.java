package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

import bean.NFileChooser;
import bean.NTextArea;
import inter.ResourceMgmt;
import server.FileIOServer;
import server.FileServer;
import server.TextAreaMgmtServer;
import util.AlertWindows;
import util.FileServerAlert;
import util.TextAreaUtil;
import view.FileMenu;

/**
 * FileMenu���߼������ӿ�
 * ����
 * 		jFileChooser 		NFileChoser�࣬���ڿ��ӻ�ѡ�ж�/д·��
 * 		textAreaServer		�ı�����Դ����
 * 		fileServer 			�ļ�����
 * 		saveas, save		FileMenu�˵��ϵ�saveas, save��Ŀ
 * @author zx583
 *
 */
public class FileListener implements ActionListener {
	private JFileChooser jFileChooser;
	private TextAreaMgmtServer textAreaServer;
	private FileServer fileServer;
	private JMenuItem saveas, save;
	
	//����Ϊ������ʱ����
	private NTextArea textArea;
	private int result;
	/**
	 * ��ʼ������
	 * @param resourceMgmt
	 */
	public FileListener(ResourceMgmt resourceMgmt) {
		super();
		
		//ʵ�����Զ����JFileChoser������FileChooser
		jFileChooser = new NFileChooser();
		
		//ͨ��������Դ����ӿ�ʵ����fileServer,textAreaServer,save
		textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
		fileServer = (FileServer)resourceMgmt.getAResource("fileServer");
		saveas = (JMenuItem) resourceMgmt.getAResource("JMenuItem_saveas");
		save = (JMenuItem) resourceMgmt.getAResource("JMenuItem_save");
	}
	
	public void actionPerformed(ActionEvent e) {
		//�õ�ACtionComment
		String actionComment = e.getActionCommand();
	
		//�ж�ActionComment����Ӧ�Ĳ���
		if (actionComment.equals(FileMenu.ActionCommand_newfile)) {
			//�½��ı�����
			//��ȡ��ǰ�����ı���ʵ��
			textArea = textAreaServer.getUsingTextArea();
			
			//�жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				//����δ��������,��������
				if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "�Ƿ񱣴浱ǰ�ĵ�", 
												   "�����������ܻᵼ���ĵ���ʧ")) {
					//���浱ǰ�ĵ�
					save.doClick();
					return;
				}
			} 
			
			//�ı����ʼ�� 
			fileServer.newFile(textArea);
		
		} else if (actionComment.equals(FileMenu.ActionCommand_open)) {
			//�ı��򿪲���
			//��ȡ��ǰ�����ı���ʵ��
			textArea = textAreaServer.getUsingTextArea();
			
			//�жϵ�ǰ�ı������Ƿ���δ���������
			if (!textArea.isSaved()) {
				//����δ��������,��������
				if (AlertWindows.showConfirmDialog(textArea.getFrame(), 
												   "�Ƿ񱣴浱ǰ�ĵ�", 
												   "�����������ܻᵼ���ĵ���ʧ")) {
					//���浱ǰ�ĵ�
					save.doClick();
					return;
				}
			} 
		
			//��JFileChoser���ļ�ѡ���������ж��Ƿ�ѡ�����ļ�
			if (jFileChooser.showOpenDialog(textArea.getFrame()) == jFileChooser.APPROVE_OPTION) {
				//ѡ�����ļ�,��ö�Ӧ��Fileʵ��
				File file = jFileChooser.getSelectedFile();
				
				result = fileServer.open(file, textArea);
				
				if (result != fileServer.success) {
					FileServerAlert.showErrorMessage(result, textArea.getFrame());
				}

			}
				
		} else if (actionComment.equals(FileMenu.ActionCommand_save)){
			//�ı��������
	
			//��ȡ��ǰ�����ı���ʵ��
			textArea = textAreaServer.getUsingTextArea();
			//�õ������Ĵ����ļ�
			File file = textArea.getFile();
			//�����ǰ�ı���û�й��������ļ�
			if (file == null) {
				saveas.doClick();
				return;
			}
			
			result = fileServer.save(file, textArea);
			
			if (result != fileServer.success) {
				FileServerAlert.showErrorMessage(result, textArea.getFrame());
			}
			
		} else if (actionComment.equals(FileMenu.ActionCommand_saveas)) {
			//�ı�������
			//��ȡ��ǰ�����ı���ʵ��
			textArea = textAreaServer.getUsingTextArea();
			
			//���Ϊ���ļ�ʵ��
			File file = null;
			//ʹ��goto�﷨���ж�ζ�ȡ�ļ�·��
			rechose:for(;;) {
				//�ж��Ƿ�ȡ���˲����������ж��¼�
				if (jFileChooser.showSaveDialog(textArea.getFrame()) == JFileChooser.CANCEL_OPTION) return;
				//�����ѡȡ���ļ�ʵ��
				file = jFileChooser.getSelectedFile();
				//�õ���ǰѡ���ĺϷ���׺
				String end = jFileChooser.getFileFilter().getDescription().replace("*", "");
				//�ж���ѡ�Ƿ�Ϊһ���Ϸ���׺����ѡ�ļ���׺�Ƿ���Ϸ���׺��ͬ
				if (end.contains(".") && !file.getName().endsWith(end)) {
					//�ж���ѡ�ļ��Ƿ����ļ���׺
					if (file.getName().lastIndexOf('.') != -1) {
						//��ѡ�ļ���Ϸ��ļ���׺��ͬ���������Ѳ�ȡ���¼�
						AlertWindows.showMessageDialog(textArea.getFrame(), "�ļ���׺����");
						return;
					}
			
					//��ѡ�ļ�û�к�׺���Զ�����ļ���׺
					file = new File(file.getAbsolutePath() + end);
				}
				
				//�жϸ��ļ��Ƿ��Ѿ�����
				if (file.exists()) {
					//�ļ��Ѵ��ڣ�����ѯ���Ƿ�������ļ�
					if (AlertWindows.showConfirmDialog(textArea.getFrame(), "�Ƿ��滻���ļ�", "���ļ��Ѵ���")) {
						//ѡ�����滻�ļ�������gotoѭ��
						break rechose;
					}
				} else {
					//�ļ������ڣ�·���Ϸ�������gotoѭ��
					break rechose;
				}
			}
			
			fileServer.save(file, textArea);
		}
	}

}
