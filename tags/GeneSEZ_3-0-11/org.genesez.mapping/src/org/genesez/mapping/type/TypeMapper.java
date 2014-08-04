package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324560658743_863642_5314) 
 */

import org.genesez.mapping.type.types.MappingBody;
import org.genesez.mapping.type.types.MultiValuedType;
import org.genesez.mapping.type.types.SingleValuedType;
import java.util.LinkedHashSet;

/**
 * This class will unmarshall the specified type mapping files within its included references to the other mapping files. 
 * Priority goes "First Come First Serve", a context will be added if the mapping already exists but the context not.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 * @author	Tobias Haubold <tobias.haubold@fh-zwickau.de>
 * @author	Nico Herbig <nico.herbig@fh-zwickau.de>
 */
public class TypeMapper {
	
	/**
	 * Stores the associated object of association JAXBDELEGATOR to BindingDelegator. 
	 */
	private BindingDelegator jaxbDelegator;
	
	/**
	 * The path to the default type mapping file.
	 */
	private static final String DEFAULT_TYPE_MAPPING_FILE = "org/genesez/mapping/type/typemapping.xml";
	
	/**
	 * The half-singleton type mapper instance.
	 */
	private static TypeMapper instance;
	
	/**
	 * Context path to the package to introduce the JavaBeans to the context.
	 */
	private static final String CONTEXT_PATH = "org.genesez.mapping.type.types";
	
	/**
	 * Collects all files referenced or included by the user or typemapping file.
	 */
	private java.util.Set<String> fileSet = new java.util.LinkedHashSet<String>();
	
	/**
	 * Manages all external type mappings.
	 */
	private ITypeMappingManager<SingleValuedType> externalTypeManager;
	
	/**
	 * Manages all multi-valued type mappings.
	 */
	private ITypeMappingManager<MultiValuedType> multivaluedTypeManager;
	
	/**
	 * Constructor to initiate the necessary data, aggregate the type mapping files and fill the maps.
	 * 
	 * @param	typeMappingFiles	The specified type mapping files.
	 */
	protected TypeMapper(String... typeMappingFiles) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324561626008_419257_5503) ENABLED START */
		fileSet = new LinkedHashSet<String>();
		jaxbDelegator = new BindingDelegator(CONTEXT_PATH);
		MappingFileCollector fileCollector = new MappingFileCollector(jaxbDelegator);
		for (String mappingFile : typeMappingFiles) {
			fileSet.addAll(fileCollector.getMappingFiles(mappingFile));
		}
		externalTypeManager = new TypeMappingManager<SingleValuedType>();
		multivaluedTypeManager = new CollectionMappingManager<MultiValuedType>();
		fillMappingManagers();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Assigns the appropriate type mapping lists to the specific type mapping managers.
	 */
	private void fillMappingManagers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561653263_667838_5510) ENABLED START */
		for (String file : fileSet) {
			MappingBody mappingBody = jaxbDelegator.getMappingBody(file);
			if (mappingBody != null) {
				if (mappingBody.isSetExternalTypes()) {
					externalTypeManager.appendTypeMappingMap(mappingBody.getExternalTypes().getMappingList());
				}
				if (mappingBody.isSetMultiValuedTypes()) {
					multivaluedTypeManager.appendTypeMappingMap(mappingBody.getMultiValuedTypes().getMappingList());
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns true if a mapping for the specified type in the specified context exists, otherwise false.
	 * 
	 * @param mappingType	The type to map.
	 * @param context		The context in which the type should be mapped.
	 * @return	True if a type mapping exists, otherwise false.
	 * 
	 * @see org.genesez.mapping.type.ITypeMappingManager#hasTypeMapping(java.lang.String, java.lang.String)
	 */
	public boolean hasExternalTypeMapping(String externalType, String context) {
		return externalTypeManager.hasTypeMapping(externalType, context);
	}
	
	/**
	 * Returns the name of the external type if a mapping entry exists, 
	 * otherwise the specified name of the external type will be returned.
	 * 
	 * @param	externalType	The name of the external type which shall be mapped.
	 * @return	The mapped or specified name of the external type.
	 */
	public String mapExternalType(String externalType) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561693530_138667_5529) ENABLED START */
		return mapExternalType(externalType, null);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the name of the external type by means of the specified context if a mapping entry exists, 
	 * otherwise the default mapped name will be returned. If no mapping exists the specified name of the external type will be returned.
	 * 
	 * @param	externalType	The name of the external type which shall be mapped.
	 * @param	context			The name of the context in which the external type shall be mapped.
	 * @return	The mapped or specified name of the external type.
	 */
	public String mapExternalType(String externalType, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561741363_411456_5538) ENABLED START */
		return externalTypeManager.getTypeMapping(externalType, context);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the name of the multi-valued type if a mapping entry exists, 
	 * otherwise an empty string will be returned.
	 * 
	 * @param	unique	Set to true, if the values in the multi-valued type are unique, otherwise false.
	 * @param	ordered	Set to true, if the values in the multi-valued type are ordered, otherwise false.
	 * @return	The mapped name of the multi-valued type or an empty string.
	 */
	public String mapMultiValuedType(boolean unique, boolean ordered) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561783238_580019_5551) ENABLED START */
		return mapMultiValuedType(unique, ordered, null);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the name of the multi-valued type by means of the specified context if a mapping entry exists, 
	 * otherwise the default mapped name will be returned. If no mapping exists an empty string will be returned.
	 * 
	 * @param	unique	Set to true, if the values in the multi-valued type are unique, otherwise false.
	 * @param	ordered	Set to true, if the values in the multi-valued type are ordered, otherwise false.
	 * @param	context	The name of the context in which the multi-valued type shall be mapped.
	 * @return	The mapped or default name of the multi-valued type or an empty string.
	 */
	public String mapMultiValuedType(boolean unique, boolean ordered, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561947561_423965_5572) ENABLED START */
		return multivaluedTypeManager.getTypeMapping(String.valueOf(unique) + String.valueOf(ordered), context);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This static method initializes the type mapper. Please call this function before the beginning of the model to text transformation 
	 * to configure or reconfigure the type mapper with the specified set of type mapping files.
	 * 
	 * @param	typeMappingFiles	The specified type mapping files.
	 * @return	The configured type mapper instance.
	 */
	public static TypeMapper initTypeMapper(String... typeMappingFiles) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561984196_402447_5582) ENABLED START */
		instance = new TypeMapper(typeMappingFiles);
		return instance;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sole method to get the preconfigured type mapper.
	 * 
	 * @return	The configured type mapper instance.
	 */
	public static TypeMapper getInstance() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326822050435_450730_2107) ENABLED START */
		if (instance == null) {
			instance = new TypeMapper(DEFAULT_TYPE_MAPPING_FILE);
		}
		return instance;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324560658743_863642_5314) ENABLED START */
	/* PROTECTED REGION END */
	
}
