package de.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_12_5_6340215_1182161482703_876307_352) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.OneAssociationAC;
import org.genesez.platform.java.umlsupport.associations.*;
import org.genesez.platform.java.umlsupport.associations.AssociationAC;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */
public class License implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association CAR to Car */
	private Car car;
	/** Stores the association class object of association CAR to Car */
	private Owner owner;
	
	private String registration;
	
	// -- generated association + attribute accessors -----------------------
	// initialization block for association management objects
	{
		association.put(Associations.CAR, new OneAssociationAC<License, Car, Owner>(this, new Accessor<Car>() {
			public Car get() {
				return car;
			}
			
			public void set(Car referenced) {
				car = referenced;
			}
		}, new Accessor<Owner>() {
			public Owner get() {
				return owner;
			}
			
			public void set(Owner referenced) {
				owner = referenced;
			}
		}, Car.Associations.LICENSE));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see de.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
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
	public AssociationAC<License, Car, Owner> car() {
		return (AssociationAC<License, Car, Owner>) association.get(Associations.CAR);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161482703_876307_352) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
