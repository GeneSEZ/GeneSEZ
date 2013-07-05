package Bank_Tutorial_Weld_Server.bankgroupServer.event;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1293974739447_926321_776) ENABLED START */
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

public class MoneyTransferEvent {
	
	// -- generated attribute, constant + association declarations ----------
	
	private Date date;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>MoneyTransferEvent</b></em>'
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
	 * getter for the attribute '<em><b>date</b></em>'
	 */
	public Date getDate() {
		return date;
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1293974739447_926321_776) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
