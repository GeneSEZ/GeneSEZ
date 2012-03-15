package org.genesez.platform.dotnet.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.platform.common.workflow.DefaultGenerator;

/**
 * Performs model to text transformations for the .net platform and C#.
 * @author Aibek Isaev
 */
public class CSharpGenerator extends DefaultGenerator {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "org::genesez::platform::dotnet::csharp::templates::Root::Root");
		defaults.put("typeMappingFile", "org/genesez/platform/dotnet/csharp/typemapping/typemapping.xml");
	}
	private static final String IMPORT_REGEX = "using .*;$";
	
	/**
	 * The constant for the fileExtensions.
	 */
	private static final String FILE_EXTENSIONS = ".cs";
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	
	
	public CSharpGenerator() {
		super();
		super.setFileExtensions(FILE_EXTENSIONS);
		super.setImportRegex(IMPORT_REGEX);
		properties.putAll(defaults);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (isNotSetTemplate) {
			super.setTemplate(this.properties.getProperty("template"));
		}
		if (isNotAddTypeMappingFile) {
			super.addTypeMappingFile(this.properties.getProperty("typeMappingFile"));
		}
		super.checkConfigurationInternal(issues);
	}
	
	/**
	 * setter for Template parameter in super class
	 * 
	 * @see Generator#setTemplate(java.lang.String)
	 */
	public void setTemplate(String template) {
		super.setTemplate(template);
		isNotSetTemplate = false;
	}
	
	/**
	 * setter for the type mapping file
	 * 
	 * @param typeMappingFile
	 *            name of the file used by the generator for type mapping
	 */
	public void addTypeMappingFile(String typeMappingFile) {
		super.addTypeMappingFile(typeMappingFile);
		isNotAddTypeMappingFile = false;
	}
}
