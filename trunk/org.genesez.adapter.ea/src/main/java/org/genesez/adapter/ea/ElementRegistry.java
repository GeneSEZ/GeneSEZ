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
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.sparx.Connector;

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
 * @author Christian
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
		this.guidUmlElementMap = new HashMap<String, Element>();
		this.interfaceMap = new HashMap<String, Interface>();
		this.classMap = new HashMap<Port, Class>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect attribute and the corresponding element
	 */
	public void addAttribute(org.sparx.Attribute eaAttribute, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363105231599_701004_2972) ENABLED START */
		this.guidUmlElementMap.put(eaAttribute.GetAttributeGUID(), umlElement);
		this.idAttributeMap.put(eaAttribute.GetAttributeID(), umlElement);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect connector and the corresponding element
	 */
	public void addConnector(org.sparx.Connector eaConnector, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337648329_314069_1914) ENABLED START */
		this.idUmlConnectorMap.put(eaConnector.GetConnectorID(), umlElement);
		this.idEaConnectorMap.put(eaConnector.GetConnectorID(), eaConnector);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect element and the corresponding element
	 */
	public void addElement(org.sparx.Element eaElement, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363106001295_163796_2983) ENABLED START */
		addElementGuid(eaElement.GetElementGUID(), umlElement);
		// meta information
		this.idUmlElementMap.put(eaElement.GetElementID(), umlElement);
		this.idEaElementMap.put(eaElement.GetElementID(), eaElement);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an Enterprise Architect package and the corresponding element
	 */
	public void addPackage(org.sparx.Package eaPackage, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337816728_599082_1920) ENABLED START */
		//this.addElementGuid(eaPackage.GetPackageGUID(), umlElement);
		// TODO maybe an own package map
		//		this.idElementMap.put(eaPackage.GetPackageID(), eaPackage);
		// TODO is this needed?		
		//		this.addElementIdGuid(_p.GetPackageID(), _p.GetPackageGUID());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an element and its GUID entry
	 * @param	guid	The GUID of the element
	 */
	private void addElementGuid(String guid, Element umlElement) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363337939964_251840_1924) ENABLED START */
		if (this.guidUmlElementMap.containsKey(guid)) {
			LOG.fatal("Key " + guid + " already contained -> " + getElement(guid));
		} else {
			this.guidUmlElementMap.put(guid, umlElement);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * returns the interface by string
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
		StringBuilder sb = new StringBuilder("Print ElementRegistryMap:\n");
		for (String s : this.guidUmlElementMap.keySet()) {
			sb.append(s + "\t" + (guidUmlElementMap.get(s)).toString());
			sb.append("\n");
		}
		sb.append("\nId UML Element Map:\n");
		Classifier classifier = null;
		for (Integer i : idUmlElementMap.keySet()) {
			sb.append("\t");
			classifier = (Classifier) idUmlElementMap.get(i);
			sb.append(i + "\t-> " + classifier.getName());
			sb.append("\n");
		}
		
		LOG.debug(sb.toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds an string to interface map
	 */
	public void addInterface(org.sparx.Element e, Interface iface) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363338462585_989431_1950) ENABLED START */
		if (!interfaceMap.containsKey(iface.getName())) {
			this.interfaceMap.put(iface.getName(), iface);
			// meta
			this.guidUmlElementMap.put(e.GetElementGUID(), iface);
			this.idUmlElementMap.put(e.GetElementID(), iface);
			this.idEaElementMap.put(e.GetElementID(), e);
		} else {
			LOG.error("interface already contained in map -> " + iface.getName());
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
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
	 */
	public Element getElementById(int id) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363344171017_955579_2242) ENABLED START */
		if (idUmlElementMap.containsKey(id)) {
			LOG.debug("Return Element with ID " + id);
		} else {
			LOG.debug("Element with ID " + id + " is not in registry");
		}
		return this.idUmlElementMap.get(id);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public Element getElement(String guid) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363344210202_541794_2246) ENABLED START */
		LOG.debug("Return Element with GUID " + guid);
		return this.guidUmlElementMap.get(guid);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Verifies if an element exists in the registry using its GUID
	 */
	public boolean isExisting(String guid) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363940404793_936262_2092) ENABLED START */
		return this.guidUmlElementMap.containsKey(guid);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866883977_778148_1923) ENABLED START */
	
	/**
	 *  saving converted uml elements
	 */
	private Map<String, Element> guidUmlElementMap = new HashMap<String, Element>();
	private Map<Integer, Element> idUmlElementMap = new HashMap<Integer, Element>();
	/**
	 * saving all elements by their id
	 */
	private Map<Integer, org.sparx.Element> idEaElementMap = new HashMap<Integer, org.sparx.Element>();
	
	/**
	 * saving all ea connectors 
	 */
	private Map<Integer, Connector> idEaConnectorMap = new HashMap<Integer, Connector>();
	private Map<Integer, Element> idUmlConnectorMap = new HashMap<Integer, Element>();
	
	/**
	 * attribute GUID map
	 */
	private Map<Integer, Element> idAttributeMap = new HashMap<Integer, Element>();
	
	/**
	 * 
	 */
	public org.sparx.Element getEaElementById(String id) {
		LOG.debug("Return Element with ID " + id);
		return this.idEaElementMap.get(Integer.valueOf(id));
	}
	
	public Connector getConnectorById(int id) {
		LOG.debug("Return Connector with ID " + id);
		return this.idEaConnectorMap.get(id);
	}
	
	// saving interfaces
	private Map<String, Interface> interfaceMap = new HashMap<String, Interface>();
	
	// saving class for every port
	private Map<Port, Class> classMap = new HashMap<Port, Class>();
	
	public Set<Entry<String, Element>> getElements() {
		return this.guidUmlElementMap.entrySet();
	}
	/* PROTECTED REGION END */
}
