package org.genesez.eclipse.workfloweditor.ui;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbench;
import org.eclipse.wb.swt.SWTResourceManager;
import org.genesez.eclipse.workfloweditor.ui.renderer.FieldRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.RendererRegisterHelper;
import org.genesez.eclipse.workfloweditor.util.ClassHelper;
import org.genesez.eclipse.workfloweditor.util.Description;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;
import org.genesez.workflow.WorkflowComponent;
import org.genesez.workflow.profile.Parameter;

@SuppressWarnings("restriction")
public class WorkflowComponentGroup {

	private static final String NO_DESCRIPTION = "No description given for the component.";
	private static final String DESCRIPTION = "Description:";
	private static final String OPEN = " Open ";
	private static final String CLOSE = " Close ";
	private static final String SHOW_SUMMARY = "Show summary when closed.";

	public static Map<Group, WorkflowComponentGroup> groups = new HashMap<Group, WorkflowComponentGroup>();
	private static Collection<FieldRenderer> renderers = RendererRegisterHelper.getRenderer();
	private static FieldRenderer defaultRenderer = RendererRegisterHelper.getDefaultRenderer();

	private Group group;
	private Composite header;
	private Button btnUpButton;
	private Button btnDownButton;
	private Button btnDeleteButton;
	private Composite advanced;

	private Composite description;
	private Label lblDescription;

	private Composite showMore;
	private Button btnCheckButton;
	private Button btnOpenClose;

	private Image closeImage;
	private Composite dynamicOpenPart;
	private Composite dynamicClosedPart;

	private Label precedingDragTarget;

	private Map<Field, Method[]> advancedFields;

	private final WorkflowComponent workflowComponent;

	private WorkflowComponent defaultWorkflowComponent = null;

	private SelectionListener advancedBtnListener;
	private SelectionListener simpleBtnListener;

	@Inject
	private UIController controller;

	@Inject
	private IEclipseContext context;

	@Inject
	private IWorkbench workbench;

	@Inject
	@Named(WorkfloweditorConstants.HEAD_COMPOSITE)
	private Composite headComposite;

