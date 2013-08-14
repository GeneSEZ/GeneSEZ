package org.genesez.util.conversion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class for converting names
 *  
 * @author andré pflueger
 * @author nico herbig
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public final class StringProcessing {

	private static Log logger = LogFactory.getLog(StringProcessing.class);
	
	private StringProcessing() {
	}
	
	/**
	 * Splits a string by every capital letter, transforms every token to lower case 
	 * and adds underscores between of them. 
	 * For instance: 'relatedPosts' -> 'related_posts'.
	 * 
	 * @param 	string	A string which should be converted. 
	 * @return 	The string in lower case and with underscores.
	 */
	public static String toLowerUnderscore(String string) {
		return getUnderscoredString(string, false);
	}
	
	/**
	 * Splits a string by every capital letter, transforms every token to upper case 
	 * and adds underscores between of them. 
	 * For instance: 'relatedPosts' -> 'RELATED_POSTS'.
	 * 
	 * @param 	string	A string which should be converted.
	 * @return 	The string in upper case and with underscores.
	 */
	public static String toUpperUnderscore(String string) {
		// ignore naming if name consists just of capital letters and underlines
		if (string.matches("[A-Z_]*")) {
			return string;
		}
		return getUnderscoredString(string, true);
	}
	
	private static String getUnderscoredString(String string, boolean upperCase) {
	    StringBuffer propertyName = new StringBuffer();
	    String[] propertyNameParts;
	    
	    propertyNameParts = string.split("(?=[A-Z])");
	    for (int i = 0; i < propertyNameParts.length; i++) {
	    	// don't let the name start with an underscore
	    	if (i == 0 && propertyNameParts[i].isEmpty()) {
	    		continue;
	    	}
	    	if (upperCase) {
	    		propertyName.append(propertyNameParts[i].toUpperCase());
	    	} else {
		        propertyName.append(propertyNameParts[i].toLowerCase());
	    	}
	        if (i < propertyNameParts.length - 1) {
	            propertyName.append("_");
	        }
	    }
	    return propertyName.toString();
	}
}
