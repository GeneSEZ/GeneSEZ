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
import org.eclipse.swt.widgets.Button;
import org.genesez.eclipse4.wizard.ui.ApplicationModelPart;
import org.genesez.eclipse4.wizard.ui.DescriptionPart;
import org.genesez.eclipse4.wizard.ui.TemplateSelectionPart;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * In this page the template and the application Model can be chosen.
 * 
 * The page contains:
 * <p>
 * {@link TemplateSelectionPart}
 * </p>
 * <p>
 * {@link DescriptionPart}
 * </p>
 * <p>
 * {@link ApplicationModelPart}
 * </p>
 * See their documentation for needed {@link IEclipseContext} elements.
 * 
 * @author Dominik Wetzel
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZProjectWizardTemplatePage extends GeneSEZProjectWizardPage {

	private static final String CHOOSE_A_TEMPLATE = "Choose a template for project generation";

	/**
	 * Creates the page.
	 * 
	 * @param pageName
	 *            the page name.
	 * @param hostWin
	 *            the host window, which contains the context.
	 */
	public GeneSEZProjectWizardTemplatePage(String pageName, MWindow hostWin) {
		super(pageName, hostWin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardPage#initializeContext
	 * ()
	 */
	@Override
	protected void initializeContext() {
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(WizardConstants.TEMPLATE);
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_LIST);
		context.declareModifiable(WizardConstants.COPY_MODEL_FILES);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_ROOT);
		context.set(WizardConstants.IS_EXAMPLE, false);
	}

	/**
	 * Creates the model with a {@link TemplateSelectionPart}, a
	 * {@link DescriptionPart} and an {@link ApplicationModelPart}
	 * 
	 * @see org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardPage#createModel()
	 */
	protected MUIElement createModel() {
		// Create the model elements
		MPerspectiveStack pStack = MAdvancedFactory.INSTANCE
				.createPerspectiveStack();
		ContextInjectionFactory.inject(pStack, context);
		MPerspective perspective = MAdvancedFactory.INSTANCE
				.createPerspective();
		MPartSashContainer complete = MBasicFactory.INSTANCE
				.createPartSashContainer();
		complete.setHorizontal(false);
		MPartSashContainer template = MBasicFactory.INSTANCE
				.createPartSashContainer();
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
		templateSelection
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.TemplateSelectionPart");
		description
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.DescriptionPart");
		applicationModel
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ApplicationModelPart");
		return pStack;
	}

	/**
	 * Updates the Message if certain Context elements Change. Sets also whether
	 * page is completed.
	 * 
	 * @param template
	 *            {@link WizardConstants#TEMPLATE}
	 */
	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template) {
		if (template == null) {
			this.setMessage(CHOOSE_A_TEMPLATE);
			this.setPageComplete(false);
		} else
			this.setPageComplete(true);
	}

	/**
	 * Sets if the page is completed evaluates also to true if
	 * {@link WizardConstants#CHOOSE_WIZARD} has data
	 * {@link WizardConstants#RADIO_3}.
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if (button != null)
			if (((Button) button).getData().equals(WizardConstants.RADIO_3))
				return true;
		return super.isPageComplete();
	}

	/**
	 * Sets if the next page is allowed, the next page is not allowed for Button
	 * data {@link WizardConstants#RADIO_3} and {@link WizardConstants#RADIO_1}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if (button != null)
			if (((Button) button).getData().equals(WizardConstants.RADIO_1)
					|| ((Button) button).getData().equals(
							WizardConstants.RADIO_3))
				return false;
		return super.canFlipToNextPage();
	}
}
