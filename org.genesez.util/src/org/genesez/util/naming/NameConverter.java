package org.genesez.util.naming;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Utility class for converting names
 *  
 * @author andré pflueger
 * @author nico herbig
 * @author tobias haubold <toh@fh-zwickau.de>
 */
public final class NameConverter {

	private static Log logger = LogFactory.getLog(NameConverter.class);
	
	private NameConverter() {
	}
	
	/**
	 * 	This method splits the name by every capital letter, 
	 *	transforms every token to lower case and adds underscores 
	 *	between of them. 
	 *	For instance: 'relatedPosts' -> 'related_posts'.
	 * 
	 * 	@param 		name	string which should be converted 
	 * 	@return 	name in lower case and with underscores
	 */
	public static String toLowerPropertyName(String name) {
		return getPropertName(name, false);
	}
	
	/**
	 * 	This method splits the given String by every capital letter, 
	 *	transforms every token to upper case and adds underscores 
	 *	between of them. 
	 *	For instance: 'relatedPosts' -> 'RELATED_POSTS'.
	 * 
	 * 	@param 		name	string which should be converted
	 * 	@return 	name in upper case and with underscores
	 */
	public static String toUpperPropertyName(String name) {
		// ignore naming if name consists just of capital letters and underlines
		if (name.matches("[A-Z_]*")) {
			return name;
		}
		return getPropertName(name, true);
	}
	
	private static String getPropertName(String name, boolean upper) {
	    StringBuffer propertyName = new StringBuffer();
	    String[] propertyNameParts;
	    
	    propertyNameParts = name.split("(?=[A-Z])");
	    for (int i = 0; i < propertyNameParts.length; i++) {
	    	// don't let the name start with an underscore
	    	if (i == 0 && propertyNameParts[i].isEmpty()) {
	    		continue;
	    	}
	    	if (upper) {
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
