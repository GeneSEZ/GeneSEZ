
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1179139182234_646597_164) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * @author	dreamer
 */
public  abstract class AbstractVehicle    {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getMake}
 */
	private   String make ;
/**
 * @generated	attribute definition
 * @see			{@link getState}
 */
	private   VehicleStatus state ;
	
	
	// -- generated method declarations -------------------------------------
	/**
	<!-- PROTECTED REGION ID(test._11_5_6340215_1179222625687_525666_120) START -->
	 * nothing
	 * @generated	method stub for further implementation
 * @param	distance	
 * @return	
 * @throws	WhatAMessException	
 * @throws	NotReallySeriousException	this is a comment; this is the second comment
	<!-- PROTECTED REGION END -->
	 */
	public   abstract
 boolean drive(				Integer distance 		) 	throws  WhatAMessException ,  NotReallySeriousException ;
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
/**
 * @generated	getter for the attribute '<em><b>make</b></em>'
 */
	public  
 String getMake() {
		return make;
	}
	
	
/**
 * @generated	getter for the attribute '<em><b>state</b></em>'
 */
	public  
 VehicleStatus getState() {
		return state;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1179139182234_646597_164) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

