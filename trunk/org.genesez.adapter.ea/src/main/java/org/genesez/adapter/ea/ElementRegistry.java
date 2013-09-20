package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866883977_778148_1923) 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;

/**
 * Collect all identifiable elements created during model transformation
 * 
 * The ElementRegistry registers and provides access to all identifiable
 * elements created during the model transformation process.
 * It also provides a search interface to get elements by their GUID or by
 * their Enterprise Architect ID.
 * 
 * @author Gerrit Beine
 *  
 * @author christian
 */

public class ElementRegistry {
	
	// -- generated attribute, constant + association declarations ----------
	
	public static final ElementRegistry INSTANCE = new ElementRegistry();
	
	private static final Log LOG = LogFactory.getLog(ElementRegistry.class);
	
	// -- generated constructors --------------------------------------------
	/**
	 * Just to make constructor private
	 */
	
	private ElementRegistry() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363105844828_326154_2977) ENABLED START */
		
		// nothing to do here ;-)
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Initializes (or reset) the ElementRegistry
	 */
	
	public void initialize() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363105865366_58090_2980) ENABLED START */
		this.elements = new HashMap<String, Element>();
		this.idGuidMap = new HashMap<Integer, String>();
		this.interfaceMap = new HashMap<String, Interface>();
		this.classMap = new HashMap<Port, Class>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect attribute and the corresponding element
	 * @param	a	The Enterprise Architect attribute
	 * @param	e	The UMLl model element
	 */
	
	public void addElement(org.sparx.Attribute a, Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363105231599_701004_2972) ENABLED START */
		this.addElementGuid(a.GetAttributeGUID(), e);
		// TODO is this needed
		//this.addElementIdGuid(_a.GetAttributeID(), _a.GetAttributeGUID());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect connector and the corresponding element
	 * @param	c	The Enterprise Architect connector
	 * @param	e	The UML model element
	 */
	
	public void addElement(org.sparx.Connector c, Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337648329_314069_1914) ENABLED START */
		this.addElementGuid(c.GetConnectorGUID(), e);
		this.addElementIdGuid(c.GetConnectorID(), c.GetConnectorGUID());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect element and the corresponding element
	 * @param	x	The UML model element
	 * @param	e	The Enterprise Architect element
	 */
	
	public void addElement(org.sparx.Element x, Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363106001295_163796_2983) ENABLED START */
		this.addElementGuid(x.GetElementGUID(), e);
		this.addElementIdGuid(x.GetElementID(), x.GetElementGUID());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect package and the corresponding element
	 * @param	p	The UML model element
	 * @param	e	The Enterprise Architect package
	 */
	
	public void addElement(org.sparx.Package p, Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337816728_599082_1920) ENABLED START */
		this.addElementGuid(p.GetPackageGUID(), e);
		// TODO is this needed?		
		//		this.addElementIdGuid(_p.GetPackageID(), _p.GetPackageGUID());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an element and its GUID entry
	 * @param	guid	The GUID of the element
	 * @param	e	The UML model element
	 */
	
	public void addElementGuid(String guid, Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337939964_251840_1924) ENABLED START */
		if (this.elements.containsKey(guid)) {
			LOG.fatal("Key " + guid + " already contained -> " + getElement(guid));
		} else {
			this.elements.put(guid, e);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add a GUID to Enterprise Architect ID mapping entry
	 * @param	id	The Enterprise Architect ID
	 * @param	guid	The GUID of the element
	 */
	
	private void addElementIdGuid(int id, String guid) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337963102_524414_1928) ENABLED START */
		if (this.idGuidMap.containsKey(id)) {
			LOG.fatal("Key " + id + " already contained");
		} else {
			this.idGuidMap.put(id, guid);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * returns the interface by string
	 * @param	name	
	 * @return	
	 */
	
	public Interface getInterfaceByName(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338075796_836391_1932) ENABLED START */
		return interfaceMap.get(name);
		/* PROTECTED REGION END */
	}
	
	/**
	 * print all interfaces
	 */
	
	public void printInterfaces() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338246778_74066_1941) ENABLED START */
		StringBuilder sb = new StringBuilder("\n");
		for (String s : interfaceMap.keySet()) {
			sb.append("\t");
			sb.append(s + " -> " + interfaceMap.get(s));
			sb.append("\n");
		}
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * prints all elements to debug
	 */
	
	public void printElementRegistry() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338255392_174539_1944) ENABLED START */
		LOG.debug("Print ElementRegistryMap...");
		StringBuilder sb = new StringBuilder("\n");
		for (String s : elements.keySet()) {
			String id = "";
			for (Integer key : idGuidMap.keySet()) {
				String guid = idGuidMap.get(key);
				if (guid.equals(s)) {
					id = key.toString();
				}
			}
			sb.append("ID(" + id + ") -> ");
			sb.append(s + "\t" + (elements.get(s)).toString());
			sb.append("\n");
		}
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds an string to interface map
	 * @param	e	
	 * @param	iface	
	 */
	
	public void addInterface(org.sparx.Element e, Interface iface) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338462585_989431_1950) ENABLED START */
		if (!interfaceMap.containsKey(iface.getName())) {
			this.interfaceMap.put(iface.getName(), iface);
			this.addElementGuid(e.GetElementGUID(), iface);
		} else {
			LOG.error("interface already contained in map");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	port	
	 * @param	clazz	
	 */
	
	public void addClass(Port port, Class clazz) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338496439_432362_1954) ENABLED START */
		if (!this.classMap.containsKey(port)) {
			this.classMap.put(port, clazz);
		} else {
			LOG.error("port already contained in map");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	port	
	 * @return	
	 */
	
	public Class getClassByPort(Port port) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338538677_862516_1966) ENABLED START */
		return this.classMap.get(port);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public void printClassMap() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338565967_83196_1970) ENABLED START */
		StringBuilder sb = new StringBuilder("ClassMap:\n");
		for (Port p : classMap.keySet()) {
			sb.append(p.getName() + "\t-> " + classMap.get(p).getName());
			sb.append("\n");
		}
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	id	
	 * @return	
	 */
	
	public Element getElementById(int id) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363344171017_955579_2242) ENABLED START */
		LOG.debug("Return Element with ID " + id);
		//		if (this.idGuidMap.containsKey(id)) {
		return this.getElement(this.idGuidMap.get(id));
		//		}
		//		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	guid	
	 * @return	
	 */
	
	public Element getElement(String guid) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363344210202_541794_2246) ENABLED START */
		LOG.debug("Return Element with GUID " + guid);
		return this.elements.get(guid);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Verifies if an element exists in the registry using its GUID
	 * @param	guid	
	 * @return	
	 */
	
	public boolean isExisting(String guid) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363940404793_936262_2092) ENABLED START */
		return this.elements.containsKey(guid);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>INSTANCE</b></em>'
	 */
	public static final ElementRegistry getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Returns the value of attribute '<em><b>LOG</b></em>'
	 */
	public static final Log getLog() {
		return LOG;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866883977_778148_1923) ENABLED START */
	private Map<String, Element> elements = new HashMap<String, Element>();
	private Map<Integer, String> idGuidMap = new HashMap<Integer, String>();
	
	private Map<String, Interface> interfaceMap = new HashMap<String, Interface>();
	private Map<Port, Class> classMap = new HashMap<Port, Class>();
	
	public Set<Entry<String, Element>> getElements() {
		return this.elements.entrySet();
	}
	/* PROTECTED REGION END */
	
}
