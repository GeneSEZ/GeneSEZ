package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;

public abstract class AbstractPackageTransformer {

	private static final Log log = LogFactory.getLog(AbstractPackageTransformer.class);
	protected Package umlPackage = null;
	protected org.sparx.Package eaPackage = null;

	protected void transformPackages() {
		for (org.sparx.Package p: this.eaPackage.GetPackages()) {
			PackageTransformer t = new PackageTransformer();
			t.transform(p, this.umlPackage);
		}
	}

	protected void transformElements() {
		for (org.sparx.Element e: this.eaPackage.GetElements()) {
			if ( 0 == e.GetParentID() ) {
				this.transformElement(e);
			}
		}
	}
	
	protected void transformElement(org.sparx.Element _e) {
		log.fatal("Transforming elements is not implemented!");
	}
}
