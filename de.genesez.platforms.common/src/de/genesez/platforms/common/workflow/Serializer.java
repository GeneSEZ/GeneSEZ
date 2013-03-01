package de.genesez.platforms.common.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.mwe.emf.Writer;
import org.openarchitectureware.workflow.issues.Issues;

/**
 * Serializes a GeneSEZ model to XMI.
 * It sets the <em><b>OPTION_SCHEMA_LOCATION_IMPLEMENTATION</b></em> to <em><b>false</b></em>, else the serialized XMI
 * cannot be opened with the sample reflective ecore model editor (because then no schema location is generated which points
 * to the met model (the gcore.ecore file))
 * 
 * @author Aibek Isaev
 * @author Beishen
 */
public class Serializer extends Writer {
	
	private Log logger = LogFactory.getLog(getClass());
	private Properties properties = new Properties(WorkflowUtils.defaults);
	private boolean isNotSetSlot=true;
	
	
	public Serializer() {
		WorkflowUtils.loadDefaultProperties(properties, logger);
		// note: to open the XMI in the sample reflective tree editor, this option must be disabled! (i don't know why)
		// else: no schema location is generated and the referenced gcore.ecore file is not found!
		super.setOPTION_SCHEMA_LOCATION_IMPLEMENTATION(false);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null, then set default value.
	 * 
	 * @see org.openarchitectureware.emf.XmiWriter#checkConfiguration(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	public void checkConfiguration(Issues issues) {
		if(isNotSetSlot) setSlot(properties.getProperty("slot"));
		super.checkConfiguration(issues);
	}
	
	/**
	 * setter for File parameter in super class.
	 */
	public void setFile(String modelFile) {
		super.setUri(modelFile);
	}
	
	/**
	 * setter for slot parameter in super class.
	 */
	public void setSlot(String slot) {
		super.setModelSlot(slot);
		isNotSetSlot = false;
	}
}
