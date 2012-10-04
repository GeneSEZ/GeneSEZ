package org.genesez.platform.typo3.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_esLdUAo9EeKxusbn3Pe47g) 
 */

import java.util.Arrays;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.XtendComponent;
import org.genesez.metamodel.gcore.MModel;
import org.genesez.platform.common.naming.NamingMapper;
import org.genesez.workflow.xpand.Model2Model;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Typo3Model2Model extends Model2Model {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean useModelNameAsExtensionKey = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean isT3MvcCompliant = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String xtendNamingFile = "org::genesez::platform::typo3v4::mvc::convention::Naming";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String extensionKey;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zhoXUAo_EeKxusbn3Pe47g) ENABLED START */
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
		// error: here we are unable to access the protected method of XtendComponent/AbstractExpressionsUsingWorkflow
		NamingMapper.initNamingMapper(xtendNamingFile, getExecutionContext(context));
		
		// start execution
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>useModelNameAsExtensionKey</b></em>'
	 */
	public boolean getUseModelNameAsExtensionKey() {
		return useModelNameAsExtensionKey;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useModelNameAsExtensionKey</b></em>'
	 */
	public void setUseModelNameAsExtensionKey(boolean useModelNameAsExtensionKey) {
		this.useModelNameAsExtensionKey = useModelNameAsExtensionKey;
	}
	
	/**
	 * Returns the value of attribute '<em><b>isT3MvcCompliant</b></em>'
	 */
	public boolean getIsT3MvcCompliant() {
		return isT3MvcCompliant;
	}
	
	/**
	 * Sets the value of attribute '<em><b>isT3MvcCompliant</b></em>'
	 */
	public void setIsT3MvcCompliant(boolean isT3MvcCompliant) {
		this.isT3MvcCompliant = isT3MvcCompliant;
	}
	
	/**
	 * Returns the value of attribute '<em><b>xtendNamingFile</b></em>'
	 */
	public String getXtendNamingFile() {
		return xtendNamingFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>xtendNamingFile</b></em>'
	 */
	public void setXtendNamingFile(String xtendNamingFile) {
		this.xtendNamingFile = xtendNamingFile;
	}
	
	/**
	 * Returns the value of attribute '<em><b>extensionKey</b></em>'
	 */
	public String getExtensionKey() {
		return extensionKey;
	}
	
	/**
	 * Sets the value of attribute '<em><b>extensionKey</b></em>'
	 */
	public void setExtensionKey(String extensionKey) {
		this.extensionKey = extensionKey;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._esLdUAo9EeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
	
}
