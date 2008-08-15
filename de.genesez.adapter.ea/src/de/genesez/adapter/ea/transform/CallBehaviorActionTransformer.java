package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class CallBehaviorActionTransformer {

	private static final Log log = LogFactory.getLog(CallBehaviorActionTransformer.class);
	private CallBehaviorAction callBehaviorAction;
	
	CallBehaviorAction transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating CallBehaviorAction " + _e.GetName() + ", parent " + _parent.getName());
		this.callBehaviorAction = UMLFactory.eINSTANCE.createCallBehaviorAction();
		this.callBehaviorAction.setActivity(_parent);
		this.callBehaviorAction.setName(_e.GetName());
		XmiFile.instance.addElement(this.callBehaviorAction, _e.GetElementGUID());
		PostProcessor.instance.registerElement(_e, this.callBehaviorAction);
		PostProcessor.instance.setCalledBehavior(this.callBehaviorAction, _e.GetClassifierID());
		return this.callBehaviorAction;
	}
}
