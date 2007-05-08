package de.genesez.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;

public class TransUtils {
	public static String getXmiId (EObject pObj) {
		return ((XMLResource)pObj.eResource()).getID(pObj);
	}
}
