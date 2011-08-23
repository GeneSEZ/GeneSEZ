package de.genesez.platforms.common.naming;

import de.genesez.metamodel.gcore.MElement;

public class Naming {
	
	public static void setXtendNamingFile(String xtendNamingFile) {
		getNamingMapper().setXtendNamingFile(xtendNamingFile);
	}
	
	/**
	 * @param element
	 * @param namingContext
	 * @return
	 */
	public static String naming(MElement element, String namingContext) {
		return getNamingMapper().getMappingName(element, namingContext);
	}
	
	/**
	 * Sole method to get the preconfigured naming mapper.
	 * 
	 * @return preconfigured naming mapper
	 */
	private static NamingMapper getNamingMapper() {
		return NamingMapper.getInstance();
	}
}
