package org.genesez.eclipse4.wizard;

import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.genesez.eclipse4.wizard.handler.CreateProjectHandler;
import org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardSelectionPage;
import org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardTemplatePage;
import org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardWorkflowPage;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * The GeneSEZ Project Wizard, used to create GeneSEZ Projects with application
 * and/or generator project from templates.
 * 
 * @author Dominik Wetzel
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZProjectWizard extends Wizard implements INewWizard {

	private MWindow hostWin;
	private ParameterizedCommand executeCommand;
	private IWizardPage page1;
	private IWizardPage page2;
	private IWizardPage page3;
	private IEclipseContext context;

	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	/**
	 * constructs the wizard
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public GeneSEZProjectWizard() throws SecurityException,
			NoSuchMethodException {
		initialize();
	}

	/**
	 * Initializes the context, pages and the handler.
	 */
	private void initialize() {
		IWorkbenchWindow wbw = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		hostWin = (MWindow) wbw.getService(MWindow.class);
		context = hostWin.getContext();
		ContextInjectionFactory.inject(this, context);
		setContextInitial();

		page1 = new GeneSEZProjectWizardSelectionPage("Create Projects",
				hostWin);
		page2 = new GeneSEZProjectWizardTemplatePage("Choose Template", hostWin);
		page3 = new GeneSEZProjectWizardWorkflowPage("Choose Workflow", hostWin);

		executeCommand = commandService.createCommand("create.projects", null);
		CreateProjectHandler handler = new CreateProjectHandler();
		ContextInjectionFactory.inject(handler, context);
		handlerService.activateHandler("create.projects", handler);
	}

	/**
	 * Adds the pages to the wizard.
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}

	/**
	 * Calls the handler {@link CreateProjectHandler}
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		handlerService.executeHandler(executeCommand);
		return true;
	}

	/**
	 * If all pages are completed canFinish is true.
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return page1.isPageComplete() && page2.isPageComplete()
				&& page3.isPageComplete();
	}

	/**
	 * Disposes the wizard.
	 * @see org.eclipse.jface.wizard.Wizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		this.dispose();
		return super.performCancel();
	}

	/**
	 * initializes the context, so no error occurs during restart.
	 */
	private void setContextInitial() {
		context.set(WizardConstants.TEMPLATE, null);
		context.set(WizardConstants.IS_EXAMPLE, false);
		context.set(WizardConstants.CHOOSE_WIZARD, null);
		context.set(WizardConstants.APP_PROJ_NAME, null);
		context.set(WizardConstants.GEN_PROJ_NAME, null);
		context.set(WizardConstants.DESCRIPTION, null);
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.set(WizardConstants.CHOOSE_WORKFLOW, null);
		context.set(WizardConstants.WORKFLOW_TEMPLATE, null);
		context.set(WizardConstants.WORKFLOW_FILENAME, null);
		context.set(WizardConstants.WORKFLOW_DIRECTORY, null);
		context.set(WizardConstants.APPLICATION_MODEL_LIST, null);
		context.set(WizardConstants.COPY_MODEL_FILES, false);
		context.set(WizardConstants.APPLICATION_MODEL_ROOT, null);
		context.set(IWizardPage.class, null);
		context.set(IWorkspaceRoot.class, ResourcesPlugin.getWorkspace()
				.getRoot());
		context.set(IWorkbench.class, PlatformUI.getWorkbench());
	}
}
