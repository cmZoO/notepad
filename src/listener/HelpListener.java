package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import bean.NTextArea;
import inter.ResourceMgmt;
import view.HelpDialog;

/**
 * HelpMenu�����߼�
 * 		�Ե���¼�������Ӧ
 * @author zx583
 *
 */
public class HelpListener extends MouseAdapter {
	private ResourceMgmt resourceMgmt;
	
	public HelpListener(ResourceMgmt resourceMgmt) {
		super();

		this.resourceMgmt = resourceMgmt;
	}

	public void mouseClicked(MouseEvent e) {
		//�Ե���¼�������Ӧ����HelpFrame����
		new HelpDialog(((NTextArea)resourceMgmt.getAResource("NTextArea_textArea")).getFrame());
	}
}
