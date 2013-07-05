package Bank_Tutorial_Weld_Server.bankgroupServer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.Stateful;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import Bank_Tutorial_Weld_Server.bankgroupServer.entity.Account;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.Address;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.Bank;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.Bankgroup;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.Customer;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.User;
import Bank_Tutorial_Weld_Server.bankgroupServer.event.ApplicationStartedEvent;
import Bank_Tutorial_Weld_Server.qualifier.BankDatabase;

@Stateful
public class DatabaseFiller implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ist Datenbank bereits gefüllt?
	 */
	private static boolean isInitialized = false;

	@Inject
	@BankDatabase
	private EntityManager database;
	
	/**
	 * Der Konstruktor.
	 */
	public DatabaseFiller(){}

	/**
	 * Initialisieren der Datenbankinhalte.
	 * 
	 * @return
	 */
	public void initDatabase(@Observes ApplicationStartedEvent event)
	{
		System.out.println("Init FillDatabase.");
		if(DatabaseFiller.isInitialized == false)
		{
			prepareDatabase();
			DatabaseFiller.isInitialized = true;
		}
	}
	
	/**
	 * Befüllen der Datenbank mit Standardwerten.
	 */
	private void prepareDatabase()
	{
		// Base data
		List<Bank> banks = new ArrayList<Bank>();
		List<Bankgroup> bankgroups = new ArrayList<Bankgroup>();
		List<Account> accounts = new ArrayList<Account>();
		List<Customer> customers = new ArrayList<Customer>();
		List<Address> addresses = new ArrayList<Address>();
		List<User> users = new ArrayList<User>();
		
		addresses 	= buildAddresses(addresses);
		bankgroups 	= buildBankgroups(bankgroups, addresses);
		banks 		= buildBanks(banks, bankgroups, addresses);	
		customers 	= buildCustomers(customers, addresses, banks);
		accounts 	= buildAccounts(accounts, customers, banks);
		users       = buildUsers(users);
		
		
		Bank bank = banks.get(4);
		bankgroups.get(0).insertInBanks(bank);
		
		database.flush();
	}

	/**
	 * Erzeugt eine Liste von Standardadressen.
	 * 
	 * @param addresses
	 * @return
	 */
	private List<Address> buildAddresses(List<Address> addresses) {
		addresses.add(createAddress("Forststr.", "17", "08261", "Schöneck"));
		addresses.add(createAddress("Richard-Wagner-Str.", "12", "08248", "Klingenthal"));
		addresses.add(createAddress("Hauptstr.", "1", "08056", "Zwickau"));
		addresses.add(createAddress("Am Alexanderplatz", "9", "10210", "Berlin"));
		addresses.add(createAddress("Am Markt", "2a", "08248", "Klingenthal"));
		addresses.add(createAddress("Hauptstr.", "1", "08056", "Zwickau"));
		addresses.add(createAddress("Berliner Allee", "120", "10102", "Berlin"));
		return addresses;
	}

	/**
	 * Erzeugt eine Liste von Standardbankgengruppen.
	 * 
	 * @param bankgroups
	 * @param addresses
	 * @return
	 */
	private List<Bankgroup> buildBankgroups(List<Bankgroup> bankgroups,
			List<Address> addresses) {
		bankgroups.add(createBankgroup("Sparkasse", addresses.get(2) ));
		bankgroups.add(createBankgroup("Cash Group", addresses.get(3) ));
		bankgroups.add(createBankgroup("Online Bank Group", addresses.get(4) ));
		return bankgroups;
	}

	/**
	 * Erzeugt eine Liste von Standardbanken.
	 * 
	 * @param banks
	 * @param bankgroups
	 * @param addresses
	 * @return
	 */
	private List<Bank> buildBanks(List<Bank> banks,
			List<Bankgroup> bankgroups, List<Address> addresses) {
		banks.add(createBank("Sparkasse Vogtland", addresses.get(4), bankgroups.get(0) ));
		banks.add(createBank("Deutsche Bank", addresses.get(3), bankgroups.get(1) ));
		banks.add(createBank("Dresdner Bank", addresses.get(3), bankgroups.get(1) ));
		banks.add(createBank("Ing DiBa", addresses.get(6), bankgroups.get(2) ));
		banks.add(createBank("Targo Bank", addresses.get(5), bankgroups.get(2) ));
		return banks;
	}

	/**
	 * Erzeugt eine Liste von Standardkunden.
	 * 
	 * @param customers
	 * @param addresses
	 * @param banks
	 * @return
	 */
	private List<Customer> buildCustomers(List<Customer> customers,
			List<Address> addresses, List<Bank> banks) {
		customers.add(createCustomer("Hans", "Wurst", addresses.get(1), banks.get(1)));
		customers.add(createCustomer("Frieda", "Müller", addresses.get(1), banks.get(1)));
		customers.add(createCustomer("Ingo", "Kunze", addresses.get(5), banks.get(2)));
		customers.add(createCustomer("Helga", "Mayer", addresses.get(0), banks.get(4)));
		return customers;
	}


	/**
	 * Erzeugt eine List von Standardkonten.
	 * 
	 * @param accounts
	 * @param customers
	 * @param banks
	 * @return
	 */
	private List<Account> buildAccounts(List<Account> accounts,
			List<Customer> customers, List<Bank> banks) {
		accounts.add(createAccount( (float) 100.0, customers.get(0), customers.get(0).getBank()));
		accounts.add(createAccount( (float) 200.0, customers.get(1), customers.get(1).getBank()));
		accounts.add(createAccount( (float) 10000.0, customers.get(2), customers.get(2).getBank()));
		accounts.add(createAccount( (float) 954180.0, customers.get(3), customers.get(3).getBank()));
		
		return accounts;
	}

	/**
	 * Erzeugt eine Liste von Standardbenutzern.
	 * 
	 * @param users
	 * @return
	 */
	private List<User> buildUsers(List<User> users) {
		users.add(createUser("Tester", "123456"));
		users.add(createUser("Nancy", "123456"));
		users.add(createUser("Marco", "123456"));
		return users;
	}
	
	/**
	 * Speichert eine Adresse in der Datenbank.
	 * 
	 * @param street
	 * @param houseNumber
	 * @param postCode
	 * @param city
	 * @return
	 */
	private Address createAddress(String street, String houseNumber, String postCode,
			String city) {
		Address address = new Address();		
		address.setStreet(street);
		address.setHouseNumber(houseNumber);
		address.setPostCode(postCode);
		address.setCity(city);
		
		database.persist(address);
		return address;
	}

	/**
	 * Speichert eine Bankengruppe in der Datenbank.
	 * 
	 * @param name
	 * @param address
	 * @return
	 */
	private Bankgroup createBankgroup(String name, Address address) {
		Bankgroup bankgroup = new Bankgroup();
		bankgroup.setName(name);
		bankgroup.setAddress(address);
		address.setBankgroup(bankgroup);
		
		database.persist(bankgroup);
		return bankgroup;
	}
	
	/**
	 * Speichert eine Bank in der Datenbank.
	 * 
	 * @param name
	 * @param address
	 * @param bankgroup
	 * @return
	 */
	private Bank createBank(String name, Address address, Bankgroup bankgroup) {
		Bank bank = new Bank();
		bank.setName(name);
		
		bank.setAddress(address);
		address.setBank(bank);
		
		bankgroup.insertInBanks(bank);
		
		database.persist(bank);
		return bank;
	}	
	
	/**
	 * Speichert einen Kunden in der Datenbank.
	 * 
	 * @param name
	 * @param sirname
	 * @return
	 */
	private Customer createCustomer(String name, String sirName, Address address, Bank bank) {
		Random random = new Random();
		long customerNumber = random.nextInt(100000000);
		
		Customer customer = new Customer();
		customer.setFirstName(name);
		customer.setSirName(sirName);
		customer.setAddress(address);
		address.setCustomer(customer);
		
		bank.insertInCustomers(customer);

		customer.setCustomerNumber(customerNumber);			

		try {
			database.persist(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	/**
	 * Speichert ein Konto in der Datenbank.
	 *  
	 * @param amount
	 * @param customer
	 * @param bank
	 * @return
	 */
	private Account createAccount(float amount, Customer customer, Bank bank) {
		Random random = new Random();
		long accountNumber = random.nextInt(1000000);
		
		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);
		
		bank.insertInAccounts(account);
		account.insertInCustomers(customer);
		
		database.persist(account);
		return account;
	}	
	
	
	/**
	 * Speichert einen Benutzer in der Datenbank.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private User createUser(String username, String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setInsertDate(new Date());
		
		database.persist(user);
		
		return user;
	}
	
}
