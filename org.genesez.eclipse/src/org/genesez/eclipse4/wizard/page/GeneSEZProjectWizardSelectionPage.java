/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
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
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.swt.widgets.Button;
import org.genesez.eclipse4.wizard.ui.ChooseWizardPart;
import org.genesez.eclipse4.wizard.ui.DescriptionPart;
import org.genesez.eclipse4.wizard.ui.ProjectSettingsPart;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * This page is needed to choose the wizard and set an application- and
 * generator project name.
 * 
 * The page contains:
 * <p>
 * {@link ChooseWizardPart}
 * </p>
 * <p>
 * {@link DescriptionPart}
 * </p>
 * <p>
 * {@link ProjectSettingsPart}
 * </p>
 * See their documentation for needed {@link IEclipseContext} elements.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZProjectWizardSelectionPage extends GeneSEZProjectWizardPage {

	private static final String ENTER_APP_PROJECTNAME = "Enter an application project name. ";
	private static final String ENTER_GEN_PROJECTNAME = "Enter a generator project name. ";
	private static final String CHOOSE_A_WIZARD = "Choose a Wizard option";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one that will be created already exists.";
	private static final String PROJECTNAMES_EQUAL = "Projectnames must be different.";

	/**
	 * Creates the page.
	 * 
	 * @param pageName
	 *            the page name.
	 * @param hostWin
	 *            the host window, which contains the context.
	 */
	public GeneSEZProjectWizardSelectionPage(String pageName, MWindow hostWin) {
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
		context.declareModifiable(WizardConstants.CHOOSE_WIZARD);
		context.declareModifiable(WizardConstants.APP_PROJ_NAME);
		context.declareModifiable(WizardConstants.GEN_PROJ_NAME);
		context.declareModifiable(WizardConstants.START_PLUGIN_WIZARD);
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(IWizardPage.class);
	}

	/**
	 * Creates the model with a {@link ChooseWizardPart}, a
	 * {@link DescriptionPart} and a {@link ProjectSettingsPart}.
	 * 
	 * @see org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardPage#createModel()
	 */
	@Override
	protected MUIElement createModel() {

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
		projectSettings
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ProjectSettingsPart");
		description.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.DescriptionPart");
		wizardSelection.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ChooseWizardPart");
		return pStack;
	}

	/**
	 * Updates the Message if certain Context elements Change. Sets also whether
	 * page is completed.
	 * 
	 * @param selectButton
	 *            {@link WizardConstants#CHOOSE_WIZARD}
	 * @param appProjectName
	 *            {@link WizardConstants#APP_PROJ_NAME}
	 * @param genProjectName
	 *            {@link WizardConstants#GEN_PROJ_NAME}
	 */
	@Inject
	private void updateMessage(@Optional @Named(WizardConstants.CHOOSE_WIZARD) Button selectButton,
			@Optional @Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Optional @Named(WizardConstants.GEN_PROJ_NAME) String genProjectName,
			@Optional @Named(WizardConstants.START_PLUGIN_WIZARD) boolean startPIWizard) {
		if (selectButton == null || selectButton.isDisposed()) {
			this.setMessage(CHOOSE_A_WIZARD);
			this.setPageComplete(false);
		} else {
			boolean isRadio3 = selectButton.getData().equals(WizardConstants.RADIO_3);
			String message = "";
			if (appProjectName == null || appProjectName.equals(""))
				if (!isRadio3)
					message = message.concat(ENTER_APP_PROJECTNAME);
			if (genProjectName == null || genProjectName.equals(""))
				if (!(isRadio3 && startPIWizard))
					message = message.concat(ENTER_GEN_PROJECTNAME);
			if (message.equals("")) {
				if (projectsAlreadyExists(appProjectName, genProjectName, (Integer) selectButton.getData())) {
					this.setMessage(PROJECTNAME_EXSISTS, ERROR);
					this.setPageComplete(false);
				} else if (appProjectName.equals(genProjectName) && !isRadio3) {
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

	/**
	 * Checks whether the projects already exists, uses the buttonData to
	 * determine which projects should be checked.
	 * 
	 * @param appProjName
	 *            the application project name.
	 * @param genProjName
	 *            the generator project name.
	 * @param buttonData
	 *            the button data (determines which button was selected).
	 * @return true if project exists.
	 */
	private boolean projectsAlreadyExists(String appProjName, String genProjName, int buttonData) {
		switch (buttonData) {
		case WizardConstants.RADIO_1:
			return projectAlreadyExists(appProjName) || projectAlreadyExists(genProjName);
		case WizardConstants.RADIO_2:
			return projectAlreadyExists(appProjName);
		case WizardConstants.RADIO_3:
			return projectAlreadyExists(genProjName);
		default:
			return true;
		}
	}

	/**
	 * Checks whether the project already exists.
	 * 
	 * @param name
	 *            the name of the project to check.
	 * @return true if project exists.
	 */
	private boolean projectAlreadyExists(String name) {
		for (IProject project : context.get(IWorkspaceRoot.class).getProjects()) {
			if (name.matches("^(/||\\\\)" + project.getName() + "(/||\\\\)$"))
				return true;
		}
		return false;
	}

	/**
	 * Sets if the next page is allowed, currently a next page is not allowed
	 * for Button data {@link WizardConstants#RADIO_3}
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#canFlipToNextPage()
	 */
	@Override
	public boolean canFlipToNextPage() {
		Object button = context.get(WizardConstants.CHOOSE_WIZARD);
		if (button != null)
			if (((Button) button).getData().equals(WizardConstants.RADIO_3))
				return false;
		return super.canFlipToNextPage();
	}
}
