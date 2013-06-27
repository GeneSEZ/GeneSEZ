package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;

/**
 * Collect all identifiable elements created during model transformation
 * 
 * @author gerbe
 * 
 * The ElementRegistry registeres and provides access to all identifiable
 * elements created during the model transformation process.
 * It also provides a search interface to get elements by their GUID or by
 * their Enterprise Architect ID.
 */
public class ElementRegistry {

	private static final Log log = LogFactory.getLog(ElementRegistry.class);
	public static final ElementRegistry instance = new ElementRegistry();
	
	private Map<String, Element> elements = new HashMap<String, Element>(); 
	private Map<Integer, String> idGuidMap = new HashMap<Integer, String>(); 
	
	/**
	 * Just to make constructor private
	 */
	private ElementRegistry() {
		// nothing to do here ;-)
	}
	
	/**
	 * Initializes (or reset) the ElementRegistry
	 */
	public void initialize() {
		this.elements = new HashMap<String, Element>();
		this.idGuidMap = new HashMap<Integer, String>();
	}
	
	/**
	 * Add an Enterprise Architect attribute and the corresponding element
	 * @param _a	The Enterprise Architect attribute
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Attribute _a, Element _e) {
		this.addElementGuid(_a.GetAttributeGUID(), _e);
//		this.addElementIdGuid(_a.GetAttributeID(), _a.GetAttributeGUID());
	}
	
	/**
	 * Add an Enterprise Architect connector and the corresponding element
	 * @param _a	The Enterprise Architect connector
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Connector _c, Element _e) {
		this.addElementGuid(_c.GetConnectorGUID(), _e);
//		this.addElementIdGuid(_c.GetConnectorID(), _c.GetConnectorGUID());
	}
	
	/**
	 * Add an Enterprise Architect element and the corresponding element
	 * @param _a	The Enterprise Architect element
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Element _x, Element _e) {
		this.addElementGuid(_x.GetElementGUID(), _e);
		this.addElementIdGuid(_x.GetElementID(), _x.GetElementGUID());
	}
	
	/**
	 * Add an Enterprise Architect package and the corresponding element
	 * @param _a	The Enterprise Architect package
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Package _p, Element _e) {
		this.addElementGuid(_p.GetPackageGUID(), _e);
//		this.addElementIdGuid(_p.GetPackageID(), _p.GetPackageGUID());
	}
	
	/**
	 * Add an element and its GUID entry
	 * @param _guid	The GUID of the element
	 * @param _e	The uml model element
	 */
	private void addElementGuid(String _guid, Element _e) {
		if (this.elements.containsKey(_guid)) {
			log.fatal("Key " + _guid + " already contained");
		} else {
			this.elements.put(_guid, _e);
		}
	}
	
	/**
	 * Add a GUID to Enterprise Architect ID mapping entry
	 * @param _id	The Enterprise Architect ID
	 * @param _guid	The GUID of the element
	 */
	private void addElementIdGuid(int _id, String _guid) {
		if (this.idGuidMap.containsKey(_id)) {
			log.fatal("Key " + _id + " already contained");
		} else {
			this.idGuidMap.put(_id, _guid);
		}
	}
	
	/**
	 * Provides access to the registered elements collection
	 * @return
	 */
	public Set<Entry<String, Element>> getElements() {
		return this.elements.entrySet();
	}
	
	/**
	 * Verifies if an element exists in the registry using its GUID
	 * @param _guid	The elements GUID to search for
	 * @return
	 */
	public boolean exists(String _guid) {
		return this.elements.containsKey(_guid);
	}

	/**
	 * Verifies if an element exists in the registry using its Enterprise Architect ID
	 * @param _id	The elements Enterprise Architect ID
	 * @return
	 */
	public boolean existsId(int _id) {
		if (this.idGuidMap.containsKey(_id)) {
			return this.exists(this.idGuidMap.get(_id));
		}
		return false;
	}

	/**
	 * Returns an element by its GUID
	 * @param _guid	The elements GUID to search for
	 * @return
	 */
	public Element get(String _guid) {
		log.debug("Return Element with GUID " + _guid);
		return this.elements.get(_guid);
	}
	
	/**
	 * Returns an element by its Enterprise Architect ID
	 * @param _id	The elements Enterprise Architect ID
	 * @return
	 */
	public Element getById(int _id) {
		log.debug("Return Element with ID " + _id);
		if (this.idGuidMap.containsKey(_id)) {
			return this.get(this.idGuidMap.get(_id));
		}
		return null;
	}
}
