/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.BooleanLiteral;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.common.types.JvmFeature;

/**
 * Value renderer, that Renders BooleanValues with a checkBox.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class BooleanValueRenderer extends FeatureRenderer {

	private Button fieldValue;

	public BooleanValueRenderer(JvmFeature feature, Component component) {
		super(feature, component);
	}

	@Override
	public boolean checkDefaultValue() {
		// TODO: Implement this
		return false;
	}

	@Override
	protected void renderElement(Composite parent) {
		parent.setLayout(new GridLayout(3, false));
		Label fieldLabel = new Label(parent, SWT.NONE);
		fieldLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		fieldLabel.setText(feature.getSimpleName().substring(3) + ":");
		fieldValue = new Button(parent, SWT.CHECK);
		fieldValue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		createDecoratedElement(parent);
		addListener();
	}

	private void addListener() {
		fieldValue.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (value == null || (fieldValue.getSelection() != ((BooleanLiteral) value).isIsTrue())) {
					setValue(controller.setBooleanLiteral(assignment, fieldValue.getSelection()));
				}
			}
		});
	}

	@Override
	protected void changeValue() {
		if (value != null && value instanceof BooleanLiteral) {
			fieldValue.setSelection(((BooleanLiteral) value).isIsTrue());
		} else {
			fieldValue.setSelection((Boolean) defaultValue);
		}
	}

}
