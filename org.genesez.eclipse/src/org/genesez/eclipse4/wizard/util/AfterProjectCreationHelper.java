package org.genesez.eclipse4.wizard.util;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ui.ide.undo.CreateFileOperation;

/**
 * A helper class thats used to add project files after they were created.
 * 
 * @author Dominik Wetzel
 * 
 */
public class AfterProjectCreationHelper {

	/**
	 * adds the application model to the appProject/model/ folder
	 * 
	 * @param project
	 *            the application project
	 * @param appModelList
	 *            the List with the chosen appModel files
	 * @param copyFiles
	 *            if true the files will be copied, else they will only be
	 *            referenced.
	 */
	public static void addApplicationModel(IProject project,
			Collection<File> appModelList, boolean copyFiles) {
		IFolder projectModelFolder = project.getFolder("model");
		IPath folder = new Path(projectModelFolder.getLocationURI().getPath());
		if (!folder.toFile().exists())
			folder.toFile().mkdirs();
		for (File file : appModelList) {
			URI linkTargetPath = file.toURI();
			IFile fileResource = projectModelFolder.getFile(file.getName());
			if (copyFiles)
				try {
					FileUtils.copyFile(file, new File(fileResource
							.getLocationURI().getPath()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			else {
				CreateFileOperation op = new CreateFileOperation(fileResource,
						linkTargetPath, null, "Reference Files");
				try {
					op.execute(new NullProgressMonitor(), null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Adds a workflow file to a given folder.
	 * 
	 * @param template
	 *            the workflow template file (can be null).
	 * @param fileName
	 *            the new workflow filename.
	 * @param folderString
	 *            the path to the folder.
	 * @param appProjectName
	 *            the name of the application project (for replacement).
	 * @param workspace
	 *            the current workspace.
	 */
	public static void addWorklfowfile(String template, String fileName,
			String folderString, String appProjectName, IWorkspaceRoot workspace) {
		IPath folder = new Path(folderString);
		if (!folder.isAbsolute())
			folder = new Path(workspace.getLocationURI().getPath())
					.append(folder);
		folder.toFile().mkdirs();
		File file = folder.append(fileName + ".mwe2").toFile();
		if (template != null && !template.equals("")) {
			try {
				FileUtils.copyFile(new File(template), file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	private AfterProjectCreationHelper() {
	}
}
