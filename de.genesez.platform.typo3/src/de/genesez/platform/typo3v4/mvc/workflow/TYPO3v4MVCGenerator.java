package de.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import de.genesez.metamodel.gcore.impl.MModelImpl;
import de.genesez.platforms.common.workflow.Generator;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Performs source code generation for the TYPO3 Extbase platform.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-04-13
 */
public class TYPO3v4MVCGenerator extends Generator {
	
	private Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "de::genesez::platform::typo3v4::mvc::templates::Root::Root");
		defaults.put("typeMappingFile", "de/genesez/platform/typo3v4/mvc/typemapping/typemapping.xml");
		defaults.put("useModelNameAsExtensionKey", "false");
		defaults.put("isT3ExtbaseCompliant", "false");
		defaults.put("scaffolding", "false");
	}
	
	/**
	 * Constructs the workflow component and initializes the default values for
	 * the parameter.
	 */
	public TYPO3v4MVCGenerator() {
		super();
		WorkflowUtils.setDefaultProperties(this, defaults);
	}
	
	@Override
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		// Checks if the model name should be used as extension key.
		if (Boolean.valueOf(properties.getProperty("useModelNameAsExtensionKey")) == true) {
			// If true then get the gcore-based model and 
			// set the model name as extension key. 
			MModelImpl coreModel = (MModelImpl) ctx.get(properties.getProperty("coreSlot"));
			setExtensionKey(coreModel.getName());
		}
		
		super.invokeInternal2(ctx, monitor, issues);
	}
	
	/**
	 * Modify the super class method to register the output dir information as
	 * global var to have access inside Xtend and Xpand.
	 * 
	 * @see de.genesez.platforms.common.workflow.Generator#setOutputDir(java.lang.String)
	 */
	@Override
	public void setOutputDir(String outputDir) {
		super.setOutputDir(outputDir);
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("outputDir", "'" + outputDir + "'"));
	}
	
	/**
	 * Because the fact that for TYPO3 Extbase the model package hierarchy is
	 * not relevant, this setting will be ignored.
	 * 
	 * @see de.genesez.platforms.common.workflow.Generator#setBasePackage(java.lang.String)
	 */
	@Override
	public void setBasePackage(String value) {
		logger.info("The 'setBasePackage' setting will be ignored!");
		
		super.setBasePackage("");
	}
	
	/**
	 * Because the fact that for TYPO3 Extbase the model package hierarchy is
	 * not relevant, this setting will be ignored.
	 * 
	 * @see de.genesez.platforms.common.workflow.Generator#setUseModelNameAsBasePackage(boolean)
	 */
	@Override
	public void setUseModelNameAsBasePackage(boolean value) {
		logger.info("The 'useModelNameAsBasePackage' setting will be ignored!");
		
		super.setUseModelNameAsBasePackage(false);
	}
	
	/**
	 * Setter for the workflow parameter <em><b>isT3ExtbaseCompliant</b></em>.
	 * 
	 * @param isT3ExtbaseCompliant true if the model package structure is equal
	 *            TYPO3 Extbase Extension structure, otherwise false
	 */
	public void setIsT3ExtbaseCompliant(String isT3ExtbaseCompliant) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("isT3ExtbaseCompliant", isT3ExtbaseCompliant));
	}
	
	/**
	 * setter for the workflow parameter <em><b>scaffolding</b></em>
	 * 
	 * @param scaffolding true if scaffolding is enabled, otherwise false
	 */
	public void setScaffolding(String scaffolding) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("scaffolding", scaffolding));
	}
	
	/**
	 * Setter for the workflow parameter
	 * <em><b>useModelNameAsExtensionKey</b></em>.
	 */
	public void setUseModelNameAsExtensionKey(String value) {
		properties.setProperty("useModelNameAsExtensionKey", value);
	}
	
	/**
	 * Setter for the workflow parameter <em><b>extensionKey</b></em>.
	 * 
	 * @param extensionKey name of TYPO3 extbase extension
	 */
	public void setExtensionKey(String extensionKey) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("extensionKey", "'" + extensionKey + "'"));
	}
	
	
	public void put(Object name, Object value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(String.valueOf(name), "'" + String.valueOf(value) + "'"));
	}
	
}
