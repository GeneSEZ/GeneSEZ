package de.genesez.example.java.car.base;

import java.util.*;
import de.genesez.example.java.car.base.parts.Screw;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945943625_542159_161) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class Wheel implements Changeable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/**
	 * variable for association to Car
	 */
	private Car mycar;
	
	/**
	 * variable for association to Screw
	 */
	private java.util.Set screw = new java.util.HashSet();
	
	/**
	 * @generated	attribute definition
	 */
	private float diameter;
	/**
	 * @generated	attribute definition
	 */
	private java.util.Set specification = new java.util.HashSet();
	/**
	 * @generated	attribute definition
	 */
	private int durability = 100000;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * @generated	method stub for further implementation
	 * @param	newWheel	
	 * @return	
	 */
	public boolean change(Changeable newWheel) {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179139054625_520706_1) ENABLED START */
		// TODO: implementation of method 'Wheel.change(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/**
	 * @generated	method stub for further implementation
	 * @throws	FlatTireException
	 */
	public void roll() throws FlatTireException {
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */
		// TODO: implementation of method 'Wheel.roll(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	/**
	 * accessor for association to mycar
	 */
	public Car getMycar() {
		return mycar;
	}
	
	/**
	 * accessor for association to mycar
	 */
	public void setMycar(Car mycar) {
		this.mycar = mycar;
	}
	
	/**
	 * accessor for association to screw
	 */
	public java.util.Set getScrew() {
		return java.util.Collections.unmodifiableSet(screw);
	}
	
	/**
	 * accessor for association to screw
	 */
	public void insertInScrew(Screw screw) {
		if (this.screw.contains(screw)) {
			return;
		}
		this.screw.add(screw);
	}
	
	/**
	 * accessor for association to screw
	 */
	public void removeFromScrew(Screw screw) {
		if (!this.screw.contains(screw)) {
			return;
		}
		this.screw.remove(screw);
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
