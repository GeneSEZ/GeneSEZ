package org.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Workflow component class for TYPO3 MVC model modifications.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-12-22
 */
public class TYPO3ModelModification extends TYPO3Model2Model {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("script", "org::genesez::platform::typo3v4::mvc::modification::Modification::modelModifications");
	}
	
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3ModelModification() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}
	
	// BEGIN OF DEFAULTS
	// END OF DEFAULTS
		
}
