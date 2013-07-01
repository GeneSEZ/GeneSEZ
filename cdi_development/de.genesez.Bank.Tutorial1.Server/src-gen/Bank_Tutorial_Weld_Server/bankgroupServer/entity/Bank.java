package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462918311_582104_470) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.persistence.Version;

import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Bank")
public class Bank implements EntityBase, Serializable {
	
	/** Stores the linked object of association '<em><b>bankgroup</b></em>' */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bankgroup bankgroup;
	
	/** Stores all linked objects of association '<em><b>accounts</b></em>' */
	@OneToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	@Basic(optional = true)
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** Stores the linked object of association '<em><b>address</b></em>' */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	private Address address;
	
	/** Stores all linked objects of association '<em><b>customers</b></em>' */
	@OneToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	private java.util.Set<Customer> customers = new java.util.HashSet<Customer>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sortCode;
	
	private String name;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Bank</b></em>'.
	 */
	
	public Bank() {
	}
	
	/**
	 * Returns the linked object of association '<em><b>bankgroup</b></em>'.
	 */
	
	public Bankgroup getBankgroup() {
		return bankgroup;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bankgroup</b></em>'.
	 * @param	bankgroup	the object to associate.
	 */
	
	public void setBankgroup(Bankgroup bankgroup) {
		if (this.bankgroup == bankgroup) {
			return;
		}
		Bankgroup former = this.bankgroup;
		this.bankgroup = bankgroup;
		if (former != null) {
			former.removeBanks(this);
		}
		if (bankgroup != null) {
			bankgroup.addBanks(this);
		}
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
		accounts.setBank(this);
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
		accounts.setBank(null);
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
			former.setBank(null);
		}
		if (address != null) {
			address.setBank(this);
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
		customers.setBank(this);
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
		customers.setBank(null);
	}
	
	/**
	 * Returns the value of attribute '<em><b>sortCode</b></em>'.
	 */
	
	public long getSortCode() {
		return sortCode;
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
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
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267462918311_582104_470__16_0_1_41601a3_1284909977612_160129_381) ENABLED START */
		// TODO: implementation of method 'Bank.getId(...)'
		throw new UnsupportedOperationException("The implementation of this generated method stub is missing!");
		/* PROTECTED REGION END */
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462918311_582104_470) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String bankString = new String();
		
		bankString = "Bank: [";
		bankString += " name: " + this.getName();
		bankString += ", sortcode: " + String.valueOf(this.getSortCode());
		bankString += ", address: " + (this.getAddress() != null ? this.getAddress().toString() : "null");
		bankString += ", bankgroup: " + (this.getBankgroup() != null ? this.getBankgroup().toString() : "null");
		bankString += ", customers: [";
		if (this.getCustomers() != null)
			for (Customer customer : this.getCustomers()) {
				bankString += " " + customer.toString();
			}
		else
			bankString += "null";
		this.getCustomers().toString();
		bankString += "]";
		bankString += "]";
		
		return bankString;
	}
	
	public long getId() {
		return sortCode;
	}
	
	/* PROTECTED REGION END */
}
