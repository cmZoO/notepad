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
 * notepad�������
 * �̳�NFrame
 * 		����
 * 			menuBar				�����Ϸ��˵���
 * 			textArea			�����е��ı���������
 * 			scrollwriteArea		����ʵ�ֻ���
 * 			nPopupMenu			�Ҽ��˵�
 * 		��������
 * 			public static void main(String[] args)
 *			public void MainFrameInit()
 *			public void initResource()
 * @author zx583
 *
 */
public class MainFrame extends NFrame {
	
	private Font textAreaFont = new Font("΢��",Font.PLAIN,24);

	private JMenuBar menuBar;
	
	private NTextArea textArea;
	private JScrollPane scrollwriteArea;
	private RightPopupMenu rightPopupMenu;
	
	public static void main(String[] args) {
		MainFrame man = new MainFrame();
		
		if (args.length > 0) {
			if (args[0].endsWith(".txt") || args[0].endsWith(".html")) {
				TextAreaUtil.appendInitText(new FileIOServer().readCharFile(args[0]), man.textArea);
				//����textArea��file�ļ�����
				man.textArea.setFile(new File(args[0]));
			} else {
				AlertWindows.showMessageDialog(man, "��֧�ֵ��ļ�����");
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
	 * ��ʼ������
	 * 		���ڳ�ʼ�������Լ�������Դ
	 */
	public void MainFrameInit() {
		System.setProperty("java.awt.im.style","on-the-spot");
		try {  
            // �����Look And Feelʹ�ñ�������ɵõ����õ�Ч��  
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
		
		//��ʼ�����ԣ�������Ҫ���������ý�������Դ��
		initResource();
		
		//���ó�ʼ���ڴ�С
		setBounds(0, 0, 600, 600);
		//���ùرհ�ť����
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//������Ļ������ʾ
		setLocationRelativeTo(null);
		//���ò���ΪBorderLayout
		getContentPane().setLayout(new BorderLayout());
		//���ü����߼�
		addWindowListener(new MainFrameListener(this));
		
		//����textArea���������
		textArea.setFont(textAreaFont);
		//ΪtextArea��Ӽ����߼�
		textArea.addMouseListener(new TextAreaListener(this));
		
		//���Ҽ��˵�nPopupMenu��Ӽ����߼�
		RightPopupMenuListener rightPopupMenuListener = new RightPopupMenuListener(this);
		rightPopupMenu.addActionListener(rightPopupMenuListener);
		rightPopupMenu.addPopupMenuListener(rightPopupMenuListener);
		
		//��textArea��ӽ�scrollwriteArea��ʵ�ֻ���
		scrollwriteArea.getViewport().add(textArea);
		
		//��scrollwriteArea������BorderLayout.CENTER
		getContentPane().add(scrollwriteArea, BorderLayout.CENTER);
		
		//����menuBar������ɫ
		menuBar.setBackground(Color.white);
		//��menuBar������BorderLayout.NORTH
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		//����ͼ��
		setIconImage(new ImageIcon("image" + File.separator + "���±�.png").getImage());
		
		//����frame���ڿ���
		setVisible(true);
	}
	
	/**
	 * ��Դ��ʼ������
	 * 		����ʵ�������ԣ�������Ҫ���������ý�������Դ��
	 */
	public void initResource() {
		//ʵ��������textArea
		textArea = new NTextArea(this);
		//textAreaΪ������Դ,���빫����Դ����
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
