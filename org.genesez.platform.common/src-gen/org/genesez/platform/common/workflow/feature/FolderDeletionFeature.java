package org.genesez.platform.common.workflow.feature;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1317801559546_174911_1575) 
 */

import java.util.List;
import org.genesez.platform.common.FileSystemHelper;
import java.io.IOException;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import org.apache.commons.logging.Log;
import org.genesez.platform.common.NotPreparedException;
import java.util.Set;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import org.genesez.platform.common.revisioncontrol.RevisionControlSystem;
import java.util.LinkedList;
import java.util.HashSet;

/**
 * Does the deletion of empty packages, it runs after generation and should run after deletion.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 * @deprecated
 */
public class FolderDeletionFeature extends DeletionFeature {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * Logger instance to output important messages.
	 */
	protected Log logger = LogFactory.getLog(getClass());
	
	/**
	 * switch for deletion
	 */
	private boolean deleteEmptyFolders = true;
	
	/**
	 * trigger for the not prepared exception.
	 */
	private boolean prepared = false;
	
	private java.util.List<Path> emptyFolders = new java.util.ArrayList<Path>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Checks the configuration. Disables folder deletion if no outputDir was given.
	 */
	
	public void checkConfiguration() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317885214732_559837_1911) ENABLED START */
		if (super.outputPath == null || super.outputPath.toString().isEmpty()) {
			deleteEmptyFolders = false;
			logger.info("No output directory given. Folder deletion is deactivated.");
		}
		if (deleteEmptyFolders) {
			logger.info("Folder deletion activated. Empty folders will be deleted.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Deletes empty Folders from found revision control system and if possible from the file system.
	 * 
	 * @throws NotPreparedException if file tree walk failed or this was not registered as observer.
	 */
	
	public void invokePost() throws NotPreparedException {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317885036627_480539_1887) ENABLED START */
		if (deleteEmptyFolders) {
			if (prepared) {
				long time = System.currentTimeMillis();
				Set<String> log = deleteEmptyPackages();
				time = System.currentTimeMillis() - time;
				logger.info(log.size() + " folder(s) deleted.");
				logger.debug("Deleted folders: " + log);
				logger.debug("Folder deletion took: " + (time / 1000.0) + "s");
			} else {
				throw new NotPreparedException("Folder deletion is not prepared properly.");
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Prepares the deletion of empty packages. Called after a directory was completely visited.
	 * @param	dir	the directory that will be checked.
	 */
	
	public void updateAfterDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1317885040231_443945_1890) ENABLED START */
		if (deleteEmptyFolders) {
			// prepare package deletion
			prepareDeleteEmptyPackages(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Sets prepared to true. Called if file tree walked completely.
	 */
	
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318575220744_2055_1994) ENABLED START */
		super.logRevisionSystems();
		prepared = true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Prepares deletion of empty packages (folders). It checks whether the subfolders are empty or not and stores the folder paths if its empty.
	 * @param	dir	the current directory that will be checked
	 */
	
	protected void prepareDeleteEmptyPackages(Path dir) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593599852_896988_3499) ENABLED START */
		// is directory excluded?
		for (String exclDirName : super.excludedDirectoryNames) {
			if (dir.endsWith(exclDirName) || dir.toString().matches(".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
				return;
			}
		}
		for (String exclRelPath : super.excludedRelativePaths) {
			if (dir.startsWith(exclRelPath)) {
				return;
			}
		}
		// get subfiles and count of subfiles
		int size = 0;
		List<File> files = new LinkedList<File>();
		if (Files.exists(dir) && Files.isDirectory(dir)) {
			files = Arrays.asList(dir.toFile().listFiles());
			size = files.size();
		}
		// number of not empty files in the directory
		int notEmptyFolders = size;
		
		for (int i = 0; i < size; i++) {
			Path subfolder = files.get(i).toPath();
			if (Files.isDirectory(subfolder)) {
				boolean toBreak = false;
				// if metadata folder "number of not empty files" -1
				for (RevisionControlSystem rep : super.getRevisionSystems()) {
					if (subfolder.endsWith(rep.getMetadataFolderName())) {
						notEmptyFolders--;
						toBreak = true;
						break;
					}
				}
				if (toBreak) {
					continue;
				}
				if (emptyFolders.contains(subfolder)) {
					notEmptyFolders--;
				}
			} else {
				break;
			}
		}
		
		if (notEmptyFolders == 0) {
			emptyFolders.add(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes previously found empty folders.
	 * @return	set with deleted folders
	 */
	protected java.util.Set<String> deleteEmptyPackages() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1318593624600_585415_3502) ENABLED START */
		Set<String> list = new HashSet<String>();
		for (Path dir : emptyFolders) {
			for (RevisionControlSystem rep : super.getRevisionSystems()) {
				rep.markForDelete(dir.toString());
			}
			// delete all folders normal if possible
			if (Files.exists(dir) && dir.toFile().listFiles().length == 0) {
				try {
					FileSystemHelper.alterPermission(dir);
					Files.delete(dir);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			list.add(dir.toString());
		}
		emptyFolders.clear();
		return list;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1317801559546_174911_1575) ENABLED START */
	/* PROTECTED REGION END */
	
}
