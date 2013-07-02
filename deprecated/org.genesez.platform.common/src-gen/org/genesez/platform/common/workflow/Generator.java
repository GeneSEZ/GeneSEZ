package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317371954349_835214_1662) 
 */

import java.util.List;

import org.genesez.platform.common.workflow.feature.PostFeature;
import org.genesez.platform.common.workflow.feature.PreFeature;
import org.genesez.platform.common.workflow.feature.TransformationFeature;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import java.util.Properties;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xpand2.output.PostProcessor;
import java.io.File;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

/**
 * Workflow component class to generate code (model to text transformation).
 * 
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Dominik Wetzel
 * @date 2011-10-11
 * @deprecated
 */
public class Generator extends org.eclipse.xpand2.Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores associated objects of association PREFEATURES to PreFeature */
	private java.util.List<PreFeature> preFeatures = new java.util.ArrayList<PreFeature>();
	
	/** Stores associated objects of association POSTFEATURES to PostFeature */
	private java.util.List<PostFeature> postFeatures = new java.util.ArrayList<PostFeature>();
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Variable to store all properties.
	 */
	protected Properties properties = new Properties();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public Generator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1318594725725_281377_3609) ENABLED START */
		super();
		
		WorkflowUtils.callPropertyAccessors(this, defaults);
		properties.putAll(WorkflowProperties.defaults);
		
		// add GeneSEZ core meta model
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
		
		// add GeneSEZ presentation meta model
		EmfMetaModel gpres = new EmfMetaModel();
		gpres.setMetaModelPackage(properties.getProperty("gpresentationPackage"));
		addMetaModel(gpres);
		
		// add GeneSEZ requirements meta model
		EmfMetaModel greq = new EmfMetaModel();
		greq.setMetaModelPackage(properties.getProperty("greqPackage"));
		addMetaModel(greq);
		
		// add GeneSEZ traceability meta model
		EmfMetaModel gtrace = new EmfMetaModel();
		gtrace.setMetaModelPackage(properties.getProperty("gtracePackage"));
		addMetaModel(gtrace);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * @see org.eclipse.xpand2.Generator#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	
	 */
	
	protected void checkConfigurationInternal(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594729812_733367_3613) ENABLED START */
		// check if template is set.
		String template = properties.getProperty("template", "");
		if (template.length() == 0) {
			issues.addError(this, "Missing property 'template'!", template);
		} else {
			if (Boolean.valueOf(properties.getProperty("singleValuedSlot"))) {
				super.setExpand(template + " FOR " + properties.getProperty("slot"));
			} else {
				super.setExpand(template + " FOREACH " + properties.getProperty("slot"));
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
				issues.addInfo(this, "Output directory is set to default for the protected region directory.", outputDir);
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * @see 	org.eclipse.xpand2.Generator#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 * org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594768312_248193_3618) ENABLED START */
		// add available models as global variable definitions
		if (ctx.get(properties.getProperty("coreSlot")) != null) {
			addGlobalVarDef("coremodel", properties.get("coreSlot"));
		}
		if (ctx.get(properties.getProperty("presentationSlot")) != null) {
			addGlobalVarDef("presentationmodel", properties.get("presentationSlot"));
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
		/* PROTECTED REGION END */
	}
	
	/**
	 * Runs invokePre() on PreFeatures in preFeatures-list.
	 */
	
	private void pre() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594840427_7588_3626) ENABLED START */
		for (PreFeature feature : preFeatures) {
			feature.invokePre();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Runs invokePost() on PostFeatures in postFeatures-list.
	 */
	
	private void post() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594854136_664402_3630) ENABLED START */
		for (PostFeature feature : postFeatures) {
			feature.invokePost();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method add a property as GlobalVarDef if no setter or adder accessor method was found. It checks if the value of the property is a boolean or number value. If not it will be registered as string. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property
	 * @param	value	The value of the property.
	 */
	
	public void put(Object key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594861157_637701_3634) ENABLED START */
		String keyStr = String.valueOf(key);
		String valueStr = String.valueOf(value);
		
		if (!WorkflowUtils.isBoolean(valueStr) && !WorkflowUtils.isNumber(valueStr)) {
			addGlobalVarDef(keyStr, valueStr);
		} else {
			addGlobalVarDef(keyStr, value);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add a property as string GlobalVarDef. This means, that the value is surrounded with two single quotation marks.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	protected void addGlobalVarDef(String key, String value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594889062_815027_3641) ENABLED START */
		logger.trace("Register property (" + key + ") with value ('" + value + "') as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, "'" + value + "'"));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add a property as GlobalVarDef.
	 * @param	key	The name of the property.
	 * @param	value	The value of the property.
	 */
	
	protected void addGlobalVarDef(String key, Object value) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594932074_613106_3647) ENABLED START */
		logger.trace("Register property (" + key + ") with value (" + value + ") as global variable definition.");
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(key, String.valueOf(value)));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>fileEncoding</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setFileEncoding(java.lang.String)
	 * @param	fileEncoding	
	 */
	
	public void setFileEncoding(String fileEncoding) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594963536_831565_3652) ENABLED START */
		super.setFileEncoding(fileEncoding);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>prDefaultExcludes</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setPrDefaultExcludes(java.lang.Boolean)
	 * @param	prDefaultExcludes	
	 */
	
	public void setPrDefaultExcludes(String prDefaultExcludes) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318594995517_850097_3656) ENABLED START */
		super.setPrDefaultExcludes(Boolean.valueOf(prDefaultExcludes));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>prExcludes</b></em>.
	 * 
	 * @see org.eclipse.xpand2.Generator#setPrExcludes(java.lang.String)
	 * @param	prExcludes	
	 */
	
	public void setPrExcludes(String prExcludes) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595020942_545988_3660) ENABLED START */
		super.setPrExcludes(prExcludes);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>singleValuedSlot</b></em>.
	 * Sets if the slot has only one root element for which the template is executed or more.
	 * @param	singleValuedSlot	True if the slot has only one root element, otherwise false.
	 */
	
	public void setSingleValuedSlot(String singleValuedSlot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595088463_96083_3665) ENABLED START */
		properties.setProperty("singleValuedSlot", Boolean.valueOf(singleValuedSlot).toString());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>proRegDir</b></em>.
	 * Sets the source path for the protected regions.
	 * @param	proRegDir	The source path for the protected regions.
	 */
	
	public void setProRegDir(String proRegDir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595112257_406435_3669) ENABLED START */
		super.setPrSrcPaths(proRegDir);
		properties.setProperty("proRegDir", proRegDir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>outputDir</b></em>.
	 * Sets the base path where the output will be generated.
	 * @param	outputDir	The base path for the output.
	 */
	
	public void setOutputDir(String outputDir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595129013_834691_3673) ENABLED START */
		super.addOutlet(new Outlet(outputDir));
		properties.setProperty("outputDir", outputDir);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>template</b></em>.
	 * Sets the template to be executed for model to code generation.
	 * @param	template	The template to execute.
	 */
	
	public void setTemplate(String template) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595161412_374906_3677) ENABLED START */
		properties.setProperty("template", template);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScript</b></em>.
	 * Adds a aspect script with advices.
	 * @param	aspectScript	A aspect script with advices.
	 */
	
	public void addAspectScript(String aspectScript) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595171010_508812_3681) ENABLED START */
		logger.trace("add Aspect script: " + aspectScript);
		if (aspectScript.length() > 0) {
			super.addExtensionAdvice(aspectScript);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectScripts</b></em>.
	 * Adds several aspect scripts with advices. The aspect scripts should be comma or semicolon separated.
	 * @param	aspectScripts	Several aspect scripts with advices.
	 */
	
	public void addAspectScripts(String aspectScripts) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595197714_176844_3685) ENABLED START */
		if (aspectScripts.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectScripts);
			for (String s : filtered) {
				addAspectScript(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectTemplate</b></em>.
	 * Adds a aspect template with advices.
	 * @param	aspectTemplate	A aspect template with advices.
	 */
	
	public void addAspectTemplate(String aspectTemplate) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595215532_232287_3689) ENABLED START */
		logger.trace("Add aspect template: " + aspectTemplate);
		if (aspectTemplate.length() > 0) {
			super.addAdvice(aspectTemplate);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>aspectTemplates</b></em>.
	 * Adds several aspect templates with advices. The aspect templates should be comma or semicolon separated.
	 * @param	aspectTemplates	Several aspect templates with advices.
	 */
	
	public void addAspectTemplates(String aspectTemplates) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595233324_854765_3693) ENABLED START */
		if (aspectTemplates.length() > 0) {
			List<String> filtered = WorkflowUtils.split(aspectTemplates);
			for (String s : filtered) {
				addAspectTemplate(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>slot</b></em>.
	 * Sets the slot where the model is stored.
	 * @param	slot	The name of the model slot.
	 */
	
	public void setSlot(String slot) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595249165_974503_3697) ENABLED START */
		properties.setProperty("slot", slot);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>includedFiles</b></em>.
	 * Sets extensions, that are included in the recursive file search.
	 * @param	fileExtensions	String that contains all the included extensions (separated by "," or ";")
	 */
	
	public void setIncludedFileExtensions(String fileExtensions) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595257626_490232_3701) ENABLED START */
		properties.put("includedFiles", fileExtensions);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>excludedFiles</b></em>.
	 * Sets file extensions, that are excluded in the recursive file search.
	 * @param	fileExtensions	String that contains all the excluded file extensions (separated by "," or ";")
	 */
	
	public void setExcludedFileExtensions(String fileExtensions) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595293681_824773_3706) ENABLED START */
		properties.put("excludedFiles", fileExtensions);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>excludedRelativePaths</b></em>.
	 * These Paths are not searched for files.
	 * @param	paths	String that contains all excluded paths (separated by "," or ";")
	 */
	
	public void setExcludedRelativePaths(String paths) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595308471_784241_3710) ENABLED START */
		properties.put("excludedRelativePaths", paths);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>excludedDirectoryNames</b></em>.
	 * Directories with these names were not searched
	 * @param	names	String that contains all excluded directory names (separated by "," or ";")
	 */
	
	public void setExcludedDirectoryNames(String names) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595324128_631760_3714) ENABLED START */
		properties.put("excludedDirectoryNames", names);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds a PreFeature to preFeatures list
	 * @param	feature	the feature that should be added.
	 */
	
	public void addPreFeature(PreFeature feature) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595339435_566550_3718) ENABLED START */
		preFeatures.add(feature);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds a PostFeature to postFeatures list
	 * @param	feature	the feature that should be added.
	 */
	
	public void addPostFeature(PostFeature feature) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595362650_852451_3722) ENABLED START */
		postFeatures.add(feature);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adds a PostProcessor (e. g. beautifier) to the postProcessor list
	 * @param	postprocessor	the PostProcessor to add
	 */
	
	public void addPostProcessor(PostProcessor postprocessor) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595374050_535582_3726) ENABLED START */
		@SuppressWarnings("unchecked")
		List<Object> toSet = (List<Object>) super.getBeautifier();
		toSet.add(postprocessor);
		super.setBeautifier(toSet);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Checks if the output directory does not exists. If true the output directory will be created.
	 * @param	uri	The base path for the output.
	 */
	
	private void checkAndCreateOutputDirectory(String uri) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595392294_659751_3730) ENABLED START */
		File f = new File(uri);
		if (!f.exists()) {
			if (!f.mkdir()) {
				logger.warn("Cannot create output directory!");
			}
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317371954349_835214_1662) ENABLED START */
	static {
		defaults.setProperty("fileEncoding", "utf-8");
		defaults.setProperty("prDefaultExcludes", "false");
		defaults.setProperty("prExcludes", ".svn");
		defaults.setProperty("singleValuedSlot", "true");
	}
	/* PROTECTED REGION END */
	
}
