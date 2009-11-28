/**
 * 
 */
package de.genesez.common;

import genesezMM.MClass;
import genesezMM.MClassifier;
import genesezMM.MPackage;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;

/**
 * Provides some helper functions for accessing the genesez model
 * 
 * note:
 * it was not possible for me to get the list with owned packages from a model in java
 * MModel.getOwnedPackage() returns an empty list !!! why???
 * 
 * @author nihe
 * @author geobe
 * @author toh
 */
public class AccessHelper {
	
	/**
	 * getter for the xmi id from an element
	 * @param	pObj	a model element
	 * @return	string representing the xmi id
	 */
	public static String getXmiId(EObject pObj) {
		return ((XMLResource) pObj.eResource()).getID(pObj);
	}
	
	/**
	 * returns the classifier specified with a full qualified name
	 * @param packages			list of root packages in a genesez model
	 * @param fullQualifiedName	full qualified type name from a classifier
	 * @return					the classifier you specified
	 * @throws Exception		if the classifier isn't found
	 */
	public static MClassifier getClassifier(List<MPackage> packages, String fullQualifiedName) throws Exception {
		int i = fullQualifiedName.lastIndexOf(".");
		if (i != -1) {
			String pkg = fullQualifiedName.substring(0, i);
			String clazz = fullQualifiedName.substring(i + 1);
//			System.err.println("fqn: " + fullQualifiedName + ", pkg: " + pkg + ", clazz = " + clazz);
			MPackage p = getPackage(packages, pkg);
			for (Object o : p.getClassifier()) {
				if (o instanceof MClassifier) {
					MClassifier cls = (MClassifier)o;
					if (cls.getName().equals(clazz)) {
						return cls;
					}
				}
			}
		}
		throw new Exception("classifier not exist:" + fullQualifiedName);
	}
	
	/**
	 * returns the package specified with a full qualified name
	 * 
	 * @param packages			list of root packages in a genesez model
	 * @param fullQualifiedPackagePath	full qualified package name
	 * @return					the package you specified
	 * @throws Exception		if the package isn't found in the model
	 */
	public static MPackage getPackage(List<MPackage> packages, String fullQualifiedPackagePath) throws Exception {
		//	packages to search
		List<MPackage> subPackages = packages;
//		System.err.println("package count = " + subPackages.size());
		MPackage pSearchedFor = null;
		//	check if a root package is specified
		if (containsPackage(subPackages, fullQualifiedPackagePath)) {
			return getPackage(subPackages, fullQualifiedPackagePath);
		}
		//	no root package specified
		String packagePath = fullQualifiedPackagePath;
//		String packagePathFound = "";
		boolean found = false;
		while (!found) {
//			System.err.println("MPackage.getPackage");
			MPackage mp = getNextPackage(subPackages, packagePath);
			if (mp == null) {
				throw new Exception("package not exist: " + fullQualifiedPackagePath);
			}
//			packagePathFound += mp.getName();
			subPackages = mp.getNestedPackage();
			if (packagePath.equals(mp.getName())) {
				found = true;
				pSearchedFor = mp;
			} else {
				packagePath = packagePath.substring(mp.getName().length() +1);
			}
		}
		return pSearchedFor;
	}
	
	
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
//	-- private methods --
//	- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	/**
	 * returns the package element specified as the first package in package path
	 * allows the possibility that a dot '.' is in the package name
	 * 
	 * @param subPackages	list of packages
	 * @param packagePath	string containing a package path
	 * @return				first package from the package path or null if not found
	 */
	private static MPackage getNextPackage(List<MPackage> subPackages, String packagePath) {
		//	get name of first package in package path
		String pkgName = null;
		if (packagePath.indexOf('.') > -1) {
			pkgName = packagePath.substring(0, packagePath.indexOf('.'));
		} else {
			pkgName = packagePath;
		}
		//	search package
		boolean found = false;
		while (!found) {
//			System.err.println("pkgName = " + pkgName + ", packagePath = " + packagePath);
			if (containsPackage(subPackages, pkgName)) {
//				System.err.println("found!");
				found = true;
			} else {
//				System.err.println("not found");
				//	no package found, maybe a dot ('.') in package name
				if (packagePath.indexOf('.', pkgName.length() +1) > -1) {
					pkgName = packagePath.substring(0, packagePath.indexOf('.', pkgName.length() +1));
				} else {
					// no more dot's in path
					return null;
				}
			}
		}
		return getPackageFromList(subPackages, pkgName);
	}
	
	
	/**
	 * returns the package from the list with the given package name
	 * 
	 * @param pkgs			list with packages
	 * @param packageName	package name
	 * @return				package element with package name
	 */
	private static MPackage getPackageFromList(List<MPackage> pkgs, String packageName) {
		for (MPackage p : pkgs) {
			if (p.getName().equals(packageName)) {
				return p;
			}
		}
		return null;
	}
	
	
	/**
	 * determines if the package specified with the package name is in 
	 * the given list of packages or not
	 * 
	 * @param pkgs			list of packages
	 * @param packageName	name of a package
	 * @return				package in list with the specified name
	 */
	private static boolean containsPackage(List<MPackage> pkgs, String packageName) {
		for (MPackage p : pkgs) {
//			System.err.println("package = " + p.getName());
			if (p.getName().equals(packageName)) {
				return true;
			}
		}
		return false;
	}
}
