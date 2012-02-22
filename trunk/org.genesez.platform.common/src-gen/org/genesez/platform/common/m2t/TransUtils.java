package org.genesez.platform.common.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324550476875_530945_2868) 
 */

import java.util.List;

import org.genesez.platform.common.Conversion;
import org.genesez.platform.common.log.GenesezLogger;

import org.genesez.metamodel.gcore.MPackage;
import java.util.StringTokenizer;
import java.util.ArrayList;

/**
 * Utility class with helper functions for model to text (M2T) transformations
 * 
 * @author	toh
 * @date	2008-04-18
 */
public class TransUtils {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * removes all specified packages with full qualified name (package path) as a comma or semicolon separated string from the given list of packages.
	 * @param	packages	a list of packages to filter
	 * @param	ignoredPackages	comma or semicolon separated string with full qualified package names
	 * @return	the filtered list of packages
	 */
	public static java.util.List<MPackage> rejectIgnoredPackages(java.util.List<MPackage> packages, String ignoredPackages) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324550520759_732092_2902) ENABLED START */
		// init logging
		GenesezLogger.selectLogger("org.genesez.platform.common.m2t");
		// perform actions
		List<MPackage> toReturn = new ArrayList<MPackage>(packages);
		List<String> pkgs = getPackages(ignoredPackages);
		for (String s : pkgs) {
			GenesezLogger.debug("to reject: " + s);
			for (MPackage p : packages) {
				String fqn = Conversion.getFullQualifiedName(p, ".");
				GenesezLogger.debug("test to reject: " + fqn);
				if (s.equals(fqn)) {
					GenesezLogger.debug("reject: '" + s + "' == '" + fqn + "'");
					toReturn.remove(p);
				}
			}
		}
		return toReturn;
		/* PROTECTED REGION END */
	}
	
	/**
	 * splits a comma or semicolon separated string of values into a list
	 * @param	list	a string with comma or semicolon separated values
	 * @return	the list of values
	 */
	public static java.util.List<String> getPackages(String list) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324550725311_397026_2935) ENABLED START */
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(list, ",;");
		while (tokenizer.hasMoreTokens()) {
			//	cut leading + trailing spaces if separator was ', ' or '; '
			packages.add(tokenizer.nextToken().trim());
		}
		return packages;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324550476875_530945_2868) ENABLED START */
	/* PROTECTED REGION END */
	
}
