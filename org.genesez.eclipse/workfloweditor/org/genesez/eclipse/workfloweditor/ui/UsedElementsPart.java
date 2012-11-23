package org.genesez.eclipse.workfloweditor.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;

@SuppressWarnings("restriction")
public class UsedElementsPart {

	private Composite composite;
	private ScrolledComposite scrolled;
	private Label filler;

	private DisposeListener disposeListener;
	private MouseListener mouseLabelClickListener;
	private DragSourceListener dragSourceListener;
	private MouseTrackListener mouseOverLabelListener;
	private DropTargetListener dropTargetListener;

	private Color compositeColor;
	private Color mouseInColor;
	private Image closeImage = null;

	private WorkflowComponentGroup dragGroup = null;

	private final List<WorkflowComponent> wf_components = new ArrayList<WorkflowComponent>();

	private final Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };

	@Inject
	private @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT)
	WorkflowComponent currentComponent;

	@Inject
	private IEclipseContext context;

	@Inject
	private IWorkbench workbench;

	@Inject
	private Composite parent;

	public UsedElementsPart() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		if (workbench != null) {
			ISharedImages eclipseImages = workbench.getSharedImages();
			closeImage = eclipseImages.getImage(ISharedImages.IMG_TOOL_DELETE);
		}
		parent.setLayout(new FillLayout());

		scrolled = new ScrolledComposite(parent, SWT.V_SCROLL);
		scrolled.setExpandHorizontal(true);
		scrolled.setExpandVertical(true);
		composite = new Composite(scrolled, SWT.NONE);
		scrolled.setContent(composite);
		composite.setLayout(new GridLayout());

		scrolled.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		compositeColor = composite.getBackground();
		mouseInColor = parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY);

		filler = new Label(composite, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		addListeners();
	}

	private void addListeners() {

		disposeListener = new DisposeListener() {

			@Override
			public void widgetDisposed(DisposeEvent e) {
				// wf_components.remove(((WorkflowComponentGroup) e.widget).getWorkflowComponent());
				// context.modify(WorkfloweditorConstants.WORKFLOW_COMPONENTS, wf_components);
			}
		};

		scrolled.addControlListener(new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				Rectangle r = scrolled.getClientArea();
				composite.layout();
				scrolled.setMinSize(composite.computeSize(r.width, SWT.DEFAULT));
			}
		});

		mouseOverLabelListener = new MouseTrackAdapter() {

			@Override
			public void mouseExit(MouseEvent e) {
				((Control) e.widget).setBackground(compositeColor);
			}

			@Override
			public void mouseEnter(MouseEvent e) {
				if (currentComponent != null) {
					((Control) e.widget).setBackground(mouseInColor);
				}
			}
		};

		mouseLabelClickListener = new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if (currentComponent != null) {
					reorderChildren(addComponent(currentComponent), (Control) e.widget);
					context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, null);
					scrolled.notifyListeners(SWT.Resize, new Event());
					((Control) e.widget).setBackground(compositeColor);
				}
			}
		};

		dropTargetListener = new DropTargetAdapter() {

			@Override
			public void dragEnter(DropTargetEvent event) {
				if (dragGroup != null) {
					((DropTarget) event.widget).getControl().setBackground(mouseInColor);
					event.detail = DND.DROP_MOVE;
				} else {
					event.detail = DND.DROP_NONE;
				}
			}

			@Override
			public void dragLeave(DropTargetEvent event) {
				((DropTarget) event.widget).getControl().setBackground(compositeColor);
			}

			@Override
			public void drop(DropTargetEvent event) {
				if (dragGroup != null) {
					reorderChildren(dragGroup, ((DropTarget) event.widget).getControl());
				}
			}
		};

		dragSourceListener = new DragSourceAdapter() {

			@Override
			public void dragStart(DragSourceEvent event) {
				dragGroup = WorkflowComponentGroup.groups.get(((DragSource) event.widget).getControl());
			}

			@Override
			public void dragSetData(DragSourceEvent event) {
				event.data = "dragging";
			}

			@Override
			public void dragFinished(DragSourceEvent event) {
				dragGroup = null;
				scrolled.notifyListeners(SWT.Resize, new Event());
			}
		};

		DropTarget target = new DropTarget(filler, DND.DROP_MOVE | DND.DROP_DEFAULT);
		target.setTransfer(transfers);
		target.addDropListener(dropTargetListener);
		filler.addMouseListener(mouseLabelClickListener);
		filler.addMouseTrackListener(mouseOverLabelListener);
	}

	private WorkflowComponentGroup addComponent(WorkflowComponent component) {
		if (composite != null && !composite.isDisposed() && scrolled != null && !scrolled.isDisposed()) {
			if (component != null) {
				WorkflowComponentGroup group = new WorkflowComponentGroup(composite, component, closeImage);

				group.getGroup().addDisposeListener(disposeListener);

				group.getPrecedingDragTarget().addMouseTrackListener(mouseOverLabelListener);
				group.getPrecedingDragTarget().addMouseListener(mouseLabelClickListener);

				DragSource source = new DragSource(group.getGroup(), DND.DROP_MOVE);
				source.setTransfer(transfers);
				source.addDragListener(dragSourceListener);

				DropTarget target = new DropTarget(group.getPrecedingDragTarget(), DND.DROP_MOVE | DND.DROP_DEFAULT);
				target.setTransfer(transfers);
				target.addDropListener(dropTargetListener);

				composite.layout();
				scrolled.notifyListeners(SWT.Resize, new Event());

				wf_components.add(component);
				context.modify(WorkfloweditorConstants.WORKFLOW_COMPONENTS, wf_components);
				return group;
			}
		}
		return null;
	}

	private void reorderChildren(WorkflowComponentGroup toOrder, Control clickedControl) {
		if (toOrder != null && !toOrder.getGroup().isDisposed() && filler != null && !filler.isDisposed()
				&& clickedControl != toOrder.getPrecedingDragTarget()) {
			Group group = toOrder.getGroup();
			Label label = toOrder.getPrecedingDragTarget();
			if (clickedControl.equals(filler)) {
				group.moveAbove(filler);
				label.moveAbove(group);
			} else {
				group.moveBelow(clickedControl);
				label.moveAbove(group);
				clickedControl.moveBelow(group);
			}
		}
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}
}
