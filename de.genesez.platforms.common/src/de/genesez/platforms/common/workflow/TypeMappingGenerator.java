package de.genesez.platforms.common.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import de.genesez.platforms.common.typemapping.TypeMapper;

/**
 * Workflow component class to generate code (model to text transformation).
 * 
 * @author Aibek Isaev
 * @author Beishen
 * @author Tobias Haubold
 * @author Nico Herbig <nico.herbig@fh-zwickau.de>
 * @date 2011-08-23
 */
public class TypeMappingGenerator extends Generator {

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
	 * Constructs the workflow component and initializes the default values.
	 */
	public TypeMappingGenerator() {
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
	protected void checkConfigurationInternal(Issues issues) {
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
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
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
	 * @param excludePackage A package to exclude.
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
	 * @param excludePackages Several packages to exclude.
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
	 * @param basePackage The name of the base package.
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
	 * @param useModelNameAsBasePackage True if the package name should be used,
	 *            otherwise false.
	 */
	public void setUseModelNameAsBasePackage(String useModelNameAsBasePackage) {
		addGlobalVarDef("useModelNameAsBasePackage", Boolean.valueOf(useModelNameAsBasePackage));
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
	 * @param generateSectionComments True if section comments should be
	 *            generated, otherwise false.
	 */
	public void setGenerateSectionComments(String generateSectionComments) {
		addGlobalVarDef("generateSectionComments", Boolean.valueOf(generateSectionComments));
	}

	/**
	 * Setter for the workflow parameter <em><b>accessorForSterotypes</b></em> .
	 * 
	 * Sets the name of the accessor for sterotypes.
	 * 
	 * @param accessorForSterotypes The name of the accessor.
	 */
	public void setAccessorForStereotypes(String accessorForSterotypes) {
		addGlobalVarDef("accessorsForStereotypes", accessorForSterotypes);
	}

	/**
	 * Setter for the workflow parameter <em><b>accessorStereotype</b></em> .
	 * 
	 * Sets the name of the accessor stereotype.
	 * 
	 * @param accessorStereotype The name of the accessor.
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
	 * @param usePropertyVisibilityForAccessors True if the visibility should be
	 *            used, otherwise false.
	 */
	public void setUsePropertyVisibilityForAccessors(String usePropertyVisibilityForAccessors) {
		addGlobalVarDef("usePropertyVisibilityForAccessors", Boolean.valueOf(usePropertyVisibilityForAccessors));
	}

	// END OF DEFAULTS

	/**
	 * Adder for the workflow parameter <em><b>typeMappingFile</b></em>.
	 * 
	 * Adds a type mapping file to map multi-valued, primitive and external
	 * types.
	 * 
	 * @param typeMappingFile A type mapping file to use.
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
	 * @param typeMappingFiles Several type mapping files to use.
	 */
	public void addTypeMappingFiles(final String typeMappingFiles) {
		if (typeMappingFiles.length() > 0) {
			List<String> filtered = WorkflowUtils.split(typeMappingFiles);
			for (String s : filtered) {
				addTypeMappingFile(s);
			}
		}
	}

}
