package org.genesez.adapter.ea.transform;

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
import org.genesez.adapter.ea.PostProcessor;


/**
 * class to process all required and provided interfaces
 * 
 * @author christian
 * @version 3
 * 
 * TODO change the search from interface from string to interface,
 * but you'll see you get into big trouble 
 * 
 */
public class InterfaceFactory {

	private static final Log log = LogFactory.getLog(PostProcessor.class);
	public static InterfaceFactory instance = new InterfaceFactory();

	private Map<Port, List<String>> providedIfaceMap = new HashMap<Port, List<String>>();
	private Map<Port, List<String>> requiredIfaceMap = new HashMap<Port, List<String>>();
	private Package interfacePackage = null;

	/**
	 * private constructor
	 */
	private InterfaceFactory() {

	}

	/**
	 * process all interfaces
	 */
	public void processInterfaces() {
		createProvidedInterfaces();
		createRequiredInterfaces();
	}

	/**
	 * creates all provided interfaces
	 */
	private void createProvidedInterfaces() {
		log.info("Creating all provided interfaces...");
		// go over all ports
		for (Port port : providedIfaceMap.keySet()) {
			// go over all provided interfaces
			for (String ifaceName : providedIfaceMap.get(port)) {
				Interface iface = ElementRegistry.instance.getInterfaceByName(ifaceName);
				
				Class clazz = ElementRegistry.instance.getClassByPort(port
						);

				// set package
				iface.setPackage(getInterfacePackage());
				// UML 2.3 superstructure says one interface realization to one interface
				// create interface realization
				clazz.createInterfaceRealization(iface.getName(), iface);
			}
		}
	}

	/**
	 * creates all required interfaces
	 */
	public void createRequiredInterfaces() {
		log.info("Creating all required Interfaces...");
		// go over all ports
		for (Port port : requiredIfaceMap.keySet()) {
			// go over all provided interfaces
			for (String ifaceName : requiredIfaceMap.get(port)) {
				Interface iface = ElementRegistry.instance
						.getInterfaceByName(ifaceName);
				// get class from registry
				Class clazz = (Class) ElementRegistry.instance
						.getClassByPort(port);

				// then create for the right class all usages
				iface.setPackage(getInterfacePackage());
				clazz.createUsage(iface);
			}
		}
	}

	public void addProvidedInterface(String name, Port p) {
		if (providedIfaceMap.containsKey(p)) {
			providedIfaceMap.get(p).add(name);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(name);
			providedIfaceMap.put(p, list);
		}
	}

	public void addRequiredInterface(String name, Port p) {
		if (requiredIfaceMap.containsKey(p)) {
			requiredIfaceMap.get(p).add(name);
		} else {
			List<String> list = new ArrayList<String>();
			list.add(name);
			requiredIfaceMap.put(p, list);
		}
	}

	/**
	 * set the interface package -> there is only one package that holds all
	 * interfaces
	 * 
	 * @param e
	 */
	public void setInterfacePackage(Package e) {
		if (interfacePackage == null)
			interfacePackage = e;
	}

	public Package getInterfacePackage() {
		return interfacePackage;
	}

}
