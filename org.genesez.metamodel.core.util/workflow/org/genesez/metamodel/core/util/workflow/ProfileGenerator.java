package org.genesez.metamodel.core.util.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_JnZ-oAofEeKxusbn3Pe47g) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleModel2Text;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ProfileGenerator extends SimpleModel2Text {
	
	@WfParameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String xtendFilePath;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String profileFileName = "Profile.ext";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String accessHelperFileName = "AccessHelper.ext";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String stereotypeNamePrefix = "";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String enumerationNamePrefix = "";
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getTemplate() == null) {
			setTemplate(getDefaultTemplate());
		}
		if (xtendFilePath == null && logger.isErrorEnabled()) {
			logger.error("Mandatory parameter 'xtendFilePath' not set!");
			result = false;
		}
		if (profileFileName == null) {
			profileFileName = getDefaultProfileFileName();
		}
		if (accessHelperFileName == null) {
			accessHelperFileName = getDefaultAccessHelperFileName();
		}
		if (stereotypeNamePrefix == null) {
			stereotypeNamePrefix = getDefaultStereotypeNamePrefix();
		}
		if (enumerationNamePrefix == null) {
			enumerationNamePrefix = getDefaultEnumerationNamePrefix();
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		result.add(new Parameter("xtendFilePath", xtendFilePath));
		result.add(new Parameter("profileFileName", profileFileName));
		result.add(new Parameter("accessHelperFileName", accessHelperFileName));
		result.add(new Parameter("stereotypeNamePrefix", stereotypeNamePrefix));
		result.add(new Parameter("enumerationNamePrefix", enumerationNamePrefix));
		return result;
	}
	
	/**
	 * Returns the value of attribute '<em><b>xtendFilePath</b></em>'.
	 */
	public String getXtendFilePath() {
		return xtendFilePath;
	}
	
	/**
	 * Sets the value of attribute '<em><b>xtendFilePath</b></em>'.
	 * @param	xtendFilePath	the value to set.
	 */
	public void setXtendFilePath(String xtendFilePath) {
		this.xtendFilePath = xtendFilePath;
	}
	
	/**
	 * Returns the value of attribute '<em><b>profileFileName</b></em>'.
	 */
	public String getProfileFileName() {
		return profileFileName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>profileFileName</b></em>'.
	 * @param	profileFileName	the value to set.
	 */
	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessHelperFileName</b></em>'.
	 */
	public String getAccessHelperFileName() {
		return accessHelperFileName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessHelperFileName</b></em>'.
	 * @param	accessHelperFileName	the value to set.
	 */
	public void setAccessHelperFileName(String accessHelperFileName) {
		this.accessHelperFileName = accessHelperFileName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>stereotypeNamePrefix</b></em>'.
	 */
	public String getStereotypeNamePrefix() {
		return stereotypeNamePrefix;
	}
	
	/**
	 * Sets the value of attribute '<em><b>stereotypeNamePrefix</b></em>'.
	 * @param	stereotypeNamePrefix	the value to set.
	 */
	public void setStereotypeNamePrefix(String stereotypeNamePrefix) {
		this.stereotypeNamePrefix = stereotypeNamePrefix;
	}
	
	/**
	 * Returns the value of attribute '<em><b>enumerationNamePrefix</b></em>'.
	 */
	public String getEnumerationNamePrefix() {
		return enumerationNamePrefix;
	}
	
	/**
	 * Sets the value of attribute '<em><b>enumerationNamePrefix</b></em>'.
	 * @param	enumerationNamePrefix	the value to set.
	 */
	public void setEnumerationNamePrefix(String enumerationNamePrefix) {
		this.enumerationNamePrefix = enumerationNamePrefix;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "profileFileName")
	public String getDefaultProfileFileName() {
		return "Profile.ext";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "accessHelperFileName")
	public String getDefaultAccessHelperFileName() {
		return "AccessHelper.ext";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "stereotypeNamePrefix")
	public String getDefaultStereotypeNamePrefix() {
		return "";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "enumerationNamePrefix")
	public String getDefaultEnumerationNamePrefix() {
		return "";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "template")
	public String getDefaultTemplate() {
		return "org::genesez::platform::common::profile::templates::Root::Root";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._JnZ-oAofEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
}
