package base;

/*
	Wheel.java
	generated @ 2007-05-10 18:31:33.218 CEST by dreamer
 */

/* PROTECTED REGION ID(java.imports._XphC6v41EduRRenReWtq2g) ENABLED START */
// put your imports here - following import is placeholder that your IDE puts further imports here
import java.lang.String;
/* PROTECTED REGION END */

/**
	<!-- PROTECTED REGION ID(java.type.comment._XphC6v41EduRRenReWtq2g) ENABLED START -->
	<!-- TODO put your type comment here [description + responsibility] -->
	<!-- PROTECTED REGION END -->
	
	@author		dreamer
	@version	2007-05-10 18:31:33.218 CEST
 */


public class Wheel  {
	
	
	
	// -- attribute definitions with default initialization ---------

	private float diameter;

	
	// -- attribute getter + setter ---------------------------------
	
	public float getDiameter() {
		return diameter;
	}
	
	public void setDiameter(float diameter) {
		this.diameter = diameter;
	}

	
	
	
	// -- declare association attributes ----------------------------
	

	private Car wheels;



	private  no opposite;



	private Car spare;


	// -- accessores for association attributes ---------------------
	

	
	public void insertInWheels(Car _in) {
		
		if (wheels == _in) {
			return;
		}
		
		
		wheels = _in;
	
	
	}
	
	
	public void removeFromWheels	(Car _ex) {
	
		
		if (wheels != _ex) {
			return;
		}
		
		wheels = null;
	
	
	}
	
	
	
	public Car getWheels() {
		return wheels;
	}
	



	
	public void insertInNo opposite( _in) {
		
		if (no opposite == _in) {
			return;
		}
		
		
		no opposite = _in;
	
	
	}
	
	
	public void removeFromNo opposite	( _ex) {
	
		
		if (no opposite != _ex) {
			return;
		}
		
		no opposite = null;
	
	
	}
	
	
	
	public  getNo opposite() {
		return no opposite;
	}
	



	
	public void insertInSpare(Car _in) {
		
		if (spare == _in) {
			return;
		}
		
		
		spare = _in;
	
	
	}
	
	
	public void removeFromSpare	(Car _ex) {
	
		
		if (spare != _ex) {
			return;
		}
		
		spare = null;
	
	
	}
	
	
	
	public Car getSpare() {
		return spare;
	}
	



	
	
	
	
	/* PROTECTED REGION ID(java.impl._XphC6v41EduRRenReWtq2g) ENABLED START */
	// -- put your implementation code here -------------------------
	
	/* PROTECTED REGION END */
	
	// -- now it's your turn ----------------------------------------
}

