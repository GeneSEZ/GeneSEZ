package org.genesez.eclipse4.wizard.util;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.mapping.IResourceChangeDescriptionFactory;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.participants.ResourceChangeChecker;

public class ProjectRenameParticipant extends RenameParticipant {

	private IProject project;
	private IResourceChangeDescriptionFactory deltaFactory;
	private List<IFile> toChange = new ArrayList<IFile>();
	private String oldName;

	@Override
	protected boolean initialize(Object element) {
		if (element instanceof IProject) {
			project = (IProject) element;
			return true;
		}
		return false;
	}

	@Override
	public String getName() {
		return "Project Rename";
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {
		ResourceChangeChecker checker = (ResourceChangeChecker) context.getChecker(ResourceChangeChecker.class);
		deltaFactory= checker.getDeltaFactory();
		
//		IPath workspaceDirectory = project.getWorkspace().getRoot().getLocation();
		File projectPath = project.getLocation().toFile();
		URI projectURI = projectPath.toURI();
		oldName = projectPath.getName();
		Collection<File> files = FileUtils.listFiles(projectPath, null, true);
		for(File file : files){
			String path = projectURI.relativize(file.toURI()).getPath();
			System.out.println(path);
			IFile data = project.getFile(path);
			toChange.add(data);
			deltaFactory.change(data);
		}
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		String newName = getArguments().getNewName();
		Properties properties = new Properties();
		properties.setProperty(ChangeInFile.OLDNAME, oldName);
		properties.setProperty(ChangeInFile.NEWNAME, newName);
		CompositeChange change = new CompositeChange("Rename in Files");
		ChangeInFile changer = new ChangeInMWEFile();
		for(IFile file : toChange){
			Change[] createdChange = changer.createChange(file, properties);
			if(createdChange.length != 0){
				change.addAll(createdChange);
			}
		}
		if(change.getChildren().length > 0)
			return change;
		return null;
	}

}
