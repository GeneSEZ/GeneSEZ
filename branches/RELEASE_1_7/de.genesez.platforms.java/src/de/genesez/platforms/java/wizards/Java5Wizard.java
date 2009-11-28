package de.genesez.platforms.java.wizards;

import java.util.HashSet;
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
}
