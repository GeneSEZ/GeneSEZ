package de.genesez.platforms.common.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.utils.Writer;

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
