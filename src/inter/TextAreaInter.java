package inter;

/**
 * TextArea功能接口
 * @author zx583
 *
 */
public interface TextAreaInter extends UndoRedoInter, BaseEditableInter {
	
	/**
	 * 更新frame窗口标题,为其增加状态提示
	 */
	public void updateTitle();
	
	/**
	 * 完全清空文本域
	 */
	public void clearEdit();
	
	/**
	 * 清除文本域附属状态
	 */
	public void clearState();
	
}
