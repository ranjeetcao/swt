package com.cao.app.widgets.listadpater;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;

public abstract class ArrayListAdapter<T> {
	private ScrolledComposite scrolledResults;
	protected Composite listResults;
	
	private int width;
	private int height;
	protected int itemRowHeight;
	private int maxResultsDisplayed;
	
	private ArrayList<T> rowModel = new ArrayList<T>();
	
	public ArrayListAdapter(final Composite parent, int style, final int itemRowHeight, ArrayList<T> data) {
		this.width = parent.getBounds().width;
		this.height = parent.getBounds().height;
		this.itemRowHeight = itemRowHeight;
		this.rowModel.addAll(data);
		
		maxResultsDisplayed = height / itemRowHeight;
		
		scrolledResults = new ScrolledComposite(parent, SWT.V_SCROLL | style);
		this.width -= scrolledResults.getVerticalBar().getSize().x; 
		
		scrolledResults.setSize(width, height);
		scrolledResults.setExpandHorizontal(false);
		scrolledResults.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledResults.setMinSize(width, maxResultsDisplayed * itemRowHeight);	
		scrolledResults.getVerticalBar().setIncrement(scrolledResults.getVerticalBar().getIncrement()*10);
		
		scrolledResults.addListener(SWT.Activate, new Listener() {
		    public void handleEvent(Event e) {
		    	scrolledResults.setFocus();
		    }
		});
		
		listResults = new Composite(scrolledResults, style);
		if(!scrollbarIsShown()) {
			listResults.setSize(width, rowModel.size() * itemRowHeight);
		} else {
			listResults.setSize(width - scrolledResults.getVerticalBar().getSize().x, rowModel.size() * itemRowHeight);
		}
		listResults.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledResults.setContent(listResults);
		
		parent.addListener(SWT.Resize, new Listener() { 
			public void handleEvent(Event event) { 
				maxResultsDisplayed = parent.getBounds().height/itemRowHeight;
				resizeScrollableResults();
			} 
		}); 
		parent.notifyListeners(SWT.Resize, new Event()); 
	}
	
	
	private void resizeScrollableResults() {
		int actualHeight = rowModel.size() * itemRowHeight;
		scrolledResults.setMinSize(width, Math.max(actualHeight, height));
		scrolledResults.layout();
	}
	
	private void addRow(int position, T contact) {
		int rowCompoWidth = listResults.getBounds().width;
		
		final Composite rowCompo = new Composite(listResults, SWT.NONE);
		rowCompo.setLocation(0, (position * itemRowHeight));
		rowCompo.setSize(rowCompoWidth, itemRowHeight);
		rowCompo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		rowCompo.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		getView(rowCompo, contact);
		rowCompo.layout();
	}
	
	public abstract void getView(Composite rowCompo, T contact);

	private boolean scrollbarIsShown() {
		return (rowModel.size() >= maxResultsDisplayed);
	}

	private void clear() {
		Control[] children = listResults.getChildren();
		if (children != null) {
			for (Control child : children) {
				child.dispose();
			}
		}
		rowModel.clear();
	}
	
	public void updateView(Collection<T> items) {
		clear();
		rowModel.addAll(items);
		resizeLayout();
		build();
	}


	private void resizeLayout() {
		if(!scrollbarIsShown()) {
			listResults.setSize(width, rowModel.size() * itemRowHeight);
		} else {
			listResults.setSize(width - scrolledResults.getVerticalBar().getSize().x, rowModel.size() * itemRowHeight);
		}
		scrolledResults.layout();
	}


	public void build() {
		for(int i=0; i< rowModel.size(); i++) {
			addRow(i, rowModel.get(i));
		}
	}
}