package org.genesez.example.java.jsf.addressbook.generator;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.genesez.metamodel.gcore.MElement;
import org.genesez.metamodel.gcore.MModel;

public class GcoreAccessHelper {

//	/**
//	 * Getter for an EObject by it's URI. 
//	 * In case of an MElement the URI is normally the xmiGuid.
//	 * 
//	 * @param model the model where the object is placed
//	 * @param uri the URI of the object
//	 * @return the object where the URI is equals, otherwise null
//	 */
//	public static EObject getEObjectByUri(MModel model, String uri) {
//		EObject eObj;
//
//		try {
//			eObj = model.eResource().getEObject(uri);
//			if (eObj instanceof EObject)
//				return eObj;
//		} catch (WrappedException e) {
//		}
//		return null;
//	}
	
	/**
	 * Getter for an MElement by it's xmi guid.
	 * 
	 * @param model the model where the element is placed
	 * @param xmiGuid the xmi guid of the element
	 * @return the object where the xmi guid is equals, otherwise null
	 */
	public static MElement getMElement(MModel model, String xmiGuid) {
		TreeIterator<EObject> it;

		it = model.eAllContents();
		while (it.hasNext()) {
			EObject eObj = (EObject) it.next();
			if (eObj instanceof MElement && xmiGuid.equals(getXmiGuid(eObj))) {
				return (MElement) eObj;
			}
		}
		return null;
	}
	
	/**
	 * Getter for the xmi guid of an element.
	 * 
	 * Inside this function a type case from EObject to MElement is tryed. If
	 * the element is not an MElement then the string representation is
	 * returned.
	 * 
	 * @param eObj an eobject
	 * @return the xmi guid, if parameter eObj is an MElement, otherwise the
	 *         string representation of eObj
	 */
	private static String getXmiGuid(EObject eObj) {
		// note: if EObject is no MElement then there is no xmi guid.
		try {
			return ((MElement) eObj).getXmiGuid();
		} catch (ClassCastException cce) {
			return eObj.toString();
		}
	}
	
}
