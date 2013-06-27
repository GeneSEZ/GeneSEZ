package de.genesez.example.java.car.base;

import java.util.*;

/* PROTECTED REGION ID(java.type.import._12_5_8a7027a_1181722156333_15747_346) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */
/**
 * state of a vehicle
 * @author	dreamer
 */
public class VehicleStatus implements Comparable {
	
	// -- enumeration literals ----------------------------------------------
	
	/**
	 * @generated	enumeration literal definition
	 */
	public static final VehicleStatus FORWARD = new VehicleStatus("FORWARD");
	/**
	 * @generated	enumeration literal definition
	 */
	public static final VehicleStatus STOP = new VehicleStatus("STOP");
	/**
	 * @generated	enumeration literal definition
	 */
	public static final VehicleStatus BACKWARD = new VehicleStatus("BACKWARD");
	
	// -- generated attribute, constant + association declarations ----------
	
	private final String name;
	// Assign an ordinal to this object
	private final int ordinal = nextOrdinal++;
	// Ordinal of next object to be created
	private static int nextOrdinal = 0;
	
	private VehicleStatus(String name) {
		this.name = name;
	}
	
	// -- generated method stubs for implementations ------------------------
	
	public String toString() {
		return this.name;
	}
	
	public int compareTo(Object o) {
		return ordinal - ((VehicleStatus) o).ordinal;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.enumeration.own.code.implementation._12_5_8a7027a_1181722156333_15747_346) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
