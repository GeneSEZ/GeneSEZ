package org.genesez.eclipse4.wizard.page;

import javax.inject.Inject;
import javax.inject.Named;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZProjectWizardTemplatePage extends WizardPage {

	private static final String CHOOSE_A_TEMPLATE = "Choose a template for project generation";
	private static String description = "";

	private MWindow hostWin;
	private IEclipseContext context;
	private IWorkspaceRoot workspace;

	@Inject
	private IPresentationEngine renderer;

	public GeneSEZProjectWizardTemplatePage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();
		this.workspace = ResourcesPlugin.getWorkspace().getRoot();

		setTitle("GeneSEZ Wizard Selection");
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
		context.declareModifiable(WizardConstants.TEMPLATE);
		context.modify(WizardConstants.TEMPLATE, null);
		context.set(WizardConstants.IS_EXAMPLE, false);
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
		MPartSashContainer template = MBasicFactory.INSTANCE.createPartSashContainer();
		template.setHorizontal(false);
		MInputPart templateSelection = MBasicFactory.INSTANCE.createInputPart();
		MPart description = MBasicFactory.INSTANCE.createPart();
		MInputPart applicationModel = MBasicFactory.INSTANCE.createInputPart();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(template);
		template.getChildren().add(templateSelection);
		template.getChildren().add(description);
		complete.getChildren().add(applicationModel);

		// set the appropriate contributionURI e. g. bundleclass
		templateSelection.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.TemplateSelectionPart");
		description.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.DescriptionPart");
		applicationModel.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ApplicationModelPart");
		return pStack;
	}

	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template){
		if(template == null){
			this.setMessage(CHOOSE_A_TEMPLATE);
			this.setPageComplete(false);
		} else
			this.setPageComplete(true);
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

	@Override
	public void setVisible(boolean visible) {
		System.err.println(visible);
		System.err.println(context.get(WizardConstants.DESCRIPTION));
		System.err.println(context.getActive(WizardConstants.DESCRIPTION));
		System.err.println(context.getLocal(WizardConstants.DESCRIPTION));
		if(visible){
			context.modify(WizardConstants.DESCRIPTION, description);
		} else {
			description = (String) context.get(WizardConstants.DESCRIPTION);
		}
		super.setVisible(visible);
	}
	
	@Override
	public boolean isPageComplete() {
		if(((Button) context.get(WizardConstants.CHOOSE_WIZARD)).getData().equals(WizardConstants.RADIO_3))
			return true;
		return super.isPageComplete();
	}
	
	@Override
	public boolean canFlipToNextPage() {
		Button button = (Button) context.get(WizardConstants.CHOOSE_WIZARD);
		if(button.getData().equals(WizardConstants.RADIO_1) ||
				button.getData().equals(WizardConstants.RADIO_3))
			return false;
		return super.canFlipToNextPage();
	}
	
	
}
