package de.genesez.uml2genesezmm.utilities;

import genesezMM.MClassifier;
import genesezMM.MPackage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Package;


/**
 * Helper Class for transformation uml2genesezMM. 
 * Methods are called from the functions in uml2genesezMM.ext
 * 
 * @author geobe
 * @author nicher
 * @author toh
 * 
 * 2007-08-23 toh - added possibility to exclude packages with a comma or semicolon separated list
 */
public class TransUtils {
	
	
	/**
	 * Return the xmi id form an element
	 * @param pObj
	 * @return
	 */
	public static String getXmiId (EObject pObj) {
		return ((XMLResource)pObj.eResource()).getID(pObj);
	}
	
	
	/**
	 * Return ecore.EJavaObject as list of String. 
	 * @param eobj
	 * @return
	 */
	public static List<String> eToString(Object eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.add(eobj.toString());
		return retval;
	}
	
	
	/**
	 * Return ecore.EJavaObject as list of String.
	 * @param eobj
	 * @return
	 */
	public static List<String> lToString(org.eclipse.emf.ecore.util.EDataTypeUniqueEList eobj) {
		ArrayList<String> retval = new ArrayList<String>();
		retval.addAll(eobj);
		return retval;
	}
	
	
	/**
	 * Return the package path from a class or other.
	 * @param clazz
	 * @return
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
	 * Return the full quality name package path from a class or other.
	 * @param clazz
	 * @return
	 */
	public static String getFQNPackagePath(MClassifier clazz) {
		return getPackagePath(clazz).replaceAll("\\.", "/");
	}
	

	/**
	 * Representation from the current timestamp.
	 * @return
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z").format(new Date());
	}
	
	
	/**
	 * Representation from the current user.
	 * @return
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}
	
	
	/**
	 * Filters a list of packages with a comma or semicolon separated list of package names.
	 * The package names can contain white space. The separation between the package names
	 * can also contain white space for better looking.
	 * 
	 * @param packages			a list with uml packages, found in a model
	 * @param excludePackages	comma or semicolon separated list with package names to exclude
	 * @return					given list with uml packages without the excluded packages
	 */
	public static List<Package> rejectExcludedPackages(List<Package> packages, String excludePackages) {
		// can't remove packages from the list while iterating over it, so store all packages to remove here
		List<Package> toRemove = new ArrayList<Package>();
		// note that some packages can contain the blank (' ') in their name!
		StringTokenizer st = new StringTokenizer(excludePackages, ",;");
		while (st.hasMoreTokens()) {
			String s = st.nextToken().trim();
			Iterator<Package> it = packages.iterator();
			while (it.hasNext()) {
				Package p = it.next();
				if (p.getName().equals(s)) {
					toRemove.add(p);
				}
			}
		}
		// remove all excluded packages
		List<Package> toReturn = new ArrayList<Package>(packages);
		toReturn.removeAll(toRemove);
		return toReturn;
	}
}
