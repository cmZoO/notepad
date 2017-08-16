package bean;

import java.io.File;

import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

/**
 * 文件过滤器
 * 属性
 * 		Description  要过滤的文件的后缀名
 * @author zx583
 *
 */
public class AutoFileFilter extends FileFilter {
	private String Description;
	
	/**
	 * 通过传参初始化对象
	 * @param Description
	 */
	public AutoFileFilter(String Description) {
		super();
		//直接传参对Description进行实例化
		this.Description = Description;
	}
	
	/**
	 * 接受的文件
	 * 		文件夹
	 * 		后缀为Description的文件
	 */
	public boolean accept(File f) {
		//接受文件夹
		if (f.isDirectory()) return true;
		
		//接受后缀为Description的文件
		return f.getName().toLowerCase().endsWith(Description);
	}

	/**
     * The description of this filter. For example: "JPG and GIF Images"
     * @see FileView#getName
     */
	public String getDescription() {
		//通过Description构造返回值
		return "*" + Description;
	}

}
