
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._11_5_6340215_1177945913718_872802_139) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * A car is a vehicle with four wheels and drives on the road.
 * @author	dreamer
 */
public   class Car  	extends AbstractVehicle
 {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getMaxSpeed}
 */
	private   int maxSpeed ;
/**
 * @generated	variable definition of association to '<em><b>Wheel</b></em>'
 * @see			{@link getSpare}
 */
		private Wheel spare;
/**
 * @generated	variable definition of association to '<em><b>License</b></em>'
 * @see			{@link getLicense}
 */
		private java.util.List<Owner> license = new java.util.ArrayList<Owner>();
/**
 * @generated	variable definition of association to '<em><b>LicensePlate</b></em>'
 * @see			{@link getLicensePlate}
 */
		private LicensePlate licensePlate;
/**
 * @generated	variable definition of association to '<em><b>Engine</b></em>'
 * @see			{@link getEngine}
 */
		private Engine engine;
/**
 * @generated	variable definition of association to '<em><b>Wheel</b></em>'
 * @see			{@link getWheels}
 */
		private java.util.List<Wheel> wheels = new java.util.ArrayList<Wheel>();
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor of the class car
	 * @generated	constructor for class '<em><b>Car</b></em>'
 * @param	mxs	maximum of speed
 * @param	make	i don't know what make do
 * @throws	NotReallySeriousException	this is a comment; this is the second comment
	 */
	public   
 Car(				int mxs 		, 			String make 		) 	throws  NotReallySeriousException  {
		/* PROTECTED REGION ID(java.constructor._11_5_6340215_1179229080562_965427_117) ENABLED START */		// TODO: implementation of constructor for class 'Car'		/* PROTECTED REGION END */
	}
	
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	<!-- PROTECTED REGION ID(test._12_5_b6f02e1_1204102049578_778385_691) START -->
	 * @generated	method stub for further implementation
 * @param	distance	
 * @return	
	<!-- PROTECTED REGION END -->
	 */
	public   
 boolean drive(				Integer distance 		)  {
		boolean returnValue = false;
		/* PROTECTED REGION ID(java.implementation._12_5_b6f02e1_1204102049578_778385_691) ENABLED START */		// TODO: implementation of method 'Car.drive(...)'		/* PROTECTED REGION END */
	return returnValue;
	}
/**
 * count the number of wheels
 * @generated	getter for the attribute '<em><b>noOfWheels</b></em>'
 */
	private   Integer getNoOfWheels() {
		Integer returnValue = null;
		/* PROTECTED REGION ID(java.derived.attribute.implementation._11_5_6340215_1178786244296_257674_121) ENABLED START */		// TODO: put the implementation of derived (calculated) attribute 'noOfWheels' here		/* PROTECTED REGION END */
		return returnValue;
	}
	
	// -- generated association + attribute accessors -----------------------
/**
 * reference to the spared wheel
 * @generated	getter method for the association to '<em><b>Wheel</b></em>'
 */
	public Wheel getSpare() {
		return spare;
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Wheel</b></em>'
 * @see			{@link getSpare}
 */
	public void insertInSpare(Wheel _in) {
		if (spare == _in) {
			return;
		}
		spare = _in;
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Wheel</b></em>'
 * @see			{@link getSpare}
 */
	public void removeFromSpare(Wheel _ex) {
		if (spare != _ex) {
			return;
		}
		spare = null;
	}
/**
 * @generated	getter method for the association to '<em><b>License</b></em>'
 */
	public java.util.List<License> getLicense() {
		java.util.ArrayList<License> _result = new java.util.ArrayList<License>();
		for(Owner _assoc : license) {
			_result.add(_assoc.getLicense());
		}
		return _result;
	}
	
	/** 
	  * accessor to the association class objects
	  */
	public java.util.List<Owner> getLicenseOwner() {
		return java.util.Collections.unmodifiableList(license);
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>License</b></em>'
 * @see			{@link getLicense}
 */
	/**
	 * insert into association, generate linked association class object
	 * @param _other partner object
	 * @return newly generated linked association class object
	 */
	public Owner insertInLicense(License _other) {
			Owner _assoc = new Owner(_other, this);
		license.add(_assoc);
		_other.insertInCar(_assoc); 
		return _assoc;
	}
	
	/**
	 * insert linked association class object into association
	 * @param _other partner object
	 * @return newly generated linked association class object
	 */
	public void insertInLicense(Owner _assoc) {
		if (license.contains(_assoc)) {
				return;
		}
		if(_assoc.getCar() != this) {
			throw new RuntimeException("inconsistent association object");
		}
		license.add(_assoc);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>License</b></em>'
 * @see			{@link getLicense}
 */
	/**
	 * remove entry from association indexed by its association class object
	 */
	public void removeFromLicense(Owner _assoc) {
		if (!license.contains(_assoc)) {
			return;
		}
		license.remove(_assoc);
			_assoc.getLicense().removeFromCar(_assoc);
	}
/**
 * @generated	getter method for the association to '<em><b>LicensePlate</b></em>'
 */
	public LicensePlate getLicensePlate() {
		return licensePlate;
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>LicensePlate</b></em>'
 * @see			{@link getLicensePlate}
 */
	public void insertInLicensePlate(LicensePlate _in) {
		if (licensePlate == _in) {
			return;
		}
			if (licensePlate != null) {
				licensePlate.removeFromCar(this);
			}
		licensePlate = _in;
		_in.insertInCar(this);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>LicensePlate</b></em>'
 * @see			{@link getLicensePlate}
 */
	public void removeFromLicensePlate(LicensePlate _ex) {
		if (licensePlate != _ex) {
			return;
		}
		licensePlate = null;
			_ex.removeFromCar(this);
	}
/**
 * @generated	getter method for the association to '<em><b>Engine</b></em>'
 */
	public Engine getEngine() {
		return engine;
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Engine</b></em>'
 * @see			{@link getEngine}
 */
	public void insertInEngine(Engine _in) {
		if (engine == _in) {
			return;
		}
			if (engine != null) {
				engine.removeFromCar(this);
			}
		engine = _in;
		_in.insertInCar(this);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Engine</b></em>'
 * @see			{@link getEngine}
 */
	public void removeFromEngine(Engine _ex) {
		if (engine != _ex) {
			return;
		}
		engine = null;
			_ex.removeFromCar(this);
	}
/**
 * reference to normal wheels on a car
 * @generated	getter method for the association to '<em><b>Wheel</b></em>'
 */
	public java.util.List<Wheel> getWheels() {
		return java.util.Collections.unmodifiableList(wheels);
	}
/**
 * @generated	method to insert values in the multi-valued association to '<em><b>Wheel</b></em>'
 * @see			{@link getWheels}
 */
	public void insertInWheels(Wheel _in) {
		if (wheels.contains(_in)) {
			return;
		}
		wheels.add(_in);
		_in.insertInMycar(this);
	}
/**
 * @generated	method to remove values from the multi-valued association to '<em><b>Wheel</b></em>'
 * @see			{@link getWheels}
 */
	public void removeFromWheels(Wheel _ex) {
		if (!wheels.contains(_ex)) {
			return;
		}
		wheels.remove(_ex);
			_ex.removeFromMycar(this);
	}
/**
 * describes the maximum speed of a car
 * @generated	getter for the attribute '<em><b>maxSpeed</b></em>'
 */
	public  
 int getMaxSpeed() {
		return maxSpeed;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._11_5_6340215_1177945913718_872802_139) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

