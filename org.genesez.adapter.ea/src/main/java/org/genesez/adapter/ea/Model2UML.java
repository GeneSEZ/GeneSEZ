package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866896079_680980_1946) 
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Model;
import org.genesez.adapter.ea.transform.ModelTransformer;

/**
 * An oAW workflow component transforming an Enterprise Architect model to an UML model
 * @author christian
 */

public class Model2UML extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(Model2UML.class);
	
	private String inputSlot;
	
	private String outputSlot;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	i	
	 */
	
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096010600_76200_2036) ENABLED START */
		
		// nothing to do here
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	ctx	
	 * @param	pm	
	 * @param	i	
	 */
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor pm, Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096075214_441362_2041) ENABLED START */
		PostProcessor.INSTANCE.initialize();
		ContentRegistry.INSTANCE.initialize();
		ElementRegistry.INSTANCE.initialize();
		
		LOG.debug("Get package from slot: " + this.inputSlot);
		org.sparx.Package inputModel = (org.sparx.Package) ctx.get(this.inputSlot);
		
		LOG.info("Start transforming the model...");
		ModelTransformer t = new ModelTransformer();
		Model outputModel = t.transform(inputModel);
		
		PostProcessor.INSTANCE.startPostProcessing();
		
		LOG.debug("Set model to slot: " + this.outputSlot);
		ctx.set(this.outputSlot, outputModel);
		
		LOG.info("Model transformation finished!");
		// close the repository
		RepositoryReader.closeRepository();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the input slot from where to get the Enterprise Architect model
	 * @param	value	the slot name
	 */
	
	public void setInputSlot(String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363339371570_303169_1997) ENABLED START */
		LOG.debug("Setting inputSlot to " + value);
		this.inputSlot = value;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Set the output slot where to put the UML model
	 * @param	value	the slot name
	 */
	
	public void setOuputSlot(String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363339445341_984666_2007) ENABLED START */
		LOG.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866896079_680980_1946) ENABLED START */
	
	/* PROTECTED REGION END */
	
}
