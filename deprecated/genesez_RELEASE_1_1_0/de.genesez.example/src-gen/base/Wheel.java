package base;

/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_11_5_6340215_1177945943625_542159_161) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import base.parts.Screw;

/* <!-- PROTECTED REGION END --> */
/**
 * @author dreamer 
 */
public class Wheel implements Changeable {
	
	// ////////////////////////////////////////////////////////////////////////
	// generated variable, constant and association declarations
	// ////////////////////////////////////////////////////////////////////////
	
	private float diameter;
	private java.util.Set<String> specification = new java.util.HashSet<String>();
	/**
	 * variable for association to mycar
	 */
	private Car mycar;
	/**
	 * variable for association to screw
	 */
	private java.util.Set<Screw> screw = new java.util.HashSet<Screw>();
	
	// ////////////////////////////////////////////////////////////////////////
	// generated constructor implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated derived attribute method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated association method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	/**
	 * accessor for association to mycar
	 */
	public Car getMycar() {
		return mycar;
	}
	
	/**
	 * accessor for association to mycar
	 */
	public void insertInMycar(Car _in) {
		if (mycar == _in) {
			return;
		}
		if (mycar != null) {
			mycar.removeFromWheels(this);
		}
		mycar = _in;
		_in.insertInWheels(this);
	}
	
	/**
	 * accessor for association to mycar
	 */
	public void removeFromMycar(Car _ex) {
		if (mycar != _ex) {
			return;
		}
		mycar = null;
		_ex.removeFromWheels(this);
	}
	
	/**
	 * accessor for association to screw
	 */
	public java.util.Set<Screw> getScrew() {
		return java.util.Collections.unmodifiableSet(screw);
	}
	
	/**
	 * accessor for association to screw
	 */
	public void insertInScrew(Screw _in) {
		if (screw.contains(_in)) {
			return;
		}
		screw.add(_in);
	}
	
	/**
	 * accessor for association to screw
	 */
	public void removeFromScrew(Screw _ex) {
		if (!screw.contains(_ex)) {
			return;
		}
		screw.remove(_ex);
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// generated abstract method declaration
	// ////////////////////////////////////////////////////////////////////////
	
	// ////////////////////////////////////////////////////////////////////////
	// generated normal method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param  newWheel  
	 * @return  
	 */
	public boolean change(Changeable newWheel) {
		Boolean returnValue = null;
		/* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179139054625_520706_1) ENABLED START --> */
		/* <!-- TODO put your own implementation code here --> */
		/* <!-- PROTECTED REGION END --> */
		return returnValue;
	}
	
	/**
	 */
	public void roll() {
		
		/* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._11_5_6340215_1179238960437_25222_122) ENABLED START --> */
		/* <!-- TODO put your own implementation code here --> */
		/* <!-- PROTECTED REGION END --> */

	}
	
	// ////////////////////////////////////////////////////////////////////////
	// generated getter and setter method implementations
	// ////////////////////////////////////////////////////////////////////////
	
	public float getDiameter() {
		return diameter;
	}
	
	public void setDiameter(float _diameter) {
		diameter = _diameter;
	}
	
	public java.util.Set getSpecification() {
		return java.util.Collections.unmodifiableSet(specification);
	}
	
	public void addToSpecification(String _in) {
		specification.add(_in);
	}
	
	public void removeFromSpecification(String _ex) {
		specification.remove(_ex);
	}
	
	// ////////////////////////////////////////////////////////////////////////
	// own implementations
	// ////////////////////////////////////////////////////////////////////////
	
	/* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._11_5_6340215_1177945943625_542159_161) ENABLED START --> */
	/* <!-- TODO put your own implementation code here --> */
	/* <!-- PROTECTED REGION END --> */
}
