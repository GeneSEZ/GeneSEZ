package de.genesez.platforms.common.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import de.genesez.platforms.common.m2t.ImportBeautifier;
import de.genesez.platforms.common.typemapping.TypeMapper;
import de.genesez.platforms.common.workflow.feature.FileDeletionFeature;
import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature;
import de.genesez.platforms.common.workflow.feature.FolderDeletionFeature;

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

	/**
	 * Default values in case the property file is not found.
	 */
	private static Properties defaults = new Properties();
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
	}

	/**
	 * Variable to store all exclude packages.
	 */
	protected List<String> excludePackages = new ArrayList<String>();

	/**
	 * Variable to store all type mapping files.
	 */
	protected List<String> typeMappingFiles = new ArrayList<String>();

	/**
	 * Variable for FileDeletionFeature
	 */
	protected boolean deleteOldFiles = true;

	/**
	 * Variable for FolderDeletionFeature
	 */
	protected boolean deleteEmptyFolders = true;

	/**
	 * the used importBeautifier
	 */
	protected ImportBeautifier importBeautifier;

	/**
	 * Constructs the workflow component and initializes the default values.
	 */
	public DefaultGenerator() {
		super();
		importBeautifier = new ImportBeautifier();
		WorkflowUtils.callPropertyAccessors(this, defaults);
	}

	/**
	 * Called by the container after configuration so the component can validate
	 * the configuration before invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#checkConfigurationInternal(org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (this.importBeautifier.getOptions()
				.getProperty("de.genesez.importformatter.regex", "").isEmpty()) {
			logger.error("No import string given, imports cannot be carried over.");
		}
		if (this.importBeautifier.getOptions()
				.getProperty("de.genesez.importbeautifier.fileextensions", "")
				.isEmpty()) {
			logger.warn("No file extensions given, every file will be checked for imports. Maybe imports will not be carried over.");
		}
		setupWorkflow();
		super.checkConfigurationInternal(issues);
	}

	/**
	 * Called by the container at invocation.
	 * 
	 * @see org.eclipse.xtend.XtendComponent#invokeInternal2(org.eclipse.emf.mwe.core.WorkflowContext,
	 *      org.eclipse.emf.mwe.core.monitor.ProgressMonitor,
	 *      org.eclipse.emf.mwe.core.issues.Issues)
	 */
	@Override
	protected void invokeInternal2(WorkflowContext ctx,
			ProgressMonitor monitor, Issues issues) {
		// add exclude packages as global variables
		String packages = WorkflowUtils.arrayToString(excludePackages);
		addGlobalVarDef("excludePackages", packages);

		// init type mapper
		TypeMapper.initTypeMapper(typeMappingFiles.toArray(new String[0]));

		super.invokeInternal2(ctx, monitor, issues);
	}

	// BEGIN OF DEFAULTS

	/**
	 * Adder for the workflow parameter <em><b>excludePackage</b></em>.
	 * 
	 * Adds a package which will be excluded during code generation.
	 * 
	 * @param excludePackage
	 *            A package to exclude.
	 */
	public void addExcludePackage(String excludePackage) {
		if (excludePackage.length() > 0) {
			excludePackages.add(excludePackage);
		}
	}

	/**
	 * Adder for the workflow parameter <em><b>excludePackages</b></em>.
	 * 
	 * Adds several packages which will be excluded during code generation. The
	 * packages should be comma or semicolon separated.
	 * 
	 * @param excludePackages
	 *            Several packages to exclude.
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
	 * Setter for the workflow parameter <em><b>basePackage</b></em>.
	 * 
	 * Sets the name of the package which is added as base for all packages
	 * inside the model.
	 * 
	 * @param basePackage
	 *            The name of the base package.
	 */
	public void setBasePackage(String basePackage) {
		addGlobalVarDef("basePackage", basePackage);
	}

	/**
	 * Setter for the workflow parameter
	 * <em><b>useModelNameAsBasePackage</b></em>.
	 * 
	 * Sets if the name of the model should be used as package name which is
	 * added as base for all packages inside the model.
	 * 
	 * @param useModelNameAsBasePackage
	 *            True if the package name should be used, otherwise false.
	 */
	public void setUseModelNameAsBasePackage(String useModelNameAsBasePackage) {
		addGlobalVarDef("useModelNameAsBasePackage",
				Boolean.valueOf(useModelNameAsBasePackage));
	}

	/**
	 * setter for GenerateSectionComments parameter, which in GlobalVarDef add.
	 */

	/**
	 * Setter for the workflow parameter <em><b>generateSectionComments</b></em>
	 * .
	 * 
	 * Sets if section comments should be generated.
	 * 
	 * @param generateSectionComments
	 *            True if section comments should be generated, otherwise false.
	 */
	public void setGenerateSectionComments(String generateSectionComments) {
		addGlobalVarDef("generateSectionComments",
				Boolean.valueOf(generateSectionComments));
	}

	/**
	 * Setter for the workflow parameter <em><b>accessorForSterotypes</b></em> .
	 * 
	 * Sets the name of the accessor for sterotypes.
	 * 
	 * @param accessorForSterotypes
	 *            The name of the accessor.
	 */
	public void setAccessorForStereotypes(String accessorForSterotypes) {
		addGlobalVarDef("accessorsForStereotypes", accessorForSterotypes);
	}

	/**
	 * Setter for the workflow parameter <em><b>accessorStereotype</b></em> .
	 * 
	 * Sets the name of the accessor stereotype.
	 * 
	 * @param accessorStereotype
	 *            The name of the accessor.
	 */
	public void setAccessorStereotype(String accessorStereotype) {
		addGlobalVarDef("accessorStereotype", accessorStereotype);
	}

	/**
	 * setter for UsePropertyVisibilityForAccessors parameter, which in
	 * GlobalVarDef add.
	 */

	/**
	 * Setter for the workflow parameter
	 * <em><b>usePropertyVisibilityForAccessors</b></em> .
	 * 
	 * Sets if the visibility of the properties inside the model should be used
	 * for the visibility of the property accessors.
	 * 
	 * @param usePropertyVisibilityForAccessors
	 *            True if the visibility should be used, otherwise false.
	 */
	public void setUsePropertyVisibilityForAccessors(
			String usePropertyVisibilityForAccessors) {
		addGlobalVarDef("usePropertyVisibilityForAccessors",
				Boolean.valueOf(usePropertyVisibilityForAccessors));
	}

	// END OF DEFAULTS

	/**
	 * Adder for the workflow parameter <em><b>typeMappingFile</b></em>.
	 * 
	 * Adds a type mapping file to map multi-valued, primitive and external
	 * types.
	 * 
	 * @param typeMappingFile
	 *            A type mapping file to use.
	 */
	public void addTypeMappingFile(final String typeMappingFile) {
		typeMappingFiles.add(typeMappingFile);
	}

	/**
	 * Adder for the workflow parameter <em><b>typeMappingFiles</b></em>.
	 * 
	 * Adds several type mapping files to map multi-valued, primitive and
	 * external types. The type mapping files should be comma or semicolon
	 * separated.
	 * 
	 * @param typeMappingFiles
	 *            Several type mapping files to use.
	 */
	public void addTypeMappingFiles(final String typeMappingFiles) {
		if (typeMappingFiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(typeMappingFiles);
			for (String s : filtered) {
				addTypeMappingFile(s);
			}
		}
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteOld</b></em>.
	 * 
	 * Sets if old files should be deleted or not
	 * 
	 * @param deleteOld
	 *            Value of deleteOld True if it should be deleted.
	 */
	public void setDeleteOldFiles(String deleteOld) {
		properties.setProperty("deleteOldFiles", deleteOld);
		deleteOldFiles = Boolean.parseBoolean(deleteOld);
	}

	/**
	 * Setter for the workflow parameter <em><b>deleteEmptyFolders</b></em>.
	 * 
	 * if this is true, empty folders will be deleted after generation process
	 * 
	 * @param deleteEmpty
	 */
	public void setDeleteEmptyFolders(String deleteEmpty) {
		properties.setProperty("deleteEmptyFolders", deleteEmpty);
		deleteEmptyFolders = Boolean.parseBoolean(deleteEmpty);
	}

	/**
	 * Sets file extensions for the ImportBeautifier
	 * 
	 * @param extensions
	 *            file extensions separated by ("," or ";")
	 */
	public void setFileExtensions(String extensions) {
		this.importBeautifier.setFileExtensions(extensions);
	}

	/**
	 * Sets regular expression to indicate imports. NOTE: Be sure to use
	 * appropriate regular expression syntax.
	 * 
	 * @see java.util.regex.Pattern for more information.
	 * @see de.genesez.platforms.common.m2t.ImportBeautifier#setImportRegex(String)
	 * @param regex
	 *            the import regular expressions.
	 */
	public void setImportRegex(String regex) {
		this.importBeautifier.setImportRegex(regex);
	}

	/**
	 * Compiles given string into a regular expression pattern to indicate
	 * imports. Only for convenience.
	 * 
	 * @see de.genesez.platforms.common.m2t.ImportBeautifier#setImportStrings(String)
	 * @param importStrings
	 *            import strings (separated by "," or ";")
	 */
	public void setImportStrings(String importStrings) {
		this.importBeautifier.setImportStrings(importStrings);
	}

	/**
	 * Sets up the pre- and post-lists with file and folder deletion.
	 */
	protected void setupWorkflow() {
		FileTreeWalkerFeature preftw = new FileTreeWalkerFeature();
		FileDeletionFeature fd = null;
		if (deleteOldFiles) {
			fd = new FileDeletionFeature();
			preftw.addObserver(fd);
		}
		preftw.addObserver(importBeautifier);
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
		super.addPostProcessor(importBeautifier);
	}
}
