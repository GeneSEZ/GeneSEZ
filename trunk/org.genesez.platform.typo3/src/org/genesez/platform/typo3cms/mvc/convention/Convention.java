package org.genesez.platform.typo3v4.mvc.convention;

/**
 * Utility class for TYPO3 MVC extension conventions.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-04-13
 */
public class Convention {

	/**
	 * Create the TYPO3 MVC extension name by a given extension key. This method
	 * splits the extension key at the underscores and transform every token to
	 * first upper case to get a valid extension name.
	 * 
	 * @param extensionKey The TYPO3 MVC extension key.
	 * @return The TYPO3 MVC extension name based on extension key.
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
