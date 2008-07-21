package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LeftMany implements RelatedAssociation {
	
	public enum Associations implements AssociationRole {
		RIGHT, RIGHT_SYM, RIGHT_MANY
	}
	
	private Map<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<Associations, Association<? extends RelatedAssociation, ? extends RelatedAssociation>>();
	{
		association.put(Associations.RIGHT, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>()));
		association.put(Associations.RIGHT_SYM, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.Associations.LEFT_SYM));
		association.put(Associations.RIGHT_MANY, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.Associations.LEFT_SYM_MANY));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	/*
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
				new HashMap<RightMany, Assoc>(), "leftSym");
		rightMany = new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), "leftSymMany");
	}
	
//	@Override
	public Association<LeftMany, RightMany> getRelatedAssociation(
			String role) {
		if (role.equals("right")) {
			return right();
		} else if (role.equals("rightSym")) {
			return rightSym();
		} else if (role.equals("rightMany")) {
			return rightMany();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
