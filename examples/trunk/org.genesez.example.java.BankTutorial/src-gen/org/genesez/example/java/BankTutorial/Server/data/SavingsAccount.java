package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271071913640_952667_690) 
 */

import javax.persistence.Entity;

/**
 * The savings account offers a fixed interest rate of 2.75% for a long period of time. A bank has to deposit the interests of a savings account every 5 minutes.
 */
@Entity
public class SavingsAccount extends Account {
	
	/**
	 * Constructor for class '<em><b>SavingsAccount</b></em>'.
	 */
	
	public SavingsAccount() {
		/* PROTECTED REGION ID(java.constructor._16_0_129203bc_1271178598609_999826_315) ENABLED START */
		this.setInterestRate(1.0275f);
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271071913640_952667_690) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
