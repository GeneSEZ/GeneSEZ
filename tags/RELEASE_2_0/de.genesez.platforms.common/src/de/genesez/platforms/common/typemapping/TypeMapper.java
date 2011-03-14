package de.genesez.platforms.common.typemapping;

import java.util.LinkedHashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MPrimitiveType;
import de.genesez.metamodel.gcore.MType;
import de.genesez.platforms.common.typemapping.types.MappingBody;
import de.genesez.platforms.common.typemapping.types.MultiValuedType;
import de.genesez.platforms.common.typemapping.types.SingleValuedType;

/**
 * This class will unmarshall the specified Typemapping files within its
 * included references to the other mapping files. Priority goes First come
 * first serve a context will be added if the mapping already exists but the
 * context not
 * 
 * @author nihe
 * @author pethu
 * @author toh (last)
 * @date 2009-01-24
 */
public class TypeMapper {

	/**
	 * Singleton type mapper instance.
	 */
	private static TypeMapper typeMapper = null;

	/**
	 * Using log4j-mechanism for error logging.
	 */
	private final Log log = LogFactory.getLog(getClass());

	/**
	 * this provides all necessary binding methods to the TypeMapper
	 */
	private BindingDelegator jaxbDelegator;
	/**
	 * collects all files referenced or included by the user/typemapping file
	 */
	private LinkedHashSet<String> fileSet;

	/**
	 * context path to the package to introduce the JavaBeans to the context
	 */
	private final String contextPath = "de.genesez.platforms.common.typemapping.types";

	/**
	 * manages all primitive Mappings
	 */
	private ITypeMappingManager<SingleValuedType> primitiveTypeManager = null;
	/**
	 * manages all external Mappings
	 */
	private ITypeMappingManager<SingleValuedType> externalTypeManager = null;
	/**
	 * manages all multivalued Mappings
	 */
	private ITypeMappingManager<MultiValuedType> multiValuedTypeManager = null;

	/**
	 * singleton Constructor to initiate the necessary data, aggregate the
	 * Mapping files and fill the Hashmaps
	 * 
	 * @param typeMappingFiles
	 *            specified typeMapping files
	 */
	protected TypeMapper(String... typeMappingFiles) {
		fileSet = new LinkedHashSet<String>();
		jaxbDelegator = new BindingDelegator(contextPath);
		MappingFileCollector fileCollector = new MappingFileCollector(
				jaxbDelegator);
		for (String mappingFile : typeMappingFiles) {
			fileSet.addAll(fileCollector.getMappingFiles(mappingFile));
		}
		primitiveTypeManager = new TypeMappingManager<SingleValuedType>();
		externalTypeManager = new TypeMappingManager<SingleValuedType>();
		multiValuedTypeManager = new CollectionMappingManager<MultiValuedType>();
		fillMappingManagers();
	}

	/**
	 * Method to assign the appropriate MappingList to the specific
	 * MappingManager
	 */
	private void fillMappingManagers() {
		for (String file : fileSet) {
			MappingBody mappingBody = jaxbDelegator.getMappingBody(file);
			if (mappingBody != null) {
				if (mappingBody.isSetExternalTypes()) {
					externalTypeManager.appendMappingMap(mappingBody
							.getExternalTypes().getMappingList());
				}
				if (mappingBody.isSetPrimitiveTypes()) {
					primitiveTypeManager.appendMappingMap(mappingBody
							.getPrimitiveTypes().getMappingList());
				}
				if (mappingBody.isSetMultiValuedTypes()) {
					multiValuedTypeManager.appendMappingMap(mappingBody
							.getMultiValuedTypes().getMappingList());
				}
			}
		}
	}

	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value for this type. Attention!!! This method is not for collection
	 * types. Please use the getMappingType(...) function.
	 * 
	 * @param type
	 *            the type which shall be transformed
	 * @return the transformed or standard type as String representation
	 */
	public String getMappingName(MType type) {
		return getMappingName(type, null);
	}

	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value for this type. Attention!!! This method is not for collection
	 * types. Please use the getMappingType(...) function.
	 * 
	 * @param type
	 *            the type which shall be transformed
	 * @param context
	 *            the implementation context
	 * @return the transformed or standard type as String representation
	 */
	public String getMappingName(MType type, String context) {
		String returnValue = null;

		if (type instanceof MPrimitiveType)
			returnValue = primitiveTypeManager.getTypeMapping(
					((MPrimitiveType) type).getName(), context);
		// returnValue = getPrimitiveTypeMapping(((MPrimitiveType)
		// type).getName(), context);
		else if (type instanceof MClassifier)
			returnValue = ((MClassifier) type).getName();
		else if (type instanceof MGeneric)
			returnValue = ((MGeneric) type).getSpecification();
		else if (type instanceof MExternal)
			returnValue = externalTypeManager.getTypeMapping(((MExternal) type)
					.getSpecification(), context);
		// returnValue = getExternalTypeMapping(((MExternal)
		// type).getSpecification(), context);
		else {
			returnValue = "";
			log.error("Unsupported type");
		}

		return returnValue;
	}

	/**
	 * This method returns a language specific collection by means of the unique
	 * and ordered statements. If no matching value is detected, then the
	 * default collection type will be used. Attention!!! This method is only
	 * for collection types.
	 * 
	 * @param unique
	 *            true if the collection shall be unique otherwise false
	 * @param ordered
	 *            true if the collection shall be ordered otherwise false
	 * @return the transformed or standard collection type as String
	 *         representation
	 */
	public String getMappingType(Boolean unique, Boolean ordered) {
		return getMappingType(unique, ordered, null);
	}

	/**
	 * This method returns a language specific collection by means of the unique
	 * and ordered statements. If no matching value is detected, then the
	 * default collection type will be used. Attention!!! This method is only
	 * for collection types.
	 * 
	 * @param unique
	 *            true if the collection shall be unique otherwise false
	 * @param ordered
	 *            true if the collection shall be ordered otherwise false
	 * @param context
	 *            the implementation context
	 * @return the transformed or standard collection type as String
	 *         representation
	 */
	public String getMappingType(Boolean unique, Boolean ordered, String context) {
		return multiValuedTypeManager.getTypeMapping(unique.toString()
				+ ordered.toString(), context);
	}
	
	/**
	 * This static method initializes the type mapper. Please call this function
	 * before the beginning of the model to text transformation to configure or reconfigure
	 * the type mapper with the specified set of mapping files.
	 * 
	 * @param typeMappingFiles
	 *            the specified typeMapping files
	 * @return singleton type mapper instance
	 */
	public static TypeMapper initTypeMapper(String... typeMappingFiles) {
		typeMapper = new TypeMapper(typeMappingFiles);
		return typeMapper;
	}
	
	/**
	 * Sole method to get the preconfigured type mapper.
	 * 
	 * @return singleton type mapper instance
	 */
	public static TypeMapper getInstance() {
		if (typeMapper == null) {
			typeMapper = new TypeMapper("de/genesez/platforms/common/typemapping/typemapping.xml");
		}
		return typeMapper;
	}
}
