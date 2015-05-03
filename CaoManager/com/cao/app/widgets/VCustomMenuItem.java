package com.cao.app.widgets;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;

import com.shareboard.desktop.app.LandingPage;
import com.shareboard.desktop.custom.ui.UIFactory;

public class VCustomMenuItem extends Composite {
	Label arrowLabel;
	private Label menuIcon;
	private Label menuName;
	private boolean selected;

	public VCustomMenuItem(Composite parent, int style) {
		super(parent, style);
		setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridLayout gridLayout = UIFactory.getGridLayout(1);
		gridLayout.marginHeight = 1;
		gridLayout.numColumns = 4;
		setLayout(gridLayout);
		GridData gridLayoutData = UIFactory.getGridLayoutData();
		setLayoutData(gridLayoutData);
		
		menuIcon = new Label(this, SWT.NONE);
		menuIcon.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		GridData gd_menuIcon = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_menuIcon.horizontalIndent = 2;
		menuIcon.setLayoutData(gd_menuIcon);
		
		menuName = new Label(this, SWT.NONE);
		menuName.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 8, SWT.NORMAL));
		menuName.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		GridData gd_menuName = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_menuName.horizontalIndent = 10;
		menuName.setLayoutData(gd_menuName);
		
		arrowLabel = new Label(this, SWT.NONE);
		arrowLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		arrowLabel.setVisible(false);
		
		ArrayList<Control> controlls = new ArrayList<Control>(Arrays.asList(getChildren()));
		controlls.add(this);
		new Label(this, SWT.NONE);
		addHandler(controlls);
	}
	
	private void addHandler(ArrayList<Control> controls) {
		for (Control control : controls) {
			control.addMouseTrackListener(new MouseTrackAdapter() {
				@Override
				public void mouseExit(MouseEvent e) {
					arrowLabel.setVisible(false);
					select(selected);
				}
				
				@Override
				public void mouseEnter(MouseEvent e) {
					setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
					arrowLabel.setVisible(true);
					super.mouseEnter(e);
				}
			});
			
			control.addListener(SWT.MouseDown, new Listener() {
				@Override
				public void handleEvent(Event event) {
					ArrayList<VCustomMenuItem> items = (ArrayList<VCustomMenuItem>) getData();
					for (VCustomMenuItem mItem : items) {
						mItem.select(false);
					}
					select(true);
				}
			});
		}
	}
	
	@Override
	public void setBackground(Color color) {
		super.setBackground(color);
		Control[] children = getChildren();
		for (Control control : children) {
			control.setBackground(color);
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public void build() {
		menuIcon.setImage(SWTResourceManager.getImage(LandingPage.class, (String)getData("menuIconPath")));
		menuName.setText((String) getData("title"));
		arrowLabel.setImage(SWTResourceManager.getImage(LandingPage.class, (String)getData("arrowIconPath")));
	}

	public void select(boolean selected) {
		if(selected) {
			setBackground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		} else {
			setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		}
		this.selected = selected;
	}

}
