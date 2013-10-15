package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363949200668_792167_2693) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class PropertyClassifierTransformer extends PropertyTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PropertyClassifierTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Property transform(org.sparx.Attribute attribute, StructuredClassifier parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363949493489_939916_2765) ENABLED START */
		return super.transform(attribute, parent);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected Type findType() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363949530953_491515_2770) ENABLED START */
		Element type = ElementRegistry.INSTANCE.getElementById(this.eaAttribute.GetClassifierID());
		
		if (type == null) {
			LOG.fatal("Classifier for attribute " + this.eaAttribute.GetName() + " not found");
		}
		
		return (Type) type;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363949200668_792167_2693) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
