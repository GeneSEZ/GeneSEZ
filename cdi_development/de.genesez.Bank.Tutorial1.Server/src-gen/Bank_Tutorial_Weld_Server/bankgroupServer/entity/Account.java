package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462924637_558573_474) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import Bank_Tutorial_Weld_Server.bankgroupServer.IEntityBase;

/* PROTECTED REGION END */

/**
 */

@Entity
@Table(name = "tbl_Account")
public class Account implements IEntityBase, Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association BANK to Bank */
	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	private Bank bank;
	
	/** stores associated objects of association CUSTOMERS to Customer */
	@ManyToMany(cascade = {}, fetch = FetchType.EAGER)
	private java.util.Set<Customer> customers = new java.util.HashSet<Customer>();
	
	private float amount;
	
	@Id
	private long accountNumber;
	
	private AccountStateEnum state = AccountStateEnum.VALID;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>Account</b></em>'
	 */
	public Account() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @param	amount	
	 * @return	
	 */
	
	public boolean withdraw(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267529903556_687060_666) ENABLED START */
		this.amount -= amount;
		return true;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @param	amount	
	 * @return	
	 */
	
	public boolean deposit(float amount) {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1267529975721_901813_670) ENABLED START */

		this.amount += amount;
		
		return true;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * getter for the attribute '<em><b>amount</b></em>'
	 */
	public float getAmount() {
		return amount;
	}
	
	/**
	 * documented here {@link getAmount()}
	 * @generated	setter method for the attribute '<em><b>amount</b></em>'
	 */
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	/**
	 * getter for the attribute '<em><b>accountNumber</b></em>'
	 */
	public long getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * documented here {@link getAccountNumber()}
	 * @generated	setter method for the attribute '<em><b>accountNumber</b></em>'
	 */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	/**
	 * getter for the attribute '<em><b>state</b></em>'
	 */
	public AccountStateEnum getState() {
		return state;
	}
	
	/**
	 * documented here {@link getState()}
	 * @generated	setter method for the attribute '<em><b>state</b></em>'
	 */
	public void setState(AccountStateEnum state) {
		this.state = state;
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
		if (!customers.getAccounts().contains(this)) {
			customers.insertInAccounts(this);
		}
	}
	
	/**
	 * accessor for association to customers
	 */
	public void removeFromCustomers(Customer customers) {
		if (!this.customers.contains(customers)) {
			return;
		}
		this.customers.remove(customers);
		if (customers.getAccounts().contains(this)) {
			customers.removeFromAccounts(this);
		}
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462924637_558573_474) ENABLED START */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		String accountString = new String();
		accountString = "Account [ ";
		accountString += "accountNumber: " + this.accountNumber;
		accountString += ", amount: " + String.valueOf(this.amount);
		accountString += ", customer: " + (this.customers == null ? "null" : this.customers.toString());
		accountString += ", bank: " + (this.bank == null ? "null" : this.bank.toString());
		accountString += " ]";
		
		return accountString;
	}
	
	public long getId() {
		return accountNumber;
	}
	
	/* PROTECTED REGION END */

}
