package de.genesez.platforms.common.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.emf.mwe2.runtime.workflow.IWorkflowContext;
import org.eclipse.xpand2.output.Outlet;
import org.eclipse.xtend.typesystem.emf.EmfMetaModel;

import de.genesez.platforms.common.typemapping.TypeMapper;

/**
 * Common class for model to text (M2T) transformations
 * @author Aibek Isaev
 * @author Beishen
 * @author toh (last)
 */
public class Generator extends org.eclipse.xpand2.Generator {
	
	private static Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
		defaults.put("fileEncoding", "utf-8");
		defaults.put("prDefaultExcludes", "false");
		defaults.put("prExcludes", ".svn");
		defaults.put("excludePackages", "");
		defaults.put("basePackage", "");
		defaults.put("useModelNameAsBasePackage", "false");
		defaults.put("generateSectionComments", "true");
		defaults.put("accessorsForStereotypes", "entity");
		defaults.put("accessorStereotype", "accessor");
		defaults.put("usePropertyVisibilityForAccessors", "false");
		defaults.put("singleValuedSlot", "true");
	}
	
	protected Properties properties = new Properties(defaults);
	
	private Log logger = LogFactory.getLog(getClass());
	private List<String> excludePackages = new ArrayList<String>();
	private List<String> typeMappingFiles = new ArrayList<String>();
	private String outputDir;
	private String template;
	
	private boolean isNotSetExcludePackages = true;
	private boolean isNotSetBasePackage = true;
	private boolean isNotSetFileEncoding = true;
	private boolean isNotSetPrDefaultExcludes = true;
	private boolean isNotSetPrExcludes = true;
	private boolean isNotSetUseModelNameAsBasePackage = true;
	private boolean isNotSetGenerateSectionComments = true;
	private boolean isNotSetAccessorsForStereotypes = true;
	private boolean isNotSetAccessorStereotype = true;
	private boolean isNotSetUsePropertyVisibilityForAccessors = true;
	private boolean isSetTemplate = false;
	private boolean isNotSetProRegDir = true;
	
	
	/**
	 * create a generator object
	 */
	public Generator() {
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
		
		EmfMetaModel greq = new EmfMetaModel();
		greq.setMetaModelPackage(properties.getProperty("greqPackage"));
		addMetaModel(greq);
		
		EmfMetaModel gtrace = new EmfMetaModel();
		gtrace.setMetaModelPackage(properties.getProperty("gtracePackage"));
		addMetaModel(gtrace);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see org.openarchitectureware.xpand2.Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal (Issues issues) {
		// output dir is the default for the protected region directory
		if (isNotSetProRegDir) {
			setProRegDir(outputDir);
		}
		if (Boolean.parseBoolean(properties.getProperty("singleValuedSlot", "true"))) {
			if (isSetTemplate) {
				super.setExpand(template + " FOR " + properties.getProperty("slot"));
			}
		} else {
			if (isSetTemplate) {
				super.setExpand(template + " FOREACH " + properties.getProperty("slot"));
			}
		}
		if (isNotSetFileEncoding) {
			setFileEncoding(properties.getProperty("fileEncoding"));
		}
		if (isNotSetPrDefaultExcludes) {
			setPrDefaultExcludes(new Boolean(properties.getProperty("prDefaultExcludes")));
		}
		if (isNotSetPrExcludes) {
			setPrExcludes(properties.getProperty("prExcludes"));
		}
		if (isNotSetExcludePackages) {
			super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef(
					"excludePackages", "'" + properties.getProperty("excludePackages") + "'"));
		} else {
			String packages = "'" + WorkflowUtils.arrayToString(excludePackages) + "'";
			super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("excludePackages", packages));
		}
		if (isNotSetBasePackage) {
			setBasePackage(properties.getProperty("basePackage"));
		}
		if (isNotSetUseModelNameAsBasePackage) {
			setUseModelNameAsBasePackage(new Boolean(properties.getProperty("useModelNameAsBasePackage")));
		}
		if (isNotSetGenerateSectionComments) {
			setGenerateSectionComments(new Boolean(properties.getProperty("generateSectionComments")));
		}
		if (isNotSetAccessorsForStereotypes) {
			setAccessorsForStereotypes("'" + properties.getProperty("accessorsForStereotypes") + "'");
		}
		if (isNotSetAccessorStereotype) {
			setAccessorStereotype("'" + properties.getProperty("accessorStereotype") + "'");
		}
		if (isNotSetUsePropertyVisibilityForAccessors) {
			setUsePropertyVisibilityForAccessors(new Boolean(properties.getProperty("usePropertyVisibilityForAccessors")));
		}
		// init type mapper
		TypeMapper.initTypeMapper(typeMappingFiles.toArray(new String[0]));
		// check output dir, create if it not exists
		checkAndCreateDirectory(outputDir);
		// delete config check to super class
		super.checkConfigurationInternal(issues);
	}
	
	/**
	 * Make available genesez models available as global variables.
	 * @see org.eclipse.xpand2.Generator#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext, org.eclipse.emf.mwe.core.monitor.ProgressMonitor, org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {
		// add available models as global variable definitions
		if (ctx.get(properties.getProperty("coreSlot")) != null) {
			addGlobalVarDef(WorkflowUtils.createGlobalVarDef("coremodel", properties.getProperty("coreSlot")));
		}
		if (ctx.get(properties.getProperty("reqSlot")) != null) {
			addGlobalVarDef(WorkflowUtils.createGlobalVarDef("reqmodel", properties.getProperty("reqSlot")));
		}
		if (ctx.get(properties.getProperty("traceSlot")) != null) {
			addGlobalVarDef(WorkflowUtils.createGlobalVarDef("tracemodel", properties.getProperty("traceSlot")));
		}
		super.invokeInternal2(ctx, monitor, issues);
	}
	
	/**
	 * Overridden setter FileEncoding parameter in super class.
	 * 
	 * @see org.openarchitectureware.xpand2.Generator#setFileEncoding(java.lang.String)
	 */
	@Override
	public void setFileEncoding(String fileEncoding) {
		super.setFileEncoding(fileEncoding);
		isNotSetFileEncoding = false;
	}
	
	/**
	 * Overridden setter PrdefaultExcludes parameter in super class.
	 * 
	 * @see org.openarchitectureware.xpand2.Generator#setPrDefaultExcludes(boolean)
	 */
	@Override
	public void setPrDefaultExcludes(boolean prDefaultExcludes) {
		super.setPrDefaultExcludes(prDefaultExcludes);
		isNotSetPrDefaultExcludes = false;
	}
	
	/**
	 * Overridden setter PrExcludes parameter in super class.
	 * 
	 * @see org.openarchitectureware.xpand2.Generator#setPrExcludes(java.lang.String)
	 */
	@Override
	public void setPrExcludes(String prExcludes) {
		super.setPrExcludes(prExcludes);
		isNotSetPrExcludes = false;
	}
	
	/**
	 * setter for OutputDir parameter in super class. This is the default value for 
	 * the protected region directory
	 */
	public void setOutputDir(String outputDir) {
		Outlet outlet = new Outlet();
		outlet.setPath(outputDir);
		super.addOutlet(outlet);
		this.outputDir = outputDir;
	}
	
	/**
	 * setter for ProRegDir parameter in super class.
	 */
	public void setProRegDir(String proRegDir) {
		super.setPrSrcPaths(proRegDir);
		isNotSetProRegDir = false;
	}
	
	/**
	 * setter for Template parameter.
	 */
	public void setTemplate(String template) {
 		this.template = template;
		isSetTemplate = true;
	}
	
	public void setSingleValuedSlot(String value) {
		properties.put("singleValuedSlot", value);
	}
	
	/**
	 * setter for Slot parameter.
	 */
	public void setSlot(String slot){
		properties.put("slot", slot);
	}
	
	/**
	 * adder for aspect templates with advices
	 * @param aspectTemplate
	 */
	public void addAspectTemplate(String aspectTemplate) {
		logger.trace("Generator.addAspectTemplate: " + aspectTemplate);
		if (aspectTemplate.length() > 0) {
			super.addAdvice(aspectTemplate);
		}
	}
	
	/**
	 * setter for AspectTemplates parameter in super class.
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
	 * adder for aspect scripts with advices
	 * @param aspectScript
	 */
	public void addAspectScript(String aspectScript) {
		if (aspectScript.length() > 0) {
			super.addExtensionAdvice(aspectScript);
		}
	}
	
	/**
	 * setter for AspectScripts parameter in super class.
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
	 * setter for the type mapping file
	 * 
	 * @param typeMappingFile
	 *            name of the file used by the generator for type mapping
	 */
	public void addTypeMappingFile(final String typeMappingFile) {
		typeMappingFiles.add(typeMappingFile);
	}
	
	public void addTypeMappingFiles(final String typeMappingFiles) {
		if (typeMappingFiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(typeMappingFiles);
			for (String s : filtered) {
				addTypeMappingFile(s);
			}
		}
	}
	
	public void addExcludePackage(String value) {
		excludePackages.add(value);
		isNotSetExcludePackages = false;
	}
	
	/**
	 * adder for ExcludePackages parameter, which in GlobalVarDef add.
	 */
	public void addExcludePackages(String excludePackages) {
		if (excludePackages.length() > 0) {
			List<String> filtered = WorkflowUtils.split(excludePackages);
			for (String s : filtered) {
				addExcludePackage(s);
			}
		}
	}
	
	/**
	 * setter for BasePackage parameter, which in GlobalVarDef add.
	 */
	public void setBasePackage(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("basePackage", "'" + value + "'"));
		isNotSetBasePackage = false;
	}
	
	/**
	 * setter for UseModelNameAsBasePackage parameter, which in GlobalVarDef
	 * add.
	 */
	public void setUseModelNameAsBasePackage(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("useModelNameAsBasePackage", value));
		isNotSetUseModelNameAsBasePackage = false;
	}
	
	/**
	 * setter for GenerateSectionComments parameter, which in GlobalVarDef add.
	 */
	public void setGenerateSectionComments(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("generateSectionComments", value));
		isNotSetGenerateSectionComments = false;
	}
	
	/**
	 * setter for DisableAccessors parameter, which in GlobalVarDef add.
	 */
	public void setAccessorsForStereotypes(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("accessorsForStereotypes", value));
		isNotSetAccessorsForStereotypes = false;
	}
	
	/**
	 * setter for UseAccessorStereotype parameter, which in GlobalVarDef add.
	 */
	public void setAccessorStereotype(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("accessorStereotype", value));
		isNotSetAccessorStereotype = false;
	}
	
	/**
	 * setter for UsePropertyVisibilityForAccessors parameter, which in
	 * GlobalVarDef add.
	 */
	public void setUsePropertyVisibilityForAccessors(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("usePropertyVisibilityForAccessors", value));
		isNotSetUsePropertyVisibilityForAccessors = false;
	}
	
	/**
	 * setter for GonfigFile parameter, which in GlobalVarDef add.
	 */
	public void setConfigFile(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("configFile", "'" + value + "'"));
	}
	
	private void checkAndCreateDirectory(String file) {
		File f = new File(file);
		if (!f.exists()) {
			if (!f.mkdir()) {
				logger.warn("cannot create output directory");
			}
		}
	}
}
