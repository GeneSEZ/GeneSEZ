package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class ChooseWorkflowPart {


	private Button btnDoNotCreate;
	private Button btnCreateNewWorkflow;
	private Button btnCreateNewWorkflow_1;

	@Inject
	private IEclipseContext context;
	
	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		FillLayout fillLayout = (FillLayout) parent.getLayout();
		fillLayout.type = SWT.VERTICAL;
		
		btnDoNotCreate = new Button(parent, SWT.RADIO);
		btnDoNotCreate.setData(WizardConstants.RADIO_1);
		btnDoNotCreate.setSelection(true);
		btnDoNotCreate.setText("Do not create workflow file");
		
		btnCreateNewWorkflow = new Button(parent, SWT.RADIO);
		btnCreateNewWorkflow.setData(WizardConstants.RADIO_2);
		btnCreateNewWorkflow.setText("Create new workflow file");
		
		btnCreateNewWorkflow_1 = new Button(parent, SWT.RADIO);
		btnCreateNewWorkflow_1.setData(WizardConstants.RADIO_3);
		btnCreateNewWorkflow_1.setText("Create new workflow file from template");
		
		addListener();
		btnDoNotCreate.notifyListeners(SWT.Selection, new Event());
	}
	
	private void addListener(){
		btnDoNotCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WORKFLOW, btnDoNotCreate);
			}
		});
		
		btnCreateNewWorkflow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WORKFLOW, btnCreateNewWorkflow);
			}
		});
		
		btnCreateNewWorkflow_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				context.modify(WizardConstants.CHOOSE_WORKFLOW, btnCreateNewWorkflow_1);
			}
		});
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO	Set the focus to control
	}

}
