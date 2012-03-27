package org.genesez.platform.common.revisioncontrol;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_1_8e00291_1323946227175_155547_2733) 
 */

import org.eclipse.jgit.dircache.DirCacheEditor;
import org.eclipse.jgit.util.FS;
import java.io.File;
import java.util.HashSet;
import org.eclipse.jgit.dircache.DirCache;
/**
 * Implementation of the delete algorithm for Git.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class GitImpl implements RevisionControlSystem {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String metadataFolderName = ".git";
	
	private java.util.Set<String> rootDir = new HashSet<String>();
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Sets the path of the found .git directory. Needed for deletion.
	 * @param	name	String-representation of the path to the directory.
	 */
	
	public void setRepositoryRoot(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227196_977597_2754) ENABLED START */
		rootDir.add(name);
		/* PROTECTED REGION END */
	}
	
	/**
	 * deletes a file with the given path String under Git
	 * @param	file	the file, that should be deleted
	 */
	
	public void markForDelete(String file) {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227197_292059_2755) ENABLED START */
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
	 * @return	"Git"
	 */
	public String toString() {
		/* PROTECTED REGION ID(java.implementation._17_0_1_8e00291_1323946227198_504793_2756) ENABLED START */
		return "Git";
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>metadataFolderName</b></em>'
	 */
	public String getMetadataFolderName() {
		return metadataFolderName;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_1_8e00291_1323946227175_155547_2733) ENABLED START */
	//	static {
	//		System.err.println("Add GitImpl");
	//		RegisterHelper.addRepositoryImpl(new GitImpl());
	//	}
	/* PROTECTED REGION END */
	
}
