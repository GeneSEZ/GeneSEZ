package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324556963941_767545_4318) 
 */

/**
 * Interface for the TypeMappingManagers to handle the ValuedTypes
 * 
 * @author pethu
 * @date 2009-01-24
 */
public interface ITypeMappingManager<T> {
	
	/**
	 * This method is used to return the language specific type by means of the context, if any entry exists.
	 * @param	searchMappingType	the specific mapping type
	 * @param	context	the implementation context
	 * @return	the Mapping of the Type
	 */
	public String getTypeMapping(String searchMappingType, String context);
	
	/**
	 * this method puts each mapping of the mappingContainer in its own Mapping HashMap
	 * @param	mappingContainer	contains possible new typeMaps
	 */
	
	public void appendMappingMap(java.util.List<T> mappingContainer);
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._17_0_1_8e00291_1324556963941_767545_4318) ENABLED START */
	/* PROTECTED REGION END */
}
