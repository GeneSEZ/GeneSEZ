package org.genesez.platform.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1326709010962_484208_2721) 
 */

import org.genesez.platform.common.workflow.DefaultGenerator;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.apache.commons.logging.LogFactory;
import org.genesez.platform.common.workflow.WorkflowUtils;
import org.apache.commons.logging.Log;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.eclipse.emf.mwe.core.issues.Issues;

/**
 * Performs model to text transformations for the Java platform
 * @author Aibek Isaev
 * @author Dominik Wetzel
 * @date 2011-10-12
 */
public class JavaGenerator extends DefaultGenerator {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * The regular expression for the import statements.
	 */
	private static final String IMPORT_REGEX = "import .*;$";
	
	/**
	 * The constant for the fileExtensions.
	 */
	private static final String FILE_EXTENSIONS = ".java";;
	
	private static Properties defaults = new Properties();
	
	private Log logger = LogFactory.getLog(getClass());
	
	private boolean isNotAddTypeMappingFile = true;
	
	private JavaBeautifier javaBeautifier;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>JavaGenerator</b></em>'.
	 */
	public JavaGenerator() {
		/* PROTECTED REGION ID(java.constructor._17_0_1_8e00291_1326709010970_194991_2722) ENABLED START */
		super();
		configureBeautifiers();
		properties.putAll(defaults);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Overridden for checking all parameters. If parameter's value is null, then set default value.
	 * @see Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 * @param	issues	
	 */
	
	protected void checkConfigurationInternal(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010973_2130_2723) ENABLED START */
		// check typemappingfile
		if (isNotAddTypeMappingFile)
			issues.addWarning(this, "No typemapping file given/found. Default will be used.");
			super.addTypeMappingFile(properties.getProperty("typeMappingFile"));
		
		// set fieldAccess
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("fieldAccess", properties.getProperty("fieldAccess")));
		// set newAssociationHandling
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("newAssociationHandling", properties.getProperty("newAssociationHandling")));
		
		javaBeautifier.setConfigFile(properties.getProperty("formatterConfig"));
		super.checkConfigurationInternal(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Configures the JavaBeautifier and the ImportBeautifier
	 */
	
	protected void configureBeautifiers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010976_407934_2724) ENABLED START */
		// java beautifier
		javaBeautifier = new JavaBeautifier();
		super.addPostProcessor(javaBeautifier);
		
		// configure ImportBeautifier
		super.setFileExtensions(FILE_EXTENSIONS);
		super.setImportRegex(IMPORT_REGEX);
		/* PROTECTED REGION END */
	}
	
	/**
	 * setter for the type mapping file.
	 * @param	typeMappingFile	name of the file used by the generator for type mapping.
	 */
	
	public boolean addTypeMappingFile(String typeMappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010982_274549_2726) ENABLED START */
		if(super.addTypeMappingFile(typeMappingFile)){
			isNotAddTypeMappingFile = false;
			return true;
		}
		return false;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	formatterConfig	
	 */
	
	public void setFormatterConfig(String formatterConfig) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010984_612104_2727) ENABLED START */
		properties.setProperty("formatterConfig", formatterConfig);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	newAssociationHandling	
	 */
	
	public void setNewAssociationHandling(boolean newAssociationHandling) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010985_759928_2728) ENABLED START */
		properties.setProperty("newAssociationHandling", String.valueOf(newAssociationHandling));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	fieldAccess	
	 */
	
	public void setFieldAccess(boolean fieldAccess) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010987_391859_2729) ENABLED START */
		properties.setProperty("fieldAccess", String.valueOf(fieldAccess));
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1326709010962_484208_2721) ENABLED START */
	static {
		defaults.put("template", "org::genesez::platform::java::java5::templates::Root::Root");
		defaults.put("typeMappingFile", "org/genesez/platform/java/typemapping/typemapping.xml");
		defaults.put("formatterConfig", "org/genesez/platform/java/workflow/eclipse.java.formatter.settings.xml");
		defaults.put("newAssociationHandling", "true");
		defaults.put("fieldAccess", "true");
	}
	/* PROTECTED REGION END */
	
}
