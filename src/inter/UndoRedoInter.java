package inter;

/**
 * �����������ܽӿ�
 * @author zx583
 *
 */
public interface UndoRedoInter {

	/**
	 * ���undo/redo����
	 */
	public void clearUndoRedo();
	
	/**
	 * �жϵ�ǰ�ı���ɷ�Redo����
	 * @return	�жϵĽ��
	 */
	public boolean canRedo();
	
	/**
	 * �жϵ�ǰ�ı���ɷ�Undo����
	 * @return	�жϵĽ��
	 */
	public boolean canUndo() ;
	
	/**
	 * �Ե�ǰ�ı������undo����
	 */
	public void undo();
	
	/**
	 * �Ե�ǰ�ı������redo����
	 */
	public void redo();
	
}
