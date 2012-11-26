package contacts.jsf;

import contacts.facade.AnonymousFacade;
import contacts.facade.FacadeBase;

public class LoginBean {

	private FacadeBase facade = AnonymousFacade.getInstance().login();

	public LoginBean() {
	}

	public FacadeBase getFacade() {
		return facade;
	}
	
	public String home() {
		return "home";
	}

}
