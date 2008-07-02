package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashMap;

import de.genesez.platforms.java.umlsupport.associations.AssociationAC;
import de.genesez.platforms.java.umlsupport.associations.ManyAssociationAC;

public class LeftMany {
	private AssociationAC<LeftMany, RightMany, Assoc> right;
	private AssociationAC<LeftMany, RightMany, Assoc> rightSym;
	private AssociationAC<LeftMany, RightMany, Assoc> rightMany;

	public AssociationAC<LeftMany, RightMany, Assoc> right() {
		return right;
	}

	public AssociationAC<LeftMany, RightMany, Assoc> rightSym() {
		return rightSym;
	}

	public AssociationAC<LeftMany, RightMany, Assoc> rightMany() {
		return rightMany;
	}

	public LeftMany() {
		right = new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>());
		rightSym = new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.class, "leftSym");
		rightMany = new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.class, "leftSymMany");
	}
}
