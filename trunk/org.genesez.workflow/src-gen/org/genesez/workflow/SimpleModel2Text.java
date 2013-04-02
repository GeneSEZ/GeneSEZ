package org.genesez.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_pl0g8IcvEeKkPZ9HV4VaKQ) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class SimpleModel2Text extends AbstractTransformable implements Model2Text {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = false)
	protected String template;
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (template == null && logger.isErrorEnabled()) {
			logger.error("Mandatory parameter 'template' not set!");
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
	 * Returns the value of attribute '<em><b>template</b></em>'.
	 */
	public String getTemplate() {
		return template;
	}
	
	/**
	 * Sets the value of attribute '<em><b>template</b></em>'.
	 * @param	template	the value to set.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._pl0g8IcvEeKkPZ9HV4VaKQ) ENABLED START */
	/* PROTECTED REGION END */
}
