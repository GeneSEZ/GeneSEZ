package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324566427216_374342_6986) 
 */

import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class for model to model (M2M) modifications or transformations.
 * 
 * To perform just model modifications just leave the output slot empty.
 *  
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-23
 */
public class Model2Model extends XtendComponent {
	
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
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Model2Model() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324567599445_835622_7389) ENABLED START */
		super();
		
		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
		
		// add GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
		
		// add GeneSEZ requirements meta model
		EmfMetaModel greq = new EmfMetaModel();
		greq.setMetaModelPackage(properties.getProperty("greqPackage"));
		addMetaModel(greq);
		
		// add GeneSEZ traceability meta model
		EmfMetaModel gtrace = new EmfMetaModel();
		gtrace.setMetaModelPackage(properties.getProperty("gtracePackage"));
		addMetaModel(gtrace);
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567613012_771755_7397) ENABLED START */
		// check if script is set.
		String script = properties.getProperty("script", "");
		if (script.length() == 0) {
			issues.addError(this, "Missing property 'script'!", script);
		} else {
			super.setInvoke(script + "(" + properties.getProperty("slot") + ")");
		}
		
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567642272_842675_7407) ENABLED START */
		super.invokeInternal2(ctx, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor method was found. It checks if the value of the property is a boolean or number value. If not it will be registered as string. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	public void put(Object key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567660240_290237_7419) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567687666_497149_7436) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567716260_315746_7450) ENABLED START */
		logger.trace("Register property (" + key + ") with value (" + value + ") as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, String.valueOf(value)));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>abortOnError</b></em>.
	 * 
	 * @see org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent#setSkipOnErrors(boolean)
	 * @param	abortOnError	
	 */
	
	public void setAbortOnError(String abortOnError) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567732113_993407_7460) ENABLED START */
		setSkipOnErrors(!Boolean.valueOf(abortOnError));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>script</b></em>.
	 * Sets a script to be executed for model to model modification or transformation.
	 * @param	script	A script to execute.
	 */
	
	public void setScript(String script) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567787353_140690_7469) ENABLED START */
		properties.setProperty("script", script);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScript</b></em>.
	 * Adds a aspect script with advices.
	 * @param	aspectScript	A aspect script with advices.
	 */
	
	public void addAspectScript(String aspectScript) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567797027_319358_7474) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567830908_484355_7486) ENABLED START */
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
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567845426_187960_7493) ENABLED START */
		properties.setProperty("slot", slot);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>outputSlot</b></em>.
	 * Sets the slot where the output model should be stored. If you want to perform model modifications, just leave the output slot empty.
	 * @param	outputSlot	The name of the output model slot.
	 */
	
	public void setOutputSlot(String outputSlot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324567863305_138111_7501) ENABLED START */
		super.setOutputSlot(outputSlot);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324566427216_374342_6986) ENABLED START */
	static {
		defaults.setProperty("abortOnError", "true");
	}
	/* PROTECTED REGION END */
	
}
