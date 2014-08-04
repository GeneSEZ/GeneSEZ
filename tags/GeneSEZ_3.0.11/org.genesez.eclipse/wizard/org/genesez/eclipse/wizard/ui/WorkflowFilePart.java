/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.ui;

import java.io.File;

import javax.annotation.PostConstruct;
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
import org.genesez.eclipse.wizard.util.FolderAndZipFolderSelectionDialog;
import org.genesez.eclipse.wizard.util.TemplateConfigXml;
import org.genesez.eclipse.wizard.util.WizardConstants;

/**
 * Part to set the variables for the workflow file creation.
 * 
 * Modify context elements:
 * <p>
 * {@link WizardConstants#WORKFLOW_TEMPLATE}
 * </p>
 * <p>
 * {@link WizardConstants#WORKFLOW_FILENAME}
 * </p>
 * <p>
 * {@link WizardConstants#WORKFLOW_DIRECTORY}
 * </p>
 * 
 * Listen to context elements:
 * <p>
 * {@link WizardConstants#CHOOSE_WORKFLOW}
 * </p>
 * <p>
 * {@link WizardConstants#APP_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#GEN_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#TEMPLATE}
 * </p>
 * <p>
 * {@link WizardConstants#CHOOSE_WIZARD}
 * </p>
 * <p>
 * {@link IWorkspaceRoot}
 * </p>
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class WorkflowFilePart {
	private Text txtWorkflowtemplate;
	private Text txtWorkflowfile;
	private Text txtWorkflowdirectory;
	private Button btnWorkflowtemplate;
	private Button btnWorkflowdirectory;
	private Composite composite;

	@Inject
	@Named(WizardConstants.TEMPLATE)
	private TemplateConfigXml template;

	@Inject
	@Named(WizardConstants.APP_PROJ_NAME)
	private String appName;

	@Inject
	@Named(WizardConstants.GEN_PROJ_NAME)
	private String genName;

	@Inject
	@Named(WizardConstants.CHOOSE_WIZARD)
	private Button wizardSelection;

	@Inject
	private IEclipseContext context;

	@Inject
	private IWorkspaceRoot workspace;

	/**
	 * Standard constructor
	 */
	public WorkflowFilePart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(GridLayoutFactory
				.copyLayout(WizardConstants.L_GL_TXTBTN));

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

	/**
	 * Sets the state of the widgets depending on
	 * {@link WizardConstants#CHOOSE_WORKFLOW}
	 * 
	 * @param radioButton
	 *            the selected button.
	 */
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

	/**
	 * Adds the needed listeners
	 */
	private void addListener() {
		// Modifies WizardConstants.WORKFLOW_TEMPLATE with text from text field.
		txtWorkflowtemplate.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_TEMPLATE,
						txtWorkflowtemplate.getText().trim());
			}
		});

		// Modifies WizardConstants.WORKFLOW_FILENAME with text from text field.
		txtWorkflowfile.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_FILENAME,
						txtWorkflowfile.getText().trim());
			}
		});

		// Modifies WizardConstants.WORKFLOW_DIRECTORY with text from text
		// field.
		txtWorkflowdirectory.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.WORKFLOW_DIRECTORY,
						txtWorkflowdirectory.getText().trim());
			}
		});

		// opens a dialog that allows to chose the workflow directory from newly
		// the created/referenced projects.
		btnWorkflowdirectory.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FolderAndZipFolderSelectionDialog dialog = new FolderAndZipFolderSelectionDialog(
						btnWorkflowdirectory.getShell(), "Choose a folder:",
						workspace, template, appName, genName);
				Object data = wizardSelection.getData();
				if (data.equals(WizardConstants.RADIO_1))
					dialog.setFlags(true, true, true);
				else if (data.equals(WizardConstants.RADIO_2))
					dialog.setFlags(true, true, false);
				else
					dialog.setFlags(true, false, true);
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if (result != null)
					txtWorkflowdirectory.setText(((File) result[0]).toString());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// opens dialog to select an ".mwe2" file from the local file system.
		btnWorkflowtemplate.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog dialog = new FileDialog(btnWorkflowtemplate
						.getShell());
				dialog.setFilterNames(WizardConstants.WORKFLOW_FILTER_NAMES);
				dialog.setFilterExtensions(WizardConstants.WORKFLOW_FILTER_EXTENSIONS);
				dialog.setFilterPath(workspace.getLocation().toOSString());
				dialog.open();
				String filename = dialog.getFileName();
				if (!filename.equals("")) {
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
}
