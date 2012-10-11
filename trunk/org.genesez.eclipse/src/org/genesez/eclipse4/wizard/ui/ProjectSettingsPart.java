package org.genesez.eclipse4.wizard.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.Focus;
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
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class ProjectSettingsPart {
	private static final String PROJECT_INSERT_MESSAGE = "Insert application project name";
	private static final String PROJECT_CHOOSE_MESSAGE = "Choose application project";
	private static final String GENERATOR_INSERT_MESSAGE = "Insert generator project name";
	private static final String GENERATOR_CHOOSE_MESSAGE = "Choose generator project";
	
	private Text textProjectname;
	private Text textGeneratorname;
	private GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false, 4,1);
	private GridData buttonData = new GridData(SWT.FILL, SWT.CENTER, true, false);
	private Button browseProject;
	private Button browseGenerator;
	private Group grpProjectSettings;
	private Object radioData;
	private boolean textNotSet = true;
	
	@Inject IEclipseContext context;

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(final Composite parent) {
		grpProjectSettings = new Group(parent, SWT.BORDER | SWT.SHADOW_ETCHED_IN);
		grpProjectSettings.setText("Project Settings");
		grpProjectSettings.setLayout(new GridLayout(5,true));
				
		textProjectname = new Text(grpProjectSettings, SWT.BORDER);
		textProjectname.setLayoutData(textData);
		textProjectname.setToolTipText(PROJECT_INSERT_MESSAGE);
		textProjectname.setEnabled(false);
		
		browseProject = new Button(grpProjectSettings, SWT.NONE);
		browseProject.setLayoutData(buttonData);
		browseProject.setText("Browse...");
		browseProject.setEnabled(false);
		
		textGeneratorname = new Text(grpProjectSettings, SWT.BORDER);
		textGeneratorname.setLayoutData(textData);
		textGeneratorname.setToolTipText(GENERATOR_INSERT_MESSAGE);
		textGeneratorname.setEnabled(false);
		
		browseGenerator = new Button(grpProjectSettings, SWT.NONE);
		browseGenerator.setLayoutData(buttonData);
		browseGenerator.setText("Browse...");
		browseGenerator.setEnabled(false);
		
		addListener(parent);
		
//		e = new FileFieldEditor("editor", "", grpProjectSettings);
////		editor = new StringButtonFieldEditor("generated.project",
////				"Select project:", grpProjectSettings) {
////
////			SelectionDialog dialog = new ContainerSelectionDialog(
////					parent.getShell(), null, false, "Choose Project");
////
////			@Override
////			protected String changePressed() {
////				dialog.setBlockOnOpen(true);
////				dialog.open();
////				Object[] result = dialog.getResult();
////				if (result == null) {
////					return "";
////				}
////				return result[0].toString();
////			}
////
////			@Override
////			public void dispose() {
////				dialog.closeTray();
////			}
////		};
//		e.setEmptyStringAllowed(true);
//		e.setChangeButtonText("Browse...");
//		e.fillIntoGrid(grpProjectSettings, 3);
	}
	
	@Inject
	private void setProjectSettingElements(@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button selectedRadioButton){
		if(selectedRadioButton != null && !grpProjectSettings.isDisposed()){
			radioData = selectedRadioButton.getData();
			if(radioData.equals(WizardConstants.RADIO_1)){
				textNotSet = true;
				textProjectname.setMessage(PROJECT_INSERT_MESSAGE);
				textGeneratorname.setMessage(GENERATOR_INSERT_MESSAGE);
				textProjectname.setEditable(true);
				textGeneratorname.setEditable(true);
				browseProject.setEnabled(false);
				browseGenerator.setEnabled(false);
			} else if(radioData.equals(WizardConstants.RADIO_2)){
				textNotSet = false;
				textProjectname.setMessage(PROJECT_INSERT_MESSAGE);
				textGeneratorname.setMessage(GENERATOR_CHOOSE_MESSAGE);
				textProjectname.setEditable(true);
				textGeneratorname.setEditable(false);
				browseProject.setEnabled(false);
				browseGenerator.setEnabled(true);
			} else if(radioData.equals(WizardConstants.RADIO_3)){
				textNotSet = false;
				textProjectname.setMessage(PROJECT_CHOOSE_MESSAGE);
				textGeneratorname.setMessage(GENERATOR_INSERT_MESSAGE);
				textProjectname.setEditable(false);
				textGeneratorname.setEditable(true);
				browseProject.setEnabled(true);
				browseGenerator.setEnabled(false);
			}
			textProjectname.setText("");
			textGeneratorname.setText("");
			textProjectname.setEnabled(true);
			textGeneratorname.setEnabled(true);
		}
	}
	
	private void addListener(final Composite parent){
		// set APP_PROJ_NAME in context and adds ".generator" on textGeneratorname if possible. 
		textProjectname.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				if(radioData != null && radioData.equals(WizardConstants.RADIO_1) && textNotSet){
					textGeneratorname.setText(textProjectname.getText().concat(".generator"));
				}
				context.modify(WizardConstants.APP_PROJ_NAME, textProjectname.getText().trim());
			}
		});
		
		// disables the overwriting from above with ".generator", if a key is pressed on textGeneratorname
		textGeneratorname.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(org.eclipse.swt.events.KeyEvent e) {
				if(textGeneratorname.getText().equals("")){
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
				context.modify(WizardConstants.GEN_PROJ_NAME,textGeneratorname.getText().trim());
			}
		});
		
		// opens a dialog to select a project
		browseGenerator.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectionDialog dialog = getSelectionDialog(parent);
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if(result != null)
					textGeneratorname.setText(((Path) dialog.getResult()[0]).toString());
				dialog.closeTray();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
		
		// opens a dialog to select a project
		browseProject.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				SelectionDialog dialog = getSelectionDialog(parent);
				dialog.setBlockOnOpen(true);
				dialog.open();
				Object[] result = dialog.getResult();
				if(result != null)
					textProjectname.setText(((Path) dialog.getResult()[0]).toString());
				dialog.closeTray();
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}
		});
	}
	
	private SelectionDialog getSelectionDialog(Composite parent){
		SelectionDialog dialog = new ContainerSelectionDialog(
				parent.getShell(), null, false, "Choose Project");
		return dialog;
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		grpProjectSettings.setFocus();
	}
}
