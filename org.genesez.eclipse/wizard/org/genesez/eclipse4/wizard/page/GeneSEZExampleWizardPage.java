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
import org.genesez.eclipse4.wizard.ui.DescriptionPart;
import org.genesez.eclipse4.wizard.ui.ProjectNamePart;
import org.genesez.eclipse4.wizard.ui.TemplateSelectionPart;
import org.genesez.eclipse4.wizard.util.TemplateConfigXml;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * The page needed to chose an Example template and define a project name.
 * 
 * The example Wizard page Contains of:
 * <p>
 * {@link TemplateSelectionPart}
 * </p>
 * <p>
 * {@link DescriptionPart}
 * </p>
 * <p>
 * {@link ProjectNamePart}
 * </p>
 * See their documentation for needed {@link IEclipseContext} elements.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZExampleWizardPage extends GeneSEZProjectWizardPage {

	private static final String ENTER_APP_PROJECTNAME = "Enter an application project name. ";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one that will be created already exists.";
	private static final String SELECT_TEMPLATE = "Select a template for the project. ";

	/**
	 * Initializes the page.
	 * 
	 * @param pageName
	 *            the name of the page.
	 * @param hostWin
	 *            the host window, which contains the context.
	 */
	public GeneSEZExampleWizardPage(String pageName, MWindow hostWin) {
		super(pageName, hostWin);
	}

	/**
	 * initializes the context. This should contain all needed context elements
	 * from the Parts.
	 */
	@Override
	protected void initializeContext() {
		context.declareModifiable(WizardConstants.DESCRIPTION);
		context.declareModifiable(WizardConstants.APP_PROJ_NAME);
		context.declareModifiable(WizardConstants.GEN_PROJ_NAME);
		context.declareModifiable(WizardConstants.TEMPLATE);
		context.declareModifiable(IWizardPage.class);

		context.set(WizardConstants.IS_EXAMPLE, true);
	}

	/**
	 * creates the Model, adds a {@link TemplateSelectionPart}, a
	 * {@link DescriptionPart} and a {@link ProjectNamePart}
	 * @see org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardPage#createModel()
	 */
	@Override
	protected MUIElement createModel() {

		// Create the model elements
		MPerspectiveStack pStack = MAdvancedFactory.INSTANCE
				.createPerspectiveStack();
		// ContextInjectionFactory.inject(pStack, context);
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

	/**
	 * Updates the Message if certain Context elements Change.
	 * Sets also whether page is completed.
	 *  
	 * @param appProjectName
	 *            {@link WizardConstants#APP_PROJ_NAME}
	 * @param genProjectName
	 *            {@link WizardConstants#GEN_PROJ_NAME}
	 * @param template
	 *            {@link WizardConstants#TEMPLATE}
	 */
	@Inject
	private void updateMessage(
			@Optional @Named(WizardConstants.APP_PROJ_NAME) String appProjectName,
			@Optional @Named(WizardConstants.GEN_PROJ_NAME) String genProjectName,
			@Optional @Named(WizardConstants.TEMPLATE) TemplateConfigXml template) {
		String message = "";
		if (template == null)
			message = message.concat(SELECT_TEMPLATE);
		if (appProjectName == null || appProjectName.equals(""))
			message = message.concat(ENTER_APP_PROJECTNAME);
		if (message.equals("")) {
			if (projectAlreadyExists(appProjectName)
					|| (genProjectName != null && projectAlreadyExists(genProjectName))) {
				this.setMessage(PROJECTNAME_EXSISTS, ERROR);
				this.setPageComplete(false);
			} else {
				setMessage(null);
				this.setPageComplete(true);
			}
		} else {
			this.setMessage(message, INFORMATION);
			this.setPageComplete(false);
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
}
