package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866873976_88694_1900) 
 */

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;

/**
 * Collect non-identifiable elements created during model transformation
 * 
 * The ContentRegistry is used to collect elements without GUIDs during the
 * model transformation process.Such elements are e.g. applications of
 * stereotypes to elements. The XmiWriter fetches these non-identifiable
 * artifacts from the ContentRegistry to add them to the output model. 
 * @author christian
 */

public class ContentRegistry {
	
	// -- generated attribute, constant + association declarations ----------
	
	public static final ContentRegistry INSTANCE = new ContentRegistry();
	
	private java.util.Set<EObject> contents = new java.util.HashSet<EObject>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Just to make constructor private
	 */
	
	private ContentRegistry() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363096931356_893989_2134) ENABLED START */
		
		// may be empty
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Initializes (or reset) the ContentRegistry
	 */
	
	public void initialize() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363097285551_740297_2141) ENABLED START */
		this.contents = new HashSet<EObject>();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Add an element to the ContentRegistry
	 * @param	e	
	 */
	
	public void addContent(EObject e) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363097630979_641199_2157) ENABLED START */
		this.contents.add(e);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>INSTANCE</b></em>'
	 */
	public static final ContentRegistry getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Returns the value of attribute '<em><b>contents</b></em>'
	 */
	public java.util.Set<EObject> getContents() {
		return contents;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866873976_88694_1900) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
