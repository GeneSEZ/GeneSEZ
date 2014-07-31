/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer.decorator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;

/**
 * Adds adder functionality to a Renderer. In fact that means Buttons to move and delete the renderer. TODO: add functionality to
 * move-buttons
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class AddDecorator extends AbstractFeatureDecorator {

	private Button btnUpButton;
	private Button btnDownButton;
	private Button btnDeleteButton;

	private Image deleteImage;

	public AddDecorator(IFeatureRenderer renderer) {
		super(renderer);
	}

	@Override
	protected void decorate(Composite composite) {
		composite.setLayout(new FillLayout());
		btnUpButton = new Button(composite, SWT.ARROW | SWT.UP);
		btnDownButton = new Button(composite, SWT.ARROW | SWT.DOWN);
		btnDeleteButton = new Button(composite, SWT.CLOSE);
		if (workbench != null) {
			deleteImage = workbench.getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE);
			btnDeleteButton.setImage(deleteImage);
		} else {
			btnDeleteButton.setText(" X ");
		}

		addListener();
	}

	private void addListener() {
		btnDeleteButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				dispose();
			}
		});
	}

}
