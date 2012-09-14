package org.genesez.workflow.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_F6MosP3MEeGcKvbUXThvRw) 
 */

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.profile.DefaultOverride;
import org.genesez.workflow.profile.Parameter;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Uml2Gcore extends Model2Model {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean mapClassesInModelToExternal = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean allowGeneratedXmiGuid = false;
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> externalStereotypes = new java.util.HashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> externalPackages = new java.util.HashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> excludeStereotypes = new java.util.HashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> excludePackages = new java.util.HashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> includeProfiles = new java.util.HashSet<String>();
	
	@DefaultOverride
	private String slot = "uml2model";
	
	@DefaultOverride
	private String script = "org::genesez::adapter::uml2::uml2genesez::transform";
	
	@DefaultOverride
	private String outputSlot = "coremodel";
	
	@DefaultOverride
	private java.util.Set<String> emfMetaModelPackage = new java.util.HashSet<String>();
	
	// initialize all multi valued fields with their default values
	{
		externalStereotypes.add("external");
		excludeStereotypes.add("exclude");
		excludePackages.add("UML Standard Profile");
		emfMetaModelPackage.add("org.genesez.metamodel.gcore.GcorePackage");
		
		// override default values of workflow parameters
		setSlot(slot);
		addScript(script);
		setOutputSlot(outputSlot);
		for (String it : emfMetaModelPackage) {
			addEmfMetaModelPackage(it);
		}
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._1xGzgP3yEeGA35ujkRyC6w) ENABLED START */
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("mapClassesInModelToExternal", mapClassesInModelToExternal);
		addGlobalVarDef("allowGeneratedXmiGuid", allowGeneratedXmiGuid);
		addGlobalVarDef("externalStereotypes", listToString(externalStereotypes));
		addGlobalVarDef("externalPackages", listToString(externalPackages));
		addGlobalVarDef("excludeStereotypes", listToString(excludeStereotypes));
		addGlobalVarDef("excludePackages", listToString(excludePackages));
		addGlobalVarDef("includeProfiles", listToString(includeProfiles));
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>mapClassesInModelToExternal</b></em>'
	 */
	public boolean getMapClassesInModelToExternal() {
		return mapClassesInModelToExternal;
	}
	
	/**
	 * Sets the value of attribute '<em><b>mapClassesInModelToExternal</b></em>'
	 */
	public void setMapClassesInModelToExternal(boolean mapClassesInModelToExternal) {
		this.mapClassesInModelToExternal = mapClassesInModelToExternal;
	}
	
	/**
	 * Returns the value of attribute '<em><b>allowGeneratedXmiGuid</b></em>'
	 */
	public boolean getAllowGeneratedXmiGuid() {
		return allowGeneratedXmiGuid;
	}
	
	/**
	 * Sets the value of attribute '<em><b>allowGeneratedXmiGuid</b></em>'
	 */
	public void setAllowGeneratedXmiGuid(boolean allowGeneratedXmiGuid) {
		this.allowGeneratedXmiGuid = allowGeneratedXmiGuid;
	}
	
	/**
	 * Returns the value of attribute '<em><b>externalStereotypes</b></em>'
	 */
	public java.util.Set<String> getExternalStereotypes() {
		return externalStereotypes;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>externalStereotypes</b></em>'.
	 * @param	externalStereotypes	the value to add
	 */
	public void addExternalStereotypes(String externalStereotypes) {
		this.externalStereotypes.add(externalStereotypes);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>externalStereotypes</b></em>'.
	 * @param	externalStereotypes	the value to remove
	 */
	public void removeExternalStereotypes(String externalStereotypes) {
		this.externalStereotypes.remove(externalStereotypes);
	}
	
	/**
	 * Returns the value of attribute '<em><b>externalPackages</b></em>'
	 */
	public java.util.Set<String> getExternalPackages() {
		return externalPackages;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>externalPackages</b></em>'.
	 * @param	externalPackages	the value to add
	 */
	public void addExternalPackages(String externalPackages) {
		this.externalPackages.add(externalPackages);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>externalPackages</b></em>'.
	 * @param	externalPackages	the value to remove
	 */
	public void removeExternalPackages(String externalPackages) {
		this.externalPackages.remove(externalPackages);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludeStereotypes</b></em>'
	 */
	public java.util.Set<String> getExcludeStereotypes() {
		return excludeStereotypes;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludeStereotypes</b></em>'.
	 * @param	excludeStereotypes	the value to add
	 */
	public void addExcludeStereotypes(String excludeStereotypes) {
		this.excludeStereotypes.add(excludeStereotypes);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludeStereotypes</b></em>'.
	 * @param	excludeStereotypes	the value to remove
	 */
	public void removeExcludeStereotypes(String excludeStereotypes) {
		this.excludeStereotypes.remove(excludeStereotypes);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludePackages</b></em>'
	 */
	public java.util.Set<String> getExcludePackages() {
		return excludePackages;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludePackages</b></em>'.
	 * @param	excludePackages	the value to add
	 */
	public void addExcludePackages(String excludePackages) {
		this.excludePackages.add(excludePackages);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludePackages</b></em>'.
	 * @param	excludePackages	the value to remove
	 */
	public void removeExcludePackages(String excludePackages) {
		this.excludePackages.remove(excludePackages);
	}
	
	/**
	 * Returns the value of attribute '<em><b>includeProfiles</b></em>'
	 */
	public java.util.Set<String> getIncludeProfiles() {
		return includeProfiles;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>includeProfiles</b></em>'.
	 * @param	includeProfiles	the value to add
	 */
	public void addIncludeProfiles(String includeProfiles) {
		this.includeProfiles.add(includeProfiles);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>includeProfiles</b></em>'.
	 * @param	includeProfiles	the value to remove
	 */
	public void removeIncludeProfiles(String includeProfiles) {
		this.includeProfiles.remove(includeProfiles);
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._F6MosP3MEeGcKvbUXThvRw) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
