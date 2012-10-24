package org.genesez.eclipse4.wizard.page;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.advanced.MAdvancedFactory;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspectiveStack;
import org.eclipse.e4.ui.model.application.ui.basic.MBasicFactory;
import org.eclipse.e4.ui.model.application.ui.basic.MInputPart;
import org.eclipse.e4.ui.model.application.ui.basic.MPartSashContainer;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IPresentationEngine;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZProjectWizardWorkflowPage extends WizardPage {

	private static final String CHOOSE_WF_TEMPLATE = "Choose a workflow template. ";
	private static final String SET_WF_FILENAME = "Set a workflow filename. ";
	private static final String SET_WF_DIRECTORY = "Set a workflow directory. ";
	private static final String CHOOSE_OPTION = "Choose an option for workflow file creation.";

	private MWindow hostWin;
	private IEclipseContext context;

	@Inject
	private IPresentationEngine renderer;

	public GeneSEZProjectWizardWorkflowPage(String pageName, MWindow hostWin) {
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
		context.declareModifiable(WizardConstants.CHOOSE_WORKFLOW);
		context.declareModifiable(WizardConstants.WORKFLOW_TEMPLATE);
		context.declareModifiable(WizardConstants.WORKFLOW_FILENAME);
		context.declareModifiable(WizardConstants.WORKFLOW_DIRECTORY);
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
	 * 			|-template
	 * 			|	|-templateSelection
	 * 			|	|-description
	 * 			|
	 * 			|-applicationModel
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
		MInputPart chooseWorkflow = MBasicFactory.INSTANCE.createInputPart();
		MInputPart workflowFile = MBasicFactory.INSTANCE.createInputPart();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(chooseWorkflow);
		complete.getChildren().add(workflowFile);

		// set the appropriate contributionURI e. g. bundleclass
		chooseWorkflow.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ChooseWorkflowPart");
		workflowFile.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.WorkflowFilePart");
		return pStack;
	}

	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button workflowButton,
			@Optional @Named(WizardConstants.WORKFLOW_TEMPLATE) String template,
			@Optional @Named(WizardConstants.WORKFLOW_FILENAME) String filename,
			@Optional @Named(WizardConstants.WORKFLOW_DIRECTORY) String directory){
		if(workflowButton == null){
			this.setMessage(CHOOSE_OPTION);
			this.setPageComplete(false);
		} else 	if(workflowButton.getData().equals(WizardConstants.RADIO_1)){
			setMessage(null);
			setPageComplete(true);
		} else {
			String message = "";
			if(workflowButton.getData().equals(WizardConstants.RADIO_3) && (template == null || template.equals("")))
				message = message.concat(CHOOSE_WF_TEMPLATE);
			if(filename == null || filename.equals(""))
				message = message.concat(SET_WF_FILENAME);
			if(directory == null || directory.equals(""))
				message = message.concat(SET_WF_DIRECTORY);
			if(message.equals("")){
				setMessage(null);
				setPageComplete(true);
			} else {
				setMessage(message, INFORMATION);
				setPageComplete(false);
			}
		}
	}
	
	@Override
	public boolean isPageComplete() {
		Button button = (Button) context.get(WizardConstants.CHOOSE_WIZARD);
		if(button.getData().equals(WizardConstants.RADIO_1) ||
				button.getData().equals(WizardConstants.RADIO_3))
			return true;
		return super.isPageComplete();
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
