package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462924637_558573_474) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Account")
public class Account implements EntityBase, Serializable {
	
	/** Stores the linked object of association '<em><b>bank</b></em>' */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bank bank;
	
	/** Stores all linked objects of association '<em><b>customers</b></em>' */
	@ManyToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "accounts")
	private java.util.Set<Customer> customers = new java.util.HashSet<Customer>();
	
	private float amount;
	
	@Id
	private long accountNumber;
	
	private AccountStateEnum state = AccountStateEnum.VALID;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Account</b></em>'.
	 */
	
	public Account() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean withdraw(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267529903556_687060_666) ENABLED START */
		this.amount -= amount;
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public boolean deposit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267529975721_901813_670) ENABLED START */
		
		this.amount += amount;
		
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the linked object of association '<em><b>bank</b></em>'.
	 */
	
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bank</b></em>'.
	 * @param	bank	the object to associate.
	 */
	
	public void setBank(Bank bank) {
		if (this.bank == bank) {
			return;
		}
		Bank former = this.bank;
		this.bank = bank;
		if (former != null) {
			former.removeAccounts(this);
		}
		if (bank != null) {
			bank.addAccounts(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>customers</b></em>'.
	 */
	
	public java.util.Set<Customer> getCustomers() {
		return customers;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>customers</b></em>'.
	 * @param	customers	the object to associate.
	 */
	
	public void addCustomers(Customer customers) {
		if (customers == null || this.customers.contains(customers)) {
			return;
		}
		this.customers.add(customers);
		customers.addAccounts(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>customers</b></em>'.
	 * @param	customers	the object to remove.
	 */
	
	public void removeCustomers(Customer customers) {
		if (customers == null || !this.customers.contains(customers)) {
			return;
		}
		this.customers.remove(customers);
		customers.removeAccounts(this);
	}
	
	/**
	 * Returns the value of attribute '<em><b>amount</b></em>'.
	 */
	
	public float getAmount() {
		return amount;
	}
	
	/**
	 * Sets the value of attribute '<em><b>amount</b></em>'.
	 * @param	amount	the value to set.
	 */
	
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accountNumber</b></em>'.
	 */
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Sets the value of attribute '<em><b>accountNumber</b></em>'.
	 * @param	accountNumber	the value to set.
	 */
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * Returns the value of attribute '<em><b>state</b></em>'.
	 */
	
	public AccountStateEnum getState() {
		return state;
	}
	
	/**
	 * Sets the value of attribute '<em><b>state</b></em>'.
	 * @param	state	the value to set.
	 */
	
	public void setState(AccountStateEnum state) {
		this.state = state;
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public long getId() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462924637_558573_474__16_0_1_41601a3_1284909977612_160129_381) ENABLED START */
		// TODO: implementation of method 'Account.getId(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462924637_558573_474) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		String accountString = new String();
		accountString = "Account [ ";
		accountString += "accountNumber: " + this.accountNumber;
		accountString += ", amount: " + String.valueOf(this.amount);
		accountString += ", customer: " + (this.customers == null ? "null" : this.customers.toString());
		accountString += ", bank: " + (this.bank == null ? "null" : this.bank.toString());
		accountString += " ]";
		
		return accountString;
	}
	
	public long getId() {
		return accountNumber;
	}
	
	/* PROTECTED REGION END */
}
