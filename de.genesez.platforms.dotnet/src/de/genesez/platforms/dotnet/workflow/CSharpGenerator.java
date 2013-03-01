package de.genesez.platforms.dotnet.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.issues.Issues;

import de.genesez.platforms.common.workflow.Generator;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Performs model to text transformations for the .net platform and C#.
 * @author Aibek Isaev
 */
public class CSharpGenerator extends Generator {
	
	private static final Properties defaults = new Properties();
	static {
		CSharpGenerator.defaults.put("template", "de::genesez::platforms::dotnet::csharp::templates::Root::Root");
		CSharpGenerator.defaults.put("typeMappingFile", "de/genesez/platforms/dotnet/csharp/typemapping/typemapping.xml");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	
	
	public CSharpGenerator() {
		super();
		this.properties.putAll(CSharpGenerator.defaults);
		WorkflowUtils.loadAllProperties(this.properties, this.logger, this.getClass());
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (this.isNotSetTemplate) {
			super.setTemplate(this.properties.getProperty("template"));
		}
		if (this.isNotAddTypeMappingFile) {
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
		this.isNotSetTemplate = false;
	}
	
	/**
	 * setter for the type mapping file
	 * 
	 * @param typeMappingFile
	 *            name of the file used by the generator for type mapping
	 */
	public void addTypeMappingFile(String typeMappingFile) {
		super.addTypeMappingFile(typeMappingFile);
		this.isNotAddTypeMappingFile = false;
	}
}
