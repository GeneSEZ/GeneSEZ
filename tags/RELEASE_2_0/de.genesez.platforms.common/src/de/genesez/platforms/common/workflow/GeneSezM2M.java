
package de.genesez.platforms.common.workflow;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * Provides a workflow component for model modifications and a model to model transformation. To perform just model modifications
 * just leave the output slot empty.
 * 
 * The workflow component allows to execute multiple model modification scripts for a particular model. 
 * If a model to model transformation should be executed, it can be only one and it must be the last script.
 * 
 * @author tobias haubold
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
	}
	
	/**
	 * Checks parameter values and set parameters to values specified in workflow file or to default values.
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
			EmfMetaModel greq = new EmfMetaModel();
			greq.setMetaModelPackage(properties.getProperty("greqPackage"));
			c.addMetaModel(greq);
			EmfMetaModel gtrace = new EmfMetaModel();
			gtrace.setMetaModelPackage(properties.getProperty("gtracePackage"));
			c.addMetaModel(gtrace);
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
		// delegate
		super.checkConfiguration(issues);
	}
	
	/**
	 * Allows to set if the workflow should be aborted if an error occurs.
	 * @see org.openarchitectureware.check.CheckComponent#setAbortOnError(boolean)
	 */
	public void setAbortOnError(boolean abortOnError) {
		properties.put("abortOnError", abortOnError);
	}
	
	/**
	 * @param inputSlot	the name of the model slot where the input model is stored
	 */
	public void setInputSlot(String inputSlot) {
		properties.put("slot", inputSlot);
	}
	
	/**
	 * Sets the name of the model slot where the output model should be stored. If you
	 * want to perform model modifications, just leave the output slot empty.
	 * @param outputSlot	the name of the model slot where the output model should be stored
	 */
	public void setOutputSlot(String outputSlot) {
		properties.put("outputSlot", outputSlot);
		isSetOutputSlot = true;
	}
	
	/**
	 * Adds a script to be executed during the model modification or the model to model transformation.
	 * @param script	a script to execute
	 */
	public void addScript(String script) {
		if (script.length() > 0) {
			this.scripts.add(script);
		}
	}
	
	/**
	 * Adds several scripts to be executed on transformation. The scripts should be comma separated.
	 * @param scripts	several scripts to execute
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
	 * @param aspectScript	an script with advices for AOP
	 */
	public void addAspectScript(String aspectScript) {
		if (aspectScript.length() > 0) {
			aspects.add(aspectScript);
		}
	}
	
	/**
	 * @param aspectScripts	several aspect scripts with advices for AOP
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
