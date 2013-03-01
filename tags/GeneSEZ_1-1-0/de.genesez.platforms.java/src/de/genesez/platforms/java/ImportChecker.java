package de.genesez.platforms.java;

import genesezMM.MClassifier;
import genesezMM.MOperation;
import genesezMM.MParameter;
import genesezMM.MProperty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.genesez.common.Conversion;

/**
 * @author dreamer
 */
public class ImportChecker {

	private static Set<String> imports = new HashSet<String>();

	private static String ownFQN;

	public static String getImports(MClassifier clazz) {
		// initizial import routine
		init(clazz);
		
		// checks Imports
		checkSupertypes(clazz);
		checkProperties(clazz);
		checkOperations(clazz);
		
		// returns the generated import string
		return getImportString();

	}
	

	private static void checkSupertypes(MClassifier clazz) {
		Iterator it = clazz.getSupertype().iterator();
		MClassifier c;
		while (it.hasNext()) {
			c = (MClassifier)it.next();
			insertInImports(c);
		}
	}
	
	private static void checkProperties(MClassifier clazz) {
		Iterator it = clazz.getProperty().iterator();
		MProperty p;

		while (it.hasNext()) {
			p = (MProperty) it.next();
			//insertInImports(p.getType());
		}
	}
	
	private static void checkOperations(MClassifier clazz) {
		Iterator it = clazz.getOperation().iterator();
		MOperation op;
		
		while (it.hasNext()) {
			op = (MOperation) it.next();
			//insertInImports(op.getReturnType());
			checkParameter(op);
		}
	}
	
	private static void checkParameter(MOperation op) {
		Iterator it = op.getParameter().iterator();
		MParameter pa;
		
		while (it.hasNext()) {
			pa = (MParameter) it.next();
			//insertInImports(pa.getType());
		}
	}

	// //////////////////////////////////////////////////////////////////////////////
	// private helper functions
	// //////////////////////////////////////////////////////////////////////////////

	
	private static void init(MClassifier clazz) {
		// clear the old imports
		imports.clear();

		// save the own package path
		ownFQN = getFQN(clazz);

	}

	private static String getImportString() {
		String str = "";
		Iterator<String> it = imports.iterator();
		while (it.hasNext()) {
			str += it.next() + "\n";
		}

		return str;
	}

	private static void insertInImports(MClassifier clazz) {
		if (checkClassifier(clazz) && !ownFQN.equals(getFQN(clazz))) {
			imports.add(getJavaImportString(clazz));
		}
	}

	private static String getJavaImportString(MClassifier clazz) {
		return "import " + getFQN(clazz).replace("/", ".") + "."
				+ getName(clazz) + ";";
	}

	private static String getFQN(MClassifier clazz) {
		return Conversion.getFullQualifiedName(clazz, ".").trim();
	}

	private static String getName(MClassifier clazz) {
		return clazz.getName().trim();
	}

	private static boolean checkClassifier(MClassifier clazz) {
		String type = clazz.eClass().getName();
		if (type == "MInterface" || type == "MClass") {
			return true;
		} else {
			return false;
		}
	}

}
