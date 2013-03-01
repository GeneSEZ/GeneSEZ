package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;

import de.genesez.adapter.ea.ElementRegistry;

public class InterfaceTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(InterfaceTransformer.class);
	
	Interface transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating Interface " + _e.GetName() + ", parent " + _parent.getName());
		Interface iface = _parent.createOwnedInterface(_e.GetName());
		
		this.umlElement = iface;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		ElementRegistry.instance.addElement(_e, iface);
		return iface;
	}
}
