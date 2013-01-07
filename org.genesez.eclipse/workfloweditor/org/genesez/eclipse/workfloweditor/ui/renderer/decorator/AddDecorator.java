package org.genesez.eclipse.workfloweditor.ui.renderer.decorator;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.genesez.eclipse.workfloweditor.ui.renderer.BooleanValueRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;

@SuppressWarnings("restriction")
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
