package com.cao.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

public class CaoMainPageContainer extends Composite {
	private LeftPane leftPane;
	private RightPane rightPane;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public CaoMainPageContainer(Composite parent, int style) {
		super(parent, style);
		setLayoutData(UIFactory.getGridLayoutData());
		setLayout(UIFactory.getGridLayout(2));
		
		leftPane = new LeftPane(this, SWT.BORDER);
		rightPane = new RightPane(this, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public LeftPane getLeftPane() {
		return leftPane;
	}
	
	public RightPane getRightPane() {
		return rightPane;
	}
}
