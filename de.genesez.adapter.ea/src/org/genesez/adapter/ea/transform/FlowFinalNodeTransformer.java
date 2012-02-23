package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ProfileRegistry;


public class FlowFinalNodeTransformer {

	private static final Log log = LogFactory.getLog(FlowFinalNodeTransformer.class);
	private FlowFinalNode flowFinalNode;
	
	FlowFinalNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating FlowFinalNode " + _e.GetName() + ", parent " + _parent.getName());
		this.flowFinalNode = UMLFactory.eINSTANCE.createFlowFinalNode();
		this.flowFinalNode.setActivity(_parent);
		this.flowFinalNode.setName(_e.GetName());
		this.applyStereotypes(_e);
		ElementRegistry.instance.addElement(_e, this.flowFinalNode);
		return this.flowFinalNode;
	}

	private void applyStereotypes(org.sparx.Element _e) {
		for (String s : _e.GetStereotypeList().split(",")) {
			log.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.instance.getStereotype(s);
			if (this.flowFinalNode.isStereotypeApplicable(st)) {
				log.debug("Apply stereotype " + st.getName() );
				EObject o = this.flowFinalNode.applyStereotype(st);
				if (null != o) {
					ContentRegistry.instance.addContent(o);
				}
			}
		}
	}
}
