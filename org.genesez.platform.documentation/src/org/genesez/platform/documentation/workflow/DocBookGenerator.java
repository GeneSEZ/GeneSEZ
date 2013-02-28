package org.genesez.platform.documentation.workflow;

import java.util.Properties;

import org.genesez.platform.common.workflow.DefaultGenerator;
import org.genesez.platform.common.workflow.WorkflowUtils;


/**
 * Provides a generator component for docbook artifacts by setting the default docbook template.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 * @date 2011-10-03
 */
public class DocBookGenerator extends DefaultGenerator {
	
	/**
	 * Default values of the generator.
	 */
	private static final Properties defaults = new Properties();
	
	static {
		defaults.setProperty("template", "org::genesez::platform::documentation::docbook::Root::Root");
	}
	
	
	public DocBookGenerator() {
		super();
		WorkflowUtils.callPropertyAccessors(this, defaults);
	}
}
