package inter;

/**
 * 编辑功能接口
 * @author zx583
 *
 */
public interface EditorInter {
	/**
	 * 是否可剪切
	 */
	public boolean canCut();
	
	/**
	 * 是否可复制
	 */
	public boolean canCopy();
	
	/**
	 * 是否可粘贴
	 */
	public boolean canPaste();
	
	/**
	 * 是否可撤销
	 */
	public boolean canUndo();
	
	/**
	 * 是否可重做
	 */
	public boolean canRedo();
	
	/**
	 * 剪切
	 */
	public void cut();
	
	/**
	 * 复制
	 */
	public void copy();
	
	/**
	 * 粘贴
	 */
	public void paste();
	
	/**
	 * 重做
	 */
	public void redo();
	
	/**
	 * 撤销
	 */
	public void undo();
	
	/**
	 * 全选
	 */
	public void selectAll();
	
	/**
	 * 增加时间/日期
	 */
	public void addTime();
	
	/**
	 * 查找
	 */
	public void search();
}
