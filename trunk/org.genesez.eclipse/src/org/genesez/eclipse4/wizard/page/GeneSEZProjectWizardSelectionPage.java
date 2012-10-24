package org.genesez.eclipse4.wizard.page;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZProjectWizardSelectionPage extends WizardPage {

	private static final String ENTER_APP_PROJECTNAME = "Enter an application project name. ";
	private static final String ENTER_GEN_PROJECTNAME = "Enter a generator project name. ";
	private static final String CHOOSE_A_WIZARD = "Choose a Wizard option";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one that will be created already exists.";
	private static final String PROJECTNAMES_EQUAL = "Projectnames must be different.";

	private MWindow hostWin;
	private IEclipseContext context;
	private MUIElement hostModel;

	@Inject
	private IPresentationEngine renderer;

	public GeneSEZProjectWizardSelectionPage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();

		setTitle("GeneSEZ Project Wizard");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),
				"/images/GeneSEZ.png"));

		// This is not really necessary but it demonstrates how DI works
		// once the code below runs the '@Inject' fields defined above will
		// contain their correct values.
		ContextInjectionFactory.inject(this, context);
		initializeContext();
		this.setPageComplete(false);
	}

	private void initializeContext() {
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.APP_PROJ_NAME);
		context.declareModifiable(WizardConstants.GEN_PROJ_NAME);
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(IWizardPage.class);
	}

	@Override
	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayout(new FillLayout());
		setControl(comp);

		// Create the model
		hostModel = createModel();

		// Render the model...by 4.2 M4 we expect that this will be
		// available as a method in the EModelService
		renderModel(comp);
	}

	/*
	 * Creates the following MUIElement tree:
	 * 
	 * pStack
	 * 	|-perspective
	 * 		|-complete
	 * 			|-wizardSelection
	 * 			|-description
	 * 			|-projectSettings
	 * 
	 * @return the pStack MUIElement
	 */
	private MUIElement createModel() {
		
		// Create the model elements
		MPerspectiveStack pStack = MAdvancedFactory.INSTANCE.createPerspectiveStack();
		ContextInjectionFactory.inject(pStack, context);
		MPerspective perspective = MAdvancedFactory.INSTANCE.createPerspective();
		MPartSashContainer complete = MBasicFactory.INSTANCE.createPartSashContainer();
		complete.setHorizontal(false);
		MInputPart wizardSelection = MBasicFactory.INSTANCE.createInputPart();
		MPart description = MBasicFactory.INSTANCE.createPart();
		MInputPart projectSettings = MBasicFactory.INSTANCE.createInputPart();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(wizardSelection);
		complete.getChildren().add(description);
		complete.getChildren().add(projectSettings);

		// set the appropriate contributionURI e. g. bundleclass
		projectSettings.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ProjectSettingsPart");
		description.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.DescriptionPart");
		wizardSelection.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ChooseWizardPart");
		return pStack;
	}

	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button selectButton,
			@Optional @Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Optional @Named(WizardConstants.GEN_PROJ_NAME) String genProjectName) {
		if(selectButton == null || selectButton.isDisposed()){
			this.setMessage(CHOOSE_A_WIZARD);
			this.setPageComplete(false);
		}else{
			String message = "";
			if(appProjectName == null || appProjectName.equals(""))
				message = message.concat(ENTER_APP_PROJECTNAME);
			if(genProjectName == null || genProjectName.equals(""))
				message = message.concat(ENTER_GEN_PROJECTNAME);
			if(message.equals("")){
				if(projectsAlreadyExists(appProjectName, genProjectName, (Integer) selectButton.getData())){
					this.setMessage(PROJECTNAME_EXSISTS, ERROR);
					this.setPageComplete(false);
				} else if(appProjectName.equals(genProjectName)){
					this.setMessage(PROJECTNAMES_EQUAL, ERROR);
					this.setPageComplete(false);
				} else {
					this.setMessage(null);
					this.setPageComplete(true);
				}
			} else {
				this.setMessage(message, INFORMATION);
				this.setPageComplete(false);
			}
		}
	}

	private boolean projectsAlreadyExists(String appProjName, String genProjName, int buttonData) {
		switch (buttonData) {
		case WizardConstants.RADIO_1 :
			return projectAlreadyExists(appProjName) || projectAlreadyExists(genProjName);
		case WizardConstants.RADIO_2 :
			return projectAlreadyExists(appProjName);
		case WizardConstants.RADIO_3 :
			return projectAlreadyExists(genProjName);
		default :
			return true;
		}
	}
	
	private boolean projectAlreadyExists(String name){
		for (IProject project : context.get(IWorkspaceRoot.class).getProjects()) {
			if (name.matches("^(/||\\\\)" + project.getName() + "(/||\\\\)$"))
				return true;
		}
		return false;
	}

	private void renderModel(Composite parent) {
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
	
	@Override
	public boolean canFlipToNextPage() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if(button != null)
			if(((Button) button).getData().equals(WizardConstants.RADIO_3))
				return false;
		return super.canFlipToNextPage();
	}
	
	@Override
	public void setVisible(boolean visible) {
		if(visible){
			context.modify(IWizardPage.class,this);
		}
		super.setVisible(visible);
	}
}
