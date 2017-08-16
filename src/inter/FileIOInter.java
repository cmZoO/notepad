package inter;

import java.io.File;
import java.util.ArrayList;

/**
 * �ļ�IO�����ӿ�
 * 	����
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
	 * �����ļ���ȡ����
	 * @param file	��ȡ���ļ�
	 * @return		��ȡ��������
	 */
	public ArrayList<String> readCharFile(File file);
	
	/**
	 * �����ļ�·������ȡ����
	 * @param fileName		��ȡ���ļ�·����
	 * @return				��ȡ��������
	 */
	public ArrayList<String> readCharFile(String fileName);
	
	/**
	 * �����ļ���ָ�����ַ�����ȡ����
	 * @param file			��ȡ���ļ�
	 * @param charset		ʹ�õ��ַ���
	 * @return				��ȡ��������
	 */
	public ArrayList<String> readCharFile(File file, String charset);
	
	/**
	 * �����ļ�·������ָ�����ַ�����ȡ����
	 * @param fileName		�ļ�·����
	 * @param charset		ʹ�õ��ַ���
	 * @return				��ȡ��������
	 */
	public ArrayList<String> readCharFile(String fileName, String charset);

	/**
	 * �����ļ�д����
	 * @param file			д�����ļ�
	 * @param data			д��������
	 * @return				д�������ɹ����
	 */
	public boolean wirteCharFile(File file, String[] data);
	
	/**
	 * �����ļ�·����д����
	 * @param file			д�����ļ�·����
	 * @param data			д��������
	 * @return				д�������ɹ����
	 */
	public boolean wirteCharFile(String fileName, String[] data);
	
	/**
	 * �����ļ���ָ�����ַ���д����
	 * @param file			д�����ļ�
	 * @param data			д��������
	 * @param charset		д��ָ�����ַ���
	 * @return				д�������ɹ����
	 */
	public boolean wirteCharFile(File file, String[] data, String charset);
	
	/**
	 * �����ļ�·������ָ�����ַ���д����
	 * @param file			д�����ļ�
	 * @param data			д��������
	 * @param charset		д��ָ�����ַ���
	 * @return				д�������ɹ����
	 */
	public boolean wirteCharFile(String fileName, String[] data, String charset);
}
