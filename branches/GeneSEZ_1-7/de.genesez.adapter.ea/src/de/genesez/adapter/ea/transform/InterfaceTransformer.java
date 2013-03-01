package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;

public class InterfaceTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(InterfaceTransformer.class);
	
	Interface transform(org.sparx.Element _e, Profile _parent) {
		log.debug("Creating Stereotype " + _e.GetName() + ", parent " + _parent.getName());
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
