package de.genesez.platforms.common.typemapping;

import java.util.Iterator;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

/**
 * This class handles the Namespaces of the XSD for the XPath expression used in the Binding Delegator
 * @author pethu
 * @date 2009-01-24
 */
public class TypemappingNamespaceContext implements NamespaceContext {
	
	/**
	 * prefix to URI mapping
	 * @param prefix the prefix used in the XML for the namespace
	 * @return the URI fitting to the prefix
	 */
	public String getNamespaceURI(String prefix) {
		if (prefix.equals("tns")) {
			return "http://www.genesez.de/typemapping";
		} else {
			return XMLConstants.NULL_NS_URI;
		}
	}
	
	/**
	 * URI to prefix mapping
	 * @param namespaceURI the namespace of the Schema
	 * @return the used prefix of the Schema used in the XML file
	 */
	public String getPrefix(String namespaceURI) {
		if (namespaceURI.equals("http://www.genesez.de/typemapping")) {
			return "tns";
		} else {
			return null;
		}
	}

	public Iterator<String> getPrefixes(String namespaceURI) {
		return null;
	}
}
