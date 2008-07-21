package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.LinkedHashMap;
import java.util.Map;

import de.genesez.platforms.java.umlsupport.associations.modified.LeftMany.Associations;


public class LeftOne implements RelatedAssociation {
	
	public enum Associations implements AssociationRole {
		RIGHT, RIGHT_SYM, BAD_NAME
	}
	
	private Map<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>>();
	{
		association.put(Associations.RIGHT, new OneAssociationAC<LeftOne, RightOne, Assoc>(this));
		association.put(Associations.RIGHT_SYM, new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				RightOne.Associations.LEFT_SYM));
		association.put(Associations.BAD_NAME, new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				RightOne.Associations.BAD_NAME));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}

	/*
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
				"leftSym");
		badName = new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				"badName");
	}
	
//	@Override
	public Association<LeftOne, RightOne> getRelatedAssociation(
			String role) {
		
		if (role.equals("right")) {
			return right();
		} else if (role.equals("rightSym")) {
			return rightSym();
		} else if (role.equals("badName")) {
			return badName();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
