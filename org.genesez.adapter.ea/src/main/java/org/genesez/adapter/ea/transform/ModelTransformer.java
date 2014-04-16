package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363340173835_292420_2022) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ProfileRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class ModelTransformer extends AbstractPackageTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ModelTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	p	
	 * @return	
	 */
	
	public Model transform(org.sparx.Package p) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363340285003_348934_2050) ENABLED START */
		LOG.debug("Creating Model " + p.GetName());
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(p.GetName());
		
		this.umlPackage = model;
		this.eaPackage = p;
		
		this.applyProfiles();
		this.transformPackages();
		
		ElementRegistry.INSTANCE.addElement(p, model);
		return model;
		/* PROTECTED REGION END */
	}
	
	/**
	 * applies profiles to the transforming model
	 */
	
	private void applyProfiles() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363340400038_468116_2059) ENABLED START */
		for (Profile p : ProfileRegistry.INSTANCE.getProfiles()) {
			LOG.info("Applying Profile " + p.getName());
			this.umlPackage.applyProfile(p);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	uri	
	 * @return	
	 */
	
	protected static Package load(URI uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363340418177_894154_2062) ENABLED START */
		LOG.fatal("LOADING PACKAGE URI -> " + uri.toFileString());
		org.eclipse.uml2.uml.Package tempPackage = null;
		
		ResourceSet rs = new ResourceSetImpl();
		
		try {
			
			Resource resource = rs.getResource(uri, true);
			
			tempPackage = (org.eclipse.uml2.uml.Package) EcoreUtil.getObjectByType(
			
			resource.getContents(), UMLPackage.Literals.PACKAGE);
			
		} catch (WrappedException we) {
			
			LOG.debug(we.getMessage());
			
			System.exit(1);
			
		}
		
		return tempPackage;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363340173835_292420_2022) ENABLED START */
	
	// :)
	
	/* PROTECTED REGION END */
	
}
