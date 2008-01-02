package de.genesez.uml2ecore.utilities;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;

/**
 * Helper Class for transformation uml2ecore. 
 * Methods are called from the functions in uml2ecore.ext
 * 
 * @author geobe, nicher
 */

public class TransUtils {

	/**
	 * Map the uml primitiv type to an ecore type.
	 * 
	 * @param typeName
	 * @return
	 */
	public static Object mapType(String typeName) {
		if (typeName == null ) return null;
		EcorePackage pack = EcoreFactoryImpl.getPackage();
		if ( typeName.equals("String") ) return pack.getEString();
		if ( typeName.equals("int") ) return pack.getEInt();
		if ( typeName.equals("Integer") ) return pack.getEInt();
		if ( typeName.equals("boolean") ) return pack.getEBoolean();
		if ( typeName.equals("Boolean") ) return pack.getEBoolean();
		return null;
	}
	
}
