package server;/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_590059_1207998935587_293390_704) ENABLED START *//* TODO put your imports here */import javax.ejb.Remote;import javax.ejb.Stateful;import javax.persistence.CascadeType;import javax.persistence.EntityManager;import javax.persistence.FetchType;import javax.persistence.OneToMany;import javax.persistence.PersistenceContext;/* PROTECTED REGION END *//** * @author X */@Remote@Statefulpublic class BankgroupBean implements Bankgroup {		// ////////////////////////////////////////////////////////////////////////	// generated variable, constant and association declarations	// ////////////////////////////////////////////////////////////////////////		private int selectedCustomerNumber = -1;		private int selectedBankCode = -1;		@PersistenceContext	private EntityManager manager;	/**	 * variable for association to banks	 * @see {@link getBanks}	 */		@OneToMany(fetch = FetchType.EAGER, cascade = {		CascadeType.ALL	})	private java.util.List<Bank> banks = new java.util.ArrayList<Bank>();		// ////////////////////////////////////////////////////////////////////////	// generated constructor implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated derived attribute method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated association method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated abstract method declaration	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated normal method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated getter and setter method implementations	// ////////////////////////////////////////////////////////////////////////		public int getSelectedCustomerNumber() {		return selectedCustomerNumber;	}		public void setSelectedCustomerNumber(int _selectedCustomerNumber) {		selectedCustomerNumber = _selectedCustomerNumber;	}		public int getSelectedBankCode() {		return selectedBankCode;	}		public void setSelectedBankCode(int _selectedBankCode) {		selectedBankCode = _selectedBankCode;	}		public EntityManager getManager() {		return manager;	}		public void setManager(EntityManager _manager) {		manager = _manager;	}		// ////////////////////////////////////////////////////////////////////////	// own implementations	// ////////////////////////////////////////////////////////////////////////		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_590059_1207998935587_293390_704) ENABLED START */	/* TODO put your own implementation code here */	@Override	public boolean bankTransfer(int sourceAccountNumber, int targetBankcode, int targetCustomerNumber, int targetAccountNumber, float amount) {		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		Account sourceAccount = manager.find(Account.class, sourceAccountNumber);		try {			if (selectedCustomer.existAccount(sourceAccount.getAccountNumber())) {				if (sourceAccount.withdraw(amount) == amount) {					Bank targetBank = manager.find(Bank.class, targetBankcode);					Customer targetCustomer = manager.find(Customer.class, targetCustomerNumber);					Account targetAccount = manager.find(Account.class, targetAccountNumber);					if (targetBank.existCustomer(targetCustomer.getCustomerNumber()) && targetCustomer.existAccount(targetAccount.getAccountNumber())) {						targetAccount.deposit(amount);						manager.flush();						return true;					}					manager.refresh(sourceAccount);					manager.refresh(targetAccount);					return false;				} else {					System.out.println("Abbuchung der " + amount + "Euro vom Quellkonto (" + sourceAccount + ") nicht möglich.");					manager.refresh(sourceAccount);					return false;				}			} else {				System.out.println("Konto " + sourceAccountNumber + " gehört nicht zum ausgewählten Kunden " + selectedCustomerNumber + ".");				return false;			}		} catch (NullPointerException npe) {			npe.printStackTrace();			return false;		}	}		@Override	public int createAccount() {		Bank selectedBank = manager.find(Bank.class, selectedBankCode);		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		try {			int accountNumber = selectedBank.createAccount(selectedCustomer.getCustomerNumber());			Account account = selectedCustomer.getAccount(accountNumber);			System.out.println("Konto mit Nummer: " + account.getAccountNumber() + " wurde erstellt.");			manager.persist(account);			manager.flush();			Account temp = manager.find(Account.class, accountNumber);			if (temp == null) {				System.out.println("Konto mit der Nummer " + accountNumber + " ist nicht im Entitymanager zu finden.");			}			return account.getAccountNumber();		} catch (NullPointerException npe) {			System.out.println(npe.toString());			return -1;		}	}		@Override	public int createBank(String name) {		Bank bank = new Bank(name);		try {			selectedBankCode = bank.getBankcode();			manager.persist(bank);			manager.flush();			Bank selectedBank = manager.find(Bank.class, selectedBankCode);			return selectedBank.getBankcode();		} catch (NullPointerException npe) {			npe.printStackTrace();			return -1;		}	}		@Override	public int createCustomer(String firstname, String sirname, String address, String postalCode, String city) {		Customer customer = new Customer(firstname, sirname, address, postalCode, city); /*, birthday*/		Bank selectedBank = manager.find(Bank.class, selectedBankCode);		try {			if (selectedBank.addCustomer(customer)) {				selectedCustomerNumber = customer.getCustomerNumber();				manager.persist(customer);				manager.flush();				System.out.println("Kunde mit Nummer: " + selectedCustomerNumber + " wurde erstellt.");				Customer temp = manager.find(Customer.class, selectedCustomerNumber);				if (temp == null) {					System.out.println("Kunde mit der Nummer " + selectedCustomerNumber + " ist nicht im Entitymanager zu finden.");				}				return selectedCustomerNumber;			} else {				return -2;			}		} catch (NullPointerException npe) {			System.out.println("bankgroupBean: " + npe.toString());			return -1;		}	}		@Override	public void deposit(int accountNumber, float amount) {		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		Account account = manager.find(Account.class, accountNumber);		try {			if (selectedCustomer.existAccount(account.getAccountNumber())) {				account.deposit(amount);			} else {				return;			}		} catch (NullPointerException npe) {			if (selectedCustomer == null) {				System.out.println("Kein CustomerObjekt über den Entity-Manager");			}			if (account == null) {				System.out.println("Kein AccountObjekt beim Kunden " + selectedCustomer.getCustomerNumber() + " vorhanden.");			}			npe.printStackTrace();		}		manager.flush();	}		@Override	public float getBalance(int accountNumber) {		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		Account account = manager.find(Account.class, accountNumber);		try {			if (selectedCustomer.existAccount(account.getAccountNumber())) {				return account.getBalance();			} else {				return -1;			}		} catch (NullPointerException npe) {			if (selectedCustomer == null) {				System.out.println("Kein CustomerObjekt über den Entity-Manager");			}			npe.printStackTrace();			return -1;		}	}		@Override	public String getStatement(int accountNumber) {		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		Account account = manager.find(Account.class, accountNumber);		String statement = "";		try {			if (selectedCustomer.existAccount(account.getAccountNumber())) {				statement = account.getStatement();			}		} catch (NullPointerException npe) {			if (selectedCustomer == null) {				System.out.println("Kein CustomerObjekt über den Entity-Manager");			}			npe.printStackTrace();		}		manager.flush();		return statement;	}		@Override	public void printAccounts(int customerNumber) {		Customer selectedCustomer = manager.find(Customer.class, customerNumber);		selectedCustomer.printAccounts();	}		@Override	public void printCustomers(int bankcode) {		Bank selectedBank = manager.find(Bank.class, bankcode);		selectedBank.printCustomers();	}		@Override	public boolean selectBank(int bankCode) {		Bank selectedBank = manager.find(Bank.class, bankCode);		try {			selectedBankCode = selectedBank.getBankcode();			//System.out.println("Im BankgroupBean wurde die Bank gewechselt. Neue Banknummer: " + selectedBankCode);			return true;		} catch (NullPointerException npe) {			npe.printStackTrace();			return false;		}	}		@Override	public boolean selectCustomer(int customerNumber) {		Bank selectedBank = manager.find(Bank.class, selectedBankCode);		Customer selectedCustomer = manager.find(Customer.class, customerNumber);		try {			if (selectedBank.getCustomer(customerNumber) != null && selectedBank.getCustomer(customerNumber).equals(selectedCustomer)) {				selectedCustomerNumber = selectedCustomer.getCustomerNumber();				//System.out.println("Im BankgroupBean wurde der Kunde gewechselt. Neue Kundennummer: " + selectedCustomerNumber);				return true;			} else {				System.out.println("Im BankgroupBean konnte der Kunde " + customerNumber + " in der Bank " + selectedBankCode + " nicht gefunden werden!");				return false;			}		} catch (NullPointerException npe) {			if (selectedCustomer == null) {				System.out.println("Customer-Objekt ist null.");			}			if (selectedBank == null) {				System.out.println("Bank-Objekt ist null.");			}			npe.printStackTrace();			return false;		}	}		@Override	public void withdraw(int accountNumber, float amount) {		Customer selectedCustomer = manager.find(Customer.class, selectedCustomerNumber);		Account account = manager.find(Account.class, accountNumber);		try {			if (selectedCustomer.existAccount(account.getAccountNumber())) {				account.withdraw(amount);			} else {				return;			}		} catch (NullPointerException npe) {			if (selectedCustomer == null) {				System.out.println("Kein CustomerObjekt über den Entity-Manager");			}			npe.printStackTrace();		}		manager.flush();	}		/* PROTECTED REGION END */}