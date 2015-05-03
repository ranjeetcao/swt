package com.cao.app.widgets.listadpater;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;

public class ContactLayout extends Composite {
	private Composite iconContainer;
	private Label contactIcon;
	private Composite userDetailContainer;
	private Label username;
	private Label phonenumber;
	private Composite sharedSizeContainer;
	private Label sharedSize;
	private Label label;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ContactLayout(Composite parent, int style, Contact contact) {
		super(parent, style);
//		contact = new Contact("Ranjeet", "9493556600", "323 KB");
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.verticalSpacing = 0;
		gridLayout.marginWidth = 0;
		gridLayout.horizontalSpacing = 0;
		gridLayout.marginHeight = 0;
		setLayout(gridLayout);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		
		iconContainer = new Composite(this, SWT.NONE);
		iconContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		iconContainer.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_iconContainer = new GridLayout(1, false);
		gl_iconContainer.marginLeft = 5;
		gl_iconContainer.verticalSpacing = 0;
		gl_iconContainer.marginWidth = 0;
		gl_iconContainer.horizontalSpacing = 0;
		gl_iconContainer.marginHeight = 0;
		iconContainer.setLayout(gl_iconContainer);
		addMouseLisnter(iconContainer);
		
		contactIcon = new Label(iconContainer, SWT.NONE);
		contactIcon.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		contactIcon.setImage(SWTResourceManager.getImage(contact.getIcon()));
		new Label(this, SWT.NONE);
		addMouseLisnter(contactIcon);
		
		userDetailContainer = new Composite(this, SWT.NONE);
		userDetailContainer.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_userDetailContainer = new GridLayout(1, false);
		gl_userDetailContainer.marginBottom = 5;
		gl_userDetailContainer.verticalSpacing = 0;
		gl_userDetailContainer.marginWidth = 0;
		gl_userDetailContainer.marginTop = 5;
		gl_userDetailContainer.marginLeft = 5;
		gl_userDetailContainer.marginHeight = 0;
		gl_userDetailContainer.horizontalSpacing = 0;
		userDetailContainer.setLayout(gl_userDetailContainer);
		userDetailContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		addMouseLisnter(userDetailContainer);
		
		username = new Label(userDetailContainer, SWT.WRAP);
		username.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		username.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		username.setFont(SWTResourceManager.getFont("Microsoft YaHei", 9, SWT.BOLD));
		username.setText(contact.getName());
		addMouseLisnter(username);
		
		phonenumber = new Label(userDetailContainer, SWT.NONE);
		phonenumber.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		phonenumber.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		phonenumber.setText(contact.getPhoneNumber());
		addMouseLisnter(phonenumber);
		
		sharedSizeContainer = new Composite(this, SWT.NONE);
		sharedSizeContainer.setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1));
		sharedSizeContainer.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gl_sharedSizeContainer = new GridLayout(1, false);
		gl_sharedSizeContainer.marginHeight = 0;
		gl_sharedSizeContainer.verticalSpacing = 0;
		gl_sharedSizeContainer.marginTop = 5;
		sharedSizeContainer.setLayout(gl_sharedSizeContainer);
		addMouseLisnter(sharedSizeContainer);
		
		sharedSize = new Label(sharedSizeContainer, SWT.NONE);
		sharedSize.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.NORMAL));
		sharedSize.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		sharedSize.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		sharedSize.setText(contact.getSize());
		addMouseLisnter(sharedSize);
		
		label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

	}

	private void addMouseLisnter(Control control) {
		control.addMouseTrackListener(new MouseTrackAdapter() {
			@Override
			public void mouseEnter(MouseEvent e) {
				super.mouseExit(e);
				Color color = new Color(getDisplay(), 220, 220, 220);
				iconContainer.setBackground(color);
				contactIcon.setBackground(color);
				
				userDetailContainer.setBackground(color);
				username.setBackground(color);
				phonenumber.setBackground(color);
				
				sharedSizeContainer.setBackground(color);
				sharedSize.setBackground(color);
			}
			
			@Override
			public void mouseExit(MouseEvent e) {
				super.mouseExit(e);
				Color color = SWTResourceManager.getColor(SWT.COLOR_WHITE);
				iconContainer.setBackground(color);
				contactIcon.setBackground(color);
				
				userDetailContainer.setBackground(color);
				username.setBackground(color);
				phonenumber.setBackground(color);
				
				sharedSizeContainer.setBackground(color);
				sharedSize.setBackground(color);
			}
		});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
