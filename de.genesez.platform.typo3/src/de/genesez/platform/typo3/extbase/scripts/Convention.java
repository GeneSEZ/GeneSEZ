package de.genesez.platform.typo3.extbase.scripts;

import de.genesez.metamodel.gcore.MProperty;

public class Convention {
	
	public static String extensionName(String extensionKey) {
		StringBuffer extensionName = new StringBuffer();
		
		for (String extensionKeyPart : extensionKey.split("_")) {
			extensionName.append(toUpperCamelCase(extensionKeyPart));
		}
		return extensionName.toString();
	}
	
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
	
	private static String toUpperCamelCase(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	
}
