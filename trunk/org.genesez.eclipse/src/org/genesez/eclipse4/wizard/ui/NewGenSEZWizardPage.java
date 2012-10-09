package org.genesez.eclipse4.wizard.ui;

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
import org.genesez.eclipse4.wizard.util.TemplateHelper;

@SuppressWarnings("restriction")
public class NewGenSEZWizardPage extends WizardPage {

	private static final String ENTER_PROJECTNAME = "Enter a project name.";
	private static final String PROJECTNAME_EXSISTS = "A project with this name or one that will be created already exists.";
	private static final String SELECT_TEMPLATE = "Select a template for the project.";
	private static final String STARTUP_INFO = "Choose a template and enter a project name.";

	private MWindow hostWin;
	private IEclipseContext context;
	private IWorkspaceRoot workspace;

	@Inject
	private IPresentationEngine renderer;

	protected NewGenSEZWizardPage(String pageName, MWindow hostWin) {
		super(pageName);
		this.hostWin = hostWin;
		this.context = hostWin.getContext();
		this.workspace = ResourcesPlugin.getWorkspace().getRoot();

		setTitle("GeneSEZ Project Wizard");
		this.setImageDescriptor(ImageDescriptor.createFromFile(this.getClass(),
				"/images/GeneSEZ.png"));

		// This is not really necessary but it demonstrates how DI works
		// once the code below runs the '@Inject' fields defined above will
		// contain their correct values.
		ContextInjectionFactory.inject(this, context);
		initializeContext();
	}

	private void initializeContext() {
		context.set("projectname", "");
		context.set("template", null);
		context.set("workspace", workspace);
		context.set("radiobutton.uml.text", "");
		context.set("checkbutton.uml.selection", false);
		context.set("checkbutton.gen.selection", false);
		context.set("umlModel", "");
		context.set("generatorProject", "");
		context.declareModifiable("projectname");
		context.declareModifiable("template");
		context.declareModifiable("radiobutton.uml.text");
		context.declareModifiable("checkbutton.uml.selection");
		context.declareModifiable("checkbutton.gen.selection");
		context.declareModifiable("umlModel");
		context.declareModifiable("generatorProject");
		// context.declareModifiable("destination");
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
	 * 			|-projectname
	 * 			|-template
	 * 			|	|-tempSelection
	 * 			|	|-tempDescription
	 * 			|
	 * 			|-preview
	 * 			|-existUml
	 * 				|-existGenProject
	 * 				|-existUmlModell
	 * 				|-existUmlRadio
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
		MInputPart projectname = MBasicFactory.INSTANCE.createInputPart();
		MPartSashContainer template = MBasicFactory.INSTANCE.createPartSashContainer();
		template.setHorizontal(true);
		MPart tempSelection = MBasicFactory.INSTANCE.createPart();
		MPart tempDescription = MBasicFactory.INSTANCE.createPart();
		MPart preview = MBasicFactory.INSTANCE.createPart();
		MInputPart existGenProj = MBasicFactory.INSTANCE.createInputPart();
		MInputPart existUmlModell = MBasicFactory.INSTANCE.createInputPart();
		MInputPart existUmlRadio = MBasicFactory.INSTANCE.createInputPart();
//		MPartSashContainer existUml = MBasicFactory.INSTANCE.createPartSashContainer();

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(projectname);
		complete.getChildren().add(template);
		template.getChildren().add(tempSelection);
		template.getChildren().add(tempDescription);
		complete.getChildren().add(preview);
//		complete.getChildren().add(existUml);
		complete.getChildren().add(existGenProj);
		complete.getChildren().add(existUmlModell);
		complete.getChildren().add(existUmlRadio);

		// set the appropriate contributionURI e. g. bundleclass
		projectname.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.ProjectNamePart");
		tempSelection.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.TemplateSelectionPart");
		tempDescription.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.TemplateDescriptionPart");
		preview.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.PreviewProjectsPart");
		existGenProj.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.CheckBoxGeneratedPart");
		existUmlModell.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.CheckBoxUmlPart");
		existUmlRadio.setContributionURI("bundleclass://org.genesez.eclipse4.wizard/org.genesez.eclipse4.wizard.ui.part.RadioButtonUmlPart");
		return pStack;
	}

	@Inject
	private void updateMessage(
			@Optional @Named("template") TemplateConfigXml template,
			@Optional @Named("projectname") String projectName,
			@Optional @Named("destination") String destination) {
		if (template == null
				&& (projectName == null || projectName.trim().equals(""))) {
			this.setMessage(STARTUP_INFO, INFORMATION);
			this.setPageComplete(false);
		} else if (template == null) {
			this.setMessage(SELECT_TEMPLATE, INFORMATION);
			this.setPageComplete(false);
			checkIfProjectAlreadyExists(projectName);
		} else if (projectName == null || projectName.trim().equals("")) {
			this.setMessage(ENTER_PROJECTNAME, INFORMATION);
			this.setPageComplete(false);
		} else {
			this.setMessage(null);
			this.setPageComplete(true);
			checkIfProjectAlreadyExists(projectName);
		}
	}

	private void checkIfProjectAlreadyExists(String name) {
		if (name != null) {
			for (IProject project : workspace.getProjects()) {
				if (project.getName().concat("/")
						.matches(name + TemplateHelper.FOLDER_ENDING)) {
					this.setMessage(PROJECTNAME_EXSISTS, ERROR);
					this.setPageComplete(false);
				}
			}
		}
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
