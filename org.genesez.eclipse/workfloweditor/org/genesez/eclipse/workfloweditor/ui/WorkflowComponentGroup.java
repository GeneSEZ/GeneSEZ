package org.genesez.eclipse.workfloweditor.ui;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.genesez.eclipse.workfloweditor.util.Description;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

public class WorkflowComponentGroup {

	private static final String NO_DESCRIPTION = "No description given for the component.";
	private static final String DESCRIPTION = "Description:";
	private static final String OPEN = " Open ";
	private static final String CLOSE = "Close";
	private static final String SHOW_SUMMARY = "Show summary when closed.";

	public static Map<Group, WorkflowComponentGroup> groups = new HashMap<Group, WorkflowComponentGroup>();

	private final Group group;
	private final Composite header;
	private final Button btnUpButton;
	private final Button btnDownButton;
	private final Button btnDeleteButton;
	private final Composite parentParent;

	private final Composite description;
	private final Label lblDescription;

	private final Composite showMore;
	private final Button btnCheckButton;
	private final Button btnOpenClose;

	private Composite dynamicOpenPart;
	private Composite dynamicClosedPart;

	private final Label precedingDragTarget;

	private final WorkflowComponent workflowComponent;

	@Inject
	private @Named(WorkfloweditorConstants.SELECTED_WORKFLOWCOMPONENT)
	WorkflowComponent currentComponent;

	/**
	 * @wbp.parser.constructor
	 */
	public WorkflowComponentGroup(Composite parent, WorkflowComponent component) {
		this(parent, component, null);
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
	public WorkflowComponentGroup(Composite parent, WorkflowComponent component, Image closeButtonImage) {
		precedingDragTarget = new Label(parent, SWT.NONE);
		GridData gd_drag = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_drag.heightHint = 4;
		precedingDragTarget.setLayoutData(gd_drag);

		group = new Group(parent, SWT.BORDER | SWT.SHADOW_OUT);
		groups.put(group, this);
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		this.parentParent = parent.getParent();
		this.workflowComponent = component;
		group.setText(component.getComponentName());
		group.setLayout(new GridLayout());

		header = new Composite(group, SWT.NONE);
		header.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		header.setLayout(new GridLayout(5, false));

		Label lblDescriptionLabel = new Label(header, SWT.NONE);
		lblDescriptionLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, false, 1, 1));
		lblDescriptionLabel.setText(DESCRIPTION);
		lblDescriptionLabel.setFont(SWTResourceManager.getFont("Sans", 10, SWT.BOLD));

		new Label(header, SWT.NONE).setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		btnUpButton = new Button(header, SWT.ARROW | SWT.UP);
		btnDownButton = new Button(header, SWT.ARROW | SWT.DOWN);
		btnDeleteButton = new Button(header, SWT.CLOSE);
		if (closeButtonImage == null) {
			btnDeleteButton.setText(" X ");
		} else {
			btnDeleteButton.setImage(closeButtonImage);
		}

		description = new Composite(group, SWT.NONE);
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		description.setLayout(new GridLayout());

		lblDescription = new Label(description, SWT.WRAP);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		Description descriptionAnnotation = component.getClass().getAnnotation(Description.class);
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

