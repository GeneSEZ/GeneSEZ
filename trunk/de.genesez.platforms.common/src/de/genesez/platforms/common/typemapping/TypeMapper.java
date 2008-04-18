package de.genesez.platforms.common.typemapping;

import genesezMM.MClassifier;
import genesezMM.MExternal;
import genesezMM.MGeneric;
import genesezMM.MPrimitiveType;
import genesezMM.MType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import de.genesez.platforms.common.typemapping.mappingtypes.CollectionMappingType;
import de.genesez.platforms.common.typemapping.mappingtypes.ExternalMappingType;
import de.genesez.platforms.common.typemapping.mappingtypes.PrimitiveMappingType;

public class TypeMapper {
	
	/** Singleton type mapper instance. */
	private static TypeMapper typeMapper = null;
	
	/** Logger instance. */
	private final Log log = LogFactory.getLog(getClass());

	/** type mapping manager for type mappings */
	private ITypeMappingManager<CollectionMappingType> collectionTypeManager = null;
	private ITypeMappingManager<PrimitiveMappingType> primitiveTypeManager = null;
	private ITypeMappingManager<ExternalMappingType> externalTypeManager = null;
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * normal methods for type mapping
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public String getMappingName(MType type) {
		return getMappingName(type, null);
	}
	
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

	public String getMappingType(Boolean unique, Boolean ordered) {
		return getMappingType(unique, ordered, null);
	}
	
	public String getMappingType(Boolean unique, Boolean ordered, String context) {
		return getCollectionTypeMapping(unique, ordered, context);
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * private methods for type mapping manager
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
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
	
	private String getPrimitiveTypeMapping(String map, String context) {
		PrimitiveMappingType pmt = new PrimitiveMappingType(map, "");
		String to = null;
		
		if (context == null)
			to = primitiveTypeManager.getTypeMapping(pmt);
		else
			to = primitiveTypeManager.getTypeMapping(pmt, context);
		return decideValue(map, to);
	}
	
	private String getExternalTypeMapping(String map, String context) {
		ExternalMappingType emt = new ExternalMappingType(map, "");
		String to = null;
		
		if (context == null)
			to = externalTypeManager.getTypeMapping(emt);
		else
			to = externalTypeManager.getTypeMapping(emt, context);
		return decideValue(map, to);
	}
		
	private String decideValue(String map, String to) {
		if (to != null) {
			return to;
		} else {
			return map;
		}
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * singleton instance creator and init method for TypeMapper class
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public static TypeMapper initTypeMapper(String typeMappingFile) {
		if (typeMapper == null) {
			typeMapper = new TypeMapper(typeMappingFile);
		}
		return typeMapper;
	}

	public static TypeMapper getInstance() {
		if (typeMapper == null) {
			typeMapper = new TypeMapper("../de.genesez.platforms.common/script/de/genesez/common/typemapping/typeMapping.xml");
		}
		return typeMapper;
	}
	
	public static void main(String[] args) {
		TypeMapper.getInstance();
	}

	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * singleton instance creator and init method for TypeMapper class
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	private class CollectionTypeXMLReader extends XMLTypeMappingReader<CollectionMappingType> {

		public CollectionTypeXMLReader() {
			super(collectionTypeManager, "collectionTypes");
		}
		
		@Override
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
	
	private class PrimitiveTypeXMLReader extends XMLTypeMappingReader<PrimitiveMappingType> {

		public PrimitiveTypeXMLReader() {
			super(primitiveTypeManager, "primitiveTypes");
		}
		
		@Override
		protected PrimitiveMappingType buildMappingType(Element mappingElement) {
			PrimitiveMappingType pmt = null;
			
			String map = mappingElement.elementText("map");
			String defaultType = getDefaultType(mappingElement);
			pmt = new PrimitiveMappingType(map, defaultType);
			return pmt;
		}
		
	}
	
	private class ExternalTypeXMLReader extends XMLTypeMappingReader<ExternalMappingType> {

		public ExternalTypeXMLReader() {
			super(externalTypeManager, "externalTypes");
		}
		
		@Override
		protected ExternalMappingType buildMappingType(Element mappingElement) {
			ExternalMappingType emt = null;
			
			String map = mappingElement.elementText("map");
			String defaultType = getDefaultType(mappingElement);
			emt = new ExternalMappingType(map, defaultType);
			return emt;
		}
		
	}
	
}
