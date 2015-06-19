package com.cao.app.widgets;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.wb.swt.SWTResourceManager;

import com.shareboard.desktop.utils.UIFactory;

public class VMenuBar extends Composite {
	ArrayList<VCustomMenuItem> items;

	public VMenuBar(Composite parent, int style) {
		super(parent, style);
		items = new ArrayList<VCustomMenuItem>();
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setLayout(UIFactory.getGridLayout(1));
		GridData gridData = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
		setLayoutData(gridData);
	}
	
	public void build() {
		ArrayList<String> menus = (ArrayList<String>) getData("menus");
		for (String menu : menus) {
			final VCustomMenuItem item = new VCustomMenuItem(this, 0);
			item.setData("title", menu);
			item.setData("menuIconPath", "/com/shareboard/desktop/res/vmenu.png");
			item.setData("arrowIconPath", "/com/shareboard/desktop/res/right.png");
			item.build();
			items.add(item);
			item.setData(items);
			
		}
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public VCustomMenuItem getItem(int index) {
		return items.get(index);
	}

}
