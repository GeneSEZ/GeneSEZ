package de.genesez.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;

import codegenMm.MClass;
import codegenMm.MPackage;

public class TransUtils {
	public static String getXmiId (EObject pObj) {
		return ((XMLResource)pObj.eResource()).getID(pObj);
	}
	
	public static String getPackagePath(MClass clazz) {
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
	 * getter for the current timestamp
	 * @return	string representation from the current timestamp
	 */
	public static String getTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z").format(new Date());
	}
	
	/**
	 * getter for the current user who logged on
	 * @return	string representation from the current user
	 */
	public static String getUser() {
		return System.getProperty("user.name", "???");
	}
}
