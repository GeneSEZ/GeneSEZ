package org.genesez.mapping.type;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324560312561_928578_5186) 
 */

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.XMLConstants;

/**
 * This class handles the namespaces of the XSD for the XPath expression used in the Binding Delegator.
 * 
 * @author	Peter Huster <peter.huster@fh-zwickau.de> (maintainer)
 */
public class TypemappingNamespaceContext implements NamespaceContext {
	
	/**
	 * Prefix to URI mapping.
	 * 
	 * @param	prefix	The prefix used in the XML for the namespace.
	 * @return	The URI mapping.
	 */
	public String getNamespaceURI(String prefix) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560345344_124875_5230) ENABLED START */
		if (prefix.equals("tns")) {
			return "http://www.genesez.org/typemapping";
		} else {
			return XMLConstants.NULL_NS_URI;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * URI to prefix mapping.
	 * @param	namespaceURI	the namespace of the Schema
	 * @return	the used prefix of the Schema used in the XML file
	 */
	public String getPrefix(String namespaceURI) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560364580_216701_5238) ENABLED START */
		if (namespaceURI.equals("http://www.genesez.org/typemapping")) {
			return "tns";
		} else {
			return null;
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	namespaceURI	
	 * @return	null
	 */
	public Iterator<String> getPrefixes(String namespaceURI) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324560386015_900467_5246) ENABLED START */
		return null;
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324560312561_928578_5186) ENABLED START */
	/* PROTECTED REGION END */
	
}
