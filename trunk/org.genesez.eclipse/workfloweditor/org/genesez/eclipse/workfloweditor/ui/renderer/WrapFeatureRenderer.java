package org.genesez.eclipse.workfloweditor.ui.renderer;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.util.UIController;

@SuppressWarnings("restriction")
public abstract class WrapFeatureRenderer implements IFeatureRenderer {

	@Inject
	protected IEclipseContext context;
	@Inject
	protected IWorkbench workbench;
	@Inject
	protected Composite parent;
	@Inject
	protected UIController controller;

	protected final JvmFeature feature;
	protected final Component component;
	protected final boolean adder;
	protected IFeatureRenderer currentRenderer;

	public WrapFeatureRenderer(JvmFeature feature, Component component, boolean adder) {
		this.feature = feature;
		this.component = component;
		this.adder = adder;
	}

	@Override
	public boolean checkDefaultValue() {
		return false;
	}

	@Override
	public void removeValue() {
	}

	@Override
	public void setDefaultValue(Object value) {
	}

	@Override
	public void setValue(Value value) {
	}

	public IFeatureRenderer getActualRenderer() {
		return currentRenderer;
	}

	@PostConstruct
	public abstract void createControls();

	@Override
	public void dispose() {
	}
}
