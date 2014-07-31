package org.genesez.adapter.ea;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_12d203c6_1328866942146_682558_2063) 
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Collect imported UML profiles and provide access to Stereotypes
 * 
 * The ProfileRegistry is a singleton which provides the possibility to
 * register a loaded UML profile under its name.
 * All stereotypes of the registered profiles can be accessed via their names.
 * 
 * Note: at the moment all the stereotypes must have unique names
 * 
 * @author gerbe
 * @author christian
 */

public class ProfileRegistry {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(ProfileRegistry.class);
	
	public static final ProfileRegistry INSTANCE = new ProfileRegistry();
	
	// -- generated constructors --------------------------------------------
	/**
	 * Constructor for class '<em><b>ProfileRegistry</b></em>'.
	 */
	
	private ProfileRegistry() {
		/* PROTECTED REGION ID(java.constructor._17_0_5_12d203c6_1363354598163_164014_2506) ENABLED START */
		// :)
		/* PROTECTED REGION END */
	}
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Register a profile
	 * @param	name	The profiles name
	 * @param	p	The UML2 profile
	 */
	
	public void register(String name, Profile p) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363354609817_156087_2509) ENABLED START */
		LOG.debug("Register Profile " + name);
		this.profiles.put(name, p);
		for (Element e : p.allOwnedElements()) {
			if (e instanceof Stereotype) {
				Stereotype s = (Stereotype) e;
				LOG.debug("Found stereotype " + s.getName());
				this.stereotypes.put(s.getName(), s);
			}
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns all profiles as a set
	 * @return	
	 */
	
	public java.util.Set<Profile> getProfiles() {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363354647261_214569_2517) ENABLED START */
		return new HashSet<Profile>(this.profiles.values());
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns a stereotype via its name
	 * @param	name	The name of the stereotype
	 * @return	
	 */
	
	public Stereotype getStereotype(String name) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363354697734_844268_2523) ENABLED START */
		LOG.debug("Searching for stereotype " + name);
		Stereotype s = null;
		
		if (this.stereotypes.containsKey(name)) {
			s = this.stereotypes.get(name);
		}
		
		return s;
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code of other cartridges --------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_12d203c6_1328866942146_682558_2063) ENABLED START */
	private Map<String, Profile> profiles = new HashMap<String, Profile>();
	private Map<String, Stereotype> stereotypes = new HashMap<String, Stereotype>();
	/* PROTECTED REGION END */
	
}
