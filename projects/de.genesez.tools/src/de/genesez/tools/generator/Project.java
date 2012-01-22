package de.genesez.tools.generator;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import de.genesez.tools.generator.TemplateManager.Template;

/**
 * A GeneSEZ project based on a template.
 * @author Marcel Klein
 */
public class Project {
	
	/** progress monitor */
	private IProgressMonitor progressMonitor = new NullProgressMonitor();
	
	/** the name of the project */
	private String projectName;
	
	/** the current Eclipse workspace */
	private IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
	
	/** used template for the project */
	private Template template;
	
	/**
	 * Generator for a new GeneSEZ Project.
	 * @throws Exception 
	 * @throws CoreException 
	 */
	public Project(String projectName, Template template) throws Exception {
		this.projectName = projectName;
		this.template = template;
	}
	/**
	 * Creates the new project out of the template.
	 * The project will be created into the current workspace.
	 * @throws CoreException
	 * @throws IOException
	 */
	public void create() throws CoreException, IOException {
		final Project project = this;
		Job createJob = new Job("Creating GeneSEZ Project") {
			
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				// create the project out of the template
				String[] projectFolders = template.extractAndReplace(project, monitor);

				// import the created project folders to eclipse workspace
				for(String folder : projectFolders) {
					IProject project = workspace.getProject(folder);
					try {
						project.create(progressMonitor);
						project.open(progressMonitor);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return Status.OK_STATUS;
			}
		};
		createJob.setUser(true);
		createJob.schedule();
		
	}
	/** @param projectName the name of the project */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	/** @return the name of the project */
	public String getProjectName() {
		return projectName;
	}
	/** @return template basis of the project */
	public Template getTemplate() {
		return template;
	}
	/** @param template template basis of the project */
	public void setTemplate(Template template) {
		this.template = template;
	}
	/** @return directory of the project files */
	public String getWorkspacePath() {
		return workspace.getLocation().toString();
	}
}
