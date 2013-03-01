package org.genesez.m2t.cp;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_vjq8gA7rEeKn_eQP-uNBOQ) 
 */
import java.nio.file.Path;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public interface LineContentExtractor {
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 * @return	
	 */
	public boolean hasExtractableContent(Path file);
	
	/**
	 * Processes the specified line of content.
	 * @param	line	
	 */
	public void extractContent(String line);
	
	/**
	 * Method stub for further implementation.
	 * @param	file	
	 */
	public void finished(boolean file);
	
	/* PROTECTED REGION ID(java.interface.own.code.declaration._vjq8gA7rEeKn_eQP-uNBOQ) ENABLED START */
	/* PROTECTED REGION END */
}
