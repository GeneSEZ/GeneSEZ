package de.genesez.platforms.common.workflow;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.eclipse.xtend.type.impl.java.JavaMetaModel;

import de.genesez.platforms.common.statistic.CommentSign;
import de.genesez.platforms.common.statistic.SProject;

/**
 * Workflow component for generating statistics about the source code of an application.
 * 
 * @author tommy hartmann ( tomha@fh-zwickau.de )
 * @author toh
 */
public class Statistics extends Generator {

	private static final Properties defaults = new Properties();
	static {
		defaults.put("template", "de::genesez::platforms::common::statistic::Root::Root");
		defaults.put("slot", "statisticModel");
		defaults.put("name", "Statistic");
		defaults.put("withDate", "false");
		defaults.put("excludes", ".svn, .cvs");
	}
	
	private Log logger = LogFactory.getLog(getClass());
	
	private Set<String> generatedDirs = new LinkedHashSet<String>();
	private Set<String> manualDirs = new LinkedHashSet<String>();
	
	
	/**
	 * constructs the workflow component and configures default settings
	 */
	public Statistics() {
		// construct superclass and load all default values from property files
		super();
		properties.putAll(defaults);
		// add java beans meta model
		super.addMetaModel(new JavaMetaModel());
		// default settings (overrideable by workflow settings)
		super.setTemplate(properties.getProperty("template"));
		super.setSlot(properties.getProperty("slot"));
	}
	
	@Override
	protected void invokeInternal2(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		// calculate statistics
		SProject project = new SProject(properties.getProperty("name"), Boolean.parseBoolean(properties.getProperty("withDate")));
		project.setExcludes(properties.getProperty("excludes"));
		project.calculate(generatedDirs, manualDirs);
		
		// add statistic model to slot
		ctx.set("statisticModel", project);
		
		// generate view
		super.invokeInternal2(ctx, monitor, issues);
	}
	
	/**
	 * Adds a source folder containing generated source code (with manual source code in protected regions).
	 * Sub directories are recursively added automatically.
	 * @param dir	a directory containing generated source code
	 */
	public void addGeneratedDir(String dir) {
		generatedDirs.add(dir);
	}
	
	/**
	 * Adds source folders containing generated source code (with manual source code in protected regions).
	 * @see addGeneratedDir
	 */
	public void addGeneratedDirs(String dirs) {
		if (dirs.length() > 0) {
			List<String> filtered = WorkflowUtils.split(dirs);
			for (String s : filtered) {
				addGeneratedDir(s);
			}
		}
	}
	
	/**
	 * Adds a source folder containing only manually written source code
	 * Sub directories are recursively added automatically.
	 * @param dir	a directory containing only manually written source code
	 */
	public void addManualDir(String dir) {
		manualDirs.add(dir);
	}
	
	/**
	 * Adds source folders containing only manually written source code
	 * @see addManualDir
	 */
	public void addManualDirs(String dirs) {
		if (dirs.length() > 0) {
			List<String> filtered = WorkflowUtils.split(dirs);
			for (String s : filtered) {
				addManualDir(s);
			}
		}
	}
	
	/**
	 * Sets the project name used for the file name.
	 * @param name	the name of the project
	 */
	public void setName(String name) {
		properties.put("name", name);
	}
	
	/**
	 * Sets the file names to exclude
	 * @param excludes	file names to exclude
	 */
	public void setExcludes(String excludes) {
		properties.put("excludes", excludes);
	}
	
	/**
	 * Sets the flag to include the date in the file name or not.
	 * @param withDate	true to include the date in the file name, otherwise false
	 */
	public void setWithDate(boolean withDate) {
		properties.put("withDate", withDate);
	}
	
	/**
	 * Sets the comment signs to determine the lines of code
	 * @param comments	the comment signs to use
	 */
	public void setComments(CommentSign comments) {
		properties.put("comments", comments);
	}
}
