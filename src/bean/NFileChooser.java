package bean;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import bean.AutoFileFilter;

/**
 * �Զ���JFileChooser
 * ֻ���� html �� txt
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