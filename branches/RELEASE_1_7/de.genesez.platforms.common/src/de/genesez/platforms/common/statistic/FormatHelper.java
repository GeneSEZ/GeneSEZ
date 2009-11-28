package de.genesez.platforms.common.statistic;

import java.text.NumberFormat;

/**
 * Helper class for XPand to format number nicely according current locale.
 * @author toh
 */
public class FormatHelper {
	
	/**
	 * Formats a number according the current locale
	 * @param number	the number to format
	 * @return			the formatted number
	 */
	public static String format(Integer number) {
		return NumberFormat.getInstance().format(number);
	}
}
