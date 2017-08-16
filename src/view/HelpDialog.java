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
 * 帮助界面的主框架
 * 	属性
 * 		helpabout		帮助界面的关于子界面
 * 		helpinfo		帮助界面的详细信息子界面
 * @author zx583
 *
 */
public class HelpDialog extends JDialog implements ActionListener{
	//ActionCommand常量
	private static final String ActionCommand_about = "about";
	private static final String ActionCommand_info = "info";

	private JPanel helpabout, helpinfo;
	
	/**
	 * 构造函数对界面进行布局
	 */
	public HelpDialog(JFrame frame) {
		//设置Frame界面的布局为BorderLayout
		getContentPane().setLayout(new BorderLayout());
		
		//新建一个JMenuBar
		JMenuBar menu = new JMenuBar();
		
		//新建一个JMenuItem
		JMenuItem aboutItem = new JMenuItem("关于");
		//为该MenuItem设置ActionCommand
		aboutItem.setActionCommand(ActionCommand_about);
		//为该MenuItem设置ActionCommand
		aboutItem.addActionListener(this);
		//设置MenuItem背景颜色为白色
		aboutItem.setBackground(Color.white);
		JMenuItem infoItem = new JMenuItem("详细信息");
		infoItem.setActionCommand(ActionCommand_info);
		infoItem.addActionListener(this);
		infoItem.setBackground(Color.white);
		
		//将该MenuItem加入MenuBar中
		menu.add(aboutItem);
		menu.add(infoItem);
		//设置MenuBar布局为FlowLayout(FlowLayout.LEFT)
		menu.setLayout(new FlowLayout(FlowLayout.LEFT));
		//设置MenuBar背景为白色
		menu.setBackground(Color.white);
		
		//将MenuBar置入Frame的BorderLayout.NORTH位置
		getContentPane().add(menu, BorderLayout.NORTH);
		
		//实例化helpabout与helpinfo界面
		helpabout = new HelpAbout();
		helpinfo = new HelpInfo();

		//将helpabout界面放在Frame的BorderLayout.CENTER位置，为BorderLayout.CENTER默认显示界面
		getContentPane().add(helpabout, BorderLayout.CENTER);

		//设置该窗口大小不可改变
		setResizable(false);
		//设置该窗口大小
		setBounds(0, 0, 400, 300);
		//设置该窗口出现在屏幕中间
		setLocationRelativeTo(frame);
		//设置该窗口可视
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		//得到ActionCommand值
		String ActionCommand = e.getActionCommand();
		
		//判断AtionCommand值
		if (ActionCommand.equals(ActionCommand_about)) {
			//点击了关于按钮
			//将Frame上的Panel的helpinfo界面移除
			getContentPane().remove(helpinfo);
			//将helpabout界面置入Frame上的BorderLayout.CENTER
			getContentPane().add(helpabout, BorderLayout.CENTER);
		} else if (ActionCommand.equals(ActionCommand_info)) {
			getContentPane().remove(helpabout);
			getContentPane().add(helpinfo, BorderLayout.CENTER);
		}
		
		//使上面的视图变化应用到实际显示中
		validate();
		repaint();
	}
	
	
}
