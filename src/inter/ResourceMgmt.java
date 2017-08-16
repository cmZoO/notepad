package inter;

/**
 * HashMap(String, Object)����resource���ԵĹ���ӿ�
 * 		��������
 * 			public Object getAResource(String name);
 * 			public boolean setAResource(String name, Object value);
 * 			public Object replaceAResource(String name, Object value);
 * @author zx583
 *
 */
public interface ResourceMgmt {

	/**
	 * �õ�resource����keyΪname��value
	 * @param name Ҫȡ��value��keyֵ
	 * @return Ҫȡ��value
	 */
	public Object getAResource(String name);
	
	/**
	 * Ϊresource�����һ����Դresource
	 * @param name	��ӵ���Դresource������ Լ����ʽΪ(��Դ������_��Դ�ı�ʶ)
	 * @param value	��ӵ���Դresource������
	 * @return	��־�Ƿ���ӳɹ� true�ɹ� falseʧ��  ���������Ѿ���������Ϊname����Դʱ���ʧ��
	 */
	public boolean setAResource(String name, Object value);
	
	/**
	 * �滻resource������Ϊname��valueֵ
	 * @param name	Ҫ�滻����Դresource������
	 * @param value	Ҫ�滻ԭֵ��ֵ
	 * @return	���ر��滻��ֵ
	 */
	public Object replaceAResource(String name, Object value);
}
