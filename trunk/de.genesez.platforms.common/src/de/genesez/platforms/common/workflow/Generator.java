package de.genesez.platforms.common.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.xpand2.output.Outlet;

import de.genesez.platforms.common.typemapping.TypeMapper;

/**
 * Common class for model to text (M2T) transformations
 * @author Aibek Isaev
 * @author Beishen
 */
public class Generator extends org.openarchitectureware.xpand2.Generator {
	
	private static Properties defaults = new Properties();
	static {
		defaults.putAll(WorkflowUtils.defaults);
		defaults.put("slot", "genesezModel");
		defaults.put("fileEncoding", "utf-8");
		defaults.put("prDefaultExcludes", "false");
		defaults.put("prExcludes", ".svn");
		defaults.put("excludePackages", "");
		defaults.put("basePackage", "");
		defaults.put("useModelNameAsBasePackage", "false");
		defaults.put("generateSectionComments", "true");
		defaults.put("disableAccessors", "false");
		defaults.put("useAccessorStereotype", "false");
		defaults.put("usePropertyVisibilityForAccessors", "false");
	}
	
	protected Properties properties = new Properties(defaults);
	
	private Log logger = LogFactory.getLog(getClass());
	private List<String> excludePackages = new ArrayList<String>();
	private String outputDir;
	private String template;
	
	private boolean isNotSetExcludePackages = true;
	private boolean isNotSetBasePackage = true;
	private boolean isNotSetFileEncoding = true;
	private boolean isNotSetPrDefaultExcludes = true;
	private boolean isNotSetPrExcludes = true;
	private boolean isNotSetUseModelNameAsBasePackage = true;
	private boolean isNotSetGenerateSectionComments = true;
	private boolean isNotSetDisableAccessors = true;
	private boolean isNotSetUseAccessorsStreotype = true;
	private boolean isNotSetUsePropertyVisibilityForAccessors = true;
	private boolean isSetTemplate = false;
	private boolean isNotSetProRegDir = true;
	
	
	/**
	 * create a generator object
	 */
	public Generator() {
		WorkflowUtils.loadAllProperties(properties, logger, getClass());
		
		EmfMetaModel gcore = new EmfMetaModel();
		gcore.setMetaModelPackage(properties.getProperty("gcorePackage"));
		addMetaModel(gcore);
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
		if (isSetTemplate) {
			super.setExpand(template + " FOR " + properties.getProperty("slot"));
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
		if (isNotSetDisableAccessors) {
			setDisableAccessors(new Boolean(properties.getProperty("disableAccessors")));
		}
		if (isNotSetUseAccessorsStreotype) {
			setUseAccessorStereotype(new Boolean(properties.getProperty("useAccessorStereotype")));
		}
		if (isNotSetUsePropertyVisibilityForAccessors) {
			setUsePropertyVisibilityForAccessors(new Boolean(properties.getProperty("usePropertyVisibilityForAccessors")));
		}
		// check output dir, create if it not exists
		checkAndCreateDirectory(outputDir);
		// delete config check to super class
		super.checkConfigurationInternal(issues);
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
		TypeMapper.initTypeMapper(typeMappingFile);
	}
	
	public void setTypeMappingFiles(final String typeMappingFiles) {
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
	public void setDisableAccessors(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("disableAccessors", value));
		isNotSetDisableAccessors = false;
	}
	
	/**
	 * setter for UseAccessorStereotype parameter, which in GlobalVarDef add.
	 */
	public void setUseAccessorStereotype(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("useAccessorStereotype", value));
		isNotSetUseAccessorsStreotype = false;
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
