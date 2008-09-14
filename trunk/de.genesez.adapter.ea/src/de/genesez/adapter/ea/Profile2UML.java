package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Profile;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.adapter.ea.transform.ProfileTransformer;

/**
 * An oAW workflow component to transfrom an Enterprise Architect profile into an UML profile
 * 
 * @author gerbe
 *
 * The Profile2UML workflow component transforms an Enterprise Architect package
 * from the input slot into an UML profile and put transformed profile to the
 * output slot.
 */
public class Profile2UML extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(Profile2UML.class);

	private String inputSlot = null;
	private String outputSlot = null;
	
	public void checkConfiguration(Issues issues) {
		// nothing to do here
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		PostProcessor.instance.initialize();
		ContentRegistry.instance.initialize();
		ElementRegistry.instance.initialize();

		log.debug("Get package from slot: " + this.inputSlot);
		org.sparx.Package inputPackage = (org.sparx.Package)ctx.get(this.inputSlot);
		PostProcessor.instance.initialize();

		log.info("Start transforming the profile...");
		ProfileTransformer t = new ProfileTransformer();
		Profile outputProfile = t.transform(inputPackage);
		PostProcessor.instance.startPostProcessing();
		outputProfile.define();

		log.debug("Set profile to slot: " + this.outputSlot);
		ctx.set(this.outputSlot, outputProfile);

		log.info("Profile definition finished!");
	}

	/**
	 * Set the input slot from where to get the Enterprise Architect model
	 * @param value	The slot name
	 */
	public void setInputSlot(String value) {
		log.debug("Setting inputSlot to " + value);
		this.inputSlot = value;
	}

	/**
	 * Set the output slot where to put the UML model
	 * @param value	The slot name
	 */
	public void setOutputSlot(String value) {
		log.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
	}
}
