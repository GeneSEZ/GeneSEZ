package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363939834854_646606_2039) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class GeneralizationTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(GeneralizationTransformer.class);
	
	private Generalization generalization;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	connector	
	 * @return	
	 */
	
	public Generalization transform(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363940016007_661568_2079) ENABLED START */
		LOG.debug("Creating Generalization " + connector.GetName());
		if (ElementRegistry.INSTANCE.isExisting(connector.GetConnectorGUID())) {
			LOG.debug("Generalization already exist");
			return (Generalization) ElementRegistry.INSTANCE.getElement(connector.GetConnectorGUID());
		} else {
			this.generalization = UMLFactory.eINSTANCE.createGeneralization();
			ElementRegistry.INSTANCE.addElement(connector, this.generalization);
		}
		return this.generalization;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363939834854_646606_2039) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
