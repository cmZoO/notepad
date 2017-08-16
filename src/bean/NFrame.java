package bean;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.HashMap;

import javax.swing.JFrame;

import inter.ResourceMgmt;

/**
 * 自定义JFrame  实现ResourceMgmt接口
 * 增加属性 
 * 		resource  属性集
 * 增加方法
 * 		各属性的getter,setter方法
 * 		public void init()
 * 		接口中未定义的方法
 * @author zx583
 *
 */
public class NFrame extends JFrame implements ResourceMgmt{
	
	private HashMap<String, Object> resource;

	public NFrame() throws HeadlessException {
		super();
		
		NFrameInit();
	}

	public NFrame(GraphicsConfiguration gc) {
		super(gc);
		
		NFrameInit();
	}

	public NFrame(String title) throws HeadlessException {
		super(title);
		
		NFrameInit();
	}

	public NFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		
		NFrameInit();
	}

	/**
	 * 初始化函数
	 * 
	 */
	private void NFrameInit() {
		this.resource = new HashMap<String, Object>();
	}

	/**
	 * resource集的getter方法
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> getResource() {
		return resource;
	}

	/**
	 * resource集的setter方法
	 * @param resource 新的resource
	 */
	public void setResource(HashMap<String, Object> resource) {
		this.resource = resource;
	}
	
	/**
	 * 得到resource集里key为name的value
	 * @param name 要取得value的key值
	 * @return 要取得value
	 */
	public Object getAResource(String name) {
		return this.resource.get(name);
	}
	
	/**
	 * 为resource集添加一个资源resource
	 * @param name	添加的资源resource的名字 约定格式为(资源的类名_资源的标识)
	 * @param value	添加的资源resource的属性
	 * @return	标志是否添加成功 true成功 false失败  当集合中已经存在命名为name的资源时添加失败
	 */
	public boolean setAResource(String name, Object value) {
		
		//可行性判断,对于已存在的name进行拒绝
		if (this.resource.containsKey(name)) return false;
		
		this.resource.put(name, value);
		
		return true;
	}
	
	/**
	 * 替换resource集中名为name的value值
	 * @param name	要替换的资源resource的名字
	 * @param value	要替换原值得值
	 * @return	返回被替换的值
	 */
	public Object replaceAResource(String name, Object value) {
		return this.resource.put(name, value);
	}
}
