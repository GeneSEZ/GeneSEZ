package de.genesez.platforms.java.umlsupport.associations;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeftOne implements AssociationRole {
	
	public enum Associations implements RelatedAssociationRole {
		RIGHT, RIGHT_SYM, BAD_NAME
	}
	
	private Map<Associations, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<Associations, Association<? extends AssociationRole, ? extends AssociationRole>>();
	{
		association.put(Associations.RIGHT, new OneAssociationAC<LeftOne, RightOne, Assoc>(this, new Accessor<RightOne>() {
			private RightOne ref;
			public RightOne get() {
				return ref;
			}
			public void set(RightOne referenced) {
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
		}));
		association.put(Associations.RIGHT_SYM, new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				new Accessor<RightOne>() {
					private RightOne ref;
					public RightOne get() {
						return ref;
					}
					public void set(RightOne referenced) {
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
				}, RightOne.Associations.LEFT_SYM));
		// using wrong enum literals to specify association should cause runtime exception
		association.put(Associations.BAD_NAME, new OneAssociationAC<LeftOne, RightOne, Assoc>(this,
				new Accessor<RightOne>() {
					private RightOne ref;
					public RightOne get() {
						return ref;
					}
					public void set(RightOne referenced) {
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
				}, /*RightOne.*/ Associations.BAD_NAME));
	}
	
	public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	public OneAssociationAC<LeftOne, RightOne, Assoc> getRight() {
		return (OneAssociationAC<LeftOne, RightOne, Assoc>) association.get(Associations.RIGHT);
	}
	
	public OneAssociationAC<LeftOne, RightOne, Assoc> getRightSym() {
		return (OneAssociationAC<LeftOne, RightOne, Assoc>) association.get(Associations.RIGHT_SYM);
	}
	
	public OneAssociationAC<LeftOne, RightOne, Assoc> getBadName() {
		return (OneAssociationAC<LeftOne, RightOne, Assoc>) association.get(Associations.BAD_NAME);
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
