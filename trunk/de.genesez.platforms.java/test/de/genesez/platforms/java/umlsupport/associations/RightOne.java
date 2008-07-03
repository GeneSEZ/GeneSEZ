package de.genesez.platforms.java.umlsupport.associations;

import de.genesez.platforms.java.umlsupport.associations.AssociationAC;
import de.genesez.platforms.java.umlsupport.associations.OneAssociationAC;

public class RightOne {
	private AssociationAC<RightOne, LeftOne, Assoc> leftSym;

	private AssociationAC<RightOne, LeftOne, Assoc> badName;

	public AssociationAC<RightOne, LeftOne, Assoc> leftSym() {
		return leftSym;
	}

	public AssociationAC<RightOne, LeftOne, Assoc> badName() {
		return badName;
	}

	public RightOne() {
		leftSym = new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				LeftOne.class, "rightSym");
		badName = new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				LeftOne.class, "badName");
	}

}
