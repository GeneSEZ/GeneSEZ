package de.genesez.adapter.uml2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Utility class for UML to GeneSEZ transformation
 * 
 * @author	geobe
 * @author	nihe
 * @author	toh
 * @date	2007-06-11
 */
public class TransUtils {
	
	/**
	 * Getter for the xmi id of an element
	 * @param	pObj	an eobject
	 * @return	the xmi id
	 */
	public static String getXmiId (EObject pObj) {
		// note: pObj.eResource() can be null, if its unresolved proxy is (a type, defined within another model file)
		try {
			return ((XMLResource)pObj.eResource()).getID(pObj);
		} catch (NullPointerException npe) {
			return pObj.toString();
		}
	}
	
	/**
	 * Getter for a string representation of an object
	 * @param	eobj	an object
	 * @return	the string representation as list
	 */
	public static List<String> eToString(Object eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(eobj.toString());
		return retval;
	}
	
	/**
	 * Getter for a string representation of a list of objects
	 * @param	eobj	a list of objects
	 * @return	a list of string representations
	 */
	public static List<String> lToString(EDataTypeUniqueEList eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.addAll(eobj);
		return retval;
	}
}
