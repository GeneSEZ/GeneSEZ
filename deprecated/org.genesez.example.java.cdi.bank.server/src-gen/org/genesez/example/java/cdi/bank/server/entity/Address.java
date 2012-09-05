package org.genesez.example.java.cdi.bank.server.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462950358_713082_482) 
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import org.genesez.example.java.cdi.bank.server.IEntityBase;

/**
 */
@Entity
@Table(name = "tbl_Address")
public class Address implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association BANKGROUP to Bankgroup */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "address")
	private Bankgroup bankgroup;
	
	/** Stores the associated object of association BANK to Bank */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "address")
	private Bank bank;
	
	/** Stores the associated object of association CUSTOMER to Customer */
	@OneToOne(cascade = {})
	private Customer customer;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String street;
	
	private String houseNumber;
	
	private String postCode;
	
	private String city;
	
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
	 * Returns the value of attribute '<em><b>id</b></em>'
	 */
	public long getId() {
		return id;
		
	}
	
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
	 * Returns the value of attribute '<em><b>postCode</b></em>'
	 */
	public String getPostCode() {
		return postCode;
		
	}
	
	/**
	 * Sets the value of attribute '<em><b>postCode</b></em>'
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	 * accessor for association to bankgroup
	 */
	public Bankgroup getBankgroup() {
		return bankgroup;
	}
	
	/**
	 * accessor for association to bankgroup
	 */
	public void setBankgroup(Bankgroup bankgroup) {
		this.bankgroup = bankgroup;
	}
	
	/**
	 * accessor for association to bank
	 */
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * accessor for association to bank
	 */
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	/**
	 * accessor for association to customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * accessor for association to customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PROTECTED REGION END */
	
}
