package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068737906_801239_1213) 
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Customer")
public class Customer implements Serializable {
	
	/** Stores the linked object of association '<em><b>contact</b></em>' */
	@OneToOne(cascade = { CascadeType.ALL })
	private Contact contact;
	
	/** Stores all linked objects of association '<em><b>accounts</b></em>' */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "owner")
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** Stores all linked objects of association '<em><b>banks</b></em>' */
	@ManyToMany(cascade = {})
	private java.util.Set<Bank> banks = new java.util.HashSet<Bank>();
	
	private String firstname;
	
	private String surname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Customer</b></em>'.
	 */
	
	public Customer() {
	}
	
	/**
	 * Returns the linked object of association '<em><b>contact</b></em>'.
	 */
	
	public Contact getContact() {
		return contact;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>contact</b></em>'.
	 * @param	contact	the object to associate.
	 */
	
	public void setContact(Contact contact) {
		if (this.contact == contact) {
			return;
		}
		this.contact = contact;
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
		accounts.setOwner(this);
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
		accounts.setOwner(null);
	}
	
	/**
	 * Returns all linked objects of association '<em><b>banks</b></em>'.
	 */
	
	public java.util.Set<Bank> getBanks() {
		return banks;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>banks</b></em>'.
	 * @param	banks	the object to associate.
	 */
	
	public void addBanks(Bank banks) {
		if (banks == null || this.banks.contains(banks)) {
			return;
		}
		this.banks.add(banks);
		banks.addCustomers(this);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>banks</b></em>'.
	 * @param	banks	the object to remove.
	 */
	
	public void removeBanks(Bank banks) {
		if (banks == null || !this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
		banks.removeCustomers(this);
	}
	
	/**
	 * Returns the value of attribute '<em><b>firstname</b></em>'.
	 */
	
	public String getFirstname() {
		return this.firstname;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstname</b></em>'.
	 * @param	firstname	the value to set.
	 */
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Returns the value of attribute '<em><b>surname</b></em>'.
	 */
	
	public String getSurname() {
		return this.surname;
	}
	
	/**
	 * Sets the value of attribute '<em><b>surname</b></em>'.
	 * @param	surname	the value to set.
	 */
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return this.id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'.
	 * @param	id	the value to set.
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Returns the value of attribute '<em><b>version</b></em>'.
	 */
	
	public int getVersion() {
		return this.version;
	}
	
	/**
	 * Sets the value of attribute '<em><b>version</b></em>'.
	 * @param	version	the value to set.
	 */
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068737906_801239_1213) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
