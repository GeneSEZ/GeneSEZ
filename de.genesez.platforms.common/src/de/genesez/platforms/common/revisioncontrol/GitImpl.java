package de.genesez.platforms.common.revisioncontrol;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jgit.dircache.DirCache;
import org.eclipse.jgit.dircache.DirCacheEditor;
import org.eclipse.jgit.util.FS;

/**
 * Implementation of the delete algorithm for Git.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public class GitImpl implements RevisionControlSystem {
	String metadataFolderName = ".git";
	List<String> rootDir = new LinkedList<String>();

	/**
	 * creates a new Git implementation
	 */
	public GitImpl() {
	}

	/**
	 * deletes a file with the given path String under Git
	 * @param file the file, that should be deleted
	 */
	public void markForDelete(String file) {
		for(String dir : rootDir){
			DirCache cache = new DirCache(new File(dir), FS.DETECTED);
			DirCacheEditor e = cache.editor();
			e.add(new DirCacheEditor.DeletePath(file));
			e.finish();
		}
	}

	/**
	 * gives a list with the repository metadata-folder-name usually this should
	 * contain only 1 entry.
	 * 
	 * @return a List with metadata-folder-name
	 */
	public String getMetadataFolderName() {
		return metadataFolderName;
	}
	
	/**
	 * Sets the path of the found .git directory. Needed for deletion.
	 * @param String representation of the path to the directory.
	 */
	public void setRepositoryRoot(String root) {
		rootDir.add(root);
	}
	
	/**
	 * The name that will be printed on the log
	 * 
	 * @return "Git"
	 */
	@Override
	public String toString() {
		return "Git";
	}
}
