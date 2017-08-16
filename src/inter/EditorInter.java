package inter;

/**
 * �༭���ܽӿ�
 * @author zx583
 *
 */
public interface EditorInter {
	/**
	 * �Ƿ�ɼ���
	 */
	public boolean canCut();
	
	/**
	 * �Ƿ�ɸ���
	 */
	public boolean canCopy();
	
	/**
	 * �Ƿ��ճ��
	 */
	public boolean canPaste();
	
	/**
	 * �Ƿ�ɳ���
	 */
	public boolean canUndo();
	
	/**
	 * �Ƿ������
	 */
	public boolean canRedo();
	
	/**
	 * ����
	 */
	public void cut();
	
	/**
	 * ����
	 */
	public void copy();
	
	/**
	 * ճ��
	 */
	public void paste();
	
	/**
	 * ����
	 */
	public void redo();
	
	/**
	 * ����
	 */
	public void undo();
	
	/**
	 * ȫѡ
	 */
	public void selectAll();
	
	/**
	 * ����ʱ��/����
	 */
	public void addTime();
	
	/**
	 * ����
	 */
	public void search();
}
