package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363943420695_851822_2343) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * transforms all ports
 * @author christian
 */

public class PortTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PortTransformer.class);
	
	private static final boolean DEBUG = false;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * transforms the element to port, create a class for the port
	 * and add provided and required interfaces to the post processor 
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Port transform(org.sparx.Element element, Component parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363943542848_757460_2372) ENABLED START */
		LOG.debug("Creating Port " + element.GetName() + ", parent " + parent.getName());
		Port port = UMLFactory.eINSTANCE.createPort();
		port.setName(element.GetName());
		
		// port will be destroyed if component is removed
		port.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		
		parent.getOwnedPorts().add(port);
		
		this.umlElement = port;
		this.eaElement = element;
		
		this.transformElements();
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// if no name is set
		// TODO only for debugging
		if (DEBUG && port.getName().equals("")) {
			port.setName("NO_NAME");
		}
		
		// create connector class to every port
		org.eclipse.uml2.uml.Class connClass = parent.createOwnedClass("c_" + port.getName(), false);
		
		// connector class to type of porttransformElement
		port.setType(connClass);
		
		// add class to registry
		ElementRegistry.INSTANCE.addClass(port, connClass);
		
		// add port to main-registry
		ElementRegistry.INSTANCE.addElement(element, port);
		return port;
		/* PROTECTED REGION END */
	}
	
	/**
	 * transform the element, if it's an provided or required interface
	 * @param	element	
	 */
	
	protected void transformElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363943583183_582940_2377) ENABLED START */
		LOG.debug("Transforming element " + element.GetName() + ", type: " + element.GetType());
		
		if (element.GetType().equals("RequiredInterface")) {
			LOG.debug("Element is a RequiredInterface");
			RequiredInterfaceTransformer t = new RequiredInterfaceTransformer();
			t.transform(element, (Port) this.umlElement);
		}
		
		if (element.GetType().equals("ProvidedInterface")) {
			LOG.debug("Element is a ProvidedInterface");
			ProvidedInterfaceTransformer t = new ProvidedInterfaceTransformer();
			t.transform(element, (Port) this.umlElement);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363943420695_851822_2343) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
