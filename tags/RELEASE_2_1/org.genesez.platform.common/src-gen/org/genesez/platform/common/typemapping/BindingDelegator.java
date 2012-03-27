package org.genesez.platform.common.typemapping;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324558508923_815444_4801) 
 */

import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import java.nio.file.Paths;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPathConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.SAXException;
import java.io.File;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import javax.xml.validation.Schema;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.bind.JAXBElement;
import java.io.FileInputStream;
import javax.xml.validation.SchemaFactory;

import org.genesez.platform.common.typemapping.types.FileContainer;
import org.genesez.platform.common.typemapping.types.MappingBody;
import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * This class initiates all Binding preconditions and delegates all binding components to the consumers
 */
public class BindingDelegator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Binding Context to do IO implicitly with XML data
	 */
	private JAXBContext bindingContext;
	
	/**
	 * to fill the Java Beans through XML
	 */
	private Unmarshaller unmarshaller;
	
	/**
	 * to create subtrees of the DOM
	 */
	private DocumentBuilder documentBuilder;
	
	/**
	 * to navigate in the DOM tree
	 */
	private XPath xPath;
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private Log log = LogFactory.getLog(getClass());
	
	// -- generated constructors --------------------------------------------
	/**
	 * creates a JAXBContext based on the contextpath creates an unmarshaller of the context
	 * @param	bindingContextPath	the context path
	 */
	public BindingDelegator(String bindingContextPath) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324559646139_438036_5007) ENABLED START */
		try {
			bindingContext = JAXBContext.newInstance(bindingContextPath);
			unmarshaller = bindingContext.createUnmarshaller();
			// register the schema or a ValidationEventHandler... or both to be
			// on the save side
			Schema schema = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(ClassLoader.getSystemResource("org/genesez/platform/common/typemapping/typemapping.xsd"));
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new ErrorLoggingValidationEventHandler());
			documentBuilder = createDocumentBuilder();
			xPath = createXPath();
		} catch (JAXBException e) {
			exceptionLogging(e, "Unable to create essential JAXB resources");
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			exceptionLogging(e, "unable to instantiate a documentBuilder");
			throw new RuntimeException(e);
		} catch (SAXException e) {
			exceptionLogging(e, "Unable to set the Schema");
			throw new RuntimeException(e);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Creates the XPath to navigate in an XML document
	 * @return	the XPath with the namespace specified in the NamespaceContext class)
	 */
	private XPath createXPath() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559665684_20148_5014) ENABLED START */
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		xpath.setNamespaceContext(new TypemappingNamespaceContext());
		return (xpath);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a Documentbuilder with Namespace awarness
	 * @return	an instance of Documentbuilder
	 * @throws	ParserConfigurationException
	 */
	private DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559679465_49455_5022) ENABLED START */
		DocumentBuilderFactory documentBuilderfactory = DocumentBuilderFactory.newInstance();
		documentBuilderfactory.setNamespaceAware(true);
		return documentBuilderfactory.newDocumentBuilder();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Gets the Mappingbody of a typeMapping xml file which is linked to the typeMapping tag
	 * @param	mappingFile	the typeMapping file which gets unmarshalled
	 * @return	the Mappingbody of the typeMappingfile
	 */
	public MappingBody getMappingBody(String mappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559708410_993818_5037) ENABLED START */
		// TODO getMappingBody and getFileContainerByXPath need a refactoring to use
		// one generic method instead of these two
		
		JAXBElement<MappingBody> element;
		try {
			// element = (JAXBElement)unmarshaller.unmarshal(new
			// File(mappingFile)); 
			InputStream input = null;
			if (Paths.get(mappingFile).isAbsolute()) {
				input = new FileInputStream(new File(mappingFile));
			} else {
				input = ClassLoader.getSystemResourceAsStream(mappingFile);
			}
			element = (JAXBElement) unmarshaller.unmarshal(input);
			return element.getValue();
		} catch (JAXBException e) {
			exceptionLogging(e, "error occured during unmarshalling");
			return null;
		} catch (FileNotFoundException e) {
			exceptionLogging(e, "File could not be found");
			return null;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * gets the FileContainer of a typeMapping file specified by an XPath Expression
	 * @param	mappingFile	the typeMapping file which gets unmarshalled
	 * @param	xPathExpression	the XPath expression to navigate to the FileContainer
	 * @return	the fileContainer of the typeMapping file
	 */
	public FileContainer getFileContainerByXPath(String mappingFile, String xPathExpression) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559750619_530096_5049) ENABLED START */
		// TODO getMappingBody and getFileContainerByXPath need a refactoring to use
		// one generic method instead of these two
		
		try {
			
			// Document typeMappingDoc = documentBuilder.parse(new
			// File(mappingFile));
			
			InputStream input = null;
			if (Paths.get(mappingFile).isAbsolute()) {
				input = new FileInputStream(new File(mappingFile));
			} else {
				input = ClassLoader.getSystemResourceAsStream(mappingFile);
			}
			
			Document typeMappingDoc = documentBuilder.parse(input);
			Node includeNode = (Node) xPath.evaluate(xPathExpression, typeMappingDoc, XPathConstants.NODE);
			if (includeNode != null) {
				JAXBElement<FileContainer> element;
				element = unmarshaller.unmarshal(includeNode, FileContainer.class);
				return element.getValue();
			}
		} catch (SAXException e) {
			exceptionLogging(e, "file cannot be parsed");
		} catch (IOException e) {
			exceptionLogging(e, "error occured during file access");
		} catch (XPathExpressionException e) {
			exceptionLogging(e, "error occured during accessing the document node via XPath");
		} catch (JAXBException e) {
			exceptionLogging(e, "error occured during unmarshalling");
		}
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * exceptionLogging method to log Exceptions
	 * @param	e	thrown exception
	 * @param	cause	probable problem
	 */
	
	private void exceptionLogging(Exception e, String cause) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559799650_344921_5061) ENABLED START */
		if (cause != null) {
			log.error("Type Mapping: " + cause);
		}
		log.error("Type Mapping: " + e.getStackTrace());
		log.info("Type Mapping: " + e.toString());
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324558508923_815444_4801) ENABLED START */
	/* PROTECTED REGION END */
	
}
