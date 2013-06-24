package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;
import de.genesez.example.java.car.base.parts.Screw;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945943625_542159_161) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

public class Wheel implements IChangeable, AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	/** defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		MYCAR, SCREW
	}
	
	/** stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** stores the associated object of association MYCAR to Car */
	private Car mycar;
	
	/** stores associated objects of association SCREW to Screw */
	private java.util.Set<Screw> screw = new java.util.HashSet<Screw>();
	
	private float diameter;
	
	private java.util.Set<String> specification = new java.util.HashSet<String>();
	
	private Integer durability = 100000;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
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
	 * method stub for further implementation
	 * @throws	FlatTireException
	 */
	public void roll() throws FlatTireException {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
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
	 * provides generic access to association objects, used by the association handling library
	 * @see de.genesez.platforms.java.umlsupport.associations.AssociationRole#getAssociation(de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/** 
	 * provides access to the association '<em><b>mycar</b></em>' to {@link Car}
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Car> mycar() {
		return (Association<Wheel, Car>) association.get(Associations.MYCAR);
	}
	
	/** 
	 * provides access to the association '<em><b>screw</b></em>' to {@link Screw}
	 */
	@SuppressWarnings("unchecked")
	public Association<Wheel, Screw> screw() {
		return (Association<Wheel, Screw>) association.get(Associations.SCREW);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
