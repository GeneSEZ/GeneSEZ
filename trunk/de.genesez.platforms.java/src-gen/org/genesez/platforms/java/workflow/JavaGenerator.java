package org.genesez.platforms.java.workflow;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1326709010962_484208_2721) 
 */

import org.genesez.platforms.common.workflow.DefaultGenerator;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.apache.commons.logging.Log;
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
		// TODO: implementation of constructor for class 'JavaGenerator'
		throw new UnsupportedOperationException("The implementation of this generated constructor is missing!");
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
		// TODO: implementation of method 'JavaGenerator.checkConfigurationInternal(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Configures the JavaBeautifier and the ImportBeautifier
	 */
	
	protected void configureBeautifiers() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010976_407934_2724) ENABLED START */
		// TODO: implementation of method 'JavaGenerator.configureBeautifiers(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * setter for the type mapping file.
	 * @param	typeMappingFile	name of the file used by the generator for type mapping.
	 */
	
	public void addTypeMappingFile(String typeMappingFile) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010982_274549_2726) ENABLED START */
		// TODO: implementation of method 'JavaGenerator.addTypeMappingFile(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	formatterConfig	
	 */
	
	public void setFormatterConfig(String formatterConfig) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010984_612104_2727) ENABLED START */
		// TODO: implementation of method 'JavaGenerator.setFormatterConfig(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	newAssociationHandling	
	 */
	
	public void setNewAssociationHandling(boolean newAssociationHandling) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010985_759928_2728) ENABLED START */
		// TODO: implementation of method 'JavaGenerator.setNewAssociationHandling(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	fieldAccess	
	 */
	
	public void setFieldAccess(boolean fieldAccess) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1326709010987_391859_2729) ENABLED START */
		// TODO: implementation of method 'JavaGenerator.setFieldAccess(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1326709010962_484208_2721) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
