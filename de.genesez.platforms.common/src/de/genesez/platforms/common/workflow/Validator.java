package de.genesez.platforms.common.workflow;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * Workflow component class to check models for consistency.
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class Validator extends CheckComponent {

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
	 * Variable to stores all check scripts.
	 */
	private Set<String> scripts = new LinkedHashSet<String>();

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Validator() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);

		// add GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void checkConfigurationInternal(Issues issues) {
		// check if scripts are set.
		if (scripts.size() == 0) {
			issues.addError(this, "Missing property 'script' or 'scripts'!", scripts);
		}

		// add scripts
		for (String script : scripts) {
			super.addCheckFile(script);
		}
		super.setEmfAllChildrenSlot(properties.getProperty("slot"));

		super.checkConfigurationInternal(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		super.invokeInternal2(ctx, monitor, issues);
	}

	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor
	 * method was found. It checks if the value of the property is a boolean or
	 * number value. If not it will be registered as string. This means, that
	 * the value is surrounded with two single quotation marks.
	 * 
	 * @param key The name of the property.
	 * @param value The value of the property.
	 */
	public void put(Object key, Object value) {
		String keyStr = String.valueOf(key);
		String valueStr = String.valueOf(value);

		if (!WorkflowUtils.isBoolean(valueStr) && !WorkflowUtils.isNumber(valueStr)) {
			addGlobalVarDef(keyStr, valueStr);
		} else {
			addGlobalVarDef(keyStr, value);
		}
	}

	/**
	 * Add a property as string GlobalVarDef. This means, that the value is
	 * surrounded with two single quotation marks.
	 * 
	 * @param key The name of the property.
	 * @param value The value of the property.
	 */
	protected void addGlobalVarDef(String key, String value) {
		logger.trace("Register property (" + key + ") with value ('" + value + "') as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, "'" + value + "'"));
	}

	/**
	 * Add a property as GlobalVarDef.
	 * 
	 * @param key The name of the property.
	 * @param value The value of the property.
	 */
	protected void addGlobalVarDef(String key, Object value) {
		logger.trace("Register property (" + key + ") with value (" + value + ") as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, String.valueOf(value)));
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
	 * Adder for the workflow parameter <em><b>script</b></em>.
	 * 
	 * Adds a script to be executed during the model check.
	 * 
	 * @param script A script to execute.
	 */
	public void addScript(String script) {
		if (script.length() > 0) {
			this.scripts.add(script);
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>scripts</b></em>.
	 * 
	 * Adds several scripts to be executed during the model check. The scripts
	 * should be comma or semicolon separated.
	 * 
	 * @param scripts Several scripts to execute.
	 */
	public void addScrips(String scripts) {
		if (scripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(scripts);
			for (String s : filtered) {
				addScript(s);
			}
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectScript</b></em>.
	 * 
	 * Adds a aspect script with advices.
	 * 
	 * @param aspectScript A aspect script with advices.
	 */
	public void addAspectScript(String aspectScript) {
		logger.trace("add Aspect script: " + aspectScript);
		if (aspectScript.length() > 0) {
			super.addExtensionAdvice(aspectScript);
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectScripts</b></em>.
	 * 
	 * Adds several aspect scripts with advices. The aspect scripts should be
	 * comma or semicolon separated.
	 * 
	 * @param aspectScripts Several aspect scripts with advices.
	 */
	public void addAspectScripts(String aspectScripts) {
		if (aspectScripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectScripts);
			for (String s : filtered) {
				addAspectScript(s);
			}
		}
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
