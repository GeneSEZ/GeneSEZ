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
	
	/** Stores the associated object of association BANK to Bank */
	@ManyToOne(cascade = {})
	private Bank bank;
	
	/** Stores the associated object of association OWNER to Customer */
	@ManyToOne(cascade = {})
	private Customer owner;
	
	/** Stores associated objects of association STATEMENTS to Statement */
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
	 * balance of the account
	 */
	
	public BigDecimal getBalance() {
		return balance;
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
		return interestRate;
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
		return interestPeriod;
	}
	
	/**
	 * period of time (in ms) after the bank has to deposit the interests to an account
	 * @param	interestPeriod	the value to set.
	 */
	
	public void setInterestPeriod(long interestPeriod) {
		this.interestPeriod = interestPeriod;
	}
	
	/**
	 * Returns the value of attribute '<em><b>bank</b></em>'.
	 */
	
	public Bank getBank() {
		return bank;
	}
	
	/**
	 * Sets the value of attribute '<em><b>bank</b></em>'.
	 * @param	bank	the value to set.
	 */
	
	public void setBank(Bank bank) {
		
		this.bank = bank;
	}
	
	/**
	 * Returns the value of attribute '<em><b>owner</b></em>'.
	 */
	
	public Customer getOwner() {
		return owner;
	}
	
	/**
	 * Sets the value of attribute '<em><b>owner</b></em>'.
	 * @param	owner	the value to set.
	 */
	
	public void setOwner(Customer owner) {
		
		this.owner = owner;
	}
	
	/**
	 * Returns the value of attribute '<em><b>statements</b></em>'.
	 */
	
	public java.util.Set<Statement> getStatements() {
		return statements;
	}
	
	/**
	 * Adds the specified value to the attribute '<em><b>statements</b></em>'.
	 * @param	statements	the value to add.
	 */
	
	public void addStatements(Statement statements) {
		if (this.statements.contains(statements)) {
			return;
		}
		this.statements.add(statements);
	}
	
	/**
	 * Removes the specified value from the attribute '<em><b>statements</b></em>'.
	 * @param	statements	the value to remove.
	 */
	
	public void removeStatements(Statement statements) {
		if (!this.statements.contains(statements)) {
			return;
		}
		this.statements.remove(statements);
	}
	
	/**
	 * Returns the value of attribute '<em><b>id</b></em>'.
	 */
	
	public int getId() {
		return id;
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
		return version;
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
