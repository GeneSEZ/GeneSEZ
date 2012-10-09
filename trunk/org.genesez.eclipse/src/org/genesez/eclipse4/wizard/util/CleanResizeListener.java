package org.genesez.eclipse4.wizard.util;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class CleanResizeListener extends ControlAdapter {

	static {
		System.setProperty("sun.awt.noerasebackground", "true");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
		} catch (InstantiationException e1) {
		} catch (IllegalAccessException e1) {
		} catch (UnsupportedLookAndFeelException e1) {
		}
	}
	
	private Rectangle oldRect = null;

	public void controlResized(ControlEvent e) {
		// Prevent garbage from Swing lags during resize. Fill exposed areas
		// with background color.
		Composite composite = (Composite) e.widget;
		Rectangle newRect = composite.getClientArea();
		if (oldRect != null) {
			int heightDelta = newRect.height - oldRect.height;
			int widthDelta = newRect.width - oldRect.width;
			if ((heightDelta > 0) || (widthDelta > 0)) {
				GC gc = new GC(composite);
				try {
					gc.fillRectangle(newRect.x, oldRect.height, newRect.width,
							heightDelta);
					gc.fillRectangle(oldRect.width, newRect.y, widthDelta,
							newRect.height);
				} finally {
					gc.dispose();
				}
			}
		}
		oldRect = newRect;
	}
}
