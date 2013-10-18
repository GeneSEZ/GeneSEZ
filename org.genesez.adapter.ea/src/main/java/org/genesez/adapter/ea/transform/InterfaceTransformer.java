package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363944629075_389873_2450) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class InterfaceTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(InterfaceTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Interface transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363944745586_266742_2480) ENABLED START */
		LOG.debug("Creating Interface " + element.GetName() + ", parent: " + parent.getName());
		Interface iface = parent.createOwnedInterface(element.GetName());
		
		iface.setVisibility(VisibilityTransformer.INSTANCE.getVisibilityKind(element));
		
		this.umlElement = iface;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		InterfaceFactory.INSTANCE.setInterfacePackage(parent);
		ElementRegistry.INSTANCE.addInterface(element, iface);
		return iface;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformAttribute(org.sparx.Attribute eaAttribute) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381924876600_609433_3760) ENABLED START */
		AttributeTransformer.INSTANCE.transform(eaAttribute,umlElement);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void transformMethod(org.sparx.Method eaMethod) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381924909267_923566_3763) ENABLED START */
		((Interface) this.umlElement).getOwnedOperations().add(OperationTransformer.INSTANCE.transform(eaMethod));
		// TODO apply stereotypes
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363944629075_389873_2450) ENABLED START */
	// :)
	/* PROTECTED REGION END */
}
