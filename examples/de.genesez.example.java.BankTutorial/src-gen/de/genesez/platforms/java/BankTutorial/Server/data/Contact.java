package de.genesez.platforms.java.BankTutorial.Server.data;

/*PROTECTED REGION ID(java.type.import._16_0_129203bc_1271068727843_795301_1167) ENABLED START*/
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/*PROTECTED REGION END*/

@Entity
@Table(name = "tbl_Contact")
public class Contact implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association ADDRESS to Address */
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
	 * constructor for class '<em><b>Contact</b></em>'
	 */
	public Contact() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>phone</b></em>'
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * documented here {@link getPhone()}
	 * @generated	setter method for the attribute '<em><b>phone</b></em>'
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * getter for the attribute '<em><b>mobilePhone</b></em>'
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	
	/**
	 * documented here {@link getMobilePhone()}
	 * @generated	setter method for the attribute '<em><b>mobilePhone</b></em>'
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * getter for the attribute '<em><b>telefax</b></em>'
	 */
	public String getTelefax() {
		return telefax;
	}
	
	/**
	 * documented here {@link getTelefax()}
	 * @generated	setter method for the attribute '<em><b>telefax</b></em>'
	 */
	public void setTelefax(String telefax) {
		this.telefax = telefax;
	}
	
	/**
	 * getter for the attribute '<em><b>email</b></em>'
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * documented here {@link getEmail()}
	 * @generated	setter method for the attribute '<em><b>email</b></em>'
	 */
	public void setEmail(String email) {
		this.email = email;
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
