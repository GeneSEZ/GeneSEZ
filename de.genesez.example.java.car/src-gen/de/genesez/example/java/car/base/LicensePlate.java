
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._12_5_8a7027a_1182165360608_205087_392) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public   class LicensePlate    {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getKey}
 */
	private   String key ;
/**
 * @generated	variable definition of association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
		private Car car;
	
	
	
	
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
				car.removeFromLicensePlate(this);
			}
		car = _in;
		_in.insertInLicensePlate(this);
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
			_ex.removeFromLicensePlate(this);
	}
/**
 * @generated	getter for the attribute '<em><b>key</b></em>'
 */
	public  
 String getKey() {
		return key;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_8a7027a_1182165360608_205087_392) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

