package org.genesez.eclipse4.wizard.util.replace.simpel;

import java.io.File;
import java.util.Dictionary;

public class MWETextReplacer extends SimpleTextReplacer {

	public MWETextReplacer() {
		fileExtensions = new String[]{".mwe", ".mwe2"};
	}
	
	@Override
	protected String getOldText(File file, String oldAppName,
			String oldGenName, boolean isGenProject,
			Dictionary<String, Object> properties) {
		return oldAppName;
	}

	@Override
	protected String getNewText(File file, String newAppName,
			String newGenName, boolean isGenProject,
			Dictionary<String, Object> properties) {
		return newAppName;
	}
}
