package de.genesez.uml2genesezmm.utilities;

import genesezMM.MClassifier;
import genesezMM.MPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.resource.UML22UMLExtendedMetaData;

public class TransUtils {
	
	// return the xmi id from an element
	public static String getXmiId (EObject pObj) {
		return ((XMLResource)pObj.eResource()).getID(pObj);
	}
	
	// return ecore.EJavaObject as list of String
	public static List<String> eToString(Object eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(eobj.toString());
		return retval;
	}
	
	// return ecore.EJavaObject as list of String
	public static List<String> lToString(org.eclipse.emf.ecore.util.EDataTypeUniqueEList eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.addAll(eobj);
		return retval;
	}
	
	
	/*public static List<String> eToString(org.eclipse.uml2.uml.TemplateSignature eObj) {
		List<String> retval = new ArrayList<String>();
		if (eObj != null) {
			Iterator<TemplateParameter> it = eObj.getParameters().iterator();
			while(it.hasNext()) {
				retval.add(((org.eclipse.uml2.uml.Class)it.next().getParameteredElement()).getName());
			}
		}
		return retval;
	}*/
	
	// return the package path from a class or other
	public static String getPackagePath(MClassifier clazz) {
		StringBuffer p = new StringBuffer();
		for (MPackage pkg = clazz.getOwningPackage(); pkg != null; pkg = pkg.getNestingPackage()) {
			p.insert(0, pkg.getName());
			if (pkg.getNestingPackage() != null) {
				p.insert(0, ".");
			}
		}
		return p.toString();
	}
	
	/**
	 * return the full quality name package path from a class or other
	 * @return string 
	 */
	public static String getFQNPackagePath(MClassifier clazz) {
		return getPackagePath(clazz).replaceAll("\\.", "/");
	}
	
	/**
	 * getter for the current timestamp
	 * @return	string representation from the current timestamp
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z").format(new Date());
	}
	
	/**
	 * getter for the current user who logged on
	 * @return	string representation from the current user
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}
}
