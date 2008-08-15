package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.ElementRegistry;
import de.genesez.adapter.ea.ProfileRegistry;

public class ModelTransformer {

	private static final Log log = LogFactory.getLog(ModelTransformer.class);
	private Model model;
	
	public Model transform(org.sparx.Package _p) {
		log.debug("Creating Model " + _p.GetName());
		this.model = UMLFactory.eINSTANCE.createModel();
		this.model.setName(_p.GetName());
		this.transformPackages(_p);
		this.applyProfiles();
		ElementRegistry.instance.addElement(_p.GetPackageGUID(), this.model);
		return this.model;
	}
	
	private void transformPackages(org.sparx.Package _p) {
		for (org.sparx.Package p: _p.GetPackages()) {
			PackageTransformer t = new PackageTransformer();
			t.transform(p, this.model);
		}
	}
	
	private void applyProfiles() {
		for (Profile p : ProfileRegistry.instance.getProfiles()) {
			log.info("Applying Profile " + p.getName());
			this.model.applyProfile(p);
		}
	}
}
