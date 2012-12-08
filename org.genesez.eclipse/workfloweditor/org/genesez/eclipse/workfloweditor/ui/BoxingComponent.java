package org.genesez.eclipse.workfloweditor.ui;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;

@SuppressWarnings("restriction")
public class BoxingComponent {

	private static final String MOUSE_OVER_LABEL_TEXT = "";// "Drop Component here.";

	private Composite composite;
	private Label filler;

	private MouseListener mouseLabelClickListener;
	private DragSourceListener dragSourceListener;
	private MouseTrackListener mouseOverLabelListener;
	private DropTargetListener dropTargetListener;

	private Color compositeColor;
	private Color mouseInColor;

	private WorkflowComponentGroup dragGroup = null;

	private final List<WorkflowComponent> wf_components = new ArrayList<WorkflowComponent>();

	private final Transfer[] TRANSFERS = new Transfer[] { TextTransfer.getInstance() };

	private int standardLabelSize;

	private static final int MOUSE_OVER_LABEL_SIZE = 20;

	@Inject
	private UIController controller;

	@Inject
	private @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT)
	WorkflowComponent currentComponent;

	@Inject
	private IEclipseContext context;

	@Inject
	private IWorkbench workbench;

	@Inject
	@Named(WorkfloweditorConstants.HEAD_COMPOSITE)
	private Composite headComposite;

	public BoxingComponent() {
	}

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		filler = new Label(composite, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		compositeColor = composite.getBackground();
		mouseInColor = parent.getDisplay().getSystemColor(SWT.COLOR_YELLOW);

		addListeners();
	}

	private void addListeners() {
		mouseOverLabelListener = new MouseTrackAdapter() {

			@Override
			public void mouseExit(MouseEvent e) {
				Label control = (Label) e.widget;
				if (!control.equals(filler)) {
					if (standardLabelSize != 0) {
						control.setSize(control.getSize().x, standardLabelSize);
					}
				}
				control.setText("");
				control.setBackground(compositeColor);
			}

			@Override
			public void mouseEnter(MouseEvent e) {
				Label control = (Label) e.widget;
				if (currentComponent != null || dragGroup != null) {
					if (!control.equals(filler)) {
						standardLabelSize = control.getSize().y;
						control.setSize(control.getSize().x, MOUSE_OVER_LABEL_SIZE);
					}
					control.setText(MOUSE_OVER_LABEL_TEXT);
					control.setBackground(mouseInColor);
				}
			}
		};

		mouseLabelClickListener = new MouseAdapter() {

			@Override
			public void mouseUp(MouseEvent e) {
				if (currentComponent != null) {
					reorderChildren(addComponent(currentComponent), (Control) e.widget);
					context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, null);
					headComposite.notifyListeners(SWT.Resize, new Event());
					Event event = new Event();
					event.widget = e.widget;
					((Control) e.widget).notifyListeners(SWT.MouseExit, event);
				}
			}
		};

		dropTargetListener = new DropTargetAdapter() {

			@Override
			public void dragEnter(DropTargetEvent event) {
				if (dragGroup != null) {
					Event e = new Event();
					Control c = ((DropTarget) event.widget).getControl();
					e.widget = c;
					c.notifyListeners(SWT.MouseEnter, e);
					event.detail = DND.DROP_MOVE;
				} else {
					event.detail = DND.DROP_NONE;
				}
			}

			@Override
			public void dragLeave(DropTargetEvent event) {
				Event e = new Event();
				Control c = ((DropTarget) event.widget).getControl();
				e.widget = c;
				c.notifyListeners(SWT.MouseExit, e);
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
				headComposite.notifyListeners(SWT.Resize, new Event());
			}
		};

		DropTarget target = new DropTarget(filler, DND.DROP_MOVE | DND.DROP_DEFAULT);
		target.setTransfer(TRANSFERS);
		target.addDropListener(dropTargetListener);
		filler.addMouseListener(mouseLabelClickListener);
		filler.addMouseTrackListener(mouseOverLabelListener);
	}

	public WorkflowComponentGroup addComponent(WorkflowComponent component) {
		if (composite != null && !composite.isDisposed()) {
			if (component != null) {
				WorkflowComponentGroup group = new WorkflowComponentGroup(component);
				IEclipseContext context = this.context.createChild();
				context.set(Composite.class, composite);
				ContextInjectionFactory.inject(group, context);

				group.getPrecedingDragTarget().addMouseTrackListener(mouseOverLabelListener);
				group.getPrecedingDragTarget().addMouseListener(mouseLabelClickListener);

				DragSource source = new DragSource(group.getGroup(), DND.DROP_MOVE);
				source.setTransfer(TRANSFERS);
				source.addDragListener(dragSourceListener);

				DropTarget target = new DropTarget(group.getPrecedingDragTarget(), DND.DROP_MOVE | DND.DROP_DEFAULT);
				target.setTransfer(TRANSFERS);
				target.addDropListener(dropTargetListener);

				headComposite.notifyListeners(SWT.Resize, new Event());

				wf_components.add(component);
				this.context.modify(WorkfloweditorConstants.WORKFLOW_COMPONENTS, wf_components);
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
			headComposite.notifyListeners(SWT.Resize, new Event());
		}
	}

	public Composite getComposite() {
		return composite;
	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}
}
