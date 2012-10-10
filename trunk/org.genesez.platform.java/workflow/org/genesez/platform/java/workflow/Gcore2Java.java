package org.genesez.platform.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_tPrfIAjhEeKn2-J_iePC7Q) 
 */

import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.genesez.m2t.ImportPreserverConfig;
import org.genesez.workflow.profile.Parameter;
import org.genesez.workflow.xpand.Model2Text;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class Gcore2Java extends Model2Text {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String eclipseFormatterConfig = "org/genesez/platform/java/workflow/eclipse.java.formatter.settings.xml";
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> excludePackage = new java.util.LinkedHashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = true, workflowInclusion = WHEN_NEEDED)
	private java.util.Set<String> excludeContentPackage = new java.util.LinkedHashSet<String>();
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean fieldAccess = true;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean useModelNameAsBasePackage = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String basePackage = "";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String accessorForStereotypes = "entity";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String accessorStereotype = "accessor";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean usePropertyVisibilityForAccessors = false;
	
	// override default values of workflow parameters
	{
		setTemplate("org::genesez::platform::java::java5::templates::Root::Root");
		addTypeMappingFile("org/genesez/platform/java/typemapping/typemapping.xml");
		addEmfMetaModelPackage("org.genesez.metamodel.gcore.GcorePackage");
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._WVoL8AjmEeKn2-J_iePC7Q) ENABLED START */
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("excludePackage", listToString(excludePackage));
		addGlobalVarDef("excludeContentPackage", listToString(excludeContentPackage));
		addGlobalVarDef("fieldAccess", fieldAccess);
		addGlobalVarDef("useModelNameAsBasePackage", useModelNameAsBasePackage);
		addGlobalVarDef("basePackage", basePackage);
		addGlobalVarDef("accessorForStereotypes", accessorForStereotypes);
		addGlobalVarDef("accessorStereotype", accessorStereotype);
		addGlobalVarDef("usePropertyVisibilityForAccessors", usePropertyVisibilityForAccessors);
		
		// formatter
		JavaBeautifier jb = new JavaBeautifier();
		jb.setConfigFile(eclipseFormatterConfig);
		addPostProcessor(jb);
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>eclipseFormatterConfig</b></em>'
	 */
	public String getEclipseFormatterConfig() {
		return eclipseFormatterConfig;
	}
	
	/**
	 * Sets the value of attribute '<em><b>eclipseFormatterConfig</b></em>'
	 */
	public void setEclipseFormatterConfig(String eclipseFormatterConfig) {
		this.eclipseFormatterConfig = eclipseFormatterConfig;
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludePackage</b></em>'
	 */
	public java.util.Set<String> getExcludePackage() {
		return excludePackage;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludePackage</b></em>'.
	 * @param	excludePackage	the value to add
	 */
	public void addExcludePackage(String excludePackage) {
		this.excludePackage.add(excludePackage);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludePackage</b></em>'.
	 * @param	excludePackage	the value to remove
	 */
	public void removeExcludePackage(String excludePackage) {
		this.excludePackage.remove(excludePackage);
	}
	
	/**
	 * Returns the value of attribute '<em><b>excludeContentPackage</b></em>'
	 */
	public java.util.Set<String> getExcludeContentPackage() {
		return excludeContentPackage;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>excludeContentPackage</b></em>'.
	 * @param	excludeContentPackage	the value to add
	 */
	public void addExcludeContentPackage(String excludeContentPackage) {
		this.excludeContentPackage.add(excludeContentPackage);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>excludeContentPackage</b></em>'.
	 * @param	excludeContentPackage	the value to remove
	 */
	public void removeExcludeContentPackage(String excludeContentPackage) {
		this.excludeContentPackage.remove(excludeContentPackage);
	}
	
	/**
	 * Returns the value of attribute '<em><b>fieldAccess</b></em>'
	 */
	public boolean getFieldAccess() {
		return fieldAccess;
	}
	
	/**
	 * Sets the value of attribute '<em><b>fieldAccess</b></em>'
	 */
	public void setFieldAccess(boolean fieldAccess) {
		this.fieldAccess = fieldAccess;
	}
	
	/**
	 * Returns the value of attribute '<em><b>useModelNameAsBasePackage</b></em>'
	 */
	public boolean getUseModelNameAsBasePackage() {
		return useModelNameAsBasePackage;
	}
	
	/**
	 * Sets the value of attribute '<em><b>useModelNameAsBasePackage</b></em>'
	 */
	public void setUseModelNameAsBasePackage(boolean useModelNameAsBasePackage) {
		this.useModelNameAsBasePackage = useModelNameAsBasePackage;
	}
	
	/**
	 * Returns the value of attribute '<em><b>basePackage</b></em>'
	 */
	public String getBasePackage() {
		return basePackage;
	}
	
	/**
	 * Sets the value of attribute '<em><b>basePackage</b></em>'
	 */
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorForStereotypes</b></em>'
	 */
	public String getAccessorForStereotypes() {
		return accessorForStereotypes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessorForStereotypes</b></em>'
	 */
	public void setAccessorForStereotypes(String accessorForStereotypes) {
		this.accessorForStereotypes = accessorForStereotypes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorStereotype</b></em>'
	 */
	public String getAccessorStereotype() {
		return accessorStereotype;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessorStereotype</b></em>'
	 */
	public void setAccessorStereotype(String accessorStereotype) {
		this.accessorStereotype = accessorStereotype;
	}
	
	/**
	 * Returns the value of attribute '<em><b>usePropertyVisibilityForAccessors</b></em>'
	 */
	public boolean getUsePropertyVisibilityForAccessors() {
		return usePropertyVisibilityForAccessors;
	}
	
	/**
	 * Sets the value of attribute '<em><b>usePropertyVisibilityForAccessors</b></em>'
	 */
	public void setUsePropertyVisibilityForAccessors(boolean usePropertyVisibilityForAccessors) {
		this.usePropertyVisibilityForAccessors = usePropertyVisibilityForAccessors;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._tPrfIAjhEeKn2-J_iePC7Q) ENABLED START */
	{
		// init import preserve
		setImportPreserverConfig(new ImportPreserverConfig(".*(\\.java)$", "(import)\\s+.*;$"));
	}
	/* PROTECTED REGION END */
	
}
