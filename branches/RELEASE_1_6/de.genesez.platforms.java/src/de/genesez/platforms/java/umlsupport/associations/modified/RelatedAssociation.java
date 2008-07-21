package de.genesez.platforms.java.umlsupport.associations.modified;

public interface RelatedAssociation {
//	public <From extends RelatedAssociation, To extends RelatedAssociation> Association<From, To> getAssociation(AssociationRole role);
//	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(AssociationRole role);
	public <T> T getAssociation(AssociationRole role);
}
