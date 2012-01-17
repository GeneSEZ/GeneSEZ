package de.genesez.platforms.common.workflow;

import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

/**
 * Helper class for other workflow components.
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-19
 */
public final class WorkflowUtils {
	
	/**
	 * Method to create a GlobalVarDef.
	 * 
	 * @param key The name of the GlobalVarDef.
	 * @param value The value of the GlobalVarDef.
	 * @return A GLobalVarDef object.
	 */
	public static GlobalVarDef createGlobalVarDef(String key, String value) {
		GlobalVarDef gVD = new GlobalVarDef();
		gVD.setName(key);
		gVD.setValue(value);
		return gVD;
	}
	
	/**
	 * Method to create a GlobalVarDef.
	 * 
	 * @param key The name of the GlobalVarDef.
	 * @param value The value of the GlobalVarDef.
	 * @return A GLobalVarDef object.
	 */
	public static GlobalVarDef createGlobalVarDef(String name, boolean value) {
		GlobalVarDef GVD = new GlobalVarDef();
		GVD.setName(name);
		GVD.setValue(Boolean.toString(value));
		return GVD;
	}
	
	/**
	 * Checks if the specified value can be parsed to a number.
	 * 
	 * @param s The value to check if it is a number.
	 * @return True if the specified value is a number, otherwise false.
	 */
	public static boolean isNumber(String s) {
		try {
			NumberFormat.getIntegerInstance().parse(s);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	/**
	 * Checks if the specified value can be parsed to a boolean.
	 * 
	 * @param s The value to check if it is a boolean.
	 * @return True if the specified value is a boolean, otherwise false.
	 */
	public static boolean isBoolean(String s) {
		return "true".equals(s) || "false".equals(s);
	}
	
	/**
	 * Converts a comma or semicolon separated string into a list an trims the
	 * values.
	 * 
	 * @param str A comma or semicolon separated string.
	 * @return A list of strings.
	 */
	public static List<String> split(String str) {
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, ",;");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result.add(token.trim());
		}
		return result;
	}
	
	/**
	 * Converts a list into a string.
	 * 
	 * @param list A List of strings.
	 * @return A string.
	 */
	public static String arrayToString(List<String> list) {
		StringBuffer s = new StringBuffer();
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			s.append(it.next());
			if(it.hasNext()){
				s.append(",");
			}
		}
		return s.toString();
	}
	
	/**
	 * Trying to call the accessor methods for for a list of workflow component
	 * properties. For instance if the property name is <em><b>slot</b></em>, it
	 * tries to call <em><b>public void setSlot(String slot)</b></em>. If this
	 * method is not found, it tries to call
	 * <em><b>public void addSlot(String slot)</b></em>, otherwise it tries to
	 * call
	 * <em><b>public void put(Object propertyName, Object propertyValue)</b></em>
	 * .
	 * 
	 * @param workflowComponent The workflow component where the accessor
	 *        methods are defined.
	 * @param defaults The properties to set.
	 */
	public static void callPropertyAccessors(Object workflowComponent, Properties defaults) {
		String keyStr;
		String valueStr;
		String methodName;
		Method invokeMethod;
		
		for (Object keyObj : defaults.keySet()) {
			keyStr = String.valueOf(keyObj);
			valueStr = defaults.getProperty(keyStr);
			
			// convert property to method name (to first upper)
			methodName = convertToFirstUpper(keyStr);
			
			try {
				if (hasMethod(workflowComponent, "set" + methodName, String.class)) {
					// Trying to get the setter method of property
					invokeMethod = getMethod(workflowComponent, "set" + methodName, String.class);
					invokeMethod.invoke(workflowComponent, valueStr);
				} else if (hasMethod(workflowComponent, "add" + methodName, String.class)) {
					// Trying to get the adder method of property
					invokeMethod = getMethod(workflowComponent, "add" + methodName, String.class);
					invokeMethod.invoke(workflowComponent, valueStr);
				} else if (hasMethod(workflowComponent, "put", Object.class, Object.class)) {
					// Trying to get the put method
					invokeMethod = getMethod(workflowComponent, "put", Object.class, Object.class);
					invokeMethod.invoke(workflowComponent, keyStr, valueStr);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
		}
	}
	
	/**
	 * Converts a string to a string with a first upper letter.
	 * 
	 * @param str The string to convert
	 * @return The string with a first upper letter.
	 */
	private static String convertToFirstUpper(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
	
	/**
	 * Returns a method object for a given method name and its parameters.
	 * 
	 * @param workflowComponent The workflow component where the method is
	 *        defined.
	 * @param name The name of the method.
	 * @param params The params of the method.
	 * @return The method object.
	 * @throws Throwable
	 */
	private static Method getMethod(Object workflowComponent, String name, Class<?>... params) throws Throwable {
		return workflowComponent.getClass().getMethod(name, params);
	}
	
	/**
	 * Checks if a method exists for a given method name and its params.
	 * 
	 * @param workflowComponent The workflow component where the method is
	 *        defined.
	 * @param name The name of the method.
	 * @param params The params of the method.
	 * @return True if the method exists, otherwise false.
	 */
	private static boolean hasMethod(Object workflowComponent, String name, Class<?>... params) {
		boolean hasMethod = false;
		
		try {
			getMethod(workflowComponent, name, params);
			hasMethod = true;
		} catch (Throwable t) {
		}
		return hasMethod;
	}
}
