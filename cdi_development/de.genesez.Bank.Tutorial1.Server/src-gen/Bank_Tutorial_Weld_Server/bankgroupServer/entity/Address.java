package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462950358_713082_482) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import Bank_Tutorial_Weld_Server.bankgroupServer.IEntityBase;

/* PROTECTED REGION END */

/**
 */

@Entity
@Table(name = "tbl_Address")
public class Address implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association BANKGROUP to Bankgroup */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "address")
	private Bankgroup bankgroup;
	
	/** stores the associated object of association BANK to Bank */
	@OneToOne(cascade = {})
	private Bank bank;
	
	/** stores the associated object of association CUSTOMER to Customer */
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
	 * constructor for class '<em><b>Address</b></em>'
	 */
	public Address() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>id</b></em>'
	 */
	public long getId() {
		return id;
	}
	
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
	 * getter for the attribute '<em><b>postCode</b></em>'
	 */
	public String getPostCode() {
		return postCode;
	}
	
	/**
	 * documented here {@link getPostCode()}
	 * @generated	setter method for the attribute '<em><b>postCode</b></em>'
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
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
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482) ENABLED START */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/* PROTECTED REGION END */

}
