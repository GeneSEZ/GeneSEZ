package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.genesez.adapter.ea.ElementRegistry;


/**
 * transforms provided interface
 * 
 * @author gerbe
 * @author christian
 *
 */

public class ProvidedInterfaceTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(ProvidedInterfaceTransformer.class);
	
	Interface transform(org.sparx.Element _e, Port _parent) {
		log.debug("Creating ProvidedInterface " + _e.GetName() + ", parent " + _parent.getName());
		
		Interface iface = ElementRegistry.instance.getInterfaceByName(_e.GetName());
		
		this.umlElement = iface;
		this.eaElement = _e;
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// add provided interface to factory		
		InterfaceFactory.instance.addProvidedInterface(_e.GetName(), _parent);
		
		return iface;
	}
	
}