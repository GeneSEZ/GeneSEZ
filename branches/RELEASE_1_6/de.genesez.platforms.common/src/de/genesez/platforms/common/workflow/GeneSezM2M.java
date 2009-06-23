/**
 * 
 */
package de.genesez.platforms.common.workflow;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.container.CompositeComponent;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.xtend.XtendComponent;

/**
 *
 */
public class GeneSezM2M extends CompositeComponent {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
		defaults.put("abortOnError", "true");
	}
	private Log logger = LogFactory.getLog(getClass());
	private Properties properties = new Properties(defaults);
	
	private Set<String> scripts = new LinkedHashSet<String>();
	private boolean isSetOutputSlot = false;
	private Set<String> aspects = new LinkedHashSet<String>();
	
	
	public GeneSezM2M() {
		super(GeneSezM2M.class.getSimpleName());
		WorkflowUtils.loadAllProperties(properties, logger, getClass());
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see org.openarchitectureware.check.CheckComponent#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	public void checkConfiguration(Issues issues) {
		// check settings
		if (scripts.size() == 0) {
			issues.addWarning("there are no model transformation scripts configured to execute!");
		}
		// add components
		for (String script : scripts) {
			XtendComponent c = new XtendComponent();
			// add GeneSEZ meta model
			EmfMetaModel gcore = new EmfMetaModel();
			gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
			c.addMetaModel(gcore);
			c.setSkipOnErrors(!Boolean.parseBoolean(properties.getProperty("abortOnError")));
			for (String aspect : aspects) {
				c.addExtensionAdvice(aspect);
			}
			if (isSetOutputSlot) {
				c.setOutputSlot(properties.getProperty("outputSlot", ""));
			}
			c.setInvoke(script + "(" + properties.getProperty("slot", "genesezModel") + ")");
			super.addComponent(c);
		}
		setAbortOnError(new Boolean(properties.getProperty("abortOnError")));
		// delegate
		super.checkConfiguration(issues);
	}
	
	/**
	 * setter for abortOnError parameter in super class.
	 * 
	 * @see org.openarchitectureware.check.CheckComponent#setAbortOnError(boolean)
	 */
	public void setAbortOnError(boolean abortOnError) {
		properties.put("abortOnError", abortOnError);
	}
	
	/**
	 * setter for slot parameter in super class.
	 */
	public void setInputSlot(String inputSlot) {
		properties.put("slot", inputSlot);
	}
	
	/**
	 * setter for slot parameter in super class.
	 */
	public void setOutputSlot(String outputSlot) {
		properties.put("outputSlot", outputSlot);
		isSetOutputSlot = true;
	}
	
	/**
	 * adder for script which filters empty strings
	 */
	public void addScript(String script) {
		if (script.length() > 0) {
			this.scripts.add(script);
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
	
	/**
	 * adder for aspect scripts with advices
	 * @param aspectScript
	 */
	public void addAspectScript(String aspectScript) {
		if (aspectScript.length() > 0) {
			aspects.add(aspectScript);
		}
	}
	
	/**
	 * setter for AspectScripts parameter in super class.
	 */
	public void addAspectScripts(String aspectScripts) {
		if (aspectScripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectScripts);
			for (String s : filtered) {
				addAspectScript(s);
			}
		}
	}
}
