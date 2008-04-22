package de.genesez.common.typemapping;

public interface ITypeMappingManager<T> {
	
	public String getTypeMapping(T searchMappingType);
	
	public String getTypeMapping(T searchMappingType, String context);
	
	public void addMappingType(T mappingType);
	
	public void addContextTypeToMappingType(T searchMappingType, String context, String contextType);

}
