package de.genesez.xpand2;

import de.genesez.common.typemapping.TypeMapper;


public class Generator extends org.openarchitectureware.xpand2.Generator {
	
	public Generator() {
		super();
	}
		
	public void setTypeMappingFile(final String typeMappingFile) {
		TypeMapper.initTypeMapper(typeMappingFile);
    }

}
