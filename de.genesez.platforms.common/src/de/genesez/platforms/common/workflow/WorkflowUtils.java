package de.genesez.platforms.common.workflow;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

/**
 * Helper class for other workflow components
 * 
 * @author 	Aibek Isaev
 * @author 	Beishen
 * @author 	Nico Herbig <nico.herbig@genesez.org>
 * @date 	2011-04-13
 */
public class WorkflowUtils {

	public static final Properties defaults = new Properties();
	static {
		defaults.put("slot", "coremodel");
		defaults.put("coreSlot", "coremodel");
		defaults.put("reqSlot", "reqmodel");
		defaults.put("traceSlot", "tracemodel");
		defaults.put("gcorePackage", "de.genesez.metamodel.gcore.GcorePackage");
		defaults.put("greqPackage", "de.genesez.metamodel.greq.GreqPackage");
		defaults.put("gtracePackage", "de.genesez.metamodel.gtrace.GtracePackage");
	}

	/**
	 * Method for create GlobalVarDef
	 * 
	 * @param name
	 *            GlobalVarDef's name
	 * @param value
	 *            GlobalVarDef's value. Type is String
	 * @return GLobalVarDef's object
	 */
	public static GlobalVarDef createGlobalVarDef(String name, String value) {
		GlobalVarDef GVD = new GlobalVarDef();
		GVD.setName(name);
		GVD.setValue(value);
		return GVD;
	}

	/**
	 * Method for create GlobalVarDef
	 * 
	 * @param name
	 *            GlobalVarDef's name
	 * @param value
	 *            GlobalVarDef's value. Type is boolean
	 * @return GLobalVarDef's object
	 */
	public static GlobalVarDef createGlobalVarDef(String name, boolean value) {
		GlobalVarDef GVD = new GlobalVarDef();
		GVD.setName(name);
		GVD.setValue(Boolean.toString(value));
		return GVD;
	}

	/**
	 * splits a comma or semicolon separated list into a list an trims the
	 * values
	 * 
	 * @param list
	 *            a comma or semicolon separated list
	 * @return a list of strings
	 */
	public static List<String> split(String list) {
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(list, ",;");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result.add(token.trim());
		}
		return result;
	}

	/**
	 * Convert from Array to String
	 * 
	 * @param name
	 *            of List<String>
	 * @return String
	 */
	public static String arrayToString(List<String> name) {
		StringBuffer s = new StringBuffer();
		Iterator<String> it = name.iterator();
		while (it.hasNext()) {
			s.append(it.next());
		}
		return s.toString();
	}

	public static void setDefaultProperties(Object workflowComponent, Properties defaults) {
		String property;
		String value;
		Method invokeMethod;

		for (Object keyObj : defaults.keySet()) {
			property = String.valueOf(keyObj);
			value = defaults.getProperty(property);

			try {
				invokeMethod = getPropertyAccessorMethod(workflowComponent, property);
				invokeMethod.invoke(workflowComponent, value);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}

	private static Method getPropertyAccessorMethod(Object workflowComponent, String property) throws Throwable {
		String methodName;
		Method method;

		methodName = property.substring(0, 1).toUpperCase() + property.substring(1);

		// Trying to get the setter method of property
		try {
			method = workflowComponent.getClass().getMethod("set" + methodName, String.class);
		} catch (Throwable e) {

			// If there is no setter, trying to get the adder method of property
			try {
				method = workflowComponent.getClass().getMethod("add" + methodName, String.class);
			} catch (Throwable e1) {
				throw new Throwable("Could not find set or add method for property: " + property);
			}
		}
		return method;
	}

}