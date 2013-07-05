package Bank_Tutorial_Weld_Server.bankgroupServer.event;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1294585114943_199405_832) ENABLED START */
/* TODO: put your own source code here */
import java.util.*;
import javax.persistence.*;
import javax.annotation.*;
import javax.ejb.*;
import Bank_Tutorial_Weld_Server.qualifier.*;
import Bank_Tutorial_Weld_Server.bankgroupServer.*;

/* PROTECTED REGION END */

/**
 */

public class BalanceNegativEvent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private float balance;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>BalanceNegativEvent</b></em>'
	 * @param	balance	
	 */
	public BalanceNegativEvent(float balance) {
		/* PROTECTED REGION ID(java.constructor._16_0_1_41601a3_1294585230047_96280_847) ENABLED START */

		this.balance = balance;
		
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>balance</b></em>'
	 */
	public float getBalance() {
		return balance;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1294585114943_199405_832) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
