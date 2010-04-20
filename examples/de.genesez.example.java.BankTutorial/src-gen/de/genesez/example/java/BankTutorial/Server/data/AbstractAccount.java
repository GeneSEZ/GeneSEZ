package de.genesez.example.java.BankTutorial.Server.data;

/*PROTECTED REGION ID(java.type.import._16_0_129203bc_1271068742187_845611_1236) ENABLED START*/
/* TODO: put your own source code here */
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/*PROTECTED REGION END*/

/**
 * abstract class for a bank account
 * No account allows a negative balance.
 * @author	apflueger
 */

@Entity
@Table(name = "tbl_AbstractAccount")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING)
public abstract class AbstractAccount implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	/** stores the associated object of association BANK to Bank */
	@ManyToOne(cascade = {})
	private Bank bank;
	
	/** stores the associated object of association OWNER to Customer */
	@ManyToOne(cascade = {})
	private Customer owner;
	
	/** stores associated objects of association STATEMENTS to Statement */
	@OneToMany(cascade = {
		CascadeType.REMOVE
	})
	private java.util.Set<Statement> statements = new java.util.HashSet<Statement>();
	
	/**
	 * balance of the account
	 */
	
	private BigDecimal balance;
	
	/**
	 * interest rate in percent
	 */
	
	private float interestRate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Version
	private int version;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>AbstractAccount</b></em>'
	 */
	public AbstractAccount() {
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
	 * documented here {@link getBalance()}
	 * @generated	setter method for the attribute '<em><b>balance</b></em>'
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
	 * documented here {@link getInterestRate()}
	 * @generated	setter method for the attribute '<em><b>interestRate</b></em>'
	 */
	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
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
