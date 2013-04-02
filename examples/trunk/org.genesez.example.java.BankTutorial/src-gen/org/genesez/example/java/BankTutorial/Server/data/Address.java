package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068733796_737386_1190) 
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Address")
public class Address implements Serializable {
	
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
	
	/**
	 * Constructor for class '<em><b>Address</b></em>'.
	 */
	
	public Address() {
	}
	
	/**
	 * Returns the value of attribute '<em><b>street</b></em>'.
	 */
	
	public String getStreet() {
		return street;
	}
	
	/**
	 * Sets the value of attribute '<em><b>street</b></em>'.
	 * @param	street	the value to set.
	 */
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * Returns the value of attribute '<em><b>houseNumber</b></em>'.
	 */
	
	public String getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * Sets the value of attribute '<em><b>houseNumber</b></em>'.
	 * @param	houseNumber	the value to set.
	 */
	
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * Returns the value of attribute '<em><b>zipCode</b></em>'.
	 */
	
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>zipCode</b></em>'.
	 * @param	zipCode	the value to set.
	 */
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * Returns the value of attribute '<em><b>city</b></em>'.
	 */
	
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the value of attribute '<em><b>city</b></em>'.
	 * @param	city	the value to set.
	 */
	
	public void setCity(String city) {
		this.city = city;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068733796_737386_1190) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
