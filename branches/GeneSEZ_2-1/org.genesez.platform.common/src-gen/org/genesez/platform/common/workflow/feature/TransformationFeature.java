package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317372111753_604969_1771) 
 */

import java.util.Properties;

/**
 *  Provides Subclasses with setProperties and check method.
 *  
 *  @author Dominik Wetzel
 *  @date 2011-10-11
 */
public interface TransformationFeature {
	
	// -- generated method declarations -------------------------------------
	/**
	 * Sets the properties for the feature.
	 * @param	properties	the properties
	 */
	
	public void setProperties(Properties properties);
	
	/**
	 * Checks the configuration of the feature.
	 */
	
	public void checkConfiguration();
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_1_8e00291_1317372111753_604969_1771) ENABLED START */
	/* PROTECTED REGION END */
}
