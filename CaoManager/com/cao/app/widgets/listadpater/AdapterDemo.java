package com.cao.app.widgets.listadpater;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;

public class AdapterDemo {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AdapterDemo window = new AdapterDemo();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.launch();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(300, 200);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

		ArrayList<Contact> names = new ArrayList<Contact>();
		names.add(new Contact("Mr A", "32323232", "21 MB"));
		names.add(new Contact("Mr B", "SDSDF32", "323 KB"));
		names.add(new Contact("Mr C", "2332DFS", "32 MB"));
		names.add(new Contact("Mr D", "1234567890", "1 GB"));
		names.add(new Contact("Mr E", "63045215", ""));
		
		ArrayListAdapter adapter = new ArrayListAdapter<Contact>(shell, SWT.BORDER, 50, names) {

			@Override
			public void getView(Composite rowCompo, Contact contact) {
				ContactLayout contactLayout = new ContactLayout(rowCompo, SWT.NONE, contact);
			}
		};
		adapter.build();

	}

}
