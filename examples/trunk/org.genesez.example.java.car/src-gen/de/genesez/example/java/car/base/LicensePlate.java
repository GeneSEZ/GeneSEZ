package de.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_12_5_8a7027a_1182165360608_205087_392) 
 */

import java.util.LinkedHashMap;
import java.util.Map;

import de.genesez.platforms.java.umlsupport.associations.*;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author domwet
 */
public class LicensePlate implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association CAR to Car */
	private Car car;
	
	private String key;
	
	// -- generated association + attribute accessors -----------------------
	// initialization block for association management objects
	{
		association.put(Associations.CAR, new OneAssociation<LicensePlate, Car>(this, new Accessor<Car>() {
			public Car get() {
				return car;
			}
			
			public void set(Car referenced) {
				car = referenced;
			}
		}));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * Provides access to the association '<em><b>car</b></em>' to {@link Car}.
	 */
	@SuppressWarnings("unchecked")
	public Association<LicensePlate, Car> car() {
		return (Association<LicensePlate, Car>) association.get(Associations.CAR);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165360608_205087_392) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
