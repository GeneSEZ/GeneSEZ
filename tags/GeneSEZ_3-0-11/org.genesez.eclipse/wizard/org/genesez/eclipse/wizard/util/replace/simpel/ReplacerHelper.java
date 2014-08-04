/*
 * (c) GeneSEZ Research Group <genesez@fh-zwickau.de>
 * All rights reserved.
 * 
 * Licensed according to GeneSEZ License Terms <http://www.genesez.org/en/license>
 */
package org.genesez.eclipse.wizard.util.replace.simpel;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Dominik Wetzel <dominik.wetzel@fh-zwickau.de> (maintainer)
 *
 */
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
