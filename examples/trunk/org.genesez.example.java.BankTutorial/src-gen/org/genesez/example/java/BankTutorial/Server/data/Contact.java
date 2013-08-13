package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068727843_795301_1167) 
 */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
@Entity
@Table(name = "tbl_Contact")
public class Contact implements Serializable {
	
	/** Stores the linked object of association '<em><b>address</b></em>' */
	@OneToOne(cascade = { CascadeType.ALL }, mappedBy = "contact")
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
	
	/**
	 * Constructor for class '<em><b>Contact</b></em>'.
	 */
	
	public Contact() {
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
			former.setContact(null);
		}
		if (address != null) {
			address.setContact(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>phone</b></em>'.
	 */
	
	public String getPhone() {
		return this.phone;
	}
	
	/**
	 * Sets the value of attribute '<em><b>phone</b></em>'.
	 * @param	phone	the value to set.
	 */
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Returns the value of attribute '<em><b>mobilePhone</b></em>'.
	 */
	
	public String getMobilePhone() {
		return this.mobilePhone;
	}
	
	/**
	 * Sets the value of attribute '<em><b>mobilePhone</b></em>'.
	 * @param	mobilePhone	the value to set.
	 */
	
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * Returns the value of attribute '<em><b>telefax</b></em>'.
	 */
	
	public String getTelefax() {
		return this.telefax;
	}
	
	/**
	 * Sets the value of attribute '<em><b>telefax</b></em>'.
	 * @param	telefax	the value to set.
	 */
	
	public void setTelefax(String telefax) {
		this.telefax = telefax;
	}
	
	/**
	 * Returns the value of attribute '<em><b>email</b></em>'.
	 */
	
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the value of attribute '<em><b>email</b></em>'.
	 * @param	email	the value to set.
	 */
	
	public void setEmail(String email) {
		this.email = email;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068727843_795301_1167) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
