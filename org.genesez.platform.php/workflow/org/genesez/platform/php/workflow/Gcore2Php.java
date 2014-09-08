package org.genesez.platform.php.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_oDsWYAopEeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleModel2Text;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2Php extends SimpleModel2Text {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean generateIncludes = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean relativeIncludes = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String includeBase = "";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String propertyAccess = "setter";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String accessorStyle = "magic";
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getTemplate() == null) {
			setTemplate(getDefaultTemplate());
		}
		if (includeBase == null) {
			includeBase = getDefaultIncludeBase();
		}
		if (propertyAccess == null) {
			propertyAccess = getDefaultPropertyAccess();
		}
		if (accessorStyle == null) {
			accessorStyle = getDefaultAccessorStyle();
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		result.add(new Parameter("generateIncludes", generateIncludes));
		result.add(new Parameter("relativeIncludes", relativeIncludes));
		result.add(new Parameter("includeBase", includeBase));
		result.add(new Parameter("propertyAccess", propertyAccess));
		result.add(new Parameter("accessorStyle", accessorStyle));
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "generateIncludes")
	public boolean getDefaultGenerateIncludes() {
		return true;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "relativeIncludes")
	public boolean getDefaultRelativeIncludes() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "includeBase")
	public String getDefaultIncludeBase() {
		return "";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "propertyAccess")
	public String getDefaultPropertyAccess() {
		return "setter";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "accessorStyle")
	public String getDefaultAccessorStyle() {
		return "magic";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "template")
	public String getDefaultTemplate() {
		return "org::genesez::platform::php::m2t::Root::Root";
	}
	
	/**
	 * Returns the value of attribute '<em><b>generateIncludes</b></em>'.
	 */
	public boolean getGenerateIncludes() {
		return this.generateIncludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>generateIncludes</b></em>'.
	 * @param	generateIncludes	the value to set.
	 */
	public void setGenerateIncludes(boolean generateIncludes) {
		this.generateIncludes = generateIncludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>relativeIncludes</b></em>'.
	 */
	public boolean getRelativeIncludes() {
		return this.relativeIncludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>relativeIncludes</b></em>'.
	 * @param	relativeIncludes	the value to set.
	 */
	public void setRelativeIncludes(boolean relativeIncludes) {
		this.relativeIncludes = relativeIncludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>includeBase</b></em>'.
	 */
	public String getIncludeBase() {
		return this.includeBase;
	}
	
	/**
	 * Sets the value of attribute '<em><b>includeBase</b></em>'.
	 * @param	includeBase	the value to set.
	 */
	public void setIncludeBase(String includeBase) {
		this.includeBase = includeBase;
	}
	
	/**
	 * Returns the value of attribute '<em><b>propertyAccess</b></em>'.
	 */
	public String getPropertyAccess() {
		return this.propertyAccess;
	}
	
	/**
	 * Sets the value of attribute '<em><b>propertyAccess</b></em>'.
	 * @param	propertyAccess	the value to set.
	 */
	public void setPropertyAccess(String propertyAccess) {
		this.propertyAccess = propertyAccess;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorStyle</b></em>'.
	 */
	public String getAccessorStyle() {
		return this.accessorStyle;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessorStyle</b></em>'.
	 * @param	accessorStyle	the value to set.
	 */
	public void setAccessorStyle(String accessorStyle) {
		this.accessorStyle = accessorStyle;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._oDsWYAopEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
