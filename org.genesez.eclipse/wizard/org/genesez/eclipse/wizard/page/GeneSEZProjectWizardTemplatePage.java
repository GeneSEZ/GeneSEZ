/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.page;

import java.io.File;
import java.util.Collection;

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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Button;
import org.genesez.eclipse.wizard.ui.ApplicationModelPart;
import org.genesez.eclipse.wizard.ui.DescriptionPart;
import org.genesez.eclipse.wizard.ui.TemplateSelectionPart;
import org.genesez.eclipse.wizard.util.TemplateConfigXml;
import org.genesez.eclipse.wizard.util.WizardConstants;

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
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZProjectWizardTemplatePage extends GeneSEZProjectWizardPage {

	private static final String CHOOSE_A_TEMPLATE = "Choose a template for project generation.";
	private static final String CHOOSE_A_DESTINATION = "Choose a destination for the application model.";
	private static final String NOT_IN_APP_OR_GEN_PROJECT = "Application model needs to be either in application or generator project.";

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
	 * org.genesez.eclipse.wizard.page.GeneSEZProjectWizardPage#initializeContext
	 * ()
	 */
	@Override
	protected void initializeContext() {
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(WizardConstants.TEMPLATE);
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_COLLECTION);
		context.declareModifiable(WizardConstants.COPY_MODEL_FILES);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_ROOT);
		context.declareModifiable(WizardConstants.CHOOSE_WORKFLOW);
		context.declareModifiable(WizardConstants.APP_PROJ_NAME);
		context.declareModifiable(WizardConstants.GEN_PROJ_NAME);
		context.declareModifiable(WizardConstants.APPLICATION_MODEL_DESTINATION);
		context.declareModifiable(IWizardPage.class);
		context.set(WizardConstants.IS_EXAMPLE, false);
	}

	/**
	 * Creates the model with a {@link TemplateSelectionPart}, a
	 * {@link DescriptionPart} and an {@link ApplicationModelPart}
	 * 
	 * @see org.genesez.eclipse.wizard.page.GeneSEZProjectWizardPage#createModel()
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
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse.wizard.ui.TemplateSelectionPart");
		description
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse.wizard.ui.DescriptionPart");
		applicationModel
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse.wizard.ui.ApplicationModelPart");
		return pStack;
	}

	/**
	 * Updates the Message if certain Context elements Change. Sets also whether
	 * page is completed.
	 * 
	 * @param template
	 *            {@link WizardConstants#TEMPLATE}
	 * @param model
	 *            {@link WizardConstants#APPLICATION_MODEL_COLLECTION}
	 * @param destination
	 *            {@link WizardConstants#APPLICATION_MODEL_DESTINATION}
	 * @param appName
	 *            {@link WizardConstants#APP_PROJ_NAME}
	 * @param genName
	 *            {@link WizardConstants#GEN_PROJ_NAME}
	 */
	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_COLLECTION) Collection<File> model,
			@Optional @Named(WizardConstants.APPLICATION_MODEL_DESTINATION) String destination,
			@Optional @Named(WizardConstants.APP_PROJ_NAME) String appName,
			@Optional @Named(WizardConstants.GEN_PROJ_NAME) String genName) {
		if (template == null) {
			this.setMessage(CHOOSE_A_TEMPLATE);
			this.setPageComplete(false);
		} else {
			if (model != null && !model.isEmpty()) {
				if (destination == null || destination.equals("")) {
					this.setMessage(CHOOSE_A_DESTINATION, ERROR);
					this.setPageComplete(false);
				} else if (appName != null && !appName.equals("")
						&& genName != null && !genName.equals("")
						&& !destination.startsWith(genName + File.separator)
						&& !destination.startsWith(appName + File.separator)) {
					this.setMessage(NOT_IN_APP_OR_GEN_PROJECT, ERROR);
					this.setPageComplete(false);
				} else {
					this.setMessage(null);
					this.setPageComplete(true);
				}
			} else {
				this.setMessage(null);
				this.setPageComplete(true);
			}
		}
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
