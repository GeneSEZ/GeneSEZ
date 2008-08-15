package de.genesez.adapter.ea;

import java.util.Collections;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

public class XmiWriter extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(XmiWriter.class);

	private String inputSlot = null;
	private String xmiFile = null;
	private String resourceSlot = null;

	public void checkConfiguration(Issues issues) {
		URI uri = URI.createFileURI(this.xmiFile);
		ResourceRegistry.instance.create(this.resourceSlot, uri);
	}
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			log.info("Start writing XMI file...");
			log.debug("Get model from slot: " + this.inputSlot);
			Model outputModel = (Model) ctx.get(this.inputSlot);
			log.debug("Get resource from slot: " + this.resourceSlot);
			XMIResource resource = (XMIResource) ResourceRegistry.instance.get(this.resourceSlot);
			resource.getContents().add(outputModel);
			for (Entry<String, Element> e : ElementRegistry.instance.getElements()) {
				log.debug("Add element " + e.getKey());
				resource.setID(e.getValue(), e.getKey());
			}
			for (EObject e : ContentRegistry.instance.getContents()) {
				log.debug("Add content " + e.toString());
				resource.getContents().add(e);				
			}
			log.debug("Save XMI file");
			resource.save(Collections.EMPTY_MAP);
			log.info("Finished writing XMI file!");
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
	 * Set the workflow resource slot
	 * @param value
	 */
	public void  setResourceSlot(String value) {
		log.debug("Setting resourceSlot to " + value);
		this.resourceSlot = value;
	}
}
