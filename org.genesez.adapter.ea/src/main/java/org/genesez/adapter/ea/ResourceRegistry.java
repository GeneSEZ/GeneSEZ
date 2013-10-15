package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866962083_411037_2109) 
 */
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * A singleton class to handle Resources for the model transformation
 * 
 * The ResourceRegistry create and load resources for transforming the model.
 * It also provides access to the resources via their names.
 * 
 * @author Georg Beine
 * @author Christian
 */
public class ResourceRegistry {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ResourceRegistry.class);
	
	private static final ResourceSet RESOURCE_SET = new ResourceSetImpl();
	
	public static final ResourceRegistry INSTANCE = new ResourceRegistry();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ResourceRegistry</b></em>'.
	 */
	private ResourceRegistry() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363357186605_192075_2827) ENABLED START */
		// :-)
		// create URI
		URI primitiveURI = URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI);
		
		// load default primitve types
		Resource resource = RESOURCE_SET.getResource(primitiveURI, true);
		
		primitiveTypeModel = (org.eclipse.uml2.uml.Package) EcoreUtil.getObjectByType(resource.getContents(), UMLPackage.Literals.PACKAGE);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Load a resource by its URI and register it
	 */
	public Resource load(String name, URI uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363357194004_204759_2830) ENABLED START */
		LOG.debug("Loading resource " + name + " from " + uri);
		Resource resource = RESOURCE_SET.getResource(uri, true);
		this.resources.put(name, resource);
		return resource;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Creates a resource under a specified URI and register it
	 */
	public XMIResource create(String name, URI uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363357225737_550883_2839) ENABLED START */
		LOG.debug("Create resource " + name + " on " + uri);
		XMIResource resource = (XMIResource) RESOURCE_SET.createResource(uri);
		resource.setEncoding("UTF-8");
		this.resources.put(name, resource);
		return resource;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns a resource identified by its name
	 */
	public Resource getResource(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363357352383_552883_2852) ENABLED START */
		return this.resources.get(name);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public PrimitiveType importPrimitiveType(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381497755281_489730_3777) ENABLED START */
		Model umlLibrary = (Model) primitiveTypeModel;
		
		PrimitiveType primitiveType = (PrimitiveType) umlLibrary.getOwnedType(name);
		primitiveTypeModel.createElementImport(primitiveType);
		
		if (primitiveType != null) {
			LOG.debug("Primitive type '" + primitiveType.getQualifiedName() + "' imported.");
		}
		return primitiveType;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866962083_411037_2109) ENABLED START */
	private Map<String, Resource> resources = new HashMap<String, Resource>();
	
	private org.eclipse.uml2.uml.Package primitiveTypeModel = null;
	
	/* PROTECTED REGION END */
}
