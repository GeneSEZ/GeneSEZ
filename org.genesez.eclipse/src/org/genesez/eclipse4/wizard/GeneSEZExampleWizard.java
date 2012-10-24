package org.genesez.eclipse4.wizard;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
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
import org.genesez.eclipse4.wizard.page.GeneSEZExampleWizardPage;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZExampleWizard extends Wizard implements INewWizard {

	private MWindow hostWin;
	private ParameterizedCommand executeCommand;
	private IEclipseContext context;
	
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	public GeneSEZExampleWizard() throws SecurityException, NoSuchMethodException {
		IWorkbenchWindow wbw = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		hostWin = (MWindow) wbw.getService(MWindow.class);
		context = hostWin.getContext();
		ContextInjectionFactory.inject(this, context);
		setContextInitial();
	}
	
	@PostConstruct
	public void initialize(){
		executeCommand = commandService.createCommand("create.projects", null);
		CreateProjectHandler handler = new CreateProjectHandler();
		ContextInjectionFactory.inject(handler, context);
		handlerService.activateHandler("create.projects", handler);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(new GeneSEZExampleWizardPage("Create example projects", hostWin));
	}

	@Override
	public boolean performFinish() {
		handlerService.executeHandler(executeCommand);
		return true;
	}
	
	@PreDestroy
	private void setContextInitial(){
		context.set(WizardConstants.DESCRIPTION, null);
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.set(WizardConstants.APP_PROJ_NAME, null);
		context.set(WizardConstants.GEN_PROJ_NAME, null);
		context.set(WizardConstants.TEMPLATE, null);
		context.set(IWizardPage.class, null);

		context.set(WizardConstants.IS_EXAMPLE, true);
		context.set(IWorkspaceRoot.class, ResourcesPlugin.getWorkspace().getRoot());
	}
}
