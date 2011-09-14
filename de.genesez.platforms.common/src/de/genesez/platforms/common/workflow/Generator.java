package de.genesez.platforms.common.workflow;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.platforms.common.Deletor;

/**
 * Workflow component class to generate code (model to text transformation).
 * 
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Dominik Wetzel
 * @date 2011-09-14
 */
public class Generator extends org.eclipse.xpand2.Generator {

	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());

	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	static {
		defaults.setProperty("fileEncoding", "utf-8");
		defaults.setProperty("prDefaultExcludes", "false");
		defaults.setProperty("prExcludes", ".svn");
		defaults.setProperty("singleValuedSlot", "true");
		defaults.setProperty("deleteOld", "false");
		defaults.setProperty("deleteEmptyFolders", "false");
		defaults.setProperty("excludedDirectoryNames",
				defaults.getProperty("prExcludes", ".svn"));
	}

	/**
	 * Variable to store all properties.
	 */
	protected Properties properties = new Properties();

	// variables for the file and package deletion
	private boolean deleteOld = false;
	private boolean deleteEmptyFolders = false;
	private Deletor deletor = new Deletor(System.getProperty("java.version")
			.charAt(2) < 7);

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Generator() {
		super();

		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);

		// add GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);

		// add GeneSEZ requirements meta model
		EmfMetaModel greq = new EmfMetaModel();
		greq.setMetaModelPackage(properties.getProperty("greqPackage"));
		addMetaModel(greq);

		// add GeneSEZ traceability meta model
		EmfMetaModel gtrace = new EmfMetaModel();
		gtrace.setMetaModelPackage(properties.getProperty("gtracePackage"));
		addMetaModel(gtrace);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.xpand2.Generator#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	protected void checkConfigurationInternal(Issues issues) {
		// check if template is set.
		String template = properties.getProperty("template", "");
		if (template.length() == 0) {
			issues.addError(this, "Missing property 'template'!", template);
		} else {
			if (Boolean.valueOf(properties.getProperty("singleValuedSlot"))) {
				super.setExpand(template + " FOR "
						+ properties.getProperty("slot"));
			} else {
				super.setExpand(template + " FOREACH "
						+ properties.getProperty("slot"));
			}
		}

		// check if an output directory is set.
		String outputDir = properties.getProperty("outputDir", "");
		if (outputDir.length() == 0) {
			issues.addError(this, "Missing property 'outputDir'!", outputDir);
		} else {
			// check output dir, create if it not exists
			checkAndCreateOutputDirectory(outputDir);

			// check if an protected region directory is set.
			String proRegDir = properties.getProperty("proRegDir", "");
			if (proRegDir.length() == 0) {
				issues.addInfo(
						this,
						"Output directory is set to default for the protected region directory.",
						outputDir);
				setProRegDir(outputDir);
			}
		}
		if (!deleteOld) {
			issues.addWarning(
					this,
					"Old classfiles won't be deleted, there may occur problems after second generation.");
		} else {
			String includedFiles = properties.getProperty("includedFiles", "");
			String excludedDirNames = properties.getProperty(
					"excludedDirectoryNames",
					properties.getProperty("prExcludes", ".svn"));
			String excludedFiles = properties.getProperty("excludedFiles", "");
			String excludedPaths = properties.getProperty(
					"excludedRelativePaths", "");

			if (includedFiles.equals("") && excludedFiles.equals("")
					&& excludedPaths.equals("") && excludedDirNames.equals("")) {
				issues.addWarning(
						this,
						"Nothing included and excluded, every file will be searched and unchanged files will be deleted.");
			}
		}
		if (!deleteEmptyFolders){
			issues.addInfo(this, "Empty Folders will not be deleted after generation.");
		} else if(properties.getProperty("repositoryFolderName", "") == ""){
			issues.addInfo(this, "No repository folder name given, maybe not all empty packages can be delted.");
		}
		super.checkConfigurationInternal(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.xpand2.Generator#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void invokeInternal2(final WorkflowContext ctx,
			final ProgressMonitor monitor, final Issues issues) {
		// add available models as global variable definitions
		if (ctx.get(properties.getProperty("coreSlot")) != null) {
			addGlobalVarDef("coremodel", properties.get("coreSlot"));
		}
		if (ctx.get(properties.getProperty("reqSlot")) != null) {
			addGlobalVarDef("reqmodel", properties.get("reqSlot"));
		}
		if (ctx.get(properties.getProperty("traceSlot")) != null) {
			addGlobalVarDef("tracemodel", properties.get("traceSlot"));
		}

		// prepares the deletion of not generated files
		if (deleteOld) {
			logger.info(deletor.prepare(properties.getProperty("outputDir"))
					+ " file(s) found");
		}
		// the generation process
		super.invokeInternal2(ctx, monitor, issues);

		// deletes not generated files
		if (deleteOld) {
			List<String> deleteLog = deletor.delete();
			if (!deleteLog.isEmpty()) {
				logger.info(deleteLog.size() + " file(s) deleted");
				logger.debug("deleted file(s): " + deleteLog);
			}
		}

		// deletes empty folders
		if (deleteEmptyFolders) {
			try {
				List<String> logInfo = deletor.deleteEmptyPackages(properties
						.getProperty("outputDir"));
				if (!logInfo.isEmpty()) {
					logger.info(logInfo.size() + " folder(s) deleted");
					logger.debug("deleted folder(s): " + logInfo);
				}
			} catch (UnsupportedOperationException e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor
	 * method was found. It checks if the value of the property is a boolean or
	 * number value. If not it will be registered as string. This means, that
	 * the value is surrounded with two single quotation marks.
	 * 
	 * @param key
	 *            The name of the property.
	 * @param value
	 *            The value of the property.
	 */
	public void put(Object key, Object value) {
		String keyStr = String.valueOf(key);
		String valueStr = String.valueOf(value);

		if (!WorkflowUtils.isBoolean(valueStr)
				&& !WorkflowUtils.isNumber(valueStr)) {
			addGlobalVarDef(keyStr, valueStr);
		} else {
			addGlobalVarDef(keyStr, value);
		}
	}

	/**
	 * Add a property as string GlobalVarDef. This means, that the value is
	 * surrounded with two single quotation marks.
	 * 
	 * @param key
	 *            The name of the property.
	 * @param value
	 *            The value of the property.
	 */
	protected void addGlobalVarDef(String key, String value) {
		logger.trace("Register property (" + key + ") with value ('" + value
				+ "') as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, "'" + value
				+ "'"));
	}

	/**
	 * Add a property as GlobalVarDef.
	 * 
	 * @param key
	 *            The name of the property.
	 * @param value
	 *            The value of the property.
	 */
	protected void addGlobalVarDef(String key, Object value) {
		logger.trace("Register property (" + key + ") with value (" + value
				+ ") as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key,
				String.valueOf(value)));
	}

	// BEGIN OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>fileEncoding</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setFileEncoding(java.lang.String)
	 */
	@Override
	public void setFileEncoding(String fileEncoding) {
		super.setFileEncoding(fileEncoding);
	}

	/**
	 * Setter for the workflow parameter <em><b>prDefaultExcludes</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setPrDefaultExcludes(java.lang.Boolean)
	 */
	public void setPrDefaultExcludes(String prDefaultExcludes) {
		super.setPrDefaultExcludes(Boolean.valueOf(prDefaultExcludes));
	}

	/**
	 * Setter for the workflow parameter <em><b>prExcludes</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setPrExcludes(java.lang.String)
	 */
	@Override
	public void setPrExcludes(String prExcludes) {
		super.setPrExcludes(prExcludes);
	}

	/**
	 * Setter for the workflow parameter <em><b>singleValuedSlot</b></em>.
	 * 
	 * Sets if the slot has only one root element for which the template is
	 * executed or more.
	 * 
	 * @param singleValuedSlot
	 *            True if the slot has only one root element, otherwise false.
	 */
	public void setSingleValuedSlot(String singleValuedSlot) {
		properties.setProperty("singleValuedSlot",
				Boolean.valueOf(singleValuedSlot).toString());
	}

	/**
	 * Setter for the workflow parameter <em><b>proRegDir</b></em>.
	 * 
	 * Sets the source path for the protected regions.
	 * 
	 * @param proRegDir
	 *            The source path for the protected regions.
	 */
	public void setProRegDir(String proRegDir) {
		super.setPrSrcPaths(proRegDir);
		properties.setProperty("proRegDir", proRegDir);
	}

	/**
	 * Setter for the workflow parameter <em><b>outputDir</b></em>.
	 * 
	 * Sets the base path where the output will be generated.
	 * 
	 * @param outputDir
	 *            The base path for the output.
	 */
	public void setOutputDir(String outputDir) {
		super.addOutlet(new Outlet(outputDir));
		properties.setProperty("outputDir", outputDir);
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteOld</b></em>.
	 * 
	 * Sets if old files should be deleted or not
	 * 
	 * @param deleteOld
	 *            Value of deleteOld True if it should be deleted.
	 */
	public void setDeleteOld(String deleteOld) {
		this.deleteOld = Boolean.parseBoolean(deleteOld);
		properties.setProperty("deleteOld", deleteOld);
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteEmptyFolders</b></em>.
	 * 
	 * if this is true, empty folders will be deleted after generation process
	 * 
	 * @param deleteEmpty
	 */
	public void setDeleteEmptyFolders(String deleteEmpty) {
		this.deleteEmptyFolders = Boolean.parseBoolean(deleteEmpty);
		properties.setProperty("deleteOld", deleteEmpty);
	}

	// END OF DEFAULTS

	/**
	 * Setter for the workflow parameter <em><b>template</b></em>.
	 * 
	 * Sets the template to be executed for model to code generation.
	 * 
	 * @param template
	 *            The template to execute.
	 */
	public void setTemplate(String template) {
		properties.setProperty("template", template);
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectScript</b></em>.
	 * 
	 * Adds a aspect script with advices.
	 * 
	 * @param aspectScript
	 *            A aspect script with advices.
	 */
	public void addAspectScript(String aspectScript) {
		logger.trace("add Aspect script: " + aspectScript);
		if (aspectScript.length() > 0) {
			super.addExtensionAdvice(aspectScript);
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectScripts</b></em>.
	 * 
	 * Adds several aspect scripts with advices. The aspect scripts should be
	 * comma or semicolon separated.
	 * 
	 * @param aspectScripts
	 *            Several aspect scripts with advices.
	 */
	public void addAspectScripts(String aspectScripts) {
		if (aspectScripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectScripts);
			for (String s : filtered) {
				addAspectScript(s);
			}
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectTemplate</b></em>.
	 * 
	 * Adds a aspect template with advices.
	 * 
	 * @param aspectTemplate
	 *            A aspect template with advices.
	 */
	public void addAspectTemplate(String aspectTemplate) {
		logger.trace("Add aspect template: " + aspectTemplate);
		if (aspectTemplate.length() > 0) {
			super.addAdvice(aspectTemplate);
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>aspectTemplates</b></em>.
	 * 
	 * Adds several aspect templates with advices. The aspect templates should
	 * be comma or semicolon separated.
	 * 
	 * @param aspectTemplates
	 *            Several aspect templates with advices.
	 */
	public void addAspectTemplates(String aspectTemplates) {
		if (aspectTemplates.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectTemplates);
			for (String s : filtered) {
				addAspectTemplate(s);
			}
		}
	}

	/**
	 * Setter for the workflow parameter <em><b>slot</b></em>.
	 * 
	 * Sets the slot where the model is stored.
	 * 
	 * @param slot
	 *            The name of the model slot.
	 */
	public void setSlot(String slot) {
		properties.setProperty("slot", slot);
	}

	/**
	 * Setter for the workflow parameter <em><b>includedFiles</b></em>.
	 * 
	 * Sets extensions, that are included in the recursive file search.
	 * 
	 * @param fileExtensions
	 *            String that contains all the included extensions (seperated by
	 *            "," or ";")
	 */
	public void setIncludedFiles(String fileExtensions) {
		deletor.setIncludedFiles(fileExtensions);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedRelativePaths</b></em>.
	 * 
	 * these Paths are not searched for files
	 * 
	 * @param paths
	 *            String that contains all excluded paths (seperated by "," or
	 *            ";")
	 */
	public void setExcludedRelativePaths(String paths) {
		deletor.setExcludedRelativePaths(paths);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedFiles</b></em>.
	 * 
	 * Sets file extensions, that are excluded in the recursive file search
	 * 
	 * @param fileExtensions
	 *            String that contains all the excluded file extensions
	 *            (seperated by "," or ";")
	 */
	public void setExcludedFiles(String fileExtensions) {
		deletor.setExcludedFiles(fileExtensions);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedDirectoryNames</b></em>.
	 * 
	 * Directories with these names were not searched
	 * 
	 * @param names
	 *            String that contains all excluded directory names (seperated
	 *            by "," or ";")
	 */
	public void setExcludedDirectoryNames(String names) {
		deletor.setExcludedDirectoryNames(names);
	}
	
	/**
	 * Setter for the workflow parameter <em><b>setRepositoryFolderName</b></em>.
	 * 
	 * repository name that will be deleted if its the only one left in a folder.
	 * 
	 * NOTE: This is not safe.
	 * 
	 * @param repName name of the repository folder.
	 */
	public void setRepositoryFolderName(String repName){
		deletor.setRepositoryFolderName(repName);
		properties.put("repositoryFolderName", repName);
	}

	/**
	 * Checks if the output directory does not exists. If true the output
	 * directory will be created.
	 * 
	 * @param uri
	 *            The base path for the output.
	 */
	private void checkAndCreateOutputDirectory(String uri) {
		File f = new File(uri);
		if (!f.exists()) {
			if (!f.mkdir()) {
				logger.warn("Cannot create output directory!");
			}
		}
	}
}
