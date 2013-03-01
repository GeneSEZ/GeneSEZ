package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.ProfileRegistry;

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
	
	private void applyProfiles() {
		for (Profile p : ProfileRegistry.instance.getProfiles()) {
			log.info("Applying Profile " + p.getName());
			this.umlPackage.applyProfile(p);
		}
	}
}
