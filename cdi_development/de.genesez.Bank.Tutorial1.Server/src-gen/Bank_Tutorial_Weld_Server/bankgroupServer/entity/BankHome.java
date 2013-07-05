package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462918311_582104_470_BankHome) ENABLED START */
/* TODO: put your own source code here */
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/* PROTECTED REGION END */

/**
 */

@Named
@ConversationScoped
@Stateful(name = "BankHome")
public class BankHome extends HomeBean<Bank, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private BankgroupHome bankgroupHome;
	
	@Inject
	private AccountHome accountHome;
	
	@Inject
	private AddressHome addressHome;
	
	@Inject
	private CustomerHome customerHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public List<Account> getAccountList() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getAccountList) ENABLED START */
		if (getInstance() != null && getInstance().getAccounts() != null && getInstance().getCustomers().size() > 0)
			return new ArrayList<Account>(getInstance().getAccounts());
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public List<Customer> getCustomerList() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getCustomerList) ENABLED START */
		if (getInstance() != null && getInstance().getCustomers() != null && getInstance().getCustomers().size() > 0)
			return new ArrayList<Customer>(getInstance().getCustomers());
		return null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public List<Bank> getBankList() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getBankList) ENABLED START */
		// Alle Banken auslesen
		List<Bank> bankList = getList();
		return bankList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public long getBankListCount() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getBankListCount) ENABLED START */
		return getBankList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.BankHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation.BankHome.wire) ENABLED START */
		// Gibt es eine Addresse?
		if (addressHome.getId() > 0) {
			Address address = addressHome.getInstance();
			getInstance().setAddress(address);
		}
		
		// Gibt es eine neue Bank?
		if (bankgroupHome.getId() > 0) {
			Bankgroup bankgroup = bankgroupHome.getInstance();
			getInstance().setBankgroup(bankgroup);
		}
		
		// Gibt es einen neuen Kunden?
		if (customerHome.getId() > 0) {
			Customer customer = customerHome.getInstance();
			getInstance().insertInCustomers(customer);
		}
		
		// Gibt es einen neues Konto?
		if (accountHome.getId() > 0) {
			Account account = accountHome.getInstance();
			getInstance().insertInAccounts(account);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation.BankHome.removeEjb) ENABLED START */

		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462918311_582104_470_BankHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	/*
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/* PROTECTED REGION END */

}
