package org.genesez.platform.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_tPrfIAjhEeKn2-J_iePC7Q) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.genesez.workflow.Parameter;
import org.genesez.workflow.SimpleModel2Text;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2Java extends SimpleModel2Text {
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> excludePackage = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> excludePackageContent = new java.util.LinkedHashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean fieldAccess = true;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean useModelNameAsBasePackage = false;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String basePackage = "";
	
	@WfParameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private java.util.Set<String> accessorForStereotypes = new java.util.HashSet<String>();
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String accessorStereotype = "accessor";
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private boolean usePropertyVisibilityForAccessors = false;
	
	/**
	 * Validates the configuration of the component before invocation.
	 */
	public boolean validate() {
		boolean result = true;
		if (getTemplate() == null) {
			setTemplate(getDefaultTemplate());
		}
		if (basePackage == null) {
			basePackage = getDefaultBasePackage();
		}
		if (accessorForStereotypes.isEmpty()) {
			accessorForStereotypes = getDefaultAccessorForStereotypes();
		}
		if (accessorStereotype == null) {
			accessorStereotype = getDefaultAccessorStereotype();
		}
		result = result && super.validate();
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public java.util.Set<Parameter> getParameter() {
		java.util.Set<Parameter> result = super.getParameter();
		if (excludePackage.isEmpty()) {
			result.add(new Parameter("excludePackage", ""));
		} else {
			for (String it : excludePackage) {
				result.add(new Parameter("excludePackage", it));
			}
		}
		if (excludePackageContent.isEmpty()) {
			result.add(new Parameter("excludePackageContent", ""));
		} else {
			for (String it : excludePackageContent) {
				result.add(new Parameter("excludePackageContent", it));
			}
		}
		result.add(new Parameter("fieldAccess", fieldAccess));
		result.add(new Parameter("useModelNameAsBasePackage", useModelNameAsBasePackage));
		result.add(new Parameter("basePackage", basePackage));
		if (accessorForStereotypes.isEmpty()) {
			result.add(new Parameter("accessorForStereotypes", ""));
		} else {
			for (String it : accessorForStereotypes) {
				result.add(new Parameter("accessorForStereotypes", it));
			}
		}
		result.add(new Parameter("accessorStereotype", accessorStereotype));
		result.add(new Parameter("usePropertyVisibilityForAccessors", usePropertyVisibilityForAccessors));
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "fieldAccess")
	public boolean getDefaultFieldAccess() {
		return true;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "useModelNameAsBasePackage")
	public boolean getDefaultUseModelNameAsBasePackage() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "basePackage")
	public String getDefaultBasePackage() {
		return "";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "accessorForStereotypes")
	public java.util.Set<String> getDefaultAccessorForStereotypes() {
		java.util.Set<String> result = new java.util.HashSet<String>();
		result.add("entity");
		return result;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "accessorStereotype")
	public String getDefaultAccessorStereotype() {
		return "accessor";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "usePropertyVisibilityForAccessors")
	public boolean getDefaultUsePropertyVisibilityForAccessors() {
		return false;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "template")
	public String getDefaultTemplate() {
		return "org::genesez::platform::java::m2t::Root::Root";
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludePackage</b></em>'.
	 */
	public java.util.Set<String> getExcludePackage() {
		return excludePackage;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludePackage</b></em>'.
	 * @param	excludePackage	the value to add.
	 */
	public void addExcludePackage(String excludePackage) {
		this.excludePackage.add(excludePackage);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludePackage</b></em>'.
	 * @param	excludePackage	the value to remove.
	 */
	public void removeExcludePackage(String excludePackage) {
		this.excludePackage.remove(excludePackage);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludePackageContent</b></em>'.
	 */
	public java.util.Set<String> getExcludePackageContent() {
		return excludePackageContent;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludePackageContent</b></em>'.
	 * @param	excludePackageContent	the value to add.
	 */
	public void addExcludePackageContent(String excludePackageContent) {
		this.excludePackageContent.add(excludePackageContent);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludePackageContent</b></em>'.
	 * @param	excludePackageContent	the value to remove.
	 */
	public void removeExcludePackageContent(String excludePackageContent) {
		this.excludePackageContent.remove(excludePackageContent);
	}
	
	/**
	 * Returns the value of attribute '<em><b>fieldAccess</b></em>'.
	 */
	public boolean getFieldAccess() {
		return fieldAccess;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fieldAccess</b></em>'.
	 * @param	fieldAccess	the value to set.
	 */
	public void setFieldAccess(boolean fieldAccess) {
		this.fieldAccess = fieldAccess;
	}
	
	/**
	 * Returns the value of attribute '<em><b>useModelNameAsBasePackage</b></em>'.
	 */
	public boolean getUseModelNameAsBasePackage() {
		return useModelNameAsBasePackage;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useModelNameAsBasePackage</b></em>'.
	 * @param	useModelNameAsBasePackage	the value to set.
	 */
	public void setUseModelNameAsBasePackage(boolean useModelNameAsBasePackage) {
		this.useModelNameAsBasePackage = useModelNameAsBasePackage;
	}
	
	/**
	 * Returns the value of attribute '<em><b>basePackage</b></em>'.
	 */
	public String getBasePackage() {
		return basePackage;
	}
	
	/**
	 * Sets the value of attribute '<em><b>basePackage</b></em>'.
	 * @param	basePackage	the value to set.
	 */
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorForStereotypes</b></em>'.
	 */
	public java.util.Set<String> getAccessorForStereotypes() {
		return accessorForStereotypes;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>accessorForStereotypes</b></em>'.
	 * @param	accessorForStereotypes	the value to add.
	 */
	public void addAccessorForStereotypes(String accessorForStereotypes) {
		this.accessorForStereotypes.add(accessorForStereotypes);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>accessorForStereotypes</b></em>'.
	 * @param	accessorForStereotypes	the value to remove.
	 */
	public void removeAccessorForStereotypes(String accessorForStereotypes) {
		this.accessorForStereotypes.remove(accessorForStereotypes);
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorStereotype</b></em>'.
	 */
	public String getAccessorStereotype() {
		return accessorStereotype;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessorStereotype</b></em>'.
	 * @param	accessorStereotype	the value to set.
	 */
	public void setAccessorStereotype(String accessorStereotype) {
		this.accessorStereotype = accessorStereotype;
	}
	
	/**
	 * Returns the value of attribute '<em><b>usePropertyVisibilityForAccessors</b></em>'.
	 */
	public boolean getUsePropertyVisibilityForAccessors() {
		return usePropertyVisibilityForAccessors;
	}
	
	/**
	 * Sets the value of attribute '<em><b>usePropertyVisibilityForAccessors</b></em>'.
	 * @param	usePropertyVisibilityForAccessors	the value to set.
	 */
	public void setUsePropertyVisibilityForAccessors(boolean usePropertyVisibilityForAccessors) {
		this.usePropertyVisibilityForAccessors = usePropertyVisibilityForAccessors;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._tPrfIAjhEeKn2-J_iePC7Q) ENABLED START */
	/* PROTECTED REGION END */
}
