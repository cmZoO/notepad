package bean;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.util.HashMap;

import javax.swing.JFrame;

import inter.ResourceMgmt;

/**
 * �Զ���JFrame  ʵ��ResourceMgmt�ӿ�
 * �������� 
 * 		resource  ���Լ�
 * ���ӷ���
 * 		�����Ե�getter,setter����
 * 		public void init()
 * 		�ӿ���δ����ķ���
 * @author zx583
 *
 */
public class NFrame extends JFrame implements ResourceMgmt{
	
	private HashMap<String, Object> resource;

	public NFrame() throws HeadlessException {
		super();
		
		NFrameInit();
	}

	public NFrame(GraphicsConfiguration gc) {
		super(gc);
		
		NFrameInit();
	}

	public NFrame(String title) throws HeadlessException {
		super(title);
		
		NFrameInit();
	}

	public NFrame(String title, GraphicsConfiguration gc) {
		super(title, gc);
		
		NFrameInit();
	}

	/**
	 * ��ʼ������
	 * 
	 */
	private void NFrameInit() {
		this.resource = new HashMap<String, Object>();
	}

	/**
	 * resource����getter����
	 * @return HashMap<String, Object>
	 */
	public HashMap<String, Object> getResource() {
		return resource;
	}

	/**
	 * resource����setter����
	 * @param resource �µ�resource
	 */
	public void setResource(HashMap<String, Object> resource) {
		this.resource = resource;
	}
	
	/**
	 * �õ�resource����keyΪname��value
	 * @param name Ҫȡ��value��keyֵ
	 * @return Ҫȡ��value
	 */
	public Object getAResource(String name) {
		return this.resource.get(name);
	}
	
	/**
	 * Ϊresource�����һ����Դresource
	 * @param name	��ӵ���Դresource������ Լ����ʽΪ(��Դ������_��Դ�ı�ʶ)
	 * @param value	��ӵ���Դresource������
	 * @return	��־�Ƿ���ӳɹ� true�ɹ� falseʧ��  ���������Ѿ���������Ϊname����Դʱ���ʧ��
	 */
	public boolean setAResource(String name, Object value) {
		
		//�������ж�,�����Ѵ��ڵ�name���оܾ�
		if (this.resource.containsKey(name)) return false;
		
		this.resource.put(name, value);
		
		return true;
	}
	
	/**
	 * �滻resource������Ϊname��valueֵ
	 * @param name	Ҫ�滻����Դresource������
	 * @param value	Ҫ�滻ԭֵ��ֵ
	 * @return	���ر��滻��ֵ
	 */
	public Object replaceAResource(String name, Object value) {
		return this.resource.put(name, value);
	}
}
