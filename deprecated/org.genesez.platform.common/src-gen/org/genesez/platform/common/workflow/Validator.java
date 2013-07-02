package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324565240008_798565_6618) 
 */

import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.apache.commons.logging.LogFactory;
import java.util.LinkedHashSet;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.check.CheckComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class to check models for consistency.
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 * @deprecated
 */
public class Validator extends CheckComponent {
	
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
	 * Variable to stores all check scripts.
	 */
	
	private java.util.Set<String> scripts = new java.util.LinkedHashSet<String>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Validator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324565464865_696233_6754) ENABLED START */
		super();
		
		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
		
		// add GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	
	 */
	
	public void checkConfigurationInternal(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565470254_837977_6761) ENABLED START */
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#invokeInternal2(
	 * 	org.eclipse.emf.mwe.core.WorkflowContext,
	 * 	org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * 	org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	public void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565491635_949097_6769) ENABLED START */
		super.invokeInternal2(ctx, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor method was found. It checks if the value of the property is a boolean or number value. If not it will be registered as string. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	public void put(Object key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565525420_110916_6778) ENABLED START */
		String keyStr = String.valueOf(key);
		String valueStr = String.valueOf(value);
		
		if (!WorkflowUtils.isBoolean(valueStr) && !WorkflowUtils.isNumber(valueStr)) {
			addGlobalVarDef(keyStr, valueStr);
		} else {
			addGlobalVarDef(keyStr, value);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add a property as string GlobalVarDef. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	protected void addGlobalVarDef(String key, String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565552019_510045_6787) ENABLED START */
		logger.trace("Register property (" + key + ") with value ('" + value + "') as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, "'" + value + "'"));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add a property as GlobalVarDef.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	protected void addGlobalVarDef(String key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565574848_48322_6795) ENABLED START */
		logger.trace("Register property (" + key + ") with value (" + value + ") as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, String.valueOf(value)));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 * @param	abortOnError	
	 */
	
	public void setAbortOnError(String abortOnError) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565593178_529016_6803) ENABLED START */
		setSkipOnErrors(!Boolean.valueOf(abortOnError));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>script</b></em>.
	 * Adds a script to be executed during the model check.
	 * @param	script	A script to execute.
	 */
	
	public void addScript(String script) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565624028_529570_6811) ENABLED START */
		if (script.length() > 0) {
			this.scripts.add(script);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>scripts</b></em>.
	 * Adds several scripts to be executed during the model check. The scripts should be comma or semicolon separated.
	 * @param	scripts	Several scripts to execute.
	 */
	
	public void addScripts(String scripts) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565640709_808169_6818) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565658994_196196_6825) ENABLED START */
		logger.trace("add Aspect script: " + aspectScript);
		if (aspectScript.length() > 0) {
			super.addExtensionAdvice(aspectScript);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScripts</b></em>.
	 * Adds several aspect scripts with advices. The aspect scripts should be comma or semicolon separated.
	 * @param	aspectScripts	Several aspect scripts with advices.
	 */
	
	public void addAspectScripts(String aspectScripts) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565684351_696455_6831) ENABLED START */
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
	 * Sets the slot where the model is stored.
	 * @param	slot	The name of the model slot.
	 */
	
	public void setSlot(String slot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324565701116_13452_6838) ENABLED START */
		properties.setProperty("slot", slot);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324565240008_798565_6618) ENABLED START */
	static {
		defaults.setProperty("abortOnError", "true");
	}
	/* PROTECTED REGION END */
	
}
