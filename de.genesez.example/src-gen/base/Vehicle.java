package base;

/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1179139182234_646597_164) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

/* <!-- PROTECTED REGION END --> */
/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * @author dreamer 
 */
public abstract class Vehicle {
	
	// ////////////////////////////////////////////////////////////////////////
	// generated variable, constant and association declarations
	// ////////////////////////////////////////////////////////////////////////
	
	private String make;
	private VehicleStatus state;
	
	// ////////////////////////////////////////////////////////////////////////
	// generated constructor implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated derived attribute method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated association method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated abstract method declaration
	// ////////////////////////////////////////////////////////////////////////
	
	/**
	 * nothing
	 * @param  speed  define the actual of speed of the vehicle
	 * @return  
	 * @throws  WhatAMessException  
	 * @throws  NotReallySeriousException  this is a comment; this is the second comment
	 */
	public abstract boolean drive(int speed) throws WhatAMessException, NotReallySeriousException;
	
	// ////////////////////////////////////////////////////////////////////////
	// generated normal method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated getter and setter method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String _make) {
		make = _make;
	}
	
	public VehicleStatus getState() {
		return state;
	}
	
	public void setState(VehicleStatus _state) {
		state = _state;
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// own implementations
	// ////////////////////////////////////////////////////////////////////////
	
	/* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1179139182234_646597_164) ENABLED START --> */
	/* <!-- TODO put your own implementation code here --> */
	/* <!-- PROTECTED REGION END --> */
}
