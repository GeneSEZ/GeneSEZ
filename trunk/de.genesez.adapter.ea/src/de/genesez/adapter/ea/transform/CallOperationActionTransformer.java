package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class CallOperationActionTransformer {

	private static final Log log = LogFactory.getLog(CallOperationActionTransformer.class);
	private CallOperationAction callOperationAction;
	
	CallOperationAction transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating CallOperationAction " + _e.GetName() + ", parent " + _parent.getName());
		this.callOperationAction = UMLFactory.eINSTANCE.createCallOperationAction();
		this.callOperationAction.setActivity(_parent);
		this.callOperationAction.setName(_e.GetName());
		XmiFile.instance.addElement(this.callOperationAction, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.callOperationAction);
		return this.callOperationAction;
	}
}
