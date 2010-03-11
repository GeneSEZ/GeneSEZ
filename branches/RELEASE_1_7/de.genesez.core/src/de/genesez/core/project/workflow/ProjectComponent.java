package de.genesez.core.project.workflow;

import org.eclipse.core.runtime.IProgressMonitor;
import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.core.project.Project;

public class ProjectComponent extends AbstractWorkflowComponent {
	
	private String inputSlot = "theModel";
	
	public void checkConfiguration(Issues issues) {
		// TODO Auto-generated method stub

	}

	public void invoke(WorkflowContext ctx, ProgressMonitor oawmonitor, Issues issues) {
		
		Project p = (Project) ctx.get(inputSlot);

		// this is the eclipse wizard's progress monitor - not the oaw progress monitor!
		IProgressMonitor monitor = (IProgressMonitor) ctx.get("monitor");
		// the name of the project to create
		String name = (String) ctx.get("name");
		
		// create the generator project first
		GeneratorProject gp = new GeneratorProject(monitor);
		gp.create(p.getGenerator(), name);

		// then create the target project
		TargetProject tp = new TargetProject(monitor);
		tp.create(p.getTarget(), name);
	}

	public void setInputSlot(String inputSlot) {
		this.inputSlot = inputSlot;
	}

}
