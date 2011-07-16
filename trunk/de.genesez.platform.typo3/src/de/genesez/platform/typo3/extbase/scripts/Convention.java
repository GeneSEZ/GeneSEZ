package de.genesez.platform.typo3.extbase.scripts;

public class Convention {

	public static String extensionName(String extensionKey) {
		StringBuffer extensionName = new StringBuffer();

		for (String extensionKeyPart : extensionKey.split("_")) {
			extensionName.append( toUpperCamelCase(extensionKeyPart) );
		}
		return extensionName.toString();
	}
	
	private static String toUpperCamelCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

}