package Bank_Tutorial_Weld_Server.bankgroupServer.action;

/* PROTECTED REGION ID(java.type.import._16_0_1_41601a3_1267462849139_226690_457) ENABLED START */
/* TODO: put your own source code here */
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PreDestroy;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager; //import org.jboss.weld.context.http.HttpSessionContext;
import javax.servlet.http.HttpSession;
import Bank_Tutorial_Weld_Server.bankgroupServer.entity.User;
import Bank_Tutorial_Weld_Server.qualifier.BankDatabase;
import Bank_Tutorial_Weld_Server.qualifier.LoggedIn;
import Bank_Tutorial_Weld_Server.qualifier.Logging;

/* PROTECTED REGION END */

/**
 */

@Named("login")
@SessionScoped
@Stateful(name = "LoginAction")
@Logging
public class LoginAction implements Serializable {
	
	// -- generated attribute, constant + association declarations ----------
	
	@Inject
	private Credentials credentials;
	
	@Inject
	@BankDatabase
	private EntityManager database;
	
	@Inject
	private HttpSession session;
	
	private User user;
	
	// -- generated constructors --------------------------------------------
	/**
	 * constructor for class '<em><b>LoginAction</b></em>'
	 */
	public LoginAction() {
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	@Named
	@Produces
	@LoggedIn
	public User getCurrentUser() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271580746901_653093_600) ENABLED START */

		//		if (user != null)
		//			System.out.println(user.toString());
		return user;
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 * @return	
	 */
	
	public boolean isLoggedIn() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271580715700_370941_597) ENABLED START */
		//System.out.println("isLoggedIn: " + (user != null));
		return user != null;
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	public void register() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271580692768_187520_593) ENABLED START */

		User user = (User) database.find(User.class, credentials.getUsername());
		if (user != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User already registered: " + user.getUsername() + ", at date: " + user.getInsertDate()));
		} else {
			user = new User();
			user.setUsername(credentials.getUsername());
			user.setInsertDate(new Date());
			user.setPassword(credentials.getPassword());
			
			database.persist(user);
			database.flush();
			
			System.out.println("Register user: " + credentials.getUsername());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome, " + credentials.getUsername()));
		}
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	public void login() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271580674064_135420_591) ENABLED START */

		// erstmal alten User ausloggen
		//logout();
		
		user = (User) database.find(User.class, credentials.getUsername());
		if (user == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User does not exist: " + credentials.getUsername()));
			return;
		}
		
		if (!user.getPassword().equals(credentials.getPassword())) {
			user = null;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Wrong Password for user, " + credentials.getUsername()));
			return;
		}
		System.out.println("User logged in: " + credentials.getUsername());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Welcome, " + credentials.getUsername()));
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	public void logout() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1271580710303_543356_595) ENABLED START */
		user = null;
		session.invalidate();
		//sessionManager.invalidate();
		
		/* PROTECTED REGION END */
	}
	
	/**
	 * method stub for further implementation
	 */
	
	@Remove
	public void remove() {
		/* PROTECTED REGION ID(java.implementation._16_0_1_41601a3_1290784723496_493431_387) ENABLED START */
		System.out.println(" --------------- LoginAction removed!!!");
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._16_0_1_41601a3_1267462849139_226690_457) ENABLED START */
	private static final long serialVersionUID = 1L;
	
	@PrePassivate
	public void passivate() {
		System.out.println(" --------------- passivate");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println(" --------------- Session ist abgelaufen!!!");
	}
	
	/* PROTECTED REGION END */

}
