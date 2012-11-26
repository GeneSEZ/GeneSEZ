package contacts.facade;


public class AnonymousFacade {

	private static AnonymousFacade theInstance;

	/**
	 * typische Zugriffsmethode auf das Singleton-Objekt
	 * 
	 * @return Referenz auf die einzige Instanz der AnonymousFacade
	 */
	public static synchronized AnonymousFacade getInstance() {
		if (theInstance == null) {
			theInstance = new AnonymousFacade();
		}
		return theInstance;
	}

	/**
	 * mache Konstruktor des Singletons nur zugreifbar innerhalb seiner Klasse
	 */
	private AnonymousFacade() {

	}

	/**
	 * An der Applikation anmelden
	 * 
	 * @return gueltiges Fassadenobjekt 
	 */
	public FacadeBase login() {
		return new UserFacade();
	}
}
