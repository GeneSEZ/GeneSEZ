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
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

@SuppressWarnings("restriction")
public class GeneSEZProjectWizardTemplatePage extends WizardPage {

	private static final String CHOOSE_A_TEMPLATE = "Choose a template for project generation";

	private MWindow hostWin;
	private IEclipseContext context;

	@Inject
	private IPresentationEngine renderer;

	public GeneSEZProjectWizardTemplatePage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();

		setTitle("GeneSEZ Project Wizard");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),
				"/images/GeneSEZ.png"));

		ContextInjectionFactory.inject(this, context);
		initializeContext();
		this.setPageComplete(false);
	}

	private void initializeContext() {
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(WizardConstants.TEMPLATE);
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_LIST);
		context.declareModifiable(WizardConstants.COPY_MODEL_FILES);
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
		if(visible){
			context.modify(IWizardPage.class, this);
		}
		super.setVisible(visible);
	}
	
	@Override
	public boolean isPageComplete() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if(button != null)
			if(((Button) button).getData().equals(WizardConstants.RADIO_3))
				return true;
		return super.isPageComplete();
	}
	
	@Override
	public boolean canFlipToNextPage() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if(button != null)
			if(((Button) button).getData().equals(WizardConstants.RADIO_1) ||
					((Button) button).getData().equals(WizardConstants.RADIO_3))
				return false;
		return super.canFlipToNextPage();
	}
}
