package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;


/**
 * transforms all ports
 * 
 * @author gerbe
 * @author christian
 * @version 2
 *
 */

public class PortTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(PortTransformer.class);
	
	private final boolean DEBUG = false; 	
	
	/**
	 * transforms the element to port, create a class for the port
	 * and add provided and required interfaces to the post processor 
	 * 
	 * @param _e
	 * @param _parent
	 * @return Port
	 */
	Port transform(org.sparx.Element _e, Component _parent) {
		log.debug("Creating Port " + _e.GetName() + ", parent " + _parent.getName());
		Port port = UMLFactory.eINSTANCE.createPort();
		port.setName(_e.GetName());
		
		// port will be destroyed if component is removed
		port.setAggregation(AggregationKind.COMPOSITE_LITERAL);
		
		_parent.getOwnedPorts().add(port);
		
		this.umlElement = port;
		this.eaElement = _e;

		this.transformElements();
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// if no name is set
		// TODO only for debugging
		if(DEBUG && port.getName().equals("")){
			port.setName("NO_NAME");
		}
		
		// create connector class to every port
		org.eclipse.uml2.uml.Class connClass = _parent.createOwnedClass("c_"+ port.getName(), false);
		
		// connector class to type of port
		port.setType(connClass);
		
		// add class to registry
		ElementRegistry.instance.addClass(port, connClass);
		
		// add port to main-registry
		ElementRegistry.instance.addElement(_e, port);
		return port;
	}
	
	/**
	 * transform the element, if it's an provided or required interface
	 */
	@Override
	protected void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName() + ", type: "+_e.GetType());
		
		if ( _e.GetType().equals("RequiredInterface") ) {
			log.debug("Element is a RequiredInterface");
			RequiredInterfaceTransformer t = new RequiredInterfaceTransformer();			
			t.transform(_e, (Port) this.umlElement);
		}
		
		if ( _e.GetType().equals("ProvidedInterface") ) {
			log.debug("Element is a ProvidedInterface");
			ProvidedInterfaceTransformer t = new ProvidedInterfaceTransformer();
			t.transform(_e, (Port) this.umlElement);
		}
	}
	
}
