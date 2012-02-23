package org.genesez.adapter.ea.transform;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.VisibilityKind;
import org.genesez.adapter.ea.ElementRegistry;


public class InterfaceTransformer extends AbstractElementTransformer {

	private static final Log log = LogFactory.getLog(InterfaceTransformer.class);
	
	Interface transform(org.sparx.Element _e, Package _parent) {
		log.debug("Creating Interface " + _e.GetName() + ", parent " + _parent.getName());
		Interface iface = _parent.createOwnedInterface(_e.GetName());
				
		setVisibility(_e, iface);
		
		this.umlElement = iface;
		this.eaElement = _e;

		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
//		ElementRegistry.instance.addElement(_e, iface);
		InterfaceFactory.instance.setInterfacePackage(_parent);
		ElementRegistry.instance.addInterface(_e, iface);				
		return iface;
	}
	
	private void setVisibility(org.sparx.Element _e, Interface iface){
		String visibility = _e.GetVisibility().trim();
		if (visibility.equals("Public")) {
			log.debug("Interface PUBLIC_LITERAL");
			iface.setVisibility(VisibilityKind.PUBLIC_LITERAL);
		} else if (visibility.equals("Private")) {
			log.debug("Interface PRIVATE_LITERAL");
			iface.setVisibility(VisibilityKind.PRIVATE_LITERAL);
		} else if (visibility.equals("Protected")) {
			log.debug("Interface PROTECTED_LITERAL");
			iface.setVisibility(VisibilityKind.PROTECTED_LITERAL);
		} else if (visibility.equals("Package")) {
			log.debug("Interface PACKAGE_LITERAL");
			iface.setVisibility(VisibilityKind.PACKAGE_LITERAL);
		}
	}
}
