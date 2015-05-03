package com.cao.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class CaoMenuBar {

	public CaoMenuBar(Shell shell) {
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		mntmOpen.setText("Open");
		
		MenuItem mntmRecent = new MenuItem(menu_1, SWT.CASCADE);
		mntmRecent.setText("Recent");
		
		Menu menu_2 = new Menu(mntmRecent);
		mntmRecent.setMenu(menu_2);
		
		MenuItem mntmFilecfiletxt = new MenuItem(menu_2, SWT.NONE);
		mntmFilecfiletxt.setText("file:c//file1.txt");
		
		MenuItem mntmFilecfiletxt_1 = new MenuItem(menu_2, SWT.NONE);
		mntmFilecfiletxt_1.setText("file:c//file2.txt");
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.setText("Exit");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		Menu menu_3 = new Menu(mntmEdit);
		mntmEdit.setMenu(menu_3);
		
		MenuItem mntmUndo = new MenuItem(menu_3, SWT.NONE);
		mntmUndo.setText("Undo");
		
		MenuItem mntmRedo = new MenuItem(menu_3, SWT.NONE);
		mntmRedo.setText("Redo");
		
		MenuItem mntmSave = new MenuItem(menu_3, SWT.NONE);
		mntmSave.setText("Save");
		
		MenuItem mntmCut = new MenuItem(menu_3, SWT.NONE);
		mntmCut.setText("Cut");
		
		MenuItem mntmCopy = new MenuItem(menu_3, SWT.NONE);
		mntmCopy.setText("Copy");
		
		MenuItem mntmPaste = new MenuItem(menu_3, SWT.NONE);
		mntmPaste.setText("Paste");

	}
	

}
