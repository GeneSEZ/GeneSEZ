package org.genesez.eclipse.workfloweditor.ui;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WorkflowComponentRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.AddDecorator;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public class WrapWorkflowComponent extends WrapFeatureRenderer {

	// private static Map<Composite, WrapWorkflowComponent> boxMap = new HashMap<Composite, WrapWorkflowComponent>();

	private final Transfer[] TRANSFERS = new Transfer[] { TextTransfer.getInstance() };

	private Group composite;
	private Label filler;

	private Color compositeColor;

	@Inject
	@Named(WorkfloweditorConstants.DRAGGED_WORKFLOWCOMPONENTGROUP)
	private WorkflowComponentRenderer dragGroup;

	@Inject
	private @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT)
	WorkflowComponent currentComponent;

	public WrapWorkflowComponent(JvmFeature feature, Component component, boolean add) {
		super(feature, component, add);
	}

	@Override
	@PostConstruct
	public void createControls() {
		context.set(WorkfloweditorConstants.CURRENT_TRANSFERS, TRANSFERS);
		composite = new Group(parent, SWT.BORDER | SWT.SHADOW_NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		composite.setText(feature.getSimpleName().substring(3));
		// boxMap.put(composite, this);
		composite.setLayout(new GridLayout());
		filler = new Label(composite, SWT.NONE);
		filler.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeColor = composite.getBackground();

		addListeners();
		addFillerListener();
	}

	private void addFillerListener() {
		DropTarget target = new DropTarget(filler, DND.DROP_MOVE | DND.DROP_DEFAULT);
		target.setTransfer(TRANSFERS);
		target.addDropListener(new DropTargetAdapter() {

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
					controller.reorderChildren(dragGroup, null);
					controller.reorderAssignments(dragGroup, null);
					controller.refreshView();
				}
			}
		});

		filler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if (currentComponent != null) {
					controller.addWorkflowComponent(currentComponent, component, null);
					context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, null);
					Event event = new Event();
					event.widget = e.widget;
					((Control) e.widget).notifyListeners(SWT.MouseExit, event);
					controller.refreshView();
				}
			}
		});

		filler.addMouseTrackListener(new MouseTrackAdapter() {

			@Override
			public void mouseExit(MouseEvent e) {
				if (!filler.isDisposed()) {
					Label control = (Label) e.widget;
					control.setBackground(compositeColor);
				}
			}

			@Override
			public void mouseEnter(MouseEvent e) {
				if (!filler.isDisposed()) {
					Label control = (Label) e.widget;
					if (currentComponent != null || dragGroup != null) {
						control.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
					}
				}
			}
		});
	}

	private void addListeners() {
		// groupDisposeListener = new DisposeListener() {
		//
		// @Override
		// public void widgetDisposed(DisposeEvent e) {
		// filler = new Label(composite, SWT.NONE);
		// filler.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// addFillerListener();
		// }
		// };

		composite.addPaintListener(new PaintListener() {

			@Override
			public void paintControl(PaintEvent e) {
				filler.moveBelow(null);
				controller.refreshView();
			}
		});
	}

	public Composite getComposite() {
		return composite;
	}

	public Component getComponent() {
		return component;
	}

	public Label getFiller() {
		return filler;
	}

	@Focus
	public void setFocus() {
		// TODO Set the focus to control
	}

	@Override
	public void setValue(Value value) {
		currentRenderer = renderElement();
		controller.injectChildContext(composite, context, currentRenderer);
		currentRenderer.setValue(value);
		if (!adder) {
			filler.dispose();
		}
	}

	private IFeatureRenderer renderElement() {
		return new AddDecorator(new WorkflowComponentRenderer(feature, component, adder));
	}

	@Override
	public boolean checkDefaultValue() {
		return false;
	}

	@PreDestroy
	public void dispose() {
	}

}
