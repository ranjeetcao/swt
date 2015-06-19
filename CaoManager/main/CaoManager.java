package main;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.cao.app.ui.CaoMainPageContainer;
import com.cao.app.ui.CaoMenuBar;
import com.cao.app.ui.UIFactory;

public class CaoManager {
	protected Shell shell;

	public static void main(String[] args) {
		try {
			CaoManager window = new CaoManager();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void open() {
		Display display = Display.getDefault();
		createContents();
		this.shell.launch();
		this.shell.layout();
		while (!this.shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	protected void createContents() {
		this.shell = new Shell();

		Rectangle rec = this.shell.getDisplay().getBounds();

		this.shell.setSize(3 * rec.width / 4, 3 * rec.height / 4);
		this.shell.setLocation(rec.width / 8, rec.height / 8);
		this.shell.setText("SWT Application");
		this.shell.setLayoutData(UIFactory.getGridLayoutData());
		this.shell.setLayout(UIFactory.getGridLayout(1));

		CaoMainPageContainer composite = new CaoMainPageContainer(this.shell, 0);
		CaoMenuBar menuBar = new CaoMenuBar(this.shell);
	}
}