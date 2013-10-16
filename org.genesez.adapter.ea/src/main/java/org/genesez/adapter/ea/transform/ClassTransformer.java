package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363942476721_653989_2257) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * 
 * @author Christian
 */
public class ClassTransformer extends AbstractElementTransformer {

	// -- generated attribute, constant + association declarations ----------

	private static final Log LOG = LogFactory.getLog(ClassTransformer.class);

	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Class transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942522238_266030_2282) ENABLED START */
		LOG.debug("Creating Class " + element.GetName() + ", parent "
				+ parent.getName());

		// TODO for development
		ElementDebugger.INSTANCE.printElement(element);

		// create class
		Class clazz = UMLFactory.eINSTANCE.createClass();
		clazz.setName(element.GetName());
		clazz.setIsLeaf(element.GetIsLeaf());
		clazz.setIsActive(element.GetIsActive());

		// is abstract
		if (element.GetAbstract().equals("1")) {
			clazz.setIsAbstract(true);
		} else {
			clazz.setIsAbstract(false);
		}

		// get description (in EA called notes) from class
		if (element.GetNotes().length() != 0) {
			clazz.createOwnedComment().setBody(element.GetNotes());
		}

		// set visibility
		clazz.setVisibility(VisibilityTransformer.INSTANCE
				.getVisibilityKind(element));

		parent.getPackagedElements().add(clazz);

		this.umlElement = clazz;
		this.eaElement = element;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();

		// apply stereotypes
		ApplyStereotypeTransformer.INSTANCE.applyStereotypes(element, clazz);

		ElementRegistry.INSTANCE.addElement(element, clazz);
		return clazz;
		/* PROTECTED REGION END */
	}

	/**
	 * Method stub for further implementation.
	 */
	protected void transformAttribute(org.sparx.Attribute eaAttribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942550717_486719_2287) ENABLED START */
		((Class) this.umlElement).getOwnedAttributes().add(
				AttributeTransformer.INSTANCE.transform(eaAttribute));
		/* PROTECTED REGION END */
	}

	/**
	 * Method stub for further implementation.
	 */
	protected void transformMethod(org.sparx.Method eaMethod) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363942597915_721139_2291) ENABLED START */
		((Class) this.umlElement).getOwnedOperations().add(
				OperationTransformer.INSTANCE.transform(eaMethod));
		/* PROTECTED REGION END */
	}

	// -- generated association + attribute accessors -----------------------

	// -- generated code ---------------------------------------------------

	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363942476721_653989_2257) ENABLED START */
	// :)
	/* PROTECTED REGION END */
}
