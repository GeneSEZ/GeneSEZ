package de.genesez.example.java.BankTutorial.Server.data;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_129203bc_1271068742187_845611_1236) 
 */

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Version;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

/**
 * abstract class for a bank account
 * No account allows a negative balance.
 * @author apflueger
 */

@Entity
@Table(name = "tbl_Account")
public abstract class Account implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** Stores the associated object of association BANK to Bank */
	@ManyToOne(cascade = {})
	private Bank bank;
	
	/** Stores the associated object of association OWNER to Customer */
	@ManyToOne(cascade = {})
	private Customer owner;
	
	/** Stores associated objects of association STATEMENTS to Statement */
	
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
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>Account</b></em>'.
	 */
	
	public Account() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	
	// -- generated association + attribute accessors -----------------------
	/**
	 * balance of the account
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	
	/**
	 * balance of the account
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * interest rate in percent
	 */
	public float getInterestRate() {
		return interestRate;
	}
	
	/**
	 * interest rate in percent
	 */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 */
	public long getInterestPeriod() {
		return interestPeriod;
	}
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 */
	public void setInterestPeriod(long interestPeriod) {
		this.interestPeriod = interestPeriod;
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
	 * accessor for association to owner
	 */
	public Customer getOwner() {
		return owner;
	}
	
	/**
	 * accessor for association to owner
	 */
	public void setOwner(Customer owner) {
		this.owner = owner;
	}
	
	/**
	 * accessor for association to statements
	 */
	public java.util.Set<Statement> getStatements() {
		return this.statements;
		
	}
	
	/**
	 * accessor for association to statements
	 */
	public void insertInStatements(Statement statements) {
		if (this.statements.contains(statements)) {
			return;
		}
		this.statements.add(statements);
	}
	
	/**
	 * accessor for association to statements
	 */
	public void removeFromStatements(Statement statements) {
		if (!this.statements.contains(statements)) {
			return;
		}
		this.statements.remove(statements);
	}
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_129203bc_1271068742187_845611_1236) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
	
}
