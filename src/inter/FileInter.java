package inter;

import java.io.File;

import bean.NTextArea;

/**
 * 文件操作接口
 * @author zx583
 *
 */
public interface FileInter {
	/**
	 * 新建文件
	 */
	public int newFile(NTextArea textArea);
	
	/**
	 * 打开文件
	 */
	public int open(File file, NTextArea textArea);
	
	/**
	 * 保存文件
	 */
	public int save(File file, NTextArea textArea);
	
	/**
	 * 通过路径保存
	 */
	public int save(String path, NTextArea textArea);
	
	/**
	 * 通过路径打开
	 */
	public int open(String path, NTextArea textArea);
}
