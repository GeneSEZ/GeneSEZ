/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Component;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowComponent;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.genesez.eclipse.workfloweditor.ui.renderer.WrapDefault.ValueType;

/**
 * Helper class, to insert Features in the "Rendering Engine"
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class Renderer {

	/**
	 * Distinguishes between the different IFeatureRenderers, dependend on the JvmExecutables Parametertype
	 * 
	 * @param feature
	 *            the JvmExecutable to render
	 * @param component
	 *            the component that contains the JvmExecutable
	 * @param adder
	 *            true if its an Adder
	 * @return the chosen WrapFeatureRenderer
	 */
	public static WrapFeatureRenderer renderFeature(JvmExecutable feature, Component component, boolean adder) {
		JvmType paramType = feature.getParameters().get(0).getParameterType().getType();
		String paramString = paramType.getIdentifier();
		if (paramType instanceof JvmTypeParameter) {
			// gets the Meaning of the TypeParameter (for instance: T -> WorkflowComponent)
			paramString = ((JvmTypeParameter) paramType).getConstraints().get(0).getTypeReference().getType().getIdentifier();
		}
		if (feature.getParameters().size() != 1 || paramString.equals("void")) {
			return null;
		}
		if (paramString.equals(boolean.class.getName()) || paramString.equals(Boolean.class.getName())) {
			return new WrapDefault(feature, component, adder, ValueType.BOOLEAN);
		} else if (paramString.equals(String.class.getName())) {
			return new WrapDefault(feature, component, adder, ValueType.STRING);
		} else {
			try {
				if (IWorkflowComponent.class.isAssignableFrom(Class.forName(paramString))) {
					return new WrapWorkflowComponent(feature, component, adder);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(e);
			}
		}
		return new WrapDefault(feature, component, adder, ValueType.COMPONENT);
	}
}
