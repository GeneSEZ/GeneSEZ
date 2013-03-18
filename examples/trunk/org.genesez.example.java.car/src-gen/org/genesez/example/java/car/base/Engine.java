package org.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_12_5_8a7027a_1182165491328_680838_471) 
 */
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Engine implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		CAR
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association CAR to Car */
	private Car car;
	
	private byte ps;
	
	private String name;
	
	/**
	 * Returns the value of attribute '<em><b>ps</b></em>'.
	 */
	public byte getPs() {
		return ps;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	public String getName() {
		return name;
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.CAR, new OneAssociation<Engine, Car>(this, new Accessor<Car>() {
			public Car get() {
				return car;
			}
			
			public void set(Car referenced) {
				car = referenced;
			}
		}, Car.Associations.ENGINE));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
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
	public Association<Engine, Car> car() {
		return (Association<Engine, Car>) association.get(Associations.CAR);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
