package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class ActivityFinalNodeTransformer {

	private static final Log log = LogFactory.getLog(ActivityFinalNodeTransformer.class);
	private ActivityFinalNode activityFinalNode;
	
	ActivityFinalNode transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating ActivityFinalNode " + _e.GetName() + ", parent " + _parent.getName());
		this.activityFinalNode = UMLFactory.eINSTANCE.createActivityFinalNode();
		this.activityFinalNode.setActivity(_parent);
		this.activityFinalNode.setName(_e.GetName());
		XmiFile.instance.addElement(this.activityFinalNode, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.activityFinalNode);
		return this.activityFinalNode;
	}
}
