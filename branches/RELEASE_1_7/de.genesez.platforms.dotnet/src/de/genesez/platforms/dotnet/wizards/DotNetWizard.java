package de.genesez.platforms.dotnet.wizards;

import java.util.HashSet;
import java.util.Set;

import de.genesez.core.IPlatformWizard;

public class DotNetWizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ .NET Platform";
	}

	public Set<String> getBundles() {
		Set<String> bundles = new HashSet<String>();
		bundles.add("de.genesez.platforms.dotnet;visibility:=reexport");
		return bundles;
	}
}
