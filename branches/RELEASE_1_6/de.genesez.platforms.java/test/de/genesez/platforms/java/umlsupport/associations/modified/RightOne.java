package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.LinkedHashMap;
import java.util.Map;

import de.genesez.platforms.java.umlsupport.associations.modified.RightMany.Associations;


public class RightOne implements RelatedAssociation {
	
	public enum Associations implements AssociationRole {
		LEFT_SYM, BAD_NAME
	}
	
	private Map<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>>();
	{
		association.put(Associations.LEFT_SYM, new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				LeftOne.Associations.RIGHT_SYM));
		association.put(Associations.BAD_NAME, new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				LeftOne.Associations.BAD_NAME));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	/*
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
				"rightSym");
		badName = new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				"badName");
	}

//	@Override
	public Association<RightOne, LeftOne> getRelatedAssociation(
			String role) {
		
		if (role.equals("leftSym")) {
			return leftSym();
		} else if (role.equals("badName")) {
			return badName();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
