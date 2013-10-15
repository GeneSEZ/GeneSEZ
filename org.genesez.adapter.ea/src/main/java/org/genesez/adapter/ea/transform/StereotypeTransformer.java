package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363954598956_480056_2810) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.PostProcessor;

/**
 * applies stereotypes that have been read from profile-files to the elements 
 * @author Christian
 */
public class StereotypeTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(StereotypeTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Stereotype transform(org.sparx.Element element, Profile parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363954738823_497759_2867) ENABLED START */
		LOG.debug("Creating Stereotype " + element.GetName() + ", parent " + parent.getName() + ", abstract(" + element.GetAbstract() + ")");
		
		Stereotype stereotype = parent.createOwnedStereotype(element.GetName(), element.GetAbstract().equals("0") ? false : true);
		
		this.umlElement = stereotype;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		
		ElementRegistry.INSTANCE.addElement(element, stereotype);
		return stereotype;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transform(org.sparx.Attribute attribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363954712293_596056_2863) ENABLED START */
		LOG.debug("Transforming attribute " + attribute.GetName());
		
		if (attribute.GetClassifierID() > 0) {
			LOG.debug("Attribute is structured type");
			PostProcessor.INSTANCE.addProperty2Classifier((Stereotype) this.umlElement, attribute);
		} else {
			LOG.debug("Attribute is primitive type");
			PropertySimpleTransformer t = new PropertySimpleTransformer();
			t.transform(attribute, (Stereotype) this.umlElement);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformConnector(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363954836637_459802_2875) ENABLED START */
		LOG.debug("Transforming connector " + connector.GetName());
		
		if (connector.GetType().equals("Generalization")) {
			LOG.debug("Connector is a Generalization");
			GeneralizationTransformer t = new GeneralizationTransformer();
			Generalization g = t.transform(connector);
			if (connector.GetSupplierID() == this.eaElement.GetElementID()) {
				g.setGeneral((Stereotype) this.umlElement);
			} else if (connector.GetClientID() == this.eaElement.GetElementID()) {
				g.setSpecific((Stereotype) this.umlElement);
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363954598956_480056_2810) ENABLED START */
	// :)
	/* PROTECTED REGION END */
}
