/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard;

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
import org.genesez.eclipse.wizard.handler.CreateProjectHandler;
import org.genesez.eclipse.wizard.page.GeneSEZExampleWizardPage;
import org.genesez.eclipse.wizard.util.WizardConstants;

/**
 * The GeneSEZ Example wizard, to create GeneSEZ examples from templates.
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 */
@SuppressWarnings("restriction")
public class GeneSEZExampleWizard extends Wizard implements INewWizard {

	private MWindow hostWin;
	private ParameterizedCommand executeCommand;
	private IEclipseContext context;
	
	@Inject
	private ECommandService commandService;
	@Inject
	private EHandlerService handlerService;

	/**
	 * Constructs the GeneSEZ example wizard
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public GeneSEZExampleWizard() throws SecurityException, NoSuchMethodException {
		initialize();
	}
	
	/**
	 * Initializes the context and the handler.
	 */
	private void initialize(){
		IWorkbenchWindow wbw = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		hostWin = (MWindow) wbw.getService(MWindow.class);
		context = hostWin.getContext();
		ContextInjectionFactory.inject(this, context);
		setContextInitial();
		
		executeCommand = commandService.createCommand("create.projects", null);
		CreateProjectHandler handler = new CreateProjectHandler();
		ContextInjectionFactory.inject(handler, context);
		handlerService.activateHandler("create.projects", handler);
	}

	/**
	 * Adds the example wizard page.
	 * @see org.eclipse.ui.IWorkbenchWizard#init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		addPage(new GeneSEZExampleWizardPage("Create example projects", hostWin));
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
	 * Disposes the Wizard.
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
