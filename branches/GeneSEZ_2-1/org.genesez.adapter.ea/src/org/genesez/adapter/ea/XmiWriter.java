package org.genesez.adapter.ea;

import java.util.Collections;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Model;

/**
 * An oAW workflow component to write an UML XWI file
 * 
 * @author gerbe
 * @author christian
 *
 * The XmiWriter creates an XMI output file from a UML model.
 * The model needs to be placed in the input slot.
 */
public class XmiWriter extends AbstractWorkflowComponent {

	private static final Log log = LogFactory.getLog(XmiWriter.class);

	private String inputSlot = null;
	private String xmiFile = null;
	private String resourceSlot = null;

	public void checkConfiguration(Issues issues) {
		URI uri = URI.createURI(this.xmiFile);
		log.debug("Creating URI: " + uri);
		ResourceRegistry.instance.create(this.resourceSlot, uri);
	}
	
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		try {
			log.info("Start writing XMI file...");
			log.debug("Get model from slot: " + this.inputSlot);
			Model output = (Model) ctx.get(this.inputSlot);
			log.debug("Get resource from slot: " + this.resourceSlot);
			XMIResource resource = (XMIResource) ResourceRegistry.instance.get(this.resourceSlot);
			resource.getContents().add(output);
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
			log.info("Finished!");
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
