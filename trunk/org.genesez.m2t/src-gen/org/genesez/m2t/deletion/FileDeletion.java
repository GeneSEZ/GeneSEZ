package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_ZACkBgD0EeK7ac-mrkJBDw) 
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.genesez.util.FileSystemHelper;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

/**
 * The FileDeletionFeature handles the deletion of unchanged files during the generation process. With the filter-options the search can be specified.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-20
 * @author dreamer
 */
public class FileDeletion extends DeletionFeature {
	
	// -- generated attribute, constant + association declarations ----------
	
	public final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * the includes
	 */
	private java.util.Set<String> includedFiles = new java.util.HashSet<String>();
	
	/**
	 * the excludes
	 */
	private java.util.Set<String> excludedFiles = new java.util.HashSet<String>();
	
	/**
	 * the map for comparison between last modification dates
	 */
	private Map<String, Long> files;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	public void updateFileVisit(Path file) {
		/* PROTECTED REGION ID(java.implementation._ZACkJQD0EeK7ac-mrkJBDw) ENABLED START */
		if (!enabled) {
			return;
		}
		// looks if file is in or excluded
		for (String exclDirName : super.excludedDirectoryNames) {
			if (file.toString().matches(".*[\\\\|/]" + exclDirName + "[\\\\|/].*")) {
				return;
			}
		}
		for (String exclRelPath : super.excludedRelativePaths) {
			if (file.startsWith(exclRelPath)) {
				return;
			}
		}
		for (String exclFile : excludedFiles) {
			if (file.toString().endsWith(exclFile)) {
				return;
			}
		}
		if (!includedFiles.isEmpty()) {
			for (String inclFile : includedFiles) {
				if (file.toString().endsWith(inclFile)) {
					files.put(file.toString(), file.toFile().lastModified());
				}
			}
			return;
		}
		// add to oldFiles map (with LMD)
		files.put(file.toString(), file.toFile().lastModified());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Logs revision systems and found files, also sets prepared to true. Called if file tree completely walked.
	 */
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._ZACkJwD0EeK7ac-mrkJBDw) ENABLED START */
		super.updateComplete();
		if (logger.isDebugEnabled()) {
			logger.debug(files.size() + " File(s) found.");
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Only for testing, gives the count of files found.
	 * @return	size of oldFiles set.
	 */
	protected int getOldFileCount() {
		/* PROTECTED REGION ID(java.implementation._ZACkKQD0EeK7ac-mrkJBDw) ENABLED START */
		return files.size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes the unchanged files. Therefore it compares the old last modification dates with the new ones.
	 * 
	 * @throws NotPreparedException if prepare wasn't called before
	 * @return	
	 */
	protected java.util.Set<String> deleteUntouchedFiles() {
		/* PROTECTED REGION ID(java.implementation._ZACkNQD0EeK7ac-mrkJBDw) ENABLED START */
		Set<String> toDelete = new HashSet<String>();
		Set<String> keys = files.keySet();
		// search for files to delete
		for (String key : keys) {
			Path path = Paths.get(key);
			if (Files.exists(path)) {
				// check if LMDs are equal
				if (files.get(key) == path.toFile().lastModified()) {
					toDelete.add(key);
				}
			}
		}
		// delete files in repositories and in filesystem
		for (String delete : toDelete) {
			for (RevisionControlSystem rep : RevisionControlSystemFinder.available) {
				rep.markForDelete(delete);
			}
			try {
				Path del = Paths.get(delete);
				FileSystemHelper.alterPermission(del);
				Files.deleteIfExists(del);
			} catch (IOException e) {
				logger.error("Error while deleting a file", e);
				e.printStackTrace();
			}
		}
		return toDelete;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void delete() {
		/* PROTECTED REGION ID(java.implementation._ZACkBgD0EeK7ac-mrkJBDw__fxr7AATmEeKUpcpqfZ9tsA) ENABLED START */
		if (!enabled) {
			return;
		}
		if (!prepared) {
			logger.fatal("File deletion was not prepared! Ensure it runs within a file system walker.");
			return;
		}
		long time = System.currentTimeMillis();
		Set<String> log = deleteUntouchedFiles();
		time = System.currentTimeMillis() - time;
		if (logger.isInfoEnabled()) {
			logger.info(log.size() + " file(s) deleted.");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("Deleted file(s): " + log.toString());
			logger.debug("File deletion took: " + (time / 1000.0) + "s");
		}
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * the includes
	 */
	public void addIncludedFiles(String includedFiles) {
		this.includedFiles.add(includedFiles);
	}
	
	/**
	 * the includes
	 */
	public void removeIncludedFiles(String includedFiles) {
		this.includedFiles.remove(includedFiles);
	}
	
	/**
	 * the excludes
	 */
	public void addExcludedFiles(String excludedFiles) {
		this.excludedFiles.add(excludedFiles);
	}
	
	/**
	 * the excludes
	 */
	public void removeExcludedFiles(String excludedFiles) {
		this.excludedFiles.remove(excludedFiles);
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._ZACkBgD0EeK7ac-mrkJBDw) ENABLED START */
	{
		files = new LinkedHashMap<>();
	}
	/* PROTECTED REGION END */
	
}
