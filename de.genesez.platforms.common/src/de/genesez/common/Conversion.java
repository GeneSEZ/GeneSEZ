/**
 * 
 */
package de.genesez.common;

import genesezMM.MClassifier;
import genesezMM.MPackage;

/**
 * @author nihe
 * @author geobe
 * @author toh
 */
public class Conversion {
	
	/**
	 * getter for the full qualified name of a package
	 * @param	pkg			a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	full qualified name of the package
	 */
	public static String getFullQualifiedName(MPackage pkg, String separator) {
		StringBuffer fqn = new StringBuffer();
		for (MPackage p = pkg; p != null; p = p.getNestingPackage()) {
			fqn.insert(0, p.getName());
			if (p.getNestingPackage() != null) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
	}
	
	/**
	 * getter for the full qualified name of a classifier
	 * @param	classifier			a classifier
	 * @param	separator	a separator used for the full qualified name
	 * @return	full qualified name of the classifier
	 */
	public static String getFullQualifiedName(MClassifier classifier, String separator) {
		return getFullQualifiedName(classifier.getOwningPackage(), separator) + separator + classifier.getName();
	}
}
