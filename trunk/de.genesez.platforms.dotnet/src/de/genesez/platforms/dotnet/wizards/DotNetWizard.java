package de.genesez.platforms.dotnet.wizards;

import de.genesez.core.IPlatformWizard;

public class DotNetWizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ .NET Platform for Visual Studio 2008";
	}

	public String getModel() {
		return "de/genesez/platforms/dotnet/wizards/vs2008.project";
	}
	
}
