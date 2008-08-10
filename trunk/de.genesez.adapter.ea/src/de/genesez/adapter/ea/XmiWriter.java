package de.genesez.adapter.ea;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
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

	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		URI fileURI = URI.createFileURI(this.xmiFile);
		this.resource = (XMIResource) RESOURCE_SET.createResource(fileURI);
		this.resource.setEncoding("UTF-8");

		try {
			org.sparx.Package inputModel = (org.sparx.Package)ctx.get(inputSlot);
			Model outputModel = this.transformModel(inputModel);
			ctx.set(outputSlot, outputModel);
		} catch (Exception e) {
			issues.addError(e.toString());
		}
	}
	
	public void  setXmiFile(String value) {
		this.xmiFile = value;
	}
	
	public void  setInputSlot(String value) {
		this.inputSlot = value;
	}

	public void  setOutputSlot(String value) {
		this.outputSlot = value;
	}
	
	private Model transformModel(org.sparx.Package inputModel) {
		Model outputModel = UMLFactory.eINSTANCE.createModel();

		// The resource is required for applying GUIDs
		TransformHelper.setResource(this.resource);

		// Start transforming the model
		TransformHelper.transform(inputModel, outputModel);
		
		// Save the XMI output
		this.save();
		
		return outputModel;
	}
	
	private void save() {
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
