package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231923224937_24486_549) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */
/**
 * Represents the <b><i>amount</i></b> of time spent for something. This 
 * amount is defined as the <u><i>time difference</i></u> of the start to the 
 * end.
 * @author	dreamer
 */
public class Duration {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 */
	private double time;
	/**
	 * @generated	attribute definition
	 */
	private String unit;
	
	// -- generated constructors --------------------------------------------
	
	/**
	 * constructor which initializes all instance attributes
	 * @generated	initializing constructor for class '<em><b>Duration</b></em>'
	 * @param	time	{@link double.getTime()}
	 * @param	unit	{@link String.getUnit()}
	 */
	public Duration(double time, String unit) {
		this.time = time;
		this.unit = unit;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>time</b></em>'
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>unit</b></em>'
	 */
	public String getUnit() {
		return unit;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._16_0_b6f02e1_1231923224937_24486_549) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
