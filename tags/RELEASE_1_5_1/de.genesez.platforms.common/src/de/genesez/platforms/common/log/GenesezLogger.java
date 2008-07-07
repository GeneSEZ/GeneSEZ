/**
 * provides logging support for all GeneSEZ scripts
 */
package de.genesez.platforms.common.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Logging Wrapper around apache commons logging to provide support for logging to all 
 * GeneSEZ openArchitectureWare scripts
 * 
 * @author	toh
 * @date	2008-05-08
 */
public class GenesezLogger {
	
	static {
		// re-configure log4j with genesez properties ???
		// but then the log output changes when different layouts are used!
		//URL url = GenesezLogger.class.getResource("log4j.properties");
		//PropertyConfigurator.configure(url);
	}
	
	/**
	 * holds the current used logger
	 */
	private static Log logger = LogFactory.getLog("GeneSEZ");
	
	
	/**
	 * selects a logger to use
	 * @param	logger	the name of the logger to use
	 */
	public static void selectLogger(final String logger) {
		GenesezLogger.logger = LogFactory.getLog(logger);
	}
	
	
	/**
	 * logs a message with 'fatal' log level
	 * @param	message	the message to log
	 */
	public static void fatal(final String message) {
		logger.fatal(message);
	}
	
	/**
	 * logs a message with 'error' log level
	 * @param	message	the message to log
	 */
	public static void error(final String message) {
		logger.error(message);
	}
	
	/**
	 * logs a message with 'warn' log level
	 * @param	message	the message to log
	 */
	public static void warn(final String message) {
		logger.warn(message);
	}
	
	/**
	 * logs a message with 'info' log level
	 * @param	message	the message to log
	 */
	public static void info(final String message) {
		logger.info(message);
	}
	
	/**
	 * logs a message with 'debug' log level
	 * @param	message	the message to log
	 */
	public static void debug(final String message) {
		logger.debug(message);
	}
	
	/**
	 * logs a message with 'trace' log level
	 * @param	message	the message to log
	 */
	public static void trace(final String message) {
		logger.trace(message);
	}
	
	
	// -- private stuff, don't know if to use later
	
	/**
	 * converts the given object to a detailed string representation using refelection
	 * 
	 * @param o		object to convert into a string representation
	 * @return		string representation of the given object
	 */
	/*
	private static String toDebugString(Object o) {
		if (o == null) {
			return "null";
		}
		ArrayList<String> list = new ArrayList<String>();
		Class clazz = o.getClass();
		convertToString(o, clazz, list);
		return list.toString();
	}
	 */
	
	/**
	 * getter for a nice formatted stack trace
	 * @param e		a throwable
	 * @return		nice formatted stack trace from given throwable
	 */
	/*
	private static String getStackTrace(Throwable e) {
		StringBuffer sb = new StringBuffer();
		StackTraceElement[] stes = e.getStackTrace();
		for (int i=0; i < stes.length; i++) {
			StackTraceElement ste = stes[i];
			sb.append("     at: ");
			sb.append(ste);
			sb.append(Output.NEWLINE);
		}
		return sb.toString();
	}
	
	private static void convertToString(Object o, Class clazz, List<String> list) {
		Field[] fields = clazz.getDeclaredFields();
		// make fields accessible
		AccessibleObject.setAccessible(fields, true);
		for (Field f : fields) {
			try {
				if (f.getType().isArray()) {
//					List<String> arrayList = new ArrayList<String>();
//					Object[] os = (Object[])f.get(o);
//					for (Object obj : os) {
//						arrayList.add(obj.toString());
//					}
//					list.add(f.getName() + " = " + arrayList.toString());
					list.add(f.getName() + " = " + ((Object[])f.get(o)).length);
				} else {
					list.add(f.getName() + " = " + f.get(o));
				}
			} catch (IllegalAccessException e) {
				list.add("-- no access --");
			}
		}
		// check for superclasses
		if (clazz.getSuperclass() != null) {
			convertToString(o, clazz.getSuperclass(), list);
		}
	}
	*/
}
