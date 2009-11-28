/**
 * 
 */
package de.genesez.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nihe
 * @author geobe
 * @author toh
 */
public class GeneralHelper {
	
	/**
	 * getter for the current timestamp
	 * @return	nice string representation of the current timestamp
	 */
	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z")
				.format(new Date());
	}
	
	/**
	 * getter for the user who logged in
	 * @return	string representation of the current user
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}
}
