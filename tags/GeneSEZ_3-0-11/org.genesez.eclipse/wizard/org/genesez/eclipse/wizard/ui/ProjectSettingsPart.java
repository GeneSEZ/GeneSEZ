/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.ui;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.genesez.eclipse.wizard.util.ProjectSelectionDialog;
import org.genesez.eclipse.wizard.util.WizardConstants;

/**
 * Part to enter an application and a generator project name. Also used to choose application or generator project
 * 
 * Modify context elements:
 * <p>
 * {@link WizardConstants#APP_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#GEN_PROJ_NAME}
 * </p>
 * <p>
 * {@link WizardConstants#START_PLUGIN_WIZARD}
 * </p>
 * 
 * Listens to context element:
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
public class ProjectSettingsPart {
	private static final String PROJECT_INSERT_MESSAGE = "Insert application project name";
	// private static final String PROJECT_CHOOSE_MESSAGE = "Choose application project";
	private static final String GENERATOR_INSERT_MESSAGE = "Insert generator project name";
	private static final String GENERATOR_CHOOSE_MESSAGE = "Choose generator project";

	private Group grpProjectSettings;
	private Text textProjectname;
	private Text textGeneratorname;
	// private Button browseProject;
	private Button browseGenerator;
	private Button btnPlugInProject;

	private Object radioData;
	private boolean textNotSet = true;

	@Inject
	private IEclipseContext context;
	@Inject
	private IWorkspaceRoot workspace;

	/**
	 * Standard constructor
	 */
	public ProjectSettingsPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(final Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		grpProjectSettings = new Group(parent, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpProjectSettings.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		grpProjectSettings.setText("Project Settings");
		grpProjectSettings.setLayout(GridLayoutFactory.copyLayout(WizardConstants.L_GL_TXTBTN));

		textProjectname = new Text(grpProjectSettings, SWT.BORDER);
		textProjectname.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		// textProjectname.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		textProjectname.setToolTipText(PROJECT_INSERT_MESSAGE);
		textProjectname.setMessage(PROJECT_INSERT_MESSAGE);
		textProjectname.setEnabled(false);

		// browseProject = new Button(grpProjectSettings, SWT.NONE);
		// browseProject.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		// browseProject.setText("Browse...");
		// browseProject.setEnabled(false);

		textGeneratorname = new Text(grpProjectSettings, SWT.BORDER);
		textGeneratorname.setLayoutData(WizardConstants.L_GD_TXTBTN_TEXT);
		textGeneratorname.setToolTipText(GENERATOR_INSERT_MESSAGE);
		textGeneratorname.setMessage(GENERATOR_INSERT_MESSAGE);
		textGeneratorname.setEnabled(false);

		browseGenerator = new Button(grpProjectSettings, SWT.NONE);
		browseGenerator.setLayoutData(WizardConstants.L_GD_TXTBTN_BUTTON);
		browseGenerator.setText("Browse...");
		browseGenerator.setEnabled(false);

		btnPlugInProject = new Button(grpProjectSettings, SWT.CHECK);
		btnPlugInProject.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		btnPlugInProject.setText("Open Plugin-Project Wizard");
		btnPlugInProject
				.setToolTipText("If not checked a default generator project will be created, else a plugin Wizard will open.");
		btnPlugInProject.setEnabled(false);
		addListener();
	}

	/**
	 * Sets the state of the project settings elements depending on {@link WizardConstants#CHOOSE_WIZARD}
	 * 
	 * @param selectedRadioButton
	 *            the selected button.
	 */
	@Inject
	private void setProjectSettingElements(@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button selectedRadioButton) {
		if (selectedRadioButton != null && grpProjectSettings != null && !grpProjectSettings.isDisposed()) {
			radioData = selectedRadioButton.getData();
			textProjectname.setText("");
			textGeneratorname.setText("");
			textProjectname.setEnabled(true);
			textGeneratorname.setEnabled(true);
			if (radioData.equals(WizardConstants.RADIO_1)) {
				textNotSet = true;
				textProjectname.setMessage(PROJECT_INSERT_MESSAGE);
				textGeneratorname.setMessage(GENERATOR_INSERT_MESSAGE);
				textProjectname.setEditable(true);
				textGeneratorname.setEditable(true);
				// browseProject.setEnabled(false);
				browseGenerator.setEnabled(false);
				btnPlugInProject.setEnabled(false);
			} else if (radioData.equals(WizardConstants.RADIO_2)) {
				textNotSet = false;
				textProjectname.setMessage(PROJECT_INSERT_MESSAGE);
				textGeneratorname.setMessage(GENERATOR_CHOOSE_MESSAGE);
				textProjectname.setEditable(true);
				textGeneratorname.setEditable(false);
				// browseProject.setEnabled(false);
				browseGenerator.setEnabled(true);
				btnPlugInProject.setEnabled(false);
			} else if (radioData.equals(WizardConstants.RADIO_3)) {
				textNotSet = false;
				textGeneratorname.setMessage(GENERATOR_INSERT_MESSAGE);
				if(btnPlugInProject.getSelection())
					textGeneratorname.setEnabled(false);
				else{
					textGeneratorname.setEditable(true);
				}
				// textProjectname.setEditable(false);
				// browseProject.setEnabled(true);
				textProjectname.setEnabled(false);
				browseGenerator.setEnabled(false);
				btnPlugInProject.setEnabled(true);
			}
		}
	}

	/**
	 * Adds needed listener.
	 */
	private void addListener() {
		// set APP_PROJ_NAME in context and adds ".generator" on
		// textGeneratorname if possible.
		textProjectname.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if (radioData != null && radioData.equals(WizardConstants.RADIO_1) && textNotSet) {
					textGeneratorname.setText(textProjectname.getText().concat(".generator"));
				}
				context.modify(WizardConstants.APP_PROJ_NAME, textProjectname.getText().trim());
			}
		});

		// disables the overwriting from above with ".generator", if a key is
		// pressed on textGeneratorname
		textGeneratorname.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
				if (textGeneratorname.getText().equals("")) {
					textNotSet = true;
				}
			}

			@Override
			public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
				textNotSet = false;
			}
		});

		// sets GEN_PROJ_NAME in context
		textGeneratorname.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				context.modify(WizardConstants.GEN_PROJ_NAME, textGeneratorname.getText().trim());
			}
		});

		// opens a dialog to select a project
		browseGenerator.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectionDialog dialog = new ProjectSelectionDialog(browseGenerator.getShell(), "Choose Project:", workspace,
						true);
				String result = dialogResult(dialog);
				if (result != null)
					textGeneratorname.setText(result);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});

		// // opens a dialog to select a project
		// browseProject.addSelectionListener(new SelectionListener() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// SelectionDialog dialog = new ProjectSelectionDialog(
		// browseProject.getShell(), "Choose Project:", workspace,
		// false);
		// String result = dialogResult(dialog);
		// if (result != null)
		// textProjectname.setText(result);
		// }
		//
		// @Override
		// public void widgetDefaultSelected(SelectionEvent e) {
		// }
		// });

		btnPlugInProject.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnPlugInProject.getSelection()) {
					textGeneratorname.setEnabled(false);
				} else {
					textGeneratorname.setEnabled(true);
				}
				context.modify(WizardConstants.START_PLUGIN_WIZARD, btnPlugInProject.getSelection());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}

	/**
	 * Gets the result of a dialog as String
	 * 
	 * @param dialog
	 *            the dialog to get the result from
	 * @return the result as String
	 */
	private String dialogResult(SelectionDialog dialog) {
		dialog.setBlockOnOpen(true);
		dialog.open();
		if (dialog.getReturnCode() == Window.OK) {
			Object[] result = dialog.getResult();
			if (result != null)
				return ((IProject) dialog.getResult()[0]).getName();
		}
		return null;
	}
}
