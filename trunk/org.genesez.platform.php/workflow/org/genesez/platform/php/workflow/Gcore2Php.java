package org.genesez.platform.php.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_oDsWYAopEeKxusbn3Pe47g) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.m2t.cp.ImportPreserverConfig;
import org.genesez.workflow.xpand.Model2Text;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Gcore2Php extends Model2Text {
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean generateIncludes = true;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private boolean relativeIncludes = false;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String includeBase = "";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String propertyAccess = "setter";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String accessorStyle = "magic";
	
	// override default values of workflow parameters
	{
		setTemplate("org::genesez::platform::php5::templates::Root::Root");
		addTypeMappingFile("org/genesez/platform/php/typemapping/typemapping.xml");
	}
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._e5HAsAoqEeKxusbn3Pe47g) ENABLED START */
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("generateIncludes", generateIncludes);
		addGlobalVarDef("relativeIncludes", relativeIncludes);
		addGlobalVarDef("includeBase", includeBase);
		addGlobalVarDef("propertyAccess", propertyAccess);
		addGlobalVarDef("accessorStyle", accessorStyle);
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>generateIncludes</b></em>'
	 */
	public boolean getGenerateIncludes() {
		return generateIncludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>generateIncludes</b></em>'
	 */
	public void setGenerateIncludes(boolean generateIncludes) {
		this.generateIncludes = generateIncludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>relativeIncludes</b></em>'
	 */
	public boolean getRelativeIncludes() {
		return relativeIncludes;
	}
	
	/**
	 * Sets the value of attribute '<em><b>relativeIncludes</b></em>'
	 */
	public void setRelativeIncludes(boolean relativeIncludes) {
		this.relativeIncludes = relativeIncludes;
	}
	
	/**
	 * Returns the value of attribute '<em><b>includeBase</b></em>'
	 */
	public String getIncludeBase() {
		return includeBase;
	}
	
	/**
	 * Sets the value of attribute '<em><b>includeBase</b></em>'
	 */
	public void setIncludeBase(String includeBase) {
		this.includeBase = includeBase;
	}
	
	/**
	 * Returns the value of attribute '<em><b>propertyAccess</b></em>'
	 */
	public String getPropertyAccess() {
		return propertyAccess;
	}
	
	/**
	 * Sets the value of attribute '<em><b>propertyAccess</b></em>'
	 */
	public void setPropertyAccess(String propertyAccess) {
		this.propertyAccess = propertyAccess;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessorStyle</b></em>'
	 */
	public String getAccessorStyle() {
		return accessorStyle;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessorStyle</b></em>'
	 */
	public void setAccessorStyle(String accessorStyle) {
		this.accessorStyle = accessorStyle;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._oDsWYAopEeKxusbn3Pe47g) ENABLED START */
	{
		// initialize import preserve config
		setImportPreserverConfig(new ImportPreserverConfig(".*(\\.php)$", "(require|include|require_once|include_once)\\s+.*;$"));
	}
	/* PROTECTED REGION END */
	
}
