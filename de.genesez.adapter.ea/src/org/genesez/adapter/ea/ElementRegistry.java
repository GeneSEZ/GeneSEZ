package org.genesez.adapter.ea;

import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Port;

/**
 * Collect all identifiable elements created during model transformation
 * 
 * @author gerbe
 * 
 * The ElementRegistry registers and provides access to all identifiable
 * elements created during the model transformation process.
 * It also provides a search interface to get elements by their GUID or by
 * their Enterprise Architect ID.
 */
public class ElementRegistry {

	private static final Log log = LogFactory.getLog(ElementRegistry.class);
	public static final ElementRegistry instance = new ElementRegistry();
	
	private Map<String, Element> elements = new HashMap<String, Element>(); 
	private Map<Integer, String> idGuidMap = new HashMap<Integer, String>(); 
	
	private Map<String, Interface> interfaceMap = new HashMap<String, Interface>();
	private Map<Port, Class> classMap = new HashMap<Port, Class>();
	
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
		this.interfaceMap = new HashMap<String, Interface>();
		this.classMap = new HashMap<Port, Class>();
	}
	
	/**
	 * Add an Enterprise Architect attribute and the corresponding element
	 * @param _a	The Enterprise Architect attribute
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Attribute _a, Element _e) {
		this.addElementGuid(_a.GetAttributeGUID(), _e);
		// TODO is this needed
		//this.addElementIdGuid(_a.GetAttributeID(), _a.GetAttributeGUID());
	}
	
	/**
	 * Add an Enterprise Architect connector and the corresponding element
	 * @param _a	The Enterprise Architect connector
	 * @param _e	The uml model element
	 */
	public void addElement(org.sparx.Connector _c, Element _e) {
		this.addElementGuid(_c.GetConnectorGUID(), _e);
		// now processed by postprocessor
		// otherwise error in simulation
		//this.addElementIdGuid(_c.GetConnectorID(), _c.GetConnectorGUID());
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
		// TODO is this needed?		
//		this.addElementIdGuid(_p.GetPackageID(), _p.GetPackageGUID());
	}
	
	/**
	 * Add an element and its GUID entry
	 * @param _guid	The GUID of the element
	 * @param _e	The uml model element
	 */
	public void addElementGuid(String _guid, Element _e) {
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
	
	//------------
	/**
	 * Adds an interface to interface map
	 */
	public void addInterface(org.sparx.Element _e, Interface iface) {
		if (!interfaceMap.containsKey(iface.getName())) {
			this.interfaceMap.put(iface.getName(), iface);
			this.addElementGuid(_e.GetElementGUID(), iface);
		}
	}
	
	public void addClass(Port port, Class clazz){
		this.classMap.put(port, clazz);
	}
	
	public Class getClassByPort(Port port){
		return classMap.get(port);
	}
	
	public void printClassMap(){
		StringBuilder sb = new StringBuilder("ClassMap:\n");
		for(Port p: classMap.keySet()){
			sb.append(p.getName() + "\t-> " + classMap.get(p).getName());
			sb.append("\n");
		}
		log.debug(sb.toString());
	}
	
	/**
	 * Returns the interface by string
	 * 
	 * @param name The interface element name
	 * @return
	 */
	public Interface getInterfaceByName(String name) {
		return interfaceMap.get(name);
	}

	/**
	 * print all interfaces
	 */
	public void printInterfaces() {
		StringBuilder sb = new StringBuilder("\n");
		for (String s : interfaceMap.keySet()) {
			sb.append("\t");
			sb.append(s + " -> " + interfaceMap.get(s));
			sb.append("\n");
		}
		log.debug(sb.toString());
	}

	/**
	 * prints all elements to debug
	 */
	public void print() {
		log.debug("Print ElementRegistryMap...");
		StringBuilder sb = new StringBuilder("\n");
		for (String s : elements.keySet()) {
			String id = "";			
			for(Integer key : idGuidMap.keySet()){
				String guid = idGuidMap.get(key);
				if(guid.equals(s)){
					id = key.toString();
				}
			}
			sb.append("ID("+ id +") -> ");
			sb.append(s + "\t" + (elements.get(s)).toString());
			sb.append("\n");
		}
		log.debug(sb.toString());
	}
}
