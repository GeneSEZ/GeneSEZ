package de.genesez.core.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
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
import de.genesez.core.project.workflow.GeneratorProject;
import de.genesez.core.project.workflow.TargetProject;

public class ProjectWizard extends Wizard implements IExecutableExtension, INewWizard {

	private  static final String WORKFLOW = "de/genesez/core/project/workflow/project.oaw";
	
	private ProjectWizardPage page;

	private ISelection selection;

	private IConfigurationElement configElement;

	public ProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		this.page = new ProjectWizardPage(this.selection);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String name = this.page.getProjectName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					ProjectWizard.this.doFinish(name, monitor);
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

		// create the generator project first
		GeneratorProject gp = new GeneratorProject(monitor, name);

		// then create the target project
		TargetProject tp = new TargetProject(monitor, name);

		// fetch the selected wizard from page
		IPlatformWizard wizard = this.page.getPlatformWizard();

		// configure parameters for oAW workflow
		Map<String, String> theParams = new HashMap<String, String>();
		theParams.put("modelFile", wizard.getModel());
		theParams.put("generatorProjectDirectory", gp.getDirectory());
		theParams.put("targetProjectDirectory", gp.getDirectory());

		// create and run the workflow
		WorkflowRunner runner = new WorkflowRunner();
		runner.getContext().set("generatorProject", gp);
		runner.getContext().set("targetProject", tp);
		runner.run(ProjectWizard.WORKFLOW, null, theParams, null);

		monitor.worked(1);
	}
}
