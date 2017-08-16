package inter;

/**
 * HashMap(String, Object)类型resource属性的管理接口
 * 		包含方法
 * 			public Object getAResource(String name);
 * 			public boolean setAResource(String name, Object value);
 * 			public Object replaceAResource(String name, Object value);
 * @author zx583
 *
 */
public interface ResourceMgmt {

	/**
	 * 得到resource集里key为name的value
	 * @param name 要取得value的key值
	 * @return 要取得value
	 */
	public Object getAResource(String name);
	
	/**
	 * 为resource集添加一个资源resource
	 * @param name	添加的资源resource的名字 约定格式为(资源的类名_资源的标识)
	 * @param value	添加的资源resource的属性
	 * @return	标志是否添加成功 true成功 false失败  当集合中已经存在命名为name的资源时添加失败
	 */
	public boolean setAResource(String name, Object value);
	
	/**
	 * 替换resource集中名为name的value值
	 * @param name	要替换的资源resource的名字
	 * @param value	要替换原值得值
	 * @return	返回被替换的值
	 */
	public Object replaceAResource(String name, Object value);
}
