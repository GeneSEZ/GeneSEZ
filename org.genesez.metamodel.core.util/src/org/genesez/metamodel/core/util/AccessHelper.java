package org.genesez.metamodel.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.metamodel.gcore.MClassifier;
import org.genesez.metamodel.gcore.MModel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.genesez.metamodel.gcore.MPackage;

/**
 * Utility class with some helper functions for accessing GeneSEZ models
 * 
 * note: it was not possible for me to get the list with owned packages from a
 * model in java MModel.getOwnedPackage() returns an empty list !!! why???
 * 
 * @author nihe
 * @author toh
 * @author geobe
 */
public class AccessHelper {
	
	private static Log logger = LogFactory.getLog(AccessHelper.class);
	
	/**
	 * Removes all specified packages by full qualified name (package path) as a comma or 
	 * semicolon separated string from the given list of packages.
	 * 
	 * @param	packages	a list of packages to filter
	 * @param	ignoredPackages	comma or semicolon separated string with full qualified package names
	 * @return	the filtered list of packages
	 */
	public static java.util.List<MPackage> rejectIgnoredPackages(java.util.List<MPackage> packages, String ignoredPackages) {
		// perform actions
		List<MPackage> toReturn = new ArrayList<MPackage>(packages);
		List<String> pkgs = getPackages(ignoredPackages);
		for (String s : pkgs) {
			logger.debug("to reject: " + s);
			for (MPackage p : packages) {
				String fqn = getFullQualifiedName(p, ".");
				logger.debug("test to reject: " + fqn);
				if (s.equals(fqn)) {
					logger.debug("reject: '" + s + "' == '" + fqn + "'");
					toReturn.remove(p);
				}
			}
		}
		return toReturn;
	}
	
	/**
	 * Splits a comma or semicolon separated string of values into a list.
	 * 
	 * @param	list	a string with comma or semicolon separated values
	 * @return	the list of values
	 */
	public static java.util.List<String> getPackages(String list) {
		List<String> packages = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(list, ",;");
		while (tokenizer.hasMoreTokens()) {
			//	cut leading + trailing spaces if separator was ', ' or '; '
			packages.add(tokenizer.nextToken().trim());
		}
		return packages;
	}
	
	/**
	 * Getter for the full qualified name of a package.
	 * 
	 * @param	pkg	a package
	 * @param	separator	a separator used for the full qualified name
	 * @return	the full qualified name of the package
	 */
	public static String getFullQualifiedName(MPackage pkg, String separator) {
		StringBuffer fqn = new StringBuffer();
		MPackage p = pkg;
		while (!(p instanceof MModel) && p != null) {
			fqn.insert(0, p.getName());
			p = p.getNestingPackage();
			if (!(p instanceof MModel) && p != null) {
				fqn.insert(0, separator);
			}
		}
		return fqn.toString();
	}
	
	/**
	 * getter for a classifier by it's full qualified name the full qualified name must start with a package in the specified list.
	 * 
	 * @throws Exception if the classifier is not found
	 * @param	packages	a list of packages
	 * @param	fullQualifiedName	a full qualified type name of a classifier
	 * @return	the classifier you specified
	 * @throws	Exception
	 */
	public static MClassifier getClassifier(java.util.List<MPackage> packages, String fullQualifiedName) throws Exception {
		int i = fullQualifiedName.lastIndexOf(".");
		if (i != -1) {
			String pkg = fullQualifiedName.substring(0, i);
			String clazz = fullQualifiedName.substring(i + 1);
			// IOExtensions.fine("fqn: " + fullQualifiedName + ", pkg: " + pkg +
			// ", clazz = " + clazz);
			MPackage p = getPackage(packages, pkg);
			for (Object o : p.getClassifier()) {
				if (o instanceof MClassifier) {
					MClassifier cls = (MClassifier) o;
					if (cls.getName().equals(clazz)) {
						return cls;
					}
				}
			}
		}
		throw new Exception("classifier not exist:" + fullQualifiedName);
	}
	
	/**
	 * getter for a package by it's full qualified name the full qualified name must start with a package in the specified list
	 * 
	 * @throws Exception if the package is not found
	 * @param	packages	a list of packages
	 * @param	fullQualifiedPackagePath	a full qualified package name
	 * @return	the package you specified
	 * @throws	Exception
	 */
	public static MPackage getPackage(java.util.List<MPackage> packages, String fullQualifiedPackagePath) throws Exception {
		// packages to search
		List<MPackage> subPackages = packages;
		// IOExtensions.fine("package count = " + subPackages.size());
		MPackage pSearchedFor = null;
		// check if a root package is specified
		if (containsPackage(subPackages, fullQualifiedPackagePath)) {
			return getPackage(subPackages, fullQualifiedPackagePath);
		}
		// no root package specified
		String packagePath = fullQualifiedPackagePath;
		// String packagePathFound = "";
		boolean found = false;
		while (!found) {
			MPackage mp = getNextPackage(subPackages, packagePath);
			if (mp == null) {
				throw new Exception("package not exist: " + fullQualifiedPackagePath);
			}
			// packagePathFound += mp.getName();
			subPackages = mp.getNestedPackage();
			if (packagePath.equals(mp.getName())) {
				found = true;
				pSearchedFor = mp;
			} else {
				packagePath = packagePath.substring(mp.getName().length() + 1);
			}
		}
		return pSearchedFor;
	}
	
	/**
	 * returns the package element specified as the first package in package path allows the possibility that a dot '.' is in the package name
	 * @param	subPackages	a list of packages
	 * @param	packagePath	a string containing a package path
	 * @return	the first package from the package path or null if not found
	 */
	private static MPackage getNextPackage(java.util.List<MPackage> subPackages, String packagePath) {
		// get name of first package in package path
		String pkgName = null;
		if (packagePath.indexOf('.') > -1) {
			pkgName = packagePath.substring(0, packagePath.indexOf('.'));
		} else {
			pkgName = packagePath;
		}
		// search package
		boolean found = false;
		while (!found) {
			// System.err.println("pkgName = " + pkgName + ", packagePath = " +
			// packagePath);
			if (containsPackage(subPackages, pkgName)) {
				// System.err.println("found!");
				found = true;
			} else {
				// System.err.println("not found");
				// no package found, maybe a dot ('.') in package name
				if (packagePath.indexOf('.', pkgName.length() + 1) > -1) {
					pkgName = packagePath.substring(0, packagePath.indexOf('.', pkgName.length() + 1));
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
	 * @param	pkgs	a list of packages
	 * @param	packageName	a package name
	 * @return	the package specified by name or null
	 */
	private static MPackage getPackageFromList(java.util.List<MPackage> pkgs, String packageName) {
		for (MPackage p : pkgs) {
			if (p.getName().equals(packageName)) {
				return p;
			}
		}
		return null;
	}
	
	/**
	 * determines if the package specified with the package name is in the given list of packages
	 * @param	pkgs	a list of packages
	 * @param	packageName	a name of a package
	 * @return	true if the package is contained in the list, otherwise false
	 */
	private static boolean containsPackage(java.util.List<MPackage> pkgs, String packageName) {
		for (MPackage p : pkgs) {
			// System.err.println("package = " + p.getName());
			if (p.getName().equals(packageName)) {
				return true;
			}
		}
		return false;
	}
}
