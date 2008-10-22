package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Related implements AssociationRole {

	public enum Associations implements RelatedAssociationRole {
		BIDI_ONE_TO_ONE, BIDI_ONE_TO_MANY, BIDI_MANY_TO_MANY
	}
	
	private Map<RelatedAssociationRole, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends AssociationRole,? extends AssociationRole>>();
	{
		association.put(Associations.BIDI_ONE_TO_ONE, new OneAssociation<Related, Hub>(
				this, Hub.Associations.BIDI_ONE_TO_ONE));
		association.put(Associations.BIDI_ONE_TO_MANY, new OneAssociation<Related, Hub>(
				this, Hub.Associations.BIDI_ONE_TO_MANY));
		association.put(Associations.BIDI_MANY_TO_MANY, new ManyAssociation<Related, Hub>(
				this, new HashSet<Hub>(), Hub.Associations.BIDI_MANY_TO_MANY));
	}
	
	public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	public Association<Related, Hub> getBidiOneToOne() {
		return (Association<Related, Hub>) association.get(Associations.BIDI_ONE_TO_ONE);
	}
	
	public Association<Related, Hub> getBidiOneToMany() {
		return (Association<Related, Hub>) association.get(Associations.BIDI_ONE_TO_MANY);
	}
	
	public Association<Related, Hub> getBidiManyToMany() {
		return (Association<Related, Hub>) association.get(Associations.BIDI_MANY_TO_MANY);
	}
	
	
	// -- old stuff
	/*
	private Association<Related, Hub> hub1 = new OneAssociation<Related, Hub>(
			this, "rel2Sym");

	private Association<Related, Hub> hub2 = new OneAssociation<Related, Hub>(
			this, "m2one");

	private Association<Related, Hub> toHubs = new ManyAssociation<Related, Hub>(
			this, new HashSet<Hub>(), "m2m");

	public Association<Related, Hub> hub1() {
		return hub1;
	}

	public Association<Related, Hub> hub2() {
		return hub2;
	}

	public Association<Related, Hub> hubs() {
		return toHubs;
	}

	public Association<Related, Hub> getAssociation(String role) {
		if (role.equals("hub1")) {
			return hub1();
		} else if (role.equals("hub2")) {
			return hub2();
		} else if (role.equals("hubs")) {
			return hubs();
		}
		throw new RuntimeException("no getter method for association");
	}
	*/
}
