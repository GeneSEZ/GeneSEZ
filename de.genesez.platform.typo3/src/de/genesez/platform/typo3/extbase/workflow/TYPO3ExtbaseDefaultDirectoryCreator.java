package de.genesez.platform.typo3.extbase.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.XtendComponent;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Create default directory layout for an TYPO3 Extbase extension.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-07-18
 */
public class TYPO3ExtbaseDefaultDirectoryCreator extends XtendComponent {
	
	private Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.put("defaultDirectoryCreationScript", "de::genesez::platform::typo3::extbase::scripts::DefaultDirectoryCreation::createDefaultDirectories");
		defaults.put("abortOnError", "true");
	}
	
	protected Properties properties = new Properties();
	
	/**
	 * Constructs the workflow component and initializes the default values for
	 * the parameter.
	 */
	public TYPO3ExtbaseDefaultDirectoryCreator() {
		super();
		WorkflowUtils.setDefaultProperties(this, defaults);
	}
	
	@Override
	public void checkConfigurationInternal(Issues issues) {
		// check if an output directory is set.
		if (properties.getProperty("outputDir") == null) {
			issues.addError("Missing property outputDir!");
		}
		
		// add GeneSEZ meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(WorkflowUtils.defaults.getProperty("gcorePackage"));
		addMetaModel(gcore);
		
		super.checkConfigurationInternal(issues);
	}
	
	/**
	 * @param defaultDirectoryCreationScript
	 */
	public void setDefaultDirectoryCreationScript(String defaultDirectoryCreationScript) {
		logger.info("set default directory creation script: " + defaultDirectoryCreationScript);
		
		setInvoke(defaultDirectoryCreationScript + "()");
	}
	
	/**
	 * Allows to set if the workflow should be aborted if an error occurs.
	 */
	public void setAbortOnError(String abortOnError) {
		logger.info("set abort on errors: " + abortOnError);
		
		setSkipOnErrors(!Boolean.valueOf(abortOnError));
	}
	
	/**
	 * Register the output dir information as global var to have access inside
	 * Xtend and Xpand.
	 */
	public void setOutputDir(String outputDir) {
		logger.info("set output dir: " + outputDir);
		
		properties.put("outputDir", outputDir);
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("outputDir", "'" + outputDir + "'"));
	}
}
