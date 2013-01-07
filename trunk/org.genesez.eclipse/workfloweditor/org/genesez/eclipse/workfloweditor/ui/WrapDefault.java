package org.genesez.eclipse.workfloweditor.ui;

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
import org.genesez.eclipse.workfloweditor.ui.renderer.BooleanValueRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.ComponentRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.IFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.StringValueRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapFeatureRenderer;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.AddDecorator;
import org.genesez.eclipse.workfloweditor.ui.renderer.decorator.SetDecorator;

public class WrapDefault extends WrapFeatureRenderer {

	public enum ValueType {
		BOOLEAN, STRING, COMPONENT;
	}

	private ValueType type;
	private Group group;
	private Image addImage;

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
