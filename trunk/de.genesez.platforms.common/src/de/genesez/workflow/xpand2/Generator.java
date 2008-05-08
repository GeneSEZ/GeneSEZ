package de.genesez.workflow.xpand2;

import de.genesez.platforms.common.typemapping.TypeMapper;

/**
 * GeneSEZ specific Generator Class supporting the GeneSEZ type mapping
 * 
 * @author	nihe
 * @date	2008-02-19
 */
public class Generator extends org.openarchitectureware.xpand2.Generator {
	
	/**
	 * constructs the GeneSEZ Generator
	 */
	public Generator() {
		super();
	}
	
	/**
	 * setter for the type mapping file
	 * @param	typeMappingFile		name of the file used by the generator for type mapping
	 */
	public void setTypeMappingFile(final String typeMappingFile) {
		TypeMapper.initTypeMapper(typeMappingFile);
    }
}
