package de.genesez.adapter.uml2;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

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
	 * Returns the tagged value of an uml model element
	 * @param e		the uml model element
	 * @param s		the applied uml stereotype
	 * @param tag	the name of the tag
	 * @return		the value of the tag
	 */
	public static Object getTaggedValue(Element e, Stereotype s, String tag) {
		return e.getValue(s, tag);
	}
	
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
