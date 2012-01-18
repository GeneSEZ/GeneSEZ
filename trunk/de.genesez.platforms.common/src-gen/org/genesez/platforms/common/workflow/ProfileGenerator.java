package org.genesez.platforms.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1324563419229_231019_5871) 
 */

import java.util.Properties;

/**
 * Workflow component class to generate code (model to text transformation) for a profile.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-23
 */
public class ProfileGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public ProfileGenerator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1324563531118_164456_6107) ENABLED START */
		super();
		WorkflowUtils.callPropertyAccessors(this, defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Setter for the workflow parameter <em><b>profileFileName</b></em>.
	 * Sets the file name and path where the profile file will be generated.
	 * @param	profileFileName	
	 */
	
	public void setProfileFileName(String profileFileName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324563539569_278646_6114) ENABLED START */
		addGlobalVarDef("profileFileName", profileFileName);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>accessHelperFileName</b></em>.
	 * Sets the file name and path where the profile access helper file will be generated.
	 * @param	accessHelperFileName	The name and path of the profile access helper file.
	 */
	
	public void setAccessHelperFileName(String accessHelperFileName) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324563554597_553710_6121) ENABLED START */
		addGlobalVarDef("accessHelperFileName", accessHelperFileName);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>stereotypeNamePrefix</b></em>.
	 * Sets the name prefix which is added to all Xtend scripts for stereotypes.
	 * @param	stereotypeNamePrefix	The name prefix.
	 */
	
	public void setStereotypeNamePrefix(String stereotypeNamePrefix) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324563587236_101642_6129) ENABLED START */
		addGlobalVarDef("stereotypeNamePrefix", stereotypeNamePrefix);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>enumerationNamePrefix</b></em>.
	 * Sets the name prefix which is added to all Xtend scripts for enumerations.
	 * @param	enumerationNamePrefix	The name prefix.
	 */
	
	public void setEnumerationNamePrefix(String enumerationNamePrefix) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1324563612975_440064_6136) ENABLED START */
		addGlobalVarDef("enumerationNamePrefix", enumerationNamePrefix);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1324563419229_231019_5871) ENABLED START */
	static {
		defaults.setProperty("template", "de::genesez::platforms::common::profile::templates::Root::Root");
		defaults.setProperty("typeMappingFile", "de/genesez/platforms/common/typemapping/typemapping.xml");
		
		defaults.setProperty("profileFileName", "Profile.ext");
		defaults.setProperty("accessHelperFileName", "AccessHelper.ext");
		defaults.setProperty("stereotypeNamePrefix", "");
		defaults.setProperty("enumerationNamePrefix", "");
	}
	/* PROTECTED REGION END */
	
}
