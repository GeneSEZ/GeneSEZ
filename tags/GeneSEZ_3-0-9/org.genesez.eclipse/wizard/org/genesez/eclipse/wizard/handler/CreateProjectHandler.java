/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.handler;

import java.io.File;
import java.net.URL;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.commands.Category;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IParameter;
import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.pde.internal.ui.wizards.plugin.NewPluginProjectWizard;
import org.eclipse.swt.widgets.Button;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.wizard.util.AfterProjectCreationHelper;
import org.genesez.eclipse.wizard.util.TemplateConfigXml;
import org.genesez.eclipse.wizard.util.TemplateHelper;
import org.genesez.eclipse.wizard.util.WizardConstants;

/**
 * Handles the creation of a project. Gets all parameters from the Context.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 */
public class CreateProjectHandler {

	@Inject
	private IWorkspaceRoot workspace;
	
	/**
	 * Standard constructor
	 */
	public CreateProjectHandler() {
	}
	
	/**
	 * Returns the parameterized command to create GeneSEZ projects.
	 * 
	 * @param commandService	The command service to define new categories + commands.
	 * @param handlerService	The handler service to execute commands.
	 * @param context			The current eclipse context.
	 * @return					The paramerized command to create GeneSEZ projects.
	 */
	public ParameterizedCommand createProjectCommand(ECommandService commandService, EHandlerService handlerService, IEclipseContext context) {
		Category genesez = commandService.defineCategory(WizardConstants.GENESEZ_CATEGORY_NAME, "GeneSEZ Commands", "A category to collect all genesez commands.");
		Command createProjectCommand = commandService.defineCommand(WizardConstants.CREATE_PROJECT_COMMAND_NAME, "Create GeneSEZ Project", "Creates an application and a genesez generator project.", genesez, new IParameter[0]);
		ContextInjectionFactory.inject(this, context);
		handlerService.activateHandler(WizardConstants.CREATE_PROJECT_COMMAND_NAME, this);
		ParameterizedCommand pc = ParameterizedCommand.generateCommand(createProjectCommand, null);
		return pc;
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
	public boolean createProject(@Named(WizardConstants.IS_EXAMPLE) boolean example,
			@Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Named(WizardConstants.GEN_PROJ_NAME) String genProjectName,
			@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button wizardButton,
			@Optional @Named(WizardConstants.START_PLUGIN_WIZARD) boolean startPIWizard,
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_COLLECTION) Set<File> appModelFiles,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_DESTINATION) String appModelDestination,
			@Optional @Named(WizardConstants.COPY_MODEL_FILES) boolean copyModelFiles,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_ROOT) File appModelRoot,
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button workflowButton,
			@Optional @Named(WizardConstants.WORKFLOW_TEMPLATE) String workflowTemplate,
			@Optional @Named(WizardConstants.WORKFLOW_FILENAME) String workflowFilename,
			@Optional @Named(WizardConstants.WORKFLOW_DIRECTORY) String workflowDirectory, IWorkbench workbench) {
		if (example)
			// for exampleProject creation
			TemplateHelper.createProject(template, appProjectName, genProjectName, workspace, true, true);
		else {
			Object wizardSelection = wizardButton.getData();
			if (wizardSelection.equals(WizardConstants.RADIO_1)) {
				TemplateHelper.createProject(template, appProjectName, genProjectName, workspace, true, true);
				if (checkProjectCreationJob())
					handleAppModel(appProjectName, genProjectName, appModelFiles, copyModelFiles, appModelRoot,
							appModelDestination);
			} else if (wizardSelection.equals(WizardConstants.RADIO_2)) {
				TemplateHelper.createProject(template, appProjectName, genProjectName, workspace, true, false);
				if (checkProjectCreationJob()) {
					handleAppModel(appProjectName, genProjectName, appModelFiles, copyModelFiles, appModelRoot,
							appModelDestination);
					Object workflowSelection = workflowButton.getData();
					if (workflowSelection.equals(WizardConstants.RADIO_2))
						handleWorkflow(null, workflowFilename, workflowDirectory, appProjectName);
					else if (workflowSelection.equals(WizardConstants.RADIO_3))
						handleWorkflow(workflowTemplate, workflowFilename, workflowDirectory, appProjectName);
				}
			} else {
				if (startPIWizard) {
					NewPluginProjectWizard wizard = new NewPluginProjectWizard();
					wizard.init(workbench, null);
					WizardDialog dialog = new WizardDialog(workbench.getActiveWorkbenchWindow().getShell(), wizard);
					dialog.open();
				} else {
					URL url = TemplateHelper.class.getProtectionDomain().getCodeSource()
							.getLocation();
					File file = new File(url.getPath().concat(TemplateHelper.DEFAULT_GEN_TEMPLATE));
					TemplateConfigXml defaultTemplate = TemplateHelper.readArchive(file);
					TemplateHelper.createProject(defaultTemplate, appProjectName, genProjectName, workspace, false, true);
				}
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
	 * Synchronizing with the projectCreationJob.
	 */
	private boolean checkProjectCreationJob() {
		int state;
		while ((state = TemplateHelper.createJob.getState()) != IStatus.OK) {
			if (state == IStatus.CANCEL)
				return false;
		}
		return true;
	}

	/**
	 * handles the application Model.
	 * 
	 * @param appProjectName
	 *            the application project name.
	 * @param genProjectName
	 *            the generator project name.
	 * @param appModelList
	 *            the application model list.
	 * @param copyModelFiles
	 *            if files should be copied.
	 * @param appModelDestination
	 *            the destination to store the application model.
	 * @return true if everything works.
	 */
	private boolean handleAppModel(String appProjectName, String genProjectName, Set<File> appModelList, boolean copyModelFiles,
			File appModelRoot, String appModelDestination) {
		if (appModelList != null) {
			IProject project = null;
			IPath destinationPath = new Path(appModelDestination);
			if (appModelDestination.startsWith(appProjectName + File.separator))
				project = workspace.getProject(appProjectName);
			else
				project = workspace.getProject(genProjectName);
			AfterProjectCreationHelper.addApplicationModel(project, appModelList, copyModelFiles, appModelRoot, destinationPath);
			return true;
		}
		return false;
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
	private boolean handleWorkflow(String template, String fileName, String folder, String appProjectName) {
		AfterProjectCreationHelper.addWorklfowfile(template, fileName, folder, appProjectName, workspace);
		return true;
	}
}
