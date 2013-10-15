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
 * This class transforms packages to EMF UML. Other Elements are identified 
 * which are contained in these packages and their transformation classes are
 * called.
 * 
 * @author Gerrit Beine
 * @author Christian
 */
public class PackageTransformer extends AbstractPackageTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(PackageTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Package transform(org.sparx.Package p, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363947164598_385019_2609) ENABLED START */
		LOG.debug("Creating Package " + p.GetName());
		
		this.umlPackage = parent.createNestedPackage(p.GetName(), UMLFactory.eINSTANCE.createPackage().eClass());
		this.eaPackage = p;
		
		this.transformPackages();
		this.transformElements();
		
		ElementRegistry.INSTANCE.addPackage(p, this.umlPackage);
		return this.umlPackage;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformElement(org.sparx.Element element) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363947923410_360235_2625) ENABLED START */
		LOG.debug("Transforming element " + element.GetName() + ", type: " + element.GetType() + ", Stereotype Extension: " + element.GetStereotypeEx());
		
		if (element.GetType().equals("Actor")) {
			LOG.debug("Element is an Actor");
			LOG.error("not implemented yet!");
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
			// if element is an enumeration
			if (element.GetStereotypeEx().equals("enumeration")) {
				LOG.debug("Element is an Enumeration");
				EnumerationTransformer t = new EnumerationTransformer();
				t.transform(element, this.umlPackage);
			} else {
				// it's a class
				LOG.debug("Element is a Class");
				ClassTransformer t = new ClassTransformer();
				t.transform(element, this.umlPackage);
			}
			
		} else if (element.GetType().equals("Interface")) {
			LOG.debug("Element is a Interface");
			InterfaceTransformer t = new InterfaceTransformer();
			t.transform(element, this.umlPackage);
		} else if (element.GetType().equals("DataType")) {
			LOG.debug("Element is a DataType");
			DataTypeTransformer dt = new DataTypeTransformer();
			dt.transform(element, this.umlPackage);
		} else {
			LOG.error(element.GetType() + " is not implemented yet!");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363361205362_720789_2943) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
