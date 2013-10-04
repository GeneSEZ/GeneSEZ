package org.genesez.platform.typo3.cms.convention;

/*
 * (c) GeneSEZ Research Group
 * All rights reserved.
 *
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */


/**
 * Utility class for TYPO3 CMS naming conventions.
 * 
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de> (maintainer)
 */
public class NamingConvention {

	private NamingConvention() {
	}
	
	/**
	 * Create a TYPO3 CMS extension name by a specified extension key. 
	 * This method splits a extension key at underscores and transform 
	 * every token to first upper case to get a valid extension name.
	 * 
	 * @param	extensionKey	The TYPO3 CMS extension key.
	 * @return	The TYPO3 CMS extension name based on extension key.
	 */
	public static String extensionName(String extensionKey) {
		StringBuffer extensionName = new StringBuffer();

		for (String extensionKeyPart : extensionKey.split("_")) {
			extensionName.append(toUpperCamelCase(extensionKeyPart));
		}
		return extensionName.toString();
	}

	/**
	 * Convert a given string so that the first letter is an capital letter and
	 * all others are in lower case.
	 * 
	 * @param str The string to convert.
	 * @return The converted string.
	 */
	private static String toUpperCamelCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

}
