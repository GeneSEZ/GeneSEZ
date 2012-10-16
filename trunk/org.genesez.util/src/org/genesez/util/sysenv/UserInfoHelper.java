package org.genesez.util.sysenv;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324548264011_843551_2411) 
 */

/**
 * Utility class for user information functions.
 * 
 * @author Tobias Haubold <tobias.haubold@fh-zwickau.de> (maintainer)
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 * @author Georg Beier<georg.beier@fh-zwickau.de>
 */
public class UserInfoHelper {
	
	/**
	 * Returns the user account name of the currently logged in user.
	 * 
	 * @return	The user account name.
	 */
	public static String getUserName() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548328730_464787_2439) ENABLED START */
		return System.getProperty("user.name", "unknown user");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324548264011_843551_2411) ENABLED START */
	/* PROTECTED REGION END */
	
}
