package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * test class which has an association to another class to test the association handling
 * @author georg beier
 */
public class Hub implements AssociationRole {
	
	public enum Associations implements RelatedAssociationRole {
		UNI_TO_ONE, BIDI_ONE_TO_ONE, UNI_TO_MANY, BIDI_ONE_TO_MANY, BIDI_MANY_TO_MANY, UNI_TO_RELATED_WO_ASSOCIATIONS
	}
	
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object,? extends Object>>();
	{
		association.put(Associations.UNI_TO_ONE, new OneAssociation<Hub, Related>(this));
		association.put(Associations.BIDI_ONE_TO_ONE, new OneAssociation<Hub, Related>(this, Related.Associations.BIDI_ONE_TO_ONE));
		association.put(Associations.UNI_TO_MANY, new ManyAssociation<Hub, Related>(
				this, new HashSet<Related>()));
		association.put(Associations.BIDI_ONE_TO_MANY, new ManyAssociation<Hub, Related>(
				this, new HashSet<Related>(), Related.Associations.BIDI_ONE_TO_MANY));
		association.put(Associations.BIDI_MANY_TO_MANY, new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), Related.Associations.BIDI_MANY_TO_MANY));
		// test wrong declaration of an unidirectional association as a bidirectional, given a wrong inverse related association role
		association.put(Associations.UNI_TO_RELATED_WO_ASSOCIATIONS, new OneAssociation<Hub, RelatedWithoutAssociation>(this, Associations.UNI_TO_RELATED_WO_ASSOCIATIONS));
	}
	
	/**
	 * generic accessor for the association objects used by the framework
	 * 
	 * because the fact that generic getters will force you to use generic definitions or casts when
	 * accessing an association, there are also getter for each association directly
	 * 
	 * @see de.genesez.platforms.java.umlsupport.associations.modified.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(
			RelatedAssociationRole role) {
		if (association.containsKey(role)) return association.get(role);
		throw new RuntimeException("wrong association role specified");
	}
	
	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Association<Hub, Related> getUniToOne() {
		return (Association<Hub, Related>) association.get(Associations.UNI_TO_ONE);
	}
	
	@SuppressWarnings("unchecked")
	public Association<Hub, Related> getBidiOneToOne() {
		return (Association<Hub, Related>) association.get(Associations.BIDI_ONE_TO_ONE);
	}
	
	@SuppressWarnings("unchecked")
	public Association<Hub, Related> getUniToMany() {
		return (Association<Hub, Related>) association.get(Associations.UNI_TO_MANY);
	}
	
	@SuppressWarnings("unchecked")
	public Association<Hub, Related> getBidiOneToMany() {
		return (Association<Hub, Related>) association.get(Associations.BIDI_ONE_TO_MANY);
	}
	
	@SuppressWarnings("unchecked")
	public Association<Hub, Related> getBidiManyToMany() {
		return (Association<Hub, Related>) association.get(Associations.BIDI_MANY_TO_MANY);
	}
	
	@SuppressWarnings("unchecked")
	public Association<Hub, RelatedWithoutAssociation> getUniToRelatedWoAssociations() {
		return (Association<Hub, RelatedWithoutAssociation>) association.get(Associations.UNI_TO_RELATED_WO_ASSOCIATIONS);
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
