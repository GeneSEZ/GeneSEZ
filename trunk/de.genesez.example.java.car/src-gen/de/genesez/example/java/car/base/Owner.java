
package de.genesez.example.java.car.base;

/* PROTECTED REGION ID(java.type.import._12_5_6340215_1182161516984_21570_380) ENABLED START */// TODO: put your further include + require statements here/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public   class Owner    {
	
	// -- generated attribute, constant + association declarations ----------
/**
 * @generated	attribute definition
 * @see			{@link getName}
 */
	private   String name ;
	/** reference attribute to the managed association end */
	private License license;
	/** reference attribute to the managed association end */
	private Car car;
	
	/**
	 * constructor which initializes the managed association ends
	 * @generated	initializing constructor for the association class
	 * @param	license	{@link License.getLicense}
	 * @param	car	{@link Car.getCar}
	 */
public Owner (License _license, Car _car) {
	license =  _license;
	car =  _car;

	/* PROTECTED REGION ID(java.initializing.constructor.own.code._12_5_6340215_1182161516984_21570_380) ENABLED START */		// TODO: put your further initialization code here		/* PROTECTED REGION END */
}
	
	
	
	// -- generated association + attribute accessors -----------------------
	/** getter of reference attribute to the managed association end license */
	public License getLicense() {
		return license;
	}
	/** getter of reference attribute to the managed association end car */
	public Car getCar() {
		return car;
	}
/**
 * @generated	getter for the attribute '<em><b>name</b></em>'
 */
	public  
 String getName() {
		return name;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._12_5_6340215_1182161516984_21570_380) ENABLED START */	// TODO: put your own implementation code here	/* PROTECTED REGION END */
}

