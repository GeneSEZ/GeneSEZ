package de.genesez.platforms.java.umlsupport.associations;

public interface AssociationRole {
	
	// sufficient accessor for the association handling library
	// for client code, an accessor for every association is generated
	/**
	 * generic accessor for all associations of a class
	 * @param <From>
	 * @param <To>
	 * @param role
	 * @return
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role);
	
	// other version which forces client code to define generic parameters for every method call
	// -> simply not useable
	//	Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
	//	hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
//	public <T> T getAssociation(RelatedAssociation role);
}
