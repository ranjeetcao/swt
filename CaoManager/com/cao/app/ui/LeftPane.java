package com.cao.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

public class LeftPane extends Composite {
	private LeftTopPane leftTopPane;
	private LeftBottomPane leftBottomPane;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LeftPane(Composite parent, int style) {
		super(parent, style);
		GridData gd_leftTopPane = new GridData(SWT.LEFT, SWT.FILL, false, true, 1, 1);
		gd_leftTopPane.widthHint = 240;
		setLayoutData(gd_leftTopPane);
		setLayout(UIFactory.getGridLayout(1));
		
		leftTopPane = new LeftTopPane(this, SWT.NONE);
		leftBottomPane = new LeftBottomPane(this, SWT.NONE);
	}
	
	public int getwidthHint() {
		return 240;
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
