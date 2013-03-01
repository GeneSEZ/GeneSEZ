package de.genesez.platforms.java.wizards;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.genesez.core.IPlatformWizard;

public class Java4Wizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ Java 1.4 Platform";
	}

	public Set<String> getBundles() {
		Set<String> bundles = new HashSet<String>();
		bundles.add("de.genesez.platforms.java;visibility:=reexport");
		return bundles;
	}

	public Set<String> getGeneratorDirectories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getGeneratorFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getProjectDirectories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, String> getProjectFiles() {
		// TODO Auto-generated method stub
		return null;
	}
}
