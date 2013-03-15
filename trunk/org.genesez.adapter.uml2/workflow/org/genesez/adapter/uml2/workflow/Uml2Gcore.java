package org.genesez.adapter.uml2.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_F6MosP3MEeGcKvbUXThvRw) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Model2Model;
import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleScript;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Uml2Gcore extends SimpleScript {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean mapClassesInModelToExternal = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean allowGeneratedXmiGuid = false;
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> externalStereotypes = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> externalPackages = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> excludeStereotypes = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> excludePackages = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> includeProfiles = new java.util.HashSet<String>();
	
	/**
	 * Method stub for further implementation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getScript() == null) {
			setScript(getDefaultScript());
		}
		if (externalStereotypes.isEmpty()) {
			externalStereotypes = getDefaultExternalStereotypes();
		}
		if (excludeStereotypes.isEmpty()) {
			excludeStereotypes = getDefaultExcludeStereotypes();
		}
		if (excludePackages.isEmpty()) {
			excludePackages = getDefaultExcludePackages();
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = new java.util.LinkedHashSet<Parameter>();
		result.add(new Parameter("mapClassesInModelToExternal", mapClassesInModelToExternal));
		result.add(new Parameter("allowGeneratedXmiGuid", allowGeneratedXmiGuid));
		if (externalStereotypes.isEmpty()) {
			result.add(new Parameter("externalStereotypes", ""));
		} else {
			for (String it : externalStereotypes) {
				result.add(new Parameter("externalStereotypes", it));
			}
		}
		if (externalPackages.isEmpty()) {
			result.add(new Parameter("externalPackages", ""));
		} else {
			for (String it : externalPackages) {
				result.add(new Parameter("externalPackages", it));
			}
		}
		if (excludeStereotypes.isEmpty()) {
			result.add(new Parameter("excludeStereotypes", ""));
		} else {
			for (String it : excludeStereotypes) {
				result.add(new Parameter("excludeStereotypes", it));
			}
		}
		if (excludePackages.isEmpty()) {
			result.add(new Parameter("excludePackages", ""));
		} else {
			for (String it : excludePackages) {
				result.add(new Parameter("excludePackages", it));
			}
		}
		if (includeProfiles.isEmpty()) {
			result.add(new Parameter("includeProfiles", ""));
		} else {
			for (String it : includeProfiles) {
				result.add(new Parameter("includeProfiles", it));
			}
		}
		return result;
	}
	
	/**
	 * Returns the value of attribute '<em><b>mapClassesInModelToExternal</b></em>'.
	 */
	public boolean getMapClassesInModelToExternal() {
		return mapClassesInModelToExternal;
	}
	
	/**
	 * Sets the value of attribute '<em><b>mapClassesInModelToExternal</b></em>'.
	 * @param	mapClassesInModelToExternal	the value to set.
	 */
	public void setMapClassesInModelToExternal(boolean mapClassesInModelToExternal) {
		this.mapClassesInModelToExternal = mapClassesInModelToExternal;
	}
	
	/**
	 * Returns the value of attribute '<em><b>allowGeneratedXmiGuid</b></em>'.
	 */
	public boolean getAllowGeneratedXmiGuid() {
		return allowGeneratedXmiGuid;
	}
	
	/**
	 * Sets the value of attribute '<em><b>allowGeneratedXmiGuid</b></em>'.
	 * @param	allowGeneratedXmiGuid	the value to set.
	 */
	public void setAllowGeneratedXmiGuid(boolean allowGeneratedXmiGuid) {
		this.allowGeneratedXmiGuid = allowGeneratedXmiGuid;
	}
	
	/**
	 * Returns the value of attribute '<em><b>externalStereotypes</b></em>'.
	 */
	public java.util.Set<String> getExternalStereotypes() {
		return externalStereotypes;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>externalStereotypes</b></em>'.
	 * @param	externalStereotypes	the value to add.
	 */
	public void addExternalStereotypes(String externalStereotypes) {
		this.externalStereotypes.add(externalStereotypes);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>externalStereotypes</b></em>'.
	 * @param	externalStereotypes	the value to remove.
	 */
	public void removeExternalStereotypes(String externalStereotypes) {
		this.externalStereotypes.remove(externalStereotypes);
	}
	
	/**
	 * Returns the value of attribute '<em><b>externalPackages</b></em>'.
	 */
	public java.util.Set<String> getExternalPackages() {
		return externalPackages;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>externalPackages</b></em>'.
	 * @param	externalPackages	the value to add.
	 */
	public void addExternalPackages(String externalPackages) {
		this.externalPackages.add(externalPackages);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>externalPackages</b></em>'.
	 * @param	externalPackages	the value to remove.
	 */
	public void removeExternalPackages(String externalPackages) {
		this.externalPackages.remove(externalPackages);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludeStereotypes</b></em>'.
	 */
	public java.util.Set<String> getExcludeStereotypes() {
		return excludeStereotypes;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludeStereotypes</b></em>'.
	 * @param	excludeStereotypes	the value to add.
	 */
	public void addExcludeStereotypes(String excludeStereotypes) {
		this.excludeStereotypes.add(excludeStereotypes);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludeStereotypes</b></em>'.
	 * @param	excludeStereotypes	the value to remove.
	 */
	public void removeExcludeStereotypes(String excludeStereotypes) {
		this.excludeStereotypes.remove(excludeStereotypes);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludePackages</b></em>'.
	 */
	public java.util.Set<String> getExcludePackages() {
		return excludePackages;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludePackages</b></em>'.
	 * @param	excludePackages	the value to add.
	 */
	public void addExcludePackages(String excludePackages) {
		this.excludePackages.add(excludePackages);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludePackages</b></em>'.
	 * @param	excludePackages	the value to remove.
	 */
	public void removeExcludePackages(String excludePackages) {
		this.excludePackages.remove(excludePackages);
	}
	
	/**
	 * Returns the value of attribute '<em><b>includeProfiles</b></em>'.
	 */
	public java.util.Set<String> getIncludeProfiles() {
		return includeProfiles;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>includeProfiles</b></em>'.
	 * @param	includeProfiles	the value to add.
	 */
	public void addIncludeProfiles(String includeProfiles) {
		this.includeProfiles.add(includeProfiles);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>includeProfiles</b></em>'.
	 * @param	includeProfiles	the value to remove.
	 */
	public void removeIncludeProfiles(String includeProfiles) {
		this.includeProfiles.remove(includeProfiles);
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "mapClassesInModelToExternal")
	public boolean getDefaultMapClassesInModelToExternal() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "allowGeneratedXmiGuid")
	public boolean getDefaultAllowGeneratedXmiGuid() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "externalStereotypes")
	public java.util.Set<String> getDefaultExternalStereotypes() {
		java.util.Set<String> result = new java.util.HashSet<String>();
		result.add("external");
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "excludeStereotypes")
	public java.util.Set<String> getDefaultExcludeStereotypes() {
		java.util.Set<String> result = new java.util.HashSet<String>();
		result.add("exclude");
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "excludePackages")
	public java.util.Set<String> getDefaultExcludePackages() {
		java.util.Set<String> result = new java.util.HashSet<String>();
		result.add("UML Standard Profile");
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "script")
	public String getDefaultScript() {
		return "org::genesez::adapter::uml2::gcore::UML2Gcore::transform";
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._F6MosP3MEeGcKvbUXThvRw) ENABLED START */
	/* PROTECTED REGION END */
}
