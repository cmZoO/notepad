package inter;

/**
 * TextArea���ܽӿ�
 * @author zx583
 *
 */
public interface TextAreaInter extends UndoRedoInter, BaseEditableInter {
	
	/**
	 * ����frame���ڱ���,Ϊ������״̬��ʾ
	 */
	public void updateTitle();
	
	/**
	 * ��ȫ����ı���
	 */
	public void clearEdit();
	
	/**
	 * ����ı�����״̬
	 */
	public void clearState();
	
}
