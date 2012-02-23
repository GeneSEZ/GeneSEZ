package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;


/**
 * transforms dependencies
 * 
 * @author gerbe
 * @author christian
 * @version 2
 *
 */
public class DependencyTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory
			.getLog(DependencyTransformer.class);
	
	// overwrite the default element to connector
	private org.sparx.Connector eaElement = null;

	Dependency transform(org.sparx.Connector _c, Component _parent) {
		log.debug("Creating Dependency " + _c.GetName() + ", parent "
				+ _parent.getName());
		
		Dependency dependency = UMLFactory.eINSTANCE.createDependency();
		dependency.setName(_c.GetName());
		
		dependency.getClients().add(_parent);		
		
		_parent.getPackagedElements().add(dependency);

		this.umlElement = dependency;
		this.eaElement = _c;
		
		// apply stereotypes
		ApplyStereotypeTransformer.applyStereotypes(eaElement, dependency);

		ElementRegistry.instance.addElement(_c, dependency);
		
		// Add dependency to postprocessor for connections
		PostProcessor.instance.setDependency(dependency, _c);
		return dependency;
	}

}
