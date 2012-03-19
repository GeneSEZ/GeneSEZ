package org.genesez.platform.documentation.workflow;

import java.util.Properties;

import org.genesez.platform.common.workflow.DefaultGenerator;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Provides a generator component for latex artifacts by setting the default latex template.
 * 
 * @author tobias haubold <toh@fh-zwickau.de>
 * @date 2011-10-03
 */
public class LatexGenerator extends DefaultGenerator {
	
	/**
	 * Default values of the generator.
	 */
	private static final Properties defaults = new Properties();
	
	static {
		defaults.setProperty("template", "org::genesez::platform::documentation::latex::Root::Root");
	}
	
	
	public LatexGenerator() {
		super();
		deleteOldFiles = false;
		deleteEmptyFolders = false;
		importTakeOver = false;
		WorkflowUtils.callPropertyAccessors(this, defaults);
	}
}
