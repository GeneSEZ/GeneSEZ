package de.genesez.example.java.car.base;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945913718_872802_139) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * A car is a vehicle with four wheels and drives on the road.
 * @author	dreamer
 */
public class Car extends Vehicle {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * variable for association to Wheel
	 */
	private Wheel spare;
	
	/**
	 * variable for association to License
	 */
	
	/**
	 * variable for association to LicensePlate
	 */
	private LicensePlate licensePlate;
	
	/**
	 * variable for association to Engine
	 */
	private Engine engine;
	
	/**
	 * variable for association to Wheel
	 */
	private java.util.Set wheels = new java.util.HashSet();
	
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
	 * accessor for association to spare
	 * reference to the spared wheel
	 */
	public Wheel getSpare() {
		return spare;
	}
	
	/**
	 * accessor for association to spare
	 * @see {@link getSpare}
	 */
	public void setSpare(Wheel spare) {
		this.spare = spare;
	}
	
	/**
	 * accessor for association to licensePlate
	 */
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}
	
	/**
	 * accessor for association to licensePlate
	 */
	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	/**
	 * accessor for association to engine
	 */
	public Engine getEngine() {
		return engine;
	}
	
	/**
	 * accessor for association to engine
	 */
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	/**
	 * accessor for association to wheels
	 * reference to normal wheels on a car
	 */
	public java.util.Set getWheels() {
		return java.util.Collections.unmodifiableSet(wheels);
	}
	
	/**
	 * accessor for association to wheels
	 * @see {@link getWheels}
	 */
	public void insertInWheels(Wheel wheels) {
		if (this.wheels.contains(wheels)) {
			return;
		}
		this.wheels.add(wheels);
		wheels.setMycar(this);
	}
	
	/**
	 * accessor for association to wheels
	 * @see {@link getWheels}
	 */
	public void removeFromWheels(Wheel wheels) {
		if (!this.wheels.contains(wheels)) {
			return;
		}
		this.wheels.remove(wheels);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945913718_872802_139) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
