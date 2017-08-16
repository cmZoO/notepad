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
 * 帮助里面的helpinfo子界面
 * @author zx583
 *
 */
public class HelpInfo extends JPanel {
	
	/**
	 * 构造函数中对界面进行构造与排版
	 */
	public HelpInfo() {
		//设置界面布局为FlowLayout(FlowLayout.LEFT)
		setLayout(new BorderLayout());
		setBackground(Color.white);
		//新建一个JLable实例
		JLabel lable = new JLabel("文件处理系统-NoteSys");
		lable.setFont(new Font("微软", Font.PLAIN, 16));
		lable.setHorizontalAlignment(JLabel.CENTER);
		//将该实例添加到界面中
		add(lable, BorderLayout.NORTH);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setPreferredSize(new Dimension(150, 200));
		leftPanel.setLayout(new GridLayout(6, 1));
		leftPanel.add(new JLabel("产品版本: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("操作系统: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("Java: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("供应商: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("网址: ", JLabel.RIGHT));
		leftPanel.add(new JLabel("开发小组: ", JLabel.RIGHT));
		leftPanel.setBackground(Color.white);
		add(leftPanel, BorderLayout.WEST);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(6, 1));
		rightPanel.add(new JLabel("NoteSys1.0", JLabel.LEFT));
		rightPanel.add(new JLabel(System.getProperty("os.name"), JLabel.LEFT));
		rightPanel.add(new JLabel("JDK 1.8", JLabel.LEFT));
		rightPanel.add(new JLabel("hands-on", JLabel.LEFT));
		rightPanel.add(new JLabel("www.handson.gov", JLabel.LEFT));
		rightPanel.add(new JLabel("易", JLabel.LEFT));
		rightPanel.setBackground(Color.white);
		add(rightPanel, BorderLayout.CENTER);
	}
}
