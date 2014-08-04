/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse.wizard.util.WizardConstants;

/**
 * Part to Choose from 3 Wizard options.
 * 
 * Modify context elements:
 * <p>
 * {@link WizardConstants#CHOOSE_WIZARD}
 * </p>
 * <p>
 * {@link WizardConstants#DESCRIPTION}
 * </p>
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class ChooseWizardPart {

	private final static String APP_GEN_TEXT = "Create an application project and a generator project from a template.";
	private final static String APP_TEXT = "Create an application project for a given generator project.";
	private final static String GEN_TEXT = "Create a generator project for a given application project.";

	private Button btnRadioButton;
	private Button btnCreateNewApplication;
	private Button btnCreateNewGenerator;

	@Inject
	private IEclipseContext context;

	/**
	 * Standard constructor
	 */
	public ChooseWizardPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		btnRadioButton = new Button(parent, SWT.RADIO);
		btnRadioButton.setData(WizardConstants.RADIO_1);
		btnRadioButton.setText("Create new application and generator project");

		btnCreateNewApplication = new Button(parent, SWT.RADIO);
		btnCreateNewApplication.setData(WizardConstants.RADIO_2);
		btnCreateNewApplication.setText("Create new application project");

		btnCreateNewGenerator = new Button(parent, SWT.RADIO);
		btnCreateNewGenerator.setData(WizardConstants.RADIO_3);
		btnCreateNewGenerator.setText("Create new generator project");
	
		addListener();
	}

	/**
	 * Adds the Listener
	 */
	private void addListener() {
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD, btnRadioButton);
				context.modify(WizardConstants.DESCRIPTION, APP_GEN_TEXT);
			}
		});

		btnCreateNewApplication.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD,
						btnCreateNewApplication);
				context.modify(WizardConstants.DESCRIPTION, APP_TEXT);
			}
		});

		btnCreateNewGenerator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD,
						btnCreateNewGenerator);
				context.modify(WizardConstants.DESCRIPTION, GEN_TEXT);
			}
		});
	}
}
