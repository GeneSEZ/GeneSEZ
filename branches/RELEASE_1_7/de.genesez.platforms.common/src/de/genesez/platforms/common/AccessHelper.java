package de.genesez.platforms.common;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MPackage;

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
	 * getter for a classifier by it's full qualified name
	 * the full qualified name must start with a package in the specified list
	 * @param	packages			a list of packages
	 * @param	fullQualifiedName	a full qualified type name of a classifier
	 * @return	the classifier you specified
	 * @throws	Exception			if the classifier is not found
	 */
	public static MClassifier getClassifier(List<MPackage> packages, String fullQualifiedName) throws Exception {
		int i = fullQualifiedName.lastIndexOf(".");
		if (i != -1) {
			String pkg = fullQualifiedName.substring(0, i);
			String clazz = fullQualifiedName.substring(i + 1);
//			IOExtensions.fine("fqn: " + fullQualifiedName + ", pkg: " + pkg + ", clazz = " + clazz);
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
	 * getter for a package by it's full qualified name
	 * the full qualified name must start with a package in the specified list
	 * @param	packages					a list of packages
	 * @param	fullQualifiedPackagePath	a full qualified package name
	 * @return	the package you specified
	 * @throws	Exception		if the package is not found
	 */
	public static MPackage getPackage(List<MPackage> packages, String fullQualifiedPackagePath) throws Exception {
		//	packages to search
		List<MPackage> subPackages = packages;
//		IOExtensions.fine("package count = " + subPackages.size());
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
	
/* - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 * private methods
 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
 */

	/**
	 * returns the package element specified as the first package in package path
	 * allows the possibility that a dot '.' is in the package name
	 * 
	 * @param	subPackages	a list of packages
	 * @param	packagePath	a string containing a package path
	 * @return	the first package from the package path or null if not found
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
	 * returns the package from a list with the given package name
	 * 
	 * @param	pkgs		a list of packages
	 * @param	packageName	a package name
	 * @return	the package specified by name or null
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
	 * the given list of packages
	 * 
	 * @param	pkgs		a list of packages
	 * @param	packageName	a name of a package
	 * @return	true if the package is contained in the list, otherwise false
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
