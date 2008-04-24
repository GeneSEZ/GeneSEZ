/**
 * 
 */
package de.genesez.platforms.common;

import de.genesez.metamodel.genesezMM.MModel;
import de.genesez.metamodel.genesezMM.MPackage;

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
		MPackage p = pkg;
		while (!(p instanceof MModel)) {
			fqn.insert(0, p.getName());
			p = p.getNestingPackage();
			if (!(p instanceof MModel)) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
	}
}
