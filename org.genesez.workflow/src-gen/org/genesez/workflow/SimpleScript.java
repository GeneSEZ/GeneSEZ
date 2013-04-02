package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_tZUAsIcvEeKkPZ9HV4VaKQ) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class SimpleScript extends AbstractTransformable implements Model2Model {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = false)
	protected String script;
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (script == null && logger.isErrorEnabled()) {
			logger.error("Mandatory parameter 'script' not set!");
			result = false;
		}
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		return result;
	}
	
	/**
	 * Returns the value of attribute '<em><b>script</b></em>'.
	 */
	public String getScript() {
		return script;
	}
	
	/**
	 * Sets the value of attribute '<em><b>script</b></em>'.
	 * @param	script	the value to set.
	 */
	public void setScript(String script) {
		this.script = script;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._tZUAsIcvEeKkPZ9HV4VaKQ) ENABLED START */
	/* PROTECTED REGION END */
}
