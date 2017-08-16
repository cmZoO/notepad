package inter;

import java.io.File;
import java.util.ArrayList;

/**
 * 文件IO操作接口
 * 	方法
 * 		public ArrayList<String> readCharFile(File file);
 * 		public ArrayList<String> readCharFile(String fileName);
 * 		public ArrayList<String> readCharFile(File file, String charset);
 * 		public ArrayList<String> readCharFile(String fileName, String charset);
 * 		public boolean wirteCharFile(File file, String[] data);
 * 		public boolean wirteCharFile(String fileName, String[] data);
 * 		public boolean wirteCharFile(File file, String[] data, String charset);
 * 		public boolean wirteCharFile(String fileName, String[] data, String charset);
 * @author zx583
 *
 */
public interface FileIOInter {
	/**
	 * 根据文件读取数据
	 * @param file	读取的文件
	 * @return		读取出的数据
	 */
	public ArrayList<String> readCharFile(File file);
	
	/**
	 * 根据文件路径名读取数据
	 * @param fileName		读取的文件路径名
	 * @return				读取出的数据
	 */
	public ArrayList<String> readCharFile(String fileName);
	
	/**
	 * 根据文件与指定的字符集读取数据
	 * @param file			读取的文件
	 * @param charset		使用的字符集
	 * @return				读取出的数据
	 */
	public ArrayList<String> readCharFile(File file, String charset);
	
	/**
	 * 根据文件路径名与指定的字符集读取数据
	 * @param fileName		文件路径名
	 * @param charset		使用的字符集
	 * @return				读取出的数据
	 */
	public ArrayList<String> readCharFile(String fileName, String charset);

	/**
	 * 根据文件写数据
	 * @param file			写出的文件
	 * @param data			写出的数据
	 * @return				写出操作成功与否
	 */
	public boolean wirteCharFile(File file, String[] data);
	
	/**
	 * 根据文件路径名写数据
	 * @param file			写出的文件路径名
	 * @param data			写出的数据
	 * @return				写出操作成功与否
	 */
	public boolean wirteCharFile(String fileName, String[] data);
	
	/**
	 * 根据文件与指定的字符集写数据
	 * @param file			写出的文件
	 * @param data			写出的数据
	 * @param charset		写出指定的字符集
	 * @return				写出操作成功与否
	 */
	public boolean wirteCharFile(File file, String[] data, String charset);
	
	/**
	 * 根据文件路径名与指定的字符集写数据
	 * @param file			写出的文件
	 * @param data			写出的数据
	 * @param charset		写出指定的字符集
	 * @return				写出操作成功与否
	 */
	public boolean wirteCharFile(String fileName, String[] data, String charset);
}
