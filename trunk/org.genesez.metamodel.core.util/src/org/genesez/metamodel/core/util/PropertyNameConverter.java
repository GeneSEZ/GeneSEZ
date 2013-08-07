package org.genesez.metamodel.core.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.metamodel.gcore.MProperty;

/**
 * Utility class for converting property names
 *  
 * @author andré pflueger
 * @author nico herbig
 */
public class PropertyNameConverter {

	private static Log logger = LogFactory.getLog(AccessHelper.class);
	
	/**
	 * 	This method splits the property name by every capital letter, 
	 *	transforms every token to lower case and adds underscores 
	 *	between of them. For instance: the property name is
	 * 	'relatedPosts' it converts to 'related_posts'.
	 * 
	 * 	@param 		property The property.
	 * 	@return 	The property name in lower case and with underscores.
	 */
	public static String toLowerPropertyName(MProperty property) {
		return getPropertName(property, false);
	}
	
	/**
	 * 	This method splits the property name by every capital letter, 
	 *	transforms every token to upper case and adds underscores 
	 *	between of them. For instance: the property name is
	 * 	'relatedPosts' it converts to 'RELATED_POSTS'.
	 * 
	 * 	@param 		property The property.
	 * 	@return 	The property name in upper case and with underscores.
	 */
	public static String toUpperPropertyName(MProperty property) {
		return getPropertName(property, true);
	}
	
	private static String getPropertName(MProperty property, boolean upper) {
	    StringBuffer propertyName = new StringBuffer();
	    String[] propertyNameParts;

	    propertyNameParts = property.getName().split("(?=[A-Z])");
	    for (int i = 0; i < propertyNameParts.length; i++) {
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
