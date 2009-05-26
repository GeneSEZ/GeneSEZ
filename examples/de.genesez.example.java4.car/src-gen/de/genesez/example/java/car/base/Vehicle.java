package de.genesez.example.java.car.base;

import java.util.*;
import java.awt.Color;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1179139182234_646597_164) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * @author	nicher
 */
public abstract class Vehicle implements Paintable, Driveable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * @generated	attribute definition
	 */
	private String make;
	/**
	 * @generated	attribute definition
	 */
	private Color color;
	/**
	 * @generated	attribute definition
	 */
	private VehicleStatus state = VehicleStatus.STOP;
	
	// -- generated method declarations -------------------------------------
	/**
	 * @generated	method stub for further implementation
	 * @param	distance	
	 * @return	
	 * @throws	OutOfFuelException
	 * @throws	FlatTireException
	 */
	public abstract boolean drive(Integer distance) throws OutOfFuelException, FlatTireException;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * @generated	method stub for further implementation
	 * @param	color	
	 * @return	
	 */
	public Color repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1215089083984_451860_771) ENABLED START */
		// TODO: implementation of method 'Vehicle.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>make</b></em>'
	 */
	public String getMake() {
		return make;
	}
	
	/**
	 * documented here {@link getMake()}
	 * @generated	setter method for the attribute '<em><b>make</b></em>'
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>color</b></em>'
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * documented here {@link getColor()}
	 * @generated	setter method for the attribute '<em><b>color</b></em>'
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>state</b></em>'
	 */
	public VehicleStatus getState() {
		return state;
	}
	
	/**
	 * documented here {@link getState()}
	 * @generated	setter method for the attribute '<em><b>state</b></em>'
	 */
	public void setState(VehicleStatus state) {
		this.state = state;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1179139182234_646597_164) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
