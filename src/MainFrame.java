import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import bean.NFrame;
import bean.NTextArea;
import listener.MainFrameListener;
import listener.RightPopupMenuListener;
import listener.TextAreaListener;
import server.ConfigServer;
import server.EditorServer;
import server.FileIOServer;
import server.FileServer;
import server.TextAreaMgmtServer;
import util.AlertWindows;
import util.TextAreaUtil;
import view.NMenuBar;
import view.RightPopupMenu;

/**
 * notepad程序入口
 * 继承NFrame
 * 		属性
 * 			menuBar				窗口上方菜单条
 * 			textArea			窗口中的文本操作区域
 * 			scrollwriteArea		用于实现滑动
 * 			nPopupMenu			右键菜单
 * 		新增方法
 * 			public static void main(String[] args)
 *			public void MainFrameInit()
 *			public void initResource()
 * @author zx583
 *
 */
public class MainFrame extends NFrame {
	
	private Font textAreaFont = new Font("微软",Font.PLAIN,24);

	private JMenuBar menuBar;
	
	private NTextArea textArea;
	private JScrollPane scrollwriteArea;
	private RightPopupMenu rightPopupMenu;
	
	public static void main(String[] args) {
		MainFrame man = new MainFrame();
		
		if (args.length > 0) {
			if (args[0].endsWith(".txt") || args[0].endsWith(".html")) {
				TextAreaUtil.appendInitText(new FileIOServer().readCharFile(args[0]), man.textArea);
				//设置textArea的file文件关联
				man.textArea.setFile(new File(args[0]));
			} else {
				AlertWindows.showMessageDialog(man, "不支持的文件类型");
			}
		}
	}
	
	public MainFrame() throws HeadlessException {
		super();
		
		MainFrameInit();
	}



	public MainFrame(GraphicsConfiguration gc) {
		super(gc);
		
		MainFrameInit();
	}



	public MainFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		
		MainFrameInit();
	}



	public MainFrame(String title) throws HeadlessException {
		super(title);
		
		MainFrameInit();
	}

	/**
	 * 初始化函数
	 * 		用于初始化界面以及公有资源
	 */
	public void MainFrameInit() {
		System.setProperty("java.awt.im.style","on-the-spot");
		try {  
            // 请配合Look And Feel使用本组件，可得到更好的效果  
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        } catch (InstantiationException e) {  
            e.printStackTrace();  
        } catch (IllegalAccessException e) {  
            e.printStackTrace();  
        } catch (UnsupportedLookAndFeelException e) {  
            e.printStackTrace();  
        }  
		
		//初始化属性，并将必要的属性设置进公有资源集
		initResource();
		
		//设置初始窗口大小
		setBounds(0, 0, 600, 600);
		//设置关闭按钮属性
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//设置屏幕居中显示
		setLocationRelativeTo(null);
		//设置布局为BorderLayout
		getContentPane().setLayout(new BorderLayout());
		//设置监听逻辑
		addWindowListener(new MainFrameListener(this));
		
		//设置textArea里面的字体
		textArea.setFont(textAreaFont);
		//为textArea添加监听逻辑
		textArea.addMouseListener(new TextAreaListener(this));
		
		//给右键菜单nPopupMenu添加监听逻辑
		RightPopupMenuListener rightPopupMenuListener = new RightPopupMenuListener(this);
		rightPopupMenu.addActionListener(rightPopupMenuListener);
		rightPopupMenu.addPopupMenuListener(rightPopupMenuListener);
		
		//将textArea添加进scrollwriteArea，实现滑动
		scrollwriteArea.getViewport().add(textArea);
		
		//将scrollwriteArea放置于BorderLayout.CENTER
		getContentPane().add(scrollwriteArea, BorderLayout.CENTER);
		
		//设置menuBar背景颜色
		menuBar.setBackground(Color.white);
		//将menuBar放置于BorderLayout.NORTH
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		//设置图标
		setIconImage(new ImageIcon("image" + File.separator + "记事本.png").getImage());
		
		//设置frame窗口可视
		setVisible(true);
	}
	
	/**
	 * 资源初始化函数
	 * 		用于实例化属性，并将必要的属性设置进公有资源集
	 */
	public void initResource() {
		//实例化属性textArea
		textArea = new NTextArea(this);
		//textArea为公有资源,置入公有资源集中
		setAResource("NTextArea_textArea", textArea);
		TextAreaMgmtServer textAreaServer = new TextAreaMgmtServer(textArea);
		setAResource("textAreaServer", textAreaServer);
		setAResource("fileServer", new FileServer(this));
		setAResource("editorServer", new EditorServer(this));
		setAResource("configServer", new ConfigServer(textAreaServer));

		scrollwriteArea = new JScrollPane();
		
		menuBar =  new NMenuBar(this);
		
		rightPopupMenu = new RightPopupMenu(this);
		setAResource("RightPopupMenu_rightPopupMenu", rightPopupMenu);
	}
}
