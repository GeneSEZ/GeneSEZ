package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class GeneralizationTransformer {

	private static final Log log = LogFactory.getLog(GeneralizationTransformer.class);
	private Generalization generalization;
	
	Generalization transform(org.sparx.Connector _c) {
		log.debug("Creating Generalization " + _c.GetName());
		if (ElementRegistry.instance.exists(_c.GetConnectorGUID())) {
			log.debug("Generalization already exist");
			return (Generalization) ElementRegistry.instance.get(_c.GetConnectorGUID());
		} else {
			this.generalization = UMLFactory.eINSTANCE.createGeneralization();
			ElementRegistry.instance.addElement(_c, this.generalization);
		}
		return this.generalization;
	}
}
