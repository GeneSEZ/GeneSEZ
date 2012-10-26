package org.genesez.eclipse4.wizard.handler;

import java.io.File;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.swt.widgets.Button;
import org.genesez.eclipse4.wizard.util.AfterProjectCreationHelper;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.TemplateHelper;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * Handles the creation of a project.
 * Gets all parameters from the Context.
 * @author Dominik Wetzel
 */
@SuppressWarnings("restriction")
public class CreateProjectHandler {

	@Inject
	private IWorkspaceRoot workspace;

	/**
	 * Standard constructor
	 */
	public CreateProjectHandler(){
	}

	/**
	 * Creates the project gets every parameter from the context.
	 * 
	 * @param example
	 *            if its called from the example Wizard.
	 * @param appProjectName
	 *            the application project name.
	 * @param genProjectName
	 *            the generator project name.
	 * @param wizardButton
	 *            the radio button to determine the wizard type.
	 * @param template
	 *            the information about the zipfile template.
	 * @param appModelFiles
	 *            the application model files.
	 * @param copyModelFiles
	 *            true if model files should be copied.
	 * @param workflowButton
	 *            the radio button to determine the workflow file creation.
	 * @param workflowTemplate
	 *            the template file for the workflow.
	 * @param workflowFilename
	 *            the filename for the workflow file.
	 * @param workflowDirectory
	 *            the directory where the workflowfile should be stored.
	 * @return true if everything works
	 * @see Execute
	 */
	@Execute
	public boolean createProject(
			@Named(WizardConstants.IS_EXAMPLE) boolean example,
			@Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Named(WizardConstants.GEN_PROJ_NAME) final String genProjectName,
			@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button wizardButton,
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_LIST) Set<File> appModelFiles,
			@Optional @Named(WizardConstants.COPY_MODEL_FILES) boolean copyModelFiles,
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button workflowButton,
			@Optional @Named(WizardConstants.WORKFLOW_TEMPLATE) String workflowTemplate,
			@Optional @Named(WizardConstants.WORKFLOW_FILENAME) String workflowFilename,
			@Optional @Named(WizardConstants.WORKFLOW_DIRECTORY) String workflowDirectory) {
		if (example)
			// for exampleProject creation
			TemplateHelper.createProject(template, appProjectName,
					genProjectName, workspace, true, true);
		else {
			Object wizardSelection = wizardButton.getData();
			if (wizardSelection.equals(WizardConstants.RADIO_1)) {
				TemplateHelper.createProject(template, appProjectName,
						genProjectName, workspace, true, true);
				handleAppModel(appProjectName, appModelFiles, copyModelFiles);
			} else if (wizardSelection.equals(WizardConstants.RADIO_2)) {
				TemplateHelper.createProject(template, appProjectName,
						genProjectName, workspace, true, false);
				handleAppModel(appProjectName, appModelFiles, copyModelFiles);
				Object workflowSelection = workflowButton.getData();
				if (workflowSelection.equals(WizardConstants.RADIO_2))
					handleWorkflow(null, workflowFilename, workflowDirectory,
							appProjectName);
				else if (workflowSelection.equals(WizardConstants.RADIO_3))
					handleWorkflow(workflowTemplate, workflowFilename,
							workflowDirectory, appProjectName);
			} else {
				TemplateHelper.createProject(template, appProjectName,
						genProjectName, workspace, false, true);
			}
		}
		try {
			workspace.refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * handles the application Model.
	 * 
	 * @param appProjectName
	 *            the application project name.
	 * @param appModelList
	 *            the application model list.
	 * @param copyModelFiles
	 *            if files should be copied.
	 * @return true if everything works.
	 */
	private boolean handleAppModel(String appProjectName,
			Set<File> appModelList, boolean copyModelFiles) {
		IProject project = workspace.getProject(appProjectName);
		AfterProjectCreationHelper.addApplicationModel(project, appModelList,
				copyModelFiles);
		return true;
	}

	/**
	 * handles the workflow creation.
	 * 
	 * @param template
	 *            the workflow template.
	 * @param fileName
	 *            the workflow file name.
	 * @param folder
	 *            the workflow directory to create file into
	 * @param appProjectName
	 *            the application project name.
	 * @return true if everything works
	 */
	private boolean handleWorkflow(String template, String fileName,
			String folder, String appProjectName) {
		AfterProjectCreationHelper.addWorklfowfile(template, fileName, folder,
				appProjectName, workspace);
		return true;
	}
}
