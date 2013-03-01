package de.genesez.platforms.dotnet.wizards;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.genesez.core.IPlatformWizard;

public class SharpDevelopWizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ .NET Platform for SharpDevelop";
	}

	public Set<String> getBundles() {
		Set<String> bundles = new HashSet<String>();
		bundles.add("de.genesez.platforms.dotnet;visibility:=reexport");
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
