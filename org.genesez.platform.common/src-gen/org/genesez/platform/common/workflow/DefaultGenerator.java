package org.genesez.platform.common.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317994867406_376688_2793) 
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.genesez.platform.common.m2t.ImportBeautifier;
import org.genesez.platform.common.typemapping.TypeMapper;
import org.genesez.platform.common.workflow.feature.FileDeletionFeature;
import org.genesez.platform.common.workflow.feature.FileTreeWalkerFeature;
import org.genesez.platform.common.workflow.feature.FolderDeletionFeature;

import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

/**
 * Workflow component class to generate code (model to text transformation), with default properties.
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @author Dominik Wetzel
 * @date 2011-10-12
 */
public class DefaultGenerator extends Generator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
	
	/**
	 * Variable to store all exclude packages.
	 */
	
	protected java.util.Set<String> excludedPackages = new java.util.HashSet<String>();
	
	/**
	 * Variable to store all type mapping files.
	 */
	
	protected java.util.Set<String> typeMappingFiles = new java.util.LinkedHashSet<String>();
	
	/**
	 * the used ImportBeautifier
	 */
	protected ImportBeautifier importBeautifier;
	
	/**
	 * Variable for de-/activation of FileDeletionFeature
	 */
	protected boolean deleteOldFiles = true;
	
	/**
	 * Variable for de-/activation of FolderDeletionFeature
	 */
	protected boolean deleteEmptyFolders = true;
	
	/**
	 * Variable for de-/activation of ImportTakeOver
	 */
	protected boolean importTakeOver = true;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructs the workflow component, initializes the default values and creates an ImportBeautifier.
	 */
	public DefaultGenerator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1318595787020_121739_3751) ENABLED START */
		super();
		importBeautifier = new ImportBeautifier();
		WorkflowUtils.callPropertyAccessors(this, defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Called by the container after configuration so the component can validate the configuration before invocation.
	 * @see org.eclipse.xtend.XtendComponent#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	issues	
	 */
	
	protected void checkConfigurationInternal(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595797746_151764_3754) ENABLED START */
		if (importTakeOver) {
			if (this.importBeautifier.getOptions().getProperty("org.genesez.importformatter.regex", "").isEmpty()) {
				logger.error("No import string given, imports cannot be carried over.");
			}
			if (this.importBeautifier.getOptions().getProperty("org.genesez.importbeautifier.fileextensions", "").isEmpty()) {
				logger.warn("No file extensions given, every file will be checked for imports. Maybe imports will not be carried over correctly.");
			}
		} else {
			logger.info("Import take over deactivated.");
		}
		setupWorkflow();
		super.checkConfigurationInternal(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Called by the container at invocation.
	 * @see org.eclipse.xtend.XtendComponent#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 * org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 * org.eclipse.emf.mwe.core.issues.Issues)
	 * @param	ctx	
	 * @param	monitor	
	 * @param	issues	
	 */
	
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595813162_223951_3757) ENABLED START */
		// add exclude packages as global variables
		String packages = WorkflowUtils.arrayToString(excludedPackages);
		addGlobalVarDef("excludePackages", packages);
		String classifierPackages = WorkflowUtils.arrayToString(excludedContentPackages);
		addGlobalVarDef("excludeContentPackages", classifierPackages);
		// init type mapper
		TypeMapper.initTypeMapper(typeMappingFiles.toArray(new String[0]));
		
		super.invokeInternal2(ctx, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets up the pre- and post-lists with file and folder deletion. And adds the ImportBeautifier to postprocessor-list.
	 */
	
	private void setupWorkflow() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318576455179_884545_2580) ENABLED START */
		FileTreeWalkerFeature preftw = new FileTreeWalkerFeature();
		FileDeletionFeature fd = null;
		if (deleteOldFiles) {
			fd = new FileDeletionFeature();
			preftw.addObserver(fd);
		}
		if (importTakeOver) {
			preftw.addObserver(importBeautifier);
			super.addPostProcessor(importBeautifier);
		}
		super.addPreFeature(preftw);
		if (deleteOldFiles) {
			super.addPostFeature(fd);
		}
		if (deleteEmptyFolders) {
			FolderDeletionFeature fod = new FolderDeletionFeature();
			FileTreeWalkerFeature postftw = new FileTreeWalkerFeature();
			postftw.addObserver(fod);
			super.addPostFeature(postftw);
			super.addPostFeature(fod);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>excludePackages</b></em>.
	 * Adds several packages which will be excluded during code generation. The packages should be comma or semicolon separated.
	 * @param	excludePackages	Several packages to exclude.
	 */
	
	public void addExcludePackages(String excludePackages) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595861264_420835_3762) ENABLED START */
		if (excludePackages.length() > 0) {
			List<String> filtered = WorkflowUtils.split(excludePackages);
			for (String s : filtered) {
				addExcludePackage(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>excludePackage</b></em>.
	 * Adds a package which will be excluded during code generation.
	 * @param	excludePackage	A package to exclude.
	 */
	
	public void addExcludePackage(String excludePackage) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595892875_753918_3766) ENABLED START */
		if (excludePackage.length() > 0) {
			excludedPackages.add(excludePackage);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>basePackage</b></em>.
	 * Sets the name of the package which is added as base for all packages inside the model.
	 * @param	basePackage	The name of the base package.
	 */
	
	public void setBasePackage(String basePackage) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595908777_784969_3769) ENABLED START */
		addGlobalVarDef("basePackage", basePackage);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets file extensions for the ImportBeautifier.
	 * @param	extensions	file extensions separated by ("," or ";")
	 */
	
	public void setFileExtensions(String extensions) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317994965436_883197_2834) ENABLED START */
		this.importBeautifier.setFileExtensions(extensions);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>useModelNameAsBasePackage</b></em>.
	 * Sets if the name of the model should be used as package name which is added as base for all packages inside the model.
	 * @param	useModelNameAsBasePackage	True if the package name should be used, otherwise false.
	 */
	
	public void setUseModelNameAsBasePackage(String useModelNameAsBasePackage) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318596014121_626083_3776) ENABLED START */
		addGlobalVarDef("useModelNameAsBasePackage", Boolean.valueOf(useModelNameAsBasePackage));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>generateSectionComments</b></em>.
	 * Sets if section comments should be generated.
	 * @param	generateSectionComments	True if section comments should be generated, otherwise false.
	 */
	
	public void setGenerateSectionComments(String generateSectionComments) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318596066089_874321_3780) ENABLED START */
		addGlobalVarDef("generateSectionComments", Boolean.valueOf(generateSectionComments));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>accessorForSterotypes</b></em> .
	 * Sets the name of the accessor for sterotypes.
	 * @param	accessorForStereotypes	The name of the accessor.
	 */
	
	public void setAccessorForStereotypes(String accessorForStereotypes) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318596113332_943791_3784) ENABLED START */
		addGlobalVarDef("accessorsForStereotypes", accessorForStereotypes);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>accessorStereotype</b></em>.
	 * Sets the name of the accessor stereotype.
	 * @param	accessorStereotype	
	 */
	
	public void setAccessorStereotype(String accessorStereotype) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318596148018_128364_3787) ENABLED START */
		addGlobalVarDef("accessorStereotype", accessorStereotype);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Setter for the workflow parameter <em><b>usePropertyVisibilityForAccessors</b></em> .
	 * Sets if the visibility of the properties inside the model should be used for the visibility of the property accessors.
	 * @param	usePropertyVisibilityForAccessors	True if the visibility should be used, otherwise false.
	 */
	
	public void setUsePropertyVisibilityForAccessors(String usePropertyVisibilityForAccessors) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318596174295_860626_3790) ENABLED START */
		addGlobalVarDef("usePropertyVisibilityForAccessors", Boolean.valueOf(usePropertyVisibilityForAccessors));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>typeMappingFile</b></em>.
	 * Adds a type mapping file to map multi-valued, primitive and external types.
	 * @param	typeMappingFile	A type mapping file to use.
	 */
	
	public boolean addTypeMappingFile(String typeMappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317994891773_230537_2811) ENABLED START */
		Path path = Paths.get(typeMappingFile);
		if ((ClassLoader.getSystemResourceAsStream(typeMappingFile) != null) ||
				(path.isAbsolute() && Files.exists(path))) {
				typeMappingFiles.add(typeMappingFile);
				return true;
		} else {
			if(path.isAbsolute()){
				logger.warn(typeMappingFile + " does not exist!");
			} else {
				logger.warn(typeMappingFile + " could not be found in classpath!");
			}
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Adder for the workflow parameter <em><b>typeMappingFiles</b></em>.
	 * Adds several type mapping files to map multi-valued, primitive and external types. The type mapping files should be comma or semicolon separated.
	 * @param	typeMappingFiles	Several type mapping files to use.
	 */
	
	public void addTypeMappingFiles(String typeMappingFiles) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595969767_908115_3772) ENABLED START */
		if (typeMappingFiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(typeMappingFiles);
			for (String s : filtered) {
				addTypeMappingFile(s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Compiles given string into a regular expression pattern to indicate imports. Only for convenience.
	 * 
	 * @see org.genesez.platform.common.m2t.ImportBeautifier#setImportStrings(String)
	 * @param	importStrings	import strings (separated by "," or ";")
	 */
	
	public void setImportStrings(String importStrings) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318595751560_430872_3748) ENABLED START */
		this.importBeautifier.setImportStrings(importStrings);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets regular expression to indicate imports. NOTE: Be sure to use appropriate regular expression syntax.
	 * 
	 * @see java.util.regex.Pattern for more information.
	 * @see org.genesez.platform.common.m2t.ImportBeautifier#setImportRegex(String)
	 * @param	regex	the import regular expression.
	 */
	
	public void setImportRegex(String regex) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317994985092_589937_2837) ENABLED START */
		this.importBeautifier.setImportRegex(regex);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Variable for de-/activation of FileDeletionFeature
	 */
	public void setDeleteOldFiles(boolean deleteOldFiles) {
		this.deleteOldFiles = deleteOldFiles;
	}
	
	/**
	 * Variable for de-/activation of FolderDeletionFeature
	 */
	public void setDeleteEmptyFolders(boolean deleteEmptyFolders) {
		this.deleteEmptyFolders = deleteEmptyFolders;
	}
	
	/**
	 * Variable for de-/activation of ImportTakeOver
	 */
	public void setImportTakeOver(boolean importTakeOver) {
		this.importTakeOver = importTakeOver;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317994867406_376688_2793) ENABLED START */
	static {
		defaults.setProperty("excludePackages", "");
		defaults.setProperty("basePackage", "");
		defaults.setProperty("useModelNameAsBasePackage", "false");
		defaults.setProperty("generateSectionComments", "true");
		defaults.setProperty("accessorForStereotypes", "entity");
		defaults.setProperty("accessorStereotype", "accessor");
		defaults.setProperty("usePropertyVisibilityForAccessors", "false");
		defaults.setProperty("deleteOldFiles", "true");
		defaults.setProperty("deleteEmptyFolders", "true");
		defaults.setProperty("importTakeOver", "true");
	}
	
	protected java.util.Set<String> excludedContentPackages = new java.util.HashSet<String>();
	public void addExcludeContentPackage(String excludeContentPackage) {
		excludedContentPackages.add(excludeContentPackage);
	}
	/* PROTECTED REGION END */
	
}
