package de.genesez.platforms.common;

/**
 * Helper class for user information functions.
 * 
 * @author geobe
 * @author toh
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (last)
 * @date 2011-04-13
 */
public class UserInfoHelper {

	/**
	 * Getter for the user name, who is currently logged in.
	 * 
	 * @return string representation of the current user
	 */
	public static String getUserName() {
		return System.getProperty("user.name", "unknown user");
	}

}
