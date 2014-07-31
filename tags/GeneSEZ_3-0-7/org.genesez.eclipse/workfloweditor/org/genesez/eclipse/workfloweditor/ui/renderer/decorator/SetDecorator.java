/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer.decorator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;

/**
 * Adds Setter functionality to the FeatureRenderer. In fact a Button which allows to set back to the default Value. TODO:
 * implement Button functionality
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
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
