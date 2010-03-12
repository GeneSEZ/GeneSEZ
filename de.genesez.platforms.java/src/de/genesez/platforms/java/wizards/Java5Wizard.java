package de.genesez.platforms.java.wizards;

import de.genesez.core.IPlatformWizard;

public class Java5Wizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ Java 5 Platform";
	}

	public String getModel() {
		return "de/genesez/platforms/java/wizards/java5.project";
	}
}
