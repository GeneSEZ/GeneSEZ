package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_ZAIqqwD0EeK7ac-mrkJBDw) 
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Does the deletion of empty packages, it runs after generation and should run after deletion.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public class FolderDeletion extends DeletionFeature {
	
	public final Log logger = LogFactory.getLog(getClass());
	
	private java.util.List<Path> emptyFolders = new java.util.ArrayList<Path>();
	
	/**
	 * Prepares the deletion of empty packages. Called after a directory was completely visited.
	 * @param	dir	the directory that will be checked.
	 */
	public void updateAfterDir(Path dir) {
		/* PROTECTED REGION ID(java.implementation._ZAIqvgD0EeK7ac-mrkJBDw) ENABLED START */
		if (enabled) {
			prepareDeletion(dir);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Prepares deletion of empty packages (folders). It checks whether the subfolders are empty or not and stores the folder paths if its empty.
	 * @param	dir	the current directory that will be checked
	 */
	protected void prepareDeletion(Path dir) {
		/* PROTECTED REGION ID(java.implementation._ZAIqxAD0EeK7ac-mrkJBDw) ENABLED START */
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
				for (RevisionControlSystem rep : RevisionControlSystem.REGISTRY) {
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
	protected java.util.Set<String> deleteEmptyFolders() {
		/* PROTECTED REGION ID(java.implementation._ZAIqyAD0EeK7ac-mrkJBDw) ENABLED START */
		Set<String> list = new HashSet<String>();
		for (Path dir : emptyFolders) {
			for (RevisionControlSystem rep : RevisionControlSystemFinder.available) {
				rep.markForDelete(dir.toString());
			}
			// delete all folders normal if possible
			if (Files.exists(dir) && dir.toFile().listFiles().length == 0) {
				try {
					// toh: comments, may not be needed
					//					FileSystemHelper.alterPermission(dir);
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
	
	/**
	 * Method stub for further implementation.
	 */
	public void delete() {
		/* PROTECTED REGION ID(java.implementation._ZAIqqwD0EeK7ac-mrkJBDw__fxr7AATmEeKUpcpqfZ9tsA) ENABLED START */
		if (!enabled) {
			return;
		}
		if (!prepared) {
			logger.fatal("Folder deletion is not prepared! Ensure it runs within a file system walker.");
			return;
		}
		long time = System.currentTimeMillis();
		Set<String> log = deleteEmptyFolders();
		time = System.currentTimeMillis() - time;
		if (logger.isInfoEnabled()) {
			logger.info(log.size() + " folder(s) deleted.");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Deleted folders: " + log);
			logger.debug("Folder deletion took: " + (time / 1000.0) + "s");
		}
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._ZAIqqwD0EeK7ac-mrkJBDw) ENABLED START */
	/* PROTECTED REGION END */
}
