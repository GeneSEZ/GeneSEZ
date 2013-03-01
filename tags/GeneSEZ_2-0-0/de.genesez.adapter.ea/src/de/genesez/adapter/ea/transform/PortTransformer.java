package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class PortTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(PortTransformer.class);
	
	Port transform(org.sparx.Element _e, Component _parent) {
		log.debug("Creating Port " + _e.GetName() + ", parent " + _parent.getName());
		Port port = UMLFactory.eINSTANCE.createPort();
		port.setName(_e.GetName());
		_parent.getOwnedPorts().add(port);
		
		this.umlElement = port;
		this.eaElement = _e;

		this.transformElements();
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, port);
		return port;
	}
	
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
