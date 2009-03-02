package de.genesez.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlatformWizardRegistry {

	private List<IPlatformWizard> wizards = new ArrayList<IPlatformWizard>();
	
	public static final PlatformWizardRegistry INSTANCE = new PlatformWizardRegistry();
	
	private PlatformWizardRegistry() {
		// nothing to do here yet ;-)
	}
	
	public void add(IPlatformWizard w) {
		this.wizards.add(w);
	}
	
	public List<IPlatformWizard> getAll() {
		return Collections.unmodifiableList(this.wizards);
	}
}
