package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324563889572_809428_6195) 
 */

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.io.File;
import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.Writer;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class to serialize a model to XMI.
 * 
 * It sets the <em><b>OPTION_SCHEMA_LOCATION_IMPLEMENTATION</b></em> to <em><b>false</b></em>, else the serialized XMI cannot be opened with the sample reflective ecore model editor (because then no schema location is generated which points to the met model (the gcore.ecore file))
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 * @deprecated
 */
public class Serializer extends Writer {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Variable to store all properties.
	 */
	protected Properties properties = new Properties();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Serializer() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324564000205_364366_6266) ENABLED START */
		super();
		
		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * @see org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	
	 */
	
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564006799_159141_6273) ENABLED START */
		// check if file is set.
		String file = properties.getProperty("file", "");
		if (file.length() == 0) {
			issues.addError(this, "Missing property 'file'!", file);
		} else {
			super.setUri(file);
			setModelSlot(properties.getProperty("slot"));
		}
		
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.emf.mwe.utils.Writer#invokeInternal(
	 * 	org.eclipse.emf.mwe.core.WorkflowContext,
	 * 	org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * 	org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564022435_423416_6280) ENABLED START */
		super.invokeInternal(ctx, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 * 	
	 * @param	abortOnError	
	 */
	
	public void setAbortOnError(String abortOnError) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564063071_964285_6290) ENABLED START */
		setSkipOnErrors(!Boolean.valueOf(abortOnError));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>file</b></em>.
	 * Sets the file name and path where the model will be serialized.
	 * @param	file	The name and path of the file.
	 */
	
	public void setFile(String file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564101185_449276_6297) ENABLED START */
		if (new File(file).isAbsolute()) {
			file = "file:/" + file;
		}
		properties.setProperty("file", file);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>slot</b></em>.
	 * Sets the slot where the model is stored.
	 * @param	slot	The name of the model slot.
	 */
	
	public void setSlot(String slot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324564111688_563691_6304) ENABLED START */
		properties.setProperty("slot", slot);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324563889572_809428_6195) ENABLED START */
	static {
		defaults.setProperty("abortOnError", "true");
	}
	/* PROTECTED REGION END */
	
}
