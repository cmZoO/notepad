package inter;

/**
 * 重做撤销功能接口
 * @author zx583
 *
 */
public interface UndoRedoInter {

	/**
	 * 清除undo/redo数据
	 */
	public void clearUndoRedo();
	
	/**
	 * 判断当前文本域可否Redo操作
	 * @return	判断的结果
	 */
	public boolean canRedo();
	
	/**
	 * 判断当前文本域可否Undo操作
	 * @return	判断的结果
	 */
	public boolean canUndo() ;
	
	/**
	 * 对当前文本域进行undo操作
	 */
	public void undo();
	
	/**
	 * 对当前文本域进行redo操作
	 */
	public void redo();
	
}
