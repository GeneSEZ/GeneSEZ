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

@SuppressWarnings("restriction")
public abstract class AbstractFeatureDecorator implements IFeatureRenderer {

	protected IFeatureRenderer decoratedRenderer;

	@Inject
	protected IEclipseContext context;

	@Inject
	protected UIController controller;

	@Inject
	protected Composite parent;

	@Inject
	protected IWorkbench workbench;

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

	@Inject
	protected void checkAndDecorate(@Optional @Named(WorkfloweditorConstants.DECORATED_RENDERER) IFeatureRenderer renderer,
			@Optional @Named(WorkfloweditorConstants.DECORATED_COMPOSITE) Composite composite) {
		if (decoratedRenderer.equals(renderer)) {
			if (composite != null && !composite.isDisposed()) {
				decorate(composite);
			}
		}
	}

	protected abstract void decorate(Composite composite);

	public IFeatureRenderer getRenderer() {
		if (decoratedRenderer instanceof AbstractFeatureDecorator) {
			return ((AbstractFeatureDecorator) decoratedRenderer).getRenderer();
		}
		return decoratedRenderer;
	}

	@PostConstruct
	protected void initialize() {
		ContextInjectionFactory.inject(decoratedRenderer, context);
	}

	public void dispose() {
		decoratedRenderer.dispose();
	}

}
