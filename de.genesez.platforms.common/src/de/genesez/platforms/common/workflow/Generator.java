package de.genesez.platforms.common.workflow;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.platforms.common.workflow.feature.PostFeature;
import de.genesez.platforms.common.workflow.feature.PreFeature;
import de.genesez.platforms.common.workflow.feature.TransformationFeature;

/**
 * Workflow component class to generate code (model to text transformation).
 * 
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Dominik Wetzel
 * @date 2011-10-11
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
	}

	/**
	 * Variable to store all properties.
	 */
	protected Properties properties = new Properties();

	// private List<TransformationFeature> features = new
	// LinkedList<TransformationFeature>();
	private List<PreFeature> preFeatures = new LinkedList<PreFeature>();
	private List<PostFeature> postFeatures = new LinkedList<PostFeature>();

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
		for (TransformationFeature feature : preFeatures) {
			feature.setProperties(properties);
			feature.checkConfiguration();
		}
		for (TransformationFeature feature : postFeatures) {
			feature.setProperties(properties);
			feature.checkConfiguration();
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

		pre();

		super.invokeInternal2(ctx, monitor, issues);

		post();
	}

	/**
	 * Runs invokePre() on PreFeatures in preFeatures-list.
	 */
	private void pre() {
		for (PreFeature feature : preFeatures) {
			feature.invokePre();
		}
	}

	/**
	 * Runs invokePost() on PostFeatures in postFeatures-list.
	 */
	private void post() {
		for (PostFeature feature : postFeatures) {
			feature.invokePost();
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
	public void setIncludedFileExtensions(String fileExtensions) {
		properties.put("includedFiles", fileExtensions);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedRelativePaths</b></em>.
	 * 
	 * these Paths are not searched for files
	 * 
	 * @param paths
	 *            String that contains all excluded paths (separated by "," or
	 *            ";")
	 */
	public void setExcludedRelativePaths(String paths) {
		properties.put("excludedRelativePaths", paths);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedFiles</b></em>.
	 * 
	 * Sets file extensions, that are excluded in the recursive file search
	 * 
	 * @param fileExtensions
	 *            String that contains all the excluded file extensions
	 *            (separated by "," or ";")
	 */
	public void setExcludedFileExtensions(String fileExtensions) {
		properties.put("excludedFiles", fileExtensions);
	}

	/**
	 * Setter for the workflow parameter <em><b>excludedDirectoryNames</b></em>.
	 * 
	 * Directories with these names were not searched
	 * 
	 * @param names
	 *            String that contains all excluded directory names (separated
	 *            by "," or ";")
	 */
	public void setExcludedDirectoryNames(String names) {
		properties.put("excludedDirectoryNames", names);
	}

	/**
	 * Adds a PreFeature to preFeatures list
	 * 
	 * @param feature
	 *            the feature that should be added.
	 */
	public void addPreFeature(PreFeature feature) {
		preFeatures.add(feature);
	}

	/**
	 * Adds a PostFeature to postFeatures list
	 * 
	 * @param feature
	 *            the feature that should be added.
	 */
	public void addPostFeature(PostFeature feature) {
		postFeatures.add(feature);
	}

	/**
	 * Adds a PostProcesser (e. g. beautifier) to the postProcessor list
	 * 
	 * @param postprocessor
	 *            the PostProcessor to add
	 */
	public void addPostProcessor(PostProcessor postprocessor) {
		@SuppressWarnings("unchecked")
		List<Object> toSet = (List<Object>) super.getBeautifier();
		toSet.add(postprocessor);
		super.setBeautifier(toSet);
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
