package Bank_Tutorial_Weld_Server.bankgroupServer.entity;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462950358_713082_482_AddressHome) ENABLED START */
/* TODO: put your own source code here */
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import Bank_Tutorial_Weld_Server.qualifier.BankDatabase;

/* PROTECTED REGION END */

/**
 */

@Named
@ConversationScoped
@Stateful(name = "AddressHome")
public class AddressHome extends HomeBean<Address, EntityManager> {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private BankgroupHome bankgroupHome;
	
	@Inject
	private BankHome bankHome;
	
	@Inject
	private CustomerHome customerHome;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public List<Address> getAddressList() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.getAddressList) ENABLED START */
		// Alle Addressen auslesen
		List<Address> addressList = getList();
		return addressList;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public long getAddressListCount() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.getAddressListCount) ENABLED START */
		return getAddressList().size();
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public EntityManager getEntityManager() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.getEntityManager) ENABLED START */
		return entityManager;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	public void wire() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.wire) ENABLED START */
		// Nothing to do
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	@Remove
	public void removeEjb() {
		/* PROTECTED REGION ID(java.implementation.AddressHome.removeEjb) ENABLED START */

		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462950358_713082_482_AddressHome) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@Inject
	@BankDatabase
	private EntityManager entityManager;
	/* PROTECTED REGION END */

}
