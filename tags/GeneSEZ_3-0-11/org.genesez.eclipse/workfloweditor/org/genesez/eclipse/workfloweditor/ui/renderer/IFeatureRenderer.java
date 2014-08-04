/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.ui.renderer;

import org.eclipse.emf.mwe2.language.mwe2.Value;

/**
 * Basic Interface for the "Rendering Engine". Needed to graphically represent the JvmFeatures and Assignments.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public interface IFeatureRenderer {

	/**
	 * Checks if the default Value is used
	 * 
	 * @return true if default value is used
	 */
	public boolean checkDefaultValue();

	/**
	 * Sets the default Value.
	 * 
	 * @param value
	 *            the Value.
	 */
	public void setDefaultValue(Object value);

	/**
	 * Sets the current Value of the JvmFeature
	 * 
	 * @param value
	 *            the Value
	 */
	public void setValue(Value value);

	/**
	 * Removes the Value and its Assignment
	 */
	public void removeValue();

	/**
	 * Removes the value and disposes the graphical representation of the feature.
	 */
	public void dispose();
}
