package de.genesez.uml2ecore.utilities;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EcoreFactoryImpl;

/**
 * Helper Class whose single operation is called from the mapTypeName
 * extension in uml2ecore.ext
 */
public class TransUtils {

	/**
	 * JAVA extension functions must be static methods
	 * @param typeName the name of the UML primitive type to 
	 * 				   be mapped to Ecore 
	 * @return the EDataType object to which the type is mapped
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
