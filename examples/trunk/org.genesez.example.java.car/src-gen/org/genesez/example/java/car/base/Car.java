package org.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_11_5_6340215_1177945913718_872802_139) 
 */
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationAC;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.ManyAssociation;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.OneAssociationAC;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

/**
 * A car is a vehicle with four wheels and drives on the road.
 */
public class Car extends AbstractVehicle implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		SPARE, LICENSE, LICENSEPLATE, ENGINE, WHEELS
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the associated object of association SPARE to Wheel */
	private Wheel spare;
	
	/** Stores the associated object of association LICENSE to License */
	private License license;
	/** Stores the association class object of association LICENSE to License */
	private Owner owner;
	
	/** Stores the associated object of association LICENSEPLATE to LicensePlate */
	private LicensePlate licensePlate;
	
	/** Stores the associated object of association ENGINE to Engine */
	private Engine engine;
	
	/** Stores associated objects of association WHEELS to Wheel */
	private java.util.Set<Wheel> wheels = new java.util.HashSet<Wheel>();
	
	/**
	 * describes the maximum speed of a car
	 * 
	 * internal bla bla bla
	 */
	private int maxSpeed;
	
	/**
	 * constructor of the class car
	 * @param	mxs	maximum of speed
	 * @param	make	i don't know what make do
	 */
	public Car(int mxs, String make) {
		/* PROTECTED REGION ID(java.constructor._11_5_6340215_1179229080562_965427_117) ENABLED START */
		super();
		maxSpeed = mxs;
		/* PROTECTED REGION END */
	}
	
	/**
	 * starts the engine of the car and moves it to another place
	 * @param	distance	
	 * @return	true, if the car arrived successfully, otherwise false
	 * @throws	OutOfFuelException
	 * @throws	FlatTireException
	 */
	public boolean drive(int distance) throws OutOfFuelException, FlatTireException {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1215088972218_727597_762) ENABLED START */
		// TODO: implementation of method 'Car.drive(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * describes the maximum speed of a car
	 * 
	 * internal bla bla bla
	 * @return	
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	/**
	 * count the number of wheels
	 */
	private int getNoOfWheels() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._11_5_6340215_1178786244296_257674_121) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'noOfWheels'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'noOfWheels' is missing!");
		/* PROTECTED REGION END */
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.SPARE, new OneAssociation<Car, Wheel>(this, new Accessor<Wheel>() {
			public Wheel get() {
				return spare;
			}
			
			public void set(Wheel referenced) {
				spare = referenced;
			}
		}));
		association.put(Associations.LICENSE, new OneAssociationAC<Car, License, Owner>(this, new Accessor<License>() {
			public License get() {
				return license;
			}
			
			public void set(License referenced) {
				license = referenced;
			}
		}, new Accessor<Owner>() {
			public Owner get() {
				return owner;
			}
			
			public void set(Owner referenced) {
				owner = referenced;
			}
		}, License.Associations.CAR));
		association.put(Associations.LICENSEPLATE, new OneAssociation<Car, LicensePlate>(this, new Accessor<LicensePlate>() {
			public LicensePlate get() {
				return licensePlate;
			}
			
			public void set(LicensePlate referenced) {
				licensePlate = referenced;
			}
		}, LicensePlate.Associations.CAR));
		association.put(Associations.ENGINE, new OneAssociation<Car, Engine>(this, new Accessor<Engine>() {
			public Engine get() {
				return engine;
			}
			
			public void set(Engine referenced) {
				engine = referenced;
			}
		}, Engine.Associations.CAR));
		association.put(Associations.WHEELS, new ManyAssociation<Car, Wheel>(this, wheels, Wheel.Associations.MYCAR));
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
	 * reference to the spared wheel
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Wheel> spare() {
		return (Association<Car, Wheel>) association.get(Associations.SPARE);
	}
	
	/**
	 * Provides access to the association '<em><b>license</b></em>' to {@link License}.
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<Car, License, Owner> license() {
		return (AssociationAC<Car, License, Owner>) association.get(Associations.LICENSE);
	}
	
	/**
	 * Provides access to the association '<em><b>licensePlate</b></em>' to {@link LicensePlate}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, LicensePlate> licensePlate() {
		return (Association<Car, LicensePlate>) association.get(Associations.LICENSEPLATE);
	}
	
	/**
	 * Provides access to the association '<em><b>engine</b></em>' to {@link Engine}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Engine> engine() {
		return (Association<Car, Engine>) association.get(Associations.ENGINE);
	}
	
	/**
	 * reference to normal wheels on a car
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Wheel> wheels() {
		return (Association<Car, Wheel>) association.get(Associations.WHEELS);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945913718_872802_139) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
