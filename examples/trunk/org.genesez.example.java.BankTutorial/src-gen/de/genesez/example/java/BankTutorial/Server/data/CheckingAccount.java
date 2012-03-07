package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271071979937_985074_736) 
 */

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * The checking account is used for the daily cash flow with a low interest rate of 0.75%. A bank has to deposit the interests of a checking account every 3 minutes.
 * @author apflueger
 */

@Entity
public class CheckingAccount extends Account implements Serializable {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>CheckingAccount</b></em>'.
	 */
	
	public CheckingAccount() {
		/* PROTECTED REGION ID(java.constructor._16_0_129203bc_1271178624843_74493_321) ENABLED START */
		this.setInterestRate(1.0075f);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271071979937_985074_736) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
