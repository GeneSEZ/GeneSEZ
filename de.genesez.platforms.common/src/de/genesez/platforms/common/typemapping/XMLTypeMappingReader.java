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

public abstract class XMLTypeMappingReader<T extends MappingType> {
	
	/** Logger instance. */
	private final Log log = LogFactory.getLog(getClass());

	private ITypeMappingManager<T> manager = null;
	private String nameOfMappingTypes = null;
		
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * constructor 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
		
	public XMLTypeMappingReader(ITypeMappingManager<T> manager, String nameOfMappingTypes) {
		this.manager = manager;
		this.nameOfMappingTypes = nameOfMappingTypes;
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * abstract methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	protected abstract T buildMappingType(Element mappingElement);
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 * public methods 
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	public void parseTypeMappingFile(String typeMappingFile) {
		Element root = null;
		Element header = null;
		
		String superMappingFile = "";
		
		try {
			log.info("Type Mapping: type mapping with file " + typeMappingFile);
			root = getXMLRoot(getXMLDocument(typeMappingFile));
			header = getHeader(root);

			storeMappingElementsInManager(root);
			
			superMappingFile = header.elementText("superMappingFile");
			if (!superMappingFile.equals("")) {
				log.info("Type Mapping: recursion of type mapping with file " + superMappingFile); 
				parseTypeMappingFile(superMappingFile);
			}
		} catch (Exception ex) {
			log.error("Type Mapping: " + ex.getStackTrace());
			log.error("Type Mapping: " + ex.toString());
		}
		
	}
	
	protected String getDefaultType(Element mappingElement) {
		return mappingElement.elementText("defaultType");
	}
		
	private void storeMappingElementsInManager(Element root) {
		List mappingElements = null;
		Element mappingElement = null;
		
		mappingElements = getMappingElements(root);
		Iterator it = mappingElements.iterator();
		while(it.hasNext()) {
			mappingElement = (Element)it.next();
			T mappingType = buildMappingType(mappingElement);
			storeContextTypes(mappingType, mappingElement);
			// store type mapping in manager
			manager.addMappingType(mappingType);
		}
	}
	
	private void storeContextTypes(T mappingType, Element mappingElement) {
		List contextTypes = null;
		Element contextType = null;
		String context = null;
		String type = null;
		
		contextTypes = getContextTypes(mappingElement);
		Iterator it = contextTypes.iterator();
		while(it.hasNext()) {
			contextType = (Element)it.next();
			context = contextType.elementText("context");
			type = contextType.elementText("type");
			mappingType.addContextType(context, type);
		}
	}
		
	private Element getHeader(Element root) {
		return root.element("header");
	}
	
	private List getMappingElements(Element root) {
		return root.element(nameOfMappingTypes).elements("mappingElement");
	}
	
	private List getContextTypes(Element mappingElement) {
		return mappingElement.elements("contextType");
	}
	
	/*
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 *  
	 * - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	 */
	
	/**
	 * Returns the xml document.
	 * 
	 * @param xmlFile
	 * @return
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 * @throws IOException
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
	 * Returns the root element of this mapping file
	 * [typeMapping]...[/typeMapping].
	 * 
	 * @param doc
	 * @return
	 */
	private Element getXMLRoot(Document doc) {
		return doc.getRootElement();
	}
	
}
