package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;
import de.genesez.example.java.car.base.parts.Screw;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945943625_542159_161) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class Wheel implements IChangeable, AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		MYCAR, SCREW
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.MYCAR, new OneAssociation<Wheel, Car>(this, Car.Associations.WHEELS));
		association.put(Associations.SCREW, new ManyAssociation<Wheel, Screw>(this, new LinkedHashSet<Screw>()));
	}
	/**
	 * @generated	attribute definition
	 */
	private float diameter;
	/**
	 * @generated	attribute definition
	 */
	private java.util.Set<String> specification = new java.util.HashSet<String>();
	/**
	 * @generated	attribute definition
	 */
	private Integer durability = 100000;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * @generated	method stub for further implementation
	 * @param	newWheel	
	 * @return	
	 */
	public boolean change(IChangeable newWheel) {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179139054625_520706_1) ENABLED START */
		// TODO: implementation of method 'Wheel.change(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * @generated	method stub for further implementation
	 * @throws	FlatTireException
	 */
	public void roll() throws FlatTireException {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>diameter</b></em>'
	 */
	public float getDiameter() {
		return diameter;
	}
	
	public java.util.Set<String> getSpecification() {
		return specification;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>durability</b></em>'
	 */
	public Integer getDurability() {
		return durability;
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
	 * @generated	accessor of the association '<em><b>mycar</b></em>' to {@link Car}
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Car> mycar() {
		return (Association<Wheel, Car>) association.get(Associations.MYCAR);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>screw</b></em>' to {@link Screw}
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Screw> screw() {
		return (Association<Wheel, Screw>) association.get(Associations.SCREW);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
