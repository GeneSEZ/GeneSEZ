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
import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.util.UIController;

/**
 * Basic class to Render the Features with different behavior. For instance a JvmFeature setString(String) must be rendered other
 * than a JvmFeature addString(String). This class works as an interface between the different FeatureTypes and the actual
 * Renderer.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@SuppressWarnings("restriction")
public abstract class WrapFeatureRenderer implements IFeatureRenderer {

	/** the context to inject values from */
	@Inject
	protected IEclipseContext context;

	/** the workbench providing images */
	@Inject
	protected IWorkbench workbench;

	/** the parent Composite */
	@Inject
	protected Composite parent;

	/** the Controller to use the model */
	@Inject
	protected UIController controller;

	/** the feature to render */
	protected final JvmFeature feature;

	/** the component containing the feature */
	protected final Component component;

	/** true if the Feature is an adder */
	protected final boolean adder;

	/** the currently rendered Renderer with an instance of this class */
	protected IFeatureRenderer currentRenderer;

	/**
	 * Constructs a WrapFeatureRenderer
	 * 
	 * @param feature
	 *            the feature to store
	 * @param component
	 *            the component containing the feature
	 * @param adder
	 *            true if the Feature is an adder
	 */
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

	/**
	 * gives the currently rendered or used renderer.
	 * 
	 * @return the currentRenderer
	 */
	public IFeatureRenderer getActualRenderer() {
		return currentRenderer;
	}

	/**
	 * Creates the Controls after construction and injection.
	 */
	@PostConstruct
	public abstract void createControls();

	@Override
	public void dispose() {
	}
}
