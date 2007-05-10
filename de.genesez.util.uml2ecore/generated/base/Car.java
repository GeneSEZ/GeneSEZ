package base;

/*
	Car.java
	generated @ 2007-05-10 18:31:33.203 CEST by dreamer
 */

/* PROTECTED REGION ID(java.imports._XphC4_41EduRRenReWtq2g) ENABLED START */
// put your imports here - following import is placeholder that your IDE puts further imports here
import java.lang.String;
/* PROTECTED REGION END */

/**
	<!-- PROTECTED REGION ID(java.type.comment._XphC4_41EduRRenReWtq2g) ENABLED START -->
	<!-- TODO put your type comment here [description + responsibility] -->
	<!-- PROTECTED REGION END -->
	
	@author		dreamer
	@version	2007-05-10 18:31:33.203 CEST
 */


public class Car  {
	
	
	
	// -- attribute definitions with default initialization ---------

	private int maxSpeed;

	private String make;

	
	// -- attribute getter + setter ---------------------------------
	
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}

	
	
	
	// -- declare association attributes ----------------------------
	

	private Wheel mycar;



	private Wheel owner;


	// -- accessores for association attributes ---------------------
	

	
	public void insertInMycar(Wheel _in) {
		
		if (mycar == _in) {
			return;
		}
		
		
		mycar = _in;
	
	
	}
	
	
	public void removeFromMycar	(Wheel _ex) {
	
		
		if (mycar != _ex) {
			return;
		}
		
		mycar = null;
	
	
	}
	
	
	
	public Wheel getMycar() {
		return mycar;
	}
	



	
	public void insertInOwner(Wheel _in) {
		
		if (owner == _in) {
			return;
		}
		
		
		owner = _in;
	
	
	}
	
	
	public void removeFromOwner	(Wheel _ex) {
	
		
		if (owner != _ex) {
			return;
		}
		
		owner = null;
	
	
	}
	
	
	
	public Wheel getOwner() {
		return owner;
	}
	



	
	
	
	
	/* PROTECTED REGION ID(java.impl._XphC4_41EduRRenReWtq2g) ENABLED START */
	// -- put your implementation code here -------------------------
	
	/* PROTECTED REGION END */
	
	// -- now it's your turn ----------------------------------------
}

