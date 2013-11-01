package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363680456653_877987_1981) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class DecisionNodeTransformer extends AbstractActivityNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(DecisionNodeTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	e	
	 * @param	parent	
	 * @return	
	 */
	
	public DecisionNode transform(org.sparx.Element e, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363680508082_475526_2009) ENABLED START */
		LOG.debug("Creating DecisionNode " + e.GetName() + ", parent " + parent.getName());
		
		DecisionNode node = UMLFactory.eINSTANCE.createDecisionNode();
		node.setActivity(parent);
		node.setName(e.GetName());
		
		this.umlElement = node;
		this.eaElement = e;
		
		this.applyStereotypes();
		
		ElementRegistry.INSTANCE.addElement(e, node);
		return node;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363680456653_877987_1981) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
