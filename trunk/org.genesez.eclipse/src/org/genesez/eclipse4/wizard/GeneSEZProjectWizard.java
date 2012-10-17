package org.genesez.eclipse4.wizard;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
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

@SuppressWarnings("restriction")
public class GeneSEZProjectWizard extends Wizard implements INewWizard {

	private MWindow hostWin;
	private ParameterizedCommand executeCommand;
	private IWizardPage page1;
	private IWizardPage page2;
	private IWizardPage page3;
	
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	public GeneSEZProjectWizard() throws SecurityException, NoSuchMethodException {
		// This is not really necessary but it demonstrates how DI works
		// once the code below runs the '@Inject' fields defined above will
		// contain their correct values.
		IWorkbenchWindow wbw = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		hostWin = (MWindow) wbw.getService(MWindow.class);
		ContextInjectionFactory.inject(this, hostWin.getContext());
		page1 = new GeneSEZProjectWizardSelectionPage("Create Projects", hostWin);
		page2 = new GeneSEZProjectWizardTemplatePage("Choose Template", hostWin);
		page3 = new GeneSEZProjectWizardWorkflowPage("Choose Workflow", hostWin);
	}
	
	@PostConstruct
	public void initialize(){
		executeCommand = commandService.createCommand("create.projects", null);
		CreateProjectHandler handler = new CreateProjectHandler();
		ContextInjectionFactory.inject(handler, hostWin.getContext());
		handlerService.activateHandler("create.projects", handler);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}

	@Override
	public boolean performFinish() {
		handlerService.executeHandler(executeCommand);
		return true;
	}
	
	@Override
	public boolean canFinish() {
		return page1.isPageComplete() && page2.isPageComplete() && page3.isPageComplete();
	}
}
