package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.InitialNode;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;

public class InitialNodeTransformer {

	private static final Log log = LogFactory.getLog(InitialNodeTransformer.class);
	private InitialNode initialNode;
	
	InitialNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating InitialNode " + _e.GetName() + ", parent " + _parent.getName());
		this.initialNode = UMLFactory.eINSTANCE.createInitialNode();
		this.initialNode.setActivity(_parent);
		this.initialNode.setName(_e.GetName());
		ElementRegistry.instance.addElement(_e.GetElementGUID(), this.initialNode);
		PostProcessor.instance.registerElement(_e, this.initialNode);
		return this.initialNode;
	}
}
