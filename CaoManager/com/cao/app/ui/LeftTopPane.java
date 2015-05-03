package com.cao.app.ui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import com.cao.app.widgets.VMenuBar;

public class LeftTopPane extends Composite {
	private Text txtFeelingGreat;

	public LeftTopPane(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_leftTopPane = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		setLayoutData(gd_leftTopPane);
		setLayout(new GridLayout(3, false));
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label label = new Label(this, SWT.BORDER);
		label.setAlignment(SWT.CENTER);
		label.setImage(SWTResourceManager.getImage("ranjeet.png"));
		
		Composite composite_1 = new Composite(this, SWT.NONE);
		composite_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_1.setLayout(new GridLayout(1, false));
		composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		Label lblRanjeetKumar = new Label(composite_1, SWT.NONE);
		lblRanjeetKumar.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		lblRanjeetKumar.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblRanjeetKumar.setText("Ranjeet Kumar");
		
		txtFeelingGreat = new Text(composite_1, SWT.NONE);
		txtFeelingGreat.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		txtFeelingGreat.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		txtFeelingGreat.setText("Feeling Good ...");
		txtFeelingGreat.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		ArrayList<String> data = new ArrayList<String>();
		data.add("Education");
		data.add("Work");
		data.add("Hobbies");
		
		final VMenuBar vMenuBar = new VMenuBar(this, SWT.NONE);
		vMenuBar.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		vMenuBar.setData("menus", data);
		vMenuBar.build();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
