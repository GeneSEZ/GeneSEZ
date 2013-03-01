package de.genesez.platforms.java.workflow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.xpand2.output.JavaBeautifier;
import org.openarchitectureware.xpand2.output.XmlBeautifier;

import de.genesez.platforms.common.workflow.Generator;
import de.genesez.platforms.common.workflow.WorkflowUtils;
import de.genesez.platforms.java.m2t.JavaImportBeautifier;

/**
 * Performs model to text transformations for the Java platform
 * @author Aibek Isaev
 */
public class JavaGenerator extends Generator {
	
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "de::genesez::platforms::java::java5::templates::Root::Root");
		defaults.put("typeMappingFile", "de/genesez/platforms/java/typemapping/typemapping.xml");
		defaults.put("formatterConfig", "de/genesez/platforms/java/workflow/eclipse.java.formatter.settings.xml");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	
	
	public JavaGenerator() {
		super();
		properties.putAll(defaults);
		WorkflowUtils.loadAllProperties(properties, logger, JavaGenerator.class);
	}
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {
		// check parameters
		if (isNotSetTemplate) super.setTemplate(properties.getProperty("template"));
		if (isNotAddTypeMappingFile) super.addTypeMappingFile(properties.getProperty("typeMappingFile"));
		
		configureBeautifiers();
		super.checkConfigurationInternal(issues);
	}
	
	protected void configureBeautifiers() {
		// java beautifier
		JavaBeautifier javaBeautifier = new JavaBeautifier();
		javaBeautifier.setConfigFile(properties.getProperty("formatterConfig"));
		
		JavaImportBeautifier javaImportBeautifier = new JavaImportBeautifier();
		
		XmlBeautifier xmlBeautifier = new XmlBeautifier();
		
		// add all beautifiers
		List<Object> beautifiers = new ArrayList<Object>();
		beautifiers.add(javaBeautifier);
		beautifiers.add(javaImportBeautifier);
		beautifiers.add(xmlBeautifier);
		super.setBeautifier(beautifiers);
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
	
	public void setFormatterConfig(String formatterConfigFile) {
		properties.put("formatterConfig", formatterConfigFile);
	}
}
