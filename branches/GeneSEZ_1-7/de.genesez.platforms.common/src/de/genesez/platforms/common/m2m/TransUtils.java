/**
 * utility classes for model 2 model (M2M) transformations
 */
package de.genesez.platforms.common.m2m;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Utility class with some helper functions for model to model (M2M) transformations
 * 
 * @author	toh
 * @date	2007-10-25
 */
public class TransUtils {
	
	/**
	 * splits the full qualified package name (a package path) into a list
	 * of packages
	 * 
	 * @param	fullQualifiedPackage	a package path
	 * @return	the list of packages names contained in package path
	 */
	public static List<String> splitIntoPackages(String fullQualifiedPackage) {
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(fullQualifiedPackage, ".");
		while (tokenizer.hasMoreTokens()) {
			packages.add(tokenizer.nextToken());
		}
		return packages;
	}	
}
