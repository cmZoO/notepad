package server;

import java.text.SimpleDateFormat;
import java.util.Date;

import bean.NTextArea;
import inter.EditorInter;
import inter.ResourceMgmt;
import util.StrSearchDialog;
import util.TextAreaUtil;

/**
 * 文件编辑服务
 * @author zx583
 *
 */
public class EditorServer implements EditorInter {
	private TextAreaMgmtServer textAreaServer;
	
	public EditorServer(ResourceMgmt resourceMgmt) {
		this.textAreaServer = (TextAreaMgmtServer) resourceMgmt.getAResource("textAreaServer");
	}
	
	//公有临时变量
	private NTextArea textArea;
	
	/**
	 * 剪切事务
	 */
	public void cut() {
		textAreaServer.getUsingTextArea().cut();
	}

	/**
	 * 复制事务
	 */
	public void copy() {
		textAreaServer.getUsingTextArea().copy();
	}

	/**
	 * 粘贴事务
	 */
	public void paste() {
		textAreaServer.getUsingTextArea().paste();
	}

	/**
	 * 重做事务
	 */
	public void redo() {
		textAreaServer.getUsingTextArea().redo();
	}

	/**
	 * undo事务
	 */
	public void undo() {
		textAreaServer.getUsingTextArea().undo();
	}

	/**
	 * 全选事务
	 */
	public void selectAll() {
		textAreaServer.getUsingTextArea().selectAll();
	}

	/**
	 * 添加时间事务
	 */
	public void addTime() {
		TextAreaUtil.insertToSelectPosition(textAreaServer.getUsingTextArea(),  new SimpleDateFormat("hh:mm:ss yyyy-MM-dd").format(new Date()).toString());
	}

	/**
	 * 查找事务
	 */
	public void search() {
		textArea = textAreaServer.getUsingTextArea();
		new StrSearchDialog(textArea, textArea.getFrame());
	}

	/**
	 * 判断能否剪切事务
	 */
	public boolean canCut() {
		
		return textAreaServer.getUsingTextArea().canCut();
	}

	/**
	 * 判断能否复制事务
	 */
	public boolean canCopy() {
		
		return textAreaServer.getUsingTextArea().canCopy();
	}

	/**
	 * 判断能否粘贴事务
	 */
	public boolean canPaste() {
		
		return textAreaServer.getUsingTextArea().canPaste();
	}

	/**
	 * 判断能否撤销事务
	 */
	public boolean canUndo() {
		
		return textAreaServer.getUsingTextArea().canUndo();
	}

	/**
	 * 判断能否重做事务
	 */
	public boolean canRedo() {
	
		return textAreaServer.getUsingTextArea().canRedo();
	}

}
