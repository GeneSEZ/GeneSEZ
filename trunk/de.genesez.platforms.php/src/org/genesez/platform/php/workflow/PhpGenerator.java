package org.genesez.platform.php.workflow;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.genesez.platform.common.workflow.DefaultGenerator;
import org.genesez.platform.common.workflow.WorkflowUtils;

/**
 * Performs source code generation for the PHP platform
 * @author Aibek Isaev
 */
public class PhpGenerator extends DefaultGenerator {
	
	/**
	 * default values in case the property file is not found
	 */
	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "org::genesez::platform::php5::templates::Root::Root");
		defaults.put("typeMappingFile", "org/genesez/platform/php/typemapping/typemapping.xml");
		defaults.put("generateIncludes", "true");
		defaults.put("relativeIncludes", "false");
		defaults.put("includeBase", "");
		defaults.put("propertyAccess", "setter");
		defaults.put("accessorStyle", "magic");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	private boolean isNotSetTemplate = true;
	private boolean isNotAddTypeMappingFile = true;
	private boolean isNotSetGenerateIncludes = true;
	private boolean isNotSetRelativeIncludes = true;
	private boolean isNotSetIncludeBase = true;
	private boolean isNotSetPropertyAccess = true;
	private boolean isNotSetAccessorStyle = true;
	
	
	/**
	 * constructs the workflow component and initializes the default values for the parameter
	 */
	public PhpGenerator() {
		super();
		properties.putAll(defaults);
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
		if (isNotSetGenerateIncludes) setGenerateIncludes(new Boolean(properties.getProperty("generateIncludes")));
		if (isNotSetRelativeIncludes) setRelativeIncludes(new Boolean(properties.getProperty("relativeIncludes")));
		if (isNotSetIncludeBase) setIncludeBase(properties.getProperty("includeBase"));
		if (isNotSetPropertyAccess) setPropertyAccess(properties.getProperty("propertyAccess"));
		if (isNotSetAccessorStyle) setAccessorStyle(properties.getProperty("accessorStyle"));
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
	
	public void setGenerateIncludes(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("generateIncludes", value));
		isNotSetGenerateIncludes = false;
	}
	public void setRelativeIncludes(boolean value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("relativeIncludes", value));
		isNotSetRelativeIncludes = false;
	}
	public void setIncludeBase(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("includeBase", "'" + value + "'"));
		isNotSetIncludeBase = false;
	}
	public void setPropertyAccess(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("propertyAccess", "'" + value + "'"));
		isNotSetPropertyAccess = false;
	}
	public void setAccessorStyle(String value) {
		super.addGlobalVarDef(WorkflowUtils.createGlobalVarDef("accessorStyle", "'" + value + "'"));
		isNotSetAccessorStyle = false;
	}
}
