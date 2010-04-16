package de.genesez.platforms.java.BankTutorial.Server.data;

/*PROTECTED REGION ID(java.type.import._16_0_129203bc_1271068737906_801239_1213) ENABLED START*/
/* TODO: put your own source code here */
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/*PROTECTED REGION END*/

@Entity
@Table(name = "tbl_Customer")
public class Customer implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association CONTACT to Contact */
	@OneToOne(cascade = {
		CascadeType.ALL
	})
	private Contact contact;
	
	/** stores associated objects of association ACCOUNTS to AbstractAccount */
	@OneToMany(cascade = {
		CascadeType.ALL
	}, mappedBy = "owner")
	private java.util.Set<AbstractAccount> accounts = new java.util.HashSet<AbstractAccount>();
	
	/** stores associated objects of association BANKS to Bank */
	@ManyToMany(cascade = {})
	private java.util.Set<Bank> banks = new java.util.HashSet<Bank>();
	
	private String firstname;
	
	private String surname;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>Customer</b></em>'
	 */
	public Customer() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>firstname</b></em>'
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * documented here {@link getFirstname()}
	 * @generated	setter method for the attribute '<em><b>firstname</b></em>'
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * getter for the attribute '<em><b>surname</b></em>'
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * documented here {@link getSurname()}
	 * @generated	setter method for the attribute '<em><b>surname</b></em>'
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * getter for the attribute '<em><b>id</b></em>'
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * documented here {@link getId()}
	 * @generated	setter method for the attribute '<em><b>id</b></em>'
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * getter for the attribute '<em><b>version</b></em>'
	 */
	public int getVersion() {
		return version;
	}
	
	/**
	 * documented here {@link getVersion()}
	 * @generated	setter method for the attribute '<em><b>version</b></em>'
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
		accounts.setOwner(this);
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
		if (!banks.getCustomers().contains(this)) {
			banks.insertInCustomers(this);
		}
	}
	
	/**
	 * accessor for association to banks
	 */
	public void removeFromBanks(Bank banks) {
		if (!this.banks.contains(banks)) {
			return;
		}
		this.banks.remove(banks);
		if (banks.getCustomers().contains(this)) {
			banks.removeFromCustomers(this);
		}
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068737906_801239_1213) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
