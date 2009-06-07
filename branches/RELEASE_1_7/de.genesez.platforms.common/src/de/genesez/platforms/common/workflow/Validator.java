package de.genesez.platforms.common.workflow;

import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.issues.Issues;

/**
 * The validator is used to validate GeneSEZ models
 * 
 * @author Aibek Isaev
 * @author Beishen
 */
public class Validator extends org.openarchitectureware.check.CheckComponent {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
		defaults.put("abortOnError", "true");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private Properties properties = new Properties(defaults);
	private boolean isNotSetAbortOnError = true;
	private boolean isNotSetSlot = true;
	
	
	/**
	 * creates a validator object
	 */
	public Validator() {
		WorkflowUtils.loadAllProperties(properties, logger, getClass());
		// add GeneSEZ meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see org.openarchitectureware.check.CheckComponent#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (isNotSetAbortOnError) {
			setAbortOnError(new Boolean(properties.getProperty("abortOnError")));
		}
		if (isNotSetSlot) {
			setEmfAllChildrenSlot(properties.getProperty("slot", "genesezModel"));
		}
		super.checkConfigurationInternal(issues);
	}
	
	/**
	 * setter for abortOnError parameter in super class.
	 * 
	 * @see org.openarchitectureware.check.CheckComponent#setAbortOnError(boolean)
	 */
	@Override
	public void setAbortOnError(boolean abortOnError) {
		super.setAbortOnError(abortOnError);
		isNotSetAbortOnError = false;
	}
	
	/**
	 * setter for slot parameter in super class.
	 */
	public void setSlot(String slot) {
		setEmfAllChildrenSlot(slot);
		isNotSetSlot = false;
	}
	
	/**
	 * adder for script which filters empty strings
	 */
	public void addScript(String script) {
		if (script.length() > 0) {
			super.addCheckFile(script);
		}
	}
	
	/**
	 * adder for scripts which filters empty strings and for comma separated
	 * list of scripts
	 */
	public void addScrips(String scripts) {
		if (scripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(scripts);
			for (String s : filtered) {
				addScript(s);
			}
		}
	}
}
