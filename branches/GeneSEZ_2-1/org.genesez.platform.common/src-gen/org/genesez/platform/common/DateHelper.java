package org.genesez.platform.common;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324545543496_662372_2045) 
 */

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Helper class for date and time functions.
 * 
 * @author geobe
 * @author toh
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (last)
 * @date 2011-04-20
 */
public class DateHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Getter for the current timestamp.
	 * @return	string representation ("yyyy-MM-dd HH:mm:ss.SSS z") of the current timestamp
	 */
	public static String getTimeStamp() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545579276_502122_2075) ENABLED START */
		return getTimeStamp("yyyy-MM-dd HH:mm:ss.SSS z");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for the current timestamp.
	 * @param	formatPattern	the pattern describing the date and time format
	 * @return	string representation of the current timestamp
	 */
	public static String getTimeStamp(String formatPattern) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545652469_876407_2086) ENABLED START */
		return new SimpleDateFormat(formatPattern).format(new Date());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Getter for the current UNIX timestamp.
	 * @return	representation of the current timestamp
	 */
	public static String getUnixTimeStamp() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545745428_162639_2103) ENABLED START */
		return String.valueOf(new Date().getTime() * 1000L);
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324545543496_662372_2045) ENABLED START */
	/* PROTECTED REGION END */
	
}
