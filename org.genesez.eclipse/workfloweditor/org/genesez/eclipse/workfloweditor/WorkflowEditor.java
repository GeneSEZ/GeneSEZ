package org.genesez.eclipse.workfloweditor;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;
import org.genesez.eclipse.wizard.util.WizardConstants;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public class WorkflowEditor extends EditorPart {

	public static final String ID = "org.genesez.eclipse.workfloweditor.WorkflowEditor"; //$NON-NLS-1$
	public static final String ERROR_MESSAGE = "File could not be saved due to some Errors";
	public static final String ERROR_HEAD = "Save Error";

	private final MWindow hostWin;
	private final IEclipseContext context;
	private Composite composite;
	private Cursor oldCursor;
	private final Cursor newCursor = new Cursor(Display.getCurrent(), SWT.CURSOR_CROSS);
	private final Image image = new Image(Display.getCurrent(), getClass().getClassLoader().getResourceAsStream(
	// "icons/butterfly.gif"));
			"images/GeneSEZ_32x32.png"));
	private boolean dirty = false;
	private UIController controller;

	/** The presentationEngine for Rendering */
	@Inject
	private IPresentationEngine renderer;

	public WorkflowEditor() {
		IWorkbenchWindow wbw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		hostWin = (MWindow) wbw.getService(MWindow.class);
		context = hostWin.getContext();
		ContextInjectionFactory.inject(this, context);
		initializeContext();
	}

	/**
	 * Create contents of the editor part.
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		oldCursor = composite.getCursor();
		composite.setLayout(new FillLayout());

		// Create the model
		MUIElement hostModel = createModel();
		renderModel(composite, hostModel);
	}

	/**
	 * initializes the context. This should contain all needed context elements from the Parts.
	 */
	protected void initializeContext() {
		context.declareModifiable(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT);
		context.declareModifiable(WorkfloweditorConstants.DRAGGED_WORKFLOWCOMPONENTGROUP);
	}

	/**
	 * Creates the model.
	 * 
	 * @return the top MUIElement, will be mostly a {@link MPerspectiveStack},
	 */
	protected MUIElement createModel() {
		// Create the model elements
		MPerspectiveStack pStack = MAdvancedFactory.INSTANCE.createPerspectiveStack();
		ContextInjectionFactory.inject(pStack, context);
		MPerspective perspective = MAdvancedFactory.INSTANCE.createPerspective();
		MPartSashContainer complete = MBasicFactory.INSTANCE.createPartSashContainer();
		complete.setHorizontal(true);

		MPart availableElements = MBasicFactory.INSTANCE.createPart();
		availableElements.setContainerData("30");
		MInputPart usedElements = MBasicFactory.INSTANCE.createInputPart();
		usedElements.setContainerData("70");

		// put the model elements together
		pStack.getChildren().add(perspective);
		perspective.getChildren().add(complete);
		complete.getChildren().add(availableElements);
		complete.getChildren().add(usedElements);

		// set the appropriate contributionURI e. g. bundleclass
		availableElements
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse.workfloweditor.ui.AvailableElementsPart");
		usedElements
				.setContributionURI("bundleclass://org.genesez.eclipse/org.genesez.eclipse.workfloweditor.ui.UsedElementsPart");
		return pStack;
	};

	/**
	 * renders the model
	 * 
	 * @param parent
	 *            the parent composite
	 * @param hostModel
	 *            the hostModel
	 */
	private void renderModel(Composite parent, final MUIElement hostModel) {
		hostWin.getSharedElements().add(hostModel);

		// Render it
		renderer.createGui(hostModel, parent, context);
		// Clean up the shared elements list once we're done
		parent.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				hostWin.getSharedElements().remove(hostModel);
			}
		});
	}

	@Inject
	private void changeCursor(@Optional @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT) Object component) {
		if (composite != null && !composite.isDisposed()) {
			if (component != null) {
				composite.setCursor(newCursor);
			} else {
				composite.setCursor(oldCursor);
			}
		}
	}

	@Override
	protected Image getDefaultImage() {
		return image;
	}

	@Override
	public void setFocus() {
		composite.setFocus();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		try {
			controller.serialize();
			setDirty(false);
		} catch (Exception e) {
			Status status = new Status(IStatus.ERROR, WizardConstants.PLUGIN_ID, IStatus.OK, e.getMessage(), e);
			// Display the dialog
			ErrorDialog.openError(Display.getCurrent().getActiveShell(), ERROR_HEAD, ERROR_MESSAGE, status);
		}
	}

	@Override
	public void doSaveAs() {
		doSave(null);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		if (!(input instanceof FileEditorInput)) {
			throw new PartInitException("Not the right input type");
		}
		controller = new UIController(((FileEditorInput) input).getFile(), this);
		ContextInjectionFactory.inject(controller, context);
		context.set(UIController.class, controller);
		setPartName(input.getName());
		setSite(site);
		setInput(input);
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		firePropertyChange(PROP_DIRTY);
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
