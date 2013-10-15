package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363939834854_646606_2039) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Generalization;
import org.genesez.adapter.ea.ElementRegistry;
import org.sparx.CustomProperty;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class GeneralizationTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(GeneralizationTransformer.class);
	
	public static final String ISSUBSTITUTABLE = "isSubstitutable";
	
	private Generalization generalization;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Generalization transform(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363940016007_661568_2079) ENABLED START */
		LOG.debug("Creating Generalization " + connector.GetName());
		
		// get the classifier from repository for client to add generalization
		client = (Classifier) ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		// get the supplier for the general
		supplier = (Classifier) ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		
		this.generalization = client.createGeneralization(supplier);
		
		// set isSubstitutable
		for (CustomProperty customProperty : connector.GetCustomProperties()) {
			if (customProperty.GetName().equals("isSubstitutable")) {
				if (customProperty.GetValue().equals("0")) {
					LOG.debug(ISSUBSTITUTABLE + " is " + customProperty.GetValue() + " (0)");
					generalization.setIsSubstitutable(false);
				} else {
					LOG.debug(ISSUBSTITUTABLE + " is " + customProperty.GetValue() + " (1)");
					generalization.setIsSubstitutable(true);
				}
			}
		}
		
		// persist in repository
		ElementRegistry.INSTANCE.addConnector(connector, this.generalization);
		
		return this.generalization;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363939834854_646606_2039) ENABLED START */
	
	// temporary classifiers
	private Classifier client = null, supplier = null;
	
	/*
	 * 
	 * if (ElementRegistry.INSTANCE.isExisting(connector.GetConnectorGUID())) {
			LOG.debug("Generalization already exist");
			return (Generalization) ElementRegistry.INSTANCE.getElement(connector.GetConnectorGUID());
		} else {
			this.generalization = UMLFactory.eINSTANCE.createGeneralization();
			ElementRegistry.INSTANCE.addElement(connector, this.generalization);
		}
	 */
	
	/* PROTECTED REGION END */
}