		addListener();
	}

	@SuppressWarnings("rawtypes")
	private List<Field> getAllFields() {
		List<Class> classes = new ArrayList<Class>();
		Class clazz = workflowComponent.getClass();
		while (!clazz.equals(Object.class)) {
			classes.add(clazz);
			clazz = clazz.getSuperclass();
		}
		for (int i = classes.size() - 1; i >= 0; i--) {
			Class[] interfaces = classes.get(i).getInterfaces();
			boolean hasInterface = false;
			for (Class interfaze : interfaces) {
				if (interfaze.equals(WorkflowComponent.class)) {
					hasInterface = true;
					break;
				}
			}
			if (hasInterface) {
				break;
			}
			classes.remove(i);
		}
		List<Field> fields = new ArrayList<Field>();
		for (Class clazz_i : classes) {
			try {
				Collections.addAll(fields, clazz_i.getDeclaredFields());
			} catch (NoClassDefFoundError e) {
				continue;
			}
		}
		return fields;
	}

	private Composite closedPart() {
		dynamicClosedPart = new Composite(group, SWT.NONE);
		dynamicClosedPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicClosedPart.setLayout(new FillLayout());
		Text closedText = new Text(dynamicClosedPart, SWT.WRAP | SWT.MULTI);
		closedText.setEditable(false);
		for (Field field : getAllFields()) {
			Parameter param = field.getAnnotation(Parameter.class);
			if (param != null) {
				field.setAccessible(true);
				String text = closedText.getText() + field.getName() + " = ";
				Object value = null;
				try {
					value = field.get(workflowComponent);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (value == null) {
					closedText.setText(text + "null\n");
				} else {
					closedText.setText(text + value.toString() + "\n");
				}
			}
		}
		closedText.setText(closedText.getText().trim());
		return dynamicClosedPart;
	}

	private Composite openPart() {
		dynamicOpenPart = new Composite(group, SWT.NONE);
		dynamicOpenPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicOpenPart.setLayout(new GridLayout(2, false));
		for (Field field : getAllFields()) {
			Parameter param = field.getAnnotation(Parameter.class);
			if (param != null) {
				field.setAccessible(true);
				Label fieldLabel = new Label(dynamicOpenPart, SWT.NONE);
				fieldLabel.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
				fieldLabel.setText(field.getName() + ":");
				Text fieldValue = new Text(dynamicOpenPart, SWT.BORDER);
				fieldValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
				Object value = null;
				try {
					value = field.get(workflowComponent);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				if (value != null) {
					fieldValue.setText(value.toString());
				}
			}
		}
		return dynamicOpenPart;
	}

	private void addListener() {

		// creates and disposes the needed parts
		btnOpenClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnOpenClose.getSelection()) {
					if (dynamicClosedPart != null) {
						dynamicClosedPart.dispose();
					}
					openPart();
					group.setSize(group.getSize().x, group.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
					parentParent.notifyListeners(SWT.Resize, new Event());
				} else {
					if (dynamicOpenPart != null) {
						dynamicOpenPart.dispose();
					}
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
					group.setSize(group.getSize().x, group.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
					parentParent.notifyListeners(SWT.Resize, new Event());
				}
			}
		});

		// disposes the group
		btnDeleteButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				precedingDragTarget.dispose();
				group.dispose();
				parentParent.notifyListeners(SWT.Resize, new Event());
			}
		});

		// Changes the Label of the OpenClose Button
		btnOpenClose.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (btnOpenClose.getSelection()) {
					btnOpenClose.setText(CLOSE);
				} else {
					btnOpenClose.setText(OPEN);
				}
			}
		});

		// moves the group above the preceding group
		btnUpButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int pos = getPosition();
				if (pos > 1) {
					group.moveAbove(group.getParent().getChildren()[pos - 3]);
					precedingDragTarget.moveAbove(group);
					parentParent.notifyListeners(SWT.Resize, new Event());
				}
			}
		});

		// moves the group below the following group
		btnDownButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int pos = getPosition();
				if (pos != -1 && pos < (group.getParent().getChildren().length - 2)) {
					group.moveBelow(group.getParent().getChildren()[pos + 2]);
					precedingDragTarget.moveAbove(group);
					parentParent.notifyListeners(SWT.Resize, new Event());
				}
			}
		});
	}

	/**
	 * Gets the current position in the surrounding Composite
	 * 
	 * @return the position.
	 */
	public int getPosition() {
		Control[] children = group.getParent().getChildren();
		for (int i = 0; i < children.length; i++) {
			if (children[i].equals(group)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the label that gets the dragEvents (its before the group).
	 * 
	 * @return the label
	 */
	public Label getPrecedingDragTarget() {
		return precedingDragTarget;
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
	public WorkflowComponent getWorkflowComponent() {
		return workflowComponent;
	}
}
