package de.genesez.platforms.java.umlsupport.associations;

/**
 * additional operations for association class associations.
 * 
 * @author georg beier
 * 
 * @param <From>
 *            the from class
 * @param <To>
 *            the to class
 */
public interface AssociationAC<From, To, Assoc> extends
		Association<From, To> {
	/**
	 * insert associated object and association class object into the
	 * association.
	 * 
	 * @param associated
	 *            the newly associated object
	 * @param aco
	 *            the association class object
	 * @return associated
	 */
	To insert(To associated, Assoc aco);

	/**
	 * get the association class object
	 * 
	 * @param associated
	 *            the associated object
	 * @return the association class object
	 */
	Assoc getAssoc(To associated);

	/**
	 * set the association class object
	 * 
	 * @param associated
	 *            the associated object
	 * @param assoc
	 *            the new association class object
	 * @return the association class object
	 */
	Assoc setAssoc(To associated, Assoc assoc);
}
