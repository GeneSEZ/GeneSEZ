package org.genesez.traceability;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_y4kyYI8JEeKpNoiOVa6Abg) 
 */
import static org.genesez.workflow.profile.WorkflowFileInclusion.WHEN_NEEDED;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;
import org.genesez.metamodel.gcore.GcorePackage;
import org.genesez.metamodel.greq.GreqPackage;
import org.genesez.metamodel.gtrace.GtracePackage;
import org.genesez.workflow.Copier;
import org.genesez.workflow.profile.WfDefault;
import org.genesez.workflow.profile.WfParameter;
import org.genesez.workflow.xpand.Model2TextComponent;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class DashboardComponent extends Model2TextComponent {
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String templateDir;
	
	@WfParameter(isRequired = false, isMultiValued = false, workflowInclusion = WHEN_NEEDED, isTransformationParameter = true)
	private String templateZipFile = "template.zip";
	
	private Path templateSource;
	
	/**
	 * Validates the configuration of the component before invocation.
	 * @param	issues	Instance to collect all problems during configuration check.
	 */
	public void checkConfiguration(Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Q5J7CI8TEeKpNoiOVa6Abg) ENABLED START */
		// ensure a template source to from exists
		if (templateDir == null || Files.notExists(Paths.get(templateDir))) {
			Path zip = Paths.get(templateZipFile);
			if (Files.notExists(zip)) {
				Path base = Copier.resourceBase(getClass());
				if (base != null) {
					zip = base.resolve(zip);
					if (Files.exists(zip)) {
						try {
							templateSource = Copier.zipFileSystemRoot(zip);
						} catch (IOException e) {
							issues.addError(this, "Workflow parameter 'templateZipFile' not usable!", null, e, Collections.emptyList());
						}
					} else {
						issues.addError(this, "Workflow parameter 'templateZipFile' must exists!", zip);
					}
				}
			} else {
				try {
					templateSource = Copier.zipFileSystemRoot(zip);
				} catch (IOException e) {
					issues.addError(this, "Workflow parameter 'templateZipFile' not usable!", null, e, Collections.emptyList());
				}
			}
		} else {
			templateSource = Paths.get(templateDir);
		}
		if (templateSource == null || Files.notExists(templateSource)) {
			issues.addError(this, "Workflow parameter 'templateDir' or 'templateZipFile' must be present and existing!", templateSource);
		}
		// register meta models
		addEmfMetaModelPackage(GcorePackage.class.getName());
		addEmfMetaModelPackage(GreqPackage.class.getName());
		addEmfMetaModelPackage(GtracePackage.class.getName());
		super.checkConfiguration(issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Invokes the execution of the component.
	 * @param	context	The context of workflow execution.
	 * @param	monitor	Instance to report any activity to.
	 * @param	issues	Instance to collect all problems during execution.
	 */
	protected void invokeInternal(WorkflowContext context, ProgressMonitor monitor, Issues issues) {
		/* PROTECTED REGION ID(java.implementation._Q5J7AI8TEeKpNoiOVa6Abg) ENABLED START */
		try {
			// copy dashboard template
			Path destination = Paths.get(getOutputDir());
			Copier.copy(templateSource, destination);
		} catch (IOException e) {
			throw new RuntimeException("Copy of dashboard template failed!", e);
		}
		// delegate invoke
		super.invokeInternal(context, monitor, issues);
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "templateZipFile")
	public String getDefaultTemplateZipFile() {
		return "template.zip";
	}
	
	/**
	 * Method stub for further implementation.
	 */
	@WfDefault(parameter = "slot")
	public String getDefaultSlot() {
		return "tracemodel";
	}
	
	/**
	 * Returns the value of attribute '<em><b>templateDir</b></em>'.
	 */
	public String getTemplateDir() {
		return templateDir;
	}
	
	/**
	 * Sets the value of attribute '<em><b>templateDir</b></em>'.
	 * @param	templateDir	the value to set.
	 */
	public void setTemplateDir(String templateDir) {
		this.templateDir = templateDir;
	}
	
	/**
	 * Returns the value of attribute '<em><b>templateZipFile</b></em>'.
	 */
	public String getTemplateZipFile() {
		return templateZipFile;
	}
	
	/**
	 * Sets the value of attribute '<em><b>templateZipFile</b></em>'.
	 * @param	templateZipFile	the value to set.
	 */
	public void setTemplateZipFile(String templateZipFile) {
		this.templateZipFile = templateZipFile;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._y4kyYI8JEeKpNoiOVa6Abg) ENABLED START */
	/* PROTECTED REGION END */
}
