package de.genesez.platforms.common.workflow;

import java.util.Properties;

import de.genesez.platforms.common.workflow.Generator;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Performs source code generation for the EMP platform.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-07-20
 */
public class ProfileGenerator extends Generator {
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "de::genesez::platforms::common::profile::templates::Root::Root");
		defaults.put("typeMappingFile", "de/genesez/platforms/common/typemapping/typemapping.xml");
		defaults.put("profileFileName", "Profile.ext");
		defaults.put("accessHelperFileName", "AccessHelper.ext");
		defaults.put("dependStereotypeNamePrefix", "");
		defaults.put("dependEnumerationNamePrefix", "");
	}
	
	/**
	 * Constructs the workflow component and initializes the default values for
	 * the parameter.
	 */
	public ProfileGenerator() {
		super();
		WorkflowUtils.setDefaultProperties(this, defaults);
	}
	
	/**
	 * Setter for the workflow parameter
	 * <em><b>profileFileName</b></em>.
	 */
	public void setProfileFileName(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("profileFileName", "'" + value + "'"));
	}
	
	/**
	 * Setter for the workflow parameter
	 * <em><b>accessHelperFileName</b></em>.
	 */
	public void setAccessHelperFileName(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("accessHelperFileName", "'" + value + "'"));
	}
	
	/**
	 * Setter for the workflow parameter
	 * <em><b>dependStereotypeNamePrefix</b></em>.
	 */
	public void setDependStereotypeNamePrefix(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("dependStereotypeNamePrefix", "'" + value + "'"));
	}
	
	/**
	 * Setter for the workflow parameter
	 * <em><b>dependEnumerationNamePrefix</b></em>.
	 */
	public void setDependEnumerationNamePrefix(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("dependEnumerationNamePrefix", "'" + value + "'"));
	}
	
}
