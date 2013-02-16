package org.genesez.example.java.car.base;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_11_5_6340215_1179139182234_646597_164) 
 */
import java.awt.Color;

/**
 * This abstract class Vehicle is the superclass for all things that can drive (for example: car, boat, air plane, ...).
 */
public abstract class AbstractVehicle implements IDriveable, IPaintable {
	
	private String make;
	
	private Color color;
	
	private VehicleStatus state = VehicleStatus.STOP;
	
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1179139182234_646597_164) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
