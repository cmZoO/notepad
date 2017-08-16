package listener;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.filechooser.FileFilter;

import bean.NFileChooser;
import bean.NTextArea;
import inter.ResourceMgmt;
import server.FileIOServer;
import server.FileServer;
import util.AlertWindows;
import util.FileServerAlert;
import util.TextAreaUtil;
import view.RightPopupMenu;

/**
 * textArea����ļ����߼�
 * 		�̳�KeyAdapter�������̲���
 * 		ʵ��DropTargetListener�ӿ�ʵ���ļ���ק�򿪲���
 * ����
 * 		textArea  			�������ı������
 * 		resourceMgmt		������Դ�ӿ�
 * 		dropTarget			����ʹ�������ק��������
 * 		rightPopupMenu		�Ҽ��˵�
 * 		fileServer 			�ļ�����
 * @author zx583
 *
 */
public class TextAreaListener extends DropTargetAdapter implements MouseListener {
	private NTextArea textArea;
	private ResourceMgmt resourceMgmt;
	private DropTarget dropTarget; 
	private FileServer fileServer;
	private RightPopupMenu rightPopupMenu;
	
	/**
	 * ͨ��������Դ�ӿڶ�textArea,resourceMgmtʵ����,ע��dropTarget
	 * ע���ݼ��߼�
	 * @param resourceMgmt		������Դ�ӿ�
	 */
	public TextAreaListener(final ResourceMgmt resourceMgmt) {
		super();
		this.resourceMgmt = resourceMgmt;
		this.rightPopupMenu = (RightPopupMenu) resourceMgmt.getAResource("RightPopupMenu_rightPopupMenu");
		this.fileServer = (FileServer)resourceMgmt.getAResource("fileServer");
		this.textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
		//ע��DropTarget������������������������ĸ����������    
        //����ͨ�����textArea����Listener(this)    
		this.dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, this);
		
//		//ע��control + zΪ����
//		textArea.getActionMap().put("Undo", new AbstractAction("Undo") {
//			public void actionPerformed(ActionEvent evt) {
//				textArea.undo();
//		    }
//		});
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
//		
//		//ע��control + sΪ����
//		textArea.getActionMap().put("Save", new AbstractAction("Save") {
//			public void actionPerformed(ActionEvent evt) {
//				((JMenuItem) resourceMgmt.getAResource("JMenuItem_save")).doClick();
//			}
//		});
//				 
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control S"), "Save");
//		 
//		//ע��control + yΪ����
//		textArea.getActionMap().put("Redo", new AbstractAction("Redo") {
//			public void actionPerformed(ActionEvent evt) {
//				textArea.redo();
//			}
//		});
//		 
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
//		
//		//ע��control + fΪ����
//		textArea.getActionMap().put("search", new AbstractAction("search") {
//			public void actionPerformed(ActionEvent evt) {
//				new StrSearchServer(textArea);
//			}
//		});
//
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control F"), "search");
	
	}

	//��ק�������ſ�
	public void drop(DropTargetDropEvent dtde) {
		// �ı���ק�򿪲���
		// �жϵ�ǰ�ı������Ƿ���δ���������
		if (!textArea.isSaved()) {
			// ����δ��������,��������
			if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "�����������ܻᵼ���ĵ���ʧ",
					"����:��ǰ�ĵ�δ����")) {
				// ȡ���¼�����
				dtde.rejectDrop();
				return;
			}
		}

		//���������ļ���ʽ��֧��
		if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			try {
				dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//������ק��������
				Transferable tr = dtde.getTransferable();
				Object obj = tr.getTransferData(DataFlavor.javaFileListFlavor);
				List<File> files = (List<File>) obj;
				// �ж���ק���ļ��ĺ�׺�Ƿ�Ϸ�
				for (FileFilter filter : new NFileChooser().getChoosableFileFilters()) {
					//ͬʱ��ק���ֻ�򿪵�һ���ļ�
					if (files.get(0).getName().endsWith(filter.getDescription().replace("*", ""))) {
						// ��⵽��ק���ļ��Ϸ�
						File file = files.get(0);
						
						int result = fileServer.open(file, textArea);
						
						if (result != FileServer.success) {
							FileServerAlert.showErrorMessage(result, textArea.getFrame());
						}
						
						dtde.dropComplete(true);
						return;
					}
				}

				// ��ק���ļ������кϷ�ѡ���ƥ�䣬��ʾ
				AlertWindows.showMessageDialog(textArea.getFrame(), "��֧�ֵ��ļ�����");
				dtde.dropComplete(false);
				
				
				
			} catch (UnsupportedFlavorException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			rightPopupMenu.show(textArea, e.getX(), e.getY());
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}


}
