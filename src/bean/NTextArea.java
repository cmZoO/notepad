package bean;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;

import inter.TextAreaInter;

/**
 * 自定义的继承JTextArea的文本域类
 * 	实现	
 * 		DocumentListener接口		用于保存状态变更
 * 	新增属性
 * 		UndoManager		用于撤销与重做(未实现)
 * 		saved			标记文本域内的内容状态是否保存
 *  	file			表示当前文本域关联的文件
 *  	encoded			表示当前编码格式环境		默认值null
 *  	frame			上文框架
 *  	clip			系统剪切板对象
 *	新增方法
 *		接口未实现的方法
 *		各属性的getter和setter方法
 *		public void NTextAreaInit()
 *		public boolean newEdit()
 *		public boolean canRedo()
 *		public boolean canUndo()
 *		public boolean canCopy()
 *		public boolean canCut()
 *		public boolean canPaste()
 *		public void redo()
 *		public void undo()
 *		public void updateTitle();
 * @author zx583
 *
 */
public class NTextArea extends JTextArea implements DocumentListener, TextAreaInter {
	private UndoManager um = new UndoManager();
	private boolean saved;
	private File file;
	private String encoded;
	private JFrame frame;
	private Clipboard clip;
	
	public NTextArea(JFrame frame) {
		super();
		
		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, Document doc) {
		super(doc);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, int rows, int columns) {
		super(rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, String text, int rows, int columns) {
		super(text, rows, columns);

		NTextAreaInit(frame);
	}


	public NTextArea(JFrame frame, String text) {
		super(text);

		NTextAreaInit(frame);
	}

	/**
	 * 初始化函数，实例化各属性，编码格式环境置null
	 */
	public void NTextAreaInit(JFrame frame) {
		//实例化系统剪切板对象
		clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		//实例化上文框架
		this.frame = frame;
		
		//默认文本创建时为空且已保存状态
		this.saved = true;
		
		//给file赋初值null
		this.file = null;
					
		//注册UndoManager
		this.getDocument().addUndoableEditListener(new UndoableEditListener() {
				public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});
		
		//
		this.getDocument().addDocumentListener(this);
		
		//编码格式默认null
		this.encoded = null;
		
		//设置Tab的大小
		setTabSize(4);
    }

	
	/**
	 * UndoManager的getter方法
	 * @return		文本域绑定的UndoManager实例
	 */
	public UndoManager getUm() {
		return um;
	}

	/**
	 * UndoManager的setter方法
	 * @param um		用于取代的新UndoManager实例
	 */
	public void setUm(UndoManager um) {
		this.um = um;
	}

	/**
	 * saved的setter方法
	 * @param saved		新的saved值
	 */
	public void setSaved(boolean saved) {
		this.saved = saved;
		
		updateTitle();
	}
	
	/**
	 * 更新frame窗口标题,为其增加状态提示
	 */
	public void updateTitle() {
		//设置标题提示
		String s, n, e;

		s = (isSaved() ? "" : "*");
		n = (getFile() == null ? "" : getFile().getName());
		e = (getEncoded() == null ? "" : "(" + getEncoded() + ")");

		frame.setTitle(s + n + e);
	}

	/**
	 * saved的getter方法
	 * @return		saved的值
	 */
	public boolean isSaved() {
		return saved;
	}

	/**
	 * 初始化文本域为空
	 */
	public void clearEdit() {
		//如果文本还没进行过输入，直接返回
		if (!um.canUndoOrRedo() && file == null) return;

		//设置文本域为空文本
		setText("");
		
		//清除UndoManager记录
		um.discardAllEdits();
		
		//取消textArea的file文件关联
		setFile(null);
		
		//重置当前编码环境
		setEncoded(null);
		
		//设置文本域为已保存状态
		setSaved(true);
		
		updateTitle();
		
		return;
	}
	
	/**
	 * 清除文本域附属状态
	 */
	public void clearState() {
		//取消textArea的file文件关联
		setFile(null);
				
		//重置当前编码环境
		setEncoded(null);	
		
		//清除undo/redo数据
		clearUndoRedo();
		
		//设置文本域为已保存状态
		setSaved(true);
		
		updateTitle();
	}
	
	/**
	 * 清除undo/redo数据
	 */
	public void clearUndoRedo() {
		//清除UndoManager记录
		um.discardAllEdits();
	}

	/**
	 * 判断当前文本域可否Redo操作
	 * @return	判断的结果
	 */
	public boolean canRedo() {
		return um.canRedo();
	}
	
	/**
	 * 判断当前文本域可否Undo操作
	 * @return	判断的结果
	 */
	public boolean canUndo() {
		return um.canUndo();
	}
	
	/**
	 * 判断当前文本域可否复制操作
	 * @return	判断的结果
	 */
	public boolean canCopy() {
		return getSelectedText() != null ;
	}
	
	/**
	 * 判断当前文本域可否剪切操作
	 * @return	判断的结果
	 */
	public boolean canCut() {
		return canCopy();
	}
	
	/**
	 * 判断当前文本域可否粘贴操作
	 * @return	判断的结果
	 */
	public boolean canPaste() {
		Transferable clipT = clip.getContents(null);
		
		return clipT != null && clipT.isDataFlavorSupported(DataFlavor.stringFlavor);
	}
	
	/**
	 * 对当前文本域进行redo操作
	 */
	public void redo() {
		if (um.canRedo())	um.redo();
	}
	
	/**
	 * 对当前文本域进行undo操作
	 */
	public void undo() {
		if (um.canUndo())	um.undo();
	}
	
	/**
	 * file的getter方法
	 * @return		file实例
	 */
	public File getFile() {
		return file;
	}

	/**
	 * file的setter方法
	 * @param file		新的file实例
	 */
	public void setFile(File file) {
		this.file = file;
		
		updateTitle();
	}

	/**
	 * frame的getter方法
	 * @param frame实例
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * frame的setter方法
	 * @param frame		新的frame实例
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	/**
	 * 编码格式环境encoded的getter方法
	 * @return	当前编码格式环境
	 */
	public String getEncoded() {
		return encoded;
	}

	/**
	 * 编码格式环境encoded的setter方法
	 * @param encoded	新的编码格式环境
	 */
	public void setEncoded(String encoded) {
		this.encoded = encoded;
		
		updateTitle();
	}


	/**
	 * DocumentListener方法
	 * 响应文本插入变更
	 */
	public void insertUpdate(DocumentEvent e) {
		setSaved(false);
//		System.out.println("增加");
	}

	/**
	 * DocumentListener方法
	 * 响应文本移除变更
	 */
	public void removeUpdate(DocumentEvent e) {
		setSaved(false);
//		System.out.println("移除");
	}

	/**
	 * DocumentListener方法
	 * 响应文本属性的变化
	 */
	public void changedUpdate(DocumentEvent e) {
		
	}
}
