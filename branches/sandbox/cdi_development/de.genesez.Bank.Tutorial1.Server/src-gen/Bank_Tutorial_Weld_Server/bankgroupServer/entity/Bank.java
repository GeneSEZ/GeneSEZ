package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462918311_582104_470) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import Bank_Tutorial_Weld_Server.bankgroupServer.IEntityBase;

/* PROTECTED REGION END */

/**
 */

@Entity
@Table(name = "tbl_Bank")
public class Bank implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association BANKGROUP to Bankgroup */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bankgroup bankgroup;
	
	/** stores associated objects of association ACCOUNTS to Account */
	@OneToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	@Basic(optional = true)
	private java.util.Set<Account> accounts = new java.util.HashSet<Account>();
	
	/** stores the associated object of association ADDRESS to Address */
	@OneToOne(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	private Address address;
	
	/** stores associated objects of association CUSTOMERS to Customer */
	@OneToMany(cascade = {}, fetch = FetchType.EAGER, mappedBy = "bank")
	private java.util.Set<Customer> customers = new java.util.HashSet<Customer>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sortCode;
	
	private String name;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>Bank</b></em>'
	 */
	public Bank() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>sortCode</b></em>'
	 */
	public long getSortCode() {
		return sortCode;
	}
	
	/**
	 * getter for the attribute '<em><b>name</b></em>'
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * documented here {@link getName()}
	 * @generated	setter method for the attribute '<em><b>name</b></em>'
	 */
	public void setName(String name) {
		this.name = name;
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
	 * accessor for association to accounts
	 */
	public java.util.Set<Account> getAccounts() {
		return this.accounts;
		
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void insertInAccounts(Account accounts) {
		if (this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.add(accounts);
		accounts.setBank(this);
	}
	
	/**
	 * accessor for association to accounts
	 */
	public void removeFromAccounts(Account accounts) {
		if (!this.accounts.contains(accounts)) {
			return;
		}
		this.accounts.remove(accounts);
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
	
	/**
	 * accessor for association to customers
	 */
	public java.util.Set<Customer> getCustomers() {
		return this.customers;
		
	}
	
	/**
	 * accessor for association to customers
	 */
	public void insertInCustomers(Customer customers) {
		if (this.customers.contains(customers)) {
			return;
		}
		this.customers.add(customers);
		customers.setBank(this);
	}
	
	/**
	 * accessor for association to customers
	 */
	public void removeFromCustomers(Customer customers) {
		if (!this.customers.contains(customers)) {
			return;
		}
		this.customers.remove(customers);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462918311_582104_470) ENABLED START */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String bankString = new String();
		
		bankString = "Bank: [";
		bankString += " name: " + this.getName();
		bankString += ", sortcode: " + String.valueOf(this.getSortCode());
		bankString += ", address: " + (this.getAddress() != null ? this.getAddress().toString() : "null");
		bankString += ", bankgroup: " + (this.getBankgroup() != null ? this.getBankgroup().toString() : "null");
		bankString += ", customers: [";
		if (this.getCustomers() != null)
			for (Customer customer : this.getCustomers()) {
				bankString += " " + customer.toString();
			}
		else
			bankString += "null";
		this.getCustomers().toString();
		bankString += "]";
		bankString += "]";
		
		return bankString;
	}
	
	public long getId() {
		return sortCode;
	}
	
	/* PROTECTED REGION END */

}
