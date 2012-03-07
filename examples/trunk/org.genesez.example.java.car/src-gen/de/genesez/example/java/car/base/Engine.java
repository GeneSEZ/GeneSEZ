package de.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_12_5_8a7027a_1182165491328_680838_471) 
 */

import java.util.LinkedHashMap;
import java.util.Map;
import de.genesez.platforms.java.umlsupport.associations.Association;
import de.genesez.platforms.java.umlsupport.associations.OneAssociation;
import de.genesez.platforms.java.umlsupport.associations.Accessor;
import de.genesez.platforms.java.umlsupport.associations.*;
import de.genesez.platforms.java.umlsupport.associations.AssociationRole;
import de.genesez.platforms.java.umlsupport.associations.RelatedAssociationRole;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */
public class Engine implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
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
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>ps</b></em>'
	 */
	public byte getPs() {
		return ps;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'
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
	public Association<Engine, Car> car() {
		return (Association<Engine, Car>) association.get(Associations.CAR);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165491328_680838_471) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
