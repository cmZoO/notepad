package inter;

import java.awt.Font;

/**
 * ���ù��ܽӿ�
 * @author zx583
 *
 */
public interface ConfigInter {
	/**
	 * ʹ��UTF-8����
	 */
	public int useUTF(boolean force);
	
	/**
	 * ʹ��GBK����
	 */
	public int useGBK(boolean force);
	
	/**
	 * ��������
	 */
	public void setFont();
}
