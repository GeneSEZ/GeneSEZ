package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.StructuredClassifier;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;

public class StereotypeTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(StereotypeTransformer.class);
	
	Stereotype transform(org.sparx.Element _e, Profile _parent) {
		log.debug("Creating Stereotype " + _e.GetName() + ", parent " + _parent.getName());
		Stereotype stereotype = _parent.createOwnedStereotype(_e.GetName());
		
		this.umlElement = stereotype;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		
		ElementRegistry.instance.addElement(_e, stereotype);
		return stereotype;
	}

	@Override
	protected void transformAttribute(org.sparx.Attribute _a) {
		log.debug("Transforming attribute " + _a.GetName());
		
		if (_a.GetClassifierID() > 0 ) {
			log.debug("Attribute is structured type");
			PostProcessor.instance.setProperty((Stereotype)this.umlElement, _a);
		}
		else {
			log.debug("Attribute is primitive type");
			PropertySimpleTransformer t = new PropertySimpleTransformer();
			t.transform(_a, (Stereotype)this.umlElement);
		}
	}

	@Override
	protected void transformConnector(org.sparx.Connector _c) {
		log.debug("Transforming connector " + _c.GetName());
		
		if ( _c.GetType().equals("Generalization")) {
			log.debug("Connector is a Generalization");
			GeneralizationTransformer t = new GeneralizationTransformer();
			Generalization g = t.transform(_c);
			if (_c.GetSupplierID() == this.eaElement.GetElementID()) {
				g.setGeneral((Stereotype)this.umlElement);
			}
			else if ( _c.GetClientID() == this.eaElement.GetElementID()) {
				g.setSpecific((Stereotype)this.umlElement);
			}
		}
	}
}
