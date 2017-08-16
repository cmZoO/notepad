package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * ��������������
 * 	����
 * 		helpabout		��������Ĺ����ӽ���
 * 		helpinfo		�����������ϸ��Ϣ�ӽ���
 * @author zx583
 *
 */
public class HelpDialog extends JDialog implements ActionListener{
	//ActionCommand����
	private static final String ActionCommand_about = "about";
	private static final String ActionCommand_info = "info";

	private JPanel helpabout, helpinfo;
	
	/**
	 * ���캯���Խ�����в���
	 */
	public HelpDialog(JFrame frame) {
		//����Frame����Ĳ���ΪBorderLayout
		getContentPane().setLayout(new BorderLayout());
		
		//�½�һ��JMenuBar
		JMenuBar menu = new JMenuBar();
		
		//�½�һ��JMenuItem
		JMenuItem aboutItem = new JMenuItem("����");
		//Ϊ��MenuItem����ActionCommand
		aboutItem.setActionCommand(ActionCommand_about);
		//Ϊ��MenuItem����ActionCommand
		aboutItem.addActionListener(this);
		//����MenuItem������ɫΪ��ɫ
		aboutItem.setBackground(Color.white);
		JMenuItem infoItem = new JMenuItem("��ϸ��Ϣ");
		infoItem.setActionCommand(ActionCommand_info);
		infoItem.addActionListener(this);
		infoItem.setBackground(Color.white);
		
		//����MenuItem����MenuBar��
		menu.add(aboutItem);
		menu.add(infoItem);
		//����MenuBar����ΪFlowLayout(FlowLayout.LEFT)
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		//����MenuBar����Ϊ��ɫ
		menu.setBackground(Color.white);
		
		//��MenuBar����Frame��BorderLayout.NORTHλ��
		getContentPane().add(menu, BorderLayout.NORTH);
		
		//ʵ����helpabout��helpinfo����
		helpabout = new HelpAbout();
		helpinfo = new HelpInfo();

		//��helpabout�������Frame��BorderLayout.CENTERλ�ã�ΪBorderLayout.CENTERĬ����ʾ����
		getContentPane().add(helpabout, BorderLayout.CENTER);

		//���øô��ڴ�С���ɸı�
		setResizable(false);
		//���øô��ڴ�С
		setBounds(0, 0, 400, 300);
		//���øô��ڳ�������Ļ�м�
		setLocationRelativeTo(frame);
		//���øô��ڿ���
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//�õ�ActionCommandֵ
		String ActionCommand = e.getActionCommand();
		
		//�ж�AtionCommandֵ
		if (ActionCommand.equals(ActionCommand_about)) {
			//����˹��ڰ�ť
			//��Frame�ϵ�Panel��helpinfo�����Ƴ�
			getContentPane().remove(helpinfo);
			//��helpabout��������Frame�ϵ�BorderLayout.CENTER
			getContentPane().add(helpabout, BorderLayout.CENTER);
		} else if (ActionCommand.equals(ActionCommand_info)) {
			getContentPane().remove(helpabout);
			getContentPane().add(helpinfo, BorderLayout.CENTER);
		}
		
		//ʹ�������ͼ�仯Ӧ�õ�ʵ����ʾ��
		validate();
		repaint();
	}
	
	
}
