package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363943800013_556704_2384) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * creates required interface
 * @author Christian
 */
public class RequiredInterfaceTransformer extends AbstractElementTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(RequiredInterfaceTransformer.class);
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Interface transform(org.sparx.Element element, Port parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363943956934_913920_2437) ENABLED START */
		LOG.debug("Creating RequiredInterface " + element.GetName() + ", parent " + parent.getName());
		
		Interface iface = ElementRegistry.INSTANCE.getInterfaceByName(element.GetName());
		
		this.umlElement = iface;
		this.eaElement = element;
		
		this.transformConnectors();
		this.transformAttributes();
		this.transformOperations();
		
		// add required interface to factory for postprocessing
		InterfaceFactory.INSTANCE.addRequiredInterface(element.GetName(), parent);
		
		return iface;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363943800013_556704_2384) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
