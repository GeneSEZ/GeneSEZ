package de.genesez.adapter.uml2;

import org.eclipse.emf.ecore.EObject;

/**
 * Utility class with some helper functions for accessing GeneSEZ models
 * 
 * note:
 * it was not possible for me to get the list with owned packages from a model in java
 * MModel.getOwnedPackage() returns an empty list !!! why???
 * 
 * @author	nihe
 * @author	geobe
 * @author	toh
 * @date	2008-04-18
 */
public class AccessHelper {
	
	/**
	 * getter for the xmi id from an element
	 * @param	pObj	a model element
	 * @return	the xmi id
	 * @see		TransUtils#getXmiId(EObject)
	 */
	public static String getXmiId(EObject pObj) {
		return TransUtils.getXmiId(pObj);
	}
}
