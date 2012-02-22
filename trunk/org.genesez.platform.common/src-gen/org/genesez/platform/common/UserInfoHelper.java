package org.genesez.platform.common;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324548264011_843551_2411) 
 */

/**
 * Helper class for user information functions.
 * 
 * @author geobe
 * @author toh
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (last)
 * @date 2011-04-13
 */
public class UserInfoHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Getter for the user name, who is currently logged in.
	 * @return	string representation of the current user
	 */
	public static String getUserName() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324548328730_464787_2439) ENABLED START */
		return System.getProperty("user.name", "unknown user");
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324548264011_843551_2411) ENABLED START */
	/* PROTECTED REGION END */
	
}
