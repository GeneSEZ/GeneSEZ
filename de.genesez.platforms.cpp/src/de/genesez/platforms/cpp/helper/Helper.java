package de.genesez.genesezmm.cpp.helper;

import genesezMM.MClassifier;
import genesezMM.MPackage;

public class Helper {

	public static String getPackagePath(MClassifier clazz, String delim) {
		StringBuffer p = new StringBuffer();
		for (MPackage pkg = clazz.getOwningPackage(); pkg != null; pkg = pkg.getNestingPackage()) {
			p.insert(0, pkg.getName());
			if (pkg.getNestingPackage() != null) {
				p.insert(0, delim);
			}
		}
		return p.toString();
	}
	
	public static String getFQNPackagePath(MClassifier clazz) {
		return getPackagePath(clazz, "/");
	}
	
	public static String getFQNamespace(MClassifier clazz) {
		return getPackagePath(clazz, "::");
	}
}
