package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_esLdUAo9EeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.expression.AbstractExpressionsUsingWorkflowComponent.GlobalVarDef;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.expression.Variable;
import org.genesez.mapping.name.NameMapper;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import org.genesez.workflow.xpand.Model2ModelComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Typo3Model2ModelComponent extends Model2ModelComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean useModelNameAsExtensionKey = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean isT3MvcCompliant = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String extensionKey;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zhoXUAo_EeKxusbn3Pe47g) ENABLED START */
		// check default values
		if (getXtendNamingFile() == null) {
			setXtendNamingFile(getDefaultXtendNamingFile());
		}
		
		// check extension key
		if (!useModelNameAsExtensionKey || (extensionKey == null || extensionKey.isEmpty())) {
			issues.addError(this, "Either workflow parameter 'extensionKey' must be present or 'useModelNameAsExtensionKey' must be set to 'true'", Arrays.<Object> asList(useModelNameAsExtensionKey, extensionKey));
		}
		
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("isT3MvcCompliant", isT3MvcCompliant);
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zhoXVAo_EeKxusbn3Pe47g) ENABLED START */
		// fetch extension key if not specified
		if (useModelNameAsExtensionKey) {
			MModel model = (MModel) context.get(getSlot());
			extensionKey = model.getName();
		}
		addGlobalVarDef("extensionKey", extensionKey);
		
		// init naming mapper
		Map<String, Variable> globalVars = new HashMap<String, Variable>();
		for (GlobalVarDef globalVarDef : getGlobalVarDef()) {
			globalVars.put(globalVarDef.getName(), new Variable(globalVarDef.getName(), globalVarDef.getValue()));
		}
		ExecutionContext namingCtx = new ExecutionContextImpl(new TypeSystemImpl(), globalVars);
		NameMapper.initNameMapper(getXtendNamingFile(), namingCtx, getMetaModel());
		
		// start execution
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "useModelNameAsExtensionKey")
	public boolean getDefaultUseModelNameAsExtensionKey() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "isT3MvcCompliant")
	public boolean getDefaultIsT3MvcCompliant() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "xtendNamingFile")
	public String getDefaultXtendNamingFile() {
		return "org::genesez::platform::typo3v4::mvc::convention::Naming";
	}
	
	/**
	 * Returns the value of attribute '<em><b>useModelNameAsExtensionKey</b></em>'.
	 */
	public boolean getUseModelNameAsExtensionKey() {
		return useModelNameAsExtensionKey;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useModelNameAsExtensionKey</b></em>'.
	 * @param	useModelNameAsExtensionKey	the value to set.
	 */
	public void setUseModelNameAsExtensionKey(boolean useModelNameAsExtensionKey) {
		this.useModelNameAsExtensionKey = useModelNameAsExtensionKey;
	}
	
	/**
	 * Returns the value of attribute '<em><b>isT3MvcCompliant</b></em>'.
	 */
	public boolean getIsT3MvcCompliant() {
		return isT3MvcCompliant;
	}
	
	/**
	 * Sets the value of attribute '<em><b>isT3MvcCompliant</b></em>'.
	 * @param	isT3MvcCompliant	the value to set.
	 */
	public void setIsT3MvcCompliant(boolean isT3MvcCompliant) {
		this.isT3MvcCompliant = isT3MvcCompliant;
	}
	
	/**
	 * Returns the value of attribute '<em><b>extensionKey</b></em>'.
	 */
	public String getExtensionKey() {
		return extensionKey;
	}
	
	/**
	 * Sets the value of attribute '<em><b>extensionKey</b></em>'.
	 * @param	extensionKey	the value to set.
	 */
	public void setExtensionKey(String extensionKey) {
		this.extensionKey = extensionKey;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._esLdUAo9EeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
