package de.genesez.platforms.dotnet.wizards;

import de.genesez.core.IPlatformWizard;

public class SharpDevelopWizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ .NET Platform for SharpDevelop";
	}

	public String getModel() {
		return "de/genesez/platforms/dotnet/wizards/sharpdevelop.project";
	}
}
