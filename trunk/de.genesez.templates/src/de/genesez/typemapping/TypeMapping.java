package de.genesez.typemapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class TypeMapping {

	/**
	 * Returns the type map. This is the top method for type mapping when no
	 * context is defined.
	 * 
	 * @param xmlFile
	 * @param map
	 * @return
	 */
	public static String typeMapping(String xmlFile, String map) {
		return typeMapping(xmlFile, map, null);
	}

	/**
	 * Returns the type map. This is the top method for type mapping.
	 * 
	 * @param xmlFile
	 * @param map
	 * @param context
	 * @return
	 */
	public static String typeMapping(String xmlFile, String map, String context) {
		try {
			//System.out.println("Search in File: " + xmlFile);
			Document doc = getDocument(xmlFile);
			
			String mappingType = getMappingType(doc, map, context);
			if (mappingType != null) {
				return mappingType;
			} else if (!getSuperMappingFile(doc).equals("")) {
				// Rekursion
				return typeMapping(getSuperMappingFile(doc), map, context);
			} else {
				return map;
			}
		} catch (Exception e) {
			System.out.println("Genesez-Gen: " + e.toString());
		}
		// if an error occurs, the parameter _map will returned
		return map;
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns the xml document.
	 * 
	 * @param xmlFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
	 */
	private static Document getDocument(String xmlFile) throws FileNotFoundException, DocumentException, IOException {
		FileReader fileReader = new FileReader(xmlFile);
		SAXReader saxReader = new SAXReader(true);
		Document doc = saxReader.read(new InputSource(fileReader));
		fileReader.close();
		return doc;
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns the xml file witch is used when no mapping type was found.
	 * 
	 * @param doc
	 * @return
	 */
	private static String getSuperMappingFile(Document doc) {
		Element header;

		header = getXMLHeader(getXMLRoot(doc));
		return getValue(getXMLSuperMappingFile(header));
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Find the right type map for the given map and context.
	 * 
	 * @param doc
	 * @param map
	 * @param context
	 * @return
	 */
	private static String getMappingType(Document doc, String map, String context) {
		List mappings;
		Element mapping;
		Element defaultType;
		Element contextType;

		mappings = getXMLMappings(getXMLRoot(doc));
		Iterator it = mappings.iterator();
		while (it.hasNext()) {
			mapping = (Element) it.next();

			if (isSearchedMap(mapping, map)) {
				defaultType = getDefaultType(mapping);
				contextType = getContextType(mapping, context);
				return getCorrectMappingType(defaultType, contextType);
			}
		}
		return null;
	}

	/**
	 * If the context type isn't null then the return value is the context type
	 * else the default type.
	 * 
	 * @param defaultType
	 * @param contextType
	 * @return
	 */
	private static String getCorrectMappingType(Element defaultType, Element contextType) {
		if (contextType != null) {
			return getValue(getXMLType(contextType));
		} else if (defaultType != null) {
			return getValue(defaultType);
		} else {
			return null;
		}
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns the default type.
	 * 
	 * @param mapping
	 * @return
	 */
	private static Element getDefaultType(Element mapping) {
		return getXMLDefaultType(mapping);
	}

	/**
	 * Returns the context type witch is equals to the searched context.
	 * 
	 * @param mapping
	 * @param context
	 * @return
	 */
	private static Element getContextType(Element mapping, String context) {
		List contextTypes = null;
		Element detectedContextType = null;

		contextTypes = getXMLContextTypes(mapping);
		Iterator it = contextTypes.iterator();
		while (it.hasNext()) {
			detectedContextType = (Element) it.next();
			if (isSearchedContextType(detectedContextType, context)) {
				return detectedContextType;
			}
		}
		return null;
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns true if the searched map is equals the actual map else other.
	 * 
	 * @param mapping
	 * @param map
	 * @return
	 */
	private static boolean isSearchedMap(Element mapping, String map) {
		return getValue(getXMLMap(mapping)).equals(map);
	}

	/**
	 * Returns true if the searched context is equals the actual context else
	 * other.
	 * 
	 * @param contextType
	 * @param context
	 * @return
	 */
	private static boolean isSearchedContextType(Element contextType, String context) {
		return getValue(getXMLContext(contextType)).equals(context);
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns the root melement of this mapping file
	 * [TemplateMapping]...[/TemplateMapping].
	 * 
	 * @param doc
	 * @return
	 */
	private static Element getXMLRoot(Document doc) {
		return doc.getRootElement();
	}

	/**
	 * Returns the header element [Header]...[/Header].
	 * 
	 * @param root
	 * @return
	 */
	private static Element getXMLHeader(Element root) {
		return root.element("Header");
	}

	/**
	 * Returns the super mapping file [SuperMappingFile]...[/SuperMappingFile].
	 * of this mapping file.
	 * 
	 * @param header
	 * @return
	 */
	private static Element getXMLSuperMappingFile(Element header) {
		return header.element("SuperMappingFile");
	}

	/**
	 * Returns a list of mapping entries [Mapping*]...[/Mapping*].
	 * 
	 * @param root
	 * @return
	 */
	private static List getXMLMappings(Element root) {
		return root.elements("Mapping");
	}

	/**
	 * Returns the map element [Map]...[/Map].
	 * 
	 * @param mapping
	 * @return
	 */
	private static Element getXMLMap(Element mapping) {
		return mapping.element("Map");
	}

	/**
	 * Returns the default mapping type [DefaultType]...[/DefaultType].
	 * 
	 * @param mapping
	 * @return
	 */
	private static Element getXMLDefaultType(Element mapping) {
		return mapping.element("DefaultType");
	}

	/**
	 * Returns a list ofcontext types [ContextType*]...[/ContextType*].
	 * 
	 * @param mapping
	 * @return
	 */
	private static List getXMLContextTypes(Element mapping) {
		return mapping.elements("ContextType");
	}

	/**
	 * Returns the mapping context [Context]...[/Context].
	 * 
	 * @param contextType
	 * @return
	 */
	private static Element getXMLContext(Element contextType) {
		return contextType.element("Context");
	}

	/**
	 * Returns the context mapping type [Type]...[/Type].
	 * 
	 * @param contextType
	 * @return
	 */
	private static Element getXMLType(Element contextType) {
		return contextType.element("Type");
	}

	// //////////////////////////////////////////////////////////////////////////////

	/**
	 * Returns the string value of an xml element.
	 * 
	 * @param e
	 * @return
	 */
	private static String getValue(Element e) {
		return e.getStringValue();
	}

	// //////////////////////////////////////////////////////////////////////////////

}
