package org.genesez.platform.java.umlsupport.associations;

import org.genesez.platform.java.umlsupport.associations.ACLink;
import org.genesez.platform.java.umlsupport.associations.AssociationClass;


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
