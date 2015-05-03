package com.cao.app.widgets.listadpater;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.wb.swt.SWTResourceManager;

public class CustomListBox extends Composite {

	private ScrolledComposite scrolledResults;
	private Composite listResults;
	
	private int width;
	private int height;
	private int itemRowHeight;
	private int rowWidth;
	private int maxResultsDisplayed;
	
	private Map<String, Composite> rows = new HashMap<String, Composite>();
	
	/**
	 * 
	 * @param parent container of the component
	 * @param style style of the componen
	 * @param marginLeft pixels from left border of the dialog
	 * @param topHeight pixels from top border fo the dialog
	 * @param width total width in pixel of the component
	 * @param height total height in pixel of the component
	 * @param scrolledCompoFormData FormData for the component
	 * @param itemRowHeight height in pixel of a single item
	 */
	public CustomListBox(Composite parent, int style, int marginLeft, int topHeight, int width, int height,
			FormData scrolledCompoFormData, int itemRowHeight) {
		super(parent, style);

		this.width = width;
		rowWidth = width - 25;
		this.height = height;
		this.itemRowHeight = itemRowHeight;
		maxResultsDisplayed = height / itemRowHeight;
		
		scrolledResults = new ScrolledComposite(parent, SWT.BORDER | SWT.V_SCROLL);
		scrolledResults.setLocation(marginLeft, topHeight);
		scrolledResults.setSize(width, height);
		scrolledResults.setExpandHorizontal(false);
		scrolledResults.setExpandVertical(true);
		scrolledResults.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledResults.setMinSize(width, height);	
		scrolledCompoFormData.height = height;	//force height of the component
		scrolledResults.setLayoutData(scrolledCompoFormData);
		scrolledResults.getVerticalBar().setIncrement(scrolledResults.getVerticalBar().getIncrement()*10);
		scrolledResults.addListener(SWT.Activate, new Listener() {
		    public void handleEvent(Event e) {
		    	scrolledResults.setFocus();
		    }
		});
		
		listResults = new Composite(scrolledResults, SWT.NONE);
		listResults.setSize(width, height);
		listResults.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		scrolledResults.setContent(listResults);
		
		parent.addListener(SWT.Resize, new Listener() { 
			public void handleEvent(Event event) { 
				resizeScrollableResults();
			} 
		}); 
		parent.notifyListeners(SWT.Resize, new Event()); 
	}
	
	
	private void resizeScrollableResults() {
		int actualHeight = rows.size() * itemRowHeight;
		scrolledResults.setMinSize(width, Math.max(actualHeight, height));
		scrolledResults.layout();
	}
	
	@Override
	public void layout() {
		listResults.layout();
		resizeScrollableResults();
	}
	
	/**
	 * Creates a new row in the list, identified by the given key.
	 * @param key identifier to retrieve the newly created item
	 * @return the just created and added composite item
	 * @throws IllegalArgumentException if key already exists or is null/empty
	 */
	public Composite addRow(String key) throws IllegalArgumentException {
		if (key == null || key.length() <= 0)
			throw new IllegalArgumentException("Null or empty key");
		if (rows.containsKey(key))
			throw new IllegalArgumentException("Item with key " + key + " already exists");
		
		int rowCompoWidth = rowWidth;
		if (!scrollbarIsShown()) 
			rowCompoWidth += 20;
		
		final Composite rowCompo = new Composite(listResults, SWT.BORDER);
		rowCompo.setLocation(0, (rows.size() * itemRowHeight));
		rowCompo.setSize(rowCompoWidth, itemRowHeight - 2);
		rowCompo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		rowCompo.addListener(SWT.MouseEnter, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				rowCompo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			}
		});
		
		rowCompo.addListener(SWT.MouseExit, new Listener() {
			
			@Override
			public void handleEvent(Event event) {
				rowCompo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
			}
		});

		rows.put(key, rowCompo);
		
		return rowCompo;
	}
	
	/**
	 * True if the number of items is greater than the total visible items 
	 */
	public boolean scrollbarIsShown() {
		return (rows.size() >= maxResultsDisplayed);
	}
	
	/**
	 * Returns the number of visible items
	 */
	public int getMaxResultsDisplayed() {
		return maxResultsDisplayed;
	}
	
	/**
	 * Empties the list of items in the list and shows a single item with the given text
	 * @param textToShow text to display
	 * @param font font of the text to display
	 * @param backgroundColor background color of the item that shows the text to display
	 * @param link link to follow (if not empty, a Link instead of a Label will be created)
	 */
	public void displayMessage(String textToShow, Font font, Color backgroundColor, final String link) {
		final Composite rowCompo = new Composite(listResults, SWT.NONE);
		rowCompo.setLocation(0, 0);
		rowCompo.setSize(width, itemRowHeight - 2);
		rowCompo.setBackground(backgroundColor);

		Control lblNoResults = null;
		if (link != null) {
			lblNoResults = new Link(rowCompo, SWT.NONE);
			((Link)lblNoResults).setText(textToShow);
			((Link)lblNoResults).setCursor(new Cursor(getShell().getDisplay(), SWT.CURSOR_HAND));
			((Link)lblNoResults).addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					//something to do with the link...
				}
			});
		} else {		
			lblNoResults = new Label(rowCompo, SWT.NONE);
			((Label)lblNoResults).setAlignment(SWT.CENTER);
			((Label)lblNoResults).setText(textToShow);
		}
		lblNoResults.setBounds(0, 0, width, itemRowHeight - 2); 
		lblNoResults.setFont(font);
		lblNoResults.setBackground(backgroundColor);
	}
	
	/**
	 * Removes all the items from the list and dispose all the children content
	 */
	public void cleanItems() {
		//clean previous results:
		Control[] children = listResults.getChildren();
		if (children != null) {
			for (Control child : children) {
				child.dispose();
			}
		}
		
		rows = new HashMap<String, Composite>();
	}
}