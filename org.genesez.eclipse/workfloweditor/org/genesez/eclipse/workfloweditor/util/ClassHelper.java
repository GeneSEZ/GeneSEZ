/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.workfloweditor.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.mwe2.language.mwe2.Component;

/**
 * A helper class, that contains methods to get information about the class (such as inheritance and all fields and so on).
 * 
 * @deprecated due to using of the MWE2-Model, maybe some functionality is later needed again.
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
@Deprecated
@SuppressWarnings("rawtypes")
public class ClassHelper {

	/**
	 * Checks whether the given class is of the given supertype
	 * 
	 * @param clazz
	 *            the class
	 * @param supertype
	 *            the supertype
	 * @return true if class is a subclass from supertype
	 */
	public static boolean isSubtypeOf(Class clazz, Class supertype) {
		if (clazz.equals(Object.class)) {
			return false;
		}
		if (clazz.equals(supertype)) {
			return true;
		}
		for (Class interfaze : clazz.getInterfaces()) {
			return isSubtypeOf(interfaze, supertype);
		}
		if (clazz.getSuperclass() == null) {
			return false;
		}
		return isSubtypeOf(clazz.getSuperclass(), supertype);
	}

	/**
	 * Gets the Method of a Component.
	 * 
	 * @param simpleName
	 *            the name of the Method
	 * @param component
	 *            the Component to look up in
	 * @return the Method or null if not found
	 */
	public static Method getMethod(String simpleName, Component component) {
		Method toReturn = null;
		int endIndex = simpleName.indexOf("(");
		String toCheck = null;
		if (endIndex == -1) {
			toCheck = simpleName;
		} else {
			toCheck = simpleName.substring(0, endIndex);
		}
		Class clazz = null;
		try {
			clazz = Class.forName(component.getActualType().getIdentifier());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		boolean anotherCheck = false;
		for (Method m : clazz.getMethods()) {
			if (m.getName().equalsIgnoreCase(toCheck)) {
				if (toReturn != null && !Arrays.equals(m.getParameterTypes(), toReturn.getParameterTypes())) {
					anotherCheck = true;
					break;
				}
				toReturn = m;
			}
		}
		if (anotherCheck) {
			throw new UnsupportedOperationException();
		}
		return toReturn;
	}

	/**
	 * Gets a getter of a Field if present
	 * 
	 * @param field
	 *            the field to get the getter for
	 * @return the Method or null if not existent.
	 */
	public static Method getGetter(Field field) {
		try {
			return field.getDeclaringClass().getMethod("get" + parseFieldName(field.getName()));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the Setter of a field
	 * 
	 * @param field
	 *            the field to get the setter for
	 * @return the Method or null if not existent.
	 */
	public static Method getSetter(Field field) {
		try {
			return field.getDeclaringClass().getMethod("set" + parseFieldName(field.getName()), field.getType());
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the first parameter type of a Method
	 * 
	 * @param method
	 *            the Method to get parameter type from
	 * @return the parameter type.
	 */
	public static Class getParameterType(Method method) {
		return method.getParameterTypes()[0];
	}

	/**
	 * Gets a adder of a Field if present
	 * 
	 * @param field
	 *            the field to get the adder for
	 * @return the Method or null if not existent.
	 */
	public static Method getAdder(Field field) {
		try {
			for (Method method : field.getDeclaringClass().getMethods()) {
				if (method.getName().equals("add" + parseFieldName(field.getName()))) {
					return method;
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets a remover of a Field if present
	 * 
	 * @param field
	 *            the field to get the remover for
	 * @return the Method or null if not existent.
	 */
	public static Method getRemover(Field field) {
		try {
			for (Method method : field.getDeclaringClass().getMethods()) {
				if (method.getName().equals("remove" + parseFieldName(field.getName()))) {
					return method;
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets all Fields and inherited Fields of a given class.
	 * 
	 * @param clazz
	 *            the class that should be searched for fields
	 * @param checkedInterface
	 *            only implementing classes (and subclasses) will be checked for fields.
	 * @return a list of fields.
	 */
	public static List<Field> getAllFields(Class clazz, Class checkedInterface) {
		List<Class> classes = new ArrayList<Class>();
		while (!clazz.equals(Object.class)) {
			classes.add(clazz);
			clazz = clazz.getSuperclass();
		}
		if (checkedInterface != null) {
			for (int i = classes.size() - 1; i >= 0; i--) {
				Class[] interfaces = classes.get(i).getInterfaces();
				boolean hasInterface = false;
				for (Class interfaze : interfaces) {
					if (interfaze.equals(checkedInterface)) {
						hasInterface = true;
						break;
					}
				}
				if (hasInterface) {
					break;
				}
				classes.remove(i);
			}
		}
		List<Field> fields = new ArrayList<Field>();
		for (Class clazz_i : classes) {
			try {
				Collections.addAll(fields, clazz_i.getDeclaredFields());
			} catch (NoClassDefFoundError e) {
				continue;
			}
		}
		return fields;
	}

	/**
	 * Makes the first char upperCase for the given String
	 * 
	 * @param fieldName
	 *            the name of a field.
	 * @return
	 */
	private static String parseFieldName(String fieldName) {
		return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	private ClassHelper() {
	}
}
