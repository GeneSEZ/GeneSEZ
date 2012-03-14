package org.genesez.platform.java.umlsupport.associations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationAC;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.ManyAssociationAC;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

public class LeftMany implements AssociationRole {
	
	public enum Associations implements RelatedAssociationRole {
		RIGHT, RIGHT_SYM, RIGHT_MANY
	}
	
	private Map<Associations, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<Associations, Association<? extends AssociationRole, ? extends AssociationRole>>();
	{
		association.put(Associations.RIGHT, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>()));
		association.put(Associations.RIGHT_SYM, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.Associations.LEFT_SYM));
		association.put(Associations.RIGHT_MANY, new ManyAssociationAC<LeftMany, RightMany, Assoc>(this,
				new HashMap<RightMany, Assoc>(), RightMany.Associations.LEFT_SYM_MANY));
	}
	
	public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	public AssociationAC<LeftMany, RightMany, Assoc> getRight() {
		return (AssociationAC<LeftMany, RightMany, Assoc>) association.get(Associations.RIGHT);
	}
	
	public AssociationAC<LeftMany, RightMany, Assoc> getRightSym() {
		return (AssociationAC<LeftMany, RightMany, Assoc>) association.get(Associations.RIGHT_SYM);
	}
	
	public AssociationAC<LeftMany, RightMany, Assoc> getRightMany() {
		return (AssociationAC<LeftMany, RightMany, Assoc>) association.get(Associations.RIGHT_MANY);
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
