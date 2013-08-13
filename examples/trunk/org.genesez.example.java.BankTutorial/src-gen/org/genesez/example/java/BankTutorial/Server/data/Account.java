package org.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068742187_845611_1236) 
 */
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * abstract class for a bank account
 * No account allows a negative balance.
 */
@Entity
@Table(name = "tbl_Account")
public abstract class Account implements Serializable {
	
	/** Stores the linked object of association '<em><b>bank</b></em>' */
	@ManyToOne(cascade = {})
	private Bank bank;
	
	/** Stores the linked object of association '<em><b>owner</b></em>' */
	@ManyToOne(cascade = {})
	private Customer owner;
	
	/** Stores all linked objects of association '<em><b>statements</b></em>' */
	@OneToMany(cascade = { CascadeType.REMOVE })
	private java.util.Set<Statement> statements = new java.util.HashSet<Statement>();
	
	/**
	 * balance of the account
	 */
	
	private BigDecimal balance;
	
	/**
	 * interest rate in percent
	 */
	
	private float interestRate;
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 */
	
	private long interestPeriod;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	/**
	 * Constructor for class '<em><b>Account</b></em>'.
	 */
	
	public Account() {
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
		this.bank = bank;
	}
	
	/**
	 * Returns the linked object of association '<em><b>owner</b></em>'.
	 */
	
	public Customer getOwner() {
		return owner;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>owner</b></em>'.
	 * @param	owner	the object to associate.
	 */
	
	public void setOwner(Customer owner) {
		if (this.owner == owner) {
			return;
		}
		Customer former = this.owner;
		this.owner = owner;
		if (former != null) {
			former.removeAccounts(this);
		}
		if (owner != null) {
			owner.addAccounts(this);
		}
	}
	
	/**
	 * Returns all linked objects of association '<em><b>statements</b></em>'.
	 */
	
	public java.util.Set<Statement> getStatements() {
		return statements;
	}
	
	/**
	 * Establishes a link to the specified object for association '<em><b>statements</b></em>'.
	 * @param	statements	the object to associate.
	 */
	
	public void addStatements(Statement statements) {
		if (statements == null || this.statements.contains(statements)) {
			return;
		}
		this.statements.add(statements);
	}
	
	/**
	 * Removes the link to the specified specified object from association '<em><b>statements</b></em>'.
	 * @param	statements	the object to remove.
	 */
	
	public void removeStatements(Statement statements) {
		if (statements == null || !this.statements.contains(statements)) {
			return;
		}
		this.statements.remove(statements);
	}
	
	/**
	 * balance of the account
	 */
	
	public BigDecimal getBalance() {
		return this.balance;
	}
	
	/**
	 * balance of the account
	 * @param	balance	the value to set.
	 */
	
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * interest rate in percent
	 */
	
	public float getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * interest rate in percent
	 * @param	interestRate	the value to set.
	 */
	
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 */
	
	public long getInterestPeriod() {
		return this.interestPeriod;
	}
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 * @param	interestPeriod	the value to set.
	 */
	
	public void setInterestPeriod(long interestPeriod) {
		this.interestPeriod = interestPeriod;
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
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068742187_845611_1236) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
