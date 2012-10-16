package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324566409134_240204_6954) 
 */

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.container.CompositeComponent;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class for model to model (M2M) modifications or transformations.
 * 
 * To perform just model modifications just leave the output slot empty. The workflow component allows to execute multiple model modification scripts for a particular model. If a model to model transformation should be executed, it can be only one and it must be the last script.
 * 
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 * @deprecated
 */
public class CompositeModel2Model extends CompositeComponent {
	
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
	
	/**
	 * Variable to stores all scripts.
	 */
	
	private java.util.Set<String> scripts = new java.util.LinkedHashSet<String>();
	
	/**
	 * Variable to stores all aspect scripts.
	 */
	
	private java.util.Set<String> aspectScripts = new java.util.LinkedHashSet<String>();
	
	/**
	 * Variable to stores all gobal variables which will be set as GlobalVarDefs.
	 */
	private Map<Object, Object> globalVars = new LinkedHashMap<Object, Object>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public CompositeModel2Model() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324566816183_524723_7217) ENABLED START */
		super(CompositeModel2Model.class.getSimpleName());
		
		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * 
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#checkConfiguration(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	
	 */
	
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566827778_814625_7224) ENABLED START */
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
			m2m.setOutputSlot(properties.getProperty("outputSlot", "default"));
			
			super.addComponent(m2m);
		}
		
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * @see org.eclipse.emf.mwe.core.container.CompositeComponent#invoke(
	 * 	org.eclipse.emf.mwe.core.WorkflowContext,
	 * 	org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * 	org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566839958_637538_7231) ENABLED START */
		super.invoke(ctx, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor method was found. It checks if the value of the property is a boolean or number value. If not it will be registered as string. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	public void put(Object key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566875541_167248_7247) ENABLED START */
		globalVars.put(key, value);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 * @param	value	
	 */
	
	public void setAbortOnError(String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566891410_158441_7257) ENABLED START */
		properties.setProperty("abortOnError", value);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>script</b></em>.
	 * Adds a script to be executed during the model to model modification or transformation.
	 * @param	script	A script to execute.
	 */
	
	public void addScript(String script) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566913691_567398_7265) ENABLED START */
		if (script.length() > 0) {
			this.scripts.add(script);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>scripts</b></em>.
	 * Adds several scripts to be executed during the model to model modification or transformation. The scripts should be comma or semicolon separated.
	 * @param	scripts	Several scripts to execute.
	 */
	
	public void addScripts(String scripts) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566925867_422928_7272) ENABLED START */
		if (scripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(scripts);
			for (String s : filtered) {
				addScript(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScript</b></em>.
	 * Adds a aspect script with advices.
	 * @param	aspectScript	A aspect script with advices.
	 */
	
	public void addAspectScript(String aspectScript) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566938298_442234_7279) ENABLED START */
		logger.trace("add Aspect script: " + aspectScript);
		if (aspectScript.length() > 0) {
			this.aspectScripts.add(aspectScript);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScripts</b></em>.
	 * Adds several aspect scripts with advices. The aspect scripts should be comma or semicolon separated.
	 * @param	aspectScripts	Several aspect scripts with advices.
	 */
	
	public void addAspectScripts(String aspectScripts) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566960400_841333_7287) ENABLED START */
		if (aspectScripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectScripts);
			for (String s : filtered) {
				addAspectScript(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>slot</b></em>.
	 * Sets the slot where the input model is stored.
	 * @param	slot	The name of the input model slot.
	 */
	
	public void setSlot(String slot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566976687_57145_7294) ENABLED START */
		properties.setProperty("slot", slot);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>outputSlot</b></em>.
	 * Sets the slot where the output model should be stored. If you want to perform model modifications, just leave the output slot empty.
	 * @param	outputSlot	The name of the output model slot.
	 */
	
	public void setOutputSlot(String outputSlot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324566996641_675681_7302) ENABLED START */
		properties.setProperty("outputSlot", outputSlot);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324566409134_240204_6954) ENABLED START */
	static {
		defaults.setProperty("abortOnError", "true");
	}
	/* PROTECTED REGION END */
	
}
