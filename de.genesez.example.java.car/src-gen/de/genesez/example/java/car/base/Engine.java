
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._12_5_8a7027a_1182165491328_680838_471) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public   class Engine    {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getPs}
 */
	private   byte ps ;
/**
 * @generated	attribute definition
 * @see			{@link getName}
 */
	private   String name ;
/**
 * @generated	variable definition of association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
		private Car car;
	
	// -- generated constructors --------------------------------------------
	/**
	 * @generated	constructor for class '<em><b>Engine</b></em>'
 * @param	ps	
 * @param	name	
	 */
	public   
 Engine(				byte ps 		, 			String name 		)  {
		/* PROTECTED REGION ID(java.constructor._12_5_8a7027a_1182275619895_618915_478) ENABLED START */		// TODO: implementation of constructor for class 'Engine'		/* PROTECTED REGION END */
	}
	
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
/**
 * @generated	getter method for the association to '<em><b>Car</b></em>'
 */
	public Car getCar() {
		return car;
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
	public void insertInCar(Car _in) {
		if (car == _in) {
			return;
		}
			if (car != null) {
				car.removeFromEngine(this);
			}
		car = _in;
		_in.insertInEngine(this);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
	public void removeFromCar(Car _ex) {
		if (car != _ex) {
			return;
		}
		car = null;
			_ex.removeFromEngine(this);
	}
/**
 * @generated	getter for the attribute '<em><b>ps</b></em>'
 */
	public  
 byte getPs() {
		return ps;
	}
	
	
/**
 * @generated	getter for the attribute '<em><b>name</b></em>'
 */
	public  
 String getName() {
		return name;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165491328_680838_471) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

