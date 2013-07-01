package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462905086_648269_462) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Customer")
public class Customer implements EntityBase, Serializable {
	
	/** Stores all linked objects of association '<em><b>accounts</b></em>' */
	@ManyToMany(cascade = {}, fetch = FetchType.EAGER)
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** Stores the linked object of association '<em><b>address</b></em>' */
	@OneToOne(cascade = {})
	private Address address;
	
	/** Stores the linked object of association '<em><b>bank</b></em>' */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bank bank;
	
	@Id
	private long customerNumber;
	
	private String firstName;
	
	private String sirName;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Customer</b></em>'.
	 */
	
	public Customer() {
	}
	
	/**
	 * Method stub for further implementation.
	 */
	
	public String getFullName() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267535825397_180057_892) ENABLED START */
		
		return firstName + " " + sirName;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns all linked objects of association '<em><b>accounts</b></em>'.
	 */
	
	public java.util.Set<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>accounts</b></em>'.
	 * @param	accounts	the object to associate.
	 */
	
	public void addAccounts(Account accounts) {
		if (accounts == null || this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.add(accounts);
		accounts.addCustomers(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>accounts</b></em>'.
	 * @param	accounts	the object to remove.
	 */
	
	public void removeAccounts(Account accounts) {
		if (accounts == null || !this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.remove(accounts);
		accounts.removeCustomers(this);
	}
	
	/**
	 * Returns the linked object of association '<em><b>address</b></em>'.
	 */
	
	public Address getAddress() {
		return address;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>address</b></em>'.
	 * @param	address	the object to associate.
	 */
	
	public void setAddress(Address address) {
		if (this.address == address) {
			return;
		}
		Address former = this.address;
		this.address = address;
		if (former != null) {
			former.setCustomer(null);
		}
		if (address != null) {
			address.setCustomer(this);
		}
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
			former.removeCustomers(this);
		}
		if (bank != null) {
			bank.addCustomers(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>customerNumber</b></em>'.
	 */
	
	public long getCustomerNumber() {
		return customerNumber;
	}
	
	/**
	 * Sets the value of attribute '<em><b>customerNumber</b></em>'.
	 * @param	customerNumber	the value to set.
	 */
	
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstName</b></em>'.
	 */
	
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstName</b></em>'.
	 * @param	firstName	the value to set.
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the value of attribute '<em><b>sirName</b></em>'.
	 */
	
	public String getSirName() {
		return sirName;
	}
	
	/**
	 * Sets the value of attribute '<em><b>sirName</b></em>'.
	 * @param	sirName	the value to set.
	 */
	
	public void setSirName(String sirName) {
		this.sirName = sirName;
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
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462905086_648269_462__16_0_1_41601a3_1284909977612_160129_381) ENABLED START */
		// TODO: implementation of method 'Customer.getId(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
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
