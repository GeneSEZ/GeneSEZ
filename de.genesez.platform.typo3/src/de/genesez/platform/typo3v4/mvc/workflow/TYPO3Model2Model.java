package de.genesez.platform.typo3v4.mvc.workflow;

import java.util.Properties;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import de.genesez.metamodel.gcore.impl.MModelImpl;
import de.genesez.platforms.common.naming.NamingMapper;
import de.genesez.platforms.common.workflow.Model2Model;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Workflow component class for TYPO3 MVC model to model (M2M) modifications.
 * 
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-20
 */
public class TYPO3Model2Model extends Model2Model {

	/**
	 * Default values in case the property file is not found.
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.setProperty("useModelNameAsExtensionKey", "false");
		defaults.setProperty("isT3MVCCompliant", "false");
		defaults.setProperty("xtendNamingFile", "de::genesez::platform::typo3v4::mvc::convention::Naming");
	}

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public TYPO3Model2Model() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void checkConfigurationInternal(Issues issues) {
		super.checkConfigurationInternal(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see de.genesez.platforms.common.workflow.Model2Model#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	public void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
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
