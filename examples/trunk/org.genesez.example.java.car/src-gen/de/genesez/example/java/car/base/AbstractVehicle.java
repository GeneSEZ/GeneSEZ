package de.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_11_5_6340215_1179139182234_646597_164) 
 */

import de.genesez.platforms.java.umlsupport.associations.*;
import java.awt.Color;

/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 * @author apflueger
 */
public abstract class AbstractVehicle implements IDriveable, IPaintable {
	
	// -- generated attribute, constant + association declarations ----------
	
	private String make;
	
	private Color color;
	
	private VehicleStatus state = VehicleStatus.STOP;
	
	// -- generated method declarations -------------------------------------
	/**
	 * Method stub for further implementation.
	 * @param	distance	
	 * @return	
	 * @throws	OutOfFuelException
	 * @throws	FlatTireException
	 */
	public abstract boolean drive(Integer distance) throws OutOfFuelException, FlatTireException;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @param	color	
	 * @return	
	 */
	public Color repaint(Color color) {
		/* PROTECTED REGION ID(java.implementation._14_0_b6f02e1_1215089083984_451860_771) ENABLED START */
		// TODO: implementation of method 'AbstractVehicle.repaint(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1179139182234_646597_164) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
