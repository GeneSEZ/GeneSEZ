package server;/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_590059_1207998892896_185347_634OwnManualImports) ENABLED START *//* TODO: put your own source code here */import javax.persistence.GeneratedValue;import javax.persistence.GenerationType;import javax.persistence.ManyToOne;import javax.persistence.CascadeType;import javax.persistence.Entity;import javax.persistence.Table;import java.io.Serializable;import javax.persistence.Id;import javax.persistence.OneToMany;/* PROTECTED REGION END *//** * The account class provides information for a normal money account. It has a unique accountNumber, the balance and the actual statementNumber. Money can be withdrawed or deposit. With the help of statements the customer can control the turnovers. The account class adminitrates the statements and make them available for the customer. An account can only be owned by one customer. * @author	X */@Entity@Table(name = "tbl_Account")public class Account implements Serializable {		/**	 * generated variable, constant and association declarations	 *	 */	/**	 * documented here {@link getBalance()}	 * @generated	attribute definition	 */		private float balance = 0.0f;	/**	 * @generated	attribute definition	 */		@Id	@GeneratedValue(strategy = GenerationType.AUTO)	private int accountNumber;	/**	 * @generated	attribute definition	 */		private int statementNumber = 0;	/**	 * variable for association to statements	 */		@OneToMany(cascade = {		CascadeType.ALL	})	private java.util.Set<Statement> statements = new java.util.HashSet<Statement>();	/**	 * variable for association to owner	 */		@ManyToOne(cascade = {		CascadeType.ALL	})	private Customer owner;		/**	 * generated constructor implementations	 *	 */	/**	 * @generated	constructor for class '<em><b>Account</b></em>'	 */	public Account() {		/* PROTECTED REGION ID(java.constructor.StandardConstructorAccount) ENABLED START */		// TODO: implementation of constructor for class 'Account'		/* PROTECTED REGION END */	}		/**	 * generated derived attribute method implementations	 *	 */		/**	 * generated association method implementations	 *	 */	public java.util.Set<Statement> getStatements() {		return java.util.Collections.unmodifiableSet(statements);	}		/**	 * accessor for association to statements	 */	public void insertInStatements(Statement statements) {		if (this.statements.contains(statements)) {			return;		}		this.statements.add(statements);	}		/**	 * accessor for association to statements	 */	public void removeFromStatements(Statement statements) {		if (!this.statements.contains(statements)) {			return;		}		this.statements.remove(statements);	}		public Customer getOwner() {		return owner;	}		/**	 * accessor for association to owner	 */		/**	 * accessor for association to owner	 */	public void setOwner(Customer owner) {		this.owner = owner;	}		/**	 * accessor for association to owner	 */		/**	 * generated abstract method declaration	 *	 */		/**	 * generated normal method implementations	 *	 */		/**	 * @generated	method stub for further implementation	 * @param	amount		 * @return		 */	public float withdraw(float amount) {		/* PROTECTED REGION ID(java.implementation._14_0_590059_1208212563143_720079_470) ENABLED START */		// TODO: implementation of method 'Account.withdraw(...)'		float returnValue = -1;		if (balance >= amount) {			balance -= amount;			statements.add(new Statement("Withdraw of " + amount + " Euro\nNew balance is " + balance + ".\n\n", statementNumber));			statementNumber++;			returnValue = amount;		}		return returnValue;		/* PROTECTED REGION END */	}		/**	 * @generated	method stub for further implementation	 * @param	amount		 */	public void deposit(float amount) {		/* PROTECTED REGION ID(java.implementation._14_0_590059_1208212613626_554815_474) ENABLED START */		// TODO: implementation of method 'Account.deposit(...)'		balance += amount;		statements.add(new Statement("Deposit of " + amount + " Euro\nNew balance is " + balance + ".\n\n", statementNumber));		statementNumber++;		/* PROTECTED REGION END */	}		/**	 * @generated	method stub for further implementation	 * @return		 */	public String getStatement() {		/* PROTECTED REGION ID(java.implementation._14_0_590059_1209547538185_661055_970) ENABLED START */		// TODO: implementation of method 'Account.getStatement(...)'		String returnValue = "";		boolean printed = false;		try {			for (Statement statement : statements){				if (!statement.hasBeenPrinted()) {					printed = true;					returnValue += statement.getStatement();				}			}		} catch (NullPointerException npe) {			npe.printStackTrace();			returnValue = "-1";		}		if (!printed) {			returnValue = "There are currently no statements available!\n";		}		return returnValue;		/* PROTECTED REGION END */	}		/**	 * generated getter and setter method implementations	 *	 */	/**	 * 	 * @generated	getter for the attribute '<em><b>balance</b></em>'	 */	public float getBalance() {		return balance;	}		/**	 * documented here {@link getBalance()}	 * @generated	setter method for the attribute '<em><b>balance</b></em>'	 */	public void setBalance(float balance) {		this.balance = balance;	}		/**	 * @generated	getter for the attribute '<em><b>accountNumber</b></em>'	 */	public int getAccountNumber() {		return accountNumber;	}		/**	 * documented here {@link getAccountNumber()}	 * @generated	setter method for the attribute '<em><b>accountNumber</b></em>'	 */	public void setAccountNumber(int accountNumber) {		this.accountNumber = accountNumber;	}		/**	 * @generated	getter for the attribute '<em><b>statementNumber</b></em>'	 */	public int getStatementNumber() {		return statementNumber;	}		/**	 * documented here {@link getStatementNumber()}	 * @generated	setter method for the attribute '<em><b>statementNumber</b></em>'	 */	public void setStatementNumber(int statementNumber) {		this.statementNumber = statementNumber;	}		/**	 * generated methods from the implementing interface(s)	 * Serializable	 *	 */		/**	 * own implementations	 *	 */	/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_590059_1207998892896_185347_634) ENABLED START */	/* TODO put your own implementation code here */	/**	 */	//	private void init() {	//			//		//accountNumber = new Random().nextInt(999999);	//		statements = new HashSet<Statement>();	//		statementNumber = 0;	//		balance = 0;	//	//	}	/* PROTECTED REGION END */}