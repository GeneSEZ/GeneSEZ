package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;


public class DecisionNodeTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(DecisionNodeTransformer.class);
	
	DecisionNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating DecisionNode " + _e.GetName() + ", parent " + _parent.getName());
		
		DecisionNode node = UMLFactory.eINSTANCE.createDecisionNode();
		node.setActivity(_parent);
		node.setName(_e.GetName());
		
		this.umlElement = node;
		this.eaElement = _e;

		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, node);
		return node;
	}
}
