package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashMap;

import de.genesez.platforms.java.umlsupport.associations.AssociationAC;
import de.genesez.platforms.java.umlsupport.associations.ManyAssociationAC;
import de.genesez.platforms.java.umlsupport.associations.OneAssociationAC;

public class RightMany {
	private AssociationAC<RightMany, LeftMany, Assoc> leftSym;
	private AssociationAC<RightMany, LeftMany, Assoc> leftSymMany;

	public AssociationAC<RightMany, LeftMany, Assoc> leftSym() {
		return leftSym;
	}
	public AssociationAC<RightMany, LeftMany, Assoc> leftSymMany() {
		return leftSymMany;
	}

	public RightMany() {
		leftSym = new OneAssociationAC<RightMany, LeftMany, Assoc>(this,
				LeftMany.class, "rightSym");
		leftSymMany = new ManyAssociationAC<RightMany, LeftMany, Assoc>(this,
				new HashMap<LeftMany, Assoc>(), LeftMany.class, "rightMany");
	}

}
