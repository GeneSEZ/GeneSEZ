package contacts.facade;

import architecture.hibernate.DaoHibernate;
import architecture.hibernate.DbHibernate;

import org.genesez.examples.java.jsf.addressbook.domain.Address;
import org.genesez.examples.java.jsf.addressbook.domain.Organisation;
import org.genesez.examples.java.jsf.addressbook.domain.Person;
import org.genesez.examples.java.jsf.addressbook.domain.Phone;

public class FacadeBase {

	/**
	 * Datenbankanbindung
	 */
	private DbHibernate dbConnection = new DbHibernate();

	/**
	 * Datenbank-Zugriffsobjekt
	 */
	protected DaoHibernate<Person> personDao;
	protected DaoHibernate<Organisation> organisationDao;
	protected DaoHibernate<Phone> phoneDao;
	protected DaoHibernate<Address> addressDao;

	/**
	 * Legt neues Fassadenobjekt an. Wird sinnvollerweise nur aus der
	 * AnonymousFacade aufgerufen
	 * 
	 * @param user
	 */
	protected FacadeBase() {
		personDao = new DaoHibernate<Person>(Person.class, dbConnection);
		organisationDao = new DaoHibernate<Organisation>(Organisation.class, dbConnection);
		phoneDao = new DaoHibernate<Phone>(Phone.class, dbConnection);
		addressDao = new DaoHibernate<Address>(Address.class, dbConnection);
	}

}
