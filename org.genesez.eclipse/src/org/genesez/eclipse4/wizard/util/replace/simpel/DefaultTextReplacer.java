package org.genesez.eclipse4.wizard.util.replace.simpel;

import java.io.File;
import java.util.Dictionary;

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
