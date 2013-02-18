package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.genesez.adapter.ea.ResourceRegistry;


public class PropertySimpleTransformer extends PropertyTransformer {

	private static final Log log = LogFactory.getLog(PropertySimpleTransformer.class);
	private static Model metamodel;

	static {
		Resource resource = ResourceRegistry.instance.load("UML_METAMODEL", URI.createURI(UMLResource.UML_METAMODEL_URI));
		PropertySimpleTransformer.metamodel = (Model) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
	}
	
	@Override
	protected Type findType() {
		Type type = null;
		
		if ( "Integer".equals(this.eaAttribute.GetType()) || "int".equals(this.eaAttribute.GetType()) ) {
			log.debug("Property is an integer");
			type = PropertySimpleTransformer.metamodel.getOwnedType("Integer");
		}
		else if ( "String".equals(this.eaAttribute.GetType()) || "string".equals(this.eaAttribute.GetType()) || "char".equals(this.eaAttribute.GetType()) ) {
			log.debug("Property is a string");
			type = PropertySimpleTransformer.metamodel.getOwnedType("String");
		}
		else if ( "Boolean".equals(this.eaAttribute.GetType()) || "boolean".equals(this.eaAttribute.GetType()) ) {
			log.debug("Property is a boolean");
			type = PropertySimpleTransformer.metamodel.getOwnedType("Boolean");
		} else {
			log.fatal("No UML type defined for attribute type " + this.eaAttribute.GetType());
		}

		return type;
	}
}
