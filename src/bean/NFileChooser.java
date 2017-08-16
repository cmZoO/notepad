package bean;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import bean.AutoFileFilter;

/**
 * 自定义JFileChooser
 * 只允许 html 与 txt
 * @author zx583
 *
 */
public class NFileChooser extends JFileChooser {
	public NFileChooser() {
		super();

		FileFilter htmlFilter = new AutoFileFilter(".html");
		FileFilter txtFilter = new AutoFileFilter(".txt");
		addChoosableFileFilter(htmlFilter); 
		addChoosableFileFilter(txtFilter); 
	
		setFileFilter(txtFilter);
	}

}