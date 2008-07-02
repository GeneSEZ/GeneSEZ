/**
 * 
 */
package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashMap;
import java.util.Map;

/**
 * this class is to be placed in the association class.
 * 
 * @author georg beier
 * 
 */
public class ACLink {

	private Map<String, Object> links = new HashMap<String, Object>(2);

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
	public Object getAssociationEnd(String role) {
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
	protected void link(Object assocEnd, String role) {
		if (links.containsKey(role)
				&& !links.get(role).getClass().equals(assocEnd.getClass()))
			throw new RuntimeException(
					"Role names for association class associations have to be different");
		links.put(role, assocEnd);
	}

	/**
	 * remove association end reference for given role
	 * 
	 * @param role
	 *            the role to clear
	 */
	protected void clear(String role) {
		links.remove(role);
	}

}
