/**
 * common transformation utilities for model to text transformations
 */
package de.genesez.platforms.common.m2t;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.genesez.metamodel.gcore.MPackage;
import de.genesez.platforms.common.Conversion;
import de.genesez.platforms.common.log.GenesezLogger;

/**
 * Utility class with helper functions for model to text (M2T) transformations
 * 
 * @author	toh
 * @date	2008-04-18
 */
public class TransUtils {
	
	/**
	 * removes all specified packages with full qualified name (package path) as a comma
	 * or semicolon separated string from the given list of packages.
	 * 
	 * @param packages			a list of packages to filter
	 * @param ignoredPackages	comma or semicolon separated string with full qualified package names
	 * @return					the filtered list of packages
	 */
	public static List<MPackage> rejectIgnoredPackages(List<MPackage> packages, String ignoredPackages) {
		// init logging
		GenesezLogger.selectLogger("de.genesez.platforms.common.m2t");
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
	}
	
	/**
	 * splits a comma or semicolon separated string of values into a list
	 * 
	 * @param	list	a string with comma or semicolon separated values
	 * @return	the list of values
	 */
	public static List<String> getPackages(String list) {
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(list, ",;");
		while (tokenizer.hasMoreTokens()) {
			//	cut leading + trailing spaces if separator was ', ' or '; '
			packages.add(tokenizer.nextToken().trim());
		}
		return packages;
	}
}
