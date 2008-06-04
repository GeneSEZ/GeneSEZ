
package de.genesez.example.java.car.base;
import de.genesez.example.java.car.base.parts.Screw;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945943625_542159_161) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public   class Wheel   	implements IChangeable {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getDiameter}
 */
	private   float diameter ;
/**
 * @generated	attribute definition
 * @see			{@link getSpecification}
 */
	private   java.util.Set<String> specification = new java.util.HashSet<String>();
/**
 * @generated	attribute definition
 * @see			{@link getDurability}
 */
	private   Integer durability  = 100000;
/**
 * @generated	variable definition of association to '<em><b>Car</b></em>'
 * @see			{@link getMycar}
 */
		private Car mycar;
/**
 * @generated	variable definition of association to '<em><b>Screw</b></em>'
 * @see			{@link getScrew}
 */
		private java.util.List<Screw> screw = new java.util.ArrayList<Screw>();
	
	
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	<!-- PROTECTED REGION ID(test._11_5_6340215_1179139054625_520706_1) START -->
	 * @generated	method stub for further implementation
 * @param	newWheel	
 * @return	
	<!-- PROTECTED REGION END -->
	 */
	public   
 boolean change(				IChangeable newWheel 		)  {
		boolean returnValue = false;
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179139054625_520706_1) ENABLED START */		// TODO: implementation of method 'Wheel.change(...)'		/* PROTECTED REGION END */
	return returnValue;
	}
	/**
	<!-- PROTECTED REGION ID(test._11_5_6340215_1179238960437_25222_122) START -->
	 * @generated	method stub for further implementation
 * @throws	FlatTireException	
	<!-- PROTECTED REGION END -->
	 */
	public   
 void roll(	) 	throws  FlatTireException  {
		
		/* PROTECTED REGION ID(java.implementation._11_5_6340215_1179238960437_25222_122) ENABLED START */		// TODO: implementation of method 'Wheel.roll(...)'		/* PROTECTED REGION END */
	
	}
	
	// -- generated association + attribute accessors -----------------------
/**
 * @generated	getter method for the association to '<em><b>Car</b></em>'
 */
	public Car getMycar() {
		return mycar;
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getMycar}
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
 * @generated	method to remove values from the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getMycar}
 */
	public void removeFromMycar(Car _ex) {
		if (mycar != _ex) {
			return;
		}
		mycar = null;
			_ex.removeFromWheels(this);
	}
/**
 * @generated	getter method for the association to '<em><b>Screw</b></em>'
 */
	public java.util.List<Screw> getScrew() {
		return java.util.Collections.unmodifiableList(screw);
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Screw</b></em>'
 * @see			{@link getScrew}
 */
	public void insertInScrew(Screw _in) {
		if (screw.contains(_in)) {
			return;
		}
		screw.add(_in);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Screw</b></em>'
 * @see			{@link getScrew}
 */
	public void removeFromScrew(Screw _ex) {
		if (!screw.contains(_ex)) {
			return;
		}
		screw.remove(_ex);
	}
/**
 * @generated	getter for the attribute '<em><b>diameter</b></em>'
 */
	public  
 float getDiameter() {
		return diameter;
	}
	
	
/**
 * @generated	getter for the attribute '<em><b>specification</b></em>'
 */
	public  
 java.util.Set<String> getSpecification() {
		return java.util.Collections.unmodifiableSet(specification);
	}
	
	
/**
 * @generated	method to insert values in the multi-valued attribute '<em><b>specification</b></em>'
 * @see			{@link getSpecification}
 */
	public  
 void addToSpecification(String toAdd) {
		specification.add(toAdd);
	}
/**
 * @generated	method to remove values from the multi-valued attribute '<em><b>specification</em>
 * @see			{@link getSpecification}
 */
	public  
 void removeFromSpecification(String toRemove) {
		specification.remove(toRemove);
	}
/**
 * @generated	getter for the attribute '<em><b>durability</b></em>'
 */
	public  
 Integer getDurability() {
		return durability;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945943625_542159_161) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

