package org.genesez.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_ZACkSgD0EeK7ac-mrkJBDw) 
 */

import java.nio.file.Path;

/**
 *  The observer interface for observing the FileTreeWalker. If a class needs information from the file tree it should implement this.
 *   
 *  @author Dominik Wetzel
 *  @date 2011-09-27
 * @author dreamer
 */
public interface FileTreeObserver {
	
	// -- generated method declarations -------------------------------------
	/**
	 * Updates the status. Called before FileTreeWalker opens a directory.
	 * @param	dir	the directory which will be opened in the next step.
	 */
	public void updateBeforeDir(Path dir);
	
	/**
	 * Updates the status. Called after FileTreeWalker left a directory.
	 * @param	dir	the directory which was left.
	 */
	public void updateAfterDir(Path dir);
	
	/**
	 * Updates the status. Called if a file is visited.
	 * @param	file	the file that's visited.
	 */
	public void updateFileVisit(Path file);
	
	/**
	 * Updates the status. Called if file visit failed.
	 * @param	file	the file thats visitation failed.
	 */
	public void updateFileVisitFailed(Path file);
	
	/**
	 * Updates the status. Called if file tree walked completely.
	 */
	public void updateComplete();
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._ZACkSgD0EeK7ac-mrkJBDw) ENABLED START */
	/* PROTECTED REGION END */
}
