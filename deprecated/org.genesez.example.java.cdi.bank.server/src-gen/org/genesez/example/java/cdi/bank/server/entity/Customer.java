package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462905086_648269_462) 
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.genesez.example.java.cdi.bank.server.IEntityBase;

/**
 */
@Entity
@Table(name = "tbl_Customer")
public class Customer implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores associated objects of association ACCOUNTS to Account */
	@ManyToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "customers")
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** Stores the associated object of association ADDRESS to Address */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "customer")
	private Address address;
	
	/** Stores the associated object of association BANK to Bank */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bank bank;
	
	@Id
	private long customerNumber;
	
	private String firstName;
	
	private String sirName;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Customer</b></em>'.
	 */
	
	public Customer() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 * @return	
	 */
	
	public String getFullName() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267535825397_180057_892) ENABLED START */
		
		return firstName + " " + sirName;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>customerNumber</b></em>'
	 */
	public long getCustomerNumber() {
		return customerNumber;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>customerNumber</b></em>'
	 */
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'
	 */
	public String getFirstName() {
		return firstName;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>sirName</b></em>'
	 */
	public String getSirName() {
		return sirName;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>sirName</b></em>'
	 */
	public void setSirName(String sirName) {
		this.sirName = sirName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'
	 */
	public int getVersion() {
		return version;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'
	 */
	public void setVersion(int version) {
		this.version = version;
	}
	
	/**
	 * accessor for association to accounts
	 */
	public java.util.Set<Account> getAccounts() {
		return this.accounts;
		
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void insertInAccounts(Account accounts) {
		if (this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.add(accounts);
		if (!accounts.getCustomers().contains(this)) {
			accounts.insertInCustomers(this);
		}
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void removeFromAccounts(Account accounts) {
		if (!this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.remove(accounts);
		if (accounts.getCustomers().contains(this)) {
			accounts.removeFromCustomers(this);
		}
	}
	
	/**
	 * accessor for association to address
	 */
	public Address getAddress() {
		return address;
	}
	
	/**
	 * accessor for association to address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	/**
	 * accessor for association to bank
	 */
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * accessor for association to bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462905086_648269_462) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public long getId() {
		return customerNumber;
	}
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String customerString = new String();
		
		customerString = "Customer: [";
		customerString += "  customerNumber: " + this.getCustomerNumber();
		customerString += ", firstName: " + this.getFirstName();
		customerString += ", sirName: " + this.getSirName();
		//customerString += ", address: " + ((this.getAddress() == null) ? "null" : this.getAddress().toString());
		//customerString += ", bank: " + ((this.getBank() == null) ? "null" : this.getBank().toString());
		
		customerString += "]";
		
		return customerString;
	}
	
	/* PROTECTED REGION END */
	
}
