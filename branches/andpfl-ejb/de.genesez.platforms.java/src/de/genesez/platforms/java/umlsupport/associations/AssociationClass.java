/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

/**
 * Interface to be implemented by all association classes. Specifies a getter
 * method to access the association implementation.
 * 
 * @author georg beier
 * 
 */
public interface AssociationClass {

	/**
	 * get the link object that links to the association ends
	 * 
	 * @return link object
	 */
	ACLink getAssociationClassLink();
}
