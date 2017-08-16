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
 * textArea自身的监听逻辑
 * 		继承KeyAdapter监听键盘操作
 * 		实现DropTargetListener接口实现文件拖拽打开操作
 * 属性
 * 		textArea  			操作的文本域对象
 * 		resourceMgmt		公有资源接口
 * 		dropTarget			用于使组件与拖拽功能相连
 * 		rightPopupMenu		右键菜单
 * 		fileServer 			文件服务
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
	 * 通过公有资源接口对textArea,resourceMgmt实例化,注册dropTarget
	 * 注册快捷键逻辑
	 * @param resourceMgmt		公有资源接口
	 */
	public TextAreaListener(final ResourceMgmt resourceMgmt) {
		super();
		this.resourceMgmt = resourceMgmt;
		this.rightPopupMenu = (RightPopupMenu) resourceMgmt.getAResource("RightPopupMenu_rightPopupMenu");
		this.fileServer = (FileServer)resourceMgmt.getAResource("fileServer");
		this.textArea = (NTextArea) resourceMgmt.getAResource("NTextArea_textArea");
		//注册DropTarget，并将它与组件相连，处理哪个组件的相连    
        //即连通组件（textArea）和Listener(this)    
		this.dropTarget = new DropTarget(textArea, DnDConstants.ACTION_COPY_OR_MOVE, this);
		
//		//注册control + z为撤销
//		textArea.getActionMap().put("Undo", new AbstractAction("Undo") {
//			public void actionPerformed(ActionEvent evt) {
//				textArea.undo();
//		    }
//		});
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Z"), "Undo");
//		
//		//注册control + s为保存
//		textArea.getActionMap().put("Save", new AbstractAction("Save") {
//			public void actionPerformed(ActionEvent evt) {
//				((JMenuItem) resourceMgmt.getAResource("JMenuItem_save")).doClick();
//			}
//		});
//				 
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control S"), "Save");
//		 
//		//注册control + y为重做
//		textArea.getActionMap().put("Redo", new AbstractAction("Redo") {
//			public void actionPerformed(ActionEvent evt) {
//				textArea.redo();
//			}
//		});
//		 
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control Y"), "Redo");
//		
//		//注册control + f为查找
//		textArea.getActionMap().put("search", new AbstractAction("search") {
//			public void actionPerformed(ActionEvent evt) {
//				new StrSearchServer(textArea);
//			}
//		});
//
//		textArea.getInputMap().put(KeyStroke.getKeyStroke("control F"), "search");
	
	}

	//拖拽动作鼠标放开
	public void drop(DropTargetDropEvent dtde) {
		// 文本拖拽打开操作
		// 判断当前文本域内是否有未保存的内容
		if (!textArea.isSaved()) {
			// 存在未保存内容,弹窗警告
			if (!AlertWindows.showConfirmDialog(textArea.getFrame(), "继续操作可能会导致文档丢失",
					"警告:当前文档未保存")) {
				// 取消事件操作
				dtde.rejectDrop();
				return;
			}
		}

		//如果拖入的文件格式受支持
		if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
			try {
				dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);//接收拖拽来的数据
				Transferable tr = dtde.getTransferable();
				Object obj = tr.getTransferData(DataFlavor.javaFileListFlavor);
				List<File> files = (List<File>) obj;
				// 判断拖拽的文件的后缀是否合法
				for (FileFilter filter : new NFileChooser().getChoosableFileFilters()) {
					//同时拖拽多个只打开第一个文件
					if (files.get(0).getName().endsWith(filter.getDescription().replace("*", ""))) {
						// 监测到拖拽的文件合法
						File file = files.get(0);
						
						int result = fileServer.open(file, textArea);
						
						if (result != FileServer.success) {
							FileServerAlert.showErrorMessage(result, textArea.getFrame());
						}
						
						dtde.dropComplete(true);
						return;
					}
				}

				// 拖拽的文件与所有合法选项都不匹配，提示
				AlertWindows.showMessageDialog(textArea.getFrame(), "不支持的文件类型");
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
