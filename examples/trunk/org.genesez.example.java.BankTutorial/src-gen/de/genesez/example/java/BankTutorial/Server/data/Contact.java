package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068727843_795301_1167) 
 */

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author apflueger
 */

@Entity
@Table(name = "tbl_Contact")
public class Contact implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association ADDRESS to Address */
	@OneToOne(cascade = {
		CascadeType.ALL
	}, mappedBy = "contact")
	private Address address;
	
	private String phone;
	
	private String mobilePhone;
	
	private String telefax;
	
	private String email;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Contact</b></em>'.
	 */
	
	public Contact() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * Returns the value of attribute '<em><b>phone</b></em>'
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the value of attribute '<em><b>phone</b></em>'
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Returns the value of attribute '<em><b>mobilePhone</b></em>'
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	/**
	 * Sets the value of attribute '<em><b>mobilePhone</b></em>'
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * Returns the value of attribute '<em><b>telefax</b></em>'
	 */
	public String getTelefax() {
		return telefax;
	}
	
	/**
	 * Sets the value of attribute '<em><b>telefax</b></em>'
	 */
	public void setTelefax(String telefax) {
		this.telefax = telefax;
	}
	
	/**
	 * Returns the value of attribute '<em><b>email</b></em>'
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the value of attribute '<em><b>email</b></em>'
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068727843_795301_1167) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
