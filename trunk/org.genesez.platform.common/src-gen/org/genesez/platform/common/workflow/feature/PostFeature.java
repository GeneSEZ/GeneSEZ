package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317994210426_641555_2699) 
 */

import org.genesez.platform.common.NotPreparedException;

/**
 * Implementations of this interface can be added to the Generator. It does something after the generation.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public interface PostFeature extends TransformationFeature {
	
	// -- generated method declarations -------------------------------------
	/**
	 * Is called after generation.
	 * @throws NotPreparedException if not prepared properly.
	 */
	
	public void invokePost() throws NotPreparedException;
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_1_8e00291_1317994210426_641555_2699) ENABLED START */
	/* PROTECTED REGION END */
}