	public WorkflowComponentGroup(WorkflowComponent component) {
		this.workflowComponent = component;
		try {
			this.defaultWorkflowComponent = component.getClass().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
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
	@PostConstruct
	public void createControls(Composite parent) {
		if (workbench != null) {
			ISharedImages eclipseImages = workbench.getSharedImages();
			closeImage = eclipseImages.getImage(ISharedImages.IMG_TOOL_DELETE);
		}

		precedingDragTarget = new Label(parent, SWT.NONE);
		GridData gd_drag = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_drag.heightHint = 4;
		precedingDragTarget.setLayoutData(gd_drag);

		group = new Group(parent, SWT.BORDER | SWT.SHADOW_OUT);
		groups.put(group, this);
		group.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

		group.setText(workflowComponent.getComponentName());
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
		if (closeImage != null) {
			btnDeleteButton.setImage(closeImage);
		} else {
			btnDeleteButton.setText(" X ");
		}

		description = new Composite(group, SWT.NONE);
		description.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		description.setLayout(new GridLayout());

		lblDescription = new Label(description, SWT.WRAP);
		lblDescription.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));

		Description descriptionAnnotation = workflowComponent.getClass().getAnnotation(Description.class);
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

	private Composite closedPart() {
		dynamicClosedPart = new Composite(group, SWT.NONE);
		dynamicClosedPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicClosedPart.setLayout(new FillLayout());
		Text closedText = new Text(dynamicClosedPart, SWT.WRAP | SWT.MULTI);
		closedText.setEditable(false);
		StringBuffer buffer = new StringBuffer();
		for (Field field : ClassHelper.getAllFields(workflowComponent.getClass(), WorkflowComponent.class)) {
			Parameter param = field.getAnnotation(Parameter.class);
			if (param != null) {
				Method array[] = new Method[4];
				Boolean checkField = checkShowField(array, field, param);
				if (checkField == null || !checkField) {
					continue;
				}
				buffer.append(field.getName() + " = " + getValue(field, workflowComponent, array) + "\n");
			}
		}
		String text = buffer.toString().trim();
		if (text.isEmpty()) {
			closedText.setVisible(false);
		}
		closedText.setText(text);
		return dynamicClosedPart;
	}

	private Boolean checkShowField(Method[] array, Field field, Parameter param) {
		if (array != null && array.length >= 4) {
			array[0] = ClassHelper.getGetter(field);
			array[1] = ClassHelper.getSetter(field);
			array[2] = ClassHelper.getAdder(field);
			array[3] = ClassHelper.getRemover(field);

			if (array[0] == null || (array[1] == null && (array[2] == null || array[3] == null))) {
				return null;
			}

			String value = getValue(field, workflowComponent, array);

			if (defaultWorkflowComponent == null) {
				if (param.isRequired()) {
					return true;
				}
				return false;
			}

			if (param.isRequired() && (value.isEmpty() || value.equals(Collections.EMPTY_LIST.toString()))) {
				return true;
			}
			if (getValue(field, workflowComponent, array).equals(getValue(field, defaultWorkflowComponent, array))) {
				return false;
			}
			return true;
		}
		return null;
	}

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

	private Composite openPart() {
		dynamicOpenPart = new Composite(group, SWT.NONE);
		dynamicOpenPart.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dynamicOpenPart.setLayout(new GridLayout(2, false));
		advancedFields = new HashMap<Field, Method[]>();
		for (Field field : ClassHelper.getAllFields(workflowComponent.getClass(), WorkflowComponent.class)) {
			Parameter param = field.getAnnotation(Parameter.class);
			if (param != null) {
				Method array[] = new Method[4];
				Boolean checkField = checkShowField(array, field, param);
				if (checkField == null) {
					continue;
				}
				if (checkField) {
					renderField(field, param, array);
				} else {
					advancedFields.put(field, array);
				}
			}
		}
		new Label(dynamicOpenPart, SWT.SEPARATOR | SWT.HORIZONTAL).setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 2,
				1));
		if (!advancedFields.isEmpty()) {
			advanced = new Composite(dynamicOpenPart, SWT.NONE);
			advanced.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 2, 1));
			advanced.setLayout(new GridLayout(2, false));
			Label label_l = new Label(advanced, SWT.NONE);
			label_l.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
			Button btnAdvanced = new Button(advanced, SWT.PUSH);
			btnAdvanced.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			btnAdvanced.setText("Advanced >>");
			btnAdvanced.addSelectionListener(advancedBtnListener);
		}
		return dynamicOpenPart;
	}

	private Composite openAdvancedPart() {
		for (Field field : advancedFields.keySet()) {
			renderField(field, field.getAnnotation(Parameter.class), advancedFields.get(field));
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

	private void renderField(Field field, Parameter param, Method[] array) {
		boolean rendered = false;
		for (FieldRenderer renderer : renderers) {
			if (renderer.renderElement(dynamicOpenPart, field, param, workflowComponent, workbench, context)) {
				rendered = true;
				break;
			}
		}
		if (!rendered) {
			defaultRenderer.renderElement(dynamicOpenPart, field, param, workflowComponent, workbench, context);
		}
	}

	private void addListener() {
		advancedBtnListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				advanced.dispose();
				openAdvancedPart();
				headComposite.notifyListeners(SWT.Resize, new Event());
			}
		};

		simpleBtnListener = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dynamicOpenPart.dispose();
				openPart();
				headComposite.notifyListeners(SWT.Resize, new Event());
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
					headComposite.notifyListeners(SWT.Resize, new Event());
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
					headComposite.notifyListeners(SWT.Resize, new Event());
				}
			}
		});

		// disposes the group
		btnDeleteButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				precedingDragTarget.dispose();
				group.dispose();
				headComposite.notifyListeners(SWT.Resize, new Event());
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
					headComposite.notifyListeners(SWT.Resize, new Event());
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
					headComposite.notifyListeners(SWT.Resize, new Event());
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
