package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363361279874_965542_2968) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityFinalNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class ActivityFinalNodeTransformer extends AbstractActivityNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ActivityFinalNodeTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public ActivityFinalNode transform(org.sparx.Element element, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363361340204_695662_2996) ENABLED START */
		LOG.debug("Creating ActivityFinalNode " + element.GetName() + ", parent " + parent.getName());
		
		ActivityFinalNode node = UMLFactory.eINSTANCE.createActivityFinalNode();
		node.setActivity(parent);
		node.setName(element.GetName());
		
		this.umlElement = node;
		this.eaElement = element;
		
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(element, node);
		return node;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363361279874_965542_2968) ENABLED START */
	
	/* PROTECTED REGION END */
}
