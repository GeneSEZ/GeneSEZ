package de.genesez.core.project.workflow;

import java.util.Properties;

import org.openarchitectureware.type.emf.EmfMetaModel;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.core.project.Project;

public class ProjectComponent extends org.openarchitectureware.xpand2.Generator {
	
	private static Properties defaults = new Properties();
	static {
		defaults.put("fileEncoding", "utf-8");
		defaults.put("expand", "de::genesez::core::project::templates::Main::main FOR theModel");
		defaults.put("metaModelPackage", "de.genesez.core.project.ProjectPackage");
	}
	private String inputSlot = "theModel";
	
	/**
	 * Overridden for checking all parameters. If parameter's value is null,
	 * then set default value.
	 * 
	 * @see org.openarchitectureware.xpand2.Generator#checkConfigurationInternal(org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void checkConfigurationInternal(Issues issues) {

		// set the file encoding
		this.setFileEncoding(ProjectComponent.defaults.getProperty("fileEncoding"));
		
		// set the path to xpand template
		this.setExpand(ProjectComponent.defaults.getProperty("expand"));

		// add the meta model
		EmfMetaModel project = new EmfMetaModel();
		project.setMetaModelPackage(ProjectComponent.defaults.getProperty("metaModelPackage"));
		this.addMetaModel(project);
		
		super.checkConfigurationInternal(issues);
	}

	/**
	 * Override invocation of xpand execution - the project structures has to be created first
	 *
	 * @see org.openarchitectureware.xpand2.Generator#invokeInternal2(org.openarchitectureware.workflow.WorkflowContext,org.openarchitectureware.workflow.monitor.ProgressMonitor,org.openarchitectureware.workflow.issues.Issues)
	 */
	@Override
	protected void invokeInternal2(final WorkflowContext ctx, final ProgressMonitor monitor, final Issues issues) {

		// get the project model out of workflow context
		Project p = (Project) ctx.get(inputSlot);

		GeneratorProject gp = (GeneratorProject) ctx.get("generatorProject");
		TargetProject tp = (TargetProject) ctx.get("targetProject");
		
		gp.create(p.getGenerator());
		tp.create(p.getTarget());

		// generate files
		super.invokeInternal2(ctx, monitor, issues);
	
		gp.refresh();
	}

	public void setInputSlot(String inputSlot) {
		this.inputSlot = inputSlot;
	}
	
}
