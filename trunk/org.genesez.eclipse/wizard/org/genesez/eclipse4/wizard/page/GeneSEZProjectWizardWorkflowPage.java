/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
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
import org.eclipse.swt.widgets.Button;
import org.genesez.eclipse4.wizard.ui.ChooseWorkflowPart;
import org.genesez.eclipse4.wizard.ui.WorkflowFilePart;
import org.genesez.eclipse4.wizard.util.WizardConstants;

/**
 * This page is used to specify how and if a workflow file will be created.
 * 
 * The page contains:
 * <p>
 * {@link ChooseWorkflowPart}
 * </p>
 * <p>
 * {@link WorkflowFilePart}
 * </p>
 * See their documentation for needed {@link IEclipseContext} elements.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class GeneSEZProjectWizardWorkflowPage extends GeneSEZProjectWizardPage {

	private static final String CHOOSE_WF_TEMPLATE = "Choose a workflow template. ";
	private static final String SET_WF_FILENAME = "Set a workflow filename. ";
	private static final String SET_WF_DIRECTORY = "Set a workflow directory. ";
	private static final String CHOOSE_OPTION = "Choose an option for workflow file creation.";

	/**
	 * Creates the page.
	 * 
	 * @param pageName
	 *            the page name.
	 * @param hostWin
	 *            the host window, which contains the context.
	 */
	public GeneSEZProjectWizardWorkflowPage(String pageName, MWindow hostWin) {
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
		context.declareModifiable(WizardConstants.CHOOSE_WORKFLOW);
		context.declareModifiable(WizardConstants.WORKFLOW_TEMPLATE);
		context.declareModifiable(WizardConstants.WORKFLOW_FILENAME);
		context.declareModifiable(WizardConstants.WORKFLOW_DIRECTORY);
	}

	/**
	 * Creates the model with a {@link ChooseWorkflowPart} and a
	 * {@link WorkflowFilePart}.
	 * 
	 * @see org.genesez.eclipse4.wizard.page.GeneSEZProjectWizardPage#createModel()
	 */
	@Override
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
		MInputPart chooseWorkflow = MBasicFactory.INSTANCE.createInputPart();
		MInputPart workflowFile = MBasicFactory.INSTANCE.createInputPart();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(chooseWorkflow);
		complete.getChildren().add(workflowFile);

		// set the appropriate contributionURI e. g. bundleclass
		chooseWorkflow
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.ChooseWorkflowPart");
		workflowFile
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse4.wizard.ui.WorkflowFilePart");
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
			@Optional @Named(WizardConstants.CHOOSE_WORKFLOW) Button workflowButton,
			@Optional @Named(WizardConstants.WORKFLOW_TEMPLATE) String template,
			@Optional @Named(WizardConstants.WORKFLOW_FILENAME) String filename,
			@Optional @Named(WizardConstants.WORKFLOW_DIRECTORY) String directory) {
		if (workflowButton == null) {
			this.setMessage(CHOOSE_OPTION);
			this.setPageComplete(false);
		} else if (workflowButton.getData().equals(WizardConstants.RADIO_1)) {
			setMessage(null);
			setPageComplete(true);
		} else {
			String message = "";
			if (workflowButton.getData().equals(WizardConstants.RADIO_3)
					&& (template == null || template.equals("")))
				message = message.concat(CHOOSE_WF_TEMPLATE);
			if (filename == null || filename.equals(""))
				message = message.concat(SET_WF_FILENAME);
			if (directory == null || directory.equals(""))
				message = message.concat(SET_WF_DIRECTORY);
			if (message.equals("")) {
				setMessage(null);
				setPageComplete(true);
			} else {
				setMessage(message, INFORMATION);
				setPageComplete(false);
			}
		}
	}

	/**
	 * Sets if the page is completed evaluates also to true if
	 * {@link WizardConstants#CHOOSE_WIZARD} has data
	 * {@link WizardConstants#RADIO_1} or {@link WizardConstants#RADIO_3}.
	 * 
	 * @see org.eclipse.jface.wizard.WizardPage#isPageComplete()
	 */
	@Override
	public boolean isPageComplete() {
		Button button = (Button) context.get(WizardConstants.CHOOSE_WIZARD);
		if (button.getData().equals(WizardConstants.RADIO_1)
				|| button.getData().equals(WizardConstants.RADIO_3))
			return true;
		return super.isPageComplete();
	}
}
