package de.genesez.platforms.common;

import de.genesez.metamodel.gcore.MModel;
import de.genesez.metamodel.gcore.MPackage;

/**
 * Utility class for Conversion of model informations
 * 
 * @author	nihe
 * @author	geobe
 * @author	toh
 * @date	2008-04-18
 */
public class Conversion {
	
	/**
	 * getter for the full qualified name of a package
	 * @param	pkg			a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	the full qualified name of the package
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
