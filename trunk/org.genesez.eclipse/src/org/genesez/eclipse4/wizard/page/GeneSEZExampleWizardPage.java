package org.genesez.eclipse4.wizard.page;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MAdvancedFactory;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MInputPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZExampleWizardPage extends WizardPage {

	private static final String ENTER_APP_PROJECTNAME = "Enter an application project name. ";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one that will be created already exists.";
	private static final String SELECT_TEMPLATE = "Select a template for the project. ";

	private MWindow hostWin;
	private IEclipseContext context;
	private IWorkspaceRoot workspace;

	@Inject
	private IPresentationEngine renderer;

	public GeneSEZExampleWizardPage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();
		this.workspace = ResourcesPlugin.getWorkspace().getRoot();

		setTitle("GeneSEZ example selection");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),
				"/images/GeneSEZ.png"));

		ContextInjectionFactory.inject(this, context);
		initializeContext();
		setPageComplete(false);
	}

	private void initializeContext() {
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(WizardConstants.APP_PROJ_NAME);
		context.declareModifiable(WizardConstants.TEMPLATE);

		context.set(WizardConstants.IS_EXAMPLE, true);
		context.set(WizardConstants.WORKSPACE, workspace);
	}

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout());
		setControl(comp);

		// Create the model
		MUIElement hostModel = createModel();

		// Render the model...by 4.2 M4 we expect that this will be
		// available as a method in the EModelService
		renderModel(comp, hostModel);
	}

	/*
	 * Creates the following MUIElement tree:
	 * 
	 * pStack 
	 * 	|-perspective 
	 * 		|-complete 
	 * 			|-templateSelection 
	 * 			|-description
	 * 			|-projectName
	 * 
	 * @return the pStack MUIElement
	 */
	private MUIElement createModel() {

		// Create the model elements
		MPerspectiveStack pStack = MAdvancedFactory.INSTANCE
				.createPerspectiveStack();
		ContextInjectionFactory.inject(pStack, context);
		MPerspective perspective = MAdvancedFactory.INSTANCE
				.createPerspective();
		MPartSashContainer complete = MBasicFactory.INSTANCE
				.createPartSashContainer();
		complete.setHorizontal(false);
		MInputPart templateSelection = MBasicFactory.INSTANCE.createInputPart();
		MPart description = MBasicFactory.INSTANCE.createPart();
		MInputPart projectName = MBasicFactory.INSTANCE.createInputPart();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(templateSelection);
		complete.getChildren().add(description);
		complete.getChildren().add(projectName);

		// set the appropriate contributionURI e. g. bundleclass
		templateSelection
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.TemplateSelectionPart");
		description
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.DescriptionPart");
		projectName
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ProjectNamePart");
		return pStack;
	}

	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template) {
		String message = "";
		if (template == null)
			message = message.concat(SELECT_TEMPLATE);
		if (appProjectName == null || appProjectName.equals(""))
			message = message.concat(ENTER_APP_PROJECTNAME);
		if (message.equals("")) {
			setMessage(null);
			if (projectAlreadyExists(appProjectName)) {
				this.setMessage(PROJECTNAME_EXSISTS, ERROR);
				this.setPageComplete(false);
			} else
				this.setPageComplete(true);
		} else {
			this.setMessage(message, INFORMATION);
			this.setPageComplete(false);
		}
	}

	private boolean projectAlreadyExists(String name) {
		for (IProject project : workspace.getProjects()) {
			if (name.matches("^(/||\\\\)" + project.getName() + "(/||\\\\)$") ||
					name.concat(".generator").matches("^(/||\\\\)" + project.getName() + "(/||\\\\)$"))
				return true;
		}
		return false;
	}

	private void renderModel(Composite parent, final MUIElement hostModel) {
		// This is subtle; unless the element is hooked into the model it won't
		// fire events
		hostWin.getSharedElements().add(hostModel);

		// Render it
		renderer.createGui(hostModel, parent, context);
		// Clean up the shared elements list once we're done
		parent.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				hostWin.getSharedElements().remove(hostModel);
			}
		});
	}
}
