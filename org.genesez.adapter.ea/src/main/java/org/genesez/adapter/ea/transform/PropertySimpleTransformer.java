package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363949546037_909056_2775) 
 */

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

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class PropertySimpleTransformer extends PropertyTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static Model metaModel;
	
	private Log log = LogFactory.getLog(PropertySimpleTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	protected Type findType() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363950042883_914097_2805) ENABLED START */
		Type type = null;
		
		if ("Integer".equals(this.eaAttribute.GetType()) || "int".equals(this.eaAttribute.GetType())) {
			log.debug("Property is an integer");
			type = PropertySimpleTransformer.metaModel.getOwnedType("Integer");
		} else if ("String".equals(this.eaAttribute.GetType()) || "string".equals(this.eaAttribute.GetType()) || "char".equals(this.eaAttribute.GetType())) {
			log.debug("Property is a string");
			type = PropertySimpleTransformer.metaModel.getOwnedType("String");
		} else if ("Boolean".equals(this.eaAttribute.GetType()) || "boolean".equals(this.eaAttribute.GetType())) {
			log.debug("Property is a boolean");
			type = PropertySimpleTransformer.metaModel.getOwnedType("Boolean");
		} else {
			log.fatal("No UML type defined for attribute type " + this.eaAttribute.GetType());
		}
		
		return type;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363949546037_909056_2775) ENABLED START */
	static {
		Resource resource = ResourceRegistry.INSTANCE.load("UML_METAMODEL", URI.createURI(UMLResource.UML_METAMODEL_URI));
		PropertySimpleTransformer.metaModel = (Model) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
	}
	/* PROTECTED REGION END */
	
}
