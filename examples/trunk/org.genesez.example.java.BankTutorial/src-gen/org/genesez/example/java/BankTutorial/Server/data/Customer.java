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
	
	/** Stores the associated object of association CONTACT to Contact */
	@OneToOne(cascade = { CascadeType.ALL })
	private Contact contact;
	
	/** Stores associated objects of association ACCOUNTS to Account */
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "owner")
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** Stores associated objects of association BANKS to Bank */
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
	 * Returns the value of attribute '<em><b>firstname</b></em>'.
	 */
	
	public String getFirstname() {
		return firstname;
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
		return surname;
	}
	
	/**
	 * Sets the value of attribute '<em><b>surname</b></em>'.
	 * @param	surname	the value to set.
	 */
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Returns the value of attribute '<em><b>contact</b></em>'.
	 */
	
	public Contact getContact() {
		return contact;
	}
	
	/**
	 * Sets the value of attribute '<em><b>contact</b></em>'.
	 * @param	contact	the value to set.
	 */
	
	public void setContact(Contact contact) {
		
		this.contact = contact;
	}
	
	/**
	 * Returns the value of attribute '<em><b>accounts</b></em>'.
	 */
	
	public java.util.Set<Account> getAccounts() {
		return accounts;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>accounts</b></em>'.
	 * @param	accounts	the value to add.
	 */
	
	public void addAccounts(Account accounts) {
		if (this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.add(accounts);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>accounts</b></em>'.
	 * @param	accounts	the value to remove.
	 */
	
	public void removeAccounts(Account accounts) {
		if (!this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.remove(accounts);
	}
	
	/**
	 * Returns the value of attribute '<em><b>banks</b></em>'.
	 */
	
	public java.util.Set<Bank> getBanks() {
		return banks;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>banks</b></em>'.
	 * @param	banks	the value to add.
	 */
	
	public void addBanks(Bank banks) {
		if (this.banks.contains(banks)) {
			return;
		}
		this.banks.add(banks);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>banks</b></em>'.
	 * @param	banks	the value to remove.
	 */
	
	public void removeBanks(Bank banks) {
		if (!this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
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
		return version;
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
