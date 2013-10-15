package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363938915240_693010_1936) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class ExtensionTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ExtensionTransformer.class);
	
	private Extension extension;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Extension transform(org.sparx.Connector connector, Stereotype stereotype, Class clazz) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363938973250_499981_1967) ENABLED START */
		LOG.debug("Creating Extension " + connector.GetName() + ", stereotype " + stereotype.getName());
		Extension e = stereotype.createExtension(clazz, false);
		ElementRegistry.INSTANCE.addConnector(connector, e);
		return this.extension;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363938915240_693010_1936) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
