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
 * TODO		Move functionality to StringProcessing class of org.genesez.util project.
 */
public final class NamingConvention {

	private NamingConvention() {
	}
		
	/**
	 * Create a TYPO3 CMS extension package name by a specified extension key.
	 * This method splits a extension key at the underscore characters and transform
	 * every token to first upper case to get a valid extension package name.
	 * 
	 * @param	extensionKey	The TYPO3 CMS extension key.
	 * @return	The TYPO3 CMS extension package name.
	 */
	public static String extensionPackageName(String extensionKey) {
		StringBuffer extensionPackageName = new StringBuffer();

		for ( String extensionKeyPart : extensionKey.split("_") ) {
			extensionPackageName.append( toUpperCamelCase(extensionKeyPart) );
		}
		return extensionPackageName.toString();
	}

	/**
	 * Convert a given string that the first letter is an capital letter and all others are in lower case.
	 * 
	 * @param 	string 	The string to convert.
	 * @return 	The converted string.
	 */
	private static String toUpperCamelCase(String string) {
		String upperCamelCase;
		
		if (string.length() <= 1) {
			upperCamelCase = string.toUpperCase();
		} else {
			upperCamelCase = string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
		}
		return upperCamelCase;
	}

}