/**
 * 
 */
package de.genesez.common.m2t;

import genesezMM.MPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
		List<MPackage> toReturn = new ArrayList<MPackage>();
		List<String> pkgs = getPackages(ignoredPackages);
		for (MPackage p : packages) {
			String fqn = getFullQualifiedName(p);
			for (String s : pkgs) {
				if (!s.equals(fqn)) {
//					System.err.println("--> reject: '" + s + "' != '" + fqn + "'");
					toReturn.add(p);
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
	
	/**
	 * returns the full qualified name of the given package
	 * 
	 * @param pkg	a package
	 * @return		full qualified name of the given package (package path)
	 */
	private static String getFullQualifiedName(MPackage pkg) {
		StringBuffer fqn = new StringBuffer();
		for (MPackage p = pkg; p != null; p = p.getNestingPackage()) {
			fqn.insert(0, p.getName());
			if (p.getNestingPackage() != null) {
				fqn.insert(0, ".");
			}
		}
		return fqn.toString();
	}
}
