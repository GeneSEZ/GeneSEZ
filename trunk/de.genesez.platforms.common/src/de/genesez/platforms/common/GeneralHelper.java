package de.genesez.platforms.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class with general helper functions
 * 
 * @author	nihe
 * @author	geobe
 * @author	toh
 * @date	2008-04-18
 * @deprecated
 */
public class GeneralHelper {
	
	/**
	 * getter for the current timestamp
	 * @return	nice string representation of the current timestamp
	 * @deprecated
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z").format(new Date());
	}
	
	/**
	 * getter for the user who logged in
	 * @return	string representation of the current user
	 * @deprecated
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}
}
