package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.ResourceRegistry;

public class MetaclassTransformer {

	private static final Log log = LogFactory.getLog(MetaclassTransformer.class);
	private static Model metamodel;
	private Class metaclass;
	private ElementImport elementImport;
	
	static {
		Resource resource = ResourceRegistry.instance.load("UML_METAMODEL", URI.createURI(UMLResource.UML_METAMODEL_URI));
		MetaclassTransformer.metamodel = (Model) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
	}
	
	Class transform(org.sparx.Element _e, Profile _parent) {
		log.debug("Creating Metaclass " + _e.GetName() + ", parent " + _parent.getName());
		this.metaclass = (Class) MetaclassTransformer.metamodel.getOwnedType(_e.GetName());
		this.elementImport = _parent.createMetaclassReference(this.metaclass);
		ElementRegistry.instance.addElement(_e, this.elementImport);
		return this.metaclass;
	}
}
