package org.genesez.example.java.cdi.bank.server.event;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1293974739447_926321_776) 
 */

import java.util.Date;
/**
 */

public class MoneyTransferEvent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Date date;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>MoneyTransferEvent</b></em>'.
	 * @param	date	
	 */
	
	public MoneyTransferEvent(Date date) {
		/* PROTECTED REGION ID(java.constructor._16_0_1_41601a3_1293976524170_631698_403) ENABLED START */
		
		this.date = date;
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>date</b></em>'
	 */
	public Date getDate() {
		return new Date(date.getTime());
		
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1293974739447_926321_776) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
