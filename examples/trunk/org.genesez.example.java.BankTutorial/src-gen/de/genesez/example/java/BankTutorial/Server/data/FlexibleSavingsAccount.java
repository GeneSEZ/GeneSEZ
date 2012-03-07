package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271071927718_941385_713) 
 */

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * The flexible savings account offers a volatile interest rate depending on the daily interest development. For a first implementation an average interest rate of 3.5% can be chosen. A bank has to deposit the interests of a flexible savings account  every minute.
 * @author apflueger
 */

@Entity
public class FlexibleSavingsAccount extends Account implements Serializable {
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>FlexibleSavingsAccount</b></em>'.
	 */
	
	public FlexibleSavingsAccount() {
		/* PROTECTED REGION ID(java.constructor._16_0_129203bc_1271178614359_750303_318) ENABLED START */
		this.setInterestRate(1.035f);
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271071927718_941385_713) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
