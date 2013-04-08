package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363939050176_299079_1974) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.FlowFinalNode;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ContentRegistry;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ProfileRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class FlowFinalNodeTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(FlowFinalNodeTransformer.class);
	
	private FlowFinalNode flowFinalNode;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public FlowFinalNode transform(org.sparx.Element element, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363939120424_322431_2005) ENABLED START */
		LOG.debug("Creating FlowFinalNode " + element.GetName() + ", parent " + parent.getName());
		this.flowFinalNode = UMLFactory.eINSTANCE.createFlowFinalNode();
		this.flowFinalNode.setActivity(parent);
		this.flowFinalNode.setName(element.GetName());
		this.applyStereotypes(element);
		ElementRegistry.INSTANCE.addElement(element, this.flowFinalNode);
		return this.flowFinalNode;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 */
	
	private void applyStereotypes(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363939192783_730094_2010) ENABLED START */
		for (String s : element.GetStereotypeList().split(",")) {
			LOG.debug("Search for stereotype " + s);
			Stereotype st = ProfileRegistry.INSTANCE.getStereotype(s);
			if (this.flowFinalNode.isStereotypeApplicable(st)) {
				LOG.debug("Apply stereotype " + st.getName());
				EObject o = this.flowFinalNode.applyStereotype(st);
				if (null != o) {
					ContentRegistry.INSTANCE.addContent(o);
				}
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363939050176_299079_1974) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
