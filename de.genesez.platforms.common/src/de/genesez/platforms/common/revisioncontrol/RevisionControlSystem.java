package de.genesez.platforms.common.revisioncontrol;

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
	public void delete(String file);
}