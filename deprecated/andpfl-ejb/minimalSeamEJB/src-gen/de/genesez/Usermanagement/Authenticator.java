package de.genesez.Usermanagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.JndiName;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.security.Identity;

@Stateless
@Name("authenticator")
@Scope(ScopeType.SESSION)
//@JndiName("authenticator")
public class Authenticator implements AuthenticatorLocal {
	
	@In
	Identity identity;
	
	@In(create=true)
	@Out
	User user;
	
	@PersistenceContext
	private EntityManager manager;
	
	public boolean authenticate() 
	{
		user.setUsername(identity.getUsername());
		user.setPassword(identity.getPassword());
		manager.persist(user);
		manager.flush();
		user = null;
		user = manager.find(User.class, identity.getUsername());
		return true;
	}

}
