package de.genesez.Usermanagement;

import javax.ejb.Local;

@Local
public interface AuthenticatorLocal {
	public boolean authenticate();
}
