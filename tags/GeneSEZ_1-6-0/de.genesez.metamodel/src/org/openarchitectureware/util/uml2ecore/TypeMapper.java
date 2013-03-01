package org.openarchitectureware.util.uml2ecore;

import org.eclipse.emf.ecore.EcorePackage;

/**
 * Helper Class whose single operation is called from the mapTypeName
 * extension in uml2ecore.ext
 */
public class TypeMapper {

	/**
	 * JAVA extension functions must be static methods
	 * @param typeName the name of the UML primitive type to 
	 * 				   be mapped to Ecore 
	 * @return the EDataType object to which the type is mapped
	 */
	public static Object mapType(String typeName) {
		if (typeName == null ) return null;
		EcorePackage pack = EcorePackage.eINSTANCE;
		if ( typeName.equals("String") ) return pack.getEString();
		if ( typeName.equals("int") ) return pack.getEInt();
		if ( typeName.equals("Integer") ) return pack.getEInt();
		if ( typeName.equals("boolean") ) return pack.getEBoolean();
		if ( typeName.equals("Boolean") ) return pack.getEBoolean();
		if ( typeName.equals("byte") ) return pack.getEByte();
		if ( typeName.equals("char") ) return pack.getEChar();
		if ( typeName.equals("double") ) return pack.getEDouble();
		if ( typeName.equals("float") ) return pack.getEFloat();
		if ( typeName.equals("long") ) return pack.getELong();
		if ( typeName.equals("short") ) return pack.getEShort();
		return null;
	}
	
}
