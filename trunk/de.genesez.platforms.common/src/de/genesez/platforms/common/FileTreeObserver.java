package de.genesez.platforms.common;

import java.nio.file.Path;

import de.genesez.platforms.common.workflow.feature.FileTreeWalkerFeature.FileEvent;

/**
 * The observer interface for observing the FileTreeWalker.
 * If a class needs information from the file tree it should implement this.
 * 
 * @author Dominik Wetzel
 * @date 2011-09-27
 */
public interface FileTreeObserver extends Prioritizable {
	
	/**
	 * called from the class that's observed. Updates the status
	 * @param event the event thats was given for the file
	 * @param file the file that the event was given for
	 */
	public abstract void update(FileEvent event, Path file);
}
