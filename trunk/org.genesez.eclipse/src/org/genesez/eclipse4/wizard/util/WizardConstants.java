package org.genesez.eclipse4.wizard.util;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;

public class WizardConstants {
	
	// Integer values for Radio Buttons
	
	public static final int RADIO_1 = 0;
	public static final int RADIO_2 = 1;
	public static final int RADIO_3 = 2;
	
	// Strings for the DI context
	
	public static final String WORKFLOW_TEMPLATE = "workflow.template";
	public static final String WORKFLOW_FILENAME = "workflow.filename";
	public static final String WORKFLOW_DIRECTORY = "workflow.directory";
	public static final String CHOOSE_WIZARD = "choose.wizard";
	public static final String CHOOSE_WORKFLOW = "choose.workflow";
	public static final String DESCRIPTION = "description";
	public static final String GEN_PROJ_NAME = "generator.project.name";
	public static final String APP_PROJ_NAME = "application.project.name";
	public static final String IS_EXAMPLE = "is.example";
	public static final String TEMPLATE = "template.selection";
	public static final String CURRENT_PAGE = "current.wizard.page";
	public static final String APPLICATION_MODEL_LIST = "application.model.list";
	public static final String COPY_MODEL_FILES = "copy.model.files";
	
	// important String values
	
	public static final String PLUGIN_ID = "org.genesez.eclipse";
	public static final String NATURE_ID = "genesezgennature";
	public static final String[] WORKFLOW_FILTER_NAMES = new String[]{"Any MWE Workflowfile (*.mwe2; *.mwe)","MWE2 Workflowfile (*.mwe2)", "Old MWE Workflowfile (*.mwe)"};
	public static final String[] WORKFLOW_FILTER_EXTENSIONS = new String[]{"*.mwe2;*.mwe","*.mwe2","*.mwe"}; 
	public static final String ORIGINAL_PATH = "original.path";

	// Constants for Layout behaviour
	
	/** GridLayout for use with textfield with button. To use with GridLayoutFactory.copyLayout() */
	public static final GridLayout L_GL_TXTBTN = new GridLayout(5,true);
	/** GridData for textfield with button [text], only useful in GridLayout(5, true) */
	public static final GridData L_GD_TXTBTN_TEXT = new GridData(SWT.FILL, SWT.CENTER, true, false, 4,1);
	/** GridData for textfield with button [button], only useful in GridLayout(5, true) */
	public static final GridData L_GD_TXTBTN_BUTTON = new GridData(SWT.FILL, SWT.CENTER, true, false);

	// empty Constructor
	private WizardConstants(){};
}
