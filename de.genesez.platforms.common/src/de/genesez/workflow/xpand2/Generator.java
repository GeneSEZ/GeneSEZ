package de.genesez.workflow.xpand2;

import de.genesez.platforms.common.typemapping.TypeMapper;


public class Generator extends org.openarchitectureware.xpand2.Generator {
	
	public Generator() {
		super();
	}
	
	public void setTypeMappingFile(final String typeMappingFile) {
		TypeMapper.initTypeMapper(typeMappingFile);
    }
}
