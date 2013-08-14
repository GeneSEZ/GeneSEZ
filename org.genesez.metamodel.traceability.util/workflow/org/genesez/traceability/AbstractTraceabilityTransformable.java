package org.genesez.traceability;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_CRUH0I_XEeK_rM5VK2SGEA) 
 */
import org.genesez.workflow.Parameter;

import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public abstract class AbstractTraceabilityTransformable {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gcoreModelSlot = "coremodel";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String greqModelSlot = "reqmodel";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String gtraceModelSlot = "tracemodel";
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = false)
	private String template;
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (gcoreModelSlot == null) {
			gcoreModelSlot = getDefaultGcoreModelSlot();
		}
		if (greqModelSlot == null) {
			greqModelSlot = getDefaultGreqModelSlot();
		}
		if (gtraceModelSlot == null) {
			gtraceModelSlot = getDefaultGtraceModelSlot();
		}
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
		java.util.Set<Parameter> result = new java.util.LinkedHashSet<Parameter>();
		result.add(new Parameter("gcoreModelSlot", gcoreModelSlot));
		result.add(new Parameter("greqModelSlot", greqModelSlot));
		result.add(new Parameter("gtraceModelSlot", gtraceModelSlot));
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "gcoreModelSlot")
	public String getDefaultGcoreModelSlot() {
		return "coremodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "greqModelSlot")
	public String getDefaultGreqModelSlot() {
		return "reqmodel";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "gtraceModelSlot")
	public String getDefaultGtraceModelSlot() {
		return "tracemodel";
	}
	
	/**
	 * Returns the value of attribute '<em><b>gcoreModelSlot</b></em>'.
	 */
	public String getGcoreModelSlot() {
		return this.gcoreModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gcoreModelSlot</b></em>'.
	 * @param	gcoreModelSlot	the value to set.
	 */
	public void setGcoreModelSlot(String gcoreModelSlot) {
		this.gcoreModelSlot = gcoreModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>greqModelSlot</b></em>'.
	 */
	public String getGreqModelSlot() {
		return this.greqModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>greqModelSlot</b></em>'.
	 * @param	greqModelSlot	the value to set.
	 */
	public void setGreqModelSlot(String greqModelSlot) {
		this.greqModelSlot = greqModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>gtraceModelSlot</b></em>'.
	 */
	public String getGtraceModelSlot() {
		return this.gtraceModelSlot;
	}
	
	/**
	 * Sets the value of attribute '<em><b>gtraceModelSlot</b></em>'.
	 * @param	gtraceModelSlot	the value to set.
	 */
	public void setGtraceModelSlot(String gtraceModelSlot) {
		this.gtraceModelSlot = gtraceModelSlot;
	}
	
	/**
	 * Returns the value of attribute '<em><b>template</b></em>'.
	 */
	public String getTemplate() {
		return this.template;
	}
	
	/**
	 * Sets the value of attribute '<em><b>template</b></em>'.
	 * @param	template	the value to set.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._CRUH0I_XEeK_rM5VK2SGEA) ENABLED START */
	/* PROTECTED REGION END */
}
