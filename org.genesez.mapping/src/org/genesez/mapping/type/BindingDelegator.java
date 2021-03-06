package org.genesez.mapping.type;

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
import org.genesez.mapping.type.types.FileContainer;
import org.genesez.mapping.type.types.MappingBody;

import javax.xml.validation.Schema;
import javax.xml.bind.Unmarshaller;
import javax.xml.xpath.XPath;
import javax.xml.bind.JAXBElement;
import java.io.FileInputStream;
import javax.xml.validation.SchemaFactory;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;

/**
 * This class initiates all Binding preconditions and delegates all binding components to the consumers.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public class BindingDelegator {
	
	/**
	 * Binding context to do I/O implicitly with XML data.
	 */
	private JAXBContext bindingContext;
	
	/**
	 * Unmarshaller to fill the Java Beans through XML.
	 */
	private Unmarshaller unmarshaller;
	
	/**
	 * Document builder to create subtrees of the DOM.
	 */
	private DocumentBuilder documentBuilder;
	
	/**
	 * XPath to navigate in the DOM tree.
	 */
	private XPath xPath;
	
	/**
	 * Using log4j-mechanism for error logging.
	 */
	private Log log = LogFactory.getLog(getClass());
	
	/**
	 * Creates a JAXBContext based on the contextpath creates an unmarshaller of the context.
	 * 
	 * @param	bindingContextPath	The context path.
	 */
	public BindingDelegator(String bindingContextPath) {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324559646139_438036_5007) ENABLED START */
		try {
			bindingContext = JAXBContext.newInstance(bindingContextPath);
			unmarshaller = bindingContext.createUnmarshaller();
			// register the schema or a ValidationEventHandler... or both to be
			// on the save side
			Schema schema = SchemaFactory.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(ClassLoader.getSystemResource("org/genesez/mapping/type/typemapping.xsd"));
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
	
	/**
	 * Creates the XPath to navigate in an XML document.
	 * 
	 * @return	The XPath with the namespace specified in the NamespaceContext class.
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
	 * Creates a DocumentBuilder with Namespace awarness.
	 * 
	 * @return	An instance of DocumentBuilder.
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
	 * Gets the mapping body of a type mapping file which is linked to the typeMapping tag.
	 * 
	 * @param	mappingFile	The type mapping file which gets unmarshalled.
	 * @return	The mapping body of the type mapping file.
	 */
	public MappingBody getMappingBody(String mappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559708410_993818_5037) ENABLED START */
		// TODO getMappingBody and getFileContainerByXPath need a refactoring to use
		// one generic method instead of these two
		JAXBElement<MappingBody> element;
		try {
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
	 * Gets the FileContainer of a type mapping file specified by an XPath expression.
	 * 
	 * @param	mappingFile		The type mapping file which gets unmarshalled.
	 * @param	xPathExpression	The XPath expression to navigate to the FileContainer.
	 * @return	The FileContainer of the type mapping file.
	 */
	public FileContainer getFileContainerByXPath(String mappingFile, String xPathExpression) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559750619_530096_5049) ENABLED START */
		// TODO getMappingBody and getFileContainerByXPath need a refactoring to use
		// one generic method instead of these two
		try {
			InputStream input = null;
			if (Paths.get(mappingFile).isAbsolute()) {
				input = new FileInputStream(new File(mappingFile));
			} else {
				input = ClassLoader.getSystemResourceAsStream(mappingFile);
			}
			
			// check if input is still null -> file not found
			if (input == null) {
				throw new FileNotFoundException(mappingFile);
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
	 * This method is used to log exceptions.
	 * 
	 * @param	e		The thrown exception.
	 * @param	cause	The probable problem.
	 */
	private void exceptionLogging(Exception e, String cause) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324559799650_344921_5061) ENABLED START */
		if (cause != null) {
			log.error("Type Mapping: " + cause);
		}
		log.error("Type Mapping: " + e.toString());
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324558508923_815444_4801) ENABLED START */
	/* PROTECTED REGION END */
}
