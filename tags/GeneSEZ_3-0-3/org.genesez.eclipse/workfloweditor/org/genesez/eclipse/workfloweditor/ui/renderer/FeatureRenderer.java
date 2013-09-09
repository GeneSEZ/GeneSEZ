/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
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

/**
 * Renders the JvmFeatures and stores the shown modelelement.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public abstract class FeatureRenderer implements IFeatureRenderer {

	/** The stored Feature */
	protected final JvmFeature feature;
	/** The Component, that contains the feature */
	protected final Component component;
	/** The default Value */
	protected Object defaultValue;
	/** The value assigned to the feature */
	protected Value value;
	/** The complete assignment */
	protected Assignment assignment;
	/** The main Composite, that keeps the rendered elements */
	protected Composite composite;

	/** The Controller */
	@Inject
	protected UIController controller;

	/** The parent composite */
	@Inject
	protected Composite parent;

	/** The context to get values injecte from */
	@Inject
	protected IEclipseContext context;

	/**
	 * Constructs the feature
	 * 
	 * @param feature
	 *            The feature
	 * @param component
	 *            The component the contains the feature
	 */
	public FeatureRenderer(JvmFeature feature, Component component) {
		this.feature = feature;
		this.component = component;
	}

	/**
	 * Sets the Value, and creates Assignment if needed.
	 * 
	 * @param value
	 *            the Value
	 */
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

	/**
	 * Deletes the Value and removes the assignment.
	 */
	@Override
	public void removeValue() {
		this.value = null;
		controller.removeAssignment(component, assignment);
		this.assignment = null;
		changeValue();
	}

	/**
	 * Sets the DefaultValue.
	 * 
	 * @param value
	 *            can be anything, should be of the Type of the renderer.
	 */
	@Override
	public void setDefaultValue(Object value) {
		this.defaultValue = value;
	}

	/**
	 * creates the Element that can be decorated by decorators.
	 * 
	 * @param parent
	 *            the parent composite
	 * @return the decorated Composite.
	 */
	protected Composite createDecoratedElement(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		comp.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		context.set(WorkfloweditorConstants.DECORATED_RENDERER, null);
		context.set(WorkfloweditorConstants.DECORATED_COMPOSITE, comp);
		context.set(WorkfloweditorConstants.DECORATED_RENDERER, this);
		return comp;
	}

	/**
	 * Called after everything is injected. Creates a parent composite, passed to subclasses.
	 */
	@PostConstruct
	protected void renderElement() {
		composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		renderElement(composite);
	}

	/**
	 * Renders the Feature
	 * 
	 * @param composite
	 *            the parent composite
	 */
	protected abstract void renderElement(Composite composite);

	/**
	 * is called if the value changed
	 */
	protected abstract void changeValue();

	/**
	 * Removes the value and disposes the graphical representation of the feature.
	 */
	@Override
	public void dispose() {
		removeValue();
		if (composite != null) {
			composite.dispose();
		}
	}
}
