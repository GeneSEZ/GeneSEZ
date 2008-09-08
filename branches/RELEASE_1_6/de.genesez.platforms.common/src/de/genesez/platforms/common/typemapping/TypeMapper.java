package de.genesez.platforms.common.typemapping;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import de.genesez.metamodel.gcore.MClassifier;
import de.genesez.metamodel.gcore.MExternal;
import de.genesez.metamodel.gcore.MGeneric;
import de.genesez.metamodel.gcore.MPrimitiveType;
import de.genesez.metamodel.gcore.MType;
import de.genesez.platforms.common.typemapping.mappingtypes.CollectionMappingType;
import de.genesez.platforms.common.typemapping.mappingtypes.ExternalMappingType;
import de.genesez.platforms.common.typemapping.mappingtypes.PrimitiveMappingType;

/**
 * This class is the main class of the type mapping system which handles the
 * whole transformations.
 * 
 * @author nihe
 * @date 2008-02-18
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
	 * Type mapping manager for collection type mappings.
	 */
	private ITypeMappingManager<CollectionMappingType> collectionTypeManager = null;
	
	/**
	 * Type mapping manager for primitive type mappings.
	 */
	private ITypeMappingManager<PrimitiveMappingType> primitiveTypeManager = null;
	
	/**
	 * Type mapping manager for external type mappings.
	 */
	private ITypeMappingManager<ExternalMappingType> externalTypeManager = null;
	
	/**
	 * Sole constructor which starts the parsing of the type mapping file.
	 * 
	 * @param typeMappingFile the type mapping file in which the type
	 *            transformations are stored
	 */
	private TypeMapper(String typeMappingFile) {
		log.info("Type Mapping: type mapping initialized with file " + typeMappingFile);
		
		collectionTypeManager = new TypeMappingManager<CollectionMappingType>();
		primitiveTypeManager = new TypeMappingManager<PrimitiveMappingType>();
		externalTypeManager = new TypeMappingManager<ExternalMappingType>();
		
		new CollectionTypeXMLReader().parseTypeMappingFile(typeMappingFile);
		new PrimitiveTypeXMLReader().parseTypeMappingFile(typeMappingFile);
		new ExternalTypeXMLReader().parseTypeMappingFile(typeMappingFile);
	}
	
	/**
	 * This method returns if any entry exists the transformed value else the
	 * basic value for this type. Attention!!! This method is not for collection
	 * types. Please use the getMappingType(...) function.
	 * 
	 * @param type the type which shall be transformed
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
	 * @param type the type which shall be transformed
	 * @param context the implementation context
	 * @return the transformed or standard type as String representation
	 */
	public String getMappingName(MType type, String context) {
		String returnValue = null;
		
		if (type instanceof MPrimitiveType)
			returnValue = getPrimitiveTypeMapping(((MPrimitiveType) type).getName(), context);
		else if (type instanceof MClassifier)
			returnValue = ((MClassifier) type).getName();
		else if (type instanceof MGeneric)
			returnValue = ((MGeneric) type).getSpecification();
		else if (type instanceof MExternal)
			returnValue = getExternalTypeMapping(((MExternal) type).getSpecification(), context);
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
	 * @param unique true if the collection shall be unique otherwise false
	 * @param ordered true if the collection shall be ordered otherwise false
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
	 * @param unique true if the collection shall be unique otherwise false
	 * @param ordered true if the collection shall be ordered otherwise false
	 * @param context the implementation context
	 * @return the transformed or standard collection type as String
	 *         representation
	 */
	public String getMappingType(Boolean unique, Boolean ordered, String context) {
		return getCollectionTypeMapping(unique, ordered, context);
	}
	
	/**
	 * Private method which checks if a context is given or not. Furthermore, it
	 * returns the language specific primitive type or the model type if no
	 * transformation settings exists.
	 * 
	 * @param map the type which shall be transformed (model type)
	 * @param context the implementation context or null
	 * @return the language specific type or the model type as String
	 *         representation
	 */
	private String getPrimitiveTypeMapping(String map, String context) {
		PrimitiveMappingType pmt = new PrimitiveMappingType(map, "");
		String to = null;
		
		if (context == null)
			to = primitiveTypeManager.getTypeMapping(pmt);
		else
			to = primitiveTypeManager.getTypeMapping(pmt, context);
		return decideValue(map, to);
	}
	
	/**
	 * Private method which checks if a context is given or not. Furthermore, it
	 * returns the language specific collection type or a empty string if no
	 * transformation settings exists.
	 * 
	 * @param unique true if the collection shall be unique otherwise false
	 * @param ordered true if the collection shall be ordered otherwise false
	 * @param context the implementation context or null
	 * @return the language specific type or a empty string as String
	 *         representation
	 */
	private String getCollectionTypeMapping(Boolean unique, Boolean ordered, String context) {
		CollectionMappingType cmt = new CollectionMappingType(unique, ordered, "");
		String to = null;
		
		if (context == null)
			to = collectionTypeManager.getTypeMapping(cmt);
		else
			to = collectionTypeManager.getTypeMapping(cmt, context);
		return decideValue("", to);
	}
	
	/**
	 * Private method which checks if a context is given or not. Furthermore, it
	 * returns the language specific external type or the model type if no
	 * transformation settings exists.
	 * 
	 * @param map the type which shall be transformed (model type)
	 * @param context the implementation context or null
	 * @return the language specific type or the model type as String
	 *         representation
	 */
	private String getExternalTypeMapping(String map, String context) {
		ExternalMappingType emt = new ExternalMappingType(map, "");
		String to = null;
		
		if (context == null)
			to = externalTypeManager.getTypeMapping(emt);
		else
			to = externalTypeManager.getTypeMapping(emt, context);
		return decideValue(map, to);
	}
	
	/**
	 * This method decide if the model type or the language specific type will
	 * be returned. If the language specific type is null, then the model type
	 * will be returned, otherwise the language specific type.
	 * 
	 * @param map the type which shall be transformed (model type)
	 * @param to the language specific type
	 * @return the model type or the language specific type
	 */
	private String decideValue(String map, String to) {
		if (to != null) {
			return to;
		} else {
			return map;
		}
	}
	
	/**
	 * This static method initializes the type mapper. Please call this function
	 * before the beginning of the model to text transformation.
	 * 
	 * @param typeMappingFile the type mapping file
	 * @return singleton type mapper instance
	 */
	public static TypeMapper initTypeMapper(String typeMappingFile) {
		if (typeMapper == null) {
			typeMapper = new TypeMapper(typeMappingFile);
		}
		return typeMapper;
	}
	
	/**
	 * Sole method to get the preconfigured type mapper.
	 * 
	 * @return singleton type mapper instance
	 */
	public static TypeMapper getInstance() {
		if (typeMapper == null) {
			typeMapper = new TypeMapper("de/genesez/common/typemapping/typeMapping.xml");
		}
		return typeMapper;
	}
	
	/**
	 * This class parse a type mapping file and search for collection types.
	 * 
	 * @author nihe
	 */
	private class CollectionTypeXMLReader extends XMLTypeMappingReader<CollectionMappingType> {
		
		/**
		 * Sole constructor which tells the super constructor to search for
		 * collection types.
		 */
		public CollectionTypeXMLReader() {
			super(collectionTypeManager, "collectionTypes");
		}
		
		/**
		 * This method creates a new collection type.
		 * 
		 * @see de.genesez.platforms.common.typemapping.XMLTypeMappingReader#buildMappingType(org.dom4j.Element)
		 */
		protected CollectionMappingType buildMappingType(Element mappingElement) {
			CollectionMappingType cmt = null;
			
			Boolean unique = null;
			if (mappingElement.attributeValue("unique") != null)
				unique = new Boolean(mappingElement.attributeValue("unique"));
			Boolean ordered = null;
			if (mappingElement.attributeValue("ordered") != null)
				ordered = new Boolean(mappingElement.attributeValue("ordered"));
			String defaultType = getDefaultType(mappingElement);
			cmt = new CollectionMappingType(unique, ordered, defaultType);
			return cmt;
		}
		
	}
	
	/**
	 * This class parse a type mapping file and search for primitive types.
	 * 
	 * @author nihe
	 */
	private class PrimitiveTypeXMLReader extends XMLTypeMappingReader<PrimitiveMappingType> {
		
		/**
		 * Sole constructor which tells the super constructor to search for
		 * primitive types.
		 */
		public PrimitiveTypeXMLReader() {
			super(primitiveTypeManager, "primitiveTypes");
		}
		
		/**
		 * This method creates a new primitive type.
		 * 
		 * @see de.genesez.platforms.common.typemapping.XMLTypeMappingReader#buildMappingType(org.dom4j.Element)
		 */
		protected PrimitiveMappingType buildMappingType(Element mappingElement) {
			PrimitiveMappingType pmt = null;
			
			String map = mappingElement.elementText("map");
			String defaultType = getDefaultType(mappingElement);
			pmt = new PrimitiveMappingType(map, defaultType);
			return pmt;
		}
		
	}
	
	/**
	 * This class parse a type mapping file and search for external types.
	 * 
	 * @author nihe
	 */
	private class ExternalTypeXMLReader extends XMLTypeMappingReader<ExternalMappingType> {
		
		/**
		 * Sole constructor which tells the super constructor to search for
		 * external types.
		 */
		public ExternalTypeXMLReader() {
			super(externalTypeManager, "externalTypes");
		}
		
		/**
		 * This method creates a new external type.
		 * 
		 * @see de.genesez.platforms.common.typemapping.XMLTypeMappingReader#buildMappingType(org.dom4j.Element)
		 */
		protected ExternalMappingType buildMappingType(Element mappingElement) {
			ExternalMappingType emt = null;
			
			String map = mappingElement.elementText("map");
			String defaultType = getDefaultType(mappingElement);
			emt = new ExternalMappingType(map, defaultType);
			return emt;
		}
		
	}
	
}
