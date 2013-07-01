package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_1_41601a3_1267462950358_713082_482) 
 */
import Bank_Tutorial_Weld_Server.bankgroupServer.EntityBase;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
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
public class Address implements EntityBase, Serializable {
	
	/** Stores the linked object of association '<em><b>bankgroup</b></em>' */
	@OneToOne(cascade = {})
	private Bankgroup bankgroup;
	
	/** Stores the linked object of association '<em><b>bank</b></em>' */
	@OneToOne(cascade = {})
	private Bank bank;
	
	/** Stores the linked object of association '<em><b>customer</b></em>' */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "address")
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
	
	/**
	 * Constructor for class '<em><b>Address</b></em>'.
	 */
	
	public Address() {
	}
	
	/**
	 * Returns the linked object of association '<em><b>bankgroup</b></em>'.
	 */
	
	public Bankgroup getBankgroup() {
		return bankgroup;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bankgroup</b></em>'.
	 * @param	bankgroup	the object to associate.
	 */
	
	public void setBankgroup(Bankgroup bankgroup) {
		if (this.bankgroup == bankgroup) {
			return;
		}
		Bankgroup former = this.bankgroup;
		this.bankgroup = bankgroup;
		if (former != null) {
			former.setAddress(null);
		}
		if (bankgroup != null) {
			bankgroup.setAddress(this);
		}
	}
	
	/**
	 * Returns the linked object of association '<em><b>bank</b></em>'.
	 */
	
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>bank</b></em>'.
	 * @param	bank	the object to associate.
	 */
	
	public void setBank(Bank bank) {
		if (this.bank == bank) {
			return;
		}
		Bank former = this.bank;
		this.bank = bank;
		if (former != null) {
			former.setAddress(null);
		}
		if (bank != null) {
			bank.setAddress(this);
		}
	}
	
	/**
	 * Returns the linked object of association '<em><b>customer</b></em>'.
	 */
	
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>customer</b></em>'.
	 * @param	customer	the object to associate.
	 */
	
	public void setCustomer(Customer customer) {
		if (this.customer == customer) {
			return;
		}
		Customer former = this.customer;
		this.customer = customer;
		if (former != null) {
			former.setAddress(null);
		}
		if (customer != null) {
			customer.setAddress(this);
		}
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public long getId() {
		return id;
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
	 * Returns the value of attribute '<em><b>postCode</b></em>'.
	 */
	
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * Sets the value of attribute '<em><b>postCode</b></em>'.
	 * @param	postCode	the value to set.
	 */
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482) ENABLED START */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PROTECTED REGION END */
}
