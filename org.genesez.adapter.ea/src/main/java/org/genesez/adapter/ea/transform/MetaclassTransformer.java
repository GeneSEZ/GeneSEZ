package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363946244537_586608_2561) 
 */

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
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ResourceRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class MetaclassTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(MetaclassTransformer.class);
	
	private static Model metaModel;
	
	private Class metaclass;
	
	private ElementImport elementImport;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Class transform(org.sparx.Element element, Profile parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363946601641_683663_2597) ENABLED START */
		LOG.debug("Creating Metaclass " + element.GetName() + ", parent " + parent.getName());
		this.metaclass = (Class) MetaclassTransformer.metaModel.getOwnedType(element.GetName());
		this.elementImport = parent.createMetaclassReference(this.metaclass);
		ElementRegistry.INSTANCE.addElement(element, this.elementImport);
		return this.metaclass;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363946244537_586608_2561) ENABLED START */
	static {
		Resource resource = ResourceRegistry.INSTANCE.load("UML_METAMODEL", URI.createURI(UMLResource.UML_METAMODEL_URI));
		MetaclassTransformer.metaModel = (Model) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.MODEL);
	}
	/* PROTECTED REGION END */
	
}
