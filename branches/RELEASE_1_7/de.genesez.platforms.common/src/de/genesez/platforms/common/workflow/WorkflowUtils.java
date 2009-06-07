package de.genesez.platforms.common.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;

/**
 * Helper class for other workflow components
 * @author Aibek Isaev
 * @author Beishen
 */
public class WorkflowUtils {
	
	private static final String propertyFile = "GeneSEZ.properties";
	public static final Properties defaults = new Properties();
	static {
		defaults.put("slot", "genesezModel");
		defaults.put("gcorePackage", "de.genesez.metamodel.gcore.GcorePackage");
		try {
			InputStream is = ClassLoader.getSystemResourceAsStream(propertyFile);
			if (is != null) {
				defaults.load(is);
			}
		} catch (IOException ioe) {
			LogFactory.getLog(WorkflowUtils.class).warn("could not load GeneSEZ properties file");
		}
	}
	
	
	/**
	 * load properties from the specified file and from the default file
	 * @param properties	the properties object to fill
	 * @param logger		a log object
	 * @param file			the name of the file
	 */
	public static void loadAllProperties(Properties properties, Log logger, Class<?> clazz) {
		loadPropertyFile(properties, logger, propertyFile);
		loadPropertyFile(properties, logger, getFileName(clazz));
	}
	
	public static void loadDefaultProperties(Properties properties, Log logger) {
		loadPropertyFile(properties, logger, propertyFile);
	}
	
	/**
	 * Method for create GlobalVarDef
	 * 
	 * @param name	GlobalVarDef's name
	 * @param value	GlobalVarDef's value. Type is String
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
	 * @param name	GlobalVarDef's name
	 * @param value	GlobalVarDef's value. Type is boolean
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
	 * @param list	a comma or semicolon separated list
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
	 * @param name	of List<String>
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
	
	private static String getFilePath(Class<?> clazz) {
		return clazz.getPackage().getName().replace('.', '/') + '/';
	}
	
	private static String getFileName(Class<?> clazz) {
		return getFilePath(clazz) + clazz.getSimpleName() + ".properties";
	}
	
	private static void loadPropertyFile(Properties properties, Log logger, String file) {
		InputStream is = ClassLoader.getSystemResourceAsStream(file);
		if (is == null) {
			String alternate = getFilePath(WorkflowUtils.class) + file;
			is = ClassLoader.getSystemResourceAsStream(alternate);
		}
		if (is == null) {
			logger.info("properties file '" + file + "' not found, using defaults");
		} else {
			try {
				properties.load(is);
				is.close();
			} catch (IOException ioe) {
				logger.warn("cannot read properties file '" + file + "'", ioe);
			}
		}
	}
}
