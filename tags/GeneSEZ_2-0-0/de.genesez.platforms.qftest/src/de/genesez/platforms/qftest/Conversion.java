package de.genesez.platforms.qftest;

import de.genesez.testing.gtesting.TModel;
import de.genesez.testing.gtesting.TPackage;

public class Conversion {

	/**
	 * getter for the full qualified name of a package
	 * @param	pkg			a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	the full qualified name of the package
	 */
	public static String getFullQualifiedName(TPackage pkg, String separator) {
		StringBuffer fqn = new StringBuffer();
		TPackage p = pkg;
		while (!(p instanceof TModel)) {
			fqn.insert(0, p.getName());
			p = p.getNestingPackage();
			if (!(p instanceof TModel)) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
	}

}
