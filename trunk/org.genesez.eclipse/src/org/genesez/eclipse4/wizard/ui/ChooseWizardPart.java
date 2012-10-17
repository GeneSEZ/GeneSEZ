package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class ChooseWizardPart {

	private final static String APP_GEN_TEXT = "Create an application project and a generator project from a template.";
	private final static String APP_TEXT = "Create an application project for a given generator project.";
	private final static String GEN_TEXT = "Create a generator project for a given application project.";

	
	private Button btnRadioButton;
	private Button btnCreateNewApplication;
	private Button btnCreateNewGenerator;
	
	public ChooseWizardPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent, final IEclipseContext context) {
		parent.setLayout(new FillLayout(SWT.VERTICAL));
		
		btnRadioButton = new Button(parent, SWT.RADIO);
		btnRadioButton.setData(WizardConstants.RADIO_1);
		btnRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD, btnRadioButton);
				context.modify(WizardConstants.DESCRIPTION, APP_GEN_TEXT);
			}
		});
		btnRadioButton.setText("Create new application and generator project");
		
		btnCreateNewApplication = new Button(parent, SWT.RADIO);
		btnCreateNewApplication.setData(WizardConstants.RADIO_2);
		btnCreateNewApplication.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD, btnCreateNewApplication);
				context.modify(WizardConstants.DESCRIPTION, APP_TEXT);
			}
		});
		btnCreateNewApplication.setText("Create new application project");
		
		btnCreateNewGenerator = new Button(parent, SWT.RADIO);
		btnCreateNewGenerator.setData(WizardConstants.RADIO_3);
		btnCreateNewGenerator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WIZARD, btnCreateNewGenerator);
				context.modify(WizardConstants.DESCRIPTION, GEN_TEXT);
			}
		});
		btnCreateNewGenerator.setText("Create new generator project");
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}
}
