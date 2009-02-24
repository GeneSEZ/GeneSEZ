package de.genesez.platforms.php.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.issues.Issues;

import de.genesez.platforms.common.workflow.Generator;
import de.genesez.platforms.common.workflow.WorkflowUtils;

/**
 * Performs source code generation for the PHP platform
 * @author Aibek Isaev
 */
public class PhpGenerator extends Generator {
	
	/**
	 * default values in case the property file is not found
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "de::genesez::platforms::php5::templates::Root::Root");
		defaults.put("typeMappingFile", "de/genesez/platforms/php/typemapping/typemapping.xml");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	
	
	/**
	 * constructs the workflow component and initializes the default values for the parameter
	 */
	public PhpGenerator() {
		super();
		properties.putAll(defaults);
		WorkflowUtils.loadAllProperties(properties, logger, getClass());
	}
	
	
	/**
	 * checks configuration of the workflow component and sets configured default values
	 * 
	 * @see Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		if (isNotSetTemplate) super.setTemplate(properties.getProperty("template"));
		if (isNotAddTypeMappingFile) super.addTypeMappingFile(properties.getProperty("typeMappingFile"));
		super.checkConfigurationInternal(issues);
	}
	
	/**
	 * setter for the workflow parameter <em><b>template</b></em>
	 * 
	 * @see Generator#setTemplate(java.lang.String)
	 */
	public void setTemplate(String template) {
		super.setTemplate(template);
		isNotSetTemplate = false;
	}
	
	/**
	 * setter for the workflow parameter <em><b>type mapping file</b></em>
	 * 
	 * @param typeMappingFile	location of the type mapping file in the classpath
	 */
	public void addTypeMappingFile(String typeMappingFile) {
		super.addTypeMappingFile(typeMappingFile);
		isNotAddTypeMappingFile=false;
	}
}
