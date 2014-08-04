package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363944802228_497529_2486) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.JoinNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class JoinNodeTransformer extends AbstractActivityNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(JoinNodeTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public JoinNode transform(org.sparx.Element element, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363945599932_858436_2511) ENABLED START */
		LOG.debug("Creating JoinNode " + element.GetName() + ", parent " + parent.getName());
		
		JoinNode node = UMLFactory.eINSTANCE.createJoinNode();
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363944802228_497529_2486) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
