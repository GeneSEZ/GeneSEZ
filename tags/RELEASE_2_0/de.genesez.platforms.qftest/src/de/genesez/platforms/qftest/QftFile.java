package de.genesez.platforms.qftest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

import de.genesez.testing.gtesting.TElement;
import de.genesez.testing.gtesting.TTestSuite;

public class QftFile {

	private static final Log log = LogFactory.getLog(QftFile.class);
	private static final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
	private static Document document;
	private static Element activeElement;
	
	public static void open(String s) {
		log.debug("Opening file: " + s);
		File f = new File(s);

		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			if ( f.exists() ) {
				log.debug("File exists");
				log.debug("Parsing DOM");
				document = db.parse(f);				
			} else {
				log.debug("Creating new DOM");
				document = db.newDocument();
			}
		} catch (ParserConfigurationException e) {
			log.error(e.toString());
		} catch (SAXException e) {
			log.error(e.toString());
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	public static void save(String s) {
		log.debug("Saving file: " + s);
		File f = new File(s);

		try {
			FileOutputStream fos = new FileOutputStream(f);
			
			OutputFormat format = new OutputFormat(document);
			format.setIndenting(true);
			
			XMLSerializer serializer = new XMLSerializer(fos, format);
			serializer.serialize(document);
		} catch (IOException e) {
			log.error(e.toString());
		}
	}

	public static void qfRootStep(TTestSuite t) {
		Element e = document.getDocumentElement();
		if ( null != e &&
				"RootStep".equals(e.getNodeName()) &&
				t.getXmiGuid().equals(e.getAttribute("id"))) {
			log.debug("Found RootStep for TestSuite " + t.getName());
			e.setAttribute("name", t.getName());
		} else {
			log.debug("Create RootStep");
			e = document.createElement("RootStep");
			e.setAttribute("id", t.getXmiGuid());
			e.setAttribute("name", t.getName());
			e.setAttribute("version", "2.2.3");
			document.appendChild(e);
		}
		activeElement = e;
	}
	
	public static void qfElement(TElement t, String tagName) {
		Element e = getElement(t, tagName); 
		addElement(e);
		activeElement = e;
	}

	public static void qfReset() {
		log.debug("Active element " + activeElement.getAttribute("id"));
		activeElement = (Element) activeElement.getParentNode();
		log.debug("New active element " + activeElement.getAttribute("id"));
	}
	
	private static Element getElement(TElement t, String tagName) {
		Element e = null;
		NodeList nl = activeElement.getElementsByTagName(tagName);
		
		if ( null != nl && 0 < nl.getLength()) {
			for ( int i = 0; i < nl.getLength(); i++ ) {
				Element _e = (Element) nl.item(i);
				if (t.getXmiGuid().equals(_e.getAttribute("id"))) {
					log.debug("Found Element " + t.getXmiGuid());
					e = _e;
					break;
				}
			}
		}
		
		if ( null == e ) {
			log.debug("Create Element " + tagName);
			e = document.createElement(tagName);
		}

		e.setAttribute("id", t.getXmiGuid());
		e.setAttribute("name", t.getName());

		return e;
	}
	
	private static void addElement(Element e) {
		if ( null == e.getParentNode() ) {
			activeElement.appendChild(e);
		}
	}
}
