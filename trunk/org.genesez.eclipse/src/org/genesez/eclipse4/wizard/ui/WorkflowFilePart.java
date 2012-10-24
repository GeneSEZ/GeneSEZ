package org.genesez.eclipse4.wizard.ui;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.genesez.eclipse4.wizard.util.FolderAndZipFolderSelectionDialog;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class WorkflowFilePart {
	private Text txtWorkflowtemplate;
	private Text txtWorkflowfile;
	private Text txtWorkflowdirectory;
	private Button btnWorkflowtemplate;
	private Button btnWorkflowdirectory;
	private Composite composite;
	
	@Inject @Named(WizardConstants.TEMPLATE)
	private TemplateConfigXml template;
	
	@Inject @Named(WizardConstants.APP_PROJ_NAME)
	private String appName;
	
	@Inject @Named(WizardConstants.GEN_PROJ_NAME)
	private String genName;
	
	@Inject @Named(WizardConstants.CHOOSE_WIZARD)
	private Button wizardSelection;
	
	@Inject
	private IEclipseContext context;
	
	@Inject
	private IWorkspaceRoot workspace;

	public WorkflowFilePart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory.copyLayout(WizardConstants.L_GL_TXTBTN));
		
		txtWorkflowtemplate = new Text(composite, SWT.BORDER);
		txtWorkflowtemplate.setMessage("Workflow template file");
		txtWorkflowtemplate.setToolTipText("Workflow template file");
		txtWorkflowtemplate.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		txtWorkflowtemplate.setEditable(false);

		btnWorkflowtemplate = new Button(composite, SWT.NONE);
		btnWorkflowtemplate.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnWorkflowtemplate.setText("Browse...");

		txtWorkflowfile = new Text(composite, SWT.BORDER);
		txtWorkflowfile.setMessage("Workflow file name");
		txtWorkflowfile.setToolTipText("Workflow file name");
		txtWorkflowfile.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		
		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, true, false));
		label.setText(".mwe2");
		label.setEnabled(false);

		txtWorkflowdirectory = new Text(composite, SWT.BORDER);
		txtWorkflowdirectory.setMessage("Directory for workflow file");
		txtWorkflowdirectory.setToolTipText("Directory for workflow file");
		txtWorkflowdirectory.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
	
		btnWorkflowdirectory = new Button(composite, SWT.NONE);
		btnWorkflowdirectory.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		btnWorkflowdirectory.setText("Browse...");
		
		txtWorkflowtemplate.setEnabled(false);
		txtWorkflowfile.setEnabled(false);
		txtWorkflowdirectory.setEnabled(false);
		btnWorkflowdirectory.setEnabled(false);
		btnWorkflowtemplate.setEnabled(false);
		
		addListener();
	}

	@Inject
	private void changeActive(
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button radioButton) {
		if (radioButton != null && composite != null && !composite.isDisposed()) {
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
	
	private void addListener(){
		txtWorkflowtemplate.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_TEMPLATE,
						txtWorkflowtemplate.getText().trim());
			}
		});
		
		txtWorkflowfile.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_FILENAME,
						txtWorkflowfile.getText().trim());
			}
		});
		
		txtWorkflowdirectory.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_DIRECTORY,
						txtWorkflowdirectory.getText().trim());
			}
		});
		
		btnWorkflowdirectory.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FolderAndZipFolderSelectionDialog dialog = new FolderAndZipFolderSelectionDialog(
						btnWorkflowdirectory.getShell(), "Choose a folder:",
						workspace, template, appName, genName);
				Object data = wizardSelection.getData();
				if(data.equals(WizardConstants.RADIO_1))
					dialog.setFlags(true, true, true);
				else if(data.equals(WizardConstants.RADIO_2))
					dialog.setFlags(true, true, false);
				else
					dialog.setFlags(true, false, true);
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if(result != null)
					txtWorkflowdirectory.setText(((File) result[0]).toString());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		btnWorkflowtemplate.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(btnWorkflowtemplate.getShell());
				dialog.setFilterNames(WizardConstants.WORKFLOW_FILTER_NAMES);
				dialog.setFilterExtensions(WizardConstants.WORKFLOW_FILTER_EXTENSIONS);
				dialog.setFilterPath(workspace.getLocation().toOSString());
				dialog.open();
				String filename = dialog.getFileName();
				if(!filename.equals("")){
					IPath path = new Path(dialog.getFilterPath());
					path = path.append(filename).makeAbsolute();
					txtWorkflowtemplate.setText(path.toOSString()); 
				}
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	@PreDestroy
	public void dispose() {
	}
}
