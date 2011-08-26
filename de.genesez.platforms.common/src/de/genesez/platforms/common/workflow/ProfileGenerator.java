package de.genesez.platforms.common.workflow;

import java.util.Properties;

/**
 * Workflow component class to generate code (model to text transformation) for
 * a profile.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-23
 */
public class ProfileGenerator extends AbstractGenerator {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("template", "de::genesez::platforms::common::profile::templates::Root::Root");
		defaults.setProperty("typeMappingFile", "de/genesez/platforms/common/typemapping/typemapping.xml");

		defaults.setProperty("profileFileName", "Profile.ext");
		defaults.setProperty("accessHelperFileName", "AccessHelper.ext");
		defaults.setProperty("stereotypeNamePrefix", "");
		defaults.setProperty("enumerationNamePrefix", "");
	}

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public ProfileGenerator() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	/**
	 * Setter for the workflow parameter <em><b>profileFileName</b></em>.
	 * 
	 * Sets the file name and path where the profile file will be generated.
	 * 
	 * @param profileFileName The name and path of the profile file.
	 */
	public void setProfileFileName(String profileFileName) {
		addGlobalVarDef("profileFileName", profileFileName);
	}

	/**
	 * Setter for the workflow parameter <em><b>accessHelperFileName</b></em>.
	 * 
	 * Sets the file name and path where the profile access helper file will be
	 * generated.
	 * 
	 * @param accessHelperFileName The name and path of the profile access
	 *            helper file.
	 */
	public void setAccessHelperFileName(String accessHelperFileName) {
		addGlobalVarDef("accessHelperFileName", accessHelperFileName);
	}

	/**
	 * Setter for the workflow parameter <em><b>stereotypeNamePrefix</b></em>.
	 * 
	 * Sets the name prefix which is added to all Xtend scripts for stereotypes.
	 * 
	 * @param stereotypeNamePrefix The name prefix.
	 */
	public void setStereotypeNamePrefix(String stereotypeNamePrefix) {
		addGlobalVarDef("stereotypeNamePrefix", stereotypeNamePrefix);
	}

	/**
	 * Setter for the workflow parameter <em><b>enumerationNamePrefix</b></em>.
	 * 
	 * Sets the name prefix which is added to all Xtend scripts for
	 * enumerations.
	 * 
	 * @param enumerationNamePrefix The name prefix.
	 */
	public void setEnumerationNamePrefix(String enumerationNamePrefix) {
		addGlobalVarDef("enumerationNamePrefix", enumerationNamePrefix);
	}

}
