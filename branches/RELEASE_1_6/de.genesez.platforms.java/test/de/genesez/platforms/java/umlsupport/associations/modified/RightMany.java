package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import de.genesez.platforms.java.umlsupport.associations.modified.LeftOne.Associations;

public class RightMany implements RelatedAssociation {
	
	public enum Associations implements AssociationRole {
		LEFT_SYM, LEFT_SYM_MANY
	}
	
	private Map<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>>();
	{
		association.put(Associations.LEFT_SYM, new OneAssociationAC<RightMany, LeftMany, Assoc>(this,
				LeftMany.Associations.RIGHT_SYM));
		association.put(Associations.LEFT_SYM_MANY, new ManyAssociationAC<RightMany, LeftMany, Assoc>(this,
				new HashMap<LeftMany, Assoc>(), LeftMany.Associations.RIGHT_MANY));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}

	
	/*
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
				"rightSym");
		leftSymMany = new ManyAssociationAC<RightMany, LeftMany, Assoc>(this,
				new HashMap<LeftMany, Assoc>(), "rightMany");
	}

//	@Override
	public Association<RightMany, LeftMany> getRelatedAssociation(
			String role) {
		if (role.equals("leftSym")) {
			return leftSym();
		} else if (role.equals("leftSymMany")) {
			return leftSymMany();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
