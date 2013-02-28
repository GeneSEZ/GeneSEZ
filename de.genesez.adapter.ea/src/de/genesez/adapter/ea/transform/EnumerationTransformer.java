package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.Package;

import de.genesez.adapter.ea.ElementRegistry;

public class EnumerationTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(EnumerationTransformer.class);
	
	Enumeration transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating Enumeration " + _e.GetName() + ", parent " + _parent.getName());

		Enumeration enumeration = _parent.createOwnedEnumeration(_e.GetName());
		this.umlElement = enumeration;
		this.eaElement = _e;

		this.transformAttributes();
		this.applyStereotypes();

		ElementRegistry.instance.addElement(_e, enumeration);
		return enumeration;
	}

	@Override
	protected void transformAttribute(org.sparx.Attribute _a) {
		log.debug("Transforming attribute " + _a.GetName());
		
		if ( 0 < _a.GetClassifierID() ) {
			log.debug("Attribute is structured type");
			EnumerationLiteral l = ((Enumeration)this.umlElement).createOwnedLiteral(_a.GetName());
			ElementRegistry.instance.addElement(_a, l);
		}
		else {
			log.debug("Attribute is primitive type");
			EnumerationLiteral l = ((Enumeration)this.umlElement).createOwnedLiteral(_a.GetName());
			ElementRegistry.instance.addElement(_a, l);
		}
	}

}
