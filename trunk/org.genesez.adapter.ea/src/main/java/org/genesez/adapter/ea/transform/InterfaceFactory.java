package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363352788555_947919_2360) 
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * class to process all required and provided interfaces
 * 
 * TODO change the search from interface from string to interface,
 * but you'll see you get into big trouble 
 * @author Christian
 */
public class InterfaceFactory {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(InterfaceFactory.class);
	
	public static final InterfaceFactory INSTANCE = new InterfaceFactory();
	
	private Package interfacePackage = null;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>InterfaceFactory</b></em>'.
	 */
	private InterfaceFactory() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363352830142_101552_2385) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * process all interfaces
	 */
	public void processInterfaces() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941033372_448860_2141) ENABLED START */
		createProvidedInterfaces();
		createRequiredInterfaces();
		/* PROTECTED REGION END */
	}
	
	/**
	 * creates all provided interfaces
	 */
	private void createProvidedInterfaces() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941064175_816572_2145) ENABLED START */
		LOG.info("Creating all provided interfaces...");
		// go over all ports
		for (Port port : providedIfaceMap.keySet()) {
			// go over all provided interfaces
			for (String ifaceName : providedIfaceMap.get(port)) {
				Interface iface = ElementRegistry.INSTANCE.getInterfaceByName(ifaceName);
				
				Class clazz = ElementRegistry.INSTANCE.getClassByPort(port);
				
				// set package
				iface.setPackage(getInterfacePackage());
				// UML 2.3 superstructure says one interface realization to one
				// interface
				// create interface realization
				clazz.createInterfaceRealization(iface.getName(), iface);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void createRequiredInterfaces() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941166664_757929_2150) ENABLED START */
		LOG.info("Creating all required Interfaces...");
		// go over all ports
		for (Port port : requiredIfaceMap.keySet()) {
			// go over all provided interfaces
			for (String ifaceName : requiredIfaceMap.get(port)) {
				Interface iface = ElementRegistry.INSTANCE.getInterfaceByName(ifaceName);
				// get class from registry
				Class clazz = ElementRegistry.INSTANCE.getClassByPort(port);
				
				// then create for the right class all usages
				iface.setPackage(getInterfacePackage());
				clazz.createUsage(iface);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addProvidedInterface(String name, Port p) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941178297_329983_2153) ENABLED START */
		if (providedIfaceMap.containsKey(p)) {
			providedIfaceMap.get(p).add(name);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(name);
			providedIfaceMap.put(p, list);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void addRequiredInterface(String name, Port p) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941213660_19757_2157) ENABLED START */
		if (requiredIfaceMap.containsKey(p)) {
			requiredIfaceMap.get(p).add(name);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(name);
			requiredIfaceMap.put(p, list);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>interfacePackage</b></em>'.
	 */
	public Package getInterfacePackage() {
		return interfacePackage;
	}
	
	/**
	 * Sets the value of attribute '<em><b>interfacePackage</b></em>'.
	 * @param	interfacePackage	the value to set.
	 */
	public void setInterfacePackage(Package interfacePackage) {
		this.interfacePackage = interfacePackage;
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363352788555_947919_2360) ENABLED START */
	private Map<Port, List<String>> providedIfaceMap = new HashMap<Port, List<String>>();
	private Map<Port, List<String>> requiredIfaceMap = new HashMap<Port, List<String>>();
	/* PROTECTED REGION END */
}
