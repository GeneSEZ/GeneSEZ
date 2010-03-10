package de.genesez.core.project.workflow;

import org.openarchitectureware.workflow.WorkflowContext;
import org.openarchitectureware.workflow.issues.Issues;
import org.openarchitectureware.workflow.lib.AbstractWorkflowComponent;
import org.openarchitectureware.workflow.monitor.ProgressMonitor;

import de.genesez.core.project.Project;

public class GeneratorProject extends AbstractWorkflowComponent {
	
	private String inputSlot = "theModel";
	
	public void checkConfiguration(Issues issues) {
		// TODO Auto-generated method stub

	}

	public void invoke(WorkflowContext ctx, ProgressMonitor monitor, Issues issues) {
		Project p = (Project) ctx.get(inputSlot);
		System.out.println(p);
	}

	public void setInputSlot(String inputSlot) {
		this.inputSlot = inputSlot;
	}
	
}
