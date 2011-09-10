package de.genesez.example.java.BankTutorial.Server.data;

/* PROTECTED REGION ID(java.type.import._16_0_129203bc_1271068733796_737386_1190) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/* PROTECTED REGION END */

@Entity
@Table(name = "tbl_Address")
public class Address implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association CONTACT to Contact */
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
	 * constructor for class '<em><b>Address</b></em>'
	 */
	public Address() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>street</b></em>'
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * documented here {@link getStreet()}
	 * @generated	setter method for the attribute '<em><b>street</b></em>'
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * getter for the attribute '<em><b>houseNumber</b></em>'
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * documented here {@link getHouseNumber()}
	 * @generated	setter method for the attribute '<em><b>houseNumber</b></em>'
	 */
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	/**
	 * getter for the attribute '<em><b>zipCode</b></em>'
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * documented here {@link getZipCode()}
	 * @generated	setter method for the attribute '<em><b>zipCode</b></em>'
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	/**
	 * getter for the attribute '<em><b>city</b></em>'
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * documented here {@link getCity()}
	 * @generated	setter method for the attribute '<em><b>city</b></em>'
	 */
	public void setCity(String city) {
		this.city = city;
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068733796_737386_1190) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */

}
