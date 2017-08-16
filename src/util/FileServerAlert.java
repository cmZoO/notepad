package util;

import java.awt.Component;

import server.FileServer;

public class FileServerAlert {
	public static void showErrorMessage(int errorCode, Component relativeTo) {
		switch (errorCode) {
		case FileServer.fileNotExists:
			AlertWindows.showMessageDialog(relativeTo, "文件不存在");
			break;
		default:
			break;
		}
	}
}
