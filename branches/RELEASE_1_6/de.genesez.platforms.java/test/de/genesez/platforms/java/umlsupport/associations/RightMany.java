package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RightMany implements AssociationRole {
	
	public enum Associations implements RelatedAssociationRole {
		LEFT_SYM, LEFT_SYM_MANY
	}
	
	private Map<Associations, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<Associations, Association<? extends AssociationRole, ? extends AssociationRole>>();
	{
		association.put(Associations.LEFT_SYM, new OneAssociationAC<RightMany, LeftMany, Assoc>(this,
				LeftMany.Associations.RIGHT_SYM));
		association.put(Associations.LEFT_SYM_MANY, new ManyAssociationAC<RightMany, LeftMany, Assoc>(this,
				new HashMap<LeftMany, Assoc>(), LeftMany.Associations.RIGHT_MANY));
	}
	
	public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	public OneAssociationAC<RightMany, LeftMany, Assoc> getLeftSym() {
		return (OneAssociationAC<RightMany, LeftMany, Assoc>) association.get(Associations.LEFT_SYM);
	}
	
	public ManyAssociationAC<RightMany, LeftMany, Assoc> getLeftSymMany() {
		return (ManyAssociationAC<RightMany, LeftMany, Assoc>) association.get(Associations.LEFT_SYM_MANY);
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
