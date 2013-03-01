package org.genesez.m2t.deletion;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_qUp80AQdEeK-ufRtI9UaTA) 
 */

/**
 * Interface that provides different delete algorithms for different revision control systems (RCS).
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public interface RevisionControlSystem {
	
	public static final java.util.Set<RevisionControlSystem> REGISTRY = new java.util.HashSet<RevisionControlSystem>();
	
	/**
	 * gives the metadata foldername of the currently checked RCS.
	 * @return	the metadata folder name
	 */
	public String getMetadataFolderName();
	
	/**
	 * a callback from the DeletionFeature to set the Path of the metadata folder
	 * @param	name	the directory where the metadata folder was found
	 */
	public void setRepositoryRoot(String name);
	
	/**
	 * deletes a file with the given path String
	 * @param	file	the file, that should be deleted
	 */
	public void markForDelete(String file);
	
	/**
	 * The name that will be printed on the log
	 * @return	name of the RCS
	 */
	public String toString();
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._qUp80AQdEeK-ufRtI9UaTA) ENABLED START */
	/* PROTECTED REGION END */
}
