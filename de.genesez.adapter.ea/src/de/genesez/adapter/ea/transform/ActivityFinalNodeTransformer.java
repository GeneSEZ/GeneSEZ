package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ContentRegistry;
import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.ProfileRegistry;

public class ActivityFinalNodeTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(ActivityFinalNodeTransformer.class);
	
	ActivityFinalNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating ActivityFinalNode " + _e.GetName() + ", parent " + _parent.getName());

		ActivityFinalNode node = UMLFactory.eINSTANCE.createActivityFinalNode();
		node.setActivity(_parent);
		node.setName(_e.GetName());
		
		this.umlElement = node;
		this.eaElement = _e;

		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, node);
		return node;
	}
}
