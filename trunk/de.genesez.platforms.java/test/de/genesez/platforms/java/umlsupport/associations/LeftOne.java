package de.genesez.platforms.java.umlsupport.associations;

import de.genesez.platforms.java.umlsupport.associations.AssociationAC;
import de.genesez.platforms.java.umlsupport.associations.OneAssociationAC;

public class LeftOne {
	private AssociationAC<LeftOne, RightOne, Assoc> right;
	private AssociationAC<LeftOne, RightOne, Assoc> rightSym;
	private AssociationAC<LeftOne, RightOne, Assoc> badName;

	public AssociationAC<LeftOne, RightOne, Assoc> right() {
		return right;
	}

	public AssociationAC<LeftOne, RightOne, Assoc> rightSym() {
		return rightSym;
	}

	public AssociationAC<LeftOne, RightOne, Assoc> badName() {
		return badName;
	}

	public LeftOne() {
		right = new OneAssociationAC<LeftOne, RightOne, Assoc>(this);
		rightSym = new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				RightOne.class, "leftSym");
		badName = new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				RightOne.class, "badName");
	}
}
