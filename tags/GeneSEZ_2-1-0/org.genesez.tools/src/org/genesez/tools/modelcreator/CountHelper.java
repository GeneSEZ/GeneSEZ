package org.genesez.tools.modelcreator;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CountHelper {

	private static Log logger = LogFactory.getLog(CountHelper.class);

	private static int packages = 0;

	private static int classes = 0;

	private static int attributes = 0;

	private static int references = 0;

	private static int operations = 0;

	private static int parameters = 0;

	private static int interfaces = 0;

	private static int realizations = 0;

	private static int generalizations = 0;

	private static int associationClasses = 0;

	private static long time = 0;

	private static long completeTime = 0;

	/**
	 * Increments the amount of the given type.
	 * 
	 * @param type
	 *            the type thats incremented
	 * @return the name for the type consists of a prefix and {@link #getId()}
	 */
	public static String getName(String type) {
		increment(type);
		Character prefix = type.charAt(0);
		return prefix + getId();
	}

	/**
	 * gets given number adjusted with the given parameters.
	 * 
	 * @param number
	 *            the number that should be
	 * @param random
	 *            the percentage of randomization for the number
	 * @param offset
	 *            the absolute amount or percentage of an offset for the number
	 * @param isPercent
	 *            true if offset is given in percent
	 * @return if only number is given, number is returned, else number adjusted
	 *         with the given parameters.
	 */
	public static Integer getNumber(Integer number, Integer random,
			Integer offset, Boolean isPercent) {
		if (isPercent) {
			offset = Math.round(((Double) (offset * number / 100.0))
					.floatValue());
		}
		int result = Math.round(((Double) (number + (Math.random() - 0.5) * 2
				* (number * random / 100.0))).floatValue());
		return result + offset;
	}

	/**
	 * Gets an unique name
	 * 
	 * @return a String containing the amount of all counted fields.
	 */
	public static String getId() {
		return "" + packages + classes + interfaces + realizations + references
				+ associationClasses + attributes + operations + parameters;
	}

	public static void setStartTime() {
		time = System.currentTimeMillis();
		completeTime = time;
	}

	/**
	 * logs an output with all stored information.
	 */
	public static void output() {
		completeTime = System.currentTimeMillis() - completeTime;
		logger.info("Generated model contains " + packages + " packages, "
				+ classes + " classes, " + generalizations
				+ " generalizations, " + interfaces + " interfaces, "
				+ realizations + " interface realizations, "
				+ +(references / 2) + " associations (thereof "
				+ associationClasses + " association classes), " + attributes
				+ " attributes, " + operations + " operations and "
				+ parameters + " parameters.");
		logger.info("Model generation took: " + (completeTime / 1000.0) + "s");
	}

	/**
	 * increments the given attribute name
	 * 
	 * @param attributeName
	 *            the attribute to increment
	 */
	private static void increment(String attributeName) {
		try {
			Class<CountHelper> cl = CountHelper.class;
			Field field = cl.getDeclaredField(attributeName);
			int i = field.getInt(cl);
			field.setInt(cl, ++i);
		} catch (ReflectiveOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
