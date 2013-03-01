package de.genesez.platforms.java.wizards;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.genesez.core.IPlatformWizard;

public class Java5Wizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ Java 5 Platform";
	}

	public Set<String> getBundles() {
		Set<String> bundles = new HashSet<String>();
		bundles.add("de.genesez.platforms.java;visibility:=reexport");
		return bundles;
	}

	public Map<String, String> getProjectFiles() {
		Map<String, String> files = new HashMap<String, String>();
		files.put("skeleton/java5/lib/de.genesez.platforms.java.umlsupport.jar", "lib/de.genesez.platforms.java.umlsupport.jar");
		return files;
	}
	
	public Map<String, String> getGeneratorFiles() {
		Map<String, String> files = new HashMap<String, String>();
		files.put("skeleton/java5/config/log4j.properties", "config/log4j.properties");
		files.put("skeleton/java5/config/workflow.oaw", "config/workflow.oaw");
		files.put("skeleton/java5/build.properties", "build.properties");
		return files;
	}

	public Set<String> getGeneratorDirectories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getProjectDirectories() {
		// TODO Auto-generated method stub
		return null;
	}
}
