package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.ResourceRegistry;

public class PropertyClassifierTransformer extends PropertyTransformer {

	private static final Log log = LogFactory.getLog(PropertyClassifierTransformer.class);
	
	@Override
	public Property transform(org.sparx.Attribute _a, StructuredClassifier _parent) {
		return super.transform(_a, _parent);
	}
	
	@Override
	protected Type findType() {
		Type type = (Type)ElementRegistry.instance.getById(this.eaAttribute.GetClassifierID());

		if (type == null) {
			log.fatal("Classifier for attribute " + this.eaAttribute.GetName() + " not found");
		}
		
		return type;
	}
}
