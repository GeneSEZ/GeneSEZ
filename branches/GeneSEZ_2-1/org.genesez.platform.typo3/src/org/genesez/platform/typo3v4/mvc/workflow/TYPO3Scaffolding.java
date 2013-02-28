package org.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Workflow component class for TYPO3 MVC static scaffolding.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-12-22
 */
public class TYPO3Scaffolding extends TYPO3Model2Model {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("script", "org::genesez::platform::typo3v4::mvc::modification::Scaffolding::modelScaffolding");
		
		defaults.setProperty("scaffolding", "false");
	}
	
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3Scaffolding() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}
	
	// BEGIN OF DEFAULTS
	
	/**
	 * Setter for the workflow parameter <em><b>scaffolding</b></em>
	 * 
	 * Sets if static scaffolding should be enabled.
	 * 
	 * @param scaffolding True if scaffolding should be enabled, otherwise
	 *            false.
	 */
	public void setScaffolding(String scaffolding) {
		addGlobalVarDef("scaffolding", Boolean.valueOf(scaffolding));
	}
	
	// END OF DEFAULTS
		
}
