package de.genesez.platforms.common.revisioncontrol;

import java.util.List;

/**
 * For use with different repositories. 
 * @author domwet
 *
 */
public interface RevisionControlSystem {
	
	/**
	 * deletes a file with the given path String
	 * @param file the file, that should be deleted
	 */
	public abstract void delete(String file);
	
	/**
	 * gives a list of repository metadata folder names
	 * usually this should contain only 1 entry
	 * (except for default)
	 * 
	 * @return a List with metadata folder names
	 */
	public abstract List<String> getMetadataFolderNames();
	
	/**
	 * The name that will be printed on the log
	 * @return name of the RCS
	 */
	public abstract String getName();
	
}