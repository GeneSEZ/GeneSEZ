package de.genesez.adapter.ea;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;

public class ContentRegistry {

	private static final Log log = LogFactory.getLog(ContentRegistry.class);
	public static final ContentRegistry instance = new ContentRegistry();

	private Set<EObject> contents = new HashSet<EObject>(); 
	
	private ContentRegistry() {
		// nothing to do here ;-)
	}
	
	public void addContent(EObject _e) {
		this.contents.add(_e);
	}
	
	public Set<EObject> getContents() {
		return this.contents;
	}

}
