package org.genesez.adapter.ea;

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
 * 
 * @author gerbe
 *
 */
public class Model2UML extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(Model2UML.class);

	private String inputSlot = null;
	private String outputSlot = null;
	
	public void checkConfiguration(Issues issues) {
		// nothing to do here
	}

	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		PostProcessor.instance.initialize();
		ContentRegistry.instance.initialize();
		ElementRegistry.instance.initialize();

		log.debug("Get package from slot: " + this.inputSlot);
		org.sparx.Package inputModel = (org.sparx.Package)ctx.get(this.inputSlot);
				
		log.info("Start transforming the model...");
		ModelTransformer t = new ModelTransformer();
		Model outputModel = t.transform(inputModel);
		
		PostProcessor.instance.startPostProcessing();

		log.debug("Set model to slot: " + this.outputSlot);
		ctx.set(this.outputSlot, outputModel);

		log.info("Model transformation finished!");
		// close the repository
		RepositoryReader.closeRepository();
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
