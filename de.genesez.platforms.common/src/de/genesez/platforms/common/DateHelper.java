package de.genesez.platforms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class for date and time functions.
 * 
 * @author geobe
 * @author toh
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (last)
 * @date 2011-04-20
 */
public class DateHelper {

	/**
	 * Getter for the current timestamp.
	 * 
	 * @return string representation ("yyyy-MM-dd HH:mm:ss.SSS z") of the
	 *         current timestamp
	 */
	public static String getTimeStamp() {
		return getTimeStamp("yyyy-MM-dd HH:mm:ss.SSS z");
	}

	/**
	 * Getter for the current timestamp.
	 * 
	 * @param formatPattern
	 *            the pattern describing the date and time format
	 * @return string representation of the current timestamp
	 */
	public static String getTimeStamp(String formatPattern) {
		return new SimpleDateFormat(formatPattern).format(new Date());
	}

	/**
	 * Getter for the current UNIX timestamp.
	 * 
	 * @return representation of the current timestamp
	 */
	public static String getUnixTimeStamp() {
		return String.valueOf(new Date().getTime() * 1000L);
	}

}
