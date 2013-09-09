/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer.decorator;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;
import org.genesez.eclipse.workfloweditor.util.UIController;
import org.genesez.eclipse.workfloweditor.util.WorkfloweditorConstants;

/**
 * Basic class for decorator functionality. These decorators allow adding special functionality to the visual representation of
 * Features during runtime.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public abstract class AbstractFeatureDecorator implements IFeatureRenderer {

	/** the decoratedRenderer */
	protected IFeatureRenderer decoratedRenderer;

	/** the context to inject values from */
	@Inject
	protected IEclipseContext context;

	/** the controller that allows interacting with the model */
	@Inject
	protected UIController controller;

	/** the parent Composite */
	@Inject
	protected Composite parent;

	/** the Workbench needed for icons */
	@Inject
	protected IWorkbench workbench;

	/**
	 * Constructs a new Decorator
	 * 
	 * @param renderer
	 *            element to decorate
	 */
	public AbstractFeatureDecorator(IFeatureRenderer renderer) {
		this.decoratedRenderer = renderer;
	}

	@Override
	public boolean checkDefaultValue() {
		return decoratedRenderer.checkDefaultValue();
	}

	@Override
	public void setDefaultValue(Object value) {
		decoratedRenderer.setDefaultValue(value);
	}

	@Override
	public void setValue(Value value) {
		decoratedRenderer.setValue(value);
	}

	@Override
	public void removeValue() {
		decoratedRenderer.removeValue();
	}

	/**
	 * Starts the decorating. Listens on the context.
	 * 
	 * @param renderer
	 *            {@link WorkfloweditorConstants#DECORATED_RENDERER}
	 * @param composite
	 *            {@link WorkfloweditorConstants#DECORATED_COMPOSITE}
	 */
	@Inject
	protected void checkAndDecorate(@Optional @Named(WorkfloweditorConstants.DECORATED_RENDERER) IFeatureRenderer renderer,
			@Optional @Named(WorkfloweditorConstants.DECORATED_COMPOSITE) Composite composite) {
		if (decoratedRenderer.equals(renderer)) {
			if (composite != null && !composite.isDisposed()) {
				decorate(composite);
			}
		}
	}

	/**
	 * The decoration of the given Composite
	 * 
	 * @param composite
	 *            the composite to decorate
	 */
	protected abstract void decorate(Composite composite);

	/**
	 * gets the actual Renderer under the decorators
	 * 
	 * @return the actual renderer
	 */
	public IFeatureRenderer getRenderer() {
		if (decoratedRenderer instanceof AbstractFeatureDecorator) {
			return ((AbstractFeatureDecorator) decoratedRenderer).getRenderer();
		}
		return decoratedRenderer;
	}

	/**
	 * Injects the context to the decoratedRenderer
	 */
	@PostConstruct
	protected void initialize() {
		ContextInjectionFactory.inject(decoratedRenderer, context);
	}

	@Override
	public void dispose() {
		decoratedRenderer.dispose();
	}

}
