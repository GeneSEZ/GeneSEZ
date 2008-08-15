package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;

public class ElementRegistry {

	private static final Log log = LogFactory.getLog(ElementRegistry.class);
	public static final ElementRegistry instance = new ElementRegistry();
	
	private Map<String, Element> elements = new HashMap<String, Element>(); 
	
	private ElementRegistry() {
		// nothing to do here ;-)
	}
	
	public void addElement(String _guid, Element _e) {
		this.elements.put(_guid, _e);
	}
	
	public Set<Entry<String, Element>> getElements() {
		return this.elements.entrySet();
	}
}
