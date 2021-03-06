package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363941981266_615246_2220) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class CallOperationActionTransformer extends AbstractActivityNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(CallOperationActionTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public CallOperationAction transform(org.sparx.Element element, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942028022_442082_2246) ENABLED START */
		LOG.debug("Creating CallOperationAction " + element.GetName() + ", parent " + parent.getName());
		CallOperationAction action = UMLFactory.eINSTANCE.createCallOperationAction();
		action.setActivity(parent);
		action.setName(element.GetName());
		
		this.umlElement = action;
		this.eaElement = element;
		
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(element, action);
		return action;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363941981266_615246_2220) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
