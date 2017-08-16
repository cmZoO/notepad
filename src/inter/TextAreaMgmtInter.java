package inter;

import bean.NTextArea;

/**
 * 文本域操作接口
 * @author zx583
 *
 */
public interface TextAreaMgmtInter {
	/**
	 * 获取当前使用的文本域
	 */
	public NTextArea getUsingTextArea();
	
	/**
	 * 设置当前使用文本域
	 */
	public void setUsingTextArea(NTextArea textArea);
}
