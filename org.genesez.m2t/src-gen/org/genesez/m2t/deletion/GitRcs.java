package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_bPxLoAS9EeKUpcpqfZ9tsA) 
 */

import java.io.File;
import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEditor;
import org.eclipse.jgit.util.FS;
/**
 * Implementation of the delete algorithm for Git.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 * @author dreamer
 */
public class GitRcs implements RevisionControlSystem {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String metadataFolderName = ".git";
	
	private java.util.Set<String> rootDir = new java.util.HashSet<String>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * gives the metadata foldername of the currently checked RCS.
	 * @return	the metadata folder name
	 */
	public String getMetadataFolderName() {
		/* PROTECTED REGION ID(java.implementation._bPxLoAS9EeKUpcpqfZ9tsA__qUp80gQdEeK-ufRtI9UaTA) ENABLED START */
		return metadataFolderName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * a callback from the DeletionFeature to set the Path of the metadata folder
	 * @param	name	the directory where the metadata folder was found
	 */
	public void setRepositoryRoot(String name) {
		/* PROTECTED REGION ID(java.implementation._bPxLoAS9EeKUpcpqfZ9tsA__qUp81gQdEeK-ufRtI9UaTA) ENABLED START */
		rootDir.add(name);
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes a file with the given path String
	 * @param	file	the file, that should be deleted
	 */
	public void markForDelete(String file) {
		/* PROTECTED REGION ID(java.implementation._bPxLoAS9EeKUpcpqfZ9tsA__qUp82gQdEeK-ufRtI9UaTA) ENABLED START */
		for (String dir : rootDir) {
			DirCache cache = new DirCache(new File(dir), FS.DETECTED);
			DirCacheEditor e = cache.editor();
			e.add(new DirCacheEditor.DeletePath(file));
			e.finish();
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * The name that will be printed on the log
	 * @return	name of the RCS
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._bPxLoAS9EeKUpcpqfZ9tsA__qUp83gQdEeK-ufRtI9UaTA) ENABLED START */
		return "Git";
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._bPxLoAS9EeKUpcpqfZ9tsA) ENABLED START */
	/* PROTECTED REGION END */
	
}
