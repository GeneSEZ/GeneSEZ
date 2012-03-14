package org.genesez.platform.java.umlsupport.associations;

import java.util.Collection;
import java.util.Iterator;

/**
 * principal type for all associations, defines a universal interface to deal
 * with all kinds of associations.
 * 
 * @author georg beier
 * 
 * @param <From>
 *            the from class
 * @param <To>
 *            the to class
 */
public interface Association<From, To> extends Iterable<To> {
	/**
	 * insert associated object into the association, if not already present.
	 * 
	 * @param associated
	 *            the newly associated object
	 * @return associated
	 */
	To insert(To associated);

	/**
	 * remove an associated object from the association, if present
	 * 
	 * @param associated
	 *            object to be removed
	 * @return the actually removed object or null
	 */
	To remove(To associated);

	/**
	 * in case of a to-one-association, return the associated object, otherwise
	 * return the first object that would be returned by iterator().next().
	 * 
	 * @return an (or the) associated object or null, if none exists
	 */
	To get();
	
	/**
	 * returns all associated objects as an unmodifiable collection
	 * 
	 * @return the associated objects or an empty collection
	 */
	Collection<To> getAll();
	
	/**
	 * get an iterator on all associated objects
	 * 
	 * @see java.lang.Iterable#iterator()
	 * @return an iterator on the associated objects, even if it is a to-one
	 *         association
	 */
	Iterator<To> iterator();
}
