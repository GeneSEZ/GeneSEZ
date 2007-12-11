/**
 * 
 */
package de.genesez.genesezmm;

import genesezMM.MClassifier;
import genesezMM.MPackage;

/**
 * @author dreamer
 *
 */
public class Conversion {
	
	/**
	 * getter for the package path of a classifier
	 * @param	clazz		a classifier
	 * @param	separator	a separator used for the package path
	 * @return	string representation of the package path
	 */
	public static String getPackagePath(MClassifier clazz, String separator) {
		StringBuffer p = new StringBuffer();
		for (MPackage pkg = clazz.getOwningPackage(); pkg != null; pkg = pkg.getNestingPackage()) {
			p.insert(0, pkg.getName());
			if (pkg.getNestingPackage() != null) {
				p.insert(0, separator);
			}
		}
		return p.toString();
	}
}
