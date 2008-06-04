
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._12_5_6340215_1182161482703_876307_352) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public   class License    {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getRegistration}
 */
	private   String registration ;
/**
 * @generated	variable definition of association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
		private java.util.List<Owner> car = new java.util.ArrayList<Owner>();
	
	
	
	
	// -- generated association + attribute accessors -----------------------
/**
 * @generated	getter method for the association to '<em><b>Car</b></em>'
 */
	public java.util.List<Car> getCar() {
		java.util.ArrayList<Car> _result = new java.util.ArrayList<Car>();
		for(Owner _assoc : car) {
			_result.add(_assoc.getCar());
		}
		return _result;
	}
	
	/** 
	  * accessor to the association class objects
	  */
	public java.util.List<Owner> getCarOwner() {
		return java.util.Collections.unmodifiableList(car);
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
	/**
	 * insert into association, generate linked association class object
	 * @param _other partner object
	 * @return newly generated linked association class object
	 */
	public Owner insertInCar(Car _other) {
			Owner _assoc = new Owner(this, _other);
		car.add(_assoc);
		_other.insertInLicense(_assoc); 
		return _assoc;
	}
	
	/**
	 * insert linked association class object into association
	 * @param _other partner object
	 * @return newly generated linked association class object
	 */
	public void insertInCar(Owner _assoc) {
		if (car.contains(_assoc)) {
				return;
		}
		if(_assoc.getLicense() != this) {
			throw new RuntimeException("inconsistent association object");
		}
		car.add(_assoc);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Car</b></em>'
 * @see			{@link getCar}
 */
	/**
	 * remove entry from association indexed by its association class object
	 */
	public void removeFromCar(Owner _assoc) {
		if (!car.contains(_assoc)) {
			return;
		}
		car.remove(_assoc);
			_assoc.getCar().removeFromLicense(_assoc);
	}
/**
 * @generated	getter for the attribute '<em><b>registration</b></em>'
 */
	public  
 String getRegistration() {
		return registration;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161482703_876307_352) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

