package de.genesez.core.project.workflow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;

import de.genesez.core.project.Builder;
import de.genesez.core.project.Classpath;
import de.genesez.core.project.Directory;
import de.genesez.core.project.Nature;
import de.genesez.core.project.Target;

public class TargetProject {

	private IWorkspace workspace = ResourcesPlugin.getWorkspace();
	private IProgressMonitor monitor;
	private IProject project;
	private String projectName;
	private String projectPath;
	
	public TargetProject(IProgressMonitor monitor, String name) {
		this.monitor = monitor;
		this.projectName = name;
		this.project = this.workspace.getRoot().getProject(this.projectName);
	}
	
	public void create(Target targetModel) {

		final IProjectDescription projectDescription = this.workspace.newProjectDescription(this.getName());
		final IJavaProject javaProject = JavaCore.create(this.project);

		// create empty project
		try {
			this.project.create(projectDescription, new SubProgressMonitor(this.monitor, 1));
		} catch (CoreException e) {
			// TODO: Handle Exception in correct way
			e.printStackTrace();
		}

		// create all directories and collect source folders
		List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>(); 
		for (Directory directory : targetModel.getDirectories()) {
			String path = this.getDirectory() + "/" + directory.getName();
			(new File(path)).mkdirs();
			if (directory.isSource()) {
				final IFolder srcFolder = this.project.getFolder(directory.getName());
				classpathEntries.add(JavaCore.newSourceEntry(srcFolder.getFullPath()));
			}
		}

		// collect all natures and add them to project description
		List<String> natures = new ArrayList<String>();
		for (Nature nature: targetModel.getNatures()) {
			natures.add(
					WizardHelper.NATUREMAP.get(nature.getId())
				);
		}
		projectDescription.setNatureIds(natures.toArray(new String[natures.size()]));

		// collect all builders and add them to project description
		List<ICommand> builders = new ArrayList<ICommand>();
		for (Builder builder: targetModel.getBuilder()) {
			final ICommand command = projectDescription.newCommand();
			command.setBuilderName(WizardHelper.BUILDERMAP.get(builder.getId()));
			builders.add( command );
		}
		projectDescription.setBuildSpec(builders.toArray(new ICommand[builders.size()]));

		// renew project description (containing natures and builders) 
		try {
			this.project.open(new SubProgressMonitor(this.monitor, 1));
			this.project.setDescription(projectDescription, new SubProgressMonitor(this.monitor, 1));
		} catch (CoreException e) {
			// TODO: Handle Exception in correct way
			e.printStackTrace();
		}

		// collect classpath entries and add them to project
		for (Classpath classpath : targetModel.getClasspath()) {
			Path path = new Path(WizardHelper.CLASSPATHMAP.get(classpath.getId()));
			classpathEntries.add(JavaCore.newContainerEntry(path));
		}

		// add project classpath and output path
		try {
			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]), new SubProgressMonitor(monitor, 1));
			javaProject.setOutputLocation(new Path("/" + this.getName() + "/bin"), new SubProgressMonitor(monitor,	1));
		} catch (JavaModelException e) {
			// TODO: Handle Exception in correct way
			e.printStackTrace();
		}
	}

	public String getDirectory() {
		if (this.projectPath == null) {
			String workspacePath = this.workspace.getRoot().getLocation().toOSString();
			this.projectPath = workspacePath + this.project.getFullPath().toOSString();			
		}
		return this.projectPath;
	}
	
	public String getName() {
		return this.projectName;
	}
	
	public void refresh() {
		try {
			this.project.refreshLocal(IProject.DEPTH_INFINITE, this.monitor);
		} catch (CoreException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
