package com.cao.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabItem;

public class RightPane extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RightPane(Composite parent, int style) {
		super(parent, style);
		setLayoutData(UIFactory.getGridLayoutData());
		setLayout(new GridLayout(1, false));
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		tabFolder.setLayoutData(UIFactory.getGridLayoutData());
		
		TabItem tbtmDetails = new TabItem(tabFolder, SWT.NONE);
		tbtmDetails.setText("details");
		
		TabItem tbtmBackgroud = new TabItem(tabFolder, SWT.NONE);
		tbtmBackgroud.setText("backgroud");
		
		TabItem tbtmEducation = new TabItem(tabFolder, SWT.NONE);
		tbtmEducation.setText("education");
		
		TabItem tbtmExperience = new TabItem(tabFolder, SWT.NONE);
		tbtmExperience.setText("experience");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
