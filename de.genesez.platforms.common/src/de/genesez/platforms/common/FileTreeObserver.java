package de.genesez.platforms.common;

import java.nio.file.Path;

import de.genesez.platforms.common.FileTreeWalker.FileEvent;

/**
 * The observer interface for observing the FileTreeWalker.
 * If a class needs information from the file tree it should implement this.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-27
 */
public interface FileTreeObserver {
	
	/**
	 * called from the class that's observed. Updates the status
	 * @param event the event thats was given for the file
	 * @param file the file that the event was given for
	 */
	public abstract void update(FileEvent event, Path file);
	
	/**
	 * Says whether the observer needs a file tree walk before generation.
	 * It will be registered as observer if true.
	 * @return true, if a file tree walk is needed before generation.
	 */
	public abstract boolean getNeedsPrepare();
	
	/**
	 * Says whether the observer needs file tree walk after generation.
	 * It will be again registered as observer if true
	 * @return true, if a file tree walk is needed after generation.
	 */
	public abstract boolean getNeedsSecondWalk();
	
	/**
	 * Methods thats called after the second file tree walk
	 */
	public abstract void afterSecondFileWalk();
}
