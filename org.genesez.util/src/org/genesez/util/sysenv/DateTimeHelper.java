package org.genesez.util.sysenv;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324545543496_662372_2045) 
 */
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Utility class for date and time functions.
 * 
 * @author Tobias Haubold <tobias.haubold@fh-zwickau.de> (maintainer)
 * @author Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 * @author Georg Beier<georg.beier@fh-zwickau.de>
 */
public class DateTimeHelper {
	
	/**
	 * Returns the current timestamp in the "yyyy-MM-dd HH:mm:ss.SSS z" format.
	 * 
	 * @return	The string representation of the current timestamp.
	 */
	public static String getTimeStamp() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545579276_502122_2075) ENABLED START */
		return getTimeStamp("yyyy-MM-dd HH:mm:ss.SSS z");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the current timestamp for the specified date time pattern.
	 * 
	 * @param	dateTimePattern	The date time pattern.
	 * @return	The string representation of the current timestamp.
	 */
	public static String getTimeStamp(String dateTimePattern) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545652469_876407_2086) ENABLED START */
		return new SimpleDateFormat(dateTimePattern).format(new Date());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the current UNIX timestamp.
	 * 
	 * @return	The string representation of the current timestamp.
	 */
	public static String getUnixTimeStamp() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324545745428_162639_2103) ENABLED START */
		return String.valueOf(new Date().getTime() * 1000L);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324545543496_662372_2045) ENABLED START */
	/* PROTECTED REGION END */
	
}
