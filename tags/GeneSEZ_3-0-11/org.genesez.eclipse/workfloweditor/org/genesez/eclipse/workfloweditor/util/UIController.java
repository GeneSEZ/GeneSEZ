/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.core.resources.IFile;
import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.mwe.core.WorkflowComponent;
import org.eclipse.emf.mwe2.language.mwe2.Assignment;
import org.eclipse.emf.mwe2.language.mwe2.BooleanLiteral;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Module;
import org.eclipse.emf.mwe2.language.mwe2.Mwe2Factory;
import org.eclipse.emf.mwe2.language.mwe2.PlainString;
import org.eclipse.emf.mwe2.language.mwe2.StringLiteral;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.emf.mwe2.runtime.workflow.Workflow;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.xtext.ui.XtextResourceSetBasedProjectProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.genesez.eclipse.workfloweditor.WorkflowEditor;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.Renderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WorkflowComponentRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.AbstractFeatureDecorator;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

//import org.genesez.workflow.WorkflowComponent;

/**
 * The Controller class that connects the view with the model. It is only a slight version of the MVC Controller. Every
 * interaction between model and view is handled here.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public class UIController {

	private static Map<Component, Map<JvmFeature, WrapFeatureRenderer>> components = new HashMap<Component, Map<JvmFeature, WrapFeatureRenderer>>();

	private final IFile file;
	private final Mwe2Factory mwe2Factory = Mwe2Factory.eINSTANCE;
	private Module module = null;
	private Component root = null;
	private final XtextResourceSet rSet = new XtextResourceSet();
	private final Resource fileResource;
	private final IJvmTypeProvider typeProvider;
	private final WorkflowEditor editor;
	private final JdtTypeProviderFactory factory;
	private Composite headComposite;

	// private IJdtTypeProvider provider;
	// private JdtBasedTypeFactory jbtf;

	/**
	 * Constructs and initializes the Controller
	 * 
	 * @param file
	 *            the file to read
	 * @param editor
	 *            the editor to work with
	 */
	public UIController(IFile file, WorkflowEditor editor) {
		this.file = file;
		this.editor = editor;
		this.fileResource = rSet.getResource(URI.createFileURI(file.getLocationURI().getPath()), true);

		rSet.setClasspathURIContext(JavaCore.create(file.getProject()));

		XtextResourceSetBasedProjectProvider xrsbpp = new XtextResourceSetBasedProjectProvider();
		factory = new JdtTypeProviderFactory(xrsbpp);
		// injector = new Mwe2StandaloneSetup().createInjectorAndDoEMFRegistration();
		// Object o = injector.getInstance(IJvmTypeProvider.Factory.class);
		// factory = injector.getInstance(JdtTypeProviderFactory.class);
		typeProvider = factory.createTypeProvider(rSet);
		// JdtBasedTypeFactory f = typeProvider.getJdtBasedTypeFactory();
		// jbtf = ((JdtTypeProvider) provider).getJdtBasedTypeFactory();

		// URI uri = URI.createFileURI(file.getLocationURI().getPath());
		// this.fileResource = rSet.getResource(uri, true);
		module = getModuleInternal();
		EcoreUtil.resolveAll(module);
		root = getRootInternal();
	}

	/**
	 * gets the module from the Model
	 * 
	 * @return the Module
	 */
	private Module getModuleInternal() {
		List<EObject> list = fileResource.getContents();
		if (list.isEmpty() || !(list.get(0) instanceof Module)) {
			Module m = mwe2Factory.createModule();
			fileResource.getContents().add(m);
			return m;
			// return false;
		}
		return (Module) list.get(0);
		// return true;
	}

	/**
	 * gets the root Component from the Model
	 * 
	 * @return the root Component
	 */
	private Component getRootInternal() {
		Component root = module.getRoot();
		if (root != null && root.getType().equals(getType(Workflow.class))) {
			return root;
		}
		root = mwe2Factory.createComponent();
		root.setType(getType(Workflow.class));
		module.setRoot(root);
		editor.setDirty(true);
		return root;
	}

	/**
	 * Sets the headComposite (used for resizing and layout)
	 * 
	 * @param composite
	 *            the head scrolled composite.
	 */
	public void setHeadComposite(Composite composite) {
		this.headComposite = composite;
	}

	/**
	 * Changes the editors state
	 * 
	 * @param dirty
	 *            true if something changed (save will be activated)
	 */
	public void setDirty(boolean dirty) {
		editor.setDirty(dirty);
	}

	/**
	 * Gets the name of the file
	 * 
	 * @return the file name
	 */
	public String getFileName() {
		return file.getName();
	}

	/**
	 * Gets the name of the Module
	 * 
	 * @return the module name
	 */
	public String getModuleName() {
		return module.getCanonicalName();
	}

	/**
	 * Gets the rootComponent
	 * 
	 * @return the root component
	 */
	public Component getRootComponent() {
		return root;
	}

	/**
	 * Gets the JvmDeclaredType from a classname
	 * 
	 * @param clazz
	 *            the class to get the type from
	 * @return the JvmDeclaredType
	 */
	public JvmDeclaredType getType(Class<?> clazz) {
		return (JvmDeclaredType) typeProvider.findTypeByName(clazz.getName());
	}

	/**
	 * Gets a specific Operation, with the given parameters. If no parameters are given, it will search only for Methods with the
	 * given name and 1 none-void parameter.
	 * 
	 * @param type
	 *            the Type that should be searched for the operation
	 * @param methodName
	 *            the name of the searched method
	 * @param params
	 *            qualifiedNames of the parameters (can be null)
	 * @return the operation that matches or null if not found.
	 */
	public JvmOperation getSpecificOperation(JvmDeclaredType type, final String methodName, final String... params) {
		try {
			return Iterables.find(Iterables.filter(type.getAllFeatures(), JvmOperation.class), new Predicate<JvmOperation>() {
				@Override
				public boolean apply(JvmOperation op) {
					List<JvmFormalParameter> parameters = op.getParameters();
					if (params != null && params.length != 0) {
						if (op.getSimpleName().equalsIgnoreCase(methodName) && parameters.size() == params.length) {
							for (int i = 0; i < params.length; i++) {
								if (!parameters.get(i).getParameterType().getQualifiedName().equals(params[i])) {
									return false;
								}
							}
							return true;
						}
					} else if (op.getSimpleName().equalsIgnoreCase(methodName) && parameters.size() == 1) {
						if (parameters.get(0) instanceof JvmVoid) {
							if (((JvmVoid) parameters.get(0)).getIdentifier().equals("void")) {
								return false;
							}
						}
						return true;
					}
					return false;
				}
			});
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	/**
	 * Changes the name of the module. If newName is empty the filename will be set instead.
	 * 
	 * @param newName
	 *            the newName (can be empty)
	 */
	public void changeModuleName(String newName) {
		if (newName.isEmpty()) {
			module.setCanonicalName(getFileName());
		} else {
			module.setCanonicalName(newName);
		}
		setDirty(true);
	}

	/**
	 * Creates a childContext of the given context, inserts the given Composite into it and injects the context into the given
	 * object.
	 * 
	 * @param parent
	 *            the parentComposite to insert
	 * @param parentContext
	 *            the context to derive a child from.
	 * @param toInject
	 *            the object, in which the new context is injected to.
	 */
	public void injectChildContext(Composite parent, IEclipseContext parentContext, Object toInject) {
		IEclipseContext context = parentContext.createChild();
		context.set(Composite.class, parent);
		ContextInjectionFactory.inject(toInject, context);
	}

	/**
	 * Reads the Features of a Component, stores them together with their WrapFeatureRenderern and places them into a Composite.
	 * 
	 * @param component
	 *            the Component the should be read for Features
	 * @param parent
	 *            the parent composite (to elements in)
	 * @param parentContext
	 *            the parent context
	 */
	public void readFeatures(Component component, Composite parent, IEclipseContext parentContext) {
		JvmType type = component.getType();
		if (type instanceof JvmDeclaredType) {
			Map<JvmFeature, WrapFeatureRenderer> featureMap = new HashMap<JvmFeature, WrapFeatureRenderer>();
			components.put(component, featureMap);
			for (JvmFeature feature : ((JvmDeclaredType) type).getAllFeatures()) {
				Boolean adder = isAdder(feature);
				if (adder == null) {
					continue;
				}
				WrapFeatureRenderer renderer = Renderer.renderFeature((JvmExecutable) feature, component, adder);
				featureMap.put(feature, renderer);
				injectChildContext(parent, parentContext, renderer);
			}
		}
		showAssignments(component);
		refreshView();
	}

	/**
	 * Renders all Assignments of a the given Component.
	 * 
	 * @param component
	 *            the component, which assignments should be rendered.
	 */
	private void showAssignments(Component component) {
		for (Assignment assignment : component.getAssignment()) {
			renderAssignment(component, assignment);
		}
	}

	/**
	 * Renders the Assignment from the given Component into the stored WrapFeatureRenderer for the Feature of the Assignment.
	 * 
	 * @param component
	 *            the Component which contains the Assignment
	 * @param assignment
	 *            the actual Assignment
	 * @return the used WrapFeatureRenderer
	 */
	public WrapFeatureRenderer renderAssignment(Component component, Assignment assignment) {
		WrapFeatureRenderer renderer = components.get(component).get(assignment.getFeature());
		if (renderer != null) {
			renderer.setValue(assignment.getValue());
		}
		return renderer;
	}

	/**
	 * Checks whether the Feature is a public JvmOperation and if its an Adder
	 * 
	 * @param feature
	 *            the Feature to check
	 * @return true if its an Adder, false if not, null if its not public or no JvmOperation
	 */
	private Boolean isAdder(JvmFeature feature) {
		if (feature instanceof JvmOperation && feature.getVisibility().equals(JvmVisibility.PUBLIC)) {
			String addOrSet = feature.getSimpleName().substring(0, 3);
			if (addOrSet.equals("add")) {
				return true;
			}
			if (addOrSet.equals("set")) {
				return false;
			}
		}
		return null;
	}

	/**
	 * Adds a WorkflowComponent to the model, in the right order. (Creates a new Assignment)
	 * 
	 * @param w_component
	 *            the WorkflowComponent to add
	 * @param addTo
	 *            the Component to add the WorkflowComponent to
	 * @param clickedRenderer
	 *            the Renderer that was clicked to place the WorkflowComponent on the right position.
	 * @return the created Assignment
	 */
	public Assignment addWorkflowComponent(WorkflowComponent w_component, Component addTo,
			WorkflowComponentRenderer clickedRenderer) {
		Assignment a = mwe2Factory.createAssignment();
		Component value = mwe2Factory.createComponent();
		JvmOperation feature = getSpecificOperation((JvmDeclaredType) addTo.getType(), "addComponent");
		JvmType type = getType(w_component.getClass());
		value.setType(type);
		a.setFeature(feature);
		a.setValue(value);
		if (clickedRenderer == null) {
			addTo.getAssignment().add(a);
			renderAssignment(addTo, a);
		} else {
			addTo.getAssignment().add(getPositionInAssignments(addTo.getAssignment(), clickedRenderer.getAssignment()), a);
			IFeatureRenderer renderer = renderAssignment(addTo, a).getActualRenderer();
			if (renderer instanceof AbstractFeatureDecorator) {
				renderer = ((AbstractFeatureDecorator) renderer).getRenderer();
			}
			reorderChildren((WorkflowComponentRenderer) renderer, clickedRenderer.getPrecedingDragTarget());
		}
		setDirty(true);

		return a;
	}

	/**
	 * Create and add an Assignment to a Component
	 * 
	 * @param feature
	 *            the Feature for the Assignment
	 * @param value
	 *            the Value for the Assignment
	 * @param toAdd
	 *            the Component to add the Assignment to
	 * @return the created Assignment
	 */
	public Assignment addAssignment(JvmFeature feature, Value value, Component toAdd) {
		Assignment a = mwe2Factory.createAssignment();
		a.setFeature(feature);
		a.setValue(value);
		toAdd.getAssignment().add(a);
		setDirty(true);
		return a;
	}

	/**
	 * Reomves an Assignment from a Component
	 * 
	 * @param removeFrom
	 *            the Component to remove the Assignment from
	 * @param assignment
	 *            the Assignment to remove
	 */
	public void removeAssignment(Component removeFrom, Assignment assignment) {
		removeFrom.getAssignment().remove(assignment);
		setDirty(true);
	}

	/**
	 * Places a StringLiteral into the model
	 * 
	 * @param assignment
	 *            the Assignment to place the StringLiteral to (can be null)
	 * @param text
	 *            the Text that the StringLiteral should contain
	 * @return the Value that was created
	 */
	public Value setStringLiteral(Assignment assignment, String text) {
		PlainString part = mwe2Factory.createPlainString();
		part.setValue(text);
		StringLiteral value = null;
		if (assignment == null) {
			value = mwe2Factory.createStringLiteral();
			value.setBegin("\"");
			value.setEnd("\"");
		} else {
			value = (StringLiteral) assignment.getValue();
			value.getParts().clear();
		}
		value.getParts().add(part);
		setDirty(true);
		return value;
	}

	/**
	 * Places a BooleanLiteral into the model
	 * 
	 * @param assignment
	 *            the Assignment to place the BooleanLiteral to (can be null)
	 * @param isTrue
	 *            the value of the BooleanLiteral
	 * @return the Value that was created
	 */
	public Value setBooleanLiteral(Assignment assignment, boolean isTrue) {
		BooleanLiteral value = null;
		if (assignment == null) {
			value = mwe2Factory.createBooleanLiteral();
		} else {
			value = (BooleanLiteral) assignment.getValue();
		}
		value.setIsTrue(isTrue);
		setDirty(true);
		return value;
	}

	/**
	 * Refreshes (layout) the View. (Calling SWT.Resize on the headComposite)
	 */
	public void refreshView() {
		if (headComposite != null && !headComposite.isDisposed()) {
			headComposite.notifyListeners(SWT.Resize, new Event());
		}
	}

	/**
	 * Changes order of the Assignments
	 * 
	 * @param toOrder
	 *            the WorkflowComponent that should be moved
	 * @param clickedControl
	 *            the Control that was clicked for moving
	 */
	public void reorderAssignments(WorkflowComponentRenderer toOrder, Control clickedControl) {
		if (toOrder != null && clickedControl != toOrder.getPrecedingDragTarget()) {
			List<Assignment> assignments = toOrder.getComponent().getAssignment();
			Assignment assignment = toOrder.getAssignment();
			int first = getPositionInAssignments(assignments, assignment);

			WorkflowComponentRenderer otherRenderer = WorkflowComponentRenderer.fromDropTarget.get(clickedControl);
			if (otherRenderer == null) {
				if (first != assignments.size() - 1) {
					moveAssignments(first, assignments.size(), assignment, assignments);
					setDirty(true);
				}
			} else if (otherRenderer.getComponent().equals(toOrder.getComponent())) {
				int second = getPositionInAssignments(assignments, otherRenderer.getAssignment());
				if ((second - first) != 1) {
					moveAssignments(first, second, assignment, assignments);
					setDirty(true);
				}
			}
		}
	}

	/**
	 * Moves the Assignments
	 * 
	 * @param first
	 *            position of the first Assignment
	 * @param second
	 *            position of the second Assignment
	 * @param assignment
	 *            the assignment to move
	 * @param assignments
	 *            all assignments of the Component
	 */
	private void moveAssignments(int first, int second, Assignment assignment, List<Assignment> assignments) {
		assignments.remove(first);
		if (first < second) {
			assignments.add(second - 1, assignment);
		} else {
			assignments.add(second, assignment);
		}
	}

	/**
	 * gets the position of the Assignments in the Assignments list
	 * 
	 * @param list
	 *            the list of Assignments
	 * @param assignment
	 *            the Assignment to get the position for
	 * @return the position of the Assignment
	 */
	private int getPositionInAssignments(List<Assignment> list, Assignment assignment) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(assignment)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Reorders the WorkflowComponentRenderers.
	 * 
	 * @param toOrder
	 *            the Renderer that should be ordered
	 * @param clickedControl
	 *            the control that was clicked
	 * @return true if something has changed
	 */
	public boolean reorderChildren(WorkflowComponentRenderer toOrder, Control clickedControl) {
		if (toOrder != null) {
			Group group = toOrder.getGroup();
			Label label = toOrder.getPrecedingDragTarget();
			if (clickedControl == null) {
				Control parent = getFillerControl(group);
				if (parent != null) {
					parent.moveBelow(null);
					return true;
				}
			} else if (!group.isDisposed() && clickedControl != label) {
				Control[] children = new Control[2];
				if (getBothParent(label, clickedControl, children)) {
					children[0].moveAbove(children[1]);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Gets that parent control that contains the {@link WorkfloweditorConstants#CURRENT_FILLER} String in its data
	 * 
	 * @param control
	 *            the control to start the search from
	 * @return that parent control that contains the String or null if not found
	 */
	private Control getFillerControl(Control control) {
		try {
			if (WorkfloweditorConstants.CURRENT_FILLER.equals(control.getParent().getData())) {
				return control;
			}
			return getFillerControl(control.getParent());
		} catch (NullPointerException e) {
			return null;
		}
	}

	/**
	 * Gets the parent that contains both given controls.
	 * 
	 * @param control1
	 *            the first control
	 * @param control2
	 *            the second control
	 * @param children
	 *            the children for the next recursion
	 * @return true if same child found (needed control is then in children array)
	 */
	private boolean getBothParent(Control control1, Control control2, Control[] children) {
		if (control1 == control2) {
			return true;
		}
		children[0] = control1;
		children[1] = control2;
		try {
			return getBothParent(control1.getParent(), control2.getParent(), children);
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Saves the file.
	 */
	public void serialize() {
		if (module.getCanonicalName() == null || module.getCanonicalName().equals("")) {
			module.setCanonicalName(file.getName());
		}

		try {
			fileResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
