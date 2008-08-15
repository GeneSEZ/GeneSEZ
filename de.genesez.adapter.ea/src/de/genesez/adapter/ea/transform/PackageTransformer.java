package de.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

import de.genesez.adapter.ea.PostProcessor;
import de.genesez.adapter.ea.XmiFile;

public class PackageTransformer {

	private static final Log log = LogFactory.getLog(PackageTransformer.class);
	private Package pckage;
	
	Package transform(org.sparx.Package _p, Package _parent) {
		log.debug("Creating Package " + _p.GetName());
		this.pckage = _parent.createNestedPackage(_p.GetName(),
				UMLFactory.eINSTANCE.createPackage().eClass());
		this.transformPackages(_p);
		this.transformElements(_p);
		XmiFile.instance.addElement(this.pckage, _p.GetPackageGUID());
		return this.pckage;
	}

	private void transformPackages(org.sparx.Package _p) {
		for (org.sparx.Package p: _p.GetPackages()) {
			PackageTransformer t = new PackageTransformer();
			t.transform(p, this.pckage);
		}
	}

	private void transformElements(org.sparx.Package _p) {
		for (org.sparx.Element e: _p.GetElements()) {
			if ( 0 == e.GetParentID() ) {
				this.transformElement(e);
			}
		}
	}
	
	private void transformElement(org.sparx.Element _e) {
		log.debug("Transforming element " + _e.GetName());
		
		if ( _e.GetType().equals("Actor") ) {
			log.debug("Element is an Actor");
		}
		else if ( _e.GetType().equals("UseCase") ) {
			log.debug("Element is a UseCase");
			UseCaseTransformer t = new UseCaseTransformer();
			t.transform(_e, this.pckage);
		}
		else if ( _e.GetType().equals("Activity") ) {
			log.debug("Element is a Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(_e, this.pckage);
		}
	}
}
