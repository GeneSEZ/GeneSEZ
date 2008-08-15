package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.adapter.ea.transform.ModelTransformer;

public class Model2UML extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(Model2UML.class);

	private String inputSlot = null;
	private String outputSlot = null;
	
	public void checkConfiguration(Issues issues) {
		
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		org.sparx.Package inputModel = (org.sparx.Package)ctx.get(this.inputSlot);
		
		// Start transforming the model
		ModelTransformer t = new ModelTransformer();
		Model outputModel = t.transform(inputModel);
		PostProcessor.instance.startPostProcessing();
		
		ctx.set(this.outputSlot, outputModel);
	}

	public void setInputSlot(String value) {
		log.debug("Setting inputSlot to " + value);
		this.inputSlot = value;
	}

	public void setOutputSlot(String value) {
		log.debug("Setting outputSlot to " + value);
		this.outputSlot = value;
	}
}
