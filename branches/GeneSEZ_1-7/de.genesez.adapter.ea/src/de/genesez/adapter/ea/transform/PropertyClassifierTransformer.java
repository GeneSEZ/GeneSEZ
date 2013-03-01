package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;

import de.genesez.adapter.ea.ElementRegistry;

public class PropertyClassifierTransformer extends PropertyTransformer {

	private static final Log log = LogFactory.getLog(PropertyClassifierTransformer.class);
	
	@Override
	public Property transform(org.sparx.Attribute _a, StructuredClassifier _parent) {
		return super.transform(_a, _parent);
	}
	
	@Override
	protected Type findType() {
		Element type = ElementRegistry.instance.getById(this.eaAttribute.GetClassifierID());

		if (type == null) {
			log.fatal("Classifier for attribute " + this.eaAttribute.GetName() + " not found");
		}

		return (Type)type;
	}
}
