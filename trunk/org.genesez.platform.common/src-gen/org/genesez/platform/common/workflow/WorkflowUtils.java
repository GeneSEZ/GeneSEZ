package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1318947289729_619671_3539) 
 */

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.text.NumberFormat;
import java.util.Properties;
import java.util.StringTokenizer;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

/**
 * Helper class for other workflow components.
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-19
 * @deprecated
 */
public class WorkflowUtils {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method to create a GlobalVarDef.
	 * @param	key	The name of the GlobalVarDef.
	 * @param	value	The value of the GlobalVarDef.
	 * @return	A GLobalVarDef object.
	 */
	public static GlobalVarDef createGlobalVarDef(String key, String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318947642078_345425_3623) ENABLED START */
		GlobalVarDef gVD = new GlobalVarDef();
		gVD.setName(key);
		gVD.setValue(value);
		return gVD;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method to create a GlobalVarDef.
	 * @param	key	The name of the GlobalVarDef.
	 * @param	value	The value of the GlobalVarDef.
	 * @return	A GLobalVarDef object.
	 */
	public static GlobalVarDef createGlobalVarDef(String key, boolean value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318947793462_388487_3651) ENABLED START */
		GlobalVarDef GVD = new GlobalVarDef();
		GVD.setName(key);
		GVD.setValue(Boolean.toString(value));
		return GVD;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the specified value can be parsed to a number.
	 * @param	s	The value to check if it is a number.
	 * @return	True if the specified value is a number, otherwise false.
	 */
	public static boolean isNumber(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318947880342_592590_3664) ENABLED START */
		try {
			NumberFormat.getIntegerInstance().parse(s);
			return true;
		} catch (ParseException e) {
			return false;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the specified value can be parsed to a boolean.
	 * @param	s	The value to check if it is a boolean.
	 * @return	True if the specified value is a boolean, otherwise false.
	 */
	public static boolean isBoolean(String s) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318947948670_231610_3673) ENABLED START */
		return "true".equals(s) || "false".equals(s);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Converts a comma or semicolon separated string into a list an trims the values.
	 * @param	str	A comma or semicolon separated string.
	 * @return	A list of strings.
	 */
	public static java.util.List<String> split(String str) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318948024086_659892_3682) ENABLED START */
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(str, ",;");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result.add(token.trim());
		}
		return result;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Converts a list into a string.
	 * @param	collection	
	 * @return	
	 */
	public static String arrayToString(Collection<String> collection) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318948254990_273568_3702) ENABLED START */
		StringBuffer s = new StringBuffer();
		Iterator<String> it = collection.iterator();
		while (it.hasNext()) {
			s.append(it.next());
			if (it.hasNext()) {
				s.append(",");
			}
		}
		return s.toString();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Trying to call the accessor methods for for a list of workflow component properties. For instance if the property name is <em><b>slot</b></em>, it tries to call <em><b>public void setSlot(String slot)</b></em>. If this method is not found, it tries to call <em><b>public void addSlot(String slot)</b></em>, otherwise it tries to call <em><b>public void put(Object propertyName, Object propertyValue)</b></em>
	 * @param	workflowComponent	The workflow component where the accessor methods are defined.
	 * @param	defaults	The properties to set.
	 */
	
	public static void callPropertyAccessors(Object workflowComponent, Properties defaults) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318948380887_146153_3713) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Converts a string to a string with a first upper letter.
	 * @param	str	The string to convert
	 * @return	The string with a first upper letter.
	 */
	private static String convertToFirstUpper(String str) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318948563270_251099_3726) ENABLED START */
		return str.substring(0, 1).toUpperCase() + str.substring(1);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns a method object for a given method name and its parameters.
	 * @throws Throwable if something is thrown.
	 * @param	workflowComponent	The workflow component where the method is defined.
	 * @param	name	The name of the method.
	 * @param	params	The parameters of the method.
	 * @return	The method object.
	 * @throws	Throwable
	 */
	private static Method getMethod(Object workflowComponent, String name, Class<?>... params) throws Throwable {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318948658862_293714_3735) ENABLED START */
		return workflowComponent.getClass().getMethod(name, params);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if a method exists for a given method name and its parameters.
	 * @param	workflowComponent	The workflow component where the method should be defined.
	 * @param	name	The name of the method.
	 * @param	params	The parameters of the method.
	 * @return	True if the method exists, otherwise false.
	 */
	private static boolean hasMethod(Object workflowComponent, String name, Class<?>... params) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318949113263_620845_3818) ENABLED START */
		boolean hasMethod = false;
		
		try {
			getMethod(workflowComponent, name, params);
			hasMethod = true;
		} catch (Throwable t) {
		}
		return hasMethod;
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1318947289729_619671_3539) ENABLED START */
	/* PROTECTED REGION END */
	
}
