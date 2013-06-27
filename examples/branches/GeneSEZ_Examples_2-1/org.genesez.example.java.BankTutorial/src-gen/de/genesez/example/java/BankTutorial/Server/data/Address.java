package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068733796_737386_1190) 
 */

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */

@Entity
@Table(name = "tbl_Address")
public class Address implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association CONTACT to Contact */
	@OneToOne(cascade = {})
	private Contact contact;
	
	private String street;
	
	private String houseNumber;
	
	private String zipCode;
	
	private String city;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Address</b></em>'.
	 */
	
	public Address() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>street</b></em>'
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the value of attribute '<em><b>street</b></em>'
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Returns the value of attribute '<em><b>houseNumber</b></em>'
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * Sets the value of attribute '<em><b>houseNumber</b></em>'
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * Returns the value of attribute '<em><b>zipCode</b></em>'
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>zipCode</b></em>'
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Returns the value of attribute '<em><b>city</b></em>'
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the value of attribute '<em><b>city</b></em>'
	 */
	public void setCity(String city) {
		this.city = city;
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068733796_737386_1190) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
