package de.genesez.platforms.common.typemapping;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import de.genesez.platforms.common.typemapping.mappingtypes.MappingType;

/**
 * This class parse a XML type mapping file.
 * 
 * @author nihe
 * @param <T> the specific mapping type
 * @todo enable validation
 * @date 2008-02-18
 */
public abstract class XMLTypeMappingReader<T extends MappingType> implements ITypeMappingReader {
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private final Log log = LogFactory.getLog(getClass());
	
	/**
	 * The type mapping manager which manages all type mappings.
	 */
	private ITypeMappingManager<T> manager = null;
	
	/**
	 * The name of the specific type mapping type, e.g. collectionTypes,
	 * primitiveTypes and so on.
	 */
	private String nameOfMappingTypes = null;
	
	/**
	 * Sole constructor which set the type mapping manager and the type of
	 * mapping types, e.g. primitiveTypes, externalTypes and so on.
	 * 
	 * @param manager
	 * @param nameOfMappingTypes
	 */
	public XMLTypeMappingReader(ITypeMappingManager<T> manager, String nameOfMappingTypes) {
		this.manager = manager;
		this.nameOfMappingTypes = nameOfMappingTypes;
	}
	
	/**
	 * This abstract method creates a new specific type mapping type, e.g.
	 * primitiveTypes, externalTypes and so on.
	 * 
	 * @param mappingElement the parent element (<mappingElement> ...
	 *            </mappingElement>)
	 * @return a new specific type mapping type which stores the transformation
	 *         settings
	 */
	protected abstract T buildMappingType(Element mappingElement);
	
	/**
	 * This method starts the parsing of a XML type mapping file.
	 * 
	 * @param typeMappingFile the XML type mapping file
	 */
	public void parseTypeMappingFile(String typeMappingFile) {
		Element root = null;
		Element header = null;
		
		String superTypeMappingFile = "";
		
		try {
			log.info("Type Mapping: type mapping with file " + typeMappingFile);
			root = getXMLRoot(getXMLDocument(typeMappingFile));
			header = getHeader(root);
			
			storeMappingElementsInManager(root);
			
			superTypeMappingFile = header.elementText("superMappingFile");
			if (!superTypeMappingFile.equals("")) {
				log.info("Type Mapping: recursion of type mapping with file " + superTypeMappingFile);
				parseTypeMappingFile(superTypeMappingFile);
			}
		} catch (Exception ex) {
			log.error("Type Mapping: " + ex.getStackTrace());
			log.error("Type Mapping: " + ex.toString());
		}
		
	}
	
	/**
	 * Getter for the default language specific type.
	 * 
	 * @param mappingElement the parent element (<mappingElement> ...
	 *            </mappingElement>)
	 * @return the default language specific type as String representation
	 */
	protected String getDefaultType(Element mappingElement) {
		return mappingElement.elementText("defaultType");
	}
	
	/**
	 * This method stores all type mappings from a specific mapping type in
	 * the type mapping manager.
	 * 
	 * @param root the parent element (<typeMapping> ... </typeMapping>)
	 */
	private void storeMappingElementsInManager(Element root) {
		List mappingElements = null;
		Element mappingElement = null;
		
		mappingElements = getMappingElements(root);
		Iterator it = mappingElements.iterator();
		while (it.hasNext()) {
			mappingElement = (Element) it.next();
			T mappingType = buildMappingType(mappingElement);
			storeContextTypes(mappingType, mappingElement);
			// store type mapping in manager
			manager.addMappingType(mappingType);
		}
	}
	
	/**
	 * This method is called from the storeMappingElementsInManager(Element
	 * root) method to store all context specific type mappings in the type
	 * mapping manager.
	 * 
	 * @param mappingType the specific mapping type
	 * @param mappingElement the parent element (<mappingElement> ...
	 *            </mappingElement>)
	 */
	private void storeContextTypes(T mappingType, Element mappingElement) {
		List contextTypes = null;
		Element contextType = null;
		String context = null;
		String type = null;
		
		contextTypes = getContextTypes(mappingElement);
		Iterator it = contextTypes.iterator();
		while (it.hasNext()) {
			contextType = (Element) it.next();
			context = contextType.elementText("context");
			type = contextType.elementText("type");
			mappingType.addContextType(context, type);
		}
	}
	
	/**
	 * Returns the header of a XML type mapping file. The header includes the
	 * information about the super type mapping file.
	 * 
	 * @param root the parent element (<typeMapping> ... </typeMapping>)
	 * @return the header element (<header> ... </header>)
	 */
	private Element getHeader(Element root) {
		return root.element("header");
	}
	
	/**
	 * This method returns a list of type mappings based on a specific type
	 * mapping type, e.g. primitiveTypes, externalTypes and so on.
	 * 
	 * @param root the parent element (<typeMapping> ... </typeMapping>)
	 * @return a list of type mappings as List representation
	 */
	private List getMappingElements(Element root) {
		return root.element(nameOfMappingTypes).elements("mappingElement");
	}
	
	/**
	 * This method returns a list of context type mapping elements (<contextType>
	 * ... </contextType>).
	 * 
	 * @param mappingElement the parent element (<mappingElement> ...
	 *            </mappingElement>)
	 * @return a list of context type mappings as List representation
	 */
	private List getContextTypes(Element mappingElement) {
		return mappingElement.elements("contextType");
	}
	
	/**
	 * Create a Document class instance from a XML type mapping file.
	 * 
	 * @param typeMappingFile the XML type mapping file
	 * @return the XML type mapping file as Document class representation
	 * @throws FileNotFoundException this exception is thrown when the file
	 *             doesn't exists
	 * @throws DocumentException this exception is thrown when an error occurs
	 *             during the processing of a DOM4J document
	 * @throws IOException this exception is thrown when any I/O error occurs
	 */
	private Document getXMLDocument(String typeMappingFile) throws FileNotFoundException, DocumentException, IOException {
		FileReader fileReader = new FileReader(typeMappingFile);
		// Validation disabled
		SAXReader saxReader = new SAXReader(false);
		Document doc = saxReader.read(new InputSource(fileReader));
		fileReader.close();
		return doc;
	}
	
	/**
	 * This method returns the root element (<typeMapping>...</typeMapping>)
	 * of a XML mapping file.
	 * 
	 * @param doc the XML type mapping file as Document class representation
	 * @return the root element of a file
	 */
	private Element getXMLRoot(Document doc) {
		return doc.getRootElement();
	}
	
}
