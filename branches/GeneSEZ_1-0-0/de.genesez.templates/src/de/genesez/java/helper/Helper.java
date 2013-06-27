package de.genesez.java.helper;

import genesezMM.MClassifier;
import genesezMM.MPackage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;


public class Helper {

	/**
	 * return the xmi id from an element
	 * 
	 * @return string
	 */
	public static String getXmiId(EObject pObj) {
		return ((XMLResource) pObj.eResource()).getID(pObj);
	}


	/**
	 * return the package path from a class or other
	 * 
	 * @return string
	 */
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
	 * 
	 * @return string
	 */
	public static String getFQNPackagePath(MClassifier clazz) {
		return getPackagePath(clazz).replaceAll("\\.", "/");
	}

	
	/**
	 * getter for the current timestamp
	 * 
	 * @return string representation from the current timestamp
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z")
				.format(new Date());
	}

	
	/**
	 * getter for the current user who logged on
	 * 
	 * @return string representation from the current user
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}

	
}
