package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PrimitiveType;
import org.genesez.adapter.ea.ElementRegistry;


public class PrimitiveTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(EnumerationTransformer.class);
	
	PrimitiveType transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating PrimitiveType " + _e.GetName() + ", parent " + _parent.getName());

		PrimitiveType type = _parent.createOwnedPrimitiveType(_e.GetName());

		ElementRegistry.instance.addElement(_e, type);
		return type;
	}

}
