/**
 * 
 */
package org.genesez.platform.java.umlsupport.associations;

import java.util.HashMap;
import java.util.Map;

/**
 * this class is to be placed in the association class.
 * 
 * @author georg beier
 * 
 */
public class ACLink {

	private Map<RelatedAssociationRole, Object> links = new HashMap<RelatedAssociationRole, Object>(2);

	/**
	 * get the association end for a role name. this method cannot use a
	 * template type because
	 * <ol>
	 * <li> associations could link objects of the same class, so the ends
	 * cannot be distinguished by their types</li>
	 * <li>type parameters are not accessible at runtime</li>
	 * </ol>
	 * 
	 * @param role
	 *            name of the role, identifies side of the association
	 * @return association end at named role
	 */
	public Object getAssociationEnd(RelatedAssociationRole role) {
		return links.get(role);
	}

	/**
	 * register an association end at the association class object
	 * 
	 * @param assocEnd
	 *            the object at the association end
	 * @param role
	 *            the role name of the association end
	 */
	protected void link(Object assocEnd, RelatedAssociationRole role) {
		// the following code cannot be reached anymore, because it is shielded by
		// the generic accessor method for the association in each class which has associations
//		if (links.containsKey(role)
//				&& !links.get(role).getClass().equals(assocEnd.getClass()))
//			throw new RuntimeException(
//					"Role names for association class associations have to be different");
		links.put(role, assocEnd);
	}

	/**
	 * remove association end reference for given role
	 * 
	 * @param role
	 *            the role to clear
	 */
	protected void clear(RelatedAssociationRole role) {
		links.remove(role);
	}
}
