package de.genesez.platform.typo3.extbase.scripts;

import de.genesez.metamodel.gcore.MProperty;

/**
 * Utility class for TYPO3 Extbase extension conventions.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-04-13
 */
public class Convention {
	
	/**
	 * Create the TYPO3 Extbase extension name by a given extension key. This
	 * method splits the extension key at the underscores and transform every
	 * token to first upper case to get a valid extension name.
	 * 
	 * @param extensionKey The TYPO3 Extbase extension key
	 * @return The TYPO3 Extbase extension name based on extension key
	 */
	public static String extensionName(String extensionKey) {
		StringBuffer extensionName = new StringBuffer();
		
		for (String extensionKeyPart : extensionKey.split("_")) {
			extensionName.append(toUpperCamelCase(extensionKeyPart));
		}
		return extensionName.toString();
	}
	
	/**
	 * This method is for all attributes and association roles of a domain
	 * object. It converts the property name to get an valid property name in
	 * configuration and localization environment. It splits the property name
	 * by every capital letter and transform every token to lower case and add
	 * underscores between of them. For instance: the property name is
	 * "relatedPosts" it converts to "related_posts".
	 * 
	 * @param property The property
	 * @return The property name in lower case and with underscores
	 */
	public static String toLowerPropertyName(MProperty property) {
		StringBuffer propertyName = new StringBuffer();
		String[] propertyNameParts;
		
		propertyNameParts = property.getName().split("(?=[A-Z])");
		for (int i = 0; i < propertyNameParts.length; i++) {
			propertyName.append(propertyNameParts[i].toLowerCase());
			if (i < propertyNameParts.length - 1) {
				propertyName.append("_");
			}
		}
		return propertyName.toString();
	}
	
	/**
	 * Convert a given string so that the first letter is an capital letter and
	 * all others are in lower case.
	 * 
	 * @param str The string to convert
	 * @return The converted string
	 */
	private static String toUpperCamelCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
}
