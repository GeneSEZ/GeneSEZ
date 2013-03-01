package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_ZAIqzgD0EeK7ac-mrkJBDw) 
 */
import org.genesez.m2t.FileTreeObserverAdapter;

/**
 * Superclass for the FileDeletion. Contains methods to check which repository is in use and logs them.
 * 
 * @author Dominik Wetzel
 * @date 2011-10-11
 */
public abstract class DeletionFeature extends FileTreeObserverAdapter {
	
	/**
	 * Directory names that are excluded during file search
	 */
	protected java.util.Set<String> excludedDirectoryNames = new java.util.HashSet<String>();
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	protected java.util.Set<String> excludedRelativePaths = new java.util.HashSet<String>();
	
	/**
	 * switch for deletion
	 */
	protected boolean enabled = true;
	
	/**
	 * trigger for the NotPreparedException
	 */
	protected boolean prepared = false;
	
	/**
	 * Method stub for further implementation.
	 */
	public abstract void delete();
	
	/**
	 * Sets prepared to true. Called if file tree walked completely.
	 */
	public void updateComplete() {
		/* PROTECTED REGION ID(java.implementation._ZAIqwgD0EeK7ac-mrkJBDw) ENABLED START */
		prepared = true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Directory names that are excluded during file search
	 */
	public void addExcludedDirectoryNames(String excludedDirectoryNames) {
		this.excludedDirectoryNames.add(excludedDirectoryNames);
	}
	
	/**
	 * Directory names that are excluded during file search
	 */
	public void removeExcludedDirectoryNames(String excludedDirectoryNames) {
		this.excludedDirectoryNames.remove(excludedDirectoryNames);
	}
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	public void addExcludedRelativePaths(String excludedRelativePaths) {
		this.excludedRelativePaths.add(excludedRelativePaths);
	}
	
	/**
	 * paths relative to output directory that are excluded during the file search.
	 */
	public void removeExcludedRelativePaths(String excludedRelativePaths) {
		this.excludedRelativePaths.remove(excludedRelativePaths);
	}
	
	/**
	 * switch for deletion
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._ZAIqzgD0EeK7ac-mrkJBDw) ENABLED START */
	{
		// exclude all revision control metadata folders
		for (RevisionControlSystem rep : RevisionControlSystem.REGISTRY) {
			excludedDirectoryNames.add(rep.getMetadataFolderName());
		}
	}
	/* PROTECTED REGION END */
	
}
