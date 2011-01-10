package de.genesez.platforms.dashboard;

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
 * @author	tobias haubold
 */
public class Conversion {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * rounds a given double value to a long
	 * note: needed because a direct mapping to java.lang.Math.round(...) doesn't work :-(
	 * @param d	the value to round
	 * @return	a long value
	 */
	public static Long round(Double d) {
		return Math.round(d);
	}
	
	public static boolean isDate(String s) {
		try {
			sdf.parse(s);
			return true;
		} catch (ParseException pe) {
			return false;
		}
	}
	
	public static boolean isNumber(String s) {
		try {
			NumberFormat.getIntegerInstance().parse(s);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
	
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
