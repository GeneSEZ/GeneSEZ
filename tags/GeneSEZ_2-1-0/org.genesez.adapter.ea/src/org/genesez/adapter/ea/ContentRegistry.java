package org.genesez.adapter.ea;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;

/**
 * Collect non-identifiable elements created during model transformation
 * 
 * @author gerbe
 *
 * The ContentRegistry is used to collect elements without GUIDs during
 * the model transformation process.
 * Such elements are e.g. applications of stereotypes to elements.
 * The XmiWriter fetches these non-identifiable artifacts from the
 * ContentRegistry to add them to the output model. 
 */
public class ContentRegistry {

	private static final Log log = LogFactory.getLog(ContentRegistry.class);
	public static final ContentRegistry instance = new ContentRegistry();

	private Set<EObject> contents = new HashSet<EObject>(); 
	
	/**
	 * Just to make constructor private
	 */
	private ContentRegistry() {
		// nothing to do here ;-)
	}
	
	/**
	 * Initializes (or reset) the ContentRegistry
	 */
	public void initialize() {
		this.contents = new HashSet<EObject>();
	}
	
	/**
	 * Add an element to the ContentRegistry
	 * @param _e
	 */
	public void addContent(EObject _e) {
		this.contents.add(_e);
	}
	
	/**
	 * A Set containing all elements registered in the ContentRegistry
	 * @return
	 */
	public Set<EObject> getContents() {
		return this.contents;
	}

}
