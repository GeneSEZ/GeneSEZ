package de.genesez.adapter.ea;

import java.io.IOException;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.ConfigurationException;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class XmiWriter extends AbstractWorkflowComponent {

	private static final ResourceSet RESOURCE_SET = new ResourceSetImpl();
	private final static Log log = LogFactory.getLog(XmiWriter.class);

	private XMIResource resource = null;

	private String inputSlot = null;
	private String outputSlot = null;
	private String xmiFile = null;

	public void checkConfiguration(Issues issues) {
		URI fileURI = URI.createFileURI(this.xmiFile);
		this.resource = (XMIResource) RESOURCE_SET.createResource(fileURI);
		this.resource.setEncoding("UTF-8");
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			org.sparx.Package inputModel = (org.sparx.Package)ctx.get(inputSlot);

			TransformHelper t = new TransformHelper();
			// The resource is required for applying GUIDs
			t.setResource(this.resource);

			// Start transforming the model
			Model outputModel = t.transform(inputModel);

			// Save the XMI output
			this.save(outputModel);

			ctx.set(outputSlot, outputModel);
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
	
	/**
	 * Write the UML model into an XMI resource 
	 * @param o		the UML model reference
	 */
	private void save(Model o) {
		this.resource.getContents().add(o);
		try 
		{
	        this.resource.save(Collections.EMPTY_MAP);
		} 
		catch (final IOException e) 
		{
			throw new ConfigurationException(e);
		}
	}
}
