package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363944629075_389873_2450) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.VisibilityKind;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author christian
 */

public class InterfaceTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(InterfaceTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	element	
	 * @param	parent	
	 * @return	
	 */
	
	public Interface transform(org.sparx.Element element, Package parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363944745586_266742_2480) ENABLED START */
		LOG.debug("Creating Interface " + element.GetName() + ", parent " + parent.getName());
		Interface iface = parent.createOwnedInterface(element.GetName());
		
		setVisibility(element, iface);
		
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
	 * @param	element	
	 * @param	iface	
	 */
	
	private void setVisibility(org.sparx.Element element, Interface iface) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363944671813_889779_2473) ENABLED START */
		String visibility = element.GetVisibility().trim();
		if (visibility.equals("Public")) {
			LOG.debug("Interface PUBLIC_LITERAL");
			iface.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		} else if (visibility.equals("Private")) {
			LOG.debug("Interface PRIVATE_LITERAL");
			iface.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		} else if (visibility.equals("Protected")) {
			LOG.debug("Interface PROTECTED_LITERAL");
			iface.setVisibility(VisibilityKind.PROTECTED_LITERAL);
		} else if (visibility.equals("Package")) {
			LOG.debug("Interface PACKAGE_LITERAL");
			iface.setVisibility(VisibilityKind.PACKAGE_LITERAL);
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363944629075_389873_2450) ENABLED START */
	
	/* PROTECTED REGION END */
	
}
