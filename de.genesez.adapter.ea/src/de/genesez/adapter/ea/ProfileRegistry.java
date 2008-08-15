package de.genesez.adapter.ea;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

public class ProfileRegistry {

	private static final Log log = LogFactory.getLog(ProfileRegistry.class);
	public static final ProfileRegistry instance = new ProfileRegistry(); 
	
	private Map<String, Profile> profiles = new HashMap<String, Profile>();
	private Map<String, Stereotype> stereotypes = new HashMap<String, Stereotype>();

	private ProfileRegistry() {
		// nothing to do here ;-)
	}
	
	/**
	 * Register a profile
	 * @param id	The profiles name
	 * @param e		The UML2 profile
	 */
	public void register(String name, Profile p) {
		log.debug("Register Profile " + name);
		this.profiles.put(name, p);
		
		for (Element e: p.allOwnedElements()) {
			if (e instanceof Stereotype) {
				Stereotype s = (Stereotype) e;
				log.debug("Found stereotype " + s.getName());
				this.stereotypes.put(s.getName(), s);
			}
		}
	}
	
	/**
	 * Returns all profiles as a set
	 * @return
	 */
	public Set<Profile> getProfiles() {
		Set<Profile> _profiles = new HashSet<Profile>();
		for (String s: this.profiles.keySet()) {
			log.debug("Found profile " + s);
			_profiles.add(this.profiles.get(s));
		}
		return _profiles;
	}
	
	/**
	 * Returns a stereotype via its name
	 * @param name	The name of the stereotype
	 * @return		The stereotype
	 */
	public Stereotype getStereotype(String name) {
		log.debug("Searching for stereotype " + name);
		Stereotype s = null;
		
		if (this.stereotypes.containsKey(name)) {
			s = this.stereotypes.get(name);
		}
		
		return s;
	}
}
