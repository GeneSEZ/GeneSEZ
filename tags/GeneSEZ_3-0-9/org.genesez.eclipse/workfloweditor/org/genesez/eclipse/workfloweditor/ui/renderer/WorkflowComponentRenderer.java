/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe2.language.mwe2.Assignment;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.util.ClassHelper;
import org.genesez.eclipse.workfloweditor.util.Description;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.profile.WfParameter;

//import org.genesez.workflow.WorkflowComponent;

/**
 * Class to render WorkflowComponents. Contains also DND functionality. TODO: Clean the Code, currently really messed up, due to
 * many changes cause of the MWE2-Model. TODO: Complete functionality and commentaries.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class WorkflowComponentRenderer extends FeatureRenderer {

	private static final String NO_DESCRIPTION = "No description given for the component.";
	private static final String DESCRIPTION = "Description:";
	private static final String OPEN = " Open ";
	private static final String CLOSE = " Close ";
	private static final String SHOW_SUMMARY = "Show summary when closed.";

	public static Map<Label, WorkflowComponentRenderer> fromDropTarget = new HashMap<Label, WorkflowComponentRenderer>();
	public static Map<Group, WorkflowComponentRenderer> fromDragSource = new HashMap<Group, WorkflowComponentRenderer>();

	private Group group;
	private Composite header;
	private Composite advanced;

	private DragSource dragSource;
	private DropTarget dropTarget;

	private Composite description;
	private Label lblDescription;

	private Composite showMore;
	private Button btnCheckButton;
	private Button btnOpenClose;

	// private Image closeImage;
	private Composite dynamicOpenPart;
	private Composite dynamicClosedPart;

	private Label precedingDropTarget;

	private Color compositeColor;

	private Map<Field, Method[]> advancedFields;

	private IWorkflowComponent defaultWorkflowComponent;

	private SelectionListener advancedBtnListener;
	private SelectionListener simpleBtnListener;

	private boolean fallback = true;
	private boolean adder;

	@Inject
	private UIController controller;

	@Inject
	private IEclipseContext context;

	@Inject
	@Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT)
	private WorkflowComponent currentComponent;

	@Inject
	@Named(WorkfloweditorConstants.DRAGGED_WORKFLOWCOMPONENTGROUP)
	private WorkflowComponentRenderer dragGroup;

	@Inject
	@Named(WorkfloweditorConstants.CURRENT_TRANSFERS)
	private Transfer[] transfers;

	public WorkflowComponentRenderer(JvmFeature feature, Component component, boolean adder) {
		super(feature, component);
		this.adder = adder;
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 *            the parent composite. This should be inherited in at least another composite.
	 * @param component
	 *            the component that should be rendered
	 * @param closeButtonImage
	 *            the image for the closeButton, maybe null.
	 */
	@Override
	public void renderElement(Composite parent) {
		parent.setLayout(new GridLayout());
		if (adder) {
			precedingDropTarget = new Label(parent, SWT.NONE);
			GridData gd_drop = new GridData(SWT.FILL, SWT.FILL, true, false);
			gd_drop.heightHint = 6;
			precedingDropTarget.setLayoutData(gd_drop);
		}

		group = new Group(parent, SWT.BORDER | SWT.SHADOW_OUT);
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
		group.setLayout(new GridLayout());

		compositeColor = group.getBackground();

		header = new Composite(group, SWT.NONE);
		header.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		header.setLayout(new GridLayout(3, false));

		Label lblDescriptionLabel = new Label(header, SWT.NONE);
		lblDescriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		lblDescriptionLabel.setText(DESCRIPTION);
		lblDescriptionLabel.setFont(SWTResourceManager.getFont("Sans", 10, SWT.BOLD));

		new Label(header, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		createDecoratedElement(header);
		// btnUpButton = new Button(header, SWT.ARROW | SWT.UP);
		// btnDownButton = new Button(header, SWT.ARROW | SWT.DOWN);
		// btnDeleteButton = new Button(header, SWT.CLOSE);
		// if (closeImage != null) {
		// btnDeleteButton.setImage(closeImage);
		// } else {
		// btnDeleteButton.setText(" X ");
		// }

		description = new Composite(group, SWT.NONE);
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		description.setLayout(new GridLayout());

		lblDescription = new Label(description, SWT.WRAP);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		Description descriptionAnnotation = null;
		if (!fallback) {
			descriptionAnnotation = defaultWorkflowComponent.getClass().getAnnotation(Description.class);
		}
		if (descriptionAnnotation == null) {
			lblDescription.setText(NO_DESCRIPTION);
		} else {
			lblDescription.setText(descriptionAnnotation.text());
		}

		showMore = new Composite(group, SWT.NONE);
		showMore.setLayout(new GridLayout(3, false));
		showMore.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		btnCheckButton = new Button(showMore, SWT.CHECK);
		btnCheckButton.setText(SHOW_SUMMARY);
		btnCheckButton.setSelection(false);

		new Label(showMore, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		btnOpenClose = new Button(showMore, SWT.TOGGLE);
		btnOpenClose.setText(OPEN);

		new Label(group, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		if (adder) {
			dragSource = new DragSource(group, DND.DROP_MOVE);
			dragSource.setTransfer(transfers);

			dropTarget = new DropTarget(precedingDropTarget, DND.DROP_MOVE | DND.DROP_DEFAULT);
			dropTarget.setTransfer(transfers);

			fromDropTarget.put(precedingDropTarget, this);
			fromDragSource.put(group, this);
		}
		addListener();
	}

	/**
	 * TODO: Should contain the summarized version of the component
	 * 
	 * @return the composite containing the summary
	 */
	private Composite closedPart() {
		dynamicClosedPart = new Composite(group, SWT.NONE);
		dynamicClosedPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicClosedPart.setLayout(new FillLayout());
		Text closedText = new Text(dynamicClosedPart, SWT.WRAP | SWT.MULTI);
		// closedText.setEditable(false);
		// StringBuffer buffer = new StringBuffer();
		// for (Field field : ClassHelper.getAllFields(defaultWorkflowComponent.getClass(), WorkflowComponent.class)) {
		// Parameter param = field.getAnnotation(Parameter.class);
		// if (param != null) {
		// Method array[] = new Method[4];
		// Boolean checkField = checkShowField(array, field, param);
		// if (checkField == null || !checkField) {
		// continue;
		// }
		// buffer.append(field.getName() + " = " + getValue(field, workflowComponent, array) + "\n");
		// }
		// }
		// String text = buffer.toString().trim();
		// if (text.isEmpty()) {
		// closedText.setVisible(false);
		// }
		// closedText.setText(text);
		return dynamicClosedPart;
	}

	/**
	 * TODO: Needs complete rewrite -> should check if a field is shown immediately or only in advanced view.
	 * 
	 * @param array
	 * @param field
	 * @param param
	 * @return
	 */
	private Boolean checkShowField(Method[] array, Field field, WfParameter param) {
		if (array != null && array.length >= 4) {
			array[0] = ClassHelper.getGetter(field);
			array[1] = ClassHelper.getSetter(field);
			array[2] = ClassHelper.getAdder(field);
			array[3] = ClassHelper.getRemover(field);

			if (array[0] == null || (array[1] == null && (array[2] == null || array[3] == null))) {
				return null;
			}

			String value = getValue(field, defaultWorkflowComponent, array);

			if (defaultWorkflowComponent == null) {
				if (param.isRequired()) {
					return true;
				}
				return false;
			}

			if (param.isRequired() && (value.isEmpty() || value.equals(Collections.EMPTY_LIST.toString()))) {
				return true;
			}
			if (getValue(field, defaultWorkflowComponent, array).equals(getValue(field, defaultWorkflowComponent, array))) {
				return false;
			}
			return true;
		}
		return null;
	}

	/**
	 * TODO: Maybe not needed -> rewrite
	 * 
	 * @param field
	 * @param instance
	 * @param array
	 * @return
	 */
	private String getValue(Field field, Object instance, Method[] array) {
		Object value = null;
		try {
			value = array[0].invoke(instance);
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (value == null) {
			return "";
		}
		return value.toString();
	}

	/**
	 * Called when the workflowComponent gets opened. Shows all available JvmFeatures.
	 * 
	 * @return the Composite containing the Features.
	 */
	private Composite openPart() {
		dynamicOpenPart = new Composite(group, SWT.NONE);
		dynamicOpenPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicOpenPart.setLayout(new GridLayout());
		controller.readFeatures((Component) assignment.getValue(), dynamicOpenPart, context);
		// advancedFields = new HashMap<Field, Method[]>();
		// for (Field field : ClassHelper.getAllFields(defaultWorkflowComponent.getClass(), WorkflowComponent.class)) {
		// Parameter param = field.getAnnotation(Parameter.class);
		// if (param != null) {
		// Method array[] = new Method[4];
		// Boolean checkField = checkShowField(array, field, param);
		// if (checkField == null) {
		// continue;
		// }
		// if (checkField) {
		// renderField(field, param, array);
		// } else {
		// advancedFields.put(field, array);
		// }
		// }
		// }
		// new Label(dynamicOpenPart, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false,
		// 2,
		// 1));
		// if (!advancedFields.isEmpty()) {
		// advanced = new Composite(dynamicOpenPart, SWT.NONE);
		// advanced.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
		// advanced.setLayout(new GridLayout(2, false));
		// Label label_l = new Label(advanced, SWT.NONE);
		// label_l.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// Button btnAdvanced = new Button(advanced, SWT.PUSH);
		// btnAdvanced.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		// btnAdvanced.setText("Advanced >>");
		// btnAdvanced.addSelectionListener(advancedBtnListener);
		// }
		return dynamicOpenPart;
	}

	/**
	 * TODO: Should open advanced part, maybe it works like this.
	 * 
	 * @return the Composite containing the Advanced Feature.
	 */
	private Composite openAdvancedPart() {
		for (Field field : advancedFields.keySet()) {
			renderField(field, field.getAnnotation(WfParameter.class), advancedFields.get(field));
		}
		Composite simple = new Composite(dynamicOpenPart, SWT.NONE);
		simple.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1));
		simple.setLayout(new GridLayout(2, false));
		Label label_l = new Label(simple, SWT.NONE);
		label_l.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		Button btnSimple = new Button(simple, SWT.PUSH);
		btnSimple.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
		btnSimple.setText("<< Simple");
		btnSimple.addSelectionListener(simpleBtnListener);
		return dynamicOpenPart;
	}

	/**
	 * TODO: Should render a field -> rewrite for MWE2 Model (or delete)
	 * 
	 * @param field
	 * @param param
	 * @param array
	 */
	private void renderField(Field field, WfParameter param, Method[] array) {
		boolean rendered = false;
		// for (FeatureRenderer renderer : renderers) {
		// if (renderer.renderElement(dynamicOpenPart, field, param, workflowComponent, workbench, context)) {
		// rendered = true;
		// break;
		// }
		// }
		// if (!rendered) {
		// defaultRenderer.renderElement(dynamicOpenPart, field, param, workflowComponent, workbench, context);
		// }
	}

	/**
	 * Adds the listeners to the buttons
	 */
	private void addListener() {
		final WorkflowComponentRenderer renderer = this;
		// open advanced part
		advancedBtnListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				advanced.dispose();
				openAdvancedPart();
				controller.refreshView();
			}
		};

		// close advanced part
		simpleBtnListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dynamicOpenPart.dispose();
				openPart();
				controller.refreshView();
			}
		};

		// creates and disposes the needed parts
		btnOpenClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnOpenClose.getSelection()) {
					if (dynamicClosedPart != null) {
						dynamicClosedPart.dispose();
					}
					openPart();
					btnOpenClose.setText(CLOSE);
					controller.refreshView();
				} else {
					if (dynamicOpenPart != null) {
						dynamicOpenPart.dispose();
					}
					btnOpenClose.setText(OPEN);
					btnCheckButton.notifyListeners(SWT.Selection, new Event());
				}
			}
		});

		// creates and disposes the needed parts
		btnCheckButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!btnOpenClose.getSelection()) {
					if (btnCheckButton.getSelection()) {
						closedPart();
					} else {
						if (dynamicClosedPart != null) {
							dynamicClosedPart.dispose();
						}
					}
				}
				controller.refreshView();
			}
		});

		// // disposes the group
		// btnDeleteButton.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// precedingDropTarget.dispose();
		// group.dispose();
		// controller.removeAssignment(component, assignment);
		// controller.refreshView();
		// }
		// });
		//
		// // moves the group above the preceding group
		// btnUpButton.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// int pos = getRealPosition();
		// if (pos > 1) {
		// group.moveAbove(group.getParent().getChildren()[pos - 3]);
		// precedingDropTarget.moveAbove(group);
		// controller.refreshView();
		// }
		// }
		// });
		//
		// // moves the group below the following group
		// btnDownButton.addSelectionListener(new SelectionAdapter() {
		//
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// int pos = getRealPosition();
		// if (pos != -1 && pos < (group.getParent().getChildren().length - 2)) {
		// group.moveBelow(group.getParent().getChildren()[pos + 2]);
		// precedingDropTarget.moveAbove(group);
		// controller.refreshView();
		// }
		// }
		// });

		// if its an Adder DND functionality is enabled.
		if (adder) {
			precedingDropTarget.addMouseTrackListener(new MouseTrackAdapter() {

				@Override
				public void mouseExit(MouseEvent e) {
					Label control = (Label) e.widget;
					control.setBackground(compositeColor);
				}

				@Override
				public void mouseEnter(MouseEvent e) {
					Label control = (Label) e.widget;
					if (currentComponent != null || dragGroup != null) {
						control.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW));
					}
				}
			});

			precedingDropTarget.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseUp(MouseEvent e) {
					if (currentComponent != null) {
						controller.addWorkflowComponent(currentComponent, component, renderer);
						context.modify(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT, null);
						Event event = new Event();
						event.widget = e.widget;
						((Control) e.widget).notifyListeners(SWT.MouseExit, event);
						controller.refreshView();
					}
				}
			});

			dropTarget.addDropListener(new DropTargetAdapter() {

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
						Control dropped = ((DropTarget) event.widget).getControl();
						if (controller.reorderChildren(dragGroup, dropped)) {
							controller.reorderAssignments(dragGroup, dropped);
						}
					}
				}
			});

			dragSource.addDragListener(new DragSourceAdapter() {

				@Override
				public void dragStart(DragSourceEvent event) {
					context.modify(WorkfloweditorConstants.DRAGGED_WORKFLOWCOMPONENTGROUP,
							WorkflowComponentRenderer.fromDragSource.get(((DragSource) event.widget).getControl()));
				}

				@Override
				public void dragSetData(DragSourceEvent event) {
					event.data = "dragging";
				}

				@Override
				public void dragFinished(DragSourceEvent event) {
					context.modify(WorkfloweditorConstants.DRAGGED_WORKFLOWCOMPONENTGROUP, null);
					controller.refreshView();
				}
			});
		}
	}

	/**
	 * Gets the label that gets the dragEvents (its before the group).
	 * 
	 * @return the label
	 */
	public Label getPrecedingDragTarget() {
		return precedingDropTarget;
	}

	/**
	 * Gets the group
	 * 
	 * @return the group
	 */
	public Group getGroup() {
		return group;
	}

	/**
	 * Gets the connected WorkflowComponent
	 * 
	 * @return the workflow component
	 */
	public IWorkflowComponent getWorkflowComponent() {
		return defaultWorkflowComponent;
	}

	@Override
	public boolean checkDefaultValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void changeValue() {
		if (value != null) {
			group.setText(value.getActualType().getSimpleName());
			try {
				defaultWorkflowComponent = (IWorkflowComponent) Class.forName(value.getActualType().getQualifiedName())
						.newInstance();
				fallback = false;
			} catch (Exception e) {
				fallback = true;
			}
		} else {
			fallback = true;
			group.setText("");
		}
	}

	public Assignment getAssignment() {
		return assignment;
	}

	public Component getComponent() {
		return component;
	}
}
