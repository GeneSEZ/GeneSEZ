package Bank_Tutorial_Weld_Server.bankgroupServer.event;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1294585114943_199405_832) 
 */

/**
 * Please describe the responsibility of your class in your modeling tool.
 */

public class BalanceNegativEvent {
	
	private float balance;
	
	/**
	 * Constructor for class '<em><b>BalanceNegativEvent</b></em>'.
	 */
	
	public BalanceNegativEvent(float balance) {
		/* PROTECTED REGION ID(java.constructor._16_0_1_41601a3_1294585230047_96280_847) ENABLED START */
		
		this.balance = balance;
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>balance</b></em>'.
	 */
	
	public float getBalance() {
		return balance;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1294585114943_199405_832) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
