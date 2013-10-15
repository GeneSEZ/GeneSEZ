package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363941796971_968179_2168) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class CallBehaviorActionTransformer extends AbstractActivityNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(CallBehaviorActionTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public CallBehaviorAction transform(org.sparx.Element element, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363941884833_903043_2193) ENABLED START */
		LOG.debug("Creating CallBehaviorAction " + element.GetName() + ", parent " + parent.getName());
		
		CallBehaviorAction action = UMLFactory.eINSTANCE.createCallBehaviorAction();
		action.setActivity(parent);
		action.setName(element.GetName());
		
		this.umlElement = action;
		this.eaElement = element;
		
		this.applyStereotypes();
		
		PostProcessor.INSTANCE.addCalledBehaviorAction(action, element.GetClassifierID());
		ElementRegistry.INSTANCE.addElement(element, action);
		return action;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363941796971_968179_2168) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
