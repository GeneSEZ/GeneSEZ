package org.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.eclipse.emf.mwe.core.issues.Issues;

import org.genesez.platform.common.workflow.Model2Model;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Workflow component class to create the default directory layout for an TYPO3
 * MVC extension.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class TYPO3DefaultDirectoryCreator extends Model2Model {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("script", "org::genesez::platform::typo3v4::mvc::scripts::DefaultDirectoryCreation::createDefaultDirectories");
		defaults.setProperty("slot", "");
	}

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3DefaultDirectoryCreator() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.genesez.platform.common.workflow.Model2Model#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void checkConfigurationInternal(Issues issues) {
		// check if the output directory is set.
		String outputDir = properties.getProperty("outputDir", "");
		if (outputDir.length() == 0) {
			issues.addError("Missing property 'outputDir'!");
		} else {
			addGlobalVarDef("outputDir", outputDir);
		}

		super.checkConfigurationInternal(issues);
	}

	/**
	 * Setter for the workflow parameter <em><b>outputDir</b></em>.
	 * 
	 * Sets the base path where the output will be generated.
	 * 
	 * @param outputDir The base path for the output.
	 */
	public void setOutputDir(String outputDir) {
		properties.put("outputDir", outputDir);
	}
}
