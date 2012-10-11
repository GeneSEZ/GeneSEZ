package org.genesez.eclipse4.wizard;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.core.commands.ParameterizedCommand;
import org.eclipse.e4.core.commands.ECommandService;
import org.eclipse.e4.core.commands.EHandlerService;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.genesez.eclipse4.wizard.handler.CreateProjectHandler;
import org.genesez.eclipse4.wizard.page.GenSEZProjectWizardSelectionPage;

@SuppressWarnings("restriction")
public class GeneSEZProjectWizard extends Wizard implements INewWizard {

	private MWindow hostWin;
	private ParameterizedCommand executeCommand;
	
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
		addPage(new GenSEZProjectWizardSelectionPage("Create Projects", hostWin));
	}

	@Override
	public boolean performFinish() {
		handlerService.executeHandler(executeCommand);
		return true;
	}
}
