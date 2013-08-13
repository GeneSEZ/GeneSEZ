package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068723343_566691_1144) 
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.ManyToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Bank")
public class Bank implements Serializable {
	
	/** Stores all linked objects of association '<em><b>contact</b></em>' */
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
	private java.util.Set<Contact> contact = new java.util.HashSet<Contact>();
	
	/** Stores all linked objects of association '<em><b>customers</b></em>' */
	@ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "banks")
	private java.util.Set<Customer> customers = new java.util.HashSet<Customer>();
	
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@Column(name = "sortCode", unique = true, nullable = false)
	private int sortCode;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Bank</b></em>'.
	 */
	
	public Bank() {
	}
	
	/**
	 * Returns all linked objects of association '<em><b>contact</b></em>'.
	 */
	
	public java.util.Set<Contact> getContact() {
		return contact;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>contact</b></em>'.
	 * @param	contact	the object to associate.
	 */
	
	public void addContact(Contact contact) {
		if (contact == null || this.contact.contains(contact)) {
			return;
		}
		this.contact.add(contact);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>contact</b></em>'.
	 * @param	contact	the object to remove.
	 */
	
	public void removeContact(Contact contact) {
		if (contact == null || !this.contact.contains(contact)) {
			return;
		}
		this.contact.remove(contact);
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
		customers.addBanks(this);
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
		customers.removeBanks(this);
	}
	
	/**
	 * Returns the value of attribute '<em><b>name</b></em>'.
	 */
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the value of attribute '<em><b>name</b></em>'.
	 * @param	name	the value to set.
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the value of attribute '<em><b>sortCode</b></em>'.
	 */
	
	public int getSortCode() {
		return this.sortCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>sortCode</b></em>'.
	 * @param	sortCode	the value to set.
	 */
	
	public void setSortCode(int sortCode) {
		this.sortCode = sortCode;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068723343_566691_1144) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
