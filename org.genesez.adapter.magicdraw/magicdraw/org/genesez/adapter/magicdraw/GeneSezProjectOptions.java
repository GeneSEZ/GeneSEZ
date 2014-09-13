package org.genesez.adapter.magicdraw;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.core.options.ProjectOptions;
import com.nomagic.magicdraw.core.options.ProjectOptionsConfigurator;
import com.nomagic.magicdraw.properties.FileProperty;
import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyResourceProvider;

/**
 * Provides access to the general project options.
 * 
 * @author tobias haubold <tobias.haubold@fh-zwickau.de> (maintainer)
 */
public class GeneSezProjectOptions {
	
	static final String MENU_GROUP = "GeneSEZ Integration";
	static final String ECLIPSE_HOME_DIR = "org.genesez.adapter.magicdraw.eclipseHomeDir";
	static final String WORKFLOW_FILE = "org.genesez.adapter.magicdraw.workflowFile";
	static final String ANT_BUILD_FILE = "org.genesez.adapter.magicdraw.antBuildFile";
	
	Property eclipseHomeDir;
	Property workflowFile;
	Property antBuildFile;
	
	
	/**
	 * Creates the general project option menu entries.
	 */
	public GeneSezProjectOptions() {
		PropertyResourceProvider prp = buildPropertyResourceProvider();
		
		eclipseHomeDir = new FileProperty(ECLIPSE_HOME_DIR, null, FileProperty.DIRECTORIES_ONLY);
		eclipseHomeDir.setGroup(MENU_GROUP);
		eclipseHomeDir.setResourceProvider(prp);
		
		workflowFile = new FileProperty(WORKFLOW_FILE, null, FileProperty.FILES_ONLY);
		workflowFile.setGroup(MENU_GROUP);
		workflowFile.setResourceProvider(prp);
		
		antBuildFile = new FileProperty(ANT_BUILD_FILE, null, FileProperty.FILES_ONLY);
		antBuildFile.setGroup(MENU_GROUP);
		antBuildFile.setResourceProvider(prp);
		
		ProjectOptions.addConfigurator(new ProjectOptionsConfigurator() {
			
			public void configure(ProjectOptions options) {
				options.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, eclipseHomeDir);
				options.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, workflowFile);
				options.addProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, antBuildFile);
			}
			
			public void afterLoad(ProjectOptions options) {
				// don't know what to do here...
			}
		});
	}
	
	public boolean isEclipseHomeDirSet() {
		return isPropertySet(ECLIPSE_HOME_DIR);
	}
	
	public String getEclipseHomeDir() {
		return getPropertyValue(ECLIPSE_HOME_DIR);
	}
	
	public boolean isWorkflowFileSet() {
		return isPropertySet(WORKFLOW_FILE);
	}
	
	public String getWorkflowFile() {
		return getPropertyValue(WORKFLOW_FILE);
	}
	
	public boolean isAntBuildFileSet() {
		return isPropertySet(ANT_BUILD_FILE);
	}
	
	public String getAntBuildFile() {
		return getPropertyValue(ANT_BUILD_FILE);
	}
	
	
	boolean isPropertySet(String id) {
		Property p = getProperty(id);
		return isProjectAvailable() && p != null && p.getValue() != null;
	}
	
	String getPropertyValue(String id) {
		if (!isPropertySet(id)) {
			return null;
		}
		return getProperty(id).getValueStringRepresentation();
	}
	
	Property getProperty(String id) {
		if (!isProjectAvailable()) {
			return null;
		}
		return Application.getInstance().getProject().getOptions().getProperty(ProjectOptions.PROJECT_GENERAL_PROPERTIES, id);
	}
	
	boolean isProjectAvailable() {
		return Application.getInstance().getProject() != null;
	}
	
	/**
	 * Returns the property resource provider for GeneSEZ menu entries.
	 */
	PropertyResourceProvider buildPropertyResourceProvider() {
		return new PropertyResourceProvider() {
			
			public String getString(String key, Property property) {
				if (MENU_GROUP.equals(key)) {
					return "GeneSEZ Integration";
				}
				if (ECLIPSE_HOME_DIR.equals(key)) {
					return "Eclipse home directory";
				}
				if ((ECLIPSE_HOME_DIR + "_DESCRIPTION").equals(key)) {
					return "The directory where eclipse.ini is located.";
				}
				if (WORKFLOW_FILE.equals(key)) {
					return "Workflow file";
				}
				if ((WORKFLOW_FILE + "_DESCRIPTION").equals(key)) {
					return "The workflow file describing the transformation for your model.";
				}
				if (ANT_BUILD_FILE.equals(key)) {
					return "Ant build file";
				}
				if ((ANT_BUILD_FILE + "_DESCRIPTION").equals(key)) {
					return "The ant build file used to execute GeneSEZ transformations headless (usually frontend.xml located in " +
							"ant folder of org.genesez.headless eclipse plugin or a project specific headless.xml located in the GeneSEZ generator project).";
				}
				return key;
			}
		};
	}
}
