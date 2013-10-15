package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1357563663287_857534_1735) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public abstract class AbstractPackageTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(AbstractPackageTransformer.class);
	
	protected Package umlPackage = null;
	
	protected org.sparx.Package eaPackage = null;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	protected void transformPackages() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1357565335128_470814_1766) ENABLED START */
		for (org.sparx.Package p : this.eaPackage.GetPackages()) {
			PackageTransformer t = new PackageTransformer();
			t.transform(p, this.umlPackage);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformElements() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1357565346401_430118_1769) ENABLED START */
		for (org.sparx.Element e : this.eaPackage.GetElements()) {
			if (0 == e.GetParentID()) {
				this.transformElement(e);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformElement(org.sparx.Element e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363361108635_530655_2939) ENABLED START */
		LOG.fatal("Transforming elements is not implemented!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1357563663287_857534_1735) ENABLED START */
	
	/* PROTECTED REGION END */
}
