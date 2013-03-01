package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class LicensePlate implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.CAR, new OneAssociation<LicensePlate, Car>(this, Car.Associations.LICENSEPLATE));
	}
	/**
	 * @generated	attribute definition
	 */
	private String key;
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>key</b></em>'
	 */
	public String getKey() {
		return key;
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
	public Association<LicensePlate, Car> car() {
		return (Association<LicensePlate, Car>) association.get(Associations.CAR);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
