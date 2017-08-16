package inter;

/**
 * 基础编辑功能判断接口
 * @author zx583
 *
 */
public interface BaseEditableInter {
	
	/**
	 * 判断当前文本域可否复制操作
	 * @return	判断的结果
	 */
	public boolean canCopy();
	
	/**
	 * 判断当前文本域可否剪切操作
	 * @return	判断的结果
	 */
	public boolean canCut();
	
	/**
	 * 判断当前文本域可否粘贴操作
	 * @return	判断的结果
	 */
	public boolean canPaste();
	
}
