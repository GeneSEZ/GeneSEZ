package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324560658743_863642_5314) 
 */

import org.genesez.metamodel.gcore.MClassifier;
import org.apache.commons.logging.LogFactory;
import java.util.LinkedHashSet;

import org.genesez.platform.common.typemapping.types.MappingBody;
import org.genesez.platform.common.typemapping.types.MultiValuedType;
import org.genesez.platform.common.typemapping.types.SingleValuedType;

import org.genesez.metamodel.gcore.MExternal;
import org.apache.commons.logging.Log;
import org.genesez.metamodel.gcore.MGeneric;
import org.genesez.metamodel.gcore.MType;
import org.genesez.metamodel.gcore.MPrimitiveType;

/**
 * This class will unmarshall the specified Typemapping files within its included references to the other mapping files. Priority goes First come first serve a context will be added if the mapping already exists but the context not
 * 
 * @author nihe
 * @author pethu
 * @author toh (last)
 * @date 2009-01-24
 */
public class TypeMapper {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association JAXBDELEGATOR to BindingDelegator */
	private BindingDelegator jaxbDelegator;
	
	/**
	 * the Path to the default TypeMapping file
	 */
	private static final String DEFAULT_TYPE_MAPPING_FILE = "org/genesez/platform/common/typemapping/typemapping.xml";
	
	/**
	 * the half-singleton TypeMapper instance
	 */
	private static TypeMapper instance;
	
	/**
	 * context path to the package to introduce the JavaBeans to the context
	 */
	private static final String CONTEXT_PATH = "org.genesez.platform.common.typemapping.types";
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private Log log = LogFactory.getLog(getClass());
	
	/**
	 * collects all files referenced or included by the user/typemapping file
	 */
	
	private java.util.Set<String> fileSet = new java.util.LinkedHashSet<String>();
	
	/**
	 * manages all primitive Mappings
	 */
	private ITypeMappingManager<SingleValuedType> primitiveTypeManager;
	
	/**
	 * manages all external Mappings
	 */
	private ITypeMappingManager<SingleValuedType> externalTypeManager;
	
	/**
	 * manages all multivalued Mappings
	 */
	private ITypeMappingManager<MultiValuedType> multivaluedTypeManager;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor to initiate the necessary data, aggregate the Mapping files and fill the Maps.
	 * @param	typeMappingFiles	specified typeMapping files
	 */
	protected TypeMapper(String... typeMappingFiles) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324561626008_419257_5503) ENABLED START */
		fileSet = new LinkedHashSet<String>();
		jaxbDelegator = new BindingDelegator(CONTEXT_PATH);
		MappingFileCollector fileCollector = new MappingFileCollector(jaxbDelegator);
		for (String mappingFile : typeMappingFiles) {
			fileSet.addAll(fileCollector.getMappingFiles(mappingFile));
		}
		primitiveTypeManager = new TypeMappingManager<SingleValuedType>();
		externalTypeManager = new TypeMappingManager<SingleValuedType>();
		multivaluedTypeManager = new CollectionMappingManager<MultiValuedType>();
		fillMappingManagers();
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method to assign the appropriate MappingList to the specific MappingManager
	 */
	
	private void fillMappingManagers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561653263_667838_5510) ENABLED START */
		for (String file : fileSet) {
			MappingBody mappingBody = jaxbDelegator.getMappingBody(file);
			if (mappingBody != null) {
				if (mappingBody.isSetExternalTypes()) {
					externalTypeManager.appendMappingMap(mappingBody.getExternalTypes().getMappingList());
				}
				if (mappingBody.isSetPrimitiveTypes()) {
					primitiveTypeManager.appendMappingMap(mappingBody.getPrimitiveTypes().getMappingList());
				}
				if (mappingBody.isSetMultiValuedTypes()) {
					multivaluedTypeManager.appendMappingMap(mappingBody.getMultiValuedTypes().getMappingList());
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the basic value for this type. Attention!!! This method is not for collection types. Please use the getMappingType(...) function.
	 * @param	type	the type which shall be transformed
	 * @return	the transformed or standard type as String representation
	 */
	public String getMappingName(MType type) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561693530_138667_5529) ENABLED START */
		return getMappingName(type, null);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the basic value for this type. Attention!!! This method is not for collection types. Please use the getMappingType(...) function.
	 * @param	type	the type which shall be transformed
	 * @param	context	the implementation context
	 * @return	the transformed or standard type as String representation
	 */
	public String getMappingName(MType type, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561741363_411456_5538) ENABLED START */
		String returnValue = null;
		
		if (type instanceof MPrimitiveType)
			returnValue = primitiveTypeManager.getTypeMapping(((MPrimitiveType) type).getName(), context);
		// returnValue = getPrimitiveTypeMapping(((MPrimitiveType)
		// type).getName(), context);
		else if (type instanceof MClassifier)
			returnValue = ((MClassifier) type).getName();
		else if (type instanceof MGeneric)
			returnValue = ((MGeneric) type).getSpecification();
		else if (type instanceof MExternal) {
			MExternal t = ((MExternal) type);
			String spec;
			if (t.getSpecification() == null) {
				spec = t.getName();
			} else {
				spec = t.getSpecification();
			}
			returnValue = externalTypeManager.getTypeMapping(spec, context);
		// returnValue = getExternalTypeMapping(((MExternal)
		// type).getSpecification(), context);
		} else {
			returnValue = "";
			log.error("Unsupported type");
		}
		
		return returnValue;
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns a language specific collection by means of the unique and ordered statements. If no matching value is detected, then the default collection type will be used. Attention!!! This method is only for collection types.
	 * @param	unique	true if the collection shall be unique otherwise false
	 * @param	ordered	true if the collection shall be ordered otherwise false
	 * @return	the transformed or standard collection type as String representation
	 */
	public String getMappingType(boolean unique, boolean ordered) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561783238_580019_5551) ENABLED START */
		return getMappingType(unique, ordered, null);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method returns a language specific collection by means of the unique and ordered statements. If no matching value is detected, then the default collection type will be used. Attention!!! This method is only for collection types.
	 * @param	unique	true if the collection shall be unique otherwise false
	 * @param	ordered	true if the collection shall be ordered otherwise false
	 * @param	context	the implementation context
	 * @return	the transformed or standard collection type as String representation
	 */
	public String getMappingType(boolean unique, boolean ordered, String context) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561947561_423965_5572) ENABLED START */
		return multivaluedTypeManager.getTypeMapping(String.valueOf(unique) + String.valueOf(ordered), context);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This static method initializes the type mapper. Please call this function before the beginning of the model to text transformation to configure or reconfigure the type mapper with the specified set of mapping files.
	 * @param	typeMappingFiles	the specified typeMapping files
	 * @return	the half singleton type mapper instance
	 */
	public static TypeMapper initTypeMapper(String... typeMappingFiles) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324561984196_402447_5582) ENABLED START */
		instance = new TypeMapper(typeMappingFiles);
		return instance;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	public static TypeMapper getInstance() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326822050435_450730_2107) ENABLED START */
		if (instance == null) {
			instance = new TypeMapper(DEFAULT_TYPE_MAPPING_FILE);
		}
		return instance;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324560658743_863642_5314) ENABLED START */
	/* PROTECTED REGION END */
	
}
