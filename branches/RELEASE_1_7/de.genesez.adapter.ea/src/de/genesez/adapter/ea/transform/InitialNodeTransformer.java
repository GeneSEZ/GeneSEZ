package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class InitialNodeTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(InitialNodeTransformer.class);
	
	InitialNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating InitialNode " + _e.GetName() + ", parent " + _parent.getName());
		
		InitialNode node = UMLFactory.eINSTANCE.createInitialNode();
		node.setActivity(_parent);
		node.setName(_e.GetName());
		
		this.umlElement = node;
		this.eaElement = _e;

		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, node);
		return node;
	}
}
