package de.genesez.core.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

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


public class PlatformWizard extends Wizard implements INewWizard, IExecutableExtension {

	private  static final String WORKFLOW = "de/genesez/core/project/workflow/platform.oaw";
	
	private PlatformWizardPage page;

	private ISelection selection;

	private IConfigurationElement configElement;

	public PlatformWizard() {
		super();
		setNeedsProgressMonitor(true);
	}

	@Override
	public void addPages() {
		this.page = new PlatformWizardPage(this.selection);
		this.addPage(this.page);
	}

	@Override
	public boolean performFinish() {
		final String name = this.page.getProjectName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					PlatformWizard.this.doFinish(name, monitor);
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

	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
	}

	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		this.configElement = config;
	}
	
	private void doFinish(String name, IProgressMonitor monitor) {
		monitor.beginTask("Creating GeneSEZ Platform " + name, 2);

		String workFlowFile = PlatformWizard.WORKFLOW;
		Map<String, String> theParams = new HashMap<String, String>();
//		IPlatformWizard wizard = this.page.getPlatformWizard();
//		theParams.put("modelFile", wizard.getModel());
		WorkflowRunner runner = new WorkflowRunner();
		runner.getContext().set("name", name);
		runner.getContext().set("monitor", monitor);
		runner.run(workFlowFile, null, theParams, null);

		monitor.worked(1);
	}

}
