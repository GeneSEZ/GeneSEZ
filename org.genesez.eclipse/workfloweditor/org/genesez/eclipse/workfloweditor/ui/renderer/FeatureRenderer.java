package org.genesez.eclipse.workfloweditor.ui.renderer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.mwe2.language.mwe2.Assignment;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

@SuppressWarnings("restriction")
public abstract class FeatureRenderer implements IFeatureRenderer {

	protected final JvmFeature feature;
	protected final Component component;
	protected Object defaultValue;
	protected Value value;
	protected Assignment assignment;
	protected Composite composite;

	@Inject
	protected UIController controller;

	@Inject
	protected Composite parent;

	@Inject
	protected IEclipseContext context;

	public FeatureRenderer(JvmFeature feature, Component component) {
		this.feature = feature;
		this.component = component;
	}

	@Override
	public void setValue(Value value) {
		if (value.eContainer() instanceof Assignment) {
			this.value = value;
			this.assignment = (Assignment) value.eContainer();
		} else {
			this.value = value;
			this.assignment = controller.addAssignment(feature, value, component);
		}

		changeValue();
	}

	@Override
	public void removeValue() {
		this.value = null;
		controller.removeAssignment(component, assignment);
		this.assignment = null;
		changeValue();
	}

	@Override
	public void setDefaultValue(Object value) {
		this.defaultValue = value;
	}

	protected Composite createDecoratedElement(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		context.set(WorkfloweditorConstants.DECORATED_RENDERER, null);
		context.set(WorkfloweditorConstants.DECORATED_COMPOSITE, comp);
		context.set(WorkfloweditorConstants.DECORATED_RENDERER, this);
		return comp;
	}

	@PostConstruct
	protected void renderElement() {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		renderElement(composite);
	}

	protected abstract void renderElement(Composite composite);

	protected abstract void changeValue();

	@Override
	public void dispose() {
		removeValue();
		if (composite != null) {
			composite.dispose();
		}
	}
}
