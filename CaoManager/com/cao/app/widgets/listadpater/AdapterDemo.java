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
		shell.open();
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
		names.add(new Contact("Shareboard User", "32323232", "21 MB"));
		names.add(new Contact("Ranjeet", "9493556600", "323 KB"));
		names.add(new Contact("Pawan", "7676669915", "32 MB"));
		names.add(new Contact("Gagan", "1234567890", "1 GB"));
		names.add(new Contact("Solo", "63045215", ""));
		names.add(new Contact("Aru", "32323232", "21 MB"));
		
		ArrayListAdapter adapter = new ArrayListAdapter<Contact>(shell, SWT.BORDER, 50, names) {

			@Override
			public void getView(Composite rowCompo, Contact contact) {
				ContactLayout contactLayout = new ContactLayout(rowCompo, SWT.NONE, contact);
			}
		};
		adapter.build();

	}

}
