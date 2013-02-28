package org.genesez.platform.common.revisioncontrol;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1323946227169_261392_2731) 
 */

import java.util.HashSet;
/**
 * Helper class, that keeps all available RCS implementations in a list.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class RegisterHelper {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static java.util.Set<RevisionControlSystem> availableImpls = new HashSet<RevisionControlSystem>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Adds an repository implementation to the list
	 * @param	system	the revision control system to add
	 */
	
	public static void addRepositoryImpl(RevisionControlSystem system) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946357948_312805_2828) ENABLED START */
		availableImpls.add(system);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>availableImpls</b></em>'
	 */
	public static java.util.Set<RevisionControlSystem> getAvailableImpls() {
		return availableImpls;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1323946227169_261392_2731) ENABLED START */
	static {
		availableImpls.add(new GitImpl());
		availableImpls.add(new SubversionImpl());
	}
	/* PROTECTED REGION END */
	
}
