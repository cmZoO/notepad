package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ���������helpinfo�ӽ���
 * @author zx583
 *
 */
public class HelpInfo extends JPanel {
	
	/**
	 * ���캯���жԽ�����й������Ű�
	 */
	public HelpInfo() {
		//���ý��沼��ΪFlowLayout(FlowLayout.LEFT)
		setLayout(new BorderLayout());
		setBackground(Color.white);
		//�½�һ��JLableʵ��
		JLabel lable = new JLabel("�ļ�����ϵͳ-NoteSys");
		lable.setFont(new Font("΢��", Font.PLAIN, 16));
		lable.setHorizontalAlignment(JLabel.CENTER);
		//����ʵ����ӵ�������
		add(lable, BorderLayout.NORTH);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(150, 200));
		leftPanel.setLayout(new GridLayout(6, 1));
		leftPanel.add(new JLabel("��Ʒ�汾: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("����ϵͳ: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("Java: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("��Ӧ��: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("��ַ: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("����С��: ", JLabel.RIGHT));
		leftPanel.setBackground(Color.white);
		add(leftPanel, BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(6, 1));
		rightPanel.add(new JLabel("NoteSys1.0", JLabel.LEFT));
		rightPanel.add(new JLabel(System.getProperty("os.name"), JLabel.LEFT));
		rightPanel.add(new JLabel("JDK 1.8", JLabel.LEFT));
		rightPanel.add(new JLabel("hands-on", JLabel.LEFT));
		rightPanel.add(new JLabel("www.handson.gov", JLabel.LEFT));
		rightPanel.add(new JLabel("��", JLabel.LEFT));
		rightPanel.setBackground(Color.white);
		add(rightPanel, BorderLayout.CENTER);
	}
}
