package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363943816181_363402_2407) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * transforms provided interface
 * @author Christian
 */
public class ProvidedInterfaceTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ProvidedInterfaceTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Interface transform(org.sparx.Element element, Port parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363944044823_397384_2442) ENABLED START */
		LOG.debug("Creating ProvidedInterface " + element.GetName() + ", parent " + parent.getName());
		
		Interface iface = ElementRegistry.INSTANCE.getInterfaceByName(element.GetName());
		
		this.umlElement = iface;
		this.eaElement = element;
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// add provided interface to factory		
		InterfaceFactory.INSTANCE.addProvidedInterface(element.GetName(), parent);
		
		return iface;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363943816181_363402_2407) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
