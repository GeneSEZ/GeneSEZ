package org.genesez.eclipse4.wizard.util.replace.simpel;

import java.util.HashSet;
import java.util.Set;

public class ReplacerHelper {
	private static Set<SimpleTextReplacer> availableReplacer = new HashSet<SimpleTextReplacer>();

	public static void addReplacer(SimpleTextReplacer replacer) {
		availableReplacer.add(replacer);
	}

	public static Set<SimpleTextReplacer> getAvailableReplacer() {
		return availableReplacer;
	}
	
	static {
		availableReplacer.add(new MWETextReplacer());
		availableReplacer.add(new DefaultTextReplacer());
	}
	
	private ReplacerHelper(){}
}
