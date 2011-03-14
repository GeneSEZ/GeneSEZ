package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;

public class CallOperationActionTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(CallOperationActionTransformer.class);
	
	CallOperationAction transform(org.sparx.Element _e, Activity _parent) {
		log.debug("Creating CallOperationAction " + _e.GetName() + ", parent " + _parent.getName());
		CallOperationAction action = UMLFactory.eINSTANCE.createCallOperationAction();
		action.setActivity(_parent);
		action.setName(_e.GetName());

		this.umlElement = action;
		this.eaElement = _e;

		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, action);
		return action;
	}
}
