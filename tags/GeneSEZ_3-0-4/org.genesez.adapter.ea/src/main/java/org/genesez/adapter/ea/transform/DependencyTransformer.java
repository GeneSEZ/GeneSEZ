package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363680908893_36606_2020) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;

/**
 * transform dependency
 * 
 * @author Georg Beine
 * @author christian
 */

public class DependencyTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(DependencyTransformer.class);
	
	/**
	 * overwrite the default element to connector
	 */
	
	private org.sparx.Connector eaElement = null;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	c	
	 * @param	parent	
	 * @return	
	 */
	
	public Dependency transform(org.sparx.Connector c, Component parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363681025871_76617_2052) ENABLED START */
		LOG.debug("Creating Dependency " + c.GetName() + ", parent " + parent.getName());
		
		Dependency dependency = UMLFactory.eINSTANCE.createDependency();
		dependency.setName(c.GetName());
		
		dependency.getClients().add(parent);
		
		parent.getPackagedElements().add(dependency);
		
		this.umlElement = dependency;
		this.eaElement = c;
		
		// apply stereotypes
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(eaElement, dependency);
		
		ElementRegistry.INSTANCE.addElement(c, dependency);
		
		// Add dependency to postprocessor for connections
		PostProcessor.INSTANCE.addDependency(dependency, c);
		return dependency;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363680908893_36606_2020) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
