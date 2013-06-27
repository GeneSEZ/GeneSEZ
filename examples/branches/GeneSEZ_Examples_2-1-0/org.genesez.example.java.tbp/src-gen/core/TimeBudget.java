package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231923336343_553337_599) 
 */

import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author nicher
 */
public class TimeBudget implements AssociationClass {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Duration bookedTime;
	
	private ACLink associationClassLink = new ACLink();
	
	/**
	 * Initializing constructor for class '<em><b>TimeBudget</b></em>'.
	 * @param	bookedTime	{@link Duration.getBookedTime()}
	 * @param	associationClassLink	{@link ACLink.getAssociationClassLink()}
	 */
	public TimeBudget(Duration bookedTime, ACLink associationClassLink) {
		this.bookedTime = bookedTime;
		this.associationClassLink = associationClassLink;
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>associationClassLink</b></em>'
	 */
	public ACLink getAssociationClassLink() {
		return associationClassLink;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_b6f02e1_1231923336343_553337_599) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
