/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import javax.annotation.PostConstruct;

import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.language.mwe2.Value;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.ISharedImages;
import org.eclipse.xtext.common.types.JvmFeature;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.AddDecorator;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.SetDecorator;

/**
 * Wrapper for Boolean, String and Component Values. Works as interface between the different FeatureTypes (adder, setter,
 * boolean, string, component) and the FeatureRenderern.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class WrapDefault extends WrapFeatureRenderer {

	/**
	 * Enumeration for the ValueTypes.
	 * 
	 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
	 * 
	 */
	public enum ValueType {
		BOOLEAN, STRING, COMPONENT;
	}

	private ValueType type;
	private Group group;
	private Image addImage;

	/**
	 * Constructs the Wrapper
	 * 
	 * @param feature
	 *            the Feature
	 * @param component
	 *            the Component containing the feature
	 * @param adder
	 *            if its an adder
	 * @param type
	 *            the parameter type (ValueType)
	 */
	public WrapDefault(JvmFeature feature, Component component, boolean adder, ValueType type) {
		super(feature, component, adder);
		this.type = type;
	}

	@Override
	public boolean checkDefaultValue() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDefaultValue(Object value) {
	}

	@Override
	public void setValue(Value value) {
		if (adder) {
			currentRenderer = renderElement();
			controller.injectChildContext(group, context, currentRenderer);
		}
		currentRenderer.setValue(value);
	}

	@Override
	public void removeValue() {
		// TODO Auto-generated method stub

	}

	/**
	 * Creates the Controls. If its an Adder a surrounding Group will be created, else the Feature will be directly rendered.
	 */
	@Override
	@PostConstruct
	public void createControls() {
		if (adder) {
			group = new Group(parent, SWT.BORDER | SWT.SHADOW_NONE);
			group.setLayout(new GridLayout());
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
			group.setText(feature.getSimpleName().substring(3));
			Button button = new Button(group, SWT.PUSH);
			button.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
			if (workbench != null) {
				addImage = workbench.getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
				button.setImage(addImage);
			} else {
				button.setText("+");
			}
		} else {
			currentRenderer = renderElement();
			controller.injectChildContext(parent, context, currentRenderer);
		}
	}

	/**
	 * Renders the element depending on "adder". If its adder = true an {@link AddDecorator}, if its false a {@link SetDecorator}
	 * and the appropriate {@link FeatureRenderer} will be created.
	 * 
	 * @return the chosen IFeatureRenderer
	 */
	protected IFeatureRenderer renderElement() {
		if (adder) {
			switch (type) {
			case BOOLEAN:
				return new AddDecorator(new BooleanValueRenderer(feature, component));
			case STRING:
				return new AddDecorator(new StringValueRenderer(feature, component));
			case COMPONENT:
				return new AddDecorator(new ComponentRenderer(feature, component));
			default:
				return null;
			}
		} else {
			switch (type) {
			case BOOLEAN:
				return new SetDecorator(new BooleanValueRenderer(feature, component));
			case STRING:
				return new SetDecorator(new StringValueRenderer(feature, component));
			case COMPONENT:
				return new SetDecorator(new ComponentRenderer(feature, component));
			default:
				return null;
			}
		}
	}
}
