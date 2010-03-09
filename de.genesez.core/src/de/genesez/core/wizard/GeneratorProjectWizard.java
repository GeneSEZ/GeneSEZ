package de.genesez.core.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.openarchitectureware.workflow.WorkflowRunner;

import de.genesez.core.IPlatformWizard;


public class GeneratorProjectWizard extends Wizard implements IExecutableExtension, INewWizard {

	private  static final String WORKFLOW = "de/genesez/core/project/workflow/generator.oaw";
	
	private GeneratorProjectWizardPage page;

	private ISelection selection;

	private IConfigurationElement configElement;

	public GeneratorProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		this.page = new GeneratorProjectWizardPage(this.selection);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String name = this.page.getProjectName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					GeneratorProjectWizard.this.doFinish(name, monitor);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		BasicNewProjectResourceWizard.updatePerspective(configElement);
		return true;
	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.configElement = config;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	private void doFinish(String name, IProgressMonitor monitor) {
		monitor.beginTask("Creating GeneSEZ Project " + name, 2);

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String workspacePath = workspace.getRoot().getLocation().toOSString();

		IProject project = workspace.getRoot().getProject(name);
		String projectPath = workspacePath + project.getFullPath().toOSString();
		final IProjectDescription projectDescription = workspace.newProjectDescription(name);

		IProject generatorProject = workspace.getRoot().getProject(name + ".generator");
		String generatorProjectPath = workspacePath + project.getFullPath().toOSString() + ".generator";
		final IProjectDescription generatorProjectDescription = workspace.newProjectDescription(name + ".generator");

		try {
			project.create(projectDescription, new SubProgressMonitor(monitor, 1));
			generatorProject.create(generatorProjectDescription, new SubProgressMonitor(monitor, 1));
		} catch (Exception e) {
			// TODO: Handle Exception in correct way
			e.printStackTrace();
		}
		
		if (project == null || generatorProject == null) {
			return;
		}

		String workFlowFile = GeneratorProjectWizard.WORKFLOW;
		Map<String, String> theParams = new HashMap<String, String>();
		IPlatformWizard wizard = this.page.getPlatformWizard();
		theParams.put("modelFile", wizard.getModel());
		theParams.put("targetDir", projectPath);
		theParams.put("generatorDir", generatorProjectPath);
		WorkflowRunner runner = new WorkflowRunner();
		runner.run(workFlowFile, null, theParams, null);

		monitor.worked(1);
	}
}
