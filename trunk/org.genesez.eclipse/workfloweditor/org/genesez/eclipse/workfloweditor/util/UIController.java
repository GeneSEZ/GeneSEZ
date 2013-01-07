package org.genesez.eclipse.workfloweditor.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public void setHeadComposite(Composite composite) {
		this.headComposite = composite;
	}

	public void setDirty(boolean dirty) {
		editor.setDirty(dirty);
	}

	public String getFileName() {
		return file.getName();
	}

	public Module getModule() {
		return module;
	}

	public Component getRootComponent() {
		return root;
	}

	public JvmDeclaredType getType(Class<?> clazz) {
		return (JvmDeclaredType) typeProvider.findTypeByName(clazz.getName());
	}

	public JvmOperation getSpecificOperation(JvmDeclaredType type, final String methodName, final String... params) {

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
	}

	public void injectChildContext(Composite parent, IEclipseContext parentContext, Object toInject) {
		IEclipseContext context = parentContext.createChild();
		context.set(Composite.class, parent);
		ContextInjectionFactory.inject(toInject, context);
	}

	private void showAssignments(Component component, Composite parent) {
		for (Assignment assignment : component.getAssignment()) {
			renderAssignment(component, assignment);
		}
	}

	public WrapFeatureRenderer renderAssignment(Component component, Assignment assignment) {
		WrapFeatureRenderer renderer = components.get(component).get(assignment.getFeature());
		if (renderer != null) {
			renderer.setValue(assignment.getValue());
		}
		return renderer;
	}

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
		showAssignments(component, parent);
		refreshView();
	}

	private Boolean isAdder(JvmFeature feature) {
		if (feature instanceof JvmExecutable && feature.getVisibility().equals(JvmVisibility.PUBLIC)) {
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

	public Assignment addAssignment(JvmFeature feature, Value value, Component toAdd) {
		Assignment a = mwe2Factory.createAssignment();
		a.setFeature(feature);
		a.setValue(value);
		toAdd.getAssignment().add(a);
		setDirty(true);
		return a;
	}

	public void removeAssignment(Component removeFrom, Assignment assignment) {
		removeFrom.getAssignment().remove(assignment);
		setDirty(true);
	}

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

	public void refreshView() {
		if (headComposite != null && !headComposite.isDisposed()) {
			headComposite.notifyListeners(SWT.Resize, new Event());
		}
	}

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

	private void moveAssignments(int first, int second, Assignment assignment, List<Assignment> assignments) {
		assignments.remove(first);
		if (first < second) {
			assignments.add(second - 1, assignment);
		} else {
			assignments.add(second, assignment);
		}
	}

	private int getPositionInAssignments(List<Assignment> list, Assignment assignment) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(assignment)) {
				return i;
			}
		}
		return -1;
	}

	public void reorderChildren(WorkflowComponentRenderer toOrder, Control clickedControl) {
		Group group = toOrder.getGroup();
		Label label = toOrder.getPrecedingDragTarget();
		if (toOrder != null && !group.isDisposed() && clickedControl != label) {
			Control[] childs = new Control[2];
			getBothParent(label, clickedControl, childs);
			if (clickedControl != null) {
				childs[0].moveAbove(childs[1]);
			}
		}
	}

	private Control getBothParent(Control control1, Control control2, Control[] childs) {
		if (control1 == control2) {
			return control1;
		}
		childs[0] = control1;
		childs[1] = control2;
		return getBothParent(control1.getParent(), control2.getParent(), childs);
	}

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
