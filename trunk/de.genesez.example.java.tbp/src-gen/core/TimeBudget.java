package core;

import java.util.*;
import de.genesez.platforms.java.umlsupport.associations.*;

/* PROTECTED REGION ID(java.type.import._16_0_b6f02e1_1231923336343_553337_599) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * @author	dreamer
 */
public class TimeBudget implements AssociationClass {
	
	// -- generated attribute, constant + association declarations ----------
	/**
	 * @generated	attribute definition
	 */
	private Duration bookedTime;
	/**
	 * @generated	attribute definition
	 */
	private ACLink associationClassLink = new ACLink();
	
	/**
	 * constructor which initializes all instance attributes
	 * @generated	initializing constructor for class '<em><b>TimeBudget</b></em>'
	 * @param	bookedTime	{@link Duration.getBookedTime()}
	 * @param	associationClassLink	{@link ACLink.getAssociationClassLink()}
	 */
	public TimeBudget(Duration bookedTime, ACLink associationClassLink) {
		this.bookedTime = bookedTime;
		this.associationClassLink = associationClassLink;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * @generated	getter for the attribute '<em><b>bookedTime</b></em>'
	 */
	public Duration getBookedTime() {
		return bookedTime;
	}
	
	/**
	 * documented here {@link getBookedTime()}
	 * @generated	setter method for the attribute '<em><b>bookedTime</b></em>'
	 */
	public void setBookedTime(Duration bookedTime) {
		this.bookedTime = bookedTime;
	}
	
	/**
	 * @generated	getter for the attribute '<em><b>associationClassLink</b></em>'
	 */
	public ACLink getAssociationClassLink() {
		return associationClassLink;
	}
	
	/**
	 * documented here {@link getAssociationClassLink()}
	 * @generated	setter method for the attribute '<em><b>associationClassLink</b></em>'
	 */
	public void setAssociationClassLink(ACLink associationClassLink) {
		this.associationClassLink = associationClassLink;
	}
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231923336343_553337_599) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
