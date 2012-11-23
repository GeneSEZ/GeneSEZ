/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse4.wizard.util.replace.simpel;

import java.io.File;
import java.util.Dictionary;

/**
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
public class DefaultTextReplacer extends SimpleTextReplacer {

	public DefaultTextReplacer(){
		super();
		fileExtensions = new String[]{ "MANIFEST.MF",
				"build.xml", ".project" };
	}
	
	@Override
	protected String getOldText(File file, String oldAppName,
			String oldGenName, boolean isGenProject,
			Dictionary<String, Object> properties) {
		if(isGenProject)
			return oldGenName;
		return oldAppName;
	}

	@Override
	protected String getNewText(File file, String newAppName,
			String newGenName, boolean isGenProject,
			Dictionary<String, Object> properties) {
		if(isGenProject)
			return newGenName;
		return newAppName;
	}
}
