package org.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_11_5_6340215_1177945943625_542159_161) 
 */
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.example.java.car.base.parts.Screw;
import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.ManyAssociation;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Wheel implements IChangeable, AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		MYCAR, SCREW
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association MYCAR to Car */
	private Car mycar;
	
	/** Stores associated objects of association SCREW to Screw */
	private java.util.Set<Screw> screw = new java.util.HashSet<Screw>();
	
	private double diameter;
	
	private java.util.Set<String> specification = new java.util.HashSet<String>();
	
	private int durability = 100000;
	
	/**
	 * Method stub for further implementation.
	 * @throws	FlatTireException
	 */
	public void roll() throws FlatTireException {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 * @param	newInstance	
	 * @return	
	 */
	public boolean change(IChangeable newInstance) {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1177945943625_542159_161__11_5_6340215_1179139274500_389758_230) ENABLED START */
		// TODO: implementation of method 'Wheel.change(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.MYCAR, new OneAssociation<Wheel, Car>(this, new Accessor<Car>() {
			public Car get() {
				return mycar;
			}
			
			public void set(Car referenced) {
				mycar = referenced;
			}
		}, Car.Associations.WHEELS));
		association.put(Associations.SCREW, new ManyAssociation<Wheel, Screw>(this, screw));
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
	 * Provides access to the association '<em><b>mycar</b></em>' to {@link Car}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Car> mycar() {
		return (Association<Wheel, Car>) association.get(Associations.MYCAR);
	}
	
	/**
	 * Provides access to the association '<em><b>screw</b></em>' to {@link Screw}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Screw> screw() {
		return (Association<Wheel, Screw>) association.get(Associations.SCREW);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
