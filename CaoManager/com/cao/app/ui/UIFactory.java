package com.cao.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

public class UIFactory {
	
	public static GridLayout getGridLayout(int numColumns) {
		GridLayout gridLayout = new GridLayout(numColumns, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		
		return gridLayout;
	}
	
	public static GridData getGridLayoutData() {
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		return gd;
	}
}
