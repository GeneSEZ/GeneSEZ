package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class FlowFinalNodeTransformer {

	private static final Log log = LogFactory.getLog(FlowFinalNodeTransformer.class);
	private FlowFinalNode flowFinalNode;
	
	FlowFinalNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating FlowFinalNode " + _e.GetName() + ", parent " + _parent.getName());
		this.flowFinalNode = UMLFactory.eINSTANCE.createFlowFinalNode();
		this.flowFinalNode.setActivity(_parent);
		this.flowFinalNode.setName(_e.GetName());
		XmiFile.instance.addElement(this.flowFinalNode, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.flowFinalNode);
		return this.flowFinalNode;
	}
}
