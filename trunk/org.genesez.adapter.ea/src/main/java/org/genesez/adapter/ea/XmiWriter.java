package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866975656_393979_2132) 
 */
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
 * The XmiWriter creates an XMI output file from a UML model.
 * The model needs to be placed in the input slot.
 * 
 * @author Georg Beine
 * @author Christian
 */
public class XmiWriter extends AbstractWorkflowComponent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(XmiWriter.class);
	
	private String inputSlot = "null";
	
	private String xmiFile = "null";
	
	private String resourceSlot = "null";
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public void checkConfiguration(Issues i) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096138713_871381_2050) ENABLED START */
		URI uri = URI.createURI(this.xmiFile);
		LOG.debug("Creating URI: " + uri);
		ResourceRegistry.INSTANCE.create(this.resourceSlot, uri);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	protected void invokeInternal(WorkflowContext ctx, ProgressMonitor pm, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363096168682_36592_2058) ENABLED START */
		try {
			LOG.info("Start writing XMI file...");
			LOG.debug("Get model from slot: " + this.inputSlot);
			Model output = (Model) ctx.get(this.inputSlot);
			LOG.debug("Get resource from slot: " + this.resourceSlot);
			XMIResource resource = (XMIResource) ResourceRegistry.INSTANCE.getResource(this.resourceSlot);
			resource.getContents().add(output);
			for (Entry<String, Element> e : ElementRegistry.INSTANCE.getElements()) {
				LOG.debug("Add element " + e.getKey());
				resource.setID(e.getValue(), e.getKey());
			}
			for (EObject e : ContentRegistry.INSTANCE.getContents()) {
				LOG.debug("Add content " + e.toString());
				resource.getContents().add(e);
			}
			LOG.debug("Save XMI file");
			resource.save(Collections.EMPTY_MAP);
			LOG.info("Finished!");
		} catch (Exception e) {
			issues.addError(e.toString());
		}
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
	 * Sets the value of attribute '<em><b>xmiFile</b></em>'.
	 * @param	xmiFile	the value to set.
	 */
	public void setXmiFile(String xmiFile) {
		this.xmiFile = xmiFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>resourceSlot</b></em>'.
	 * @param	resourceSlot	the value to set.
	 */
	public void setResourceSlot(String resourceSlot) {
		this.resourceSlot = resourceSlot;
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866975656_393979_2132) ENABLED START */
	
	/* PROTECTED REGION END */
}
