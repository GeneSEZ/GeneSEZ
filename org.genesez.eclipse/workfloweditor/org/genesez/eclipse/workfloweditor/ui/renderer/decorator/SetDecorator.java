package org.genesez.eclipse.workfloweditor.ui.renderer.decorator;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public class SetDecorator extends AbstractFeatureDecorator {

	private Image imageRestoreDefault = null;
	private Button button;

	public SetDecorator(IFeatureRenderer renderer) {
		super(renderer);
	}

	@Override
	protected void decorate(Composite composite) {
		composite.setLayout(new FillLayout());
		button = new Button(composite, SWT.PUSH);
		if (workbench != null) {
			imageRestoreDefault = workbench.getSharedImages().getImage(ISharedImages.IMG_TOOL_UNDO);
			button.setImage(imageRestoreDefault);
		} else {
			button.setText("<-");
		}
	}
}
