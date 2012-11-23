package org.genesez.eclipse.workfloweditor;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.runtime.IProgressMonitor;
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
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.EditorPart;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public class WorkflowEditor extends EditorPart {

	public static final String ID = "org.genesez.eclipse.workfloweditor.WorkflowEditor"; //$NON-NLS-1$

	private MWindow hostWin;
	private IEclipseContext context;
	private Composite composite;
	private Cursor oldCursor;
	private Cursor newCursor = new Cursor(Display.getCurrent(), SWT.CURSOR_CROSS);

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
		context.declareModifiable(WorkfloweditorConstants.WORKFLOW_COMPONENTS);
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
		availableElements.setContainerData("25");
		MInputPart usedElements = MBasicFactory.INSTANCE.createInputPart();
		usedElements.setContainerData("75");

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
			public void widgetDisposed(DisposeEvent e) {
				hostWin.getSharedElements().remove(hostModel);
			}
		});
	}

	@Inject
	private void changeCursor(@Optional @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT) Object component) {
		if (composite != null && !composite.isDisposed()) {
			if (component != null)
				composite.setCursor(newCursor);
			else
				composite.setCursor(oldCursor);
		}
	}

	@Override
	public void setFocus() {
		composite.setFocus();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
