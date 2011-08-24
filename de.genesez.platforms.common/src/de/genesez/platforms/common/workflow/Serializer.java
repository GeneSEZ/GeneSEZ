package de.genesez.platforms.common.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.utils.Writer;

/**
 * Workflow component class to serialize a model to XMI.
 * 
 * It sets the <em><b>OPTION_SCHEMA_LOCATION_IMPLEMENTATION</b></em> to
 * <em><b>false</b></em>, else the serialized XMI cannot be opened with the
 * sample reflective ecore model editor (because then no schema location is
 * generated which points to the met model (the gcore.ecore file))
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class Serializer extends Writer {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	static {
		defaults.setProperty("abortOnError", "true");
	}

	/**
	 * Variable to store all properties.
	 */
	protected Properties properties = new Properties();

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Serializer() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.WorkflowComponentWithModelSlot#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public void checkConfiguration(Issues issues) {
		// check if file is set.
		String file = properties.getProperty("file", "");
		if (file.length() == 0) {
			issues.addError(this, "Missing property 'file'!", file);
		} else {
			super.setUri(file);
			setModelSlot(properties.getProperty("slot"));
		}

		super.checkConfiguration(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.emf.mwe.utils.Writer#invokeInternal(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	public void invokeInternal(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		super.invokeInternal(ctx, monitor, issues);
	}

	// BEGIN OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 */
	public void setAbortOnError(String abortOnError) {
		setSkipOnErrors(!Boolean.valueOf(abortOnError));
	}

	// END OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>file</b></em>.
	 * 
	 * Sets the file name and path where the model will be serialized.
	 * 
	 * @param file The name and path of the file.
	 */
	public void setFile(String file) {
		properties.setProperty("file", file);
	}

	/**
	 * Setter for the workflow parameter <em><b>slot</b></em>.
	 * 
	 * Sets the slot where the model is stored.
	 * 
	 * @param slot The name of the model slot.
	 */
	public void setSlot(String slot) {
		properties.setProperty("slot", slot);
	}
}
