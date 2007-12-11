package de.genesez.genesezmm.cpp.helper;

import genesezMM.MClassifier;
import genesezMM.MElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalVarProvider {

	private static final Map<String, List<MElement>> includeFilesPool = new HashMap<String, List<MElement>>();

	public static List<MElement> getIncludeFilesPool(MClassifier c) {
		List<MElement> l = includeFilesPool.get(c.getXmiGuid());
		if(l == null) {
			l = new ArrayList<MElement>();
			includeFilesPool.put(c.getXmiGuid(), l);
		}
		return l;
	}
}
