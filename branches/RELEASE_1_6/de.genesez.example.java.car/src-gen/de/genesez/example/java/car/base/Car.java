package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945913718_872802_139) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A car is a vehicle with four wheels and drives on the road.
 * @author	dreamer
 */
public class Car extends AbstractVehicle implements AssociationRole {
	
	// -- generated attribute, constant + association declarations ----------
	public enum Associations implements RelatedAssociationRole {
		SPARE, LICENSE, LICENSEPLATE, ENGINE, WHEELS
	}
	
	/** holds the references to the association objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	{
		association.put(Associations.SPARE, new OneAssociation<Car, Wheel>(this));
		association.put(Associations.LICENSE, new OneAssociationAC<Car, License, Owner>(this, License.Associations.CAR));
		association.put(Associations.LICENSEPLATE, new OneAssociation<Car, LicensePlate>(this, LicensePlate.Associations.CAR));
		association.put(Associations.ENGINE, new OneAssociation<Car, Engine>(this, Engine.Associations.CAR));
		association.put(Associations.WHEELS, new ManyAssociation<Car, Wheel>(this, new LinkedHashSet<Wheel>(), Wheel.Associations.MYCAR));
	}
	/**
	 * documented here {@link getMaxSpeed()}
	 * @generated	attribute definition
	 */
	private Integer maxSpeed;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor of the class car
	 * @generated	constructor for class '<em><b>Car</b></em>'
	 * @param	mxs	maximum of speed
	 * @param	make	i don't know what make do
	 */
	public Car(int mxs, String make) {
		/* PROTECTED REGION ID(java.constructor._11_5_6340215_1179229080562_965427_117) ENABLED START */
		// TODO: implementation of constructor for class 'Car'
		throw new UnsupportedOperationException("The implementation of this generated constructor is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * starts the engine of the car and moves it to another place
	 * @generated	method stub for further implementation
	 * @param	distance	
	 * @return	starts the engine of the car and moves it to another place
	 * @throws	OutOfFuelException
	 * @throws	FlatTireException
	 */
	public boolean drive(Integer distance) throws OutOfFuelException, FlatTireException {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1215088972218_727597_762) ENABLED START */
		// TODO: implementation of method 'Car.drive(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * count the number of wheels
	 * @generated	getter for the attribute '<em><b>noOfWheels</b></em>'
	 */
	private Integer getNoOfWheels() {
		/* PROTECTED REGION ID(java.derived.attribute.implementation._11_5_6340215_1178786244296_257674_121) ENABLED START */
		// TODO: implementation of derived (calculated) attribute 'noOfWheels'
		throw new UnsupportedOperationException("The implementation of the derived attribute 'noOfWheels' is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * describes the maximum speed of a car
	 * 
	 * internal bla bla bla
	 * @generated	getter for the attribute '<em><b>maxSpeed</b></em>'
	 */
	public Integer getMaxSpeed() {
		return maxSpeed;
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
	 * reference to the spared wheel
	 * @generated	accessor of the association '<em><b>spare</b></em>' to {@link Wheel}
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Wheel> spare() {
		return (Association<Car, Wheel>) association.get(Associations.SPARE);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>license</b></em>' to {@link License}
	 */
	@SuppressWarnings("unchecked")
	public AssociationAC<Car, License, Owner> license() {
		return (AssociationAC<Car, License, Owner>) association.get(Associations.LICENSE);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>licensePlate</b></em>' to {@link LicensePlate}
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, LicensePlate> licensePlate() {
		return (Association<Car, LicensePlate>) association.get(Associations.LICENSEPLATE);
	}
	
	/** 
	 * @generated	accessor of the association '<em><b>engine</b></em>' to {@link Engine}
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Engine> engine() {
		return (Association<Car, Engine>) association.get(Associations.ENGINE);
	}
	
	/** 
	 * reference to normal wheels on a car
	 * @generated	accessor of the association '<em><b>wheels</b></em>' to {@link Wheel}
	 */
	@SuppressWarnings("unchecked")
	public Association<Car, Wheel> wheels() {
		return (Association<Car, Wheel>) association.get(Associations.WHEELS);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945913718_872802_139) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
