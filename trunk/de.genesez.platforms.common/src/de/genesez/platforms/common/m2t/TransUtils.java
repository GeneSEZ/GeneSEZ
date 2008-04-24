/**
 * 
 */
package de.genesez.platforms.common.m2t;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.genesez.metamodel.genesezMM.MPackage;
import de.genesez.platforms.common.Conversion;
import de.genesez.platforms.common.log.IOExtensions;

/**
 * Provides some utilities and helper functions for M2T transformations
 * 
 * @author toh
 */
public class TransUtils {
	
	/**
	 * removes all packages specified with full qualified name (package path) as a comma
	 * or semicolon separated string from the given list of packages.
	 * 
	 * @param packages			list of packages
	 * @param ignoredPackages	comma or semicolon separated string with full qualified package names
	 * @return					list of packages, without the ignored packages
	 */
	public static List<MPackage> rejectIgnoredPackages(List<MPackage> packages, String ignoredPackages) {
		List<MPackage> toReturn = new ArrayList<MPackage>(packages);
		List<String> pkgs = getPackages(ignoredPackages);
		for (String s : pkgs) {
			IOExtensions.fine("to reject: " + s);
			for (MPackage p : packages) {
				String fqn = Conversion.getFullQualifiedName(p, ".");
				IOExtensions.fine("test to reject: " + fqn);
				if (s.equals(fqn)) {
					IOExtensions.fine("reject: '" + s + "' == '" + fqn + "'");
					toReturn.remove(p);
				}
			}
		}
		return toReturn;
	}
	
	/**
	 * splits a comma or semicolon separated string of package names into
	 * a list of packages
	 * 
	 * @param packageList	string containing packages separated by comma or semicolon
	 * @return				list of packages in given string
	 */
	public static List<String> getPackages(String packageList) {
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(packageList, ",;");
		while (tokenizer.hasMoreTokens()) {
			//	cut leading + trailing spaces if separator was ', ' or '; '
			packages.add(tokenizer.nextToken().trim());
		}
		return packages;
	}
}
