package bean;

import java.io.File;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/**
 * �ļ�������
 * ����
 * 		Description  Ҫ���˵��ļ��ĺ�׺��
 * @author zx583
 *
 */
public class AutoFileFilter extends FileFilter {
	private String Description;
	
	/**
	 * ͨ�����γ�ʼ������
	 * @param Description
	 */
	public AutoFileFilter(String Description) {
		super();
		//ֱ�Ӵ��ζ�Description����ʵ����
		this.Description = Description;
	}
	
	/**
	 * ���ܵ��ļ�
	 * 		�ļ���
	 * 		��׺ΪDescription���ļ�
	 */
	public boolean accept(File f) {
		//�����ļ���
		if (f.isDirectory()) return true;
		
		//���ܺ�׺ΪDescription���ļ�
		return f.getName().toLowerCase().endsWith(Description);
	}

	/**
     * The description of this filter. For example: "JPG and GIF Images"
     * @see FileView#getName
     */
	public String getDescription() {
		//ͨ��Description���췵��ֵ
		return "*" + Description;
	}

}
