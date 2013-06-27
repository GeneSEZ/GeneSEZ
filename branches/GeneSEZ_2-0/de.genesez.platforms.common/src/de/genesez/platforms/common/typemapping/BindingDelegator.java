package de.genesez.platforms.common.typemapping;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import de.genesez.platforms.common.typemapping.types.FileContainer;
import de.genesez.platforms.common.typemapping.types.MappingBody;

/**
 * This class initiates all Binding preconditions and delegates all binding
 * components to the consumers
 * 
 * @author pethu
 * @author toh (last)
 * @date 2009-01-24
 */
public class BindingDelegator {
	
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
	private final Log log = LogFactory.getLog(getClass());

	/**
	 * creates a JAXBContext based on the contextpath creates an unmarshaller of
	 * the context
	 * 
	 * @param bindingContextPath
	 */
	public BindingDelegator(String bindingContextPath) {
		try {
			bindingContext = JAXBContext.newInstance(bindingContextPath);
			unmarshaller = bindingContext.createUnmarshaller();
			// register the schema or a ValidationEventHandler... or both to be
			// on the save side
			Schema schema = SchemaFactory
					.newInstance(javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI)
					.newSchema(ClassLoader.getSystemResource(
							"de/genesez/platforms/common/typemapping/typemapping.xsd"));
			unmarshaller.setSchema(schema);
			unmarshaller.setEventHandler(new ErrorLoggingValidationEventHandler());
			documentBuilder = createDocumentBuilder();
			xPath = createXPath();
		} catch (JAXBException e) {
			ExceptionLogging(e, "Unable to create essential JAXB resources");
			throw new RuntimeException(e);
		} catch (ParserConfigurationException e) {
			ExceptionLogging(e, "unable to instantiate a documentBuilder");
			throw new RuntimeException(e);
		} catch (SAXException e) {
			ExceptionLogging(e, "Unable to set the Schema");
			throw new RuntimeException(e);
		}
	}

	/**
	 * Creates the XPath to navigate in an XML document
	 * 
	 * @return the XPath with the namespace specified in the NamespaceContext
	 *         class)
	 */
	private XPath createXPath() {
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		xpath.setNamespaceContext(new TypemappingNamespaceContext());
		return (xpath);
	}

	/**
	 * Creates a Documentbuilder with Namespace awarness
	 * 
	 * @return an instance of Documentbuilder
	 */
	private DocumentBuilder createDocumentBuilder()
			throws ParserConfigurationException {
		DocumentBuilderFactory documentBuilderfactory = DocumentBuilderFactory
				.newInstance();
		documentBuilderfactory.setNamespaceAware(true);
		return documentBuilderfactory.newDocumentBuilder();
	}

	// TODO getMappingBody and getFileContainerByXPath need a refactoring to use
	// one generic method instead of these two
	/**
	 * gets the Mappingbody of a typeMapping xml file which is linked to the
	 * typeMapping tasg
	 * 
	 * @param mappingFile
	 *            the typeMapping file which gets unmarshalled
	 * @return the Mappingbody of the typeMappingfile
	 */
	public MappingBody getMappingBody(String mappingFile) {
		JAXBElement<MappingBody> element;
		try {
			// element = (JAXBElement)unmarshaller.unmarshal(new
			// File(mappingFile));
			element = (JAXBElement) unmarshaller.unmarshal(ClassLoader
					.getSystemResourceAsStream(mappingFile));
			return element.getValue();
		} catch (JAXBException e) {
			ExceptionLogging(e, "error occured during unmarshalling");
			return null;
		}

	}

	/**
	 * gets the FileContainer of a typeMapping file specified by an XPath
	 * Expression
	 * 
	 * @param mappingFile
	 *            the typeMapping file which gets unmarshalled
	 * @param xPathExpression
	 *            the XPath expression to navigate to the FileContainer
	 * @return the fileContainer of the typeMapping file
	 */
	public FileContainer getFileContainerByXPath(String mappingFile,
			String xPathExpression) {
		try {

			// Document typeMappingDoc = documentBuilder.parse(new
			// File(mappingFile));
			Document typeMappingDoc = documentBuilder.parse(ClassLoader
					.getSystemResourceAsStream(mappingFile));
			Node includeNode = (Node) xPath.evaluate(xPathExpression,
					typeMappingDoc, XPathConstants.NODE);
			if (includeNode != null) {
				JAXBElement<FileContainer> element;
				element = unmarshaller.unmarshal(includeNode,
						FileContainer.class);
				return element.getValue();
			}
		} catch (SAXException e) {
			ExceptionLogging(e, "file cannot be parsed");
		} catch (IOException e) {
			ExceptionLogging(e, "error occured during file access");
		} catch (XPathExpressionException e) {
			ExceptionLogging(e,
					"error occured during accessing the document node via XPath");
		} catch (JAXBException e) {
			ExceptionLogging(e, "error occured during unmarshalling");
		}
		return null;
	}

	/**
	 * Exceptionlogging method to log Exceptions
	 * 
	 * @param e
	 *            thrown Exception
	 * @param cause
	 *            probable problem
	 */
	private void ExceptionLogging(Exception e, String cause) {
		if (cause != null) {
			log.error("Type Mapping: " + cause);
		}
		log.error("Type Mapping: " + e.getStackTrace());
		log.info("Type Mapping: " + e.toString());
	}
}
