package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * �����еĹ��ڽ���
 * ����
 * 		image		���ڽ�������ʾ��ͼƬ
 * @author zx583
 *
 */
public class HelpAbout extends JPanel {
	private Image image;
	
	/**
	 * ���캯���н�iamge����ʵ����
	 */
	public HelpAbout() {
		super();
	
		image = new ImageIcon("image" + File.separator + "image.jpg").getImage();
	}
	
	/**
	 * ��дpaint
	 * 		��image��ʾ�������
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		String a;
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
