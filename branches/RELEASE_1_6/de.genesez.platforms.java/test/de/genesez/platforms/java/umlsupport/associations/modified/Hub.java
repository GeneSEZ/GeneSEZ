package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hub implements RelatedAssociation {
	
	public enum Associations implements AssociationRole {
		UNI_TO_ONE, BIDI_ONE_TO_ONE, UNI_TO_MANY, BIDI_ONE_TO_MANY, BIDI_MANY_TO_MANY
	}
	
	private Map<AssociationRole, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<AssociationRole, Association<? extends RelatedAssociation,? extends RelatedAssociation>>();
	{
		association.put(Associations.UNI_TO_ONE, new OneAssociation<Hub, Related>(this));
		association.put(Associations.BIDI_ONE_TO_ONE, new OneAssociation<Hub, Related>(this, Related.Associations.BIDI_ONE_TO_ONE));
		association.put(Associations.UNI_TO_MANY, new ManyAssociation<Hub, Related>(
				this, new HashSet<Related>()));
		association.put(Associations.BIDI_ONE_TO_MANY, new ManyAssociation<Hub, Related>(
				this, new HashSet<Related>(), Related.Associations.BIDI_ONE_TO_MANY));
		association.put(Associations.BIDI_MANY_TO_MANY, new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), Related.Associations.BIDI_MANY_TO_MANY));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	
	// -- old stuff
	/*
	private Association<Hub, Related> rel1 = new OneAssociation<Hub, Related>(
			this);
	private Association<Hub, Related> rel2Sym = new OneAssociation<Hub, Related>(
			this, "hub1");

	private Association<Hub, Related> m1 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>());

	private Association<Hub, Related> m2 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), "hub2");

	private Association<Hub, Related> m3 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), "hubs");

	public Association<Hub, Related> rel1() {
		return rel1;
	}

	public Association<Hub, Related> rel2Sym() {
		return rel2Sym;
	}

	public Association<Hub, Related> m1() {
		return m1;
	}

	public Association<Hub, Related> m2one() {
		return m2;
	}

	public Association<Hub, Related> m2m() {
		return m3; 
	}

	public Association<Hub, Related> getRelatedAssociation(String role) {
		if (role.equals("rel2Sym")) {
			return rel2Sym();
		} else if (role.equals("m2one")) {
			return m2one();
		} else if (role.equals("m2m")) {
			return m2m();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
