package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363361205362_720789_2943) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class PackageTransformer extends AbstractPackageTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PackageTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	p	
	 * @param	parent	
	 * @return	
	 */
	
	public Package transform(org.sparx.Package p, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363947164598_385019_2609) ENABLED START */
		LOG.debug("Creating Package " + p.GetName());
		
		this.umlPackage = parent.createNestedPackage(p.GetName(), UMLFactory.eINSTANCE.createPackage().eClass());
		this.eaPackage = p;
		
		this.transformPackages();
		this.transformElements();
		
		ElementRegistry.INSTANCE.addElement(p, this.umlPackage);
		return this.umlPackage;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 */
	
	protected void transform(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363947923410_360235_2625) ENABLED START */
		LOG.debug("Transforming element " + element.GetName() + ", type: " + element.GetType());
		
		if (element.GetType().equals("Actor")) {
			LOG.debug("Element is an Actor");
		} else if (element.GetType().equals("UseCase")) {
			LOG.debug("Element is a UseCase");
			UseCaseTransformer t = new UseCaseTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("Activity")) {
			LOG.debug("Element is a Activity");
			ActivityTransformer t = new ActivityTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("Component")) {
			LOG.debug("Element is a Component");
			ComponentTransformer t = new ComponentTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("Class")) {
			LOG.debug("Element is a Class");
			ClassTransformer t = new ClassTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("Interface")) {
			LOG.debug("Element is a Interface");
			InterfaceTransformer t = new InterfaceTransformer();
			t.transform(element, this.umlPackage);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363361205362_720789_2943) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
