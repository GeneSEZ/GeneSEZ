package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;

public class CallBehaviorActionTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(CallBehaviorActionTransformer.class);
	
	CallBehaviorAction transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating CallBehaviorAction " + _e.GetName() + ", parent " + _parent.getName());

		CallBehaviorAction action = UMLFactory.eINSTANCE.createCallBehaviorAction();
		action.setActivity(_parent);
		action.setName(_e.GetName());
		
		this.umlElement = action;
		this.eaElement = _e;

		this.applyStereotypes();

		PostProcessor.instance.setCalledBehavior(action, _e.GetClassifierID());
		ElementRegistry.instance.addElement(_e, action);
		return action;
	}
}
