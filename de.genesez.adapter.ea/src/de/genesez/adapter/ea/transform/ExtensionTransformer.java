package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;

import de.genesez.adapter.ea.ElementRegistry;

public class ExtensionTransformer {

	private static final Log log = LogFactory.getLog(ExtensionTransformer.class);
	Extension extension;
	
	Extension transform(org.sparx.Connector _c, Stereotype _s, Class _m) {
		log.debug("Creating Extension " + _c.GetName() + ", stereotype " + _s.getName());
		Extension e = _s.createExtension(_m, false);
		ElementRegistry.instance.addElement(_c, e);
		return this.extension;
	}
}
