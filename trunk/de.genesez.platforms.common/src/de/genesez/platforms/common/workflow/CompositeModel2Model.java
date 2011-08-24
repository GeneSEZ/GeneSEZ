package de.genesez.platforms.common.workflow;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class for model to model (M2M) modifications or
 * transformations.
 * 
 * To perform just model modifications just leave the output slot empty. The
 * workflow component allows to execute multiple model modification scripts for
 * a particular model. If a model to model transformation should be executed, it
 * can be only one and it must be the last script.
 * 
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class CompositeModel2Model extends CompositeComponent {

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
	 * Variable to stores all scripts.
	 */
	private Set<String> scripts = new LinkedHashSet<String>();

	/**
	 * Variable to stores all aspect scripts.
	 */
	private Set<String> aspectScripts = new LinkedHashSet<String>();

	/**
	 * Variable to stores all gobal variables which will be set as
	 * GlobalVarDefs.
	 */
	private Map<Object, Object> globalVars = new LinkedHashMap<Object, Object>();

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public CompositeModel2Model() {
		super(CompositeModel2Model.class.getSimpleName());
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void checkConfiguration(Issues issues) {
		// check if scripts are set.
		if (scripts.size() == 0) {
			issues.addError(this, "Missing property 'script' or 'scripts'!", scripts);
		}

		// add components
		for (String script : scripts) {
			Model2Model m2m = new Model2Model();
			m2m.setAbortOnError(properties.getProperty("abortOnError"));
			m2m.setScript(script);

			for (String aspectScript : aspectScripts) {
				m2m.addAspectScript(aspectScript);
			}

			for (Object key : globalVars.keySet()) {
				m2m.put(key, globalVars.get(key));
			}

			m2m.setSlot(properties.getProperty("slot"));
			m2m.setOutputSlot(properties.getProperty("outputSlot", ""));

			super.addComponent(m2m);
		}

		super.checkConfiguration(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#invoke(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		super.invoke(ctx, monitor, issues);
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
		globalVars.put(key, value);
	}

	// BEGIN OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 */
	public void setAbortOnError(String value) {
		properties.setProperty("abortOnError", value);
	}

	// END OF DEFAULTS

	/**
	 * Adder for the workflow parameter <em><b>script</b></em>.
	 * 
	 * Adds a script to be executed during the model to model modification or
	 * transformation.
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
	 * Adds several scripts to be executed during the model to model
	 * modification or transformation. The scripts should be comma or semicolon
	 * separated.
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
			this.aspectScripts.add(aspectScript);
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
	 * Sets the slot where the input model is stored.
	 * 
	 * @param slot The name of the input model slot.
	 */
	public void setSlot(String slot) {
		properties.setProperty("slot", slot);
	}

	/**
	 * Setter for the workflow parameter <em><b>outputSlot</b></em>.
	 * 
	 * Sets the slot where the output model should be stored. If you want to
	 * perform model modifications, just leave the output slot empty.
	 * 
	 * @param outputSlot The name of the output model slot.
	 */
	public void setOutputSlot(String outputSlot) {
		properties.setProperty("outputSlot", outputSlot);
	}

}
