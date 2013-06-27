package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class RequiredInterfaceTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(RequiredInterfaceTransformer.class);
	
	Interface transform(org.sparx.Element _e, Port _parent) {
		log.debug("Creating RequiredInterface " + _e.GetName() + ", parent " + _parent.getName());
		Interface iface = UMLFactory.eINSTANCE.createInterface();
		iface.setName(_e.GetName());
//		_parent.getRequireds().add(iface);
		
		this.umlElement = iface;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, iface);
		return iface;
	}
	
	Interface transform(org.sparx.Element _e, Component _parent) {
		log.debug("Creating RequiredInterface " + _e.GetName() + ", parent " + _parent.getName());
		Interface iface = UMLFactory.eINSTANCE.createInterface();
		iface.setName(_e.GetName());
		_parent.getRequireds().add(iface);
		
		this.umlElement = iface;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, iface);
		return iface;
	}
}