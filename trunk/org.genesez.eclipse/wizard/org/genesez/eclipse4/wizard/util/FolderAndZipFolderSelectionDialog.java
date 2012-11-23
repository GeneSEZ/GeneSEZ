/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse4.wizard.util;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * A Selection dialog that is used to choose a Folder of a application or a
 * generator project. Can contain the contents of a project in a zip file (
 * {@link TemplateConfigXml}) and the contents of a project in the workspace.
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 * 
 */
public class FolderAndZipFolderSelectionDialog extends
		AbstractFolderSelectionDialog {

	private IWorkspaceRoot workspace;
	private IPath wsPath;
	private boolean[] flags;
	private String appProjectName;
	private String genProjectName;
	private TemplateConfigXml template;
	private Image imgFolder;

	/**
	 * Creates the Selection Dialog
	 * 
	 * @param shell
	 *            the Shell that should be used
	 * @param label
	 *            a Label thats printed above the selection Tree
	 * @param workspace
	 *            the used workspace
	 * @param template
	 *            the template thats was chosen
	 * @param appProjectName
	 *            the name for the application project
	 * @param genProjectName
	 *            the name for the generator project
	 */
	public FolderAndZipFolderSelectionDialog(Shell shell, String label,
			IWorkspaceRoot workspace, TemplateConfigXml template,
			String appProjectName, String genProjectName) {
		super(shell, label);
		this.workspace = workspace;
		this.wsPath = new Path(workspace.getLocationURI().getPath());
		this.template = template;
		this.imgFolder = PlatformUI.getWorkbench().getSharedImages()
				.getImage(ISharedImages.IMG_OBJ_FOLDER);
		this.appProjectName = appProjectName;
		this.genProjectName = genProjectName;
	}

	/**
	 * Sets the flags for the creation of the SelectionDialog
	 * 
	 * @param both
	 *            whether both projects are available or not (NOTE: if true zip
	 *            and generator have different meanings)
	 * @param zip
	 *            whether the chosen project should be used from the zip file
	 *            (NOTE: if both true this is same as application project from
	 *            zipfile)
	 * @param generator
	 *            whether the generator project should be used (NOTE: if both
	 *            true this is same as generator project form zipfile)
	 */
	public void setFlags(boolean both, boolean zip, boolean generator) {
		if (flags == null) {
			flags = new boolean[3];
		}
		this.flags[0] = both;
		this.flags[1] = zip;
		this.flags[2] = generator;
	}

	/**
	 * Fills the tree with the contents appropriate to the set flags. If no
	 * flags set application, generator project folders and zip projects will be
	 * added to the tree.
	 * 
	 * @see FolderAndZipFolderSelectionDialog#setFlags(boolean, boolean,
	 *      boolean)
	 */
	@Override
	protected void fillTree() {
		if (flags != null) {
			tree.clearAll(true);
			tree.removeAll();
			if (!flags[0] && !flags[1] && !flags[2])
				fillWithProjectFiles(appProjectName);
			else if (!flags[0] && !flags[1] && flags[2])
				fillWithProjectFiles(genProjectName);
			else if (!flags[0] && flags[1] && !flags[2])
				fillWithZipEntries(true, false);
			else if (!flags[0] && flags[1] && flags[2])
				fillWithZipEntries(true, true);
			else if (flags[0] && !flags[1] && !flags[2]) {
				fillWithProjectFiles(appProjectName);
				fillWithProjectFiles(genProjectName);
			} else if (flags[0] && !flags[1] && flags[2]) {
				fillWithProjectFiles(appProjectName);
				fillWithZipEntries(true, true);
			} else if (flags[0] && flags[1] && !flags[2]) {
				fillWithZipEntries(true, false);
				fillWithProjectFiles(genProjectName);
			} else
				fillWithZipEntries(false, false);
		} else {
			fillWithProjectFiles(appProjectName);
			fillWithProjectFiles(genProjectName);
			fillWithZipEntries(false, false);
		}
		for(TreeItem item : tree.getItems()){
			item.setExpanded(true);
		}

	}

	/**
	 * Fill the tree with the files from the real project on the workspace
	 * 
	 * @param projectName
	 *            the name of the project
	 */
	private void fillWithProjectFiles(String projectName) {
		IProject project = workspace.getProject(projectName);
		URI path = project.getLocationURI();
		if (project.exists() && path != null) {
			File file = new File(path);
			TreeItem item = new TreeItem(tree, SWT.NONE);
			prepareItem(item, file);
			makeTree(file, item);
		}
	}

	/**
	 * Creates the representation of the file tree for the given directory
	 * (recursively)
	 * 
	 * @param directory
	 *            which will be used as the root of this tree part
	 * @param attachTo
	 *            the TreeItem, where the child items will be attached to.
	 */
	private void makeTree(File directory, TreeItem attachTo) {
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				TreeItem item = new TreeItem(attachTo, SWT.NONE);
				prepareItem(item, file);
				makeTree(file, item);
			}
		}
	}

	/**
	 * Fills the tree with the zip entries from the template zip file
	 * 
	 * @param only
	 *            true if only one project from the zip file should be used
	 * @param generator
	 *            only useful if "only" is true, if true the generator project
	 *            will be used, if false the application project.
	 */
	private void fillWithZipEntries(boolean only, boolean generator) {
		List<IPath> allFolders = template.getInternalFolders();
		Map<IPath, TreeItem> map = new HashMap<IPath, TreeItem>();
		for (IPath folder : allFolders) {
			if (only)
				if (generator && !folder.segment(0).endsWith(".generator"))
					continue;
				else if (!generator && folder.segment(0).endsWith(".generator"))
					continue;
			String[] segments = folder.segments();
			for (int i = 0; i < segments.length; i++) {
				if (i == 0) {
					IPath seg = new Path(segments[0]);
					if (!map.containsKey(seg)) {
						TreeItem item = new TreeItem(tree, SWT.NONE);
						prepareItem(item, seg);
						item.setExpanded(true);
						map.put(seg, item);
					}
				} else {
					StringBuffer completeSegment = new StringBuffer();
					for (int j = 0; j <= i; j++) {
						completeSegment.append(segments[j]
								+ System.getProperty("file.separator"));
					}
					IPath complete = new Path(completeSegment.toString());
					if (map.containsKey(complete.removeLastSegments(1))
							&& !map.containsKey(complete)) {
						TreeItem item = new TreeItem(map.get(complete
								.removeLastSegments(1)), SWT.NONE);
						prepareItem(item, complete);
						map.put(complete, item);
					}
				}
			}
		}
	}

	/**
	 * Prepares the item, sets the text, image and the data
	 * 
	 * @param item
	 *            the item to prepare
	 * @param path
	 *            the corresponding path
	 */
	private void prepareItem(TreeItem item, IPath path) {
		File file = null;
		if (path.segment(0).endsWith(".generator"))
			file = new File(genProjectName + IPath.SEPARATOR
					+ path.removeFirstSegments(1).toOSString());
		else
			file = new File(appProjectName + IPath.SEPARATOR
					+ path.removeFirstSegments(1).toOSString());
		item.setImage(imgFolder);
		item.setText(file.getName());
		item.setData(file);
		item.setData(WizardConstants.ORIGINAL_PATH, path);
	}

	/**
	 * Prepares the item, sets the text, image and the data
	 * 
	 * @param item
	 *            the item to prepare
	 * @param file
	 *            the corresponding file
	 */
	private void prepareItem(TreeItem item, File file) {
		item.setText(file.getName());
		item.setImage(imgFolder);
		IPath path = new Path(file.getPath());
		if (path.matchingFirstSegments(wsPath) == wsPath.segmentCount()) {
			path = path.removeFirstSegments(wsPath.segmentCount());
		}
		item.setData(new File(path.toOSString()));
		item.setData(WizardConstants.ORIGINAL_PATH, new Path(file.getPath()));
	}
}
