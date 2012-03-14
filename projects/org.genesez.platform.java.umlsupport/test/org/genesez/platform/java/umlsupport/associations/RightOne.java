package org.genesez.platform.java.umlsupport.associations;

import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.OneAssociationAC;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

public class RightOne implements AssociationRole {
	
	public enum Associations implements RelatedAssociationRole {
		LEFT_SYM, BAD_NAME
	}
	
	private Map<Associations, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<Associations, Association<? extends AssociationRole, ? extends AssociationRole>>();
	{
		association.put(Associations.LEFT_SYM, new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				new Accessor<LeftOne>() {
					private LeftOne ref;
					public LeftOne get() {
						return ref;
					}
					public void set(LeftOne referenced) {
						ref = referenced;
					}
				}, new Accessor<Assoc>() {
					private Assoc associationClassObject;
					public Assoc get() {
						return associationClassObject;
					}
					public void set(Assoc referenced) {
						associationClassObject = referenced;
					}
				}, LeftOne.Associations.RIGHT_SYM));
		association.put(Associations.BAD_NAME, new OneAssociationAC<RightOne, LeftOne, Assoc>(this,
				new Accessor<LeftOne>() {
					private LeftOne ref;
					public LeftOne get() {
						return ref;
					}
					public void set(LeftOne referenced) {
						ref = referenced;
					}
				}, new Accessor<Assoc>() {
					private Assoc associationClassObject;
					public Assoc get() {
						return associationClassObject;
					}
					public void set(Assoc referenced) {
						associationClassObject = referenced;
					}
				}, LeftOne.Associations.BAD_NAME));
	}
	
	public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	public OneAssociationAC<RightOne, LeftOne, Assoc> getLeftSym() {
		return (OneAssociationAC<RightOne, LeftOne, Assoc>) association.get(Associations.LEFT_SYM);
	}
	
	public OneAssociationAC<RightOne, LeftOne, Assoc> getBadName() {
		return (OneAssociationAC<RightOne, LeftOne, Assoc>) association.get(Associations.BAD_NAME);
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
