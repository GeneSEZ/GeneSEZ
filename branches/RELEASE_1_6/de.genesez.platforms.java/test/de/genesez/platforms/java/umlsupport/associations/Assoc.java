package de.genesez.platforms.java.umlsupport.associations.modified;


public class Assoc implements AssociationClass {
	private ACLink link = new ACLink();

	/* (non-Javadoc)
	 * @see de.genesez.umlsupport.AssociationClass#getAssociationClassLink()
	 */
//	@Override
	public ACLink getAssociationClassLink() {
		return link;
	}

}
