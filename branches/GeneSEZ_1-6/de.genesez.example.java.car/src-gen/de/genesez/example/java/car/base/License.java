package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._12_5_6340215_1182161482703_876307_352) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class License implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.CAR, new OneAssociationAC<License, Car, Owner>(this, Car.Associations.LICENSE));
	}
	/**
	 * @generated	attribute definition
	 */
	private String registration;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>registration</b></em>'
	 */
	public String getRegistration() {
		return registration;
	}
	
	/**
	 * generic accessor for association objects used by the association handling framework
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>car</b></em>' to {@link Car}
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<License, Car, Owner> car() {
		return (AssociationAC<License, Car, Owner>) association.get(Associations.CAR);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161482703_876307_352) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
