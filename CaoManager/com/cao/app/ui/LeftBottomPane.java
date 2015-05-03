package com.cao.app.ui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import com.cao.app.widgets.listadpater.ArrayListAdapter;
import com.cao.app.widgets.listadpater.Contact;
import com.cao.app.widgets.listadpater.ContactLayout;
import org.eclipse.swt.layout.FillLayout;

public class LeftBottomPane extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public LeftBottomPane(Composite parent, int style) {
		super(parent, style);
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		setLayout(new FillLayout(SWT.HORIZONTAL));
		setSize(240, 232);
		
		ArrayList<Contact> names = new ArrayList<Contact>();
		names.add(new Contact("Mr. A.", "32323232", "21 MB"));
		names.add(new Contact("Mr. B.", "93556600", "323 KB"));
		names.add(new Contact("Mr. C.", "7FDS", "32 MB"));
		names.add(new Contact("Mr. D.", "SD567890", "1 GB"));
		names.add(new Contact("Mr. E.", "63SD5215", ""));
		names.add(new Contact("Mr. F.", "EWE3232", "21 MB"));
		
		ArrayListAdapter adapter = new ArrayListAdapter<Contact>(this, SWT.BORDER, 50, names) {

			@Override
			public void getView(Composite rowCompo, Contact contact) {
				ContactLayout contactLayout = new ContactLayout(rowCompo, SWT.NONE, contact);
			}
		};
		adapter.build();


	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
