package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.genesez.adapter.ea.ElementRegistry;
import org.genesez.adapter.ea.ProfileRegistry;


public class ModelTransformer extends AbstractPackageTransformer {

	private static final Log log = LogFactory.getLog(ModelTransformer.class);

	public Model transform(org.sparx.Package _p) {
		log.debug("Creating Model " + _p.GetName());
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName(_p.GetName());

		this.umlPackage = model;
		this.eaPackage = _p;

		this.applyProfiles();
		this.transformPackages();

		ElementRegistry.instance.addElement(_p, model);
		return model;
	}

	/**
	 * applies profiles to the transforming model
	 */
	private void applyProfiles() {
		for (Profile p : ProfileRegistry.instance.getProfiles()) {
			log.info("Applying Profile " + p.getName());
			this.umlPackage.applyProfile(p);			
		}
	}

	protected static org.eclipse.uml2.uml.Package load(URI uri) {
		log.fatal("LOADING PACKAGE URI -> "+ uri.toFileString());
		org.eclipse.uml2.uml.Package package_ = null;

		ResourceSet rs = new ResourceSetImpl();

		try {

			Resource resource = rs.getResource(uri, true);

			package_ = (org.eclipse.uml2.uml.Package) EcoreUtil
					.getObjectByType(

					resource.getContents(), UMLPackage.Literals.PACKAGE);

		} catch (WrappedException we) {

			log.debug(we.getMessage());

			System.exit(1);

		}

		return package_;

	}

}
