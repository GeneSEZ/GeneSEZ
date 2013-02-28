package org.genesez.platform.common.m2m;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324550068108_147684_2772) 
 */

import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
/**
 * Utility class with some helper functions for model to model (M2M) transformations
 * 
 * @author	toh
 * @date	2007-10-25
 */
public class TransUtils {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * splits the full qualified package name (a package path) into a list of packages
	 * @param	fullQualifiedPackage	a package path
	 * @return	the list of packages names contained in package path
	 */
	public java.util.List<String> splitIntoPackages(String fullQualifiedPackage) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324550136520_509999_2802) ENABLED START */
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(fullQualifiedPackage, ".");
		while (tokenizer.hasMoreTokens()) {
			packages.add(tokenizer.nextToken());
		}
		return packages;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324550068108_147684_2772) ENABLED START */
	/* PROTECTED REGION END */
	
}
