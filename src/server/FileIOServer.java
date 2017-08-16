package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import inter.FileIOInter;

/**
 * 文件操作类		实现FileInter接口
 * 方法
 * 		接口里面所有未实现的方法
 * @author zx583
 *
 */
public class FileIOServer implements FileIOInter {
	public FileIOServer() {
		super();
	}

	/**
	 * 读取文件方法
	 * 
	 * FileName 读取的文件路径 charset 读取文件使用的字符集 置为null不使用自定义编码
	 * 
	 * 返回String集合 每个String表示一行 基于原文删去回车 出现错误时返回空集合
	 */
	public ArrayList<String> readCharFile(String fileName, String charset) {
		ArrayList<String> result = new ArrayList<String>();

		if (fileName == null)
			return result;

		return readCharFile(new File(fileName), charset);
	}

	/**
	 * 写入文件方法
	 * 
	 * fileName 写入的文件路径 
	 * data 写入的文件数据集合 每个String表示一行数据 无需携带回车符 
	 * charset 自定义写入文件的字符集 null表示不使用自定义字符集
	 * 
	 * 出现错误返回false 正常返回true
	 */
	public boolean wirteCharFile(String fileName, String[] data, String charset) {
		// TODO Auto-generated method stub
		if (fileName == null)
			return false;

		return wirteCharFile(new File(fileName), data, charset);
	}

	//
	// public static void main(String[] args) {
	// FileServer test = new FileServer();
	//
	// ArrayList<String> testData = new ArrayList<String>();
	// testData.add("测试");
	// testData.add("abc");
	// test.wirteFile("1.txt", testData, "utf-8");
	//
	// // System.out.println(test.readFile("1.txt", "gbk"));
	// test_outArray(test.readFile("1.txt", "utf-8"));
	// }
	//
	// public static void test_outArray(ArrayList<String> testData) {
	// for (String tmp : testData) {
	// System.out.println(tmp);
	// }
	// }

	/**
	 * 读取文件方法
	 * 
	 * file 读取的文件
	 * 
	 * 返回String集合 每个String表示一行 基于原文删去回车 出现错误时返回空集合
	 */
	public ArrayList<String> readCharFile(File file) {
		// TODO Auto-generated method stub
		return readCharFile(file, null);
	}

	/**
	 * 读取文件方法
	 * 
	 * FileName 读取的文件路径
	 * 
	 * 返回String集合 每个String表示一行 基于原文删去回车 出现错误时返回空集合
	 */
	public ArrayList<String> readCharFile(String fileName) {
		// TODO Auto-generated method stub
		return readCharFile(fileName, null);
	}

	/**
	 * 读取文件方法
	 * 
	 * file 读取的文件 charset 读取文件使用的字符集 置为null不使用自定义编码
	 * 
	 * 返回String集合 每个String表示一行 基于原文删去回车 出现错误时返回空集合
	 */
	public ArrayList<String> readCharFile(File file, String charset) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();

		if (file == null)
			return result;

		BufferedReader reader = null;
		try {
			if (charset != null) {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file), charset));
			} else {
				reader = new BufferedReader(new InputStreamReader(
						new FileInputStream(file)));
			}

			String tmp;

			// 使用readLine读取 剔除了原文的回车符
			// while ((tmp = reader.readLine()) != null) {
			// if (!tmp.equals("")) {
			// System.out.println(tmp);
			// int i = tmp.charAt(tmp.length()-1);
			// System.out.println(i);
			// result.add(tmp);
			// }
			//
			// }

			while ((tmp = reader.readLine()) != null) {
				result.add(tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ArrayList<String>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return new ArrayList<String>();
		} finally {
			if (reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		return result;
	}

	/**
	 * 写入文件方法
	 * 
	 * file 写入的文件
	 * data 写入的文件数据集合 每个String表示一行数据 无需携带回车符
	 * 
	 * 出现错误返回false 正常返回true
	 */
	public boolean wirteCharFile(File file, String[] data) {
		// TODO Auto-generated method stub
		return wirteCharFile(file, data, null);
	}

	/**
	 * 写入文件方法
	 * 
	 * fileName 写入的文件路径 
	 * data 写入的文件数据集合 每个String表示一行数据 无需携带回车符 
	 * 
	 * 出现错误返回false 正常返回true
	 */
	public boolean wirteCharFile(String fileName, String[] data) {
		// TODO Auto-generated method stub
		return wirteCharFile(fileName, data, null);
	}

	/**
	 * 写入文件方法
	 * 
	 * file 写入的文件
	 * data 写入的文件数据集合 每个String表示一行数据 无需携带回车符 
	 * charset 自定义写入文件的字符集 null表示不使用自定义字符集
	 * 
	 * 出现错误返回false 正常返回true
	 */
	public boolean wirteCharFile(File file, String[] data, String charset) {
		// TODO Auto-generated method stub
		if (file == null)
			return false;

		BufferedWriter writer = null;
		try {
			if (charset != null) {
				writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file), charset));
			} else {
				writer = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(file)));
			}

			for (String tmp : data) {
				writer.write(tmp);
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}
}
