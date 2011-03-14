package de.genesez.platforms.java.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xpand2.output.JavaBeautifier;

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
		defaults.put("newAssociationHandling", "true");
		defaults.put("fieldAccess", "true");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	private boolean newAssociationHandling = true;
	private boolean fieldAccess = true;
	

	public JavaGenerator() {
		super();
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
		// check parameters
		if (isNotSetTemplate) super.setTemplate(properties.getProperty("template"));
		if (isNotAddTypeMappingFile) super.addTypeMappingFile(properties.getProperty("typeMappingFile"));
		if (newAssociationHandling) setNewAssociationHandling(Boolean.valueOf(properties.getProperty("newAssociationHandling")).booleanValue());
		if (fieldAccess) setFieldAccess(Boolean.valueOf(properties.getProperty("fieldAccess")).booleanValue());
		
		configureBeautifiers();
		super.checkConfigurationInternal(issues);
	}
	
	protected void configureBeautifiers() {
		// java beautifier
		JavaBeautifier javaBeautifier = new JavaBeautifier();
		javaBeautifier.setConfigFile(properties.getProperty("formatterConfig"));
		
		JavaImportBeautifier javaImportBeautifier = new JavaImportBeautifier();
		
		// add all beautifiers
		List<Object> beautifiers = new ArrayList<Object>();
		beautifiers.add(javaBeautifier);
		beautifiers.add(javaImportBeautifier);
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
	
	public void setNewAssociationHandling(boolean newAssociationHandling) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("newAssociationHandling", "" + newAssociationHandling + ""));
		this.newAssociationHandling = false;
	}

	public void setFieldAccess(boolean fieldAccess) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("fieldAccess", "" + fieldAccess + ""));
		this.fieldAccess = false;
	}
}
