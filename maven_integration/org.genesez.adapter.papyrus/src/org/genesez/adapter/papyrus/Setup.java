package org.genesez.adapter.papyrus;

import java.net.URL;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;

public class Setup {
	
	public Setup() {
		String p = "/genesez.profile.uml";
		URL url = getClass().getResource(p);
		if (url != null) {
			URIConverter.URI_MAP.put(URI.createURI("pathmap://GENESEZ_PROFILES" + p), URI.createURI(url.toString()));
		}
	}
}
