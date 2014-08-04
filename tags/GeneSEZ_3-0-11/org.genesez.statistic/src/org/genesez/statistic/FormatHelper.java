package org.genesez.statistic;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1323877062706_671014_2322) 
 */

import java.text.NumberFormat;
/**
 * Helper class for XPand to format number nicely according current locale.
 * @author toh
 */
public class FormatHelper {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Formats a number according the current locale.
	 * @param	number	the number to format
	 * @return	the formatted number
	 */
	public static String format(Integer number) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323877138588_972969_2329) ENABLED START */
		return NumberFormat.getInstance().format(number);
		/* PROTECTED REGION END */
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1323877062706_671014_2322) ENABLED START */
	/* PROTECTED REGION END */
	
}
