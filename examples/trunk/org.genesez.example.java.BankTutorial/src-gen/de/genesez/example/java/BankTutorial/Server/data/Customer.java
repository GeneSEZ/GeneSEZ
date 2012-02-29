package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068737906_801239_1213) 
 */

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author domwet
 */

@Entity
@Table(name = "tbl_Customer")
public class Customer implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association CONTACT to Contact */
	@OneToOne(cascade = {
		CascadeType.ALL
	})
	private Contact contact;
	
	/** Stores associated objects of association ACCOUNTS to AbstractAccount */
	@OneToMany(cascade = {
		CascadeType.ALL
	})
	private java.util.Set<AbstractAccount> accounts = new java.util.HashSet<AbstractAccount>();
	
	/** Stores associated objects of association BANKS to Bank */
	@ManyToMany(cascade = {})
	private java.util.Set<Bank> banks = new java.util.HashSet<Bank>();
	
	private String firstname;
	
	private String surname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Customer</b></em>'.
	 */
	
	public Customer() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>firstname</b></em>'
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the value of attribute '<em><b>firstname</b></em>'
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * Returns the value of attribute '<em><b>surname</b></em>'
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * Sets the value of attribute '<em><b>surname</b></em>'
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Sets the value of attribute '<em><b>id</b></em>'
	 */
	public void setId(int id) {
		this.id = id;
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
	 * accessor for association to contact
	 */
	public Contact getContact() {
		return contact;
	}
	
	/**
	 * accessor for association to contact
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	/**
	 * accessor for association to accounts
	 */
	public java.util.Set<AbstractAccount> getAccounts() {
		return this.accounts;
		
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void insertInAccounts(AbstractAccount accounts) {
		if (this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.add(accounts);
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void removeFromAccounts(AbstractAccount accounts) {
		if (!this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.remove(accounts);
	}
	
	/**
	 * accessor for association to banks
	 */
	public java.util.Set<Bank> getBanks() {
		return this.banks;
		
	}
	
	/**
	 * accessor for association to banks
	 */
	public void insertInBanks(Bank banks) {
		if (this.banks.contains(banks)) {
			return;
		}
		this.banks.add(banks);
	}
	
	/**
	 * accessor for association to banks
	 */
	public void removeFromBanks(Bank banks) {
		if (!this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068737906_801239_1213) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
