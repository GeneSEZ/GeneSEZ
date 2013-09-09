package org.genesez.platform.dashboard;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Utility class for Conversion of model informations
 * 
 * @author tobias haubold
 */
public class Conversion {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * Rounds a given double value to a long.
	 * note: needed because a direct mapping to java.lang.Math.round(...) doesn't work :-(
	 * @param d	the value to round
	 * @return	a long value
	 */
	public static Long round(Double d) {
		return Math.round(d);
	}
	
	/**
	 * Checks if a specified value can be parsed to a date or not.
	 * @param s	the value to check if it is a date
	 * @return	true if the specified value is a date, otherwise false
	 */
	public static boolean isDate(String s) {
		try {
			sdf.parse(s);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}
	
	/**
	 * Checks if the specified value can be parsed to a number.
	 * @param s	the value to check if it is a number
	 * @return	true if the specified value is a number, otherwise false
	 */
	public static boolean isNumber(String s) {
		try {
			NumberFormat.getIntegerInstance().parse(s);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
	/**
	 * Calculates the difference between two dates in number of days.
	 * @param before	the starting date value
	 * @param after		the ending date value
	 * @return	the number of days between the dates or zero, if an error occurs
	 */
	public static Integer daydiff(String before, String after) {
		try {
			Date d1 = sdf.parse(before);
			Date d2 = sdf.parse(after);
			long millis = d2.getTime() - d1.getTime();
			return Long.valueOf(millis / (1000 * 60 * 60 * 24)).intValue();
		} catch (ParseException pe) {
			return 0;
		}
	}
	
	/**
	 * Calculates the average value of a list of values.
	 * @param values	a list of values
	 * @return	the average value or -1 if no values are given
	 */
	public static BigDecimal average(List<BigInteger> values) {
		if (values.size() == 0) {
			return new BigDecimal("-1");
		}
		BigDecimal sum = new BigDecimal("0");
		for (BigInteger i : values) {
			sum = sum.add(new BigDecimal(i));
		}
		BigDecimal result = sum.divide(new BigDecimal(values.size()), RoundingMode.HALF_UP);
		return result;
	}
}
