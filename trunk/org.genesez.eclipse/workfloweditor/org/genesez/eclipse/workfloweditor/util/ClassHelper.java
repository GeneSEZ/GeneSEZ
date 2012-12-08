package org.genesez.eclipse.workfloweditor.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("rawtypes")
public class ClassHelper {

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

	private static String parseFieldName(String fieldName) {
		return fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	private ClassHelper() {
	}
}
