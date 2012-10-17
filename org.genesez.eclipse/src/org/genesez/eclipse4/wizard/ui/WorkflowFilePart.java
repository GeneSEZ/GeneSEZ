package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class WorkflowFilePart {
	private Text txtWorkflowtemplate;
	private Text txtWorkflowfile;
	private Text txtWorkflowdirectory;
	private Button btnWorkflowtemplate;
	private Button btnWorkflowdirectory;

	@Inject
	private IEclipseContext context;

	public WorkflowFilePart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		txtWorkflowtemplate = new Text(parent, SWT.BORDER);
		txtWorkflowtemplate.setMessage("Workflow template file");
		txtWorkflowtemplate.setToolTipText("Workflow template file");
		txtWorkflowtemplate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		txtWorkflowtemplate.setEditable(false);
		txtWorkflowtemplate.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_TEMPLATE,
						txtWorkflowtemplate.getText().trim());
			}
		});

		btnWorkflowtemplate = new Button(parent, SWT.NONE);
		btnWorkflowtemplate.setText("Browse...");

		txtWorkflowfile = new Text(parent, SWT.BORDER);
		txtWorkflowfile.setMessage("Workflow file name");
		txtWorkflowfile.setToolTipText("Workflow file name");
		txtWorkflowfile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		txtWorkflowfile.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_FILENAME,
						txtWorkflowfile.getText().trim());
			}
		});
		new Label(parent, SWT.NONE);

		txtWorkflowdirectory = new Text(parent, SWT.BORDER);
		txtWorkflowdirectory.setMessage("Directory for workflow file");
		txtWorkflowdirectory.setToolTipText("Directory for workflow file");
		txtWorkflowdirectory.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));
		txtWorkflowdirectory.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_DIRECTORY,
						txtWorkflowdirectory.getText().trim());
			}
		});

		btnWorkflowdirectory = new Button(parent, SWT.NONE);
		btnWorkflowdirectory.setText("Browse...");

		txtWorkflowtemplate.setEnabled(false);
		txtWorkflowfile.setEnabled(false);
		txtWorkflowdirectory.setEnabled(false);
		btnWorkflowdirectory.setEnabled(false);
		btnWorkflowtemplate.setEnabled(false);
	}

	@Inject
	private void changeActive(
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button radioButton) {
		if (radioButton != null) {
			Object data = radioButton.getData();
			if (data.equals(WizardConstants.RADIO_1)) {
				txtWorkflowtemplate.setEnabled(false);
				txtWorkflowfile.setEnabled(false);
				txtWorkflowdirectory.setEnabled(false);
				btnWorkflowdirectory.setEnabled(false);
				btnWorkflowtemplate.setEnabled(false);
			} else if (data.equals(WizardConstants.RADIO_2)) {
				txtWorkflowtemplate.setEnabled(false);
				txtWorkflowfile.setEnabled(true);
				txtWorkflowdirectory.setEnabled(true);
				btnWorkflowdirectory.setEnabled(true);
				btnWorkflowtemplate.setEnabled(false);
			} else if (data.equals(WizardConstants.RADIO_3)) {
				txtWorkflowtemplate.setEnabled(true);
				txtWorkflowfile.setEnabled(true);
				txtWorkflowdirectory.setEnabled(true);
				btnWorkflowdirectory.setEnabled(true);
				btnWorkflowtemplate.setEnabled(true);
			}
		}
	}

	@PreDestroy
	public void dispose() {
	}
}
