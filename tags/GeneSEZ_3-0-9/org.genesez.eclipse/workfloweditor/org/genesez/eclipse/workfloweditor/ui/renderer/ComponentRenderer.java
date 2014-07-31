/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.common.types.JvmFeature;

/**
 * Value renderer for Component Values. Allows components to get opened.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class ComponentRenderer extends FeatureRenderer {

	private final String BUTTON_OPEN_TXT = " Open >> ";
	private final String BUTTON_CLOSE_TXT = " << Close ";

	private Text text;
	private Button openButton;
	private Group group;
	private Composite dynamicOpenPart;

	public ComponentRenderer(JvmFeature feature, Component component) {
		super(feature, component);
	}

	@Override
	protected void renderElement(Composite parent) {
		parent.setLayout(new GridLayout());
		group = new Group(parent, SWT.BORDER | SWT.SHADOW_NONE);
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		group.setLayout(new GridLayout(3, false));
		group.setText(feature.getSimpleName().substring(3));
		openButton = new Button(group, SWT.TOGGLE);
		openButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		openButton.setText(BUTTON_OPEN_TXT);
		text = new Text(group, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		createDecoratedElement(group);
		addListener();
	}

	private void addListener() {
		// creates and disposes the needed parts
		openButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (openButton.getSelection()) {
					openPart();
					openButton.setText(BUTTON_CLOSE_TXT);
				} else {
					if (dynamicOpenPart != null) {
						dynamicOpenPart.dispose();
					}
					openButton.setText(BUTTON_OPEN_TXT);
				}
				controller.refreshView();
			}
		});
	}

	private void openPart() {
		dynamicOpenPart = new Composite(group, SWT.NONE);
		dynamicOpenPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		dynamicOpenPart.setLayout(new GridLayout());
		try {
			controller.readFeatures((Component) assignment.getValue(), dynamicOpenPart, context);
		} catch (Exception e) {
			Label label = new Label(dynamicOpenPart, SWT.NONE);
			label.setText("Class could not be found.");
			System.err.println(e);
		}
	}

	@Override
	public boolean checkDefaultValue() {
		return false;
	}

	@Override
	protected void changeValue() {
		if (value != null) {
			text.setText(value.getActualType().getIdentifier());
		} else {
			text.setText("");
		}
	}

}
