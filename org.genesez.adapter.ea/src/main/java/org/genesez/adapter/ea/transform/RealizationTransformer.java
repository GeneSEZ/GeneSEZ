package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1381844000660_315683_3648) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.InterfaceRealization;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class RealizationTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(RealizationTransformer.class);
	
	private InterfaceRealization interfaceRealization;
	
	private Class clazz;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public InterfaceRealization transform(org.sparx.Connector connector) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1381844023592_715825_3668) ENABLED START */
		LOG.info("Start transforming InterfaceRealization -> Name(" + connector.GetName() + ")");
		
		// get the interface
		Interface iface = (Interface) ElementRegistry.INSTANCE.getElementById(connector.GetSupplierID());
		
		clazz = (Class) ElementRegistry.INSTANCE.getElementById(connector.GetClientID());
		
		this.interfaceRealization = clazz.createInterfaceRealization(connector.GetName(), iface);
		
		ElementRegistry.INSTANCE.addConnector(connector, this.interfaceRealization);
		return interfaceRealization;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1381844000660_315683_3648) ENABLED START */
	// :)
	/* PROTECTED REGION END */
}
