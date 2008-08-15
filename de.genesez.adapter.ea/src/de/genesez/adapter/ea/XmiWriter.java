package de.genesez.adapter.ea;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.adapter.ea.transform.ModelTransformer;

public class XmiWriter extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(XmiWriter.class);

	private String inputSlot = null;
	private String outputSlot = null;
	private String xmiFile = null;

	public void checkConfiguration(Issues issues) {
		XmiFile.instance.setFilename(this.xmiFile);
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			org.sparx.Package inputModel = (org.sparx.Package)ctx.get(this.inputSlot);
			
			// Start transforming the model
			ModelTransformer t = new ModelTransformer();
			Model outputModel = t.transform(inputModel);
			PostProcessor.instance.startPostProcessing();

			// Save the XMI output
			XmiFile.instance.save();

			ctx.set(this.outputSlot, outputModel);
		} catch (Exception e) {
			issues.addError(e.toString());
		}
	}
	
	/**
	 * Set the name of the XMI output file
	 * @param value
	 */
	public void  setXmiFile(String value) {
		this.xmiFile = value;
	}
	
	/**
	 * Set the workflow input slot
	 * @param value
	 */
	public void  setInputSlot(String value) {
		this.inputSlot = value;
	}

	/**
	 * Set the workflow output slot
	 * @param value
	 */
	public void  setOutputSlot(String value) {
		this.outputSlot = value;
	}
}
