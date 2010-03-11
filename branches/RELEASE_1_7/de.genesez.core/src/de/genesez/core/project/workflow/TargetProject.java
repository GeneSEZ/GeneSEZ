package de.genesez.core.project.workflow;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;

import de.genesez.core.project.Directory;
import de.genesez.core.project.Target;

public class TargetProject {

	private IWorkspace workspace = ResourcesPlugin.getWorkspace();
	private IProgressMonitor monitor;
	private String projectName;
	
	public TargetProject(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
	public void create(Target targetModel, String name) {
		this.projectName = name;
		
		IProject project = this.workspace.getRoot().getProject(this.projectName);
		String workspacePath = this.workspace.getRoot().getLocation().toOSString();
		String projectPath = workspacePath + project.getFullPath().toOSString();
		final IProjectDescription projectDescription = this.workspace.newProjectDescription(this.projectName);
		
		try {
			project.create(projectDescription, new SubProgressMonitor(this.monitor, 1));
		} catch (Exception e) {
			// TODO: Handle Exception in correct way
			e.printStackTrace();
		}
		
		for (Directory directory : targetModel.getDirectories()) {
			String path = projectPath + "/" + directory.getName();
			(new File(path)).mkdirs();
		}
	}

}
