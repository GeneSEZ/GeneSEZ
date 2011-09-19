package de.genesez.platforms.common.revisioncontrol;

/**
 * Interface that provides different delete algorithms for different revision
 * control systems (RCS).
 * 
 * @author Dominik Wetzel
 * @date 2011-09-15
 */
public interface RevisionControlSystem {

	/**
	 * deletes a file with the given path String
	 * 
	 * @param file
	 *            the file, that should be deleted
	 */
	public abstract void markForDelete(String file);

	/**
	 * gives a list of repository metadata-folder-names usually this should
	 * contain only 1 entry (except for default)
	 * 
	 * @return a List with metadata-folder-names
	 */
	public abstract String getMetadataFolderName();

	/**
	 * a callback from the Deletor Module to set the Path of the metadataFolder 
	 * @param root the directory where the metadata folder was found
	 */
	public abstract void setRepositoryRoot(String root);
	
	/**
	 * The name that will be printed on the log
	 * 
	 * @return name of the RCS
	 */
	@Override
	public abstract String toString();
}