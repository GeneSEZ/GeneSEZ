package org.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import org.genesez.metamodel.gcore.impl.MModelImpl;

import org.genesez.platform.common.naming.NamingMapper;
import org.genesez.platform.common.workflow.DefaultGenerator;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Workflow component class for TYPO3 MVC model to text (M2T) generation.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class TYPO3Generator extends DefaultGenerator {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("template", "org::genesez::platform::typo3v4::mvc::templates::Root::Root");
		defaults.setProperty("typeMappingFile", "org/genesez/platform/typo3v4/mvc/typemapping/typemapping.xml");
		defaults.setProperty("xtendNamingFile", "org::genesez::platform::typo3v4::mvc::convention::Naming");

		defaults.setProperty("useModelNameAsExtensionKey", "false");
		defaults.setProperty("isT3MVCCompliant", "false");
		defaults.setProperty("scaffolding", "false");
		
	}

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3Generator() {
		super();
		
		deleteOldFiles = false;
		deleteEmptyFolders = false;
		importTakeOver = false;

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.genesez.platform.common.workflow.Generator2#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		// checks if the model name should be used as extension key
		if (Boolean.valueOf(properties.getProperty("useModelNameAsExtensionKey"))) {
			// If true then get the gcore-based model and set the model name as
			// extension key.
			MModelImpl coreModel = (MModelImpl) ctx.get(properties.getProperty("coreSlot"));
			setExtensionKey(coreModel.getName());
		}

		// check if extension key is set.
		String extensionKey = properties.getProperty("extensionKey", "");
		if (extensionKey.length() == 0) {
			issues.addError(this, "Missing property 'extensionKey' or 'useModelNameAsExtensionKey'!", extensionKey);
		} else {
			addGlobalVarDef("extensionKey", extensionKey);
		}

		// init naming mapper
		NamingMapper.initNamingMapper(properties.getProperty("xtendNamingFile"), getExecutionContext(ctx));

		super.invokeInternal2(ctx, monitor, issues);
	}

	// BEGIN OF DEFAULTS

	/**
	 * Because the fact that for TYPO3 MVC the model package hierarchy is not
	 * relevant, this setting will be ignored.
	 * 
	 * @see org.genesez.platform.common.workflow.TypeMappingGenerator#setBasePackage(java.lang.String)
	 */
	public void setBasePackage(String basePackage) {
		logger.info("The 'setBasePackage' setting will be ignored!");
	}

	/**
	 * Because the fact that for TYPO3 MVC the model package hierarchy is not
	 * relevant, this setting will be ignored.
	 * 
	 * @see org.genesez.platform.common.workflow.Generator2#setUseModelNameAsBasePackage(java.lang.String)
	 */
	public void setUseModelNameAsBasePackage(String useModelNameAsBasePackage) {
		logger.info("The 'useModelNameAsBasePackage' setting will be ignored!");
	}

	/**
	 * Setter for the workflow parameter
	 * <em><b>useModelNameAsExtensionKey</b></em>.
	 * 
	 * Sets if the name of the model should be used as TYPO3 MVC extension key.
	 * 
	 * @param useModelNameAsExtensionKey True if the model name should be used,
	 *            otherwise false.
	 */
	public void setUseModelNameAsExtensionKey(String useModelNameAsExtensionKey) {
		properties.setProperty("useModelNameAsExtensionKey", Boolean.valueOf(useModelNameAsExtensionKey).toString());
	}

	/**
	 * Setter for the workflow parameter <em><b>isT3MVCCompliant</b></em>.
	 * 
	 * Sets if the model package structure is TYPO3 MVC complaint.
	 * 
	 * @param isT3MVCCompliant True if the model package structure is complaint,
	 *            otherwise false.
	 */
	public void setIsT3MVCCompliant(String isT3MVCCompliant) {
		addGlobalVarDef("isT3MVCCompliant", Boolean.valueOf(isT3MVCCompliant));
	}

	/**
	 * Setter for the workflow parameter <em><b>xtendNamingFile</b></em>.
	 * 
	 * Sets the TYPO3 MVC Xtend file where the TYPO3 MVC naming scripts are
	 * located.
	 * 
	 * @param xtendNamingFile The TYPO3 MVC Xtend file.
	 */
	public void setXtendNamingFile(String xtendNamingFile) {
		properties.setProperty("xtendNamingFile", xtendNamingFile);
	}

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

	/**
	 * Setter for the workflow parameter <em><b>extensionKey</b></em>.
	 * 
	 * Sets the key of the TYPO3 MVC extension.
	 * 
	 * @param extensionKey TYPO3 MVC extension key.
	 */
	public void setExtensionKey(String extensionKey) {
		properties.setProperty("extensionKey", extensionKey);
	}

}
