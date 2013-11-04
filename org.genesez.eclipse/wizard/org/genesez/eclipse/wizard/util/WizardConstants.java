/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;

/**
 * Contains constants for the org.eclipse.genesez plugin. Mainly in use with dependency injection to pass the right values to the
 * receiver.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * @noextend should not be extended.
 */
public class WizardConstants {

	// Integer values for Radio Buttons

	/** Data for first radio button in a selection field (value == 0) */
	public static final int RADIO_1 = 0;
	/** Data for second radio button in a selection field (value == 1) */
	public static final int RADIO_2 = 1;
	/** Data for third radio button in a selection field(value == 2) */
	public static final int RADIO_3 = 2;

	// Constants for usage in an IEclipseContext
	
	/**
	 * Category for GeneSEZ commands.
	 */
	public static final String GENESEZ_CATEGORY_NAME = "org.genesez.eclipse";
	
	/**
	 * Command to create GeneSEZ projects.
	 */
	public static final String CREATE_PROJECT_COMMAND_NAME = "org.genesez.eclipse.create";
	
	/**
	 * To determine the workflow template file String (key == workflow.template, valueType: {@link java.lang.String})
	 */
	public static final String WORKFLOW_TEMPLATE = "workflow.template";

	/**
	 * To determine the workflow filename as String (key == workflow.filename, valueType: {@link java.lang.String})
	 */
	public static final String WORKFLOW_FILENAME = "workflow.filename";

	/**
	 * To determine the directory where the workflow will be stored as String (key == workflow.directory, valueType:
	 * {@link java.lang.String})
	 */
	public static final String WORKFLOW_DIRECTORY = "workflow.directory";

	/**
	 * To determine the button for the wizard selection (key == choose.wizard, valueType: {@link org.eclipse.swt.widgets.Button})
	 */
	public static final String CHOOSE_WIZARD = "choose.wizard";

	/**
	 * To determine the button for workflow selection (key == choose.workflow, valueType: {@link org.eclipse.swt.widgets.Button})
	 */
	public static final String CHOOSE_WORKFLOW = "choose.workflow";

	/**
	 * To determine the current description (key == description, valueType: {@link java.lang.String})
	 */
	public static final String DESCRIPTION = "description";

	/**
	 * To determine the generator project name (key == generator.project.name, valueType: {@link java.lang.String})
	 */
	public static final String GEN_PROJ_NAME = "generator.project.name";

	/**
	 * To determine the application project name (key == application.project.name, valueType: {@link java.lang.String})
	 */
	public static final String APP_PROJ_NAME = "application.project.name";

	/**
	 * To determine if its example Wizard or not (key == is.example, valueType: boolean)
	 */
	public static final String IS_EXAMPLE = "is.example";

	/**
	 * To determine the chosen template (key == template.selection, valueType:
	 * {@link org.genesez.eclipse.wizard.util.TemplateConfigXml})
	 */
	public static final String TEMPLATE = "template.selection";

	/**
	 * To determine the current visible wizard page (key == current.wizard.page, valueType:
	 * {@link org.eclipse.jface.wizard.IWizardPage})
	 */
	public static final String CURRENT_PAGE = "current.wizard.page";

	/**
	 * To determine the chosen files for the application model (key == application.model.list, valueType: {@link java.util.Set}<
	 * {@link java.io.File}>)
	 */
	public static final String APPLICATION_MODEL_COLLECTION = "application.model.list";

	/**
	 * To determine if application model files should be copied (key == copy.model.files, valueType: boolean)
	 */
	public static final String COPY_MODEL_FILES = "copy.model.files";

	/**
	 * To determine root of the application model (key == application.model.root, valueType:
	 * {@link org.eclipse.core.runtime.IPath} )
	 */
	public static final String APPLICATION_MODEL_ROOT = "application.model.root";

	/**
	 * To determine the destination where the application model should be stored (key == application.model.destination, valueType:
	 * {@link java.lang.String})
	 */
	public static final String APPLICATION_MODEL_DESTINATION = "application.model.destination";

	/**
	 * To determine if the plugin wizard should be started (key == start.plugin.wizard, valueType: boolean)
	 */
	public static final String START_PLUGIN_WIZARD = "start.plugin.wizard";

	// important String values

	/** The ID of the Plugin. IMPORTANT: Must be same as in MANIFEST.MF */
	public static final String PLUGIN_ID = "org.genesez.eclipse";

	/** The ID for the GeneSEZ generator nature */
	public static final String NATURE_ID = "genesezgennature";

	/** The Filter names for workflow file selection dialog */
	public static final String[] WORKFLOW_FILTER_NAMES = new String[] { "Any MWE Workflowfile (*.mwe2; *.mwe)",
			"MWE2 Workflowfile (*.mwe2)", "Old MWE Workflowfile (*.mwe)" };

	/** The Extension Patterns for workflow file selection dialog */
	public static final String[] WORKFLOW_FILTER_EXTENSIONS = new String[] { "*.mwe2;*.mwe", "*.mwe2", "*.mwe" };

	/** Used to Store the original path with a TreeItem */
	public static final String ORIGINAL_PATH = "original.path";

	// Constants for Layout behaviour

	/**
	 * GridLayout for use with textfield with button. To use with GridLayoutFactory.copyLayout()
	 */
	public static final GridLayout L_GL_TXTBTN = new GridLayout(5, true);
	/**
	 * GridData for textfield with button [text], only useful in GridLayout(5, true)
	 */
	public static final GridData L_GD_TXTBTN_TEXT = new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1);
	/**
	 * GridData for textfield with button [button], only useful in GridLayout(5, true)
	 */
	public static final GridData L_GD_TXTBTN_BUTTON = new GridData(SWT.FILL, SWT.CENTER, true, false);

	// empty Constructor
	private WizardConstants() {
	};
}
