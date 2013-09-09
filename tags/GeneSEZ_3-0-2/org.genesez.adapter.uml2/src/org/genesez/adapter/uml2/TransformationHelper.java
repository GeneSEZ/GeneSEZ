package org.genesez.adapter.uml2;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Utility class for UML2 transformations.
 * 
 * @author Tobias Haubold <tobias.haubold@fh-zwickau.de> (maintainer)
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Georg Beier<georg.beier@fh-zwickau.de>
 */
public class TransformationHelper {
	
	/**
	 * Returns true if the specified UML2 model element is a proxy object, 
	 * i.e. an unresolved object, otherwise false.
	 * 
	 * @param	element		The UML2 model element.
	 * @return	True if the element is a proxy object, otherwise false.
	 */
	public static boolean isProxy(Element element) {
		return element.eIsProxy();
	}
	
	/**
	 * Returns the tagged value of an UML2 model element.
	 * 
	 * @param	element		The UML2 model element.
	 * @param	stereotype	The applied UML2 stereotype.
	 * @param	tag			The name of the tag.
	 * @return	The value of the tag.
	 */
	public static Object getTaggedValue(Element element, Stereotype stereotype, String tag) {
		return element.getValue(stereotype, tag);
	}
	
	/**
	 * Getter for the xmi id of an element
	 * @param	pObj	an eobject
	 * @return	the xmi id
	 */
	public static String getXmiId(EObject pObj) {
		// note: pObj.eResource() can be null, if its unresolved proxy is (a type, defined within another model file)
		try {
			return ((XMLResource)pObj.eResource()).getID(pObj);
		} catch (NullPointerException npe) {
			return null;
		}
	}
	
	/**
	 * Generates an unique id
	 * @return the unique id String
	 */
	public static String generateXmiId(EObject obj){
		return java.util.UUID.randomUUID().toString();
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
