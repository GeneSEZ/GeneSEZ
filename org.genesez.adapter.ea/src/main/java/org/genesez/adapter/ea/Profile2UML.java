package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866926613_182323_2017) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Profile;
import org.genesez.adapter.ea.transform.ProfileTransformer;

/**
 * An oAW workflow component to transform an Enterprise Architect profile into an UML profile
 * 
 * The Profile2UML workflow component transforms an Enterprise Architect package
 * from the input slot into an UML profile and put transformed profile to the
 * output slot.
 * @author Christian
 */
public class Profile2UML extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(Profile2UML.class);
	
	private String inputSlot = "null";
	
	private String outputSlot = "null";
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096557648_725848_2092) ENABLED START */
		
		// nothing
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor pm, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096582750_554232_2112) ENABLED START */
		PostProcessor.INSTANCE.initialize();
		ContentRegistry.INSTANCE.initialize();
		ElementRegistry.INSTANCE.initialize();
		
		LOG.debug("Get package from slot: " + this.inputSlot);
		org.sparx.Package inputPackage = (org.sparx.Package) ctx.get(this.inputSlot);
		PostProcessor.INSTANCE.initialize();
		
		LOG.info("Start transforming the profile...");
		ProfileTransformer t = new ProfileTransformer();
		Profile outputProfile = t.transform(inputPackage);
		PostProcessor.INSTANCE.startPostProcessing();
		outputProfile.define();
		
		LOG.debug("Set profile to slot: " + this.outputSlot);
		ctx.set(this.outputSlot, outputProfile);
		
		LOG.info("Profile definition finished!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets the value of attribute '<em><b>inputSlot</b></em>'.
	 * @param	inputSlot	the value to set.
	 */
	public void setInputSlot(String inputSlot) {
		this.inputSlot = inputSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>outputSlot</b></em>'.
	 * @param	outputSlot	the value to set.
	 */
	public void setOutputSlot(String outputSlot) {
		this.outputSlot = outputSlot;
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866926613_182323_2017) ENABLED START */
	
	// :)
	
	/* PROTECTED REGION END */
}
