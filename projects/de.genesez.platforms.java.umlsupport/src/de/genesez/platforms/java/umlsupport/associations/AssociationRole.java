package de.genesez.platforms.java.umlsupport.associations;

/**
 * Indicates the implementing class as a class with associations
 * @author dreamer
 */
public interface AssociationRole {
	
	// sufficient accessor for the association handling library
	// for client code, an accessor for every association is generated
	/**
	 * provides generic access to all associations of a class (needed by the association handling library)
	 * @param role	the enumeration literal identifying the association to access
	 * @return		an association object
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role);
	
	// other version which forces client code to define generic parameters for every method call
	// -> simply not useable
	//	Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
	//	hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
//	public <T> T getAssociation(RelatedAssociation role);
}
