package org.genesez.m2t.xpand;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_higo8ASlEeKUpcpqfZ9tsA) 
 */

import org.eclipse.xpand2.output.FileHandle;
import org.eclipse.xpand2.output.PostProcessor;
import org.genesez.m2t.ImportPreserver;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author dreamer
 */
public class XpandImportPreserver extends ImportPreserver implements PostProcessor {
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called before the file will be written and closed.
	 * @param	file	the file which shall be modified.
	 */
	public void beforeWriteAndClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._Y_qJrgD0EeK7ac-mrkJBDw) ENABLED START */
		CharSequence input = file.getBuffer();
		CharSequence output = putImports(input);
		if (input != output) {
			file.setBuffer(output);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * This method is implemented from the oAW PostProcessor interface. It is called after the file is closed. Does nothing.
	 * @param	file	file which shall be modified.
	 */
	public void afterClose(FileHandle file) {
		/* PROTECTED REGION ID(java.implementation._Y_qJsgD0EeK7ac-mrkJBDw) ENABLED START */
		// nothing to do here
		/* PROTECTED REGION END */
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._higo8ASlEeKUpcpqfZ9tsA) ENABLED START */
	/* PROTECTED REGION END */
	
}
