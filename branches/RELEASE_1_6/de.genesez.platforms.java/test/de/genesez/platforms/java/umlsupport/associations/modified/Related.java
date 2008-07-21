package de.genesez.platforms.java.umlsupport.associations.modified;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class Related implements RelatedAssociation {

	public enum Associations implements AssociationRole {
		BIDI_ONE_TO_ONE, BIDI_ONE_TO_MANY, BIDI_MANY_TO_MANY
	}
	
	private Map<AssociationRole, Association<? extends RelatedAssociation, ? extends RelatedAssociation>> association = new LinkedHashMap<AssociationRole, Association<? extends RelatedAssociation,? extends RelatedAssociation>>();
	{
		association.put(Associations.BIDI_ONE_TO_ONE, new OneAssociation<Related, Hub>(
				this, Hub.Associations.BIDI_ONE_TO_ONE));
		association.put(Associations.BIDI_ONE_TO_MANY, new OneAssociation<Related, Hub>(
				this, Hub.Associations.BIDI_ONE_TO_MANY));
		association.put(Associations.BIDI_MANY_TO_MANY, new ManyAssociation<Related, Hub>(
				this, new HashSet<Hub>(), Hub.Associations.BIDI_MANY_TO_MANY));
	}
	
	public Association<? extends RelatedAssociation, ? extends RelatedAssociation> getAssociation(
			AssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
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
