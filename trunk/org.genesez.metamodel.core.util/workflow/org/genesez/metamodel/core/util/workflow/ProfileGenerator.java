package org.genesez.metamodel.core.util.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_JnZ-oAofEeKxusbn3Pe47g) 
 */

import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.workflow.xpand.Model2Text;
import org.genesez.workflow.profile.Parameter;
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class ProfileGenerator extends Model2Text {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Parameter(isRequired = true, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String xtendFilePath;
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String profileFileName = "Profile.ext";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String accessHelperFileName = "AccessHelper.ext";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String stereotypeNamePrefix = "";
	
	@Parameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED)
	private String enumerationNamePrefix = "";
	
	// override default values of workflow parameters
	{
		setTemplate("org::genesez::platform::common::profile::templates::Root::Root");
		addTypeMappingFile("org/genesez/platform/common/typemapping/typemapping.xml");
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._zAbf0AogEeKxusbn3Pe47g) ENABLED START */
		// check mandatory workflow parameter
		if (xtendFilePath == null || xtendFilePath.isEmpty()) {
			issues.addError(this, "Workflow parameter 'xtendFilePath' is missing!", xtendFilePath);
		}
		
		// add workflow parameter for transformation variables as global variables
		addGlobalVarDef("xtendFilePath", xtendFilePath);
		addGlobalVarDef("profileFileName", profileFileName);
		addGlobalVarDef("accessHelperFileName", accessHelperFileName);
		addGlobalVarDef("stereotypeNamePrefix", stereotypeNamePrefix);
		addGlobalVarDef("enumerationNamePrefix", enumerationNamePrefix);
		
		// delegate to base class
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>xtendFilePath</b></em>'
	 */
	public String getXtendFilePath() {
		return xtendFilePath;
	}
	
	/**
	 * Sets the value of attribute '<em><b>xtendFilePath</b></em>'
	 */
	public void setXtendFilePath(String xtendFilePath) {
		this.xtendFilePath = xtendFilePath;
	}
	
	/**
	 * Returns the value of attribute '<em><b>profileFileName</b></em>'
	 */
	public String getProfileFileName() {
		return profileFileName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>profileFileName</b></em>'
	 */
	public void setProfileFileName(String profileFileName) {
		this.profileFileName = profileFileName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accessHelperFileName</b></em>'
	 */
	public String getAccessHelperFileName() {
		return accessHelperFileName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accessHelperFileName</b></em>'
	 */
	public void setAccessHelperFileName(String accessHelperFileName) {
		this.accessHelperFileName = accessHelperFileName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>stereotypeNamePrefix</b></em>'
	 */
	public String getStereotypeNamePrefix() {
		return stereotypeNamePrefix;
	}
	
	/**
	 * Sets the value of attribute '<em><b>stereotypeNamePrefix</b></em>'
	 */
	public void setStereotypeNamePrefix(String stereotypeNamePrefix) {
		this.stereotypeNamePrefix = stereotypeNamePrefix;
	}
	
	/**
	 * Returns the value of attribute '<em><b>enumerationNamePrefix</b></em>'
	 */
	public String getEnumerationNamePrefix() {
		return enumerationNamePrefix;
	}
	
	/**
	 * Sets the value of attribute '<em><b>enumerationNamePrefix</b></em>'
	 */
	public void setEnumerationNamePrefix(String enumerationNamePrefix) {
		this.enumerationNamePrefix = enumerationNamePrefix;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._JnZ-oAofEeKxusbn3Pe47g) ENABLED START */
	/* PROTECTED REGION END */
	
}
