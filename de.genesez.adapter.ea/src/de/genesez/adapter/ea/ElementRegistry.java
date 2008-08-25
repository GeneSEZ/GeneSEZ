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
	private Map<Integer, String> idGuidMap = new HashMap<Integer, String>(); 
	
	private ElementRegistry() {
		// nothing to do here ;-)
	}
	
	public void addElement(org.sparx.Attribute _a, Element _e) {
		this.addElementGuid(_a.GetAttributeGUID(), _e);
		this.addElementIdGuid(_a.GetAttributeID(), _a.GetAttributeGUID());
	}
	
	public void addElement(org.sparx.Connector _c, Element _e) {
		this.addElementGuid(_c.GetConnectorGUID(), _e);
		this.addElementIdGuid(_c.GetConnectorID(), _c.GetConnectorGUID());
	}
	
	public void addElement(org.sparx.Element _x, Element _e) {
		this.addElementGuid(_x.GetElementGUID(), _e);
		this.addElementIdGuid(_x.GetElementID(), _x.GetElementGUID());
	}
	
	public void addElement(org.sparx.Package _p, Element _e) {
		this.addElementGuid(_p.GetPackageGUID(), _e);
		this.addElementIdGuid(_p.GetPackageID(), _p.GetPackageGUID());
	}
	
	private void addElementGuid(String _guid, Element _e) {
		this.elements.put(_guid, _e);
	}
	
	private void addElementIdGuid(int _id, String _guid) {
		this.idGuidMap.put(_id, _guid);
	}
	
	public Set<Entry<String, Element>> getElements() {
		return this.elements.entrySet();
	}
	
	public boolean exists(String _guid) {
		return this.elements.containsKey(_guid);
	}

	public boolean existsId(int _id) {
		if (this.idGuidMap.containsKey(_id)) {
			return this.exists(this.idGuidMap.get(_id));
		}
		return false;
	}

	public Element get(String _guid) {
		return this.elements.get(_guid);
	}
	
	public Element getById(int _id) {
		if (this.idGuidMap.containsKey(_id)) {
			return this.get(this.idGuidMap.get(_id));
		}
		return null;
	}
}
