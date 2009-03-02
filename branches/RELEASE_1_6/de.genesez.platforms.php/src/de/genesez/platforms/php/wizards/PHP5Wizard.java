package de.genesez.platforms.php.wizards;

import java.util.HashSet;
import java.util.Set;

import de.genesez.core.IPlatformWizard;

public class PHP5Wizard implements IPlatformWizard {

	public String getName() {
		return "GeneSEZ PHP 5 Platform";
	}

	public Set<String> getBundles() {
		Set<String> bundles = new HashSet<String>();
		bundles.add("de.genesez.platforms.php;visibility:=reexport");
		return bundles;
	}
}
