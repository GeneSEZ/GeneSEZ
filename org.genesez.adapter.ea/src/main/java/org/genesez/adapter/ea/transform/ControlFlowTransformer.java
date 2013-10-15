package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_5_12d203c6_1363362657495_954836_3068) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.UMLFactory;
import org.genesez.adapter.ea.ElementRegistry;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class ControlFlowTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ControlFlowTransformer.class);
	
	private ControlFlow controlFlow = null;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public ControlFlow transform(org.sparx.Connector c, Activity parent) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363679994851_249212_1974) ENABLED START */
		LOG.debug("Creating ControlFlow " + c.GetName() + ", parent " + parent.getName());
		this.controlFlow = UMLFactory.eINSTANCE.createControlFlow();
		this.controlFlow.setActivity(parent);
		this.controlFlow.setName(c.GetName());
		ElementRegistry.INSTANCE.addConnector(c, this.controlFlow);
		return this.controlFlow;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_5_12d203c6_1363362657495_954836_3068) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
