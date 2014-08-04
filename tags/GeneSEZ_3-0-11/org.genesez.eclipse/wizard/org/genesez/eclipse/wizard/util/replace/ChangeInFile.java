/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util.replace;

import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ltk.core.refactoring.Change;

/**
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
public interface ChangeInFile {

	/**
	 * String to access the oldname property.
	 */
	public static final String OLDNAME = "oldname";
	
	/**
	 * String to access the newname property.
	 */
	public static final String NEWNAME = "newname";
	
	/**
	 * Creates a Change for the Refactoring API
	 * @param file the file, where changes should be made
	 * @param properties the things that should be changed, stored in Properties Map
	 * @return the Change object, which can be executed with executeChange().
	 */
	public Change[] createChange(IFile file, Properties properties);
	
	/**
	 * Executes the Change, where refactoring is not needed.
	 * createChange() should be called first.
	 */
	public void executeChange(IProgressMonitor pm);
	
}
