package org.genesez.m2t;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_ZACkSgD0EeK7ac-mrkJBDw) 
 */

/**
 *  The observer interface for observing the FileTreeWalker. If a class needs information from the file tree it should implement this.
 *   
 *  @author Dominik Wetzel
 *  @date 2011-09-27
 * @author dreamer
 */
public interface FileTreeObserver {
	
	/**
	 * Updates the status. Called if file tree walked completely.
	 */
	public void updateComplete();
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.interface.own.code.declaration._ZACkSgD0EeK7ac-mrkJBDw) ENABLED START */
	/* PROTECTED REGION END */
}
