package de.genesez.platforms.common;

import java.nio.file.Path;

/**
 * The observer interface for observing the FileTreeWalker.
 * If a class needs information from the file tree it should implement this.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-27
 */
public interface FileTreeObserver {
	
	/**
	 * Updates the status. Called if file tree walked completely.
	 */
	public abstract void updateComplete();
	
	/**
	 * Updates the status. Called if a file is visited.
	 * @param file the file that's visited.
	 */
	public abstract void updateFileVisit(Path file);
	
	/**
	 * Updates the status. Called if file visit failed.
	 * @param file the file thats visitation failed.
	 */
	public abstract void updateFileVisitFailed(Path file);
	
	/**
	 * Updates the status. Called before FileTreeWalker opens a directory.
	 * @param dir the directory which will be opened in the next step.
	 */
	public abstract void updateBeforeDir(Path dir);
	
	/**
	 * Updates the status. Called after FileTreeWalker left a directory.
	 * @param dir the directory which was left.
	 */
	public abstract void updateAfterDir(Path file);
}
