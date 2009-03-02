package de.genesez.platforms.java.wizards;

import java.util.HashSet;
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
}
