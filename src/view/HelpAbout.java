package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 帮助中的关于界面
 * 属性
 * 		image		关于界面上显示的图片
 * @author zx583
 *
 */
public class HelpAbout extends JPanel {
	private Image image;
	
	/**
	 * 构造函数中将iamge属性实例化
	 */
	public HelpAbout() {
		super();
	
		image = new ImageIcon("image" + File.separator + "image.jpg").getImage();
	}
	
	/**
	 * 重写paint
	 * 		将image显示到面板中
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		String a;
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
