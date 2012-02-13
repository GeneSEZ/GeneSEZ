package org.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Workflow component class for TYPO3 MVC model additions.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-12-22
 */
public class TYPO3ModelAddition extends TYPO3Model2Model {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("script", "org::genesez::platform::typo3v4::mvc::modification::Addition::modelAdditions");
	}
	
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3ModelAddition() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}
	
	// BEGIN OF DEFAULTS
	// END OF DEFAULTS
		
}
