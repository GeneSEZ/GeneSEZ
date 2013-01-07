package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.genesez.eclipse.workfloweditor.ui.WrapDefault;
import org.genesez.eclipse.workfloweditor.ui.WrapDefault.ValueType;
import org.genesez.eclipse.workfloweditor.ui.WrapWorkflowComponent;

public class Renderer {
	public static WrapFeatureRenderer renderFeature(JvmExecutable feature, Component component, boolean adder) {
		String paramType = feature.getParameters().get(0).getParameterType().getType().getIdentifier();
		if (feature.getParameters().size() != 1 || paramType.equals("void")) {
			return null;
		}
		if (paramType.equals(boolean.class.getName()) || paramType.equals(Boolean.class.getName())) {
			return new WrapDefault(feature, component, adder, ValueType.BOOLEAN);
		} else if (paramType.equals(String.class.getName())) {
			return new WrapDefault(feature, component, adder, ValueType.STRING);
		} else {
			try {
				if (IWorkflowComponent.class.isAssignableFrom(Class.forName(paramType))) {
					return new WrapWorkflowComponent(feature, component, adder);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		return new WrapDefault(feature, component, adder, ValueType.COMPONENT);
	}
}
